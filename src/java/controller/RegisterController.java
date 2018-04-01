/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import utils.InputValidator;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 50 //50MB
)
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        String username = "";
        String password = "";
        String passwordcf = "";
        PrintWriter out = response.getWriter();
        boolean isMultipart = FileUpload.isMultipartContent(request);
        log("content-length: " + request.getContentLength());
        log("method: " + request.getMethod());
        log("character encoding: " + request.getCharacterEncoding());
        String name = "name";
        if (isMultipart) {
            log("is multipart");
            DiskFileUpload upload = new DiskFileUpload();
            List items = null;
            try {
                items = upload.parseRequest(request);
                log("items: " + items.toString());
            } catch (FileUploadException ex) {
                log("failed to parse request", ex);
            }
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                //check if the current item is a form field or an upload file
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    if (fieldName.equals("username")) {
                        username = item.getString();
                        name = username;
                    } else if (fieldName.equals("password")) {
                        password = item.getString();
                    } else if (fieldName.equals("passwordcf")) {
                        passwordcf = item.getString();
                    }
                } else {
                    //must be an uploaded file, save to disk
                    File fullFile = new File(item.getName());
                    System.out.println("item.name:" + item.getName());
                    String realPath = getServletContext().getRealPath("/");
                    System.out.println("real context path in register controller: " + realPath);

                    File savedFile = null;
                    File prevFile;
                    prevFile = new File(realPath, "" + name + ".png");
                    if (prevFile.exists()) {
                        if (prevFile.delete()) {
                            log("old file deleted " + prevFile.getPath());
                        } else {
                            log("error deleting " + prevFile.getPath());
                        }
                    }
                    prevFile = new File(realPath, "" + name + ".jpeg");
                    if (prevFile.exists()) {
                        if (prevFile.delete()) {
                            log("old file deleted " + prevFile.getPath());
                        } else {
                            log("error deleting " + prevFile.getPath());
                        }
                    }
                    prevFile = new File(realPath, "" + name + ".jpg");
                    if (prevFile.exists()) {
                        if (prevFile.delete()) {
                            log("old file deleted " + prevFile.getPath());
                        } else {
                            log("error deleting " + prevFile.getPath());
                        }
                    }

                    if (item.getName().contains("png")) {
                        savedFile = new File(realPath, "" + name + ".png");
                    } else if (item.getName().contains("jpg")) {
                        savedFile = new File(realPath, "" + name + ".jpg");
                    } else if (item.getName().contains("jpeg")) {
                        savedFile = new File(realPath, "" + name + ".jpeg");
                    } else {
                        request.setAttribute("error", "Vui lòng chỉ tải lên file .png, .jpeg hoặc .jpg");
                        doGet(request, response);
                    }
                    try {
                        item.write(savedFile);
                    } catch (Exception ex) {
                        Logger.getLogger(ChangeAvatarController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    log("new images saved successfully to " + savedFile.getPath());
                }
            }
        }
        UserDAO userDB = new UserDAO();
        String checkUsername = InputValidator.isUsernameValid(username);
        String checkPassword = InputValidator.isPasswordValid(password);
        if (!checkUsername.equals("") || !checkPassword.equals("")) {
            request.setAttribute("wrongUsername", checkUsername);
            request.setAttribute("wrongPassword", checkPassword);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (userDB.isUsernameExisted(username.trim())) {
            request.setAttribute("wrongUsername", "Tên đăng nhập đã tồn tại!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (!passwordcf.equals(password)) {
            request.setAttribute("wrongPasswordCf", "Mật khẩu không khớp");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            if (userDB.insert(u)) {
                //set avatar path 
                System.out.println("real context path: " + getServletContext().getRealPath("/"));
                String realPath = getServletContext().getRealPath("/");
                String jpg = realPath + u.getUsername() + ".jpg";
                File fileJpg = new File(jpg);
                String png = realPath + u.getUsername() + ".png";
                File filePng = new File(png);
                String jpeg = realPath + u.getUsername() + ".jpeg";
                File fileJpeg = new File(jpeg);
                if (fileJpg.exists()) {
                    request.getSession().setAttribute("avatarPath", u.getUsername() + ".jpg");
                } else if (filePng.exists()) {
                    request.getSession().setAttribute("avatarPath", u.getUsername() + ".png");
                } else if (fileJpeg.exists()) {
                    request.getSession().setAttribute("avatarPath", u.getUsername() + ".jpeg");
                } else {
                    request.getSession().setAttribute("avatarPath", "img/logo.jpg");
                }
                //set user attribute
                if (u.getUserID() == 0) {
                    int userID = new UserDAO().getUserID(u.getUsername());
                    u.setUserID(userID);
                }
                request.getSession().setAttribute("user", u);
                response.sendRedirect("home2.jsp");
            } else {
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emsnguyen
 */
//@WebServlet(name = "BaseController", urlPatterns = {"/BaseController"})
public abstract class BaseAuthenticationController extends HttpServlet {

    protected boolean authenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return request.getSession().getAttribute("user") != null;
    }
    protected abstract void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    protected abstract void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticate(request, response)) {
            handleGet(request, response);
        } else {
            response.sendRedirect("login");
        }
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
        if (authenticate(request, response)) {
            handlePost(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

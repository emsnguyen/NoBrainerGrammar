<%-- 
    Document   : signin
    Created on : Mar 4, 2018, 10:39:25 AM
    Author     : emsnguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <script>
            function submitForm() {
                document.getElementById("frm1").submit();
            }
        </script>
    </head>
    <body>
        <div class="div">
            <img src="image/logo.jpg" class="img"/>
        <div>
            <p id="p">Đăng Kí</p>
        </div>
            <form action="signup" id="frm1" method="POST">
                <p>
                    Tên đăng nhập: <input type="text" name="username" value="${param['username']}"/>
                    <span>${invalidUsername}</span>
                </p>
                <p>
                    Mật khẩu: <input type="password" name="password" value="${param['password']}"/>
                    <span>${invalidPassword}</span>
                </p>
                <p>
                    Nick name: <input type="text" name="nickname" value="${param['nickname']}" />
                    <span>${invalidNickname}</span>
                </p>
                <p>Ngày sinh: <input type="date" name="birthDate" required="true" value="${param['birthDate']}"/>
                    <span>${invalidBirthDate}</span>
                </p>
                <p>Giới tính: 
                    Nam &nbsp;<input type="radio" name="gender" value="Male" 
                                     <c:if test="${param['gender'] eq 'Male'}">
                                         checked="checked"
                                     </c:if>
                                     />
                    Nữ  &nbsp;<input type="radio" name="gender" value="Female" 
                                     <c:if test="${param['gender'] eq 'Female'}">
                                         checked="checked"
                                     </c:if>
                                     />
                    <span>${invalidGender}</span>
                </p>
                <p>
                    Nghề nghiệp: <input type="text" name="work" value="${param['work']}"/>
                    <span>${invalidWork}</span>
                </p>
                <p>
                    Địa chỉ: <input type="text" name="address" value="${param['address']}" />
                    <span>${invalidAddress}</span>
                </p>
                <p>Ảnh đại diện
                    <img src="image/anhdaidien.jpg" style="width: 100px; height: 50px" alt="anh dai dien"/>
                    <button>Tải ảnh lên</button></p>
            </form>
            <button onclick="submitForm()">Đăng Kí</button><br> <br>
	</div>
        </div>
    </body>
</html>
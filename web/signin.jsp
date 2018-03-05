<%-- 
    Document   : signin
    Created on : Mar 4, 2018, 10:39:25 AM
    Author     : emsnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <script>
            function submitForm() {
                document.getElementById("signInForm").submit();
            }
        </script>
    </head>
    <body>
        <div class="div">
            <img src="image/logo.jpg" class="img"/>
        <div>
            <p id="p">Đăng Nhập</p>
        </div>
            <form action="signin" id="signInForm" method="POST">
                <p>Tên đăng nhập: <input type="text" name="username" value="${param['username']}">
                    <span>${invalidUsername}</span>
                </p> 
                <p>Mật Khẩu: <input type="password" name="password" value="${param['password']}">
                    <span>${invalidPassword}</span>
                </p>
            </form>
            <button onclick="submitForm()">Đăng Nhập</button><br> <br>
	</div>
        </div>
    </body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset="UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/trangchu1.css">
    <title>Teender</title>
    <script>
        function redirectSignIn() {
            window.location.href="signin";
        }
        function redirectSignUp() {
            window.location.href="signup";
        }
    </script>
</head>
<body>
    <div class="d1">
    <table class="table1">
        <tr>
        <img src="image/logo.jpg" alt="" style="width: 20%"/>
        <th>
            <button type="button" class="btn btn-success" id="but1" onclick="redirectSignIn()">
                Sign In</button>
        </th>
        <th>
            <button type="button" class="btn btn-danger" id="but2" onclick="redirectSignUp()">
                Sign Up
            </button></th>
        </tr>
    </table>

    </div>
    <div>
	<hr WIDTH="75%" COLOR="#FF0000" SIZE="5px" class="hr"> 
    </div>
    <footer>
	<a href="#">Liên hệ</a><br>
	<a href="#">Feedback</a><br>
	<a href="#">FAQ</a><br>
        <a href="#">Người dùng nói gì về Teender</a><br>
	<a href="#">Chính sách bảo mật</a>	
    </footer>
</body>
</html>
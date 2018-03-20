<%-- 
    Document   : changepassword
    Created on : Mar 18, 2018, 10:40:51 AM
    Author     : emsnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .form-style {
                max-width: 450px;
                font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
            }
            .form-style label{
                display:block;
                margin-bottom: 10px;
            }
            .form-style span{
                /*float: left;*/
                width: 500px;
                color: #F072A9;
                font-weight: bold;
                font-size: 13px;
                text-shadow: 1px 1px 1px #fff;
            }
            .form-style input[type='password']{
                border-radius: 3px;
                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                border: 1px solid #FFC2DC;
                outline: none;
                color: #F072A9;
                padding: 5px 8px 5px 8px;
                box-shadow: inset 1px 1px 4px #FFD5E7;
                -moz-box-shadow: inset 1px 1px 4px #FFD5E7;
                -webkit-box-shadow: inset 1px 1px 4px #FFD5E7;
                background: #FFEFF6;
                width:50%;
            }
            .form-style input[type=submit]{
                background: #EB3B88;
                border: 1px solid #C94A81;
                padding: 5px 15px 5px 15px;
                color: #FFCBE2;
                box-shadow: inset -1px -1px 3px #FF62A7;
                -moz-box-shadow: inset -1px -1px 3px #FF62A7;
                -webkit-box-shadow: inset -1px -1px 3px #FF62A7;
                border-radius: 3px;
                border-radius: 3px;
                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;    
                font-weight: bold;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Đổi mật khẩu cho người dùng ${username}</h1>
        <form action="changepassword" method="POST" class="form-style">
            <label for="oldpw">Nhập lại mật khẩu cũ: </label>
            <input type="password" name="oldpassword" id="oldpw" required="true"/>
            <br/>
            <p><span>${oldPasswordUnmatch}</span></p>
            
            <label for="newpw">Nhập mật khẩu mới: </label>
            <input type="password" name="newpassword" id="newpw" required="true"/>
            <br/>
            <p><span>${invalidNewPassword}</span></p>
            <label for="newpwcf">Xác nhận lại mật khẩu mới</label>
            <input type="password" name="newpasswordcf" id="newpwcf" required="true"/>
            <br/>
            <p><span>${newPasswordUnmatch}</span></p>
            <br/>
            <input type="submit" value="Đổi mật khẩu"/>
        </form>
    </center>
        
    </body>
</html>

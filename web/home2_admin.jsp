<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>No brainer grammar</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/home2.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <c:if test="${user.rollID ne 1}">
            <c:redirect url="accessdenied.html"/>
        </c:if>
        <main>
            <header class="w3-container w3-red w3-center" style="padding:128px 16px">
                <h1 class='elegantshadow'>Chào mừng admin trở lại với <br/>
                    <b>No-brainer Grammar</b>
                </h1>
                <p class="w3-xlarge">Admin có các quyền sau: <br/><br/>
                <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
                        onclick="{window.location.href='listquestion';}">Xem danh sách câu hỏi</button>
                <br/>
                <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
                        onclick="{window.location.href='addquestion';}">Thêm câu hỏi</button>
                <br/>
                <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
                        onclick="{window.location.href='listquestion';}">Xóa câu hỏi</button>
                <br/>
                <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
                        onclick="{window.location.href='listquestion';}">Cập nhật câu hỏi</button>
                <br/>
                <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
                        onclick="{window.location.href='changepassword';}">Đổi mật khẩu</button>
                <br/>
                <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
                        onclick="{window.location.href='logout';}">Thoát</button>
                <br/>
                </p>
            </header>
            <center>
                
                
            </center>
        </main>
        <footer class="footer-basic-centered">
                <p class="footer-company-motto">Spare your brain for something more significant</p>

                <p class="footer-links">
                        <a href="#">Trang chủ</a>
                        ·
                        <a href="terms.jsp">Điều khoản</a>
                        ·
                        <a href="aboutus.jsp">Về chúng tôi</a>
                        ·
                        <a href="faq.jsp">Các câu hỏi thường gặp</a>
                </p>

                <p class="footer-company-name">No Brainer Grammar &copy; 2018</p>

        </footer>
    </body>
</html>

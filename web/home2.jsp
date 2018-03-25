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
        <main>
            <header class="w3-container w3-red w3-center" style="padding:128px 16px">
                <h1 class="w3-margin w3-jumbo">Chào mừng ${user.username} đến với</h1>
                <h1 class='elegantshadow'>No-brainer Grammar</h1>
                <p class="w3-xlarge">Chọn <em>Học</em> để bắt đầu học <br/>
                    Chọn <em>Xếp hạng</em> để xem xếp hạng <br/>
                    Chọn <em>Thoát</em> để đăng xuất <br/>
                    Cảm ơn và chúc bạn có thời gian thật tuyệt với chúng tôi! <br/>
                </p>
                <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
                        onclick="{window.location.href='study';}">Bắt đầu thôi!</button>
            </header>
            <center>
                <input class="button" type="submit" onclick="{window.location.href='study';}" value="Học"/>
                <input class="button" type="submit" onclick="{window.location.href='viewrank';}" value="Xem xếp hạng"/>
                <input class="button" type="submit" onclick="{window.location.href='logout';}" value="Thoát"/>
            </center>
        </main>
        <footer class="footer-basic-centered">
                <p class="footer-company-motto">Spare your brain for something more significant</p>

                <p class="footer-links">
                        <a href="home.jsp">Trang chủ</a>
                        ·
                        <a href="terms.html">Điều khoản</a>
                        ·
                        <a href="aboutus.html">Về chúng tôi</a>
                        ·
                        <a href="faqs.html">Các câu hỏi thường gặp</a>
                </p>

                <p class="footer-company-name">No Brainer Grammar &copy; 2018</p>

        </footer>
    </body>
</html>

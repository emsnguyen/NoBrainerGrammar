<%-- 
    Document   : viewrank
    Created on : Mar 14, 2018, 11:36:56 PM
    Author     : emsnguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>No brainer grammar</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <h1 class='elegantshadow'>Xếp hạng trên <br/>No-brainer Grammar</h1>
        </nav>
        <main>
            <table id='rank-table' border='1px solid black'>
                <c:forEach items='${users}' var='u' varStatus="loop">
                    <tr>
                        <td 
                            <c:if test='${u.username eq sessionScope.user.username}'>
                                style='color: green'
                            </c:if>
                            >
                            <h3>${loop.index+1} : ${u.username} </h3>
                        </td>
                        <td style='background-color: #4CAF50; color: white; text-align: center'>
                            <h3>${u.point}</h3>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
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

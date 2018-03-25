<%-- 
    Document   : thankyou
    Created on : Mar 22, 2018, 1:30:50 AM
    Author     : emsnguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <div class="jumbotron text-xs-center">
            <h1 class="display-3">Cảm ơn bạn đã gửi tin nhắn đến Teender</h1>
            <p class="lead"><strong>Chúng tôi sẽ xem xét và gửi lại phản hồi cho bạn sớm nhất có thể</p>
            <hr>
            <p class="lead">
            <c:choose>
                <c:when test="${user ne null}">
                    <a class="btn btn-primary btn-sm" href="home2.jsp" role="button">Trở về trang chủ</a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-primary btn-sm" href="index.html" role="button">Trở về trang chủ</a>
                </c:otherwise>
            </c:choose>
              
            </p>
        </div>
    </center>
    </body>
</html>

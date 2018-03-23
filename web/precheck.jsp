<%-- 
    Document   : precheck
    Created on : Mar 23, 2018, 11:39:49 AM
    Author     : emsnguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${user eq null}">
            <c:redirect url="accessdenied.html"/>
        </c:if>
    </body>
</html>

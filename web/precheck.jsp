<%-- 
    Document   : precheck
<<<<<<< HEAD
    Created on : Mar 20, 2018, 3:59:57 PM
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
        <c:if test="${user.rollID ne 1}">
=======
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
>>>>>>> origin/master
            <c:redirect url="accessdenied.html"/>
        </c:if>
    </body>
</html>

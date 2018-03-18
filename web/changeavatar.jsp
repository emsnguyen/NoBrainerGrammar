<%-- 
    Document   : changeavatar
    Created on : Mar 18, 2018, 10:41:19 AM
    Author     : emsnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Chọn ảnh đại diện mới cho bạn</h1>
        
        <form action="changeavatar" method="PƠST" enctype="multipart/form-data">
            <label for="avatar">Tải ảnh mới lên</label>
            <input type="file" name="avatar" 
                   id="avatar"
                   accept=".png, .jpg, .jpeg"/>
            <button>Cập nhật</button>       
        </form>
    </body>
</html>

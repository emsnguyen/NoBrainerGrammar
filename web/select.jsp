<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <link href="css/select.css" rel="stylesheet" type="text/css"/>
    <title>Chọn chế độ học</title>
</head>
<body>
    <audio controls loop='true' style='display:none;' id='player'>
        <source src="audio/NoiNayCoAnhPianoCover-AnCoong-4780660.mp3" type="audio/mpeg">
        Your browser does not support the <code>audio</code> tag.
    </audio>
    <button onclick="document.getElementById('player').muted=!document.getElementById('player').muted">
                        Bật/ Tắt nhạc nền</button>
<h2>Chọn độ khó và loại câu hỏi</h2>
<div class="container">
  <form action="study">
    <div class="sel sel--black-panther">
        <label for="category">Loại ngữ pháp</label>
        <select name="categoryID" id="category">
          <c:forEach var='c' items="${cats}">
                <option value="${c.categoryID}">${c.categoryName}</option>
            </c:forEach>
        </select>
        <br/>
    </div>
<br/>
<br/>
<hr class="rule">


<div class="sel sel--superman">
    <label for="level">Độ khó</label>
        <select name="level" id="level">
            <option value="1">Dễ</option>
            <option value="2">Trung bình</option>
            <option value="3">Khó</option>
        </select>
      <br/>
</div>
<br/>
<input type="submit" value="Lưu lại"/>
</form>
</div>
<!--<script src="js/select.js" type="text/javascript"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
</body>
</html>

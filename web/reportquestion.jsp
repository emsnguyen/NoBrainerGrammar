<%-- 
    Document   : sendfeedback
    Created on : Mar 19, 2018, 12:06:26 PM
    Author     : emsnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .form-style-6{
                font: 95% Arial, Helvetica, sans-serif;
                max-width: 400px;
                margin: 10px auto;
                padding: 16px;
                background: #F7F7F7;
            }
            .form-style-6 h1{
                background: #43D1AF;
                padding: 20px 0;
                font-size: 140%;
                font-weight: 300;
                text-align: center;
                color: #fff;
                margin: -16px -16px 16px -16px;
            }
            .form-style-6 input[type="text"],
            .form-style-6 input[type="date"],
            .form-style-6 input[type="datetime"],
            .form-style-6 input[type="email"],
            .form-style-6 input[type="number"],
            .form-style-6 input[type="search"],
            .form-style-6 input[type="time"],
            .form-style-6 input[type="url"],
            .form-style-6 textarea,
            .form-style-6 select 
            {
                -webkit-transition: all 0.30s ease-in-out;
                -moz-transition: all 0.30s ease-in-out;
                -ms-transition: all 0.30s ease-in-out;
                -o-transition: all 0.30s ease-in-out;
                outline: none;
                box-sizing: border-box;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                width: 100%;
                background: #fff;
                margin-bottom: 4%;
                border: 1px solid #ccc;
                padding: 3%;
                color: #555;
                font: 95% Arial, Helvetica, sans-serif;
            }
            .form-style-6 input[type="text"]:focus,
            .form-style-6 input[type="date"]:focus,
            .form-style-6 input[type="datetime"]:focus,
            .form-style-6 input[type="email"]:focus,
            .form-style-6 input[type="number"]:focus,
            .form-style-6 input[type="search"]:focus,
            .form-style-6 input[type="time"]:focus,
            .form-style-6 input[type="url"]:focus,
            .form-style-6 textarea:focus,
            .form-style-6 select:focus
            {
                box-shadow: 0 0 5px #43D1AF;
                padding: 3%;
                border: 1px solid #43D1AF;
            }

            .form-style-6 input[type="submit"],
            .form-style-6 input[type="button"]{
                box-sizing: border-box;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                width: 100%;
                padding: 3%;
                background: #43D1AF;
                border-bottom: 2px solid #30C29E;
                border-top-style: none;
                border-right-style: none;
                border-left-style: none;    
                color: #fff;
            }
            .form-style-6 input[type="submit"]:hover,
            .form-style-6 input[type="button"]:hover{
                background: #2EBC99;
            }
            </style>
    </head>
    <body>
        <c:if test="${user.rollID eq 1 || quiz eq ''}">
            <c:redirect url="accessdenied.html"/>
        </c:if>
        <div class="form-style-6">
        <h1>Báo cáo câu hỏi</h1>
        <form action="reportquestion" method="POST">
            <input type="hidden" value="${user.userID}" name="userID" />
            <input type="hidden" value="${quiz.quizID}" name="quizID"/>
            <input type="text" name="username" placeholder="tên người dùng" required/>
            Câu hỏi bạn đang báo cáo:
            <h3>${quiz.content}</h3>
            Đáp án đúng:
            <h3>${answer.correctOpt}</h3>
            <textarea name="problem" placeholder="Bạn phát hiện vấn đề gì với câu hỏi này"
                      rows="20" cols="50" required></textarea>
            <input type="submit" value="Gửi" />
        </form>
</div>
    </body>
</html>
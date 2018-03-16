<%-- 
    Document   : study
    Created on : Mar 10, 2018, 10:53:48 PM
    Author     : emsnguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
        <link href="css/study.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    <body>
        <audio controls loop style="display:none" id='player'>
            <source src="audio/MatTroiCuaEmPianoCover-AnCoong-5405112.mp3" type="audio/mpeg">
            Your browser does not support the <code>audio</code> tag.
        </audio>
        
    <h1 class='elegantshadow'>No-brainer Grammar</h1>

    <form class="form" action="study" method="POST">
        <center>
            <table class="topnav"> 
                <tr>
                    <td>
                        <button onclick="document.getElementById('player').muted=
                                    !document.getElementById('player').muted">
                            Bật/ Tắt nhạc nền</button>
                    </td>
                    <td>
                        <button>
                            <a href="home2.jsp">Về trang chủ</a>
                        </button>
                    </td>
                    <td>
                        <div class="dropdown">
                            <button class="dropbtn">
                                ${user.username}
                            </button>
                            <div class="dropdown-content">
                                <a href="#">Đổi mật khẩu</a>
                                <a href="#">Đổi loại câu hỏi</a>
                                <a href="#">Đổi độ khó</a>
                                <a href="#">Thoát</a>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan>
                        <div class="point">
                            <span>Điểm của bạn: </span>
                            <div id="point">
                                 ${user.point}
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
            <input id='userpoint' type='hidden' name='userpoint' value='${user.point}'>
            <input id='isCorrect' type='hidden' name='isCorrect'>
            <input name="quizID" value="${quiz.quizID}" type='hidden'/>
            <table>
            <tr>
                <td>
                    <div class="left-arrow arrow">
                        <img src="images/Actions-arrow-left-icon.png" alt=""
                             onclick="submitForm();"/>
                    </div>
                </td>
                <td>
                    <div class="timer">Thời gian còn lại: 
                        <div id="timer"></div>
                    </div>
                    <div class="notif">
                        <div id="notif"></div>
                    </div>
                    <div class="question-answer">
                        <div>
                            <h1 class="question" onmouseover="readAnswer(this.innerHTML);">
                                ${quiz.content}</h1>
                        </div>
                        <div class="answer">
                            <div class="answerA" onmouseover="readAnswer(this.innerHTML);"
                                 onclick='checkUserChoice(this);'>
                                ${answer.optA}
                            </div>
                            <div class="answerB" onmouseover="readAnswer(this.innerHTML);"
                                 onclick='checkUserChoice(this);'>
                                ${answer.optB}
                            </div>
                            <div class="answerC" onmouseover="readAnswer(this.innerHTML);"
                                 onclick='checkUserChoice(this);'>
                                ${answer.optC}
                            </div>
                            <div class="answerD" onmouseover="readAnswer(this.innerHTML);"
                                 onclick='checkUserChoice(this);'>
                                ${answer.optD}
                            </div>
                        </div>
                        <div class='correctAnswer' style="display: none; text-align: center;">
                            ${answer.correctOpt}
                        </div>
                    </div>
                </td>
                <td>
                    <div class="right-arrow arrow">
                        <img src="images/Actions-arrow-right-icon.png" alt=""
                             onclick="submitForm();"/>
                    </div>
                </td>
            </tr> 
        </table>
        <h4 class="explanation" style='display: none;'>
            ${answer.explanation}
        </h4>
        <a href="reportquestion">Báo cáo câu hỏi có vấn đề</a>
    </form><!--end of wrapper class-->
    </center>
    <script src="js/study.js" type="text/javascript"></script>
    </body>
</html>
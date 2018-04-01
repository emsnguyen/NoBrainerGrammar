<%-- 
    Document   : listquestion
    Created on : Mar 16, 2018, 9:32:06 PM
    Author     : emsnguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #quizzes {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #quizzes td, #quizzes th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #quizzes tr:nth-child(even){background-color: #f2f2f2;}

            #quizzes tr:hover {background-color: #ddd;}

            #quizzes th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }
            #search {
                font-size: 20px;
                margin-bottom: 10px;
            }
        </style>
</head>
<body>
    <%@include file="precheck_admin.jsp" %>
    <center>
        <h1>Danh sách các câu hỏi</h1>
        <form action="listquestion" method="POST" id="form">
            <div class="sel sel--black-panther">
                <label for="category">Loại ngữ pháp</label>
                <select name="cateID" id="category" onchange="submitForm();">
                    <option value="-1">---Tất cả---</option>
                    <c:forEach var='c' items="${cats}">
                        <option value="${c.categoryID}"
                                <c:if test="${param.cateID eq c.categoryID}">
                                    selected="selected"
                                </c:if>
                                >${c.categoryName}</option>
                    </c:forEach>
                </select>
                <br/>
            </div>
        <br/>
        <br/>
        <div class="sel sel--superman">
            <label for="level">Độ khó</label>
                <select name="level" id="level" onchange="submitForm();">
                    <option value="-1">---Tất cả---</option>
                    <option value="1"
                            <c:if test="${param['level'] eq '1'}">
                                selected="selected"
                            </c:if>
                            >Dễ</option>
                    <option value="2"
                            <c:if test="${param.level eq '2'}">
                                selected="selected"
                            </c:if>
                            >Trung bình</option>
                    <option value="3"
                            <c:if test="${param.level eq '3'}">
                                selected="selected"
                            </c:if>
                            >Khó</option>
                </select>
            <br/>
        </div>
        <br/>
        <input type="text" 
               placeholder="tìm kiếm" 
               id="search"
               name="search"
               onchange="submitForm();"/>
        </form>
    </center>
    <table id="quizzes">
        <tr>
            <th>Câu hỏi</th>
            <th>Thể loại</th>
            <th>Độ khó</th>
        </tr>
        <c:forEach items="${quizzes}" var="q">
            <tr>
                <td>
                    <a href="quizdetails?quizID=${q.quizID}">${q.content}</a>
                </td>
                <td>${q.category.categoryName}</td>
                <c:choose>
                    <c:when test="${q.level == 1}">
                        <td>Dễ</td>
                    </c:when>
                    <c:when test="${q.level == 2}">
                        <td>Trung bình</td>
                    </c:when>
                    <c:otherwise>
                        <td>Khó</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
    </body>
    <script src="js/listquestion.js" type="text/javascript"></script>
</html>

<%-- 
    Document   : quizdetails
    Created on : Mar 16, 2018, 10:41:57 PM
    Author     : emsnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function submitForm() {
                document.getElementByID('form').submit();
            }
        </script>
        <style>
            .quizzes {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            .quizzes td, .quizzes th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            .quizzes tr:nth-child(even){background-color: #f2f2f2;}

            .quizzes tr:hover {background-color: #ddd;}

            .quizzes th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }
            button, input[type='submit'] {
                display: inline-block;
                padding: 5px 15px;
                cursor: pointer;
                text-align: center;
                text-decoration: none;
                outline: none;
                color: #fff;
                background-color: #4CAF50;
                border: none;
                border-radius: 15px;
                box-shadow: 0 9px #999;
                font-size: 30px;
                margin: 10px;
            }

            button:hover {background-color: #3e8e41}

            button:active {
              background-color: #3e8e41;
              box-shadow: 0 5px #666;
              transform: translateY(4px);
            }
            .question {
                font-size: 30px;
            }
            input[type='text'], textarea {
                padding: 10px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1>Chi tiết câu hỏi</h1>
        <form action="updatequestion" id="form">
            <table class="quizzes">
                <tr>
                    <th>
                        <input type="text" value="${quiz.content}" size="180"
                               name="quiz"/>
                    </th>
                </tr>
            </table>
            <input type="hidden" value="${quiz.quizID}" name="quizID">
            <input type="hidden" value="${quiz.level}" name="level">
            <input type="hidden" value="${quiz.category.categoryID}" name="cateID">
            <table class="quizzes">
                <tr>
                    <td>
                        <input type="text" value="${answer.optA}" name="optA"/>
                    </td>
                    <td>
                        <input type="text" value="${answer.optB}" name="optB"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="${answer.optC}" name="optC"/>
                    </td>
                    <td>
                        <input type="text" value="${answer.optD}" name="optD"/>
                    </td>
                </tr>
            </table>
            <table class="quizzes">
                <tr>
                    <th>Đáp án đúng: 
                        <input type="text" value="${answer.correctOpt}" name="correctOpt"/>
                    </th>
                </tr>
                <tr>
                    <td>Giải thích: 
                        <textarea rows="10" cols="80" name="explanation">
                            ${answer.explanation}
                        </textarea> 
                    </td>
                </tr>
            </table>
        <input type='submit' value='Cập nhật câu hỏi'/>
        </form>
        <button onclick="{window.location.href='addquestion';}">
            Thêm câu hỏi mới
        </button>
        <button onclick="{window.location.href='deletequestion?quizID=${quiz.quizID}';}">
            Xóa câu hỏi
        </button>
        <button onclick="{window.location.href='listquestion';}">
            Quay lại danh sách câu hỏi
        </button>
    </body>
</html>

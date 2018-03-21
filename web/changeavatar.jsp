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
        <link href="https://fonts.googleapis.com/css?family=Oleo+Script:400,700" rel="stylesheet">
   	<link href="https://fonts.googleapis.com/css?family=Teko:400,700" rel="stylesheet">
   	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <style>
            #contact{

            font-size: 50px;
            padding-top: 60px;
            width: 100%;
            width: 100vw;
            height: 550px;
            background: #3a6186; /* fallback for old browsers */
            background: -webkit-linear-gradient(to left, #3a6186 , #89253e); /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to left, #3a6186 , #89253e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            color : #fff;    
            text-align: center;
            }
            .error {
                font-size: 30px;
                font-style: italic;
            }
            .button {
                display: inline-block;
                padding: 15px 25px;
                cursor: pointer;
                text-align: center;
                text-decoration: none;
                outline: none;
                color: #fff;
                background-color: #4CAF50;
                border: none;
                border-radius: 15px;
                box-shadow: 0 9px #999;
                font-size: 1em;
                margin: 10px;
            }

            .button:hover {background-color: #3e8e41}

            .button:active {
              background-color: #3e8e41;
              box-shadow: 0 5px #666;
              transform: translateY(4px);
            }
            
        </style>
    </head>
    <body>
        
        <section id="contact">
            <h1>Chọn ảnh đại diện mới cho '<em>${user.username}</em>'</h1>
            <form action="changeavatar" method="POST" enctype="multipart/form-data">
                <div class="col-md-6 form-line">
                        <div class="form-group">
                            <input type="hidden" value="${user.userID}" name="userID"/>
                            <br/>
                        </div>	
                        <div class="form-group">
                            <label for="avatar">Tải ảnh mới lên</label>
                            <br/>
                            <input type="file" name="avatar" 
                                   id="avatar"
                                   accept=".png, .jpg, .jpeg"/>
                        </div>
                        <div class="form-group">
                            <span class="error">${error}<br/></span>
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Cập nhật" class="button"/>
                        </div>
                </div>
            </form>
        </section>
        
    </body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/login.css">
</head>

<body>
<h1 class='elegantshadow'>No-brainer Grammar</h1>  
<div class="container">
  <div class="info">
    <h1>Đăng nhập</h1><span>Adapted with <i class="fa fa-heart"></i> by <a href="#">Emily Nguyen</a></span>
  </div>
</div>
<div class="form">
  <form class="login-form" action="login" method="POST">
      <input type="text" placeholder="tên đăng nhập" name="username" required="true"/>
    <input type="password" placeholder="mật khẩu" name="password" required="true"/>
    <p>${error}</p>
    <button>Đăng nhập</button>
    <p class="message">Bạn chưa có tài khoản?<a href="signup">Tạo tài khoản mới ngay</a></p>
  </form>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/login.js"></script>
</body>

</html>

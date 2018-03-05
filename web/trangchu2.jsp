<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/trangchu2.css" rel="stylesheet" type="text/css"/>	 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div class="d1">
	<table class="table">
            <tr>
                <th><img src="image/logo.jpg" class="img"></th>
                <th class="dropdown">
                    <span>
                        <img src="https://thenextweb.com/files/2010/12/winner1.png" alt=""/>
                        <span>Welcome ${sessionScope.nickname}</span>
                    </span>
                    <div class="dropdown-content" id="div1">
                        <a href="">Trang cá nhân</a><br>
                        <a href="">Cài đặt tài khoản</a><br>
                        <a href="signout">Đăng xuất</a>
                    </div>
                </th>
            </tr>
	</table>
</div>

<ul>
  <li><a class="active" href="#home">Trang chủ</a></li>
  <li><a href="#news">Tìm bạn</a></li>
  <li><a href="#contact">Tin nhắn</a></li>
  <li><input type="text" name="search" placeholder="Search.." class="se"></li>
</ul>
</body>
</html>
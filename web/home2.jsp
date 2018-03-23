<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body {font-family: "Lato", sans-serif}
    .mySlides {display: none}
    img {
        width: 100%;
    }
    #avatar {
        max-height: 50px;
        max-width: 50px;
    }
</style>
<body>
<%@include file="precheck.jsp" %>
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="index.html" class="w3-bar-item w3-button w3-padding-large">Trang chủ</a>
    <a href="choose" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Tìm bạn</a>
    <a href="chat" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Tin nhắn</a>
    <a href="#sendfeedback" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Liên hệ</a>
    <img src="${avatarPath}" 
                id="avatar"
                alt="avatar"
                style="max-width:50px; max-height: 50px;"
                />
    <div class="w3-dropdown-hover w3-hide-small">
        <button class="w3-padding-large w3-button" title="More">
            ${user.username}
        </button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="changepassword" class="w3-bar-item w3-button">Đổi mật khẩu</a>
        <a href="changeavatar" class="w3-bar-item w3-button">Đổi avatar</a>
        <a href="setting" class="w3-bar-item w3-button">Cài đặt tài khoản</a>
        <a href="logout" class="w3-bar-item w3-button">Thoát</a>
      </div>
    </div>
    <a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a>
  </div>
</div>
<!--
 Navbar on small screens 
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <a href="#band" class="w3-bar-item w3-button w3-padding-large">BAND</a>
  <a href="#tour" class="w3-bar-item w3-button w3-padding-large">TOUR</a>
  <a href="#contact" class="w3-bar-item w3-button w3-padding-large">CONTACT</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">MERCH</a>
</div>-->

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px; min-height: 300px">

  <!-- Automatic Slideshow Images -->
  <div class="mySlides w3-display-container w3-center">
    <!--<img src="/w3images/la.jpg" style="width:100%">-->
    <img src="img/1.jpg" alt=""/>
    <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
      <h3>Giao diện đẹp, đơn giản, thân thiện</h3>
      <p><b>Dễ thao tác và sử dụng</b></p>   
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
      <img src="img/1.jpg" alt=""/>
    <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
      <h3>Bảo mật tuyệt đối</h3>
      <p><b>Mang lại trải nghiệm tuyệt vời cho người dùng với chính sách bảo mật mạnh mẽ</b></p>    
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
    <img src="img/6.jpg" alt=""/>
    <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
      <h3>Cơ sở dữ liệu lớn</h3>
      <p><b>Dễ dàng tìm kiếm và kết bạn muôn phương</b></p>    
    </div>
  </div>

  <!-- The Band Section -->
  <div class="w3-container w3-content w3-center w3-padding-64" style="max-width:800px" id="band">
    <h2 class="w3-wide">TEENDER</h2>
    <p class="w3-opacity"><i>Hẹn hò chưa bao giờ dễ dàng đến thế</i></p>
    <p class="w3-justify">Với giao diện đơn giản và thân thiện, Teender đang dần chiếm được cảm tình từ người dùng...</p>
    <div class="w3-row w3-padding-32">
      <div class="w3-third">
        <p>Sơn</p>
        <img src="img/team/1.png" class="w3-round w3-margin-bottom" alt="Random Name" style="width:60%">
      </div>
      <div class="w3-third">
        <p>Ngọc Anh</p>
        <img src="img/team/2.png" class="w3-round w3-margin-bottom" alt="Random Name" style="width:60%">
      </div>
      <div class="w3-third">
        <p>Phong</p>
        <img src="img/team/3.png" class="w3-round" alt="Random Name" style="width:60%">
      </div>
    </div>
  </div>

  <!-- The Tour Section -->
  <div class="w3-black" id="tour">
    <div class="w3-container w3-content w3-padding-64" style="max-width:800px">
      <h2 class="w3-wide w3-center">Người dùng nói gì về Teender</h2>
      <!--<p class="w3-opacity w3-center"><i>Remember to book your tickets!</i></p><br>-->

      <div class="w3-row-padding w3-padding-32" style="margin:0 -16px">
        <div class="w3-third w3-margin-bottom">
          <img src="img/team/team3.jpg" alt="New York" style="width:100%" class="w3-hover-opacity">
          <div class="w3-container w3-white">
            <p><b>Anna</b></p>
            <p class="w3-opacity">Fri 27 Nov 2016</p>
            <p>Teender is the best</p>
          </div>
        </div>
        <div class="w3-third w3-margin-bottom">
          <img src="img/team/team1.jpg" alt="Paris" style="width:100%" class="w3-hover-opacity">
          <div class="w3-container w3-white">
            <p><b>Emily</b></p>
            <p class="w3-opacity">Sat 28 Nov 2016</p>
            <p>Teender is the best</p>
          </div>
        </div>
        <div class="w3-third w3-margin-bottom">
          <img src="img/team/team2.jpg" alt="San Francisco" style="width:100%" class="w3-hover-opacity">
          <div class="w3-container w3-white">
            <p><b>Ivy</b></p>
            <p class="w3-opacity">Sun 29 Nov 2016</p>
            <p>Teender is the best</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- The Contact Section -->
  <div class="w3-container w3-content w3-padding-64" style="max-width:800px" id="contact">
    <h2 class="w3-wide w3-center">Gửi feedback về dịch vụ của chúng tôi</h2>
    <!--<p class="w3-opacity w3-center"><i>Fan? Drop a note!</i></p>-->
    <div class="w3-row w3-padding-32">
      <div class="w3-col m6 w3-large w3-margin-bottom">
        <i class="fa fa-map-marker" style="width:30px"></i> Đại học FPT, Hòa Lạc<br>
        <i class="fa fa-phone" style="width:30px"></i> Phone: +00 151515<br>
        <i class="fa fa-envelope" style="width:30px"> </i> Email: fpt.edu@gmail.com<br>
      </div>
      <div class="w3-col m6">
        <form action="thankyou.jsp" id="sendfeedback">
          <div class="w3-row-padding" style="margin:0 -16px 8px -16px">
            <div class="w3-half">
              <input class="w3-input w3-border" type="text" placeholder="Name" required name="Tên">
            </div>
            <div class="w3-half">
              <input class="w3-input w3-border" type="text" placeholder="Email" required name="Email">
            </div>
          </div>
            <textarea class="w3-input w3-border" placeholder="Tin nhắn" required name="Message"
                      rows="5">
            </textarea>
          <button class="w3-button w3-black w3-section w3-right" type="submit">GỬI</button>
        </form>
      </div>
    </div>
  </div>
  
<!-- End Page Content -->

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">
  <i class="fa fa-facebook-official w3-hover-opacity"></i>
  <!--<i class="fa fa-instagram w3-hover-opacity"></i>-->
  <!--<i class="fa fa-snapchat w3-hover-opacity"></i>-->
  <i class="fa fa-pinterest-p w3-hover-opacity"></i>
  <i class="fa fa-twitter w3-hover-opacity"></i>
  <i class="fa fa-linkedin w3-hover-opacity"></i>
  <p class="w3-medium">Adapted by <a href="#" target="_blank">Teender Team</a> with <3 </p>
</footer>

<script>
// Automatic Slideshow - change image every 4 seconds
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 4000);    
}

// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

// When the user clicks anywhere outside of the modal, close it
var modal = document.getElementById('ticketModal');
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>

</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Quên mật khẩu</title>
  <!-- CORE CSS-->
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">

<style type="text/css">
html,
body {
    height: 100%;
}
html {
    display: table;
    margin: auto;
}
body {
    display: table-cell;
    vertical-align: middle;
}
.margin {
  margin: 0 !important;
}
input[type=submit] {

color: #fff;
background: #016ABC;

border: 1px solid #eee;

border-radius: 10px;

box-shadow: 5px 5px 5px #eee;

text-shadow:none;
margin: auto;
width: 50%;
/*border: 3px solid green;*/
padding: 10px;

}

input[type=submit]:hover {
    background: #557cd6;
    color: #fff;
    border: 1px solid #eee;
    border-radius: 20px;
    box-shadow: 5px 5px 5px #eee;
    text-shadow:none;

}
</style>
  
</head>

<body class="yellow">


  <div id="login-page" class="row">
    <div class="col s12 z-depth-6 card-panel">
        <form class="login-form" action="forgotpassword" method="POST">
        <div class="row">
          <div class="input-field col s12 center">
            <img src="img/logo.jpg" alt="" class="responsive-img valign profile-image-login">
            <p class="center login-form-text">Nhập email để lấy lại mật khẩu</p>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-social-person-outline prefix"></i>
            <input class="validate" id="email" type="email" required>
            <label for="email" data-error="wrong" data-success="right" class="center-align">Email</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
              <center>
                  <input type="submit" class="btn col s12" value="Khôi phục mật khẩu"/>
              </center>
            
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6 m6 l6">
              <p class="margin medium-small"><a href="register">Tạo tài khoản mới!</a></p>
          </div>
          <div class="input-field col s6 m6 l6">
              <p class="margin right-align medium-small"><a href="login">Đăng nhập</a></p>
          </div>          
        </div>

      </form>
    </div>
  </div>


  <center>
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<!-- Post Page - Responsive -->
<ins class="adsbygoogle"
     style="display:inline-block;width:300px;height:250px"
     data-ad-client="ca-pub-5104998679826243"
     data-ad-slot="3470684978"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>
</center>



  <!-- ================================================
    Scripts
    ================================================ -->

  <!-- jQuery Library -->
 <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!--materialize js-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>


<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-27820211-3', 'auto');
  ga('send', 'pageview');

</script><script src="//load.sumome.com/" data-sumo-site-id="1cf2c3d548b156a57050bff06ee37284c67d0884b086bebd8e957ca1c34e99a1" async="async"></script>
   <footer class="page-footer">
          <div class="footer-copyright">
            <div class="container">
                <center>
                    © 2018 Teender
                </center>
            </div>
          </div>
  </footer>
</body>

</html>
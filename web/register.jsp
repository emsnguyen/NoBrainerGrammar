<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Đăng kí</title>
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

background: #B9DFFF;

color: #fff;

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

background: #016ABC;

color: #fff;

border: 1px solid #eee;

border-radius: 20px;

box-shadow: 5px 5px 5px #eee;

text-shadow:none;

}
</style>
  
</head>

<body class="blue">


  <div id="login-page" class="row">
    <div class="col s12 z-depth-6 card-panel">
        <form class="login-form" action="register" method="POST">
        <div class="row">
          <div class="input-field col s12 center">
            <img src="img/logo.jpg" alt="" class="responsive-img valign profile-image-login">
            <p class="center login-form-text">Đăng kí</p>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-social-person-outline prefix"></i>
            <input id="username" type="text" class="validate" name="username" required>
            <label for="username" class="center-align">Tên đăng nhập</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password" type="password" class="validate" required>
            <label for="password">Mật khẩu</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password-again" type="password" required>
            <label for="password-again">Nhập lại mật khẩu</label>
          </div>
        </div>
        
        <div class="row margin">
          <div class="input-field col s12">
              
            <!--<i class="mdi-action-lock-outline prefix"></i>-->
            <label for="avatar">Chọn ảnh đại diện để tải lên</label><br/><br/>
            <input id="avatar" type="file" accept=".jpeg, .jpg, .png" name="avatar" required>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
              <center>
                  <input type="submit" value='Đăng kí'/>
              </center>
              
          </div>
        </div>
        <div class="row">
<!--          <div class="input-field col s12">
              <center>
                  <input type="submit" class="btn waves-effect waves-light col s12" value="Đăng kí"/>
              </center>
          </div>-->
          <div class="input-field col s12">
            <p class="margin center medium-small sign-up">Đã có tài khoản? <a href="login">Đăng nhập</a></p>
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
              <div class="container" style="text-align: center">
            ©2018 Teender
            <!--<a class="grey-text text-lighten-4 right" href="http://w3lessons.info">Karthikeyan K</a>-->
            </div>
          </div>
  </footer>
</body>

</html>
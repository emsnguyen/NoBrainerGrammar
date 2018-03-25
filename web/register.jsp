<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Đăng kí</title>
  <!-- CORE CSS-->
  <link href="css/register.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
  <style>
    #preview {
        max-width: 100px;
        max-height: 100px;
    }
  </style>
</head>

<body class="blue">


  <div id="login-page" class="row">
    <div class="col s12 z-depth-6 card-panel">
        <form class="login-form" action="register" method="POST" enctype="multipart/form-data">
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
            <p>${wrongUsername}</p>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password" type="password" class="validate" required name="password">
            <label for="password">Mật khẩu</label>
            <p>${wrongPassword}</p>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password-again" type="password" required name="passwordcf">
            <label for="password-again">Nhập lại mật khẩu</label>
            <p>${wrongPasswordCf}</p>
          </div>
        </div>
        
        <div class="row margin">
          <div class="input-field col s12">
              
            <!--<i class="mdi-action-lock-outline prefix"></i>-->
            <label for="avatar">Chọn ảnh đại diện để tải lên</label><br/><br/>
            <input id="avatar" type="file" accept=".jpeg, .jpg, .png" name="avatar" required
                   onchange="loadFile(event);">
            <img id="preview"/>
            <script>
                var loadFile = function(event) {
                    var output = document.getElementById("preview");
                    output.src = URL.createObjectURL(event.target.files[0]);
                }
            </script>
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
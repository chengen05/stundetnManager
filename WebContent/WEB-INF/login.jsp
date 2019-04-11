<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="res/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="res/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="res/css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="res/google-font/fonts.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="res/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="res/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="res/img/favicon.ico">
</head>
<body>
 <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <!-- Logo & Information Panel-->
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>Dashboard</h1>
                  </div>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                </div>
              </div>
            </div>
            <!-- Form Panel    -->
            <div class="col-lg-6 bg-white">
              <div class="form d-flex align-items-center">
                <div class="content">
                
                 <s:form  action="loginJudge" theme="simple">
                    <div class="form-group">
                      <input id="login-username" type="text" name="userInfo.account" required data-msg="Please enter your username" class="input-material">
                      <label for="login-username" class="label-material">User Name</label>
                    </div>
                    <div class="form-group">
                      <input id="login-password" type="password" name="userInfo.password" required data-msg="Please enter your password" class="input-material">
                      <label for="login-password" class="label-material">Password</label>
                    </div><input type="submit" class="btn btn-primary" value="login">
                    <!-- This should be submit button but I replaced it with <a> for demo purposes-->
                  </s:form><a href="#" class="forgot-pass">Forgot Password?</a><br><small>Do not have an account? </small><a href="register.html" class="signup">Signup</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="copyrights text-center">
        <p>Design by <a href="#" class="external">Bootstrapious</a>
          <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
        </p>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="res/vendor/jquery/jquery.min.js"></script>
    <script src="res/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="res/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="res/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="res/vendor/chart.js/Chart.min.js"></script>
    <script src="res/vendor/jquery-validation/jquery.validate.min.js"></script>
    <!-- Main File-->
    <script src="res/js/front.js"></script>
  </body>
</html>
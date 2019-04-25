<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学工助手</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet" href="res/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet" href="public/font-awesome/css/font-awesome.css">
<!-- Google fonts - Poppins -->
 <link rel="stylesheet" href="res/google-font/fonts.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="res/css/style.default.css" id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->

 <!-- 网页图标-->
<link rel="shortcut icon" href="res/img/favicon.ico">

</head>
<body>
      <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!--导航条标题-->
              <div class="navbar-header">
                <!-- 系统图标 --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><span>学工 </span><strong>助手</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- 导航条菜单 -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- 信息图标显示-->
                <li class="nav-item dropdown"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link">
                	<i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">12</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                 <!-- 下拉子项 -->
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-envelope bg-green"></i>You have 6 new messages </div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                        <!-- 下拉最下那条数据 -->
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>view all notifications</strong></a></li>
                  </ul>
                </li>

                <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" 
                aria-haspopup="true" aria-expanded="false" class="nav-link">
                <i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="res/img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Ashley Wood</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>Read all messages   </strong></a></li>
                  </ul>
                </li>
                <!-- 退出按钮    -->
                <li class="nav-item"><a href="exit.action" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- 侧栏 -->
        <nav class="side-navbar">
          <!-- 侧栏头部-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="${userinfo.photo}" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">${userinfo.name}</h1>
              
              <p>${userRole.roleName}</p>
            </div>
          </div>
          <!-- 侧栏菜单--><span class="heading">Main</span>
           <ul class="list-unstyled">
                    <li>
                  <a href="#"> <i class="fa fa-home"></i>Home</a></li>
                  
                    <s:iterator value="#session.systemList" id="systemOperate">
                    	<!-- 一级菜单 -->
                    		<li><a href="${systemOperate.linkUrl}"> <i class="${systemOperate.icon}"></i>${systemOperate.name}</a></li>
					  </s:iterator>
					  
                   <s:iterator value="#session.sysItemdropItem" id="sysMenu">
                   		 <li><a href="#exampledropdownDropdown${sysMenu.systemId}" aria-expanded="false" data-toggle="collapse"> <i class="${sysMenu.icon}"></i>${sysMenu.linkName}</a></li>
                    		  	<!-- 二级菜单的一级显示 -->
                    		  <ul id="exampledropdownDropdown${sysMenu.systemId}" class="collapse list-unstyled ">
								<s:iterator value="#sysMenu.systemOperate" id="item">
								<li><a href="${item.linkUrl}">${item.name}</a></li>
								</s:iterator>
							</ul>
                   </s:iterator>
          </ul>
        </nav>
        <div class="content-inner">
          <!--主面板-->
          <section class="feeds no-padding-top">
            <div class="container-fluid">
              <div class="row">
                <!-- Trending Articles-->
                <div class="col-lg-6">
                  <div class="articles card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard4" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                      <h2 class="h3">最新动态 </h2>
                      <div class="badge badge-rounded bg-green">0       </div>
                    </div>
                    <div class="card-body no-padding">
                     <!--  
                      <div class="item d-flex align-items-center">
                     
                        <div class="text"><a href="#">
                            <h3 class="h5">动态信息</h3></a><small> </small></div>
                      </div>
                      
                     -->
                    </div>
                  </div>
                </div>
                <!-- Check List -->
                <div class="col-lg-6">
                  <div class="checklist card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard5" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">           
                      <h2 class="h3">请假动态 </h2>
                    </div>
                    <div class="card-body no-padding">
                     
                    
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <!-- Updates Section                                                -->
          <section class="feeds no-padding-top">
            <div class="container-fluid">
              <div class="row">
                <!-- Trending Articles-->
                <div class="col-lg-6">
                  <div class="articles card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard4" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                      <h2 class="h3">通知通告 </h2>
                      <div class="badge badge-rounded bg-green">      </div>
                    </div>
                    <div class="card-body no-padding">
                     <!--  
                      <div class="item d-flex align-items-center">
                     
                        <div class="text"><a href="#">
                            <h3 class="h5">动态信息</h3></a><small> </small></div>
                      </div>
                      
                     -->
                    </div>
                  </div>
                </div>
                <!-- Check List -->
                <div class="col-lg-6">
                  <div class="checklist card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard5" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">           
                      <h2 class="h3">会议信息 </h2>
                    </div>
                    <div class="card-body no-padding">
                     
                    
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <!-- Page Footer-->
          <footer class="main-footer">
            <div class="container-fluid">
              <div class="row">
                <div class="col-sm-6">
                  <p>学工助手&copy; 2019</p>
                </div>
                <div class="col-sm-6 text-right">
                  <p>Design by 四川文理学院-智能制造</p>
                  <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </div>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="res/vendor/jquery/jquery.min.js"></script>
    <script src="res/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="res/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="res/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="res/vendor/chart.js/Chart.min.js"></script>
    <script src="res/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="res/js/charts-home.js"></script>
    <!-- Main File-->
    <script src="res/js/front.js"></script>
  </body>
</html>
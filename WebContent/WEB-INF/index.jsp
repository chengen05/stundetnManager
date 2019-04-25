<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学工助手|主页</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="public/font-awesome/css/font-awesome.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="css/ionicons.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="css/AdminLTE.css">
    <link rel="stylesheet" href="css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="css/bootstrap-table.css">
    <link rel="stylesheet" href="css/jquery.treegrid.css">
    <link rel="stylesheet" href="css/myCommon.css">
    <link rel="stylesheet" href="css/bootstrap-tab.css">
    <!-- jQuery 3 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="js/bootstrap.js"></script>
    <!-- AdminLTE App -->
    <script src="js/adminlte.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-table-zh-CN.js"></script>
    <script src="js/bootstrap-table-treegrid.js"></script>
    <script src="js/jquery.treegrid.min.js"></script>
    <script src="js/bootstrap-tab.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="#" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">学</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">学工助手</span>
        </a>

        <!-- 头部菜单 -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only"></span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- 请假提醒-->
                    <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" onclick="javascript:a();">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">${SureNum}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">有${SureNum}条学生请假未处理</li>
                            <li class="footer"><a href="insQJ.jsp" target="container" onclick="$('div#container').load(this.href);return false;" >
                            	查看信息</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#">${userName} </a></li>
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                         <li class="dropdown">
                    	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    	</a>
                    	<ul class="dropdown-menu dropdown-user">
                        <li><a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-user fa-fw"></i>修改密码</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="exit.jsp"><i class="fa fa-sign-out fa-fw"></i>退出登录</a>
                        </li>
                    	</ul>
               			 </li>
                    		</li>
                    
                </ul>
            </div>
        </nav>
    </header>
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
        <!-- 登录个人信息 -->
			<div class="user-panel">
        <div class="pull-left image">
          <img src="${userinfo.photo}" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${userinfo.name}</p>
          <a href="#"><i class="fa fa-circle text-success"></i>${userRole.roleName}</a>
        </div>
      </div>
            <!-- 左边导航 -->
              <ul class="sidebar-menu" data-widget="tree">
        <li class="header"><span class="fa-lg">目录</span></li>
        <!--生成菜单项-->
        <!-- 一级菜单 -->		 
         <s:iterator value="#session.systemList" id="systemOperate">
        <li><a href="${systemOperate.linkUrl}"><i class="${systemOperate.icon}"></i> <span>${systemOperate.name}</span></a></li>
         </s:iterator>
       
        <s:iterator value="#session.sysItemdropItem" id="sysMenu">
           <li class="treeview">
         	 <a href="#">
            <i class="${sysMenu.icon}"></i>
            <span>${sysMenu.linkName}</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          		<s:iterator value="#sysMenu.systemOperate" id="item">
					<li><a href="${item.linkUrl}">${item.name}</a></li>
				</s:iterator>
          </ul>
        </li>
       </s:iterator>
      </ul>   
        </section>
        <!-- /.sidebar -->
    </aside>

    <div class="content-wrapper">
     
        <!-- 主内容 -->
        <section class="content container-fluid">
            <div id="container">
				
            </div>

        </section>
       
    </div>
	  <!-- 脚部 -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Design by</b> 四川文理学院-智能制造
    </div>
    <strong>Copyright &copy; 2019</strong> 学工助手
    
  </footer>
</div>
</body>
</html>
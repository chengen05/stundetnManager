<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学院部门|学工助手</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="res/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="res/vendor/bootstrap/css/bootstrap-table.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="res/vendor/font-awesome/css/font-awesome.min.css">

    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="res/google-font/fonts.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="res/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="res/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="res/img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="search-box">
            <button class="dismiss"><i class="icon-close"></i></button>
            <form id="searchForm" action="#" role="search">
              <input type="search" placeholder="What are you looking for..." class="form-control">
            </form>
          </div>
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><span>学工 </span><strong>助手</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>IN</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Search-->
                <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li>
                <!-- Notifications-->
                <li class="nav-item dropdown"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link">
                	<i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">1</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                  
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>view all notifications</strong></a></li>
                  </ul>
                </li>
                <!-- Messages                        -->
                <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" 
                aria-haspopup="true" aria-expanded="false" class="nav-link">
                <i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">1</span></a>
                  
                </li>
                <!-- Logout    -->
                <li class="nav-item"><a href="exit.action" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="${userinfo.photo}" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">${userinfo.name}</h1>
              
              <p>${userRole.roleName}</p>
            </div>
          </div>
          <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
          <ul class="list-unstyled">
                    <li>
                  <a href="#"> <i class="icon-home"></i>Home</a></li>
                  
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
          <!-- Page Header-->
          <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">学校部门</h2>
            </div>
          </header>
          <section class="tables">   
            <div class="container-fluid">
              <div class="row">
                <div class="col-lg-12">
                  <div class="card">
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">信息</h3>
                    </div>
                    <div class="row">
				<div class="col-md-12">
				<input id="btnAdd" class="btn btn-primary" type="button" value="添加部门" data-toggle="modal" data-target="#addmodal">
				<input id="btnUpdate" class="btn btn btn-info" type="button" value="修改部门" data-toggle="modal" data-target="#updatemodal" onclick="getSelectedRow()">
				<input id="btnDel" class="btn btn-danger" type="button" value="删除部门" onclick="delinfo()">
				</div>
				</div>
                    <div class="card-body">
                      <div class="table-responsive">
                        <table data-toggle="table" id="table" data-pagination="true" name="table">
                          <thead>
                          	<tr>
                          		<th data-field="state" data-checkbox="true"></th>
                          		<th data-field="id">序号</th>
                          		<th data-field="name">部门名称</th>
                          		<th data-field="departtype">部门类型</th>
                          		<th data-field="linkMan">联系人</th>
                          		<th data-field="office">办公室地址</th>
                          		<th data-field="phoneNum">联系电话</th>
                          	</tr>
                          </thead>
                     
                        </table>
                      </div>
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
                  <p>Your company &copy; 2017-2019</p>
                </div>
                <div class="col-sm-6 text-right">
                  <p>Design by Bootstrapious.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                  <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </div>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <!-- 添加部门信息模态框 -->
     <div class="modal fade" id="addmodal" >
    <div class="modal-dialog">
      <div class="modal-content">
   		<form action="addSchoolDepart.action" method="post">
        <!-- 模态框头部 --> 
        <div class="modal-header">
          <h4 class="modal-title">部门信息</h4>
        </div>
   
        <!-- 模态框主体 -->
        <div class="modal-body">
				
				<div class="row clearfix">
				<div class="col-md-12 column">
				
				<div class="form-group">
					 <label for="departmentName">部门名称</label>
					 <input type="text" class="form-control" id="departName" name="schooldepart.departmentName"  />
				</div>
				<div class="form-group">
					 <label for="departmentType">部门类型</label>
					 <input type="text" class="form-control" id="departType" name="schooldepart.departmentType"  />
				</div>
				<div class="form-group">
					 <label for="departmentLinkman">联系人</label>
					 <input type="text" class="form-control" id="linkMan" name="schooldepart.departmentLinkman"/>
				</div>
				<div class="form-group">
					 <label for="officeAddress">办公室地址</label>
					 <input type="text" class="form-control" id="officeaddress" name="schooldepart.officeAddress" />
				</div>
				<div class="form-group">
					 <label for="phoneNumber">联系电话</label>
					 <input type="text" class="form-control" id="phoneNum" name="schooldepart.phoneNumber" />
					 
				</div>
				
		</div>
	</div>  
        </div>
        
        <!-- 模态框底部 -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
          
          	 <button type="submit"class="btn btn-default" >添加</button>
          	
        </div>
    </form>  
      </div>
    </div>
  </div>
  	<!-- 修改信息 -->
  	  <div class="modal fade" id="updatemodal" >
    <div class="modal-dialog">
      <div class="modal-content">
   		<form action="upSchoolDepart.action" method="post">
        <!-- 模态框头部 --> 
        <div class="modal-header">
          <h4 class="modal-title">部门信息</h4>
        </div>
   	
        <!-- 模态框主体 -->
        <div class="modal-body">
				
				<div class="row clearfix">
				<div class="col-md-12 column">
				<input type="hidden" id="id" name="schooldepart.schoolDepartId">
				<div class="form-group">
					 <label for="departmentName">部门名称</label>
					 <input type="text" class="form-control" id="updepartName" name="schooldepart.departmentName"  />
				</div>
				<div class="form-group">
					 <label for="departmentType">部门类型</label>
					 <input type="text" class="form-control" id="updepartType" name="schooldepart.departmentType"  />
				</div>
				<div class="form-group">
					 <label for="departmentLinkman">联系人</label>
					 <input type="text" class="form-control" id="uplinkMan" name="schooldepart.departmentLinkman"/>
				</div>
				<div class="form-group">
					 <label for="officeAddress">办公室地址</label>
					 <input type="text" class="form-control" id="upofficeaddress" name="schooldepart.officeAddress" />
				</div>
				<div class="form-group">
					 <label for="phoneNumber">联系电话</label>
					 <input type="text" class="form-control" id="upphoneNum" name="schooldepart.phoneNumber" />
					 
				</div>
				
		</div>
	</div>  
        </div>
        
        <!-- 模态框底部 -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
          
          	 <button type="submit"class="btn btn-default" >修改</button>
          	
        </div>
    </form>  
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
     <script src="res/vendor/bootstrap/js/bootstrap-table.js"></script>
    <!-- Main File-->
    <script src="res/js/front.js"></script>
    <script type="text/javascript">	
    $(function () {
        $.ajax({
            type: "GET",
            url: "shooldepartmentjson.action",
            dataType: "json",
            success: function (msg) {
                $("#table").bootstrapTable('load', msg);
            },
            error: function () {
                //alert("错误");
            }
        });
    });
    
  
    function getSelectedRow() 
    		{
    			var a = $('table').bootstrapTable('getSelections');
    			//向模态框传值
    			if(a.length==1){
    				$('#id').val(a[0].id);
    				$('#updepartName').val(a[0].name);
    				$('#updepartType').val(a[0].departtype);
    				$('#upofficeaddress').val(a[0].office);
    				$('#uplinkMan').val(a[0].linkMan);
    		 		$('#upphoneNum').val(a[0].phoneNum);
    		 		
    			}
    			else
    				{
    					alert("请选择一行数据");
    				}
    		//返回选中行所有数据
    		}
    function delinfo()
    	{
    		var a = $('table').bootstrapTable('getSelections');
    		if(a.length==1)
    			{
    				if(confirm("确认要删除吗?"))
    					{
    						$.ajax({
    							type:"GET",
    							url:"delSchoolDepart.action",
    							data:"departId="+a[0].id,
    							success:function(data)
    							{
    								window.location.href='schooldepartmentCode.action';
    							}
    						})
    					}
    			}
    		else
    			{
    				alert("请选择一行数据");
    			}
    	}
  
    </script>
  </body>
</html>
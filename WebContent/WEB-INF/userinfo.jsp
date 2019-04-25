<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学工助手|用户管理</title>
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
				
				<div class="box">
            		<div class="box-header">
             		 	<h3 class="box-title">用户信息管理</h3>
           			 </div>
            <!-- 盒子内容 -->
            <div class="box-body">
            <!-- 按钮 -->
            <div class="toolbar">
                <a href="#" class="btn" role="button" data-toggle="modal" data-target="#addmodal">
                    <span class=" glyphicon glyphicon-plus" aria-hidden="true" style="margin-right: 5px"></span>excel导入用户信息</a>
                  <a href="#" class="btn" role="button" data-toggle="modal" data-target="#addonemodal">
                    <span class=" glyphicon glyphicon-plus" aria-hidden="true" style="margin-right: 5px"></span>插入用户</a>
                <a id="btnEdit" href="#" class="btn" role="button" onclick="updatainfo()">
                    <span class=" glyphicon glyphicon-edit" aria-hidden="true" style="margin-right: 5px"></span>修改</a>
                <a href="#" class="btn" role="button" onclick="delinfo()">
                    <span class="glyphicon glyphicon-minus" aria-hidden="true" style="margin-right: 5px"></span>删 除</a>
            </div>
              <table id="userinfotable" class="table table-bordered table-striped">
             	
              </table>
              </div>

            </div>
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

<!-- 导入部门信息模态框 -->
    <div class="modal fade" id="addmodal" >
    <div class="modal-dialog">
      <div class="modal-content">
   		<form action="addSchoolDepart.action" method="post">
        <!-- 模态框头部 --> 
        <div class="modal-header">
          <h4 class="modal-title">导入信息</h4>
        </div>
   
        <!-- 模态框主体 -->
        <div class="modal-body">
				
				<div class="row clearfix">
				<div class="col-md-12 column">
				
				<div class="form-group">
					 <label for="departmentName">上传文件</label>
					 <s:file name="filename"/>
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
    
    <!-- 插入用户信息模态框 -->
    <div class="modal fade" id="addonemodal" >
    <div class="modal-dialog">
      <div class="modal-content">
   		<form action="insertuserinfo.action" method="post">
        <!-- 模态框头部 --> 
        <div class="modal-header">
          <h4 class="modal-title">用户信息添加</h4>
        </div>
   
        <!-- 模态框主体 -->
        <div class="modal-body">
				
				<div class="row clearfix">
				<div class="col-md-12 column">
				
				<div class="form-group">
					 <label for="account">登录账号</label>
					 <input type="text" class="form-control" id="loginAccount" name="userInfo.account"  />
				</div>
				<div class="form-group">
					 <label for="password">登录密码</label>
					<input type="text" class="form-control" id="loginPassword" name="userInfo.password"  />
				</div>	
				<div class="form-group">
					 <label for="name">姓名</label>
					<input type="text" class="form-control" id="userName" name="userInfo.name"  />
				</div>
				<div class="form-group">
					 <label for="sex">性别</label>
					<s:select id="sex" value="usersex" list="#{'男':'男','女':'女' }" class="form-control"
					name="userInfo.gender" ></s:select>
				</div>	
				<div class="form-group">
					 <label for="roleid">角色</label>
					<s:select id="roleid" list="#request.roleinfo" class="form-control"
					name="userInfo.userRoleId" listKey="id" listValue="name"></s:select>
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
    
     
    <!-- 修改用户信息模态框 -->
    <div class="modal fade" id="updatemodal" >
    <div class="modal-dialog">
      <div class="modal-content">
   		<form action="updateuserinfo.action" method="post">
        <!-- 模态框头部 --> 
        <div class="modal-header">
          <h4 class="modal-title">用户信息修改</h4>
        </div>
   
        <!-- 模态框主体 -->
        <div class="modal-body">
				
				<div class="row clearfix">
				<div class="col-md-12 column">
					<input type="hidden" id="upid" name="userInfo.userId"/>
				<div class="form-group">
					 <label for="account">登录账号</label>
					 <input type="text" class="form-control" id="uploginAccount" name="userInfo.account"  />
				</div>
				<div class="form-group">
					 <label for="password">登录密码</label>
					<input type="text" class="form-control" id="uploginPassword" name="userInfo.password"  />
				</div>	
				<div class="form-group">
					 <label for="name">姓名</label>
					<input type="text" class="form-control" id="upuserName" name="userInfo.name"  />
				</div>
				<div class="form-group">
					 <label for="sex">性别</label>
					<s:select id="upsex" value="usersex" list="#{'男':'男','女':'女' }" class="form-control"
					name="userInfo.gender" ></s:select>
				</div>	
						<input type="hidden" name="userInfo.photo" id="upphoto"/>
				<div class="form-group">
					 <label for="roleid">角色</label>
					<s:select id="uproleid" list="#request.roleinfo" class="form-control"
				value="uproleid"	name="userInfo.userRoleId" listKey="id" listValue="name"></s:select>
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
    
     <!-- 提示模态框） -->
	<div class="modal fade" id="warninginfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					提示信息
				</h4>
			</div>
			<div class="modal-body">
				您还未选择一行数据！
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div>
	</div>
</div>
    <script type="text/javascript">

	$('#userinfotable').bootstrapTable({
    	url: "userinfopagejson.action",//数据源
   		dataField: "rows",//服务端返回数据键值 就是说记录放的键值是rows，分页时使用总记录数的键值为total
    	pagination: true,//是否分页
    	pageSize: 5,//单页记录数
    	pageList: [5, 10, 20, 50],//分页步进值
    	sidePagination: "server",//服务端分页
    	contentType: "application/x-www-form-urlencoded",//请求数据内容格式 默认是 application/json 自己根据格式自行服务端处理
    	dataType: "json",//期待返回数据类型
    	method: "post",//请求方式
    	searchAlign: "right",//查询框对齐方式
   		queryParamsType: 'limit',//查询参数组织方式
    	queryParams: queryParams,
    	toolbar:"#toolbar",
    	showRefresh: true,//刷新按钮
    	showColumns: true,//列选择按钮
    	buttonsAlign: "right",//按钮对齐方式
    	toolbarAlign: "right",//工具栏对齐方式
    	columns: [
    		{
    			field:"state",
    			checkbox:true
    		},
    		{
    			title:"id",
    			field:"id",
    			visible: false
    		},
        	{
            title: "账户",
            field: "loginaccount"
        },
        {
            title: "密码",
            field: "password",
          	
        },
        {
            field: "userName",
            title: "姓名"
        },
        {
        	field: "sex",
        	title:"性别"
        },
        {
            field: "photo",
            title: "照片"
        },
        {
            field: "roleid",
            title: "角色"
        },
        {
        	field:"rolenameid",
        	visible:false
        }
    ],
    locale: "zh-CN", //中文支持
 
});
	function queryParams(params){
    	return{
    		pageSize: params.limit,
    		rowoffset: params.offset
    	}
    }
	
	function updatainfo()
	{
		var value = $("#userinfotable").bootstrapTable('getSelections');
		console.log(value);
		if(value.length==1)
			{
			$('#upid').val(value[0].id);
			$('#uploginAccount').val(value[0].loginaccount);
			$('#uploginPassword').val(value[0].password);
			$('#upuserName').val(value[0].userName);
			$('#upsex').val(value[0].sex);
			$('#upphoto').val(value[0].photo)
	 		$('#uproleid').val(value[0].rolenameid);
			$('#updatemodal').modal();
			}
		else
			{
				$('#warninginfo').modal();
			}
	}
	function delinfo()
	{
		var a = $("#userinfotable").bootstrapTable('getSelections');
  		if(a.length==1)
  			{
  				if(confirm("确认要删除吗?"))
  					{
  						$.ajax({
  							type:"GET",
  							url:"deluserinfo.action",
  							data:"userid="+a[0].id,
  							success:function(data)
  							{
  								window.location.href='userinfo.action';
  							}
  						})
  					}
  			}
  		else
  			{
  			//提示框
  				$('#warninginfo').modal();
  			}
	}
	</script>
</body>
</html>
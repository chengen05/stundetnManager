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
     <!-- ztree -->
    <link rel="stylesheet" href="css/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="js/jquery.ztree.excheck.js"></script>
   		<script type="text/javascript" src="js/jquery.ztree.exedit.js"></script>
    <!-- AdminLTE App -->
    <script src="js/adminlte.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-table-zh-CN.js"></script>
    <script src="js/bootstrap-table-treegrid.js"></script>
    <script src="js/jquery.treegrid.min.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    
    <style type="text/css">
.ztree * {font-size: 10pt;font-family:"Microsoft Yahei",Verdana,Simsun,"Segoe UI Web Light","Segoe UI Light","Segoe UI Web Regular","Segoe UI","Segoe UI Symbol","Helvetica Neue",Arial}
.ztree li ul{ margin:0; padding:0}
.ztree li {line-height:30px;}
.ztree li a {width:200px;height:30px;padding-top: 0px;}
.ztree li a:hover {text-decoration:none; background-color: #E7E7E7;}
.ztree li a span.button.switch {visibility:hidden}
.ztree.showIcon li a span.button.switch {visibility:visible}
.ztree li a.curSelectedNode {background-color:#D4D4D4;border:0;height:30px;}
.ztree li span {line-height:30px;}
.ztree li span.button {margin-top: -7px;}
.ztree li span.button.switch {width: 16px;height: 16px;}
.ztree li a.level0 span {font-size: 150%;font-weight: bold;}
.ztree li span.button.switch.level0 {width: 20px; height:20px}
.ztree li span.button.switch.level1 {width: 20px; height:20px}
.ztree li span.button.noline_open {background-position: 0 0;}
.ztree li span.button.noline_close {background-position: -18px 0;}
.ztree li span.button.noline_open.level0 {background-position: 0 -18px;}
.ztree li span.button.noline_close.level0 {background-position: -18px -18px;}
	</style>


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
    </aside>

    <div class="content-wrapper">
     
        <!-- 主内容 -->
        <section class="content container-fluid">
            <div id="container">
            	<div class="col-md-6">
			           <div class="box box-danger">
			            <div class="box-header">
			              <h3 class="box-title">菜单树</h3>
			              <div>
			              <a href="#" class="btn" role="button" id="addParent" data-toggle="modal" data-target="#addmodal">
                  		  <span class=" glyphicon glyphicon-plus" aria-hidden="true" style="margin-right: 5px"></span>添 加父菜单</a>
                  		  <a href="#" class="btn" role="button" id="addItem">
                  		  <span class=" glyphicon glyphicon-plus" aria-hidden="true" style="margin-right: 5px"></span>添 加子菜单</a>
               			 <a id="btnEdit" href="#" class="btn" role="button">
                   		 <span class=" glyphicon glyphicon-edit" aria-hidden="true" style="margin-right: 5px"></span>修 改</a>
               			 <a href="#" class="btn" role="button" id="btnRemove">
                   		 <span class="glyphicon glyphicon-minus" aria-hidden="true" style="margin-right: 5px"></span>删 除</a>		
			          	</div>
			            </div>
			            <div class="box-body">
			              	<ul id="treeDemo" class="ztree"></ul>
			            </div>
			          </div>
				</div>
				<div class="col-md-6">
					<div class="box box-danger">
            			<img alt="" src="css/img/left_menuForOutLook.png">
           
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

<!-- 添加节点模态框 -->
    <div class="modal fade" id="addmodal" >
    <div class="modal-dialog">
      <div class="modal-content">
   		<form action="addSchoolDepart.action" method="post">
        <!-- 模态框头部 --> 
        <div class="modal-header">
          <h4 class="modal-title">父菜单</h4>
        </div>
        <!-- 模态框主体 -->
        <div class="modal-body">
				<div class="row clearfix">
				<div class="col-md-12 column">
				<div class="form-group">
					 <label for="name">名称:</label>
					 <input type="text" class="form-control" id="name" name="systemOperate.name"  />
				</div>
				<div class="form-group">
					 <label for="linkUrl">链接action:</label>
					 <input type="text" class="form-control" id="linkUrl" name="systemOperate.linkUrl"/>
				</div>
				<div class="form-group">
				<!-- 父菜单 -->
					 <input type="hidden" class="form-control" value="1" id="menu" name="systemOperate.menu"/>
				</div>
				<div class="form-group">
					 <label for="icon">图标:</label>
					 <input type="text" class="form-control" id="icon" name="systemOperate.icon" />
				</div>
				<div class="form-group">
					 <input type="hidden" class="form-control" value="0" id="parentNode" name="systemOperate.parentNode" />
				</div>
		</div>
	</div>  
        </div>
        <!-- 模态框底部 -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
          
          	 <button type="submit"class="btn btn-default" onclick="addparent()">添加</button>
          	
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
	var curMenu = null, zTree_Menu = null;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {
			view: {
				showLine: true,
				showIcon: false,
				selectedMulti: false,
				dblClickExpand: false,
			
			}
			
	};	
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				setTimeout(function(){zTree.editName(treeNode)}, 10);
				return false;
			}
			return true;
		}
		
	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	var zNodes = getTree();
	function getTree(){
		var tree ;
		$.ajax({
			url:"roleinfojson.action",
			async:false,
			success:function(data){
				tree = data;
			}
	});
		return tree;            
	}
	
	//删除节点
	function remove() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if (nodes.length == 0) {
				$('#warninginfo').modal();
				return;
			}else
				{
					if(confirm("确认要删除吗?"))
						{
							zTree.removeNode(treeNode);
						}
				}
			
		};
	//编辑节点
	function edit() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if (nodes.length == 0) {
				$('#warninginfo').modal();
				return;
			}
			else
				{
					
				}
			zTree.editName(treeNode);
		};
	//增加节点
	var newCount = 1;
	function add(e) {
		var name = $('#name').val();
		var linkUrl = $('#linkUrl').val();
		var menu = $('#menu').val();
		var icon = $('#icon').val();
		var parentNode = $('#parentNode').val();
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		isParent = e.data.isParent,
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
		if (treeNode) {
			treeNode = zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, isParent:isParent, name:"new node" + (newCount++)});
		} else {
			treeNode = zTree.addNodes(null, {id:(100 + newCount), pId:0, isParent:isParent, name:name});
		}
		if (treeNode) {
			zTree.editName(treeNode[0]);
		} else {
			alert("无法增加子菜单");
		}
	};
		
		function addparent()
		{
			var name = $('#name').val();
			var linkUrl = $('#linkUrl').val();
			var menu = $('#menu').val();
			var icon = $('#icon').val();
			var parentNode = $('#parentNode').val();
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			isParent = e.data.isParent,
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			treeNode = zTree.addNodes(null, {id:(100 + newCount), pId:0, isParent:isParent, name:name});
			if (treeNode) {
				zTree.editName(treeNode[0]);
			} else {
				alert("无法增加子菜单");
			}
		
		};
	
	$(document).ready(function(){
		var ztreeObj = $("#treeDemo");
		ztreeObj = $.fn.zTree.init(ztreeObj, setting, zNodes);
		$("#addItem").bind("click", {isParent:false}, add);
		$("#btnEdit").bind("click", edit);
		$("#btnRemove").bind("click", remove);
	
		
	
});
</script>
</body>
</html>
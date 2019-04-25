<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学工助手|权限</title>
</head>
<script type="text/javascript" src="res/vendor/jquery/jquery.min.js"></script>
<link rel="stylesheet" href="res/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet" href="public/font-awesome/css/font-awesome.css">
<!-- Google fonts - Poppins -->
 <link rel="stylesheet" href="res/google-font/fonts.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="res/css/style.default.css" id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="res/css/custom.css">
 <!-- Favicon-->
<link rel="shortcut icon" href="res/img/favicon.ico">
	<!--bootstrap-treeview start-->
	<link rel="stylesheet" type="text/css" href="public/plugins/bootstrap-treeview/bootstrap-treeview.css">
	<script type="text/javascript" src="public/plugins/bootstrap-treeview/bootstrap-treeview.js"></script>
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
          <!-- Feeds Section-->
          <section class="feeds no-padding-top">
            <div class="container-fluid">
			<div class="row">
			<div class="col-md-12">
				<input id="btnAdd" class="btn btn-primary" type="button" value="添加节点">
				<input id="btnDel" class="btn btn-danger" type="button" value="删除节点">
			</div>
		</div>


		<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="panel panel-primary ">
					<div class="panel-heading">
						<h3 class="panel-title">菜单树</h3>
					</div>
					<div class="panel-body right_centent" style="">
						<div id="left-tree"></div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="panel panel-primary ">
					<div class="panel-heading">
						<h3 class="panel-title">编辑区</h3>
					</div>
					<!--编辑操作权限 start-->
                <div class="panel-body right_centent">
                <div  id="editShow">
                	<div>
                        <div class="input-group margin-t-5">
                       	 <div>
                            <label for="input-group-addon">名称:</label>
                            <input id="editName" type="text"  class="form-control" />
                            <br/>
                           </div>
                           <div>
                              <label for="input-group-addon">路径:</label>
                            <input id="editurl" type="text" class="form-control"/>
                            <br/>
                            </div>
                            <div>
                            <label for="input-group-addon">图标:</label>
                             <input id="editicon" type="text" class="form-control">
                             <br/>
                             </div>
                             <label for="input-group-addon">父节点:</label>
                             <input id="editpid" type="text" class="form-control">
                             <br/>
                             </div>
                        </div>
                    </div>
                    <div style="margin-top: 10px;">
                        <input id="Edit" class="btn btn-primary" type="button" value="确定" />
                        <input id="Edit_cancel" class="btn btn-default" type="button" style="margin-left:80px;display:none;" value="取消" />
                    </div>
                </div>
                </div>
                <!--编辑操作权限 end-->
				</div>
			</div>
		</div>
	</div>
	<div>
		<!--弹出框 新增权限 start-->
		<div class="modal fade" id="addOperation-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">

				<div class="modal-content radius_5">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">新增</h4>
					</div>
					<div class="modal-body">
						<div group="" item="add">
							<div>
								<div class="input-group margin-t-5">
									<span class="input-group-addon">名称:</span>
									<input id="addName" type="text" class="form-control" />
								</div>

							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button id="Save" type="button" class="btn btn-primary">保存</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

					</div>
				</div>


			</div>
		</div>
		<!--弹出框 新增权限 end-->
		 
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

    <script src="res/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="res/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="res/vendor/jquery.cookie/jquery.cookie.js"> </script>
 
    <script src="res/vendor/jquery-validation/jquery.validate.min.js"></script>
   
    
    <!-- Main File-->
    <script src="res/js/front.js"></script>

    <script type="text/javascript">
	$(function(){

		onLoad();

		BindEvent();
		 //页面加载
		 function onLoad()
		 {
	     	//渲染树
	     	$('#left-tree').treeview({
	     		data: getTree(),
	     		levels:2,
	     		onNodeSelected:function(event, node){
	     			$('#editName').val(node.text);
	     			$('#editurl').val(node.url);
	     			$('#editicon').val(node.icon);
	     			$('#editpid').val(node.pId);
	     		},
				showCheckbox:false//是否显示多选
			});   
	     }
	     //事件注册
	     function BindEvent()
	     {
	     	 //保存-新增
	     	 $("#Save").click(function () {
	     	 	$('#addOperation-dialog').modal('hide')
                                //静态添加节点
                                var parentNode = $('#left-tree').treeview('getSelected');
                                var node = {
                                	text: $('#addName').val()
                                };
                                $('#left-tree').treeview('addNode', [node, parentNode]);

                });
	     	}
	     	//保存-编辑
	     	$('#Edit').click(function(){
	     		var node = $('#left-tree').treeview('getSelected');
				var newNode={
					text:$('#editName').val()
				};
			$('#left-tree').treeview('updateNode', [ node, newNode]);
	     	});



		//显示-添加
		$("#btnAdd").click(function(){
			var node = $('#left-tree').treeview('getSelected');
			if (node.length == 0) {
				$.showMsgText('请选择节点');
				return;
			}
			$('#addName').val('');
			$('#addOperation-dialog').modal('show');
			
		});
		//显示-编辑
		$("#btnEdit").click(function(){
			var node=$('#left-tree').treeview('getSelected');
			$('#editShow').show();

		});
		//删除
		$("#btnDel").click(function(){
			var node = $('#left-tree').treeview('getSelected');
			if (node.length == 0) {
				$.showMsgText('请选择节点');
				return;
			}
			  BootstrapDialog.confirm({
                    title: '提示',
                    message: '确定删除此节点?',
                    size: BootstrapDialog.SIZE_SMALL,
                    type: BootstrapDialog.TYPE_DEFAULT,
                    closable: true,
                    btnCancelLabel: '取消', 
                    btnOKLabel: '确定', 
                    callback: function (result) {
                        if(result)
                        {
                            del();
                        }
                    }
                });
			  function del(){
			  	
				$('#left-tree').treeview('removeNode', [ node, { silent: true } ]);
			  }
			
		});

		//获取树数据
		function getTree(){
			var tree ;
			$.ajax({
				url:"roleinfojson.action",
				async:false,
				success:function(data){
					tree = getTrees(data,0);
				}
		});
			return tree;            
		}
		
	    function getTrees(list, parentId) {
	    	let items= {};
	   	 // 获取每个节点的直属子节点，*记住是直属，不是所有子节点
	   	 for (let i = 0; i < list.length; i++) {
	         let key = list[i].pId;
	         if (items[key]) {
	             items[key].push(list[i]);
	         } else {
	             items[key] = [];
	             items[key].push(list[i]);
	         }
	     }
	     return formatTree(items, parentId);
	}

	/**
	 * 利用递归格式化每个节点
	 */
	function formatTree(items, parentId) {
	    let result = [];
	    if (!items[parentId]) {
	        return result;
	    }
	    for (let t of items[parentId]) {
	        t.nodes = formatTree(items, t.id)
	        result.push(t);
	    }
	  return result;
	}

		
		/*-----页面pannel内容区高度自适应 start-----*/
		$(window).resize(function () {
			setCenterHeight();
		});
		setCenterHeight();
		function setCenterHeight() {
			var height = $(window).height();
			var centerHight = height - 240;
			$(".right_centent").height(centerHight).css("overflow", "auto");
		}
		/*-----页面pannel内容区高度自适应 end-----*/
	});



</script>

  </body>
</html>
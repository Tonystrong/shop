<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
			// 1: 注册 a标签单击事件  [] 是属性选择器
			$("a[title]").click(function(){
				// 2: 获取当前a标签的属性值
				var text=$(this).text();
				var href=$(this).attr("title");
				// 3: 判断tabs 是否有当前选项卡,如果有则切换,否则创建一个新的tab
				// easyui组件的方法调用: $("#tt").tabs('方法名'[,参数])  如果参数多个则参数是json格式
				//alert($("#tt").tabs('exists',1));
				if($("#tt").tabs('exists',text)){
					// 当前选项卡已经存在,切换即可
					$("#tt").tabs('select',text);
				}else{
					// 创建新的选项卡
					$("#tt").tabs('add',{
						title: text,
						content:"<iframe src='" +href+ "' width='100%' height='100%' frameborder='0' />",
						//href:href,  // 用来加载页面,并且显示当前tab面板,此方式仅仅加载body中的 数据
						closable:true
					});
				}
			});
		});
	</script>
</head>
<!-- css的方式创建 layout -->
<body class="easyui-layout">
	<!-- data-options:用来设置 ui组件的参数 -->
	<div data-options="region:'north',title:'欢迎来到易购商城后台管理系统',split:true" style="height:150px;"></div>
	<div data-options="region:'west',title:'系统菜单',split:true" style="width:180px;">
		<!-- 用来显示折叠菜单  采用css的方式创建  easyui-组件名称 -->
		<div id="aa" class="easyui-accordion" data-options="fit:true">
			<div title="基本菜单" style="padding:5px;">
				<li><a title="send_category_query.action" href="#">类别管理</a></li>
				<li><a title="send_product_query.action" href="#">商品管理</a></li>
			</div>
			<div title="业绩菜单" style="padding:5px;">				
				<li><a href="#" title="send_sale_query.action">销售报表</a></li>
			</div>
			<div title="权限设置" style="padding:5px;">
				<a href="#">角色管理</a>				
				<a href="#">权限管理</a>				
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'控制面板'" style="padding:1px;background:#fff;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">   
		    <div title="系统参数信息" style="padding:5px;">   
		                         此处显示服务器的参数信息
		    </div>   
		    <!-- 
		    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">   
		        tab2    
		    </div>   
		     -->
		</div>  
	</div>
	
</body>
</html>

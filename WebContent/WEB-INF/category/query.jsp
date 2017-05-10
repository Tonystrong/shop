<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>
	  <style type="text/css">
	  	body{
	  		margin:1px;
	  	}
	  	.searchbox{
	  		margin:-3;
	  	}
	  </style>
	  <script type="text/javascript">
		  	$(function(){
		  		// 吧当前dom-->query-->easyui对象
		  		$('#dg').datagrid({
		  			// 通过后台获取相应的数据,仅仅支持json格式
		  		    url:'categoryAction_pageMap.action',
		  			// 请求远程数据时发送额外的参数
				    queryParams:{name:""},
				    idField:"id",
		  		    fitColumns:true,  /* 真正的自动展开/收缩列的大小 */
		  		    striped:true,  /* 显示 奇偶行变色 */
		  		  	nowrap:true,   /* 则在同一行中显示数据 */
		  		  	loadMsg:'加载中...',
		  		  	sortName:'id', /* 支持排序的名称 */
		  		    sortOrder:'asc',
		  		  	rownumbers:true, // 是否显示行编号
		  		  	remoteSort:false,  /* 必须禁止使用远程排序 */
		  		   	singleSelect:false,
		  		 	checkOnSelect:false,
		  		 	pagination:true,
		  		 	pageSize:5,
				 	pageList:[5,10,15,20],
				 	
				 	toolbar: [{
						iconCls: 'icon-edit',
						text:'编辑类别',
						handler: function(){var rows=$("#dg").datagrid("getSelections");
							if(rows.length==1){
								$('#win').window({    
								    width:270,    
								    height:260,    
								    content:"<iframe src='send_category_update.action' width='100%' height='100%' frameborder='0' />",
								});			
							}else{
								$.messager.show({
									title:'提示消息',
									msg:'只能更新一条记录',
									timeout:2000,
									showType:'slide'
								});
							}
						}
					},'-',{
						iconCls: 'icon-add',
						text:'添加类别',
						handler: function(){// 加载添加类别的页面即可  panel(标准流)  window(状态栏)  dialog (工具栏,状态栏)
							$('#win').window({    
							    width:270,    
							    height:180,    
							    content:"<iframe src='send_category_save.action' width='100%' height='100%' frameborder='0' />",
							});  
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除类别',
						handler: function(){
							// 1: 获取被选中的行
							var rows=$("#dg").datagrid("getSelections");
							// 2： 对事件进行判断, 和删除确认
							if(rows.length==0){
								$.messager.show({
									title:'提示消息',
									msg:'至少选择一条记录',
									timeout:2000,
									showType:'slide'
								});
							}else{
								$.messager.confirm('删除确认', '您确认删除选中的数据吗?', function(r){
									if (r){
									    // 3: 获取要删除的 id值   1,2,3===> String ids  delete from category where id in (1,2,3)
									    var ids="";
									    for(var i=0;i<rows.length;i++){
									    	ids += rows[i].id + ",";
									    }
									    ids=ids.substring(0,ids.length-1);
									    // 4: 发送请求提交删除信息
									    $.post("categoryAction_deleteByIds.action",{ids:ids},function(result){
									    	if (result=="true") {
									    		$.messager.show({
													title:'提示消息',
													msg:'删除成功',
													timeout:2000,
													showType:'slide'
												});
									    	} else {
									    		$.messager.show({
													title:'提示消息',
													msg:'删除失败',
													timeout:2000,
													showType:'slide'
												});
									    	}
									    },"text");
									 	// 5: 刷新当前页数据
									 	$("#dg").datagrid("reload");
									}
								});
							}
						}
					},'-',{
						text:"<input type='text' id='ss' name='type' />"
					}],
		  		    /*冻结列,适合列比较多的情况*/
		  		  	frozenColumns:[[
		  		        {field:'xyz',width:50,checkbox:true},    
						{field:'id',title:'编码',width:100,sortable:true},
		  		  	]],
		  		    // 用来设置列的参数
		  		    columns:[[    
		  		        /*  field设置字段的名称,与json中的key捆绑 ,title: 列标题   */
		  		        {field:'name',title:'分类',width:100},
		  		        	/*formatter: function(value,row,index){
		  		        		return "<span title=" +value+ ">"+value+"</span>";
		  		        	}},   */ 
		  		        
		  		        {field:'hot',title:'热点',width:100,align:'right',
	  		        		formatter:function(value,row,index) {
	  		        			if (value) {
	  		        				return "<input type='checkbox' value='true' checked='checked' disabled='true'/>";
	  		        			} else {
	  		        				return "<input type='checkbox' value='true' disabled='true'/>";
	  		        			}
	  		        		}
		  		        },
		  		        
		  		      	{field:'account.login',title:'管理员',width:100,
		  		        	formatter: function(value,row,index) {
		  		        		if (row.account!=null && row.account.login!=null) {
		  		        			return row.account.login;
		  		        		}        		
		  		        	}
		  		      	}
		  		    ]]    
		  		});
		  		
		  		// 设置搜索框
				$('#ss').searchbox({ 
					// 在用户按下搜索按钮或回车键的时候调用searcher函数
					searcher:function(value,name){ 
						$('#dg').datagrid('load',{
							name:value
						});
					}, 
					prompt:'变形金刚4' 
				}); 
		  	});
	  </script>
  </head>
  <body>
  	 <table id="dg"></table>
  	 <div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
  </body>
</html>

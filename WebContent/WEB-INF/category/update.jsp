<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>	
	  <style type="text/css">
	  	form div{
	  		padding: 5px;
	  	}
	  </style>
	  <script type="text/javascript">
	  		$(function(){
	 			// 通过远程加载管理员信息
	 			$('#cc').combobox({    
				    url:'accountAction_query.action',    
				    valueField:'id',    
				    textField:'login',
				    editable:false,
				    panelHeight:'auto'
				});  
	  			// 完成数据的回显 
	  			var rows=parent.$("#dg").datagrid("getSelections");
	  			// 对表单的数据进行填充
	  			$('#ff').form('load',{
	  				name:rows[0].name,
	  				hot:rows[0].hot,
	  				id:rows[0].id,
	  				'account.id':rows[0].account.id
	  			});
	  			// 定义验证规则,通过属性选择器吧com转化为jquery对象
	  			$("[name=name]").validatebox({
	  				required:true,
	  				missingMessage:'名称必填!'
	  			});
	  			// 页面默认加载的时候禁止使用验证对照
	  			$("#ff").form("disableValidation");
	  			// 触发提交事件
	  			$("#submit").click(function(){
	  				// 进行表单数据验证
	  				$("#ff").form("enableValidation");
	  				// 验证通过则返回为true
	  				if($("#ff").form("validate")){
		  				// ajax 提交表单数据
		  				$('#ff').form("submit",{
							url:"categoryAction_updateCategory.action",
							success:function(){
								//$("#ff").form("disableValidation");
								// 清除所有的数据,包括初始值
								//$("#ff").form("clear");
								// 重置表单
								$("#ff").form("reset");
								// 关闭窗体
								parent.$("#win").window("close");
								// 刷新dg结果
								parent.$("#dg").datagrid("reload");
							}
						});
	  				}
	  			});
	  		});
	  </script>
  </head>
  <body>
  	<form id="ff" method="post">   
	    <div>   
	        <label for="name">类别名称:</label>
	        <input type="text" name="name" />   
	    </div>   
	    <div>   
	        <label for="hot">热点:</label>   
	                       热点:<input type="radio" value="true" name="hot" />
	                      非热点:<input type="radio" value="false" name="hot" checked="checked" />
	    </div>
	    <div>
	        <label for="account.id">所属管理员:</label>   
	        <!-- 获取远程的数据, 显示管理信息 -->
	        <input id="cc" name="account.id" disabled="true"/>  
	        <!-- 
	    	<select id="cc" class="easyui-combobox" data-options="height:auto" name="account.id" style="width:150px;">   
			    <option value="aa">aitem1</option>   
			    <option value="bb">aitem2</option>   
			</select>  
	         -->
	    </div>
	    <div>
	    	
	    	<input type="text" size="2" name="id" disabled="true"/>
	    	<br/>
	    	<!-- 根据需求此时的提交事件为ajax比较好 -->
	    	<a id="submit" href="#" class="easyui-linkbutton">更新</a> 
	    </div>
	</form>  
  </body>
</html>

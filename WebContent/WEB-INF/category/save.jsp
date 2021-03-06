<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>	
	  <script type="text/javascript">
	  		$(function(){
	  			// 定义验证规则,通过属性选择器吧com转化为jquery对象
	  			$("[name=name]").validatebox({
	  				required:true,
	  				missingMessage:'名称必填!'
	  			});
	  			// 页面默认加载的时候禁止使用验证对照
	  			$("#ff").form("disableValidation");
	  			// 触发重置事件
	  			$("#reset").click(function(){
	  				$("#ff").form("reset");
	  			});
	  			// 触发提交事件
	  			$("#submit").click(function(){
	  				// 进行表单数据验证
	  				$("#ff").form("enableValidation");
	  				// 验证通过则返回为true
	  				if($("#ff").form("validate")){
		  				// ajax 提交表单数据
		  				$('#ff').form("submit",{
							url:"categoryAction_saveCategory.action",
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
	        <!-- 
	       	 <input type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'名称必填'" name="type" />   
	         -->
	         <input type="text" name="name" />   
	    </div>   
	    <div>   
	        <label for="hot">热点:</label>   
	                       热点:<input type="radio" value="true" name="hot" />
	                      非热点:<input type="radio" value="false" name="hot" checked="checked" />
	    </div>
	    <div>
	    	<!-- 根据需求此时的提交事件为ajax比较好 -->
	    	<a id="submit" href="#" class="easyui-linkbutton">添加</a>  
	    	<a id="reset" href="#" class="easyui-linkbutton">重置</a>  
	    </div>
	</form>  
  </body>
</html>

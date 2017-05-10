$(function(){  // js文件内部是不能使用 jstl变量的 ${shop}
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
				content:"<iframe title=" + text + " src='" + href + "' width='100%' height='100%' frameborder='0' />",
				//href:href,  // 用来加载页面,并且显示当前tab面板,此方式仅仅加载body中的 数据
				closable:true
			});
		}
	});
});
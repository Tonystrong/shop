package com.jyx.s2sh.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.domain.User;

@Controller("userAction")
@Scope(value="prototype")
public class UserAction extends BaseAction<User> {
	
	public String login() {
		model = userService.loginValidate(model);
		if (model == null) {
			session.put("error", "用户名和密码有误，请重新输入！");
			return "ulogin";
		} 
		session.put("user", model);
		String url = (String) session.get("nextUrl");
		if (url == null) {
			return "index";
		} else {
			return "login";
		}
		
	}
}

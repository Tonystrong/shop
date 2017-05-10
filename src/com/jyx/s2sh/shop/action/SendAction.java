package com.jyx.s2sh.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("sendAction")
@Scope(value="prototype")
public class SendAction extends ActionSupport{
	
	/*
	 * 直接到后台
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		return "send";
	}
}

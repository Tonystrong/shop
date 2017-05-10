package com.jyx.s2sh.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.domain.Account;

@Controller("accountAction")
@Scope(value="prototype")
public class AccountAction extends BaseAction<Account> {
	
	public String save() {
		accountService.save(model);
		return "SUCCESS";
	}
	
	public String query() {
		jsonList = accountService.getAll();
		return "jsonList";
	}
	
	
}

package com.jyx.s2sh.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.User;

@Controller("forderAction")
@Scope(value="prototype")
public class ForderAction extends BaseAction<Forder> {
	
	public String save() {
		Forder forder = (Forder) session.get("forder");
		User user = (User) session.get("user");
		forder = forderService.saveForder(forder, model, user);
		session.put("oldForder", forder);
		session.put("forder", new Forder());
		return "bank";
	}
	
	
}

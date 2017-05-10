package com.jyx.s2sh.shop.action;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.Product;
import com.jyx.s2sh.shop.domain.Sorder;
import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionContext;

@Controller("sorderAction")
@Scope(value="prototype")
public class SorderAction extends BaseAction<Sorder> {
	
	public String addSorder() {
		Product product = productService.getById(model.getProduct().getId());
		Forder forder = (Forder) session.get("forder");
		if (forder==null) {
			forder = new Forder();
		}
		forder = sorderService.addForderByProduct(forder, product);
		forder = forderService.getTotalPrice(forder);
		session.put("forder", forder);
		return "addSorder";
	}
	
	public void delete() {
		Forder forder = (Forder) session.get("forder");
		List<Sorder> sorderList = new ArrayList<Sorder>();
		forder.setSorderList(sorderList);
		forder.setTotal(new BigDecimal(0.00));
		session.put("forder", forder);
	}
	
	public String update() {
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.updateSorder(forder, model);
		forder = forderService.getTotalPrice(forder);
		inputStream = new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
	}
	
	public String querySale() {
		jsonList = sorderService.querySale(model.getNumber());
		List<Sorder> list = sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(jsonList);
		return "json";
	}
}

package com.jyx.s2sh.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.domain.BackData;
import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.SendData;
import com.jyx.s2sh.shop.domain.User;

@Controller("payAction")
@Scope(value="prototype")
public class payAction extends BaseAction<Object> implements ParameterAware{
	
	private Map<String, String[]> parameters;
	
	@Override
	public Object getModel() {
		if (parameters.get("pd_FrpId")!=null) {
			model = new SendData();
		} else {
			model = new BackData();
		}
		return model;
	}
	
	public String goBank() {
		SendData sendData = (SendData)model; 
		Forder forder = (Forder) session.get("oldForder");
		User user = (User)session.get("user");
		//SendData sendData = new SendData();
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getPhone()+ "," +user.getEmail());
		payService.saveDataToRequest(request, sendData);
		System.out.println(model);
		return "goPay";
	}
	
	public String payBack() { 
		BackData backData = (BackData)model;
		boolean isOk = payService.checkBackData(backData);
		if (isOk && backData.getR1_Code().equals("1")) {
			//更新订单状态
			String id = backData.getR6_Order();
			String email = backData.getR8_MP().split(",")[1];
			String phone = backData.getR8_MP().split(",")[0];
			String total = backData.getR3_Amt();
			forderService.updateByOrderId(Integer.parseInt(backData.getR6_Order()), 2);
			//发送邮件
			sendUtils.sendEmail(email, id, total);
			//短信
			sendUtils.sendSMS(id, total, phone);
			request.put("info", backData.getR6_Order() + ",支付成功!");
		} else {
			request.put("info", "支付失败");
		}
		return "result";
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
}

package com.jyx.s2sh.shop.service;

public interface SendUtils {

	void sendEmail(String email, String id, String total);

	void sendSMS(String id, String total, String phone);
	
}

package com.jyx.s2sh.shop.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import com.jyx.s2sh.shop.service.SendUtils;

@Component("sendUtils")
public class SendUtilsImpl implements SendUtils{
	
	@Override 
	public void sendEmail(String email, String id, String total) {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		Session session = null;
		Message message = null;
		Transport transport = null;
		
		try {
			session = Session.getDefaultInstance(properties);
			session.setDebug(true);
			message = new MimeMessage(session);
			message.setSubject("易购支付详情");
			message.setFrom(new InternetAddress("tonyed_study@sina.com"));
			message.setContent("您购买的订单号为" +id+ "，总金额为:￥" +total+ "的商品"
					+ "已经成功支付，我们将尽快为您发件!", "text/html;charset=utf-8");
			transport = session.getTransport();
			transport.connect("smtp.sina.com", "tonyed_study", "tonystrong2014");
			transport.sendMessage(message, new Address[] 
					{new InternetAddress(email)});
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				transport.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	@Override
	public void sendSMS(String id, String total, String phone) {
		
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//在头文件中设置转码
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
		post.setParameter("Uid", "tonyed");
		post.setParameter("Key", "423465e6a24e352c30ee");
		post.setParameter("smsMob", phone);
		post.setParameter("smsText", "您购买的订单号为" +id+ "，总金额为:￥" +total+ "的商品"
				+ "已经成功支付，我们将尽快为您发件!");
		try {
			int code = httpClient.executeMethod(post);
			System.out.println("http状态码:200代表OK: " + code);
			// 查看发送结果
			System.out.println(post.getResponseBodyAsString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		SendUtilsImpl sendUtils = new SendUtilsImpl();
		sendUtils.sendEmail("494258044@qq.com", "123456789", "343.4");
		//sendUtils.sendSMS("448686", "12.0", "13202096099");
	}
}	

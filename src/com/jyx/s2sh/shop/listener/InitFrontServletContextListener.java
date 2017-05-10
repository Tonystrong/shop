package com.jyx.s2sh.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jyx.s2sh.shop.utils.FileUploadUtilsImpl;
import com.jyx.s2sh.shop.utils.ProductTimerTask;

public class InitFrontServletContextListener implements ServletContextListener {

	private ApplicationContext applicationContext;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
		ProductTimerTask productTimerTask = (ProductTimerTask) applicationContext.getBean("productTimerTask");
		FileUploadUtilsImpl fileUploadUtils = (FileUploadUtilsImpl)applicationContext.getBean("fileUploadUtils");
		productTimerTask.setApplication(event.getServletContext());
		String[] bankName = fileUploadUtils.getBankName();
		event.getServletContext().setAttribute("bankNameList", bankName);
		// 通过定时器,完成首页数据的同步更新
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
	}
	
}

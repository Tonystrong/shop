package com.jyx.s2sh.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.service.AccountService;
import com.jyx.s2sh.shop.service.CategoryService;
import com.jyx.s2sh.shop.service.ForderService;
import com.jyx.s2sh.shop.service.PayService;
import com.jyx.s2sh.shop.service.ProductService;
import com.jyx.s2sh.shop.service.SendUtils;
import com.jyx.s2sh.shop.service.SorderService;
import com.jyx.s2sh.shop.service.UserService;
import com.jyx.s2sh.shop.utils.FileUploadUtilsImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("baseAction")
@Scope(value="prototype")
public class BaseAction<T> extends ActionSupport implements 
		RequestAware, SessionAware, ApplicationAware,
		ModelDriven<T> {
	
	@Resource(name="categoryService")
	protected CategoryService categoryService;
	@Resource(name="accountService")
	protected AccountService accountService;
	@Resource(name="productService")
	protected ProductService productService;
	@Resource(name="fileUploadUtils")
	protected FileUploadUtilsImpl fileUploadUtils;
	@Resource(name="sorderService")
	protected SorderService sorderService;
	@Resource(name="forderService")
	protected ForderService forderService;
	@Resource(name="userService")
	protected UserService userService;
	@Resource(name="payService")
	protected PayService payService;
	@Resource(name="sendUtils")
	protected SendUtils sendUtils;
	
	//用于读取页面上的page分页数据
    protected int page;
    protected int rows;
    protected InputStream inputStream;
  
	protected Map<String, Object> jsonMap = null;
    //update回显
	protected List<T> jsonList = null;
	protected T model;
	

	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	protected Map<String, Object> application;
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
			this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public T getModel() {
		return model;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public List<T> getJsonList() {
		System.out.println("======j======");
		return jsonList;
	}

	
}

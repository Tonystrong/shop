package com.jyx.s2sh.shop.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.jyx.s2sh.shop.domain.Category;
import com.jyx.s2sh.shop.domain.Product;
import com.jyx.s2sh.shop.service.CategoryService;
import com.jyx.s2sh.shop.service.ProductService;

@Component("productTimerTask")
public class ProductTimerTask extends TimerTask {
	
	@Resource(name="productService")
	private ProductService productService;
	@Resource(name="categoryService")
	private CategoryService categoryService;
	private ServletContext application;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		List<Category> list = categoryService.queryByHot(true);
		List<List<Product>> productList = new ArrayList<List<Product>>();
		for (Category category : list) {
			productList.add(productService.queryProductByCid(category.getId()));
		}
		application.setAttribute("productList", productList);
	}

}

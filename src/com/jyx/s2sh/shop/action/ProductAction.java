package com.jyx.s2sh.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.domain.Product;

@Controller("productAction")
@Scope(value="prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String pageMap() {
		String name = model.getName();
		jsonList = new ArrayList<Product>();
		jsonList = productService.queryJoinCategory(name, page, rows);
		jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", jsonList);
		jsonMap.put("total", productService.getProductCount(name));
		return "jsonMap";
	}
	
	public String deleteByIds() {
		String ids = model.getIds();
		productService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void saveProduct() {
		String picUrl = fileUploadUtils.upload(model.getUpload(), model.getUploadFileName());
		model.setPic(picUrl);
		productService.save(model);
	}
	
	public void updateProduct() {
		productService.update(model);
	}
	
	public String get() {
		int id = model.getId();
		request.put("product", productService.getById(id));
		return "detail";
	}
}

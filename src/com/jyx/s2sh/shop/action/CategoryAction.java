package com.jyx.s2sh.shop.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jyx.s2sh.shop.domain.Account;
import com.jyx.s2sh.shop.domain.Category;

@Controller("categoryAction")
@Scope(value="prototype")
public class CategoryAction extends BaseAction<Category> {
	
//	private String ids;
//	
//	public String getIds() {
//		return ids;
//	}
//
//	public void setIds(String ids) {
//		this.ids = ids;
//	}

	public void saveCategory() {
		System.out.println(model);
		Account account = new Account();
		account.setId(2);
		model.setAccount(account);
		categoryService.save(model);
    }
	
	public void updateCategory() {
		System.out.println(model + "," + model.getAccount());
		categoryService.update(model);
	}
    
    public String pageMap() {
    	String name = model.getName();
    	List<Category> list = categoryService.queryJoinAccount(name, page, rows);
    	jsonMap = new HashMap<String, Object>();
    	jsonMap.put("rows", list);
    	Long jsonCount = categoryService.getAllCount("");
    	jsonMap.put("total", jsonCount);
    	System.out.println(jsonCount);
    	return "JsonMap";
    }
    
    public String deleteByIds() {
    	String ids = model.getIds();
    	categoryService.deleteByIds(ids);
    	inputStream = new ByteArrayInputStream("true".getBytes());
    	return "stream";
    }
    
    public String query() {
    	jsonList = categoryService.getAll();
    	return "jsonList";
    }
    
}

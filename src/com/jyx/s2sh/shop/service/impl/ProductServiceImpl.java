package com.jyx.s2sh.shop.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.domain.Product;
import com.jyx.s2sh.shop.service.ProductService;
import com.jyx.s2sh.shop.utils.FileUploadUtilsImpl;

@Service("productService")
@SuppressWarnings("unchecked")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	
	@Override
	public List<Product> queryJoinCategory(String name, int page, int rows) {
		return productDao.queryJoinCategory(name, page, rows);
	}
	
	@Override
	public Long getProductCount(String name) {
		return productDao.getProductCount(name);
	}
	
	@Override
	public List<Product> queryProductByCid(int id) {
		return productDao.queryProductByCid(id);
	}
}
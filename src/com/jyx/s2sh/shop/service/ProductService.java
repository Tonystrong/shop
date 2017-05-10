package com.jyx.s2sh.shop.service;

import java.util.List;

import com.jyx.s2sh.shop.domain.Product;

public interface ProductService extends BaseService<Product> {

	List<Product> queryJoinCategory(String name, int page, int rows);

	Long getProductCount(String name);

	List<Product> queryProductByCid(int id);

}

package com.jyx.s2sh.shop.service;

import java.util.List;

import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.Product;
import com.jyx.s2sh.shop.domain.Sorder;

public interface SorderService extends BaseService<Sorder> {

	public Forder addForderByProduct(Forder forder, Product product);

	public Sorder setProductToSorder(Product product);

	public Forder updateSorder(Forder forder, Sorder model);

	public List<Sorder> querySale(Integer number);
	
}

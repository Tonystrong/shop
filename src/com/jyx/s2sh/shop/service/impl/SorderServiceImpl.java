package com.jyx.s2sh.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.Product;
import com.jyx.s2sh.shop.domain.Sorder;
import com.jyx.s2sh.shop.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService{

	@Override
	public Forder addForderByProduct(Forder forder, Product product) {
		
		for(Sorder sd : forder.getSorderList()) {
			if (sd.getProduct().getId().equals(product.getId())) {
				sd.setNumber(sd.getNumber()+1);
				sd.setPrice(sd.getPrice());
				return forder;
			}
		}
		forder.getSorderList().add(setProductToSorder(product));
		return forder;
	}
	
	@Override
	public Sorder setProductToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder updateSorder(Forder forder, Sorder model) {
		for(Sorder old:forder.getSorderList()) {
			if (old.getProduct().getId().equals(model.getProduct().getId())) {
				old.setNumber(model.getNumber());
				break;
			}
		}
		return forder;
	}

	@Override
	public List<Sorder> querySale(Integer number) {
		return sorderDao.querySale(number);
		
	}
	
}

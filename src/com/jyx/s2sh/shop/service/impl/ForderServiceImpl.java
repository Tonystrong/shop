package com.jyx.s2sh.shop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.Sorder;
import com.jyx.s2sh.shop.domain.Status;
import com.jyx.s2sh.shop.domain.User;
import com.jyx.s2sh.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	@Override
	public Forder getTotalPrice(Forder forder) {
		BigDecimal total = new BigDecimal(0.00);
		for(Sorder sorder : forder.getSorderList()) {
			total = total.add(sorder.getPrice().multiply(new BigDecimal(sorder.getNumber())));
		}
		forder.setTotal(total);
		return forder;
	}
	
	/*
	 * Forder [total=299.0,  sorderList=[com.jyx.s2sh.shop.domain.Sorder@3e84c1f9]]
	 * model [ name=小刚, phone=13812345678, remark=您有什么需要我们注意的？, 
		, post=45544, address=32435f你可兑换方式,]
	 */
	@Override
	public Forder saveForder(Forder forder, Forder model, User user) {
		forder.setName(model.getName());
		forder.setPhone(model.getPhone());
		forder.setRemark(model.getRemark());
		forder.setAddress(model.getAddress());
		forder.setPost(model.getPost());
		forder.setStatus(new Status(1));
		forder.setUser(user);
		List<Sorder> sorderList = forder.getSorderList();
		for(Sorder sorder : sorderList) {
			sorder.setForder(forder);
		}
		super.save(forder);	
		return forder;
	}

	@Override
	public void updateByOrderId(int id, int sid) {
		forderDao.updateByOrderId(id, sid);
	}

	
}

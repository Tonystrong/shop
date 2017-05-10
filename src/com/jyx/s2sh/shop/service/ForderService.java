package com.jyx.s2sh.shop.service;

import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.User;

public interface ForderService extends BaseService<Forder> {
	
	public Forder getTotalPrice(Forder forder);

	public Forder saveForder(Forder forder, Forder model, User user);

	void updateByOrderId(int id, int sid);
}

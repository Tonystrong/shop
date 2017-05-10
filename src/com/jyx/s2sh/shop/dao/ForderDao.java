package com.jyx.s2sh.shop.dao;

import com.jyx.s2sh.shop.domain.Forder;
import com.jyx.s2sh.shop.domain.User;

public interface ForderDao extends BaseDao<Forder> {
	
	public Forder getTotalPrice(Forder forder);

	public Forder saveForder(Forder forder, Forder model, User user);

	void updateByOrderId(int id, int sid);
}

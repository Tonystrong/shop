package com.jyx.s2sh.shop.dao;

import com.jyx.s2sh.shop.domain.User;

public interface UserDao extends BaseDao<User>{

	public User loginValidate(User model);
	
}

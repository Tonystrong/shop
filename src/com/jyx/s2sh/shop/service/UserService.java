package com.jyx.s2sh.shop.service;

import com.jyx.s2sh.shop.domain.User;

public interface UserService extends BaseService<User>{

	public User loginValidate(User model);
	
}

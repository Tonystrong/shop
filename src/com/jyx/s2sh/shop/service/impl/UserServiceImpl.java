package com.jyx.s2sh.shop.service.impl;

import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.domain.User;
import com.jyx.s2sh.shop.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Override
	public User loginValidate(User model) {
		return userDao.loginValidate(model);
	}


}

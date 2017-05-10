package com.jyx.s2sh.shop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.dao.UserDao;
import com.jyx.s2sh.shop.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	@Override
	public User loginValidate(User model) {
		String hql = "FROM User u where u.login=:login and u.pass=:pass";
		return (User) getSession().createQuery(hql)
					.setString("login", model.getLogin())
					.setString("pass", model.getPass())
					.uniqueResult();
	}


}

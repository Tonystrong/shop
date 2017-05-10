package com.jyx.s2sh.shop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.dao.AccountDao;
import com.jyx.s2sh.shop.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	public AccountDaoImpl() {
		super();
	}
}

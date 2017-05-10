package com.jyx.s2sh.shop.service.impl;

import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.domain.Account;
import com.jyx.s2sh.shop.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

	public AccountServiceImpl() {
		super();
	}
}

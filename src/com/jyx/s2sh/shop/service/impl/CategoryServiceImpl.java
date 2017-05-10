package com.jyx.s2sh.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.domain.Category;
import com.jyx.s2sh.shop.service.CategoryService;

@Service("categoryService")
@SuppressWarnings("unchecked")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	
	@Override
	public List<Category> queryJoinAccount(String name, int page, int size) {
		return categoryDao.queryJoinAccount(name, page, size);
	}
	
	@Override
	public Long getAllCount(String name) {
		return categoryDao.getAllCount(name);
	}
	

	@Override
	public List<Category> queryByHot(boolean hot) {
		return categoryDao.queryByHot(hot);
	}
}

package com.jyx.s2sh.shop.service;

import java.util.List;

import com.jyx.s2sh.shop.domain.Category;

public interface CategoryService extends BaseService<Category>{

	List<Category> queryJoinAccount(String name, int page, int size);

	Long getAllCount(String name);

	List<Category> queryByHot(boolean hot);
    
}

package com.jyx.s2sh.shop.dao;

import java.util.List;

import com.jyx.s2sh.shop.domain.Category;

public interface CategoryDao extends BaseDao<Category>{

	List<Category> queryJoinAccount(String name, int page, int size);

	Long getAllCount(String name);

	List<Category> queryByHot(boolean hot);
    
}

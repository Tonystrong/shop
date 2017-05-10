package com.jyx.s2sh.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyx.s2sh.shop.dao.CategoryDao;
import com.jyx.s2sh.shop.domain.Category;

@Repository("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	
	@Override
	public List<Category> queryJoinAccount(String name, int page, int size) {
		String hql = "from Category c left join fetch c.account where "
				+ "c.name like :name";
		List<Category> list = getSession()
				.createQuery(hql)
				.setString("name", "%" +name+ "%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
		return list;
	}
	
	@Override
	public Long getAllCount(String name) {
		String hql = "select count(c) FROM Category c where c.name like :name";
		return (Long) getSession().createQuery(hql)
				.setString("name", "%" +name+ "%")
				.uniqueResult();
	}
	

	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql = "FROM Category c where c.hot=:hot ";
		return getSession().createQuery(hql)
				.setBoolean("hot", hot)
				.list();
	}
}

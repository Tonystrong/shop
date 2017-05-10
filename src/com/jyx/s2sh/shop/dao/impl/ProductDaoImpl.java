package com.jyx.s2sh.shop.dao.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.dao.ProductDao;
import com.jyx.s2sh.shop.domain.Product;
import com.jyx.s2sh.shop.service.ProductService;
import com.jyx.s2sh.shop.utils.FileUploadUtilsImpl;

@Repository("productDao")
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
	
	@Override
	public List<Product> queryJoinCategory(String name, int page, int rows) {
		String hql = "FROM Product p left join fetch p.category "
				+ "where p.name like :name ";
		return getSession().createQuery(hql)
				.setString("name", "%" +name+ "%")
				.setFirstResult((page-1)*rows)
				.setMaxResults(rows)
				.list();
	}
	
	@Override
	public Long getProductCount(String name) {
		String hql = "select count(p) FROM Product p WHERE p.name like :name ";
		return (Long) getSession().createQuery(hql)
				.setString("name", "%" +name+ "%")
				.uniqueResult();
	}
	
	@Override
	public List<Product> queryProductByCid(int id) {
		String hql = "FROM Product p left join fetch p.category "
				+ "where p.commend=true and p.open=true and "
				+ "p.category.id=:id ORDER BY DATE DESC";
		return getSession().createQuery(hql)
				.setInteger("id", id)
				.setFirstResult(0)
				.setMaxResults(4)
				.list();
	}
}
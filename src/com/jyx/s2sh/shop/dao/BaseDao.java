package com.jyx.s2sh.shop.dao;

import java.util.List;

public interface BaseDao<T> {

	void save(T t);

	void update(T t);

	void delete(int id);

	T getById(int id);

	List<T> getAll();

	void deleteByIds(String ids);

}
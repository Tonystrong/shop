package com.jyx.s2sh.shop.service;

import java.util.List;

public interface BaseService<T> {

	void save(T t);

	void update(T t);

	void delete(int id);

	T getById(int id);

	List<T> getAll();

	void deleteByIds(String ids);

}
package com.jyx.s2sh.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.dao.AccountDao;
import com.jyx.s2sh.shop.dao.BaseDao;
import com.jyx.s2sh.shop.dao.CategoryDao;
import com.jyx.s2sh.shop.dao.ForderDao;
import com.jyx.s2sh.shop.dao.PayDao;
import com.jyx.s2sh.shop.dao.ProductDao;
import com.jyx.s2sh.shop.dao.SorderDao;
import com.jyx.s2sh.shop.dao.UserDao;
import com.jyx.s2sh.shop.service.BaseService;
import com.sun.org.apache.xml.internal.security.Init;

@Service("baseService")
@Lazy(true)
@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {
	private Class clazz;
	
	protected BaseDao<T> baseDao;
	@Resource(name="accountDao")
	protected AccountDao accountDao;
	@Resource(name="categoryDao")
	protected CategoryDao categoryDao;
	@Resource(name="forderDao")
	protected ForderDao forderDao;
	@Resource(name="payDao")
	protected PayDao payDao;
	@Resource(name="productDao")
	protected ProductDao productDao;
	@Resource(name="sorderDao")
	protected SorderDao sorderDao;
	@Resource(name="userDao")
	protected UserDao userDao;
	
	public BaseServiceImpl() {
		System.out.println("如果子类调用，则该方法得到子类的包括泛型在类的信息：" +
							this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println("============"+clazz);
	}
	
	@PostConstruct
	public void Init() throws Exception {
		String clazzName = clazz.getSimpleName();
		String fieldName = clazzName.substring(0, 1).toLowerCase() 
				+ clazzName.substring(1) + "Dao";
		Field clazzField = this.getClass().getSuperclass().getDeclaredField(fieldName);
		Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
		baseField.set(this, clazzField.get(this));
	}
	
	@Override
	public void save(T t) {
        baseDao.save(t);
    }
	
	
	@Override
	public void update(T t) {
		baseDao.update(t);
	}
	
	
	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}
	
	@Override
	public T getById(int id) {
        return (T) baseDao.getById(id);
    }
	
	
	@Override
	public List<T> getAll() {
        return baseDao.getAll();
    }
	
	@Override
	public void deleteByIds(String ids) {
		baseDao.deleteByIds(ids);
	}
}

package com.jyx.s2sh.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jyx.s2sh.shop.dao.BaseDao;
import com.jyx.s2sh.shop.service.BaseService;

@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class clazz;
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public BaseDaoImpl() {
		System.out.println("如果子类调用，则该方法得到子类的包括泛型在类的信息：" +
							this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println("=====Dao======="+clazz);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.jyx.s2sh.shop.service.impl.BaseService#save(T)
	 */
	@Override
	public void save(T t) {
        getSession().save(t);
    }
	
	/* (non-Javadoc)
	 * @see com.jyx.s2sh.shop.service.impl.BaseService#update(T)
	 */
	@Override
	public void update(T t) {
		getSession().update(t);
	}
	
	/* (non-Javadoc)
	 * @see com.jyx.s2sh.shop.service.impl.BaseService#delete(int)
	 */
	@Override
	public void delete(int id) {
		String hql = "DELETE FROM "+ clazz.getSimpleName() +" c where c.id=:id";
        getSession().createQuery(hql)
                    .setInteger("id", id)
                    .executeUpdate();
	}
	
	/* (non-Javadoc)
	 * @see com.jyx.s2sh.shop.service.impl.BaseService#getById(int)
	 */
	@Override
	public T getById(int id) {
        return (T) getSession().get(clazz, id);
    }
	
	/* (non-Javadoc)
	 * @see com.jyx.s2sh.shop.service.impl.BaseService#getAll()
	 */
	@Override
	public List<T> getAll() {
        String hql = "FROM "+ clazz.getSimpleName();
        return getSession().createQuery(hql).list();
    }
	
	@Override
	public void deleteByIds(String ids) {
		String hql = "delete from " +clazz.getSimpleName()+ " c where c.id in (" +ids+ ")";
		getSession().createQuery(hql).executeUpdate();
	}
}

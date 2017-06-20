package com.suben.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.suben.dao.inter.IBaseDao;
import com.suben.entity.User;

/**
 * @category add update delete find database
 * @author JDRY-SJM
 * @version 1.0
 * @param <T>
 */
@Component
public class BaseDao implements IBaseDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param obj
	 * @return boolean
	 * @category 增加对象
	 */
	public boolean save(Object obj) {
		System.out.println("==save==:" + obj.toString());
		Session session = this.sessionFactory.getCurrentSession();
		session.save(obj);
		session.flush();
		return true;
	}

	/**
	 * @param obj
	 * @return boolean
	 * @category 存在就更新，否则新增
	 */
	public boolean saveOrUpdate(Object obj) {
		System.out.println("==saveOrUpdate==:" + obj.toString());
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		return true;
	}

	/**
	 * @param obj
	 * @return boolean
	 * @category 更新对象
	 */
	public void update(Object obj) {
		System.out.println("==update==:" + obj.toString());
		this.sessionFactory.getCurrentSession().update(obj);
	}

	/**
	 * @param obj
	 * @category 删除对象
	 */
	public void delete(Object obj) {
		this.sessionFactory.getCurrentSession().delete(obj);
	}

	/**
	 * @param <T>
	 * @param entityName
	 * @return List<T>
	 * @category 查询所有对象
	 */
	public List<?> findAllByEntityName(String entityName) {
		List<?> listObjects = sessionFactory.getCurrentSession().createQuery("from " + entityName).list();
		return listObjects;
	}

	/**
	 * @param Class
	 *            clzss, Integer id
	 * @return Object
	 * @category 根据ID查询对象
	 */
	public Object getEntityObjById(Class<?> clzss, Integer id) {
		Object object = this.sessionFactory.getCurrentSession().load(clzss, id);
		return object;
	}

}

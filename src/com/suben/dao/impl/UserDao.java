package com.suben.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.suben.dao.inter.IUserDao;
import com.suben.entity.User;

@Component
public class UserDao extends BaseDao implements IUserDao {
	
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByNamePasswors(String userName, String password) {
		sessionFactory = super.getSessionFactory();
		Query query = sessionFactory.getCurrentSession().createQuery("from User user where userName=? and password=?");
		query.setParameter(0, userName);
		query.setParameter(1, password);
		List<User> listUsers = query.list();
		if(listUsers != null && listUsers.size() > 0){
			User user = (User) query.list().get(0);
			return user;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUserName(String userName) {
		sessionFactory = super.getSessionFactory();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from User user where userName=?");
		query.setParameter(0, userName);
		List<User> listUsers = query.list();
		if(listUsers != null && listUsers.size() > 0){
			User user = (User) query.list().get(0);
			return user;
		}else{
			return null;
		}
	}

}

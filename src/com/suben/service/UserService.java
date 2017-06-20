package com.suben.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.suben.dao.inter.IUserDao;
import com.suben.entity.User;
import com.suben.service.inter.IUserService;

@Service
public class UserService implements IUserService {
	@Resource
	public IUserDao userDao;
	
	public boolean isUserExist(String userName, String password) {
		if (userName != null && password != null)
			return (userDao.getUserByNamePasswors(userName, password) != null) ? true : false;
		else
			return false;
	}

	public User getUserByUserName(String userName){
		if(userName != null && !userName.equals("")){
			User user = userDao.getUserByUserName(userName);
			return user;
		}else{
			return null;
		}
	}

	@Override
	public boolean saveOrUpdateUser(User user) {
		return userDao.saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList(String string) {
		return (List<User>) userDao.findAllByEntityName(string);
	}
	
	@Override
	public User getUserByNameOrPwd(String userName, String password) {
		if(null != userName && null !=password){
			return userDao.getUserByNamePasswors(userName, password);
		}else if(null != userName && null ==password){
			return userDao.getUserByUserName(userName);
		}else {
			return null;
		}
	}
}

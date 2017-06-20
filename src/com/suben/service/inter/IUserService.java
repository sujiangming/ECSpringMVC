package com.suben.service.inter;

import java.util.List;

import com.suben.entity.User;

public interface IUserService {
	
	public boolean isUserExist(String userName, String password);

	public boolean saveOrUpdateUser(User user);

	public List<User> getUserList(String entityName);

	public User getUserByNameOrPwd(String userName, String password);
}

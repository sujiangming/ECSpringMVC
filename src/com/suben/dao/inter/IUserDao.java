package com.suben.dao.inter;

import com.suben.entity.User;

public interface IUserDao extends IBaseDao {
	public User getUserByNamePasswors(String userName, String password);
	public User getUserByUserName(String userName);
}

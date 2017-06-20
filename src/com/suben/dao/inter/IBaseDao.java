package com.suben.dao.inter;

import java.util.List;

public interface IBaseDao {
	
	public boolean save(Object obj);
	
	public void update(Object obj);
	
	public boolean saveOrUpdate(Object obj);

	public void delete(Object obj);

	public List<?> findAllByEntityName(String entityName);

	public Object getEntityObjById(Class<?> clzss, Integer id);
}

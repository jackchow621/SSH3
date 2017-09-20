package com.ghost.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	public Serializable save(T t);
	
	public void delete(T t);
	
	public void update(T t);
	
	public T get(Class<T> c,Serializable id);
	
	public List<T> find(String hql);
	
	public List<T> find(String hql,Map<String, Object> map);
}

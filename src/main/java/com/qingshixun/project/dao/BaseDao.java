package com.qingshixun.project.dao;

import java.io.Serializable;
import java.util.List;

import com.qingshixun.project.model.Account;

public interface BaseDao<T, PK extends Serializable> {
	T load(PK id);  
    T get(PK id);  
    List<T> findAll();  
    void persist(T entity);  
    PK save(T entity);
    void update(T entity); 
    void saveOrUpdate(T entity);  
    void delete(PK id);  
    
    void delete(List<PK> ids);
    void flush();
	List<T> queryByPage(String hql, PK offset, PK pageSize);

	PK getAllRowCount(String hql);
}

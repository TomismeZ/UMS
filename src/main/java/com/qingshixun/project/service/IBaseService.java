package com.qingshixun.project.service;

import java.io.Serializable;
import java.util.List;

import com.qingshixun.project.model.Account;
import com.qingshixun.project.model.PageBean;

public interface IBaseService<T, PK extends Serializable> {
	T load(PK id);  
    T get(PK id);  
    List<T> findAll();  
    void persist(T entity);  
    PK save(T entity);  
    void saveOrUpdate(T entity);  
    void delete(PK id); 
    
    void delete(List<PK> ids);
    void flush();
    
   	public PageBean<T> getPageBean(PK pageSize, PK page);
}

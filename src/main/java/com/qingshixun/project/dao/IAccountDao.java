package com.qingshixun.project.dao;

import java.util.List;

import com.qingshixun.project.model.Account;


public interface IAccountDao{
	
	Account load(Integer id);  
    Account get(Integer id);  
    List<Account> findAll();  
    void persist(Account entity);  
    Integer save(Account entity);
    void update(Account entity); 
    void saveOrUpdate(Account entity);  
    void delete(Integer id);  
    
    void delete(List<Integer> ids);
    void flush();
	public Account loginAccount(String username,String password);
	public Account findByName(String userName);
	
	List<Account> queryByPage(Integer offset, Integer pageSize);

	Integer getAllRowCount();
}

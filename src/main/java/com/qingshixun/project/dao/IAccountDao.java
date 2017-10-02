package com.qingshixun.project.dao;

import java.util.List;

import com.qingshixun.project.model.Account;


public interface IAccountDao extends BaseDao<Account, Integer> {
	public Account loginAccount(String username,String password);
	public Account findByName(String userName);
}

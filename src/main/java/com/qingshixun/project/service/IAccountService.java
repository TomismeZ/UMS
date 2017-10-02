package com.qingshixun.project.service;

import com.qingshixun.project.model.Account;
import com.qingshixun.project.model.PageBean;

public interface IAccountService extends IBaseService<Account, Integer>{
	
 
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Account loginAccount(String username,String password);
	/**
	 * 验证用户名是否重复
	 * @param userName 用户名
	 * @return
	 */
	public Account findByName(String userName);
}

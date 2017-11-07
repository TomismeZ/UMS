package com.qingshixun.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.project.dao.IAccountDao;
import com.qingshixun.project.model.Account;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDao accountDao;
	@Override
	public Account load(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account get(Integer id) {
		// TODO Auto-generated method stub
		return accountDao.get(id);
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}

	@Override
	public void persist(Account entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer save(Account entity) {
		// TODO Auto-generated method stub
		return accountDao.save(entity);
	}

	@Override
	public void saveOrUpdate(Account entity) {
		accountDao.saveOrUpdate(entity);

	}

	@Override
	public void delete(Integer id) {
		accountDao.delete(id);
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}
	
	  /**
		 * 
		 * @param pageSize为每页显示的记录数
		 * @param page为当前显示的网页
		 * @return 返回一个PageBean对象
		 */
	@Override
	public PageBean<Account> getPageBean(Integer pageSize, Integer page) {
		
		PageBean<Account> pageBean=new PageBean<Account>();
		int allRows=accountDao.getAllRowCount();
		int totalPage=pageBean.getTotalPages(pageSize, allRows);
		int currentPage=pageBean.getCurPage(page);
		int offset=pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Account> list=accountDao.queryByPage(offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public Account loginAccount(String username, String password) {
		// TODO Auto-generated method stub
		return accountDao.loginAccount(username, password);
	}

	@Override
	public Account findByName(String userName) {
		// TODO Auto-generated method stub
		return accountDao.findByName(userName);
	}

	@Override
	public void delete(List<Integer> ids) {
		accountDao.delete(ids);
		
	}

}

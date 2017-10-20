package com.qingshixun.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.project.dao.IJurisdictionDao;
import com.qingshixun.project.model.Jurisdiction;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.Role;
import com.qingshixun.project.service.IJurisdictionService;

@Service("jurisdictionService")
public class JurisdictionServiceImpl implements IJurisdictionService{

	@Autowired
	private IJurisdictionDao jurisdictionDao;
	@Override
	public Jurisdiction load(Integer id) {
		// TODO Auto-generated method stub
		return jurisdictionDao.load(id);
	}

	@Override
	public Jurisdiction get(Integer id) {
		// TODO Auto-generated method stub
		return jurisdictionDao.get(id);
	}

	@Override
	public List<Jurisdiction> findAll() {
		// TODO Auto-generated method stub
		return jurisdictionDao.findAll();
	}

	@Override
	public void persist(Jurisdiction entity) {
		jurisdictionDao.persist(entity);
		
	}

	@Override
	public Integer save(Jurisdiction entity) {
		// TODO Auto-generated method stub
		return jurisdictionDao.save(entity);
	}

	@Override
	public void saveOrUpdate(Jurisdiction entity) {
		jurisdictionDao.saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		jurisdictionDao.delete(id);
		
	}

	@Override
	public void flush() {
		jurisdictionDao.flush();
		
	}

	@Override
	public Jurisdiction findByName(String name) {
		// TODO Auto-generated method stub
		return jurisdictionDao.findByName(name);
	}

	/**
	 * 
	 * @param pageSize为每页显示的记录数
	 * @param page为当前显示的网页
	 * @return 返回一个PageBean对象
	 */
	@Override
	public PageBean<Jurisdiction> getPageBean(Integer pageSize, Integer page) {
		PageBean<Jurisdiction> pageBean=new PageBean<Jurisdiction>();
		String hql="from Jurisdiction";
		int allRows=jurisdictionDao.getAllRowCount(hql);
		int totalPage=pageBean.getTotalPages(pageSize, allRows);
		int currentPage=pageBean.getCurPage(page);
		int offset=pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Jurisdiction> list=jurisdictionDao.queryByPage(hql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public void delete(List<Integer> ids) {
	jurisdictionDao.delete(ids);
		
	}

}

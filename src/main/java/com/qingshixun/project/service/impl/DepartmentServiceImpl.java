package com.qingshixun.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.project.dao.IDepartmentDao;
import com.qingshixun.project.model.Department;
import com.qingshixun.project.model.Jurisdiction;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentDao departDao;
	@Override
	public Department load(Integer id) {
		// TODO Auto-generated method stub
		return departDao.load(id);
	}

	@Override
	public Department get(Integer id) {
		// TODO Auto-generated method stub
		return departDao.get(id);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departDao.findAll();
	}

	@Override
	public void persist(Department entity) {
		departDao.persist(entity);
		
	}

	@Override
	public Integer save(Department entity) {
		// TODO Auto-generated method stub
		return departDao.save(entity);
	}

	@Override
	public void saveOrUpdate(Department entity) {
		departDao.saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		departDao.delete(id);
		
	}

	@Override
	public void flush() {
		departDao.flush();
		
	}

	@Override
	public Department findByName(String name) {
		// TODO Auto-generated method stub
		return departDao.findByName(name);
	}

	/**
	 * 
	 * @param pageSize为每页显示的记录数
	 * @param page为当前显示的网页
	 * @return 返回一个PageBean对象
	 */
	@Override
	public PageBean<Department> getPageBean(Integer pageSize, Integer page) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean=new PageBean<Department>();
		String hql="from Department";
		int allRows=departDao.getAllRowCount(hql);
		int totalPage=pageBean.getTotalPages(pageSize, allRows);
		int currentPage=pageBean.getCurPage(page);
		int offset=pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Department> list=departDao.queryByPage(hql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public void delete(List<Integer> ids) {
		departDao.delete(ids);
		
	}

	

}

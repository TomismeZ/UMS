package com.qingshixun.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.project.dao.IRoleDao;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.Role;
import com.qingshixun.project.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public Role load(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.load(id);
	}

	@Override
	public Role get(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.get(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public void persist(Role entity) {
		roleDao.persist(entity);
		
	}

	@Override
	public Integer save(Role entity) {
		
		return roleDao.save(entity);
	}

	@Override
	public void saveOrUpdate(Role entity) {
		roleDao.saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		roleDao.delete(id);
		
	}

	@Override
	public void flush() {
		roleDao.flush();
		
	}

	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return roleDao.findByName(name);
	}

	/**
	 * 
	 * @param pageSize为每页显示的记录数
	 * @param page为当前显示的网页
	 * @return 返回一个PageBean对象
	 */
	@Override
	public PageBean<Role> getPageBean(Integer pageSize, Integer page) {
		// TODO Auto-generated method stub
		PageBean<Role> pageBean=new PageBean<Role>();
		String hql="from Role";
		int allRows=roleDao.getAllRowCount(hql);
		int totalPage=pageBean.getTotalPages(pageSize, allRows);
		int currentPage=pageBean.getCurPage(page);
		int offset=pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Role> list=roleDao.queryByPage(hql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public void delete(List<Integer> ids) {
		roleDao.delete(ids);
		
	}

}

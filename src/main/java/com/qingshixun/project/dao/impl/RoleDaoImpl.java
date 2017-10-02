package com.qingshixun.project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.dao.IRoleDao;
import com.qingshixun.project.model.Role;

@Repository("roleDao")
public class RoleDaoImpl implements IRoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取sesion
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Role load(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().load(Role.class, id);
	}

	@Override
	public Role get(Integer id) {
		
		return getCurrentSession().get(Role.class, id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("FROM Role").getResultList();
	}

	@Override
	public void persist(Role entity) {
		getCurrentSession().persist(entity);

	}

	@Override
	public Integer save(Role entity) {
		// TODO Auto-generated method stub
		return (Integer) getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Role entity) {
		getCurrentSession().saveOrUpdate(entity);

	}

	@Override
	public void delete(Integer id) {
		Role role = getCurrentSession().get(Role.class, id);
		if(role!=null){
			getCurrentSession().delete(role);
		}
//		getCurrentSession().createQuery("DELETE FROM Role WHERE id=?").setParameter(0, id);

	}

	@Override
	public void flush() {
		getCurrentSession().flush();

	}

	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return (Role) getCurrentSession().createQuery("FROM Role WHERE name=?").setParameter(0, name).getSingleResult();
	}

	 /**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
	@Override
	public List<Role> queryByPage(String hql, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		List<Role> list=null;
		try {
			list=getCurrentSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			list=null;
		}finally{
			if(getCurrentSession()!=null&&getCurrentSession().isOpen()){
				getCurrentSession().close();
			}
			
		}
		return list;
	}

	/**
	 * 通过hql语句得到数据库中记录总数
	 */
	@Override
	public Integer getAllRowCount(String hql) {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery(hql).getResultList().size();
	}

}

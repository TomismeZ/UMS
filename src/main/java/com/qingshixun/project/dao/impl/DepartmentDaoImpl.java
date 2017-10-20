package com.qingshixun.project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.dao.IDepartmentDao;
import com.qingshixun.project.model.Department;
import com.qingshixun.project.model.Jurisdiction;

@Repository("")
public class DepartmentDaoImpl implements IDepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取sesion
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Department load(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().load(Department.class, id);
	}

	@Override
	public Department get(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().get(Department.class, id);
	}

	@Override
	public List<Department> findAll() {
			
		return getCurrentSession().createQuery("FROM Department").getResultList();
	}

	@Override
	public void persist(Department entity) {
		getCurrentSession().persist(entity);

	}

	@Override
	public Integer save(Department entity) {
		return (Integer) getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Department entity) {
		getCurrentSession().saveOrUpdate(entity);

	}

	@Override
	public void delete(Integer id) {
		Department department = get(id);
		if(department!=null){
			/*getCurrentSession().createSQLQuery("delete from t_user where department_id =?").setParameter(0, id);*/
			getCurrentSession().delete(department);
		}
	}

	@Override
	public void flush() {
		getCurrentSession().flush();

	}
	@Override
	public Department findByName(String name) {
		
		return (Department) getCurrentSession().createQuery("FROM Department WHERE name=?").setParameter(0, name).getSingleResult();
	}
	
	/**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
	@Override
	public List<Department> queryByPage(String hql, Integer offset, Integer pageSize) {
		List<Department> list=null;
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
		return getCurrentSession().createQuery(hql).getResultList().size();
	}
	@Override
	public void update(Department entity) {
		getCurrentSession().update(entity);
		
	}
	@Override
	public void delete(List<Integer> ids) {
		String hql="delete from Department where id IN (:idd)";
		getCurrentSession().createQuery(hql).setParameterList("idd",ids).executeUpdate();
		
	}

}

package com.qingshixun.project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qingshixun.project.dao.IJurisdictionDao;
import com.qingshixun.project.model.Jurisdiction;

@Repository("jurisdictionDao")
public class JurisdictionDaoImpl implements IJurisdictionDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取sesion
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Jurisdiction load(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().load(Jurisdiction.class, id);
	}

	@Override
	public Jurisdiction get(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().get(Jurisdiction.class, id);
	}

	@Override
	public List<Jurisdiction> findAll() {
		
		Query createQuery = getCurrentSession().createQuery("FROM Jurisdiction");
		List resultList = createQuery.getResultList();
		return resultList;
	}

	@Override
	public void persist(Jurisdiction entity) {
		getCurrentSession().persist(entity);
		
	}

	@Override
	public Integer save(Jurisdiction entity) {
			
		return (Integer) getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Jurisdiction entity) {
		getCurrentSession().saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		Jurisdiction jurisdiction = getCurrentSession().get(Jurisdiction.class, id);
		if(jurisdiction!=null){
			getCurrentSession().delete(jurisdiction);
		}
	}

	@Override
	public void flush() {
		getCurrentSession().flush();
		
	}

	@Override
	public Jurisdiction findByName(String name) {
		// TODO Auto-generated method stub
		return (Jurisdiction) getCurrentSession().createQuery("FROM Jurisdiction WHERE name=?").setParameter(0, name).getSingleResult();
	}

	/**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
	@Override
	public List<Jurisdiction> queryByPage(String hql, Integer offset, Integer pageSize) {
		List<Jurisdiction> list=null;
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
	public void update(Jurisdiction entity) {
		getCurrentSession().update(entity);
		
	}

}

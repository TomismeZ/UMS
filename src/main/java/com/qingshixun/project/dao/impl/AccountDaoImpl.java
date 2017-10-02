package com.qingshixun.project.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.dao.IAccountDao;
import com.qingshixun.project.model.Account;


@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取sesion
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Account load(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().load(Account.class, id);
	}

	@Override
	public Account get(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().get(Account.class, id);
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("FROM Account").getResultList();
	}

	@Override
	public void persist(Account entity) {
		getCurrentSession().persist(entity);

	}

	@Override
	public Integer save(Account entity) {
		// TODO Auto-generated method stub
		return (Integer) getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Account entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(Integer id) {
		Account account = getCurrentSession().get(Account.class, id);
		if(account!=null){
			getCurrentSession().delete(account);
		}
	}

	@Override
	public void flush() {
		getCurrentSession().flush();

	}
	
	 /**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
	@Override
	public List<Account> queryByPage(String hql, Integer offset, Integer pageSize) {
		List<Account> list=null;
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
		Integer allRows=0;
		allRows = getCurrentSession().createQuery(hql).getResultList().size();
		return allRows;
	}
	@Override
	public Account loginAccount(String username, String password) {
		
		Query query = getCurrentSession().createQuery("FROM Account WHERE userName=? AND password=?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		
		return (Account) query.getSingleResult();
	}
	@Override
	public Account findByName(String userName) {
		// TODO Auto-generated method stub
		return (Account) getCurrentSession().createQuery("FROM Account WHERE userName=?").setParameter(0, userName).getSingleResult();
	}

}

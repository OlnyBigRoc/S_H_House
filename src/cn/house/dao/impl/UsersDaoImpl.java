package cn.house.dao.impl;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.house.dao.HibernateSessionFactory;
import cn.house.dao.IUsersDao;
import cn.house.entity.Users;

public class UsersDaoImpl implements IUsersDao{

	public boolean insert(Users users) {
		Transaction tx=null;
		try {
			Session session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			session.save(users);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return false;
	}
	public Users login(Users users) {
		Users user=null;
		try {
			String hql="from Users where name=:name and password=:password";
			Session session=HibernateSessionFactory.getSession();
			user=(Users)session.createQuery(hql).setProperties(users).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return user;
	}
}

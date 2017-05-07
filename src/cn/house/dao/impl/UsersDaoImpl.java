package cn.house.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.house.dao.HibernateSessionFactory;
import cn.house.dao.IUsersDao;
import cn.house.entity.Users;

public class UsersDaoImpl implements IUsersDao {

	//注册
	public boolean insert(Users users) {
		Transaction tx = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(users);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSession();
		}
		return false;
	}

	//登录
	public Users login(Users users) {
		Users user = null;
		try {
			String hql = "from Users where name=:name and password=:password";
			Session session = HibernateSessionFactory.getSession();
			user = (Users) session.createQuery(hql).setProperties(users)
					.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return user;
	}
	//检查用户名是否可用
	public boolean checkName(String name) {
		System.out.println("userdaoimpl "+ name);
		String hql="from Users where name=?";
		List<Users> usersList=null;
		try {
			Session session=HibernateSessionFactory.getSession();
			usersList = session.createQuery(hql).setString(0, name).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		if(usersList.size()==0){
			return true;
		}
		return false;
	}
}

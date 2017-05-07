package cn.house.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import cn.house.dao.HibernateSessionFactory;
import cn.house.dao.IHouseDao;
import cn.house.entity.House;
import cn.house.entity.Street;
import cn.house.entity.Tj;
import cn.house.entity.Types;

public class HouseDaoImpl implements IHouseDao {

	// 查询所有房屋类型
	public List<Types> selectTypesAll() {
		List<Types> typesList = null;
		try {
			typesList = new ArrayList<Types>();
			String hql = "from Types";
			Session session = HibernateSessionFactory.getSession();
			typesList = session.createQuery(hql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return typesList;
	}

	//根据条件and页码查询房屋信息
	public List<House> selectHouseByPageNoAndTj(int pageNo, Tj tj) {
		List<House> houseList = null;
		StringBuffer hql = null;
		Session session = null;
		try {
			houseList = new ArrayList<House>();
			hql = new StringBuffer("from House where 1=1");
			// 标题
			if (tj.getFloorage() != null && tj.getTitle().trim().length() != 0) {
				hql.append(" and title like '%" + tj.getTitle() + "%' ");
			}
			// 价格
			if (tj.getPrice()!= null && tj.getPrice().trim().length()!=0) {
				System.out.println("HouseDaoImpl价格"+tj.getPrice());
				String[] price = tj.getPrice().split("-");
				short start = Short.parseShort(price[0]);
				if (price.length > 1) {
					short end = Short.parseShort(price[1]);
					hql.append(" and price >=" + start + " and price<=" + end);
				} else {
					hql.append(" and price >=" + start);
				}
			}

			// 房屋位置
			if (tj.getStreetId() != 0) {
				hql.append(" and street.id=" + tj.getStreetId());
			}

			// 房型
			if (tj.getTypesId() != 0) {
				hql.append(" and types.id=" + tj.getTypesId());
			}
			// 面积
			if (tj.getFloorage() != null && tj.getFloorage().trim().length() !=0) {
				String[] floorage = tj.getFloorage().split("-");
				short start = Short.parseShort(floorage[0]);
				if (floorage.length > 1) {
					short end = Short.parseShort(floorage[1]);
					hql.append(" and floorage >=" + start + " and floorage<="
							+ end);
				} else {
					hql.append(" and floorage >=" + start);
				}
			}
			session = HibernateSessionFactory.getSession();
			houseList = session.createQuery(hql.toString())
					.setFirstResult((pageNo - 1) * 5).setMaxResults(5).list();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return houseList;
	}

	// 查询所有街道
	public List<Street> selectStreetAll() {
		List<Street> streetList = null;
		try {
			streetList = new ArrayList<Street>();
			String hql = "from Street";
			Session session = HibernateSessionFactory.getSession();
			streetList = session.createQuery(hql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return streetList;
	}

	// 根据条件查询总页数
	public int selectSumPageByTj(Tj tj) {
		StringBuffer hql = new StringBuffer(
				"select count(*) from House where 1=1 ");
		long sum = 0;
		try {
			Session session = HibernateSessionFactory.getSession();
			// 标题
			if (tj.getFloorage() != null && tj.getTitle().trim().length() != 0) {
				hql.append(" and title like '%" + tj.getTitle() + "%' ");
			}
			// 价格
			if (tj.getPrice() != null && tj.getPrice().trim().length() != 0) {
				String[] price = tj.getPrice().split("-");
				short start = Short.parseShort(price[0]);
				if (price.length > 1) {
					short end = Short.parseShort(price[1]);
					hql.append(" and price >=" + start + " and price<=" + end);
				} else {
					hql.append(" and price >=" + start);
				}
			}

			// 房屋位置
			if (tj.getStreetId() != 0) {
				hql.append(" and street.id=" + tj.getStreetId());
			}

			// 房型
			if (tj.getTypesId() != 0) {
				hql.append(" and types.id=" + tj.getTypesId());
			}
			// 面积
			if (tj.getFloorage() != null && tj.getFloorage().trim().length()!=0) {
				String[] floorage = tj.getFloorage().split("-");
				short start = Short.parseShort(floorage[0]);
				if (floorage.length > 1) {
					short end = Short.parseShort(floorage[1]);
					hql.append(" and floorage >=" + start + " and floorage<="
							+ end);
				} else {
					hql.append(" and floorage >=" + start);
				}
			}
			sum = (Long) session.createQuery(hql.toString()).uniqueResult();
		} catch (HibernateException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		// 返回总页数
		int sumPage=(int) (sum % 5 == 0 ? sum / 5 : sum / 5 + 1);
		return sumPage;
	}
}

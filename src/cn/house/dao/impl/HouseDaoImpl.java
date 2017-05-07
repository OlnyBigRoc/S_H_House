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

	// ��ѯ���з�������
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

	//��������andҳ���ѯ������Ϣ
	public List<House> selectHouseByPageNoAndTj(int pageNo, Tj tj) {
		List<House> houseList = null;
		StringBuffer hql = null;
		Session session = null;
		try {
			houseList = new ArrayList<House>();
			hql = new StringBuffer("from House where 1=1");
			// ����
			if (tj.getFloorage() != null && tj.getTitle().trim().length() != 0) {
				hql.append(" and title like '%" + tj.getTitle() + "%' ");
			}
			// �۸�
			if (tj.getPrice()!= null && tj.getPrice().trim().length()!=0) {
				System.out.println("HouseDaoImpl�۸�"+tj.getPrice());
				String[] price = tj.getPrice().split("-");
				short start = Short.parseShort(price[0]);
				if (price.length > 1) {
					short end = Short.parseShort(price[1]);
					hql.append(" and price >=" + start + " and price<=" + end);
				} else {
					hql.append(" and price >=" + start);
				}
			}

			// ����λ��
			if (tj.getStreetId() != 0) {
				hql.append(" and street.id=" + tj.getStreetId());
			}

			// ����
			if (tj.getTypesId() != 0) {
				hql.append(" and types.id=" + tj.getTypesId());
			}
			// ���
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

	// ��ѯ���нֵ�
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

	// ����������ѯ��ҳ��
	public int selectSumPageByTj(Tj tj) {
		StringBuffer hql = new StringBuffer(
				"select count(*) from House where 1=1 ");
		long sum = 0;
		try {
			Session session = HibernateSessionFactory.getSession();
			// ����
			if (tj.getFloorage() != null && tj.getTitle().trim().length() != 0) {
				hql.append(" and title like '%" + tj.getTitle() + "%' ");
			}
			// �۸�
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

			// ����λ��
			if (tj.getStreetId() != 0) {
				hql.append(" and street.id=" + tj.getStreetId());
			}

			// ����
			if (tj.getTypesId() != 0) {
				hql.append(" and types.id=" + tj.getTypesId());
			}
			// ���
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
		// ������ҳ��
		int sumPage=(int) (sum % 5 == 0 ? sum / 5 : sum / 5 + 1);
		return sumPage;
	}
}

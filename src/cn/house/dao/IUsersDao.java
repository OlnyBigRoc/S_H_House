package cn.house.dao;

import cn.house.entity.Users;

public interface IUsersDao {

	/**
	 * ��¼
	 * @param users���û�����
	 * @return Users
	 */
	Users login(Users users);
	/**
	 * ע��
	 * @param users���û�����
	 * @return boolean
	 */
	boolean insert(Users users);
	/**
	 * ���name�Ƿ�ռ��
	 * @param name������ַ� 
	 * @return boolean
	 */
	boolean checkName(String name);
}

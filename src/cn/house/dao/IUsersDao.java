package cn.house.dao;

import cn.house.entity.Users;

public interface IUsersDao {

	/**
	 * 登录
	 * @param users：用户集合
	 * @return Users
	 */
	Users login(Users users);
	/**
	 * 注册
	 * @param users：用户集合
	 * @return boolean
	 */
	boolean insert(Users users);
	/**
	 * 检查name是否占用
	 * @param name：检查字符 
	 * @return boolean
	 */
	boolean checkName(String name);
}

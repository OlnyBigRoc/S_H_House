package cn.house.dao;

import java.util.List;


import cn.house.entity.House;
import cn.house.entity.Street;
import cn.house.entity.Tj;
import cn.house.entity.Types;

public interface IHouseDao {

	/**
	 * 查询所有Street
	 * @return List<Street>
	 */
	List<Street>selectStreetAll();
	/**
	 * 查询所有Types
	 * @return List<Types>
	 */
	List<Types>selectTypesAll();
	/**
	 * 根据条件查询页数
	 * @param tj：条件
	 * @return int SumPage
	 */
	int selectSumPageByTj(Tj tj);
	/**
	 * 根据条件和页码查询房屋信息
	 * @param pageNo
	 * @param tj
	 * @return
	 */
	List<House>selectHouseByPageNoAndTj (int pageNo ,Tj tj);
}

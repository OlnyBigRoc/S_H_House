package cn.house.dao;

import java.util.List;


import cn.house.entity.House;
import cn.house.entity.Street;
import cn.house.entity.Tj;
import cn.house.entity.Types;

public interface IHouseDao {

	/**
	 * ��ѯ����Street
	 * @return List<Street>
	 */
	List<Street>selectStreetAll();
	/**
	 * ��ѯ����Types
	 * @return List<Types>
	 */
	List<Types>selectTypesAll();
	/**
	 * ����������ѯҳ��
	 * @param tj������
	 * @return int SumPage
	 */
	int selectSumPageByTj(Tj tj);
	/**
	 * ����������ҳ���ѯ������Ϣ
	 * @param pageNo
	 * @param tj
	 * @return
	 */
	List<House>selectHouseByPageNoAndTj (int pageNo ,Tj tj);
}

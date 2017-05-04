package cn.house.action;

import java.util.List;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.house.dao.IHouseDao;
import cn.house.dao.impl.HouseDaoImpl;
import cn.house.entity.Street;

/**
 * 查询所有街道
 * @author BigRoc
 *
 */
public class StreetAction extends ActionSupport {

	IHouseDao houseDao=new HouseDaoImpl();
	@Override
	public String execute() throws Exception {
		List<Street>streetList=houseDao.selectStreetAll();
		ServletActionContext.getRequest().getSession().setAttribute("streetList", streetList);
		return "StreetSuccess";
	}
	
}

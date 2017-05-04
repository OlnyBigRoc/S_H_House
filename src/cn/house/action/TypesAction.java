package cn.house.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.house.dao.IHouseDao;
import cn.house.dao.impl.HouseDaoImpl;
import cn.house.entity.Types;

import com.opensymphony.xwork2.ActionSupport;

public class TypesAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		IHouseDao ihd=new HouseDaoImpl();
		List<Types>typesList=ihd.selectTypesAll();
		ServletActionContext.getRequest().getSession().setAttribute("typesList", typesList);
		return "TypeSuccess";
	}
}

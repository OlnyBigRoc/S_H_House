package cn.house.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.house.dao.IHouseDao;
import cn.house.dao.impl.HouseDaoImpl;
import cn.house.entity.House;
import cn.house.entity.Tj;

public class HouseAction extends ActionSupport {

	private String title; // 标题
	private String typeId; // 户型
	private String floorage; // 面积
	private String price; // 价格
	private String houseDate; // 房产证日期
	private String district_id; // 位置
	private String contact; // 联系方式
	private String description; // 详细信息
	private String street_id;
	private String pageStr;

	IHouseDao ihd = new HouseDaoImpl();

	@Override
	public String execute() throws Exception {
		Tj tj = new Tj();
		tj.setTitle(title);
		tj.setPrice(price);
		if (street_id != null) {
			tj.setStreetId(Short.parseShort(street_id));
		}
		if (street_id != null) {
			tj.setTypesId(Short.parseShort(typeId));
		}
		int sumPage = (int) ihd.selectSumPageByTj(tj);
		int pageNo=1;
		if(pageStr!=null){
			pageNo= Integer.parseInt(pageStr);
		}
		if (pageNo > sumPage) {
			pageNo = sumPage;
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
		
		List<House>houseList=ihd.selectHouseByPageNoAndTj(pageNo, tj);
		Map<String, Object> session = null;
		session = ActionContext.getContext().getSession();
		ServletActionContext.getRequest().getSession()
				.setAttribute("pageNo", pageNo);
		ServletActionContext.getRequest().getSession()
				.setAttribute("sumPage", sumPage);
		session.put("houseList", houseList);
		return "ok";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getFloorage() {
		return floorage;
	}

	public void setFloorage(String floorage) {
		this.floorage = floorage;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getHouseDate() {
		return houseDate;
	}

	public void setHouseDate(String houseDate) {
		this.houseDate = houseDate;
	}

	public String getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStreet_id() {
		return street_id;
	}

	public void setStreet_id(String street_id) {
		this.street_id = street_id;
	}

	public String getPageStr() {
		return pageStr;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

}

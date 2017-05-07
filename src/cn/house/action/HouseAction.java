package cn.house.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.house.dao.IHouseDao;
import cn.house.dao.impl.HouseDaoImpl;
import cn.house.entity.House;
import cn.house.entity.Tj;

public class HouseAction extends ActionSupport {

	private String title; 		// 标题
	private String type_id; 	// 户型id
	private String floorage; 	// 面积
	private String price; 		// 价格
	private String houseDate; 	// 房产证日期
	private String district_id; // 位置
	private String contact; 	// 联系方式
	private String description; // 详细信息
	private String street_id;	//街道id
	private String pageStr; 	// 当前页

	IHouseDao ihd = new HouseDaoImpl();

	@Override
	public String execute() throws Exception {
		System.out.println("title\t"+title);
		System.out.println("price\t"+price);
		System.out.println("street_id\t"+street_id);
		System.out.println("type_id\t"+type_id);
		System.out.println("floorage\t"+floorage);
		
		
		Tj tj = new Tj();
		tj.setTitle(title);
		tj.setPrice(price);
		tj.setFloorage(floorage);
		if (street_id != null &&street_id.trim().length()!=0) {
			tj.setStreetId(Short.parseShort(street_id));
		}
		if (type_id != null && type_id.trim().length() !=0) {
			System.err.println("type");
			tj.setTypesId(Short.parseShort(type_id));
		}
		int sumPage = ihd.selectSumPageByTj(tj);
		int pageNo = 1;
		if (pageStr != null) {
			pageNo = Integer.parseInt(pageStr);
		}
		if (pageNo > sumPage) {
			pageNo = sumPage;
		}
		if (pageNo < 1) {
			pageNo = 1;
		}

		List<House> houseList = ihd.selectHouseByPageNoAndTj(pageNo, tj);
		ServletActionContext.getRequest().getSession()
				.setAttribute("pageNo", pageNo);
		ServletActionContext.getRequest().getSession()
				.setAttribute("sumPage", sumPage);
		ServletActionContext.getRequest().getSession()
				.setAttribute("houseList", houseList);

		return "ok";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
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

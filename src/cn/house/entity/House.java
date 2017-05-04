package cn.house.entity;

import java.util.Date;

/**
 * House entity. @author MyEclipse Persistence Tools
 */

public class House implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private Types types;
	private Street street;
	private String title;
	private String description;
	private Integer price;
	private Date pubdate;
	private Short floorage;
	private String contact;

	// Constructors

	/** default constructor */
	public House() {
	}

	/** minimal constructor */
	public House(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public House(Integer id, Users users, Types types, Street street,
			String title, String description, Integer price, Date pubdate,
			Short floorage, String contact) {
		this.id = id;
		this.users = users;
		this.types = types;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorage = floorage;
		this.contact = contact;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Types getTypes() {
		return this.types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public Street getStreet() {
		return this.street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Short getFloorage() {
		return this.floorage;
	}

	public void setFloorage(Short floorage) {
		this.floorage = floorage;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
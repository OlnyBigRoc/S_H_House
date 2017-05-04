package cn.house.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Street entity. @author MyEclipse Persistence Tools
 */

public class Street implements java.io.Serializable {

	// Fields

	private Short id;
	private District district;
	private String name;
	private Set houses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Street() {
	}

	/** minimal constructor */
	public Street(Short id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Street(Short id, District district, String name, Set houses) {
		this.id = id;
		this.district = district;
		this.name = name;
		this.houses = houses;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getHouses() {
		return this.houses;
	}

	public void setHouses(Set houses) {
		this.houses = houses;
	}

}
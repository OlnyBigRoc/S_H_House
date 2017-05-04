package cn.house.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * District entity. @author MyEclipse Persistence Tools
 */

public class District implements java.io.Serializable {

	// Fields

	private Short id;
	private String name;
	private Set streets = new HashSet(0);

	// Constructors

	/** default constructor */
	public District() {
	}

	/** minimal constructor */
	public District(Short id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public District(Short id, String name, Set streets) {
		this.id = id;
		this.name = name;
		this.streets = streets;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStreets() {
		return this.streets;
	}

	public void setStreets(Set streets) {
		this.streets = streets;
	}

}
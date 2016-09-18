package com.lbartal.wishlist.model;

public class Wish {

	private String name;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	Wish(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Wish() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

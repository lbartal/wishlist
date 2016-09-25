package com.lbartal.wishlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wish_id;
	private String name;
	private String description;

	public long getId() {
		return wish_id;
	}

	public void setId(int wish_id) {
		this.wish_id = wish_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	Wish(String name, String description) {
		// this.id = id;
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

package com.lbartal.wishlist.model;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Wishlist {

	private List<Wish> wishlist = new ArrayList<Wish>();
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public List<Wish> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<Wish> wishlist) {
		this.wishlist = wishlist;
	}

	public Long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

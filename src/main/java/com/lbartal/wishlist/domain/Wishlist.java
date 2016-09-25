package com.lbartal.wishlist.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Wishlist {

	public Wishlist() {

	}

	public Wishlist(Wishlist wl) {
		this.wishlist = wl.getWishlist();
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Wish> wishlist = new ArrayList<Wish>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Override
	public String toString() {
		return "Whishlist " + id + " Wishes count " + wishlist.size();

	}
}

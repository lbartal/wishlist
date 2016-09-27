package com.lbartal.wishlist.service;

import com.lbartal.wishlist.domain.Wishlist;

public interface WishlistService {

	// returns the Wishlist of logged in User or the User identified by id
	public Wishlist get(Long userId);

	// add Wishlist to the logged in User if has no wishlist yet.
	public Wishlist add(Wishlist wishlist) throws Exception;
}

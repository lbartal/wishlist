package com.lbartal.wishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbartal.wishlist.domain.Wishlist;
import com.lbartal.wishlist.service.WishlistServiceImpl;

@RestController
public class WishlistController {

	@Autowired
	private WishlistServiceImpl wishlistServiceImpl;

	// getting wishlist of logged in user or the user identified by id.
	@RequestMapping("/wishlist")
	public Wishlist get(@RequestParam(value = "id", required = false) Long id) {
		return wishlistServiceImpl.get(id);
	}

	@RequestMapping(value = "/wishlist", method = RequestMethod.POST)
	public Wishlist create(@RequestBody Wishlist wishlistRB) throws Exception {
		return wishlistServiceImpl.add(wishlistRB);

	}

	@RequestMapping(value = "/wishlist", method = RequestMethod.PUT)
	public ResponseEntity<Wishlist> update(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<Wishlist>(wishlist, HttpStatus.OK);
	}
}
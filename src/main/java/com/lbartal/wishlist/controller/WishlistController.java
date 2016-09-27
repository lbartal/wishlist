package com.lbartal.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbartal.wishlist.domain.Wishlist;
import com.lbartal.wishlist.repository.WishlistRepository;

@RestController
public class WishlistController {

	@Autowired
	private WishlistRepository wishlistRepository;

	@RequestMapping("/wishlist")
	public List<Wishlist> get(@RequestParam(value = "name", defaultValue = "World") String name) {
		return (List<Wishlist>) wishlistRepository.findAll();
	}

	@RequestMapping(value = "/wishlist", method = RequestMethod.POST)
	public Wishlist create(@RequestBody Wishlist wishlistRB) {
		Wishlist wishlist = new Wishlist(wishlistRB);
		// System.out.println("Creating wishlist " + wishlist);

		return wishlistRepository.save(wishlist);

	}

	@RequestMapping(value = "/wishlist", method = RequestMethod.PUT)
	public ResponseEntity<Wishlist> update(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<Wishlist>(wishlist, HttpStatus.OK);
	}
}
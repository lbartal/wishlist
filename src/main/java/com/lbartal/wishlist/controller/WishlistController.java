package com.lbartal.wishlist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbartal.wishlist.model.Wishlist;

@RestController
public class WishlistController {

	@RequestMapping("/wishlist")
	public Wishlist get(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Wishlist();
	}

	@RequestMapping(value = "/wishlist", method = RequestMethod.POST)
	public ResponseEntity<Wishlist> create(@RequestBody Wishlist wishlist) {
		System.out.println("Creating wishlist");
		return new ResponseEntity<Wishlist>(wishlist, HttpStatus.OK);
	}

	@RequestMapping(value = "/wishlist", method = RequestMethod.PUT)
	public ResponseEntity<Wishlist> update(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<Wishlist>(wishlist, HttpStatus.OK);
	}
}
package com.lbartal.wishlist.repository;

import org.springframework.data.repository.CrudRepository;

import com.lbartal.wishlist.domain.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist, Long> {

}

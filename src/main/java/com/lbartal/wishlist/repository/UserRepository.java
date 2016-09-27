package com.lbartal.wishlist.repository;

import org.springframework.data.repository.CrudRepository;

import com.lbartal.wishlist.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmail(String email);

	public User findByUsername(String username);

}

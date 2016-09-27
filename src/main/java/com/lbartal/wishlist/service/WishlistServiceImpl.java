package com.lbartal.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lbartal.wishlist.domain.User;
import com.lbartal.wishlist.domain.Wishlist;
import com.lbartal.wishlist.exception.WishlistException;
import com.lbartal.wishlist.repository.UserRepository;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Wishlist get(Long userId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userRepository.findByUsername(username);
		if (null == user)
			return null;
		return user.getWishlist();
	}

	@Override
	public Wishlist add(Wishlist wishlist) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userRepository.findByUsername(username);
		if (null == user)
			return null;

		if (user.getWishlist() == null)
			user.setWishlist(wishlist);
		else
			throw new WishlistException("ALREADY ADDED");
		userRepository.save(user);
		return user.getWishlist();
	}

}

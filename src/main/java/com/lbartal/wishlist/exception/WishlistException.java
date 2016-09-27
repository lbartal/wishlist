package com.lbartal.wishlist.exception;

import org.springframework.web.util.NestedServletException;

public class WishlistException extends NestedServletException {

	public WishlistException(String message) {
		super(message);
	}

}

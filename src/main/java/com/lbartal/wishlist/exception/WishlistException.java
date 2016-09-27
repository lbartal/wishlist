package com.lbartal.wishlist.exception;

import org.springframework.web.util.NestedServletException;

public class WishlistException extends NestedServletException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WishlistException(String message) {
		super(message);
	}

}

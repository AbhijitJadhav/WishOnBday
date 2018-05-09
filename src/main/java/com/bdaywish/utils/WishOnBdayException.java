package com.bdaywish.utils;

/**
 * 
 * @author Abhijit.Jadhav
 *
 */
public class WishOnBdayException extends Exception{

	private static final long serialVersionUID = 1L;

	public WishOnBdayException() {
	}
	
	public WishOnBdayException(String message) {
		super(message);
	}
	
	public WishOnBdayException(String message,Throwable error) {
		super(message,error);
	}
	
	public WishOnBdayException(Throwable error) {
		super(error);
	}
}

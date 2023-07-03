package com.epicode.bank;

public class BancaException extends Exception {
	
	private String message;
	
	public BancaException(String message) {
		super(message);
	}

}

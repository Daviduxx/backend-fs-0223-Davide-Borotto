package com.epicode.bank;

public class BancaException extends Exception {
	
	
	public BancaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.getMessage();
	}
}

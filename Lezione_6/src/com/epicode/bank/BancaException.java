package com.epicode.bank;

public class BancaException extends Exception {
	
	private String errore;
	
	public BancaException(String message, String errore) {
		super(message);
		this.errore = errore;
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	

}

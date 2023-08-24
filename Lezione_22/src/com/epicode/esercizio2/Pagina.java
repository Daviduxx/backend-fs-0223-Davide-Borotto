package com.epicode.esercizio2;

public class Pagina extends ElementoLibro{
	
	private int numPagina;

	public Pagina(int numPagina) {
		this.numPagina = numPagina;
	}

	@Override
	public void stampa() {
		System.out.println("Stampa della pagina n. " + numPagina);
		
	}

	@Override
	public int numeroPagine() {
		return 1;
	}

}

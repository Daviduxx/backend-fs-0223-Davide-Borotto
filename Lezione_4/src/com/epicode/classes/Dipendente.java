package com.epicode.classes;

public class Dipendente {
	
	public double stipendioBase = 1000.00;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	
	//COSTRUTTORE 1 
	public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
		
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	
	//COSTRUTTORE 2 (OVERLOAD)
	public Dipendente(int matricola, Dipartimento dipartimento) {
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30.0;
		this.livello = Livello.OPERAIO;
		this.matricola = matricola;
		this.dipartimento = dipartimento;
	}
	
	//METODI GETTER
	public int getMatricola() {
		return matricola;
	}
	
	public double getStipendioBase() {
		return stipendioBase;
	}
	
	public double getStipendio() {
		return stipendio;
	}
	
	public double getimportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}
	
	public Livello getLivello() {
		return livello;
	}
	
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	
	//METODI SETTER
	
	public Dipartimento setDipartimento(Dipartimento dipartimento) {
		return this.dipartimento = dipartimento;
	}
	
	public double setImportoOrarioStraordinario(double imp) {
		return this.importoOrarioStraordinario = imp;
	}
	
	//METODI
	public String toString() { //OVERRIDE
		return 
		"Matricola: " + matricola + 
		"Stipendio: " + stipendio + 
		"Importo Straordinari: " + importoOrarioStraordinario + 
		"Livello: " + livello +
		"Dipartimento: " + dipartimento;
	}
	
	//SECONDO METODO
	public Livello promuovi() {
		switch(this.livello) {
		case OPERAIO:
			this.livello = Livello.IMPIEGATO;
			break;
		case IMPIEGATO:
			this.livello = Livello.QUADRO;
			this.stipendio = stipendioBase * 1.2;
			break;
		case QUADRO:
			this.livello = Livello.DIRIGENTE;
			this.stipendio = stipendioBase * 1.5;
			break;
		case DIRIGENTE:
			this.livello = Livello.DIRIGENTE;
			this.stipendio = stipendioBase * 2.0;
			System.out.println("Sei già un dirigente!!!!");
		}
		return  this.livello;
	}
	
	//METODI STATICI
	public static double calcolaPaga(Dipendente d) {
		return  d.stipendio;
	}
	//OVERRIDE DEL METODO PRECEDENTE
	public static double calcolaPaga(Dipendente d, int straordinario) {
		return  d.stipendio + (straordinario  * d.importoOrarioStraordinario);
	}
	
}

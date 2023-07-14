package model;

import java.time.LocalDate;

public class Utente {
	
	private Long numeroDiTessera;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	
	
	public Utente() {
		super();
	}


	public Utente(Long numeroDiTessera, String nome, String cognome, LocalDate dataDiNascita) {
		super();
		this.numeroDiTessera = numeroDiTessera;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}


	public Long getNumeroDiTessera() {
		return numeroDiTessera;
	}


	public void setNumeroDiTessera(Long numeroDiTessera) {
		this.numeroDiTessera = numeroDiTessera;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}


	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}


	@Override
	public String toString() {
		return "Utente [numeroDiTessera=" + numeroDiTessera + ", nome=" + nome + ", cognome=" + cognome
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}
	
	
}

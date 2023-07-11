package com.epicode.jdbc;

import java.sql.Date;
import java.time.LocalDate;

public class Studente {
	
	private int id;
	private String nome;
	private String cognome;
	private String gender;
	private LocalDate birthday;
	private Integer avg;
	private int min_vote;
	private int max_vote;
	
	
	public Studente(String nome, String cognome, String gender, LocalDate birthday, Integer avg, Integer min_vote,
			Integer max_vote) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.gender = gender;
		this.birthday = birthday;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public Integer getAvg() {
		return avg;
	}


	public void setAvg(Integer avg) {
		this.avg = avg;
	}


	public Integer getMin_vote() {
		return min_vote;
	}


	public void setMin_vote(Integer min_vote) {
		this.min_vote = min_vote;
	}


	public Integer getMax_vote() {
		return max_vote;
	}


	public void setMax_vote(Integer max_vote) {
		this.max_vote = max_vote;
	}
	
	

}

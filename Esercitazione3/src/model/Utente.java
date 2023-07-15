package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroDiTessera;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	@OneToMany(mappedBy = "utente")
	@Column(name = "prestiti", nullable = true)
	private Set<Prestito> prestiti;
	
	public Utente() {
		super();
	}





	


	public Utente(String nome, String cognome, LocalDate dataDiNascita, Set<Prestito> prestiti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.prestiti = prestiti;
	}








	public Set<Prestito> getPrestiti() {
		return prestiti;
	}


	public void setPrestiti(Set<Prestito> prestiti) {
		this.prestiti = prestiti;
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

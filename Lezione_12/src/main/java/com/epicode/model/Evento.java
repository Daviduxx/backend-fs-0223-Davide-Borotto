package com.epicode.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NuoviEventi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Evento {
		
		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private Long id;
		@Column(name = "titolo", nullable = false)
		private String titolo;	
		@Column(name = "data", nullable = false)
		private LocalDate dataEvento;
		@Column(name = "descrizione", nullable = false)
		private String descrizione;
		@Enumerated(EnumType.STRING)
		@Column(name = "tipo", nullable = false)
		private Type tipoEvento;
		@Column(name = "max", nullable = false)
		private Integer numeroMassimoPartecipanti;
		@OneToMany(mappedBy="evento", cascade = CascadeType.REMOVE)
		private Set<Partecipazione> partecipazioni;
		@ManyToOne
		private Location location;
	
		
		public Evento() {
			super();
		}


		public Evento(String titolo, LocalDate dataEvento, String descrizione, Type tipoEvento,
				Integer numeroMassimoPartecipanti) {
			super();
			this.titolo = titolo;
			this.dataEvento = dataEvento;
			this.descrizione = descrizione;
			this.tipoEvento = tipoEvento;
			this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitolo() {
			return titolo;
		}


		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}


		public LocalDate getDataEvento() {
			return dataEvento;
		}


		public void setDataEvento(LocalDate dataEvento) {
			this.dataEvento = dataEvento;
		}


		public String getDescrizione() {
			return descrizione;
		}


		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}


		public Type getTipoEvento() {
			return tipoEvento;
		}


		public void setTipoEvento(Type tipoEvento) {
			this.tipoEvento = tipoEvento;
		}


		public Integer getNumeroMassimoPartecipanti() {
			return numeroMassimoPartecipanti;
		}


		public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
			this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		}
		
		


		public Set<Partecipazione> getPartecipazioni() {
			return partecipazioni;
		}


		public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
			this.partecipazioni = partecipazioni;
		}


		public Location getLocation() {
			return location;
		}


		public void setLocation(Location location) {
			this.location = location;
		}


		@Override
		public String toString() {
			return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione="
					+ descrizione + ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti="
					+ numeroMassimoPartecipanti + "]";
		}
		
		

}

package com.epicode.spring.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	
	//normale tabella che viene creata nel db
	//le colonne possono essere aggiornate, modificate, eliminate ecc

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) //un utente può avere più ruoli, ogni ruolo può essere assegnato a più di un utente
    @JoinTable(name = "users_roles", //vado a cambiare il nome della tabella che gestisce la relazione tra ruolo e utente
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") //se non metto tutte queste cose non cambia niente, lo fa in maniera automatica
    )
    private Set<Role> roles = new HashSet<>(); //un utente può avere più di un ruolo
}

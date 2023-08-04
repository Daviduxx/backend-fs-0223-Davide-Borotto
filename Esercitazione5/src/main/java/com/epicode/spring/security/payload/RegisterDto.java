package com.epicode.spring.security.payload;

import java.util.Set;

import com.epicode.spring.model.Device;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}

//non è una entity. serve solo per tipizzasre l'oggetto che arriva dal client.
//simile alle interfacce di angular

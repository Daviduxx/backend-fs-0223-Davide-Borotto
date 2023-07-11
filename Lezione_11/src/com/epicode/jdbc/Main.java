package com.epicode.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args)  {
		
		try {
			DbConnection db = new DbConnection();
			
			Studente s1 = new Studente("Giorgio", "Bianchi", "m", LocalDate.of(1997,4,23), 7, 4, 9);
			Studente s2 = new Studente("Maria", "Rossi", "f", LocalDate.of(1997,1,2), 8, 6, 10);
			Studente s3 = new Studente("Luigi", "Verdi", "m", LocalDate.of(1997,11,30), 6, 3, 8);
			Studente s4 = new Studente("Giovanna", "Blu", "f", LocalDate.of(1997,3,27), 9, 7, 10);
			
			db.inserisciStudente(s1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

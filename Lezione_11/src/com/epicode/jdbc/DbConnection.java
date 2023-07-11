package com.epicode.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbConnection {
	
	static public Logger log = LoggerFactory.getLogger(DbConnection.class);
	
	String URL = "jdbc:postgresql://localhost:5432/";
	String dbName = "studenti";
	String user = "postgres";
	String pass = "root";
	Statement state;
	
	
	public DbConnection() throws SQLException {
		Connection connessione = DriverManager.getConnection(URL+dbName, user, pass);
		state = connessione.createStatement();
		log.info("DB connesso correttamente");
		creaTabellaStudenti();
	}
	
	public void creaTabellaStudenti() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS school_students ("
				+ "	id SERIAL PRIMARY KEY,"
				+ "	name VARCHAR NOT NULL,"
				+ "	lastname VARCHAR NOT NULL,"
				+ "	gender VARCHAR,"
				+ "	birthday LOCALDATE,"
				+ "	avg INTEGER NOT NULL,"
				+ "	min_vote INTEGER NOT NULL,"
				+ "	max_vote INTEGER NOT NULL"
				+ ");";
		state.executeUpdate(sql);
		log.info("Tabella creata correttamente");
	}
	
	public void inserisciStudente(Studente s) throws SQLException {
		String sql = "INSERT INTO school_students (name, lastname, gender, birthday, avg, min_vote, max_vote)"
				+ "VALUES ('"+s.getNome()+"', '"+s.getCognome()+"', '"+s.getGender()+"', '"+Date.valueOf(s.getBirthday())+"', '"+s.getAvg()+"', '"+s.getMin_vote()+"', '"+s.getMax_vote()+"');";
		state.executeUpdate(sql);
		log.info("Aggiunto studente: "+ s.getNome() + " " + s.getCognome());
	}

}

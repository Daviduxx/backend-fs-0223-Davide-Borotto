package com.epicode.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbConnection {
	
	static public Logger log = LoggerFactory.getLogger(DbConnection.class);
	static public Map<String, Studente> mStudenti = new HashMap<String, Studente>();
	
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
				+ "	birthday DATE,"
				+ "	avg INTEGER NOT NULL,"
				+ "	min_vote INTEGER NOT NULL,"
				+ "	max_vote INTEGER NOT NULL"
				+ ");";
		state.executeUpdate(sql);
		log.info("Tabella creata correttamente");
	}
	
	public void inserisciStudente(Studente s) throws SQLException {
		String sql = "INSERT INTO school_students (name, lastname, gender, birthday, avg, min_vote, max_vote)"
				+ "VALUES ('"+s.getNome()+"', '"+s.getCognome()+"', '"+s.getGender()+"', '"+Date.valueOf(s.getBirthday())+"', "+s.getAvg()+", "+s.getMin_vote()+", "+s.getMax_vote()+");";
		state.executeUpdate(sql);
		log.info("Aggiunto studente: "+ s.getNome() + " " + s.getCognome());
	}
	
	public void modificaStudente(String id, Map<String, Studente> s) throws SQLException {
		Studente st = s.get(id);
		String sql = "UPDATE school_students SET "
				   + " name = '" + st.getNome() + "', "
				   + " lastname = '" + st.getCognome() + "', "
				   + " gender = '" + st.getGender() + "', "
				   + " birthday = '" + st.getBirthday() + "', "
				   + " avg  = '"+st.getAvg()+"', "
				   + " min_vote = '"+st.getMin_vote()+"', "
				   + " max_vote = '"+st.getMax_vote()+"' "
				   + " WHERE id = " + id;
		state.executeUpdate(sql);
		log.info(st.getCognome() + " " + st.getNome() + " aggiornato!");
	}
	
	public void getAllStudents() throws SQLException {
		String sql = "SELECT * FROM school_students";
		ResultSet rs = state.executeQuery(sql);
		while(rs.next()) {
			String idUtente = rs.getString("id");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			String gender = rs.getString("gender");
			LocalDate birthday = rs.getDate("birthday").toLocalDate();
			Integer avg = rs.getInt("avg");
			int min = rs.getInt("min_vote");
			int max = rs.getInt("max_vote");
			Studente s = new Studente(name, lastname, gender, birthday, avg, min, max);
			mStudenti.put((String) idUtente, s);
		}
	}

}

	

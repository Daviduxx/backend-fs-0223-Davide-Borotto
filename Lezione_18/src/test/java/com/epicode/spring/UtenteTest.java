package com.epicode.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.epicode.spring.model.Utente;
import com.epicode.spring.repository.UtenteDAORepository;



@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class UtenteTest {
	
	@Autowired TestRestTemplate restTemplate;
	@Autowired UtenteDAORepository repo;
	@Autowired @Qualifier("utenteCustom") ObjectProvider<Utente> utenteTest;

//	@Test
//	void testReturnAll() {
//		fail("Not yet implemented");
//	}

	@Test
	@DisplayName("Test per verficare l'id")
	void testReturnOne() {
		Utente u = utenteTest.getObject();
		u.setNome("andrea");
		u.setCognome("neri");
		u.setEta(99);
		repo.save(u);
		
		String url = "http://localhost:8080/api/utenti/" + u.getId();
		ResponseEntity<Utente> resp = restTemplate.getForEntity(url, Utente.class);
		
		Utente ut = resp.getBody();
		
		assertThat(ut.getId()).isEqualTo(u.getId());
	}

//	@Test
//	@Disabled
//	void testCreaUtente() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testRimuoviUtente() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testAggiornaUtente() {
//		fail("Not yet implemented");
//	}

}

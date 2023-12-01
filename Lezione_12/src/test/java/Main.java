import java.time.LocalDate;

import com.epicode.model.Evento;
import com.epicode.model.Location;
import com.epicode.model.Partecipazione;
import com.epicode.model.PartitaDiCalcio;
import com.epicode.model.Persona;
import com.epicode.model.Sesso;
import com.epicode.model.Stato;
import com.epicode.model.Type;
import com.epicode.dao.*;

public class Main {

	public static void main(String[] args) {
		
		Evento e1 = new Evento("Concerto", LocalDate.of(2023, 11, 25), "Concerto di Eminem", Type.PUBBLICO, 5000);
		Evento e2 = new Evento("Proiezione cinematografica", LocalDate.of(2023, 12, 28), "Film di Batman", Type.PUBBLICO, 500);
		Evento e3 = new Evento("Musica classica", LocalDate.of(2023, 10, 20), "Quartetto d'Archi", Type.PRIVATO, 50);
		Location l1 = new Location("Alpitour", "Torino");
		Location l2 = new Location("Olimpico", "Roma");
		Persona p1 = new Persona("Mario", "Rossi", "mario.rossi@mail.it", LocalDate.of(1960, 1, 20), Sesso.MASCHIO);
		Persona p2 = new Persona("Maria", "Verdi", "maria.verdi@mail.it", LocalDate.of(1970, 6, 28), Sesso.FEMMINA);
		Persona p3 = new Persona("Luigi", "Bianchi", "luigi.bianchi@mail.it", LocalDate.of(1970, 6, 28), Sesso.FEMMINA);
		Partecipazione par1 = new Partecipazione(Stato.CONFERMATA);
		Partecipazione par2 = new Partecipazione(Stato.CONFERMATA);
		Partecipazione par3 = new Partecipazione(Stato.DA_CONFERMARE);
		
		PartitaDiCalcio c1 = new PartitaDiCalcio("Juventus", LocalDate.of(2023, 11, 4), "juve vs toro", Type.PUBBLICO, 50000, "Juventus", "Torino", "Juventus", 5,4);
		
		e1.setLocation(l1);
		e2.setLocation(l2);
//		e3.setLocation(l2);
		
		EventoDAO eDAO = new EventoDAOImpl();
		LocationDAOImpl lDAO = new LocationDAOImpl();
		PersonaDAOImpl pDAO = new PersonaDAOImpl();
		PartecipazioneDAOImpl partDAO = new PartecipazioneDAOImpl();
		PartitaDiCalcioDAOImpl calcioDAO = new PartitaDiCalcioDAOImpl();
		
//		pDAO.save(p2);
//		pDAO.save(p1);
//		pDAO.save(p3);
		
//		Persona pa = pDAO.getById(1l);
//		Persona pb = pDAO.getById(2l);
		Persona pc = pDAO.getById(3l);
		
//		lDAO.save(l1);
//		lDAO.save(l2);
		
		Location la = lDAO.getById(1l);
//		e3.setLocation(la);
		c1.setLocation(la);
		
		calcioDAO.save(c1);
//		eDAO.save(e2);
//		eDAO.save(e3);
		
		PartitaDiCalcio ca = calcioDAO.getById(2l);
//		Evento eb = eDAO.getById(3L);
//		Evento ec = eDAO.getById(4L);
		
		par1.setEvento(ca);
//		par2.setEvento(eb);
		par1.setPersona(pc);
//		par2.setPersona(pb);
		
		partDAO.save(par1);
//		partDAO.save(par2);
		

//		eDAO.delete(ea);
		
	}

}

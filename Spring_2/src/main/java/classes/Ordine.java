package classes;

import java.time.LocalTime;
import java.util.List;

public class Ordine {
	
	private int numero;
	private Tavolo tavolo;
	private List<Elemento> elementi;
	private StatoOrdine stato;
	private int numCoperti;
	private LocalTime ora;
}

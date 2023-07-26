package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tavolo {
	
	private int numero;
	private int maxCoperti;
	private Stato stato;
	
	
	public void setStato(Stato stato) {
		this.stato = stato;
	}

}

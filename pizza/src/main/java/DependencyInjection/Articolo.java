package DependencyInjection;

public class Articolo extends Prodotto{
	
	private String nome;

	public Articolo(int prezzo, String nome) {
		super(prezzo);
		this.nome = nome;
	}

}

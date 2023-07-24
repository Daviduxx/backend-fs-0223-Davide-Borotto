package DependencyInjection;

public class Drink extends Prodotto{
	
	private int calorie;
	private String nome;
	private int dimensione;
	private int perAlcol;
	
	
	public Drink(int prezzo, int calorie, String nome, int dimensione, int perAlcol) {
		super(prezzo);
		this.calorie = calorie;
		this.nome = nome;
		this.dimensione = dimensione;
		this.perAlcol = perAlcol;
	}
	
	
}

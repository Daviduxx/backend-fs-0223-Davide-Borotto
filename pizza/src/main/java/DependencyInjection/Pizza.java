package DependencyInjection;

public class Pizza extends Prodotto {
	

	private int calorie;
	private String nome;
	private ITopping base;
	private ITopping toppings;
	
	public Pizza(int prezzo, int calorie, String nome, ITopping base,ITopping toppings) {
		super(prezzo);
		this.calorie = calorie;
		this.nome = nome;
		this.base = base;
		this.toppings = toppings;
	}
	
	
	
	
}

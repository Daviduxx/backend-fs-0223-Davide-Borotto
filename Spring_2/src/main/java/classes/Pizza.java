package classes;

public class Pizza extends Elemento{
	
	private String nome;
	private int calories;
	
	public Pizza(double price, String nota, String nome, int calories) {
		super(price, nota);
		this.nome = nome;
		this.calories = calories;
	}

	public String getMenuLine() {
		return this.nome + " - " + this.getPrice() + "$ - " + this.calories + " calories - note: " + this.getNota();
	}
}

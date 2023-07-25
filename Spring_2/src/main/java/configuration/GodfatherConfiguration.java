package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import classes.Hawaian;
import classes.Margherita;
import classes.Menu;
import classes.Salami;

@Configuration
public class GodfatherConfiguration {
	
	@Bean
	@Scope("singleton")
	public Menu menuPizzaConfig() {
		Menu m = new Menu();
		m.getMenuPizze().add(margherita());
		m.getMenuPizze().add(salami());
		m.getMenuPizze().add(hawaian());
		return m;
	}
	
	@Bean
	@Scope("singleton")
	public Margherita margherita() {
		return new Margherita();
	}
	
	@Bean
	@Scope("singleton")
	public Salami salami() {
		return new Salami();
	}
	
	@Bean
	@Scope("singleton")
	public Hawaian hawaian() {
		return new Hawaian();
	}

}

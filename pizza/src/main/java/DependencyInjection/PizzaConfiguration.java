package DependencyInjection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class PizzaConfiguration {
	
	@Bean
	@Scope("singleton")
	public List<String> base(){
		List<String> base = new ArrayList<String>();
		String pom = "pomodoro";
		String moz = "mozzarella";
		base.add(moz);
		base.add(pom);
		return base;
	}

}

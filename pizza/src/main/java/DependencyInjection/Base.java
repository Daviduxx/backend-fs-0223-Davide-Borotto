package DependencyInjection;

import java.util.List;

public class Base implements ITopping{
	
	private List<String> base;

	public Base(List<String> base) {
		super();
		this.base = base;
	}
	
	
}

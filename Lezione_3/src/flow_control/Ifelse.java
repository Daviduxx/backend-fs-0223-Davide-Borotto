package flow_control;

public class Ifelse {
	
	private String stringa;
	public int anno;
	
	// construttore con firma di stringa
	
	public Ifelse(String stringa) {
		this.stringa = stringa;
	}
	
	// construttore con firma di int
	public Ifelse(int anno) {
		this.anno = anno;
	}
	
	public  Boolean stringaPariDispari(String str) {
		int strLength = str.length();
		if(strLength % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean annoBisestile(int anno) {
		if(anno % 4 == 0 || anno % 100 == 0 && anno % 400 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
}

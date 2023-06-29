package flow_control;

public class Ifelse {
		
	public static Boolean stringaPariDispari(String str) {
		int strLength = str.length();
		if(strLength % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Boolean annoBisestile(int anno) {
		if(anno % 4 == 0 || anno % 100 == 0 && anno % 400 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
}

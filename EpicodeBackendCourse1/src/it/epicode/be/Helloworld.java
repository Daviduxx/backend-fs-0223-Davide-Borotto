package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args) {
	
		//ESERCIZIO 1
		System.out.println("MOLTIPLICAZIONE: " + moltiplicazione(4,5));
		System.out.println("CONCATENAZIONE: " + concatenazione("ciao", 5));
		
		//ESERCIZIO 2
		String[] arrInit = {"html", "css", "js", "ts", "java"};
		String[] arrModificato = InseriscilnArray(arrInit, "angular");
		for (int i = 0; i < arrModificato.length; i++) {
			System.out.println(arrModificato[i]);
		}
		
		//ESERCIZIO 3
		user();
		
		//ESERCIZIO 4
		System.out.println("perimetro: " + perimetro(2.5,2.5));
		System.out.println("PARI O DISPARI? " + parioDispari(7));
		double area = areaTriangolo(2.5, 2.5);
		System.out.println("area triangolo: " + area);
	
		
		}

public static int moltiplicazione(int x, int y) {
	return x * y;
}


public static String concatenazione(String x, int y) {
	return x + y;
}


public static String[] InseriscilnArray(String[] arr, String str) {
	String[] newArr = new String[6];
	newArr[0] = arr[0];
	newArr[1] = arr[1];
	newArr[2] = arr[2];
	newArr[3] = str;
	newArr[4] = arr[3];
	newArr[5] = arr[4];
	return newArr;
}

public static void user() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Scrivi un linguaggio di programmazione:");
	String ling1 = sc.nextLine();
	System.out.println("Scrivi un  altro linguaggio di programmazione:");
	String ling2 = sc.nextLine();
	System.out.println("Ancora uno:");
	String ling3 = sc.nextLine();
	System.out.println("I linguaggi inseriti sono: " + ling1 + " " + ling2 + " " + ling3);
	System.out.println("I linguaggi inseriti sono: " + ling3 + " " + ling2 + " " + ling1);
	sc.close();
}

public static double perimetro(double x, double y) {
	return (x + y) * 2;
}

public static int parioDispari(int x) {
	int modulo;
	if(x % 2 == 0) {
		modulo = 0;
	}
	else {
		modulo = 1;
	}
	return modulo;
}

public static double areaTriangolo(double base, double altezza) {
	return (base * altezza) / 2;
}

}



package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		int risultato = moltiplicazione(4, 5);
		System.out.println(risultato);
		
		String frase = concatenazione("Ciao", 7);
		System.out.println(frase);
		
		String[] arrInit = {"html", "css"};
		String[] arrln = InseriscilnArray(arrInit);
		System.out.println(arrln);
		
		double perimetro = perimetro(2.5, 3.5);
		System.out.println(perimetro);
		
		int parDisp = parioDispari(7);
		System.out.println(parDisp);
		
		double area = areaTriangolo(2.5, 2.5);
		System.out.println("area triangolo: " + area);
		
		String[] arr = {"html", "css", "js", "ts", "php"};
		System.out.println(inserisciArray(arr, "java"));
		
		user();
		}

public static int moltiplicazione(int x, int y) {
	int result = x * y;
	return result;
}


public static String concatenazione(String x, int y) {
	String result = x + y;
	return result;
}


public static String[] InseriscilnArray(String[] arr) {
	String[] newArr = arr;
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
}

public static double perimetro(double x, double y) {
	double per = (x + y) * 2;
	return per;
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
	double area = (base * altezza) / 2;
	return area;
}

public static String[] inserisciArray(String[] arr, String str) {
	String[] arrIngresso = new String[6];
	
	arrIngresso[0] = arr[0];
	arrIngresso[1] = arr[1];
	arrIngresso[2] = arr[2];
	arrIngresso[3] = str;
	arrIngresso[4] = arr[3];
	arrIngresso[5] = arr[4];
	
	return arrIngresso;
}


}



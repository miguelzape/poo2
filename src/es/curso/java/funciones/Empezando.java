package es.curso.java.funciones;

import java.time.LocalDate;
import java.util.Scanner;

public class Empezando {
	static public void main(String args[]) {
		
		Scanner scan=new Scanner(System.in);
		int numero;
	
		System.out.println("Introduzca su año de nacimiento: ");
		System.out.printf("Su edad es %d años\n\n",calculaEdad(scan.nextLine()));
		
		System.out.println("Ahora vamos a ver la tabla de multiplicar del numero ¿?: ");
		numero=scan.nextInt();
		pintaTablaMultiplicar(numero);
		System.out.println("\n");
		
		
		for (String cadena:juntaDatos("telefono",7)) {
			System.out.print(cadena + " ");
		}
		
		scan.close();
		
	}
	
	static int calculaEdad(String anioNacimiento) {
	
		LocalDate date = LocalDate.now();
		int year= date.getYear();
		
		int anio = Integer.parseInt(anioNacimiento);
		return (year-anio);
		
	}
	
	static void pintaTablaMultiplicar (int numero) {
		for (int i=1;i<=10;i++) {
			System.out.println(numero + " * " + i + " = " + (numero*i));
		}
	}
	
	static String [] juntaDatos (String texto, int numRepeticiones) {
		String arrayCadenas[] = new String[numRepeticiones];
		for (int i=0;i < numRepeticiones;i++) {
			arrayCadenas[i]=texto;
			if (texto.length() > 1) {
				texto=texto.substring(0,texto.length()-1);
			}
		}
		return arrayCadenas;
	}
}

package es.curso.java;

import java.util.Scanner;

public class CosteLlamada {
	public static void main(String[] arg) {

		int entrada;
		int minutos;
		float precio = 0;
		int aux;
		final String pregunta1 = "¿Cuantos minutos ha durado la llamada?: ";
		final String pregunta2 = "¿Qué dia de la semana se realizó la llamada?: ";
		final String pregunta3 = "¿A que hora se hizo la llamada (solo hora de 0 a 23)?: ";
		Scanner scan = new Scanner(System.in);
		String diaSemana = "";
		int hora;

		System.out.println(pregunta1);
		entrada = scan.nextInt();
		minutos = entrada;

		// System.out.println("Has tecleado: " + entrada);

		if (entrada >= 10) {
			aux = entrada - 10;
			precio = aux * 0.5f;
			entrada = 10;
			System.out.print("\n(>10) " + precio + " + ");
		}

		if (entrada >= 8) {
			aux = entrada - 8;
			precio += (aux * 0.7f);
			entrada = 8;
			System.out.print("(>8) " + (aux * 0.7f) + " + ");
		}

		if (entrada >= 5) {
			aux = entrada - 5;
			precio += (aux * 0.8f);
			entrada = 5;
			System.out.print("(>5) " + (aux * 0.8f) + " + ");
		}

		precio = precio + entrada;
		System.out.print(entrada + "\n");
		System.out.println("El precio base de " + minutos + " minutos de llamada es: " + precio + "\n");
		System.out.println(pregunta2);
		diaSemana = scan.next();
		if (diaSemana.toLowerCase().equals("domingo"))
			precio = precio * 1.03f;
		else {
			System.out.println(pregunta3);
			hora = scan.nextInt();
			precio = (hora < 12) ? precio * 1.15f : precio * 1.1f;
		}
		System.out.println("El precio con impuestos es: " + precio);

		scan.close();
	}
}

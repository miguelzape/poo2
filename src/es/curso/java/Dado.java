package es.curso.java;

import java.util.Scanner;

public class Dado {
	public static void main(String[] arg) {

		int importe = 1000;
		int varInt;
		int apuesta;
		int ganador;
		String continuar;
		Scanner scan = new Scanner(System.in);
		System.out.println("Generar numeros aletori;os entre 1 y 10 hasta que salga un 6");
		procedimiento(6, 6, 1);
		System.out.println("Generar numeros aletorios entre 1 y 10 hasta que salga un 6 + 6 + 6");
		procedimiento(6, 6, 3);

		do {
			do {
				System.out.println("\nIntroduzca el importe de su apuesta: (1 a " + importe + "): ");
				varInt = scan.nextInt();
				if (varInt < 0 || varInt > importe)
					System.out.println("Importe insuficiente");
			} while (varInt < 0 || varInt > importe);
			System.out.println("Indique el numero al que apuesta (1 a 6): ");
			apuesta = scan.nextInt();
			ganador = (int) Math.random() * 6 + 1;
			System.out.printf("\nEl numero ganador es: %d", ganador);
			if (ganador == apuesta) {
				System.out.printf("\nHas ganado %d $€", varInt * 3);
				importe += (varInt * 2);
			}

			else {
				System.out.printf("\nHas perdido tus %d $€", varInt);
				importe -= varInt;
			}

			System.out.println("\nDesea continuar");
			continuar = scan.next();

		} while (continuar.toLowerCase().equals("si"));

		scan.close();
	}

// genera numeros aleatorios entre 1 y rango, los imprime, y termina cuando
// el numero es igua a terminador. Debe ocurrir el numero de veces consecutivas del tercer parametro
	public static void procedimiento(int rango, int terminador, int terminadoresConsecutivos) {
		int aleatorio;
		int repeticiones = 0;

		do {
			aleatorio = (int) (Math.random() * rango) + 1;
			System.out.print(aleatorio + ", ");
			repeticiones = (aleatorio == terminador) ? repeticiones + 1 : 0;
		} while (terminadoresConsecutivos > repeticiones);
		System.out.println();
	}
}

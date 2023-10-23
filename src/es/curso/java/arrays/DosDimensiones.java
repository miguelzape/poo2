package es.curso.java.arrays;

import java.util.Scanner;

public class DosDimensiones {
	public static void main(String[] arg) {

		String matriz[][] = new String[2][5];
		Scanner scan = new Scanner(System.in);
		int t;
		int cubo[][];
		int diagonal[];
		int aux;

		// rellenar la matriz
		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[0].length; c++) {
				matriz[f][c] = "P" + f + "-" + c;
			}
		}

		// visualizar la matriz
		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[0].length; c++) {
				System.out.print(matriz[f][c] + "\t");
			}
			System.out.println();
		}

		System.out.println("\n");

		// visualizar la matriz con bucles foreach
		for (String filas[] : matriz) {
			for (String celda : filas) {
				System.out.print(celda + "\t");
			}
			System.out.println();
		}

		System.out.println("\nCual es el numero de filas para crear una matriz cuadrada: ");
		t = scan.nextInt();

		cubo = new int[t][t];
		diagonal = new int[t];
		System.out.println("\nCual es el valor de las siguientes posiciones: ");

		for (int f = 0; f < t; f++) {
			for (int c = 0; c < t; c++) {
				System.out.printf("Posicion %d,%d: ", f, c);
				cubo[f][c] = scan.nextInt();
			}
		}

		System.out.println("\nEste es el cubo introducido\n ");
		// visualizar el cubo
		for (int filas[] : cubo) {
			for (int celda : filas) {
				System.out.print(celda + "\t");
			}
			System.out.println();
		}

		// crear un array unidimensional con la diagonal izq a der
		for (int i = 0; i < t; i++) {
			diagonal[i] = cubo[i][i];
		}

		// imprimir el array de la diagonal
		System.out.println("\nLa diagonal izq a der es: \n ");
		for (int celda : diagonal) {
			System.out.print(celda + "\t");
		}

		// invertir la diagonal der-izq invertida
		System.out.println("\nInvirtiendo la diagonal izq a der es: \n ");
		for (int f = 0, c=(t-1); f < (t / 2); f++, c--) {
			aux = cubo[f][c];
			cubo[f][c] = cubo[c][f];
			cubo[c][f] = aux;
		}

		// visualizar el cubo
		for (int filas[] : cubo) {
			for (int celda : filas) {
				System.out.print(celda + "\t");
			}
			System.out.println(); 
		}

		scan.close();

	}

}

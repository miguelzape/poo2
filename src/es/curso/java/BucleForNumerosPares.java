package es.curso.java;

import java.util.Scanner;

public class BucleForNumerosPares {
	public static void main(String[] arg) {
		final String menu1 = "\nMENU DE OPCIONES\n\n1. Lista de numeros pares/impares\n2. Media de notas"
				+ "\n3. Conjetura de Collatz\n4. Serie de Fibonachi\n5. Velocidades coches"
				+ "\n6. Multiplos de 3 y 5\n7. Tenistas top 10\n8. Tabla multiplicar"
				+ "\n9. Pintar rectangulo\n10. Pintar triangulo\n11. Pintar almohadilla \n12. Salir";
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		int collatz = 0;
		int varInt = 0;
		int fibo1, fibo2, fibo3;
		double nota = 0;
		int velocidadMin = 0;
		int velocidadCoche = 0;
		int conta3;
		int conta5;
		int mitad;

		while (opcion != 12) {
			System.out.println(menu1);
			opcion = scan.nextInt();
			switch (opcion) {
			case 1: // lista de numeros pares e impares
				for (int i = 2; i <= 50; i += 2)
					System.out.print(i + " " + (51 - i) + " ");
				break;
			case 2: // Media de notas
				do {
					System.out.println("Introduzca el numero de alumnos en la clase: (1 a 20)");
					varInt = scan.nextInt();
					if (varInt < 0 || varInt > 20)
						System.out.println("Valor erroneo");
				} while (varInt < 0 || varInt > 20);

				nota = 0;
				for (int i = 0; i < varInt; i++) {
					System.out.printf("Cual es la nota del alumno %d: ", (i + 1));
					nota += scan.nextDouble();
				}

				System.out.printf("\n\nLa nota media es: %.2f", (double) nota / varInt);
				break;
			case 3: // conjetura de collatz
				System.out.println("Introduzca un numero: ");
				collatz = scan.nextInt();
				while (collatz > 1) {
					collatz = ((collatz % 2) == 0) ? collatz / 2 : collatz * 3 + 1;
					System.out.print(collatz + ", ");
				}
				break;
			case 4: // serie de fibonacci
				System.out.println("Introduzca un numero: ");
				collatz = scan.nextInt();
				fibo1 = 1;
				fibo2 = 1;
				System.out.print("\n1, 1");
				for (int i = 0; i < collatz; i++) {
						fibo3=fibo1+fibo2;
						System.out.print(", " + fibo3);
						fibo1=fibo2;
						fibo2=fibo3;	
				}
				break;

			case 5: // Velocidades coches
				do {
					System.out.println("Introduzca el numero de coches de la carrera: (1 a 20)");
					varInt = scan.nextInt();
					if (varInt < 0 || varInt > 20)
						System.out.println("Valor erroneo");
				} while (varInt < 0 || varInt > 20);

				velocidadMin = 32535;
				for (int i = 0; i < varInt; i++) {
					System.out.printf("Cual es la velocidad maxima del coche %d: ", (i + 1));
					velocidadCoche = scan.nextInt();
					if (velocidadCoche < velocidadMin)
						velocidadMin = velocidadCoche;
				}

				System.out.print("\n\nLa velocidad minima de las maximas es: " + velocidadMin);
				break;
			case 6: // Multiplos de 3 y 5
				conta3 = 0;
				conta5 = 0;
				for (int i = 0; i < 10; i++) {
					System.out.printf("\nIntroducta un numero (%d): ", (i + 1));
					varInt = scan.nextInt();
					if (varInt != 0 && (varInt % 3) == 0)
						++conta3;
					if (varInt != 0 && (varInt % 5) == 0)
						++conta5;
				}
				System.out.printf("\nHa introducido %d multimplos de 3 y %d multiplos de 5", conta3, conta5);
				break;
			case 7: // tenistas top 10
				do {
					System.out.println("Introduzca el numero jugadores: (1 a 20)");
					varInt = scan.nextInt();
					if (varInt < 0 || varInt > 20)
						System.out.println("Valor erroneo");
				} while (varInt < 0 || varInt > 20);

				conta3 = 0;
				for (int i = 0; i < varInt; i++) {
					System.out.printf("Cual es la posicion ATP del jugador %d: ", (i + 1));
					if (scan.nextInt() <= 10)
						++conta3;
				}
				System.out.printf("\nEn el torneo participan %d jugadores del top 10 de ATP", conta3);
				break;
			case 8: // tabla de multiplicar
				System.out.print("\nIntroduzca el numero base de la tabla de multiplicar: ");
				varInt = scan.nextInt();
				for (int i = 1; i <= 10; i++)
					System.out.println(varInt + " * " + i + " es " + varInt * i);
				break;
			case 9: // pintar rectagulo
				System.out.print("\nIntroduzca el numero de filas (2 a 10): ");
				conta3 = scan.nextInt();
				System.out.print("\nIntroduzca el numero de columnas: (2 a 10)");
				conta5 = scan.nextInt();
				if (conta3 < 2 || conta5 < 2 || conta3 > 10 || conta5 > 10) {
					System.out.println("Valores fuera de rango");
					break;
				}
				for (int fila = 1; fila <= conta3; fila++) {
					System.out.println();
					for (int columna = 1; columna <= conta5; columna++) {
						if (fila==1 || fila==conta3) System.out.print("* ");
						else if (columna==1 || columna==conta5)System.out.print("* ");
						else System.out.print("  ");
					}
				}
				break;
			case 10: // pintar triangulo
				System.out.print("\nIntroduzca el tamaño de la base: (impar de 3 a 15)");
				conta3 = scan.nextInt();
				if (conta3 < 3 || conta3 > 15 || ((conta3 % 2) == 0)) {
					System.out.println("Valor no cumple especificaciones");
					break;
				}
				mitad = conta3/2;
				System.out.println("la mitad es " + mitad);
				
				for (int fila = 1; fila <= conta3; fila++) {
					System.out.println();
					if ((fila%2)==0) System.out.print(" ");
					for (int columna = 1; columna <= conta3; columna++) {
						// primera fila
						if (fila==1) {
							if (columna <= mitad) System.out.print("  ");
							else if (columna == mitad+1) System.out.print("* ");
						}
						//filas intermedias
						if (fila > 1 && fila < conta3) {
							
							
		
						}
						// ultima fila
						if (fila == conta3) {
							System.out.print("* ");	
						}
					}
				}
				break;
				

			case 12: // Salir
				System.out.println("Programa terminado");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;

			}
		}
		scan.close();
	}
}

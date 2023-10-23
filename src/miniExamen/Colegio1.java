package miniExamen;

import java.util.Scanner;

public class Colegio1 {

	public static void main(String[] args) {

		int aulas;
		int nAlumnos;
		String alumnos[][];

		aulas = pedirNumero("Cuantas aulas tiene el colegio: ", 5);
		alumnos = new String[aulas][];

		for (int i = 0; i < aulas; i++) {
			nAlumnos = pedirNumero("Cuantos plazas tiene el aula " + (i + 1) + ": ", 20);
			alumnos[i] = new String[nAlumnos];
			for (int j = 0; j < nAlumnos; j++) {
				alumnos[i][j] = cogerDatosAlumno("nº " + (j+1) + " aula " + (i+1));
			}
		}

		System.out.println("Datos de todos los alumnos ordenados por clase");
		int c = 1;
		for (String clase[] : alumnos) {
			System.out.println("\nClase " + (c++));
			for (String alumno : clase) {
				System.out.println(alumno.replace(':', '\t'));
			}
		}

		System.out.println("\nDatos de los alumnos aprobados");

		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < alumnos[i].length; j++) {
				if (Integer.parseInt(alumnos[i][j].split(":")[2]) >= 5) {
					System.out.println("Clase " + (i+1) + " nº " + (j+1) + ": " + alumnos[i][j].replace(':', '\t'));
				}
			}
		}
	}

	public static int pedirNumero(String mensaje, int limite) {
		Scanner scan = new Scanner(System.in);
		int numero;
		do {
			System.out.println(mensaje + "[1-" + limite + "]");
			numero = scan.nextInt();
		} while (numero < 0 || numero > limite);
		// scan.close();
		return (numero);
	}

	public static String cogerDatosAlumno(String mensaje) {
		Scanner scan = new Scanner(System.in);
		String nombre;
		int dni;
		int nota;

		System.out.println("Nombre del alumno " + mensaje + ": ");
		nombre = scan.nextLine();
		System.out.println("Dni del alumno " + mensaje + ": ");
		dni = scan.nextInt();
		nota = pedirNumero("Nota del alumno " + mensaje + ": ", 10);
		// scan.close();
		return (nombre + ":" + dni + ":" + nota);
	}

}

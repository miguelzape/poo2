package es.curso.java.arrays;

import java.util.Scanner;

public class notasAlumnos {
	public static void main(String[] arg) {
		Scanner scan;
		scan = new Scanner(System.in);
		int nNotas;
		float notas[];
		float ordenadas[];
		String duplaNomNota[] = { "Alumno1:9", "Alumno2:8", "Alumno3:3", "Alumno4:4", "Alumno5:5", "Alumno6:10",
				"Alumno7:4" };
		String aprobados[];
		float sumatorio = 0;
		float maximo = 0;
		float minimo = 99999.0f;
		float aux;
		int nAprobados;

		do {
			System.out.println("\nCuantos alumnos tiene la clase: [1 a 10]");
			nNotas = scan.nextInt();
		} while (nNotas < 1 && nNotas > 10);

		notas = new float[nNotas];
		// ordenadas = new float[nNotas];

		for (int i = 0; i < nNotas; i++) {
			System.out.printf("Nota del alumno %d: ", i + 1);
			notas[i] = (float) scan.nextDouble();
		}

		for (float nota : notas) {
			sumatorio += nota;
			if (nota > maximo)
				maximo = nota;
			if (nota < minimo)
				minimo = nota;
		}

		System.out.printf("\nNota Media: %.2f\nNota maxima: %.2f\nNota minima: %.2f", sumatorio / notas.length, maximo,
				minimo);

		// Ordenar array
		ordenadas = notas.clone();
		for (int i = 0; i < nNotas; i++) {
			for (int j = i + 1; j < nNotas; j++) {
				if (ordenadas[i] < ordenadas[j]) {
					aux = ordenadas[i];
					ordenadas[i] = ordenadas[j];
					ordenadas[j] = aux;
				}
			}
		}

		System.out.println("\nLas notas ordenadas de mayor a menor son: ");
		for (float nota : ordenadas) {
			System.out.println(nota);
		}

		// Comprobar el numero de aprobados
		nAprobados = 0;
		int pos;
		for (String dupla : duplaNomNota) {
			pos = dupla.indexOf(':');
			if (Integer.parseInt(dupla.substring(pos + 1)) >= 5)
				nAprobados++;
		}

		aprobados = new String[nAprobados];
		int i = 0;

		//rellenar el array de nombres de aprobados
		for (String dupla : duplaNomNota) {
			pos = dupla.indexOf(':');
			if (Integer.parseInt(dupla.substring(pos + 1)) >= 5) {
				aprobados[i] = dupla.substring(0, pos);
				i++;
			}
		}

		//imprimir nombre de aprobados
		System.out.println("\nLista de aprobados: ");
		for (String nombre : aprobados) {
			System.out.println(nombre);
		}

		scan.close();
	}

}

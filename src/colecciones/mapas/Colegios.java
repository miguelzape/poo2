package colecciones.mapas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import colecciones.Alumno;
import utils.Utilidades;

public class Colegios {

	public static void main(String[] args) {

		Alumno al1 = new Alumno("1", "Paco", "Gonzalez", 5.0);
		Alumno al2 = new Alumno("2", "Ana", "Torres", 7.8);
		Alumno al3 = new Alumno("3", "Luis", "Atolondrao", 6.7);
		Alumno al4 = new Alumno("4", "Maria", "Perez", 9.1);

		Alumno[] alumnos = { al1, al2, al3, al4 };

		Alumno al5 = new Alumno("5", "Pacos", "Gonzaleses", 6.0);
		Alumno al6 = new Alumno("6", "Anas", "Torreses", 6.8);
		Alumno al7 = new Alumno("7", "Luises", "Atolondraos", 8.7);
		Alumno al8 = new Alumno("8", "Marias", "Pereses", 9.2);

		Map<String, Alumno> alumnado = new HashMap<>();
		for (Alumno alum : alumnos) {
			alumnado.put(alum.getDni(), alum);
		}

		// mostrar informacion de todos los alumnos
		System.out.println(alumnado);

		String dni = Utilidades.pideCadena("Escriba el DNI de un alumno");

		if (alumnado.containsKey(dni))
			System.out.println(alumnado.get(dni));
		else
			System.out.println("No hay ningun alumno con ese DNI");

		// mostar la nota media de todos los alumnos
		double sumaNotas = 0;
		for (Alumno alum : alumnado.values()) {
			sumaNotas += alum.getNota();
		}
		System.out.println("La nota media de todos los alumnos es :" + sumaNotas / alumnado.size());

		List<Alumno> grupo1 = Arrays.asList(alumnos);
		List<Alumno> grupo2 = new ArrayList<>();

		grupo2.add(al5);
		grupo2.add(al6);
		grupo2.add(al7);
		grupo2.add(al8);

		Map<String, List<Alumno>> colegios = new HashMap<>();

		colegios.put("Los mataos", grupo1);
		colegios.put("Los ricos", grupo2);

		for (String colegio : colegios.keySet()) {
			System.out.println("El colegio " + colegio + " tiene estos alumnos");
			System.out.println(colegios.get(colegio));
		}

		dni = Utilidades.pideCadena("\nEscriba el DNI de un alumno para buscar su colegio: ");
		
		String colegioLocalizado=null;

		for (String c : colegios.keySet()) {
			for (Alumno a : colegios.get(c)) {
				if (a.getDni().equals(dni)) {
					colegioLocalizado=c;
				}
			}
		}
		
		if (colegioLocalizado==null) {
			System.out.println("No se ha encontrado ese alumno en ningun colegio");
		}
		else {
			System.out.println("El alumno con DNI " + dni + " va al colegio " + colegioLocalizado);
		}

	}
}

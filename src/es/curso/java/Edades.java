package es.curso.java;

import java.time.LocalDate;

public class Edades {
	public static void main(String[] arg) {
		String nombre = "Pedro";
		String apellido = "Salas";
		String paridad;
		int anio = 1997;
		int year;

		year = LocalDate.now().getYear();

		paridad = ((anio % 2) == 0) ? "par" : "impar";

		System.out.println("La edad de " + nombre + " " + apellido + " es " + (year - anio));
		System.out.println("El año de nacimiento es " + paridad);
	}

}

package colecciones;

import java.util.ArrayList;

import utils.Utilidades;

public class ListaAlumnos {

	public static void main(String[] args) {

		ListaAlumnos LA = new ListaAlumnos();
		LA.proceso();
	}

	private void proceso() {
		Alumno a1 = new Alumno("11", "Luis", "Garcia");
		Alumno a2 = new Alumno("22", "Marta", "Huerta");
		Alumno a3 = new Alumno("33", "Tomas", "Lopez");
		Alumno a4 = new Alumno("44", "Jorge", "Hidalgo");

		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

		String dni;
		int indice;

		if (listaAlumnos.isEmpty()) {
			listaAlumnos.add(a1);
			listaAlumnos.add(a2);
			listaAlumnos.add(a3);
			listaAlumnos.add(a4);
		}
		verLista(listaAlumnos);

		dni = Utilidades.pideCadena("Escriba el DNI del alumno a borrar");

		indice = buscarPorDNI(listaAlumnos, dni);

		if (indice >= 0) {
			listaAlumnos.remove(indice);
		}

		verLista(listaAlumnos);

		dni = Utilidades.pideCadena("Escriba el DNI de un alumno para cambiarle el nombre");

		indice = buscarPorDNI(listaAlumnos, dni);

		if (indice >= 0) {
			Alumno x = listaAlumnos.get(indice);
			x.setNombre("nuevo nombre");
		}

		verLista(listaAlumnos);

	}

	private void verLista(ArrayList<Alumno> listaAlumnos) {

		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno);
		}
	}

	private int buscarPorDNI(ArrayList<Alumno> listaAlumnos, String dni) {
		int i = 0;
		int indice = -1;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getDni().equalsIgnoreCase(dni)) {
				indice = i;
			}
			i++;
		}
		if (indice < 0)
			System.out.println("No hay ningun alumno con DNI= " + dni);

		return indice;
	}

}

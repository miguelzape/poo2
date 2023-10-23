package miniExamen;

import utils.Utilidades;

public class Colegio2 {

	public static void main(String[] args) {

		// String alumnos[][];
		int opcion = 0;
	
		final String menu[] = { "Insertar Alumno", "Mostrar alumnos por aula",
				"Mostrar todos los alumnos aprobados en el colegio", "Buscar alumno por DNI",
				"Borrar alumno por DNI", "Salir" };

//      int aulas
//		aulas = pedirNumero("Cuantas aulas tiene el colegio: ", 5);
//		String alumnos = new String[aulas][];
		String alumnos[][] = { { "pepe:453534:5", null, null }, { "juan:534534:7", null }, { "maria:23454:8", null } };

//		for (int i = 0; i < aulas; i++) {
//			nAlumnos = pedirNumero("Cuantos plazas tiene el aula " + (i + 1) + ": ", 20);
//			alumnos[i] = new String[nAlumnos];
//		}
		

		do {

			opcion = Utilidades.generaMenu(menu);
	
			switch (opcion) {
			case 1:
				// insertar un nuevo alumno
				insertarNuevoAlumno(alumnos);
				break;
			case 2:
				// Mostrar alumnos por aula
				mostrarAlumnosPorAula(alumnos);
				break;
			case 3:
				// Mostrar solo los alumnos aprobados
				verAlumnosAprobados(alumnos);
				break;
			case 4:
				// Buscar alumno por DNI
				 buscarAlumnoPorDNI(alumnos);
				break;
			case 5:
				// Borrar alumno por DNI
				borrarAlumnoPorDNI(alumnos);
				break;
			case 6:
				break;
			default:
				System.out.println("\nOpcion no disponible\n");
			}
		} while (opcion != 6);

	}

	public static String cogerDatosAlumno(String mensaje) {

		String nombre;
		int dni;
		int nota;

		nombre = Utilidades.pideCadena("Nombre del alumno " + mensaje + ": ");
		dni = Utilidades.pideNumero("Dni del alumno " + mensaje + ": ");
		nota = Utilidades.pideNumero("Nota del alumno " + mensaje + ": ", 0, 10);

		return (nombre + ":" + dni + ":" + nota);
	}

	public static void verAlumnosAprobados(String alumnos[][]) {
		System.out.println("\nDatos de los alumnos aprobados");

		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < alumnos[i].length; j++) {
				if (alumnos[i][j] != null) {
					if (Integer.parseInt(alumnos[i][j].split(":")[2]) >= 5) {
						System.out.println(
								"Clase " + (i + 1) + " nº " + (j + 1) + ": " + alumnos[i][j].replace(':', '\t'));
					}
				}
			}
		}

	}

	public static int buscarPosicionLibre(String alumnos[]) {
		int t = alumnos.length;
		for (int i = 0; i < t; i++)
			if (alumnos[i] == null)
				return (i);
		return (-1);
	}

	public static int buscarPosicionPorDNI(String alumnos[][], int dni, boolean borrar) {

		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < alumnos[i].length; j++) {
				if (alumnos[i][j] != null) {
					if (Integer.parseInt(alumnos[i][j].split(":")[1]) == dni) {
						if (borrar)
							alumnos[i][j] = null;
						return (i);
					}
				}
			}
		}
		return (-1);

	}

	// insertar un nuevo alumno
	static void insertarNuevoAlumno(String alumnos[][]) {
		int numeroClase;
		int aulas;
		int posicionLibre;

		aulas = alumnos.length;
		numeroClase = Utilidades.pideNumero("En que clase quiere insertarlo ", 1, aulas);
		posicionLibre = buscarPosicionLibre(alumnos[numeroClase - 1]);
		if (posicionLibre < 0) {
			System.out.println("No queda sitio libre en la clase " + numeroClase);
		} else {
			alumnos[numeroClase - 1][posicionLibre] = cogerDatosAlumno(
					"nº " + (posicionLibre + 1) + " aula " + numeroClase);
		}
	}

	// mostrar alumnos por aula
	static void mostrarAlumnosPorAula(String alumnos[][]) {
		int numeroClase;
		int aulas = alumnos.length;
		numeroClase = Utilidades.pideNumero("De que clase quiere ver sus alumnos", 1, aulas);
		for (int i = 0; i < alumnos[numeroClase - 1].length; i++) {
			if (alumnos[numeroClase - 1][i] != null) {
				System.out.println(alumnos[numeroClase - 1][i].replace(':', '\t'));
			}
		}
	}

	// buscar alumno por DNI
	static void buscarAlumnoPorDNI (String alumnos[][])
	{
		int nDni;
		int aux;
		nDni = Utilidades.pideNumero("Escriba el DNI del alumno que busca: ");
		aux = buscarPosicionPorDNI(alumnos, nDni, false);
		System.out.println(aux < 0 ? "DNI no encontrado" : "El alumno esta en el aula " + (aux + 1));
		System.out.println();
	}
	
	//borrar alumnos por DNI
	static void borrarAlumnoPorDNI (String alumnos[][])
	{
		int nDni;
		int aux;
		nDni = Utilidades.pideNumero("Escriba el DNI del alumno que quiere borrar: ");
		aux = buscarPosicionPorDNI(alumnos, nDni, true);
		System.out.print(aux < 0 ? "DNI no encontrado" : "El alumno ha sido borrado");
	}

}

package colecciones.mapas.biblioteca;

import utils.Utilidades;

public class GestionBiblioteca {

	public static void main(String[] args) {

		GestionBiblioteca gestion = new GestionBiblioteca();
		gestion.menuBiblioteca();

	}

	private void menuBiblioteca() {

		Biblioteca biblioteca = new Biblioteca("Moderna");
		Libro l1 = new Libro("Tiburon", "Pepito Lumbreras", 1);
		Libro l2 = new Libro("Biblia", "Varios autores", 2);
		Libro l3 = new Libro("Lazarillo", "Desconocido", 2);
		String titulo;

		biblioteca.agregarLibro(l1);
		biblioteca.agregarLibro(l2);
		biblioteca.agregarLibro(l3);

		final String[] menu = { "Agregar nuevo libro", "Prestar libro", "Devolver libro",  "Terminar" };
		int opcion = 0;

		while (opcion != 4) {
			biblioteca.verTitulos();
			opcion = Utilidades.generaMenu(menu);

			switch (opcion) {
			// agregar nuevo libro
			case 1:
				Libro nuevo = new Libro();
				biblioteca.agregarLibro(nuevo);
				break;
			// prestar libro
			case 2:
				titulo = Utilidades.pideCadena("Titulo del libro a prestar: ");
				biblioteca.prestarLibro(titulo);
				break;
			// devolver libro
			case 3:
				titulo = Utilidades.pideCadena("Titulo del libro a devolver: ");
				biblioteca.devolverLibro(titulo);
				break;
		
			}

		}

	}

}

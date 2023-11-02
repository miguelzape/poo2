package colecciones.mapas.biblioteca;

import java.util.Collections;

import utils.Utilidades;

public class GestionBiblioteca {

	public static void main(String[] args) {

		GestionBiblioteca gestion = new GestionBiblioteca();
		gestion.menuBiblioteca();

	}

	private void menuBiblioteca() {

		Biblioteca biblioteca = new Biblioteca("Moderna");
		String titulo;

		biblioteca.agregarLibro(new Libro("Tiburon", "Pepito Lumbreras", 1));
		biblioteca.agregarLibro(new Libro("Biblia", "Varios autores", 2));
		biblioteca.agregarLibro(new Libro("Lazarillo", "Desconocido", 2));

		final String[] menu = { "Agregar nuevo libro", "Prestar libro", "Devolver libro", "Salir de la biblioteca" };
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
			// devolver libro
			case 4:
				System.out.println("Adios. Vuelva pronto");
				break;

			}
		}
	}
}

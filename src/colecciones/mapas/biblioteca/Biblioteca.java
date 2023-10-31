package colecciones.mapas.biblioteca;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Biblioteca {

	private String nombre;
	private Map<String, Libro> libros = new HashMap<>();

	public Biblioteca(String nombre) {
		super();
		this.nombre = nombre;
		//this.libros = null;
	}

	// funcion para agregar un nuevo libro
	// devuelve true si ya existia y false si el nuevo
	public boolean agregarLibro(Libro libro) {
		return (this.libros.put(libro.getTitulo().toLowerCase(), libro) != null);
	}

	// funcion para prestar un nuevo libro
	// devuelve el total de copias existentes
	public int prestarLibro(String titulo) {
		
		int nCopias=0;
		
		titulo = titulo.toLowerCase();
		if (this.existeLibro(titulo)) {
			if (!this.libros.get(titulo).restaCopia())
			{
				System.out.println("No hay copias disponibles de " + titulo);
				nCopias= this.libros.get(titulo).getnCopias();
			}
		}
		else
		{
			System.out.println("No existe el libro: " + titulo);
		
		}
		return nCopias;

	}

	// funcion para devolver un nuevo libro
	// devuelve el total de copias existentes
	public int devolverLibro(String titulo) {
		
		titulo = titulo.toLowerCase();
		if (existeLibro(titulo)) {
			return this.libros.get(titulo).sumaCopia();
		}
		else {
			System.out.println("la biblioteca " + this.nombre + " no posee " + titulo);
			return 0;
		}
	}
	
	public boolean existeLibro (String libro) {
		libro = libro.toLowerCase();
		return (this.libros.containsKey(libro));
	}
	
	public void verTitulos () {
		final String WHITE = "\033[0;37m";    // WHITE
		final String RED = "\033[0;31m";      // RED
		System.out.println("La biblioteca " + this.nombre + " tiene estos libros:  ");
		
		for (Libro libro : this.libros.values()) {
			System.out.printf("%s%s (%d), ",libro.hayCopias()?WHITE:RED, libro.getTitulo(),libro.getnCopias());
		}
		System.out.print(WHITE + ".\n");
		
	}

}

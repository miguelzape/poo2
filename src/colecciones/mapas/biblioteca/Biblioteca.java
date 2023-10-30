package colecciones.mapas.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

	private String nombre;
	private Map<String, Libro> libros = new HashMap<>();

	public Biblioteca(String nombre) {
		super();
		this.nombre = nombre;
		this.libros = null;
	}

	// funcion para agregar un nuevo libro
	// devuelve true si ya existia y false si el nuevo
	public boolean agregarLibro(Libro libro) {
		return (this.libros.put(libro.getTitulo(), libro) != null);
	}

	// funcion para prestar un nuevo libro
	// devuelve true si se puede prestar y false si no hay copias
	public boolean prestarLibro(String titulo) {
		if (this.existeLibro(titulo)) {
			if (this.libros.get(titulo).restaCopia())
				return true;
			else {
				System.out.println("No hay copias disponibles de " + titulo);
				return false;
			}
		}
		else
		{
			System.out.println("No existe el libro: " + titulo);
			return false;
		}
	}

	// funcion para devolver un nuevo libro
	// devuelve el total de copias existentes
	public int devolverLibro(String titulo) {
		if (existeLibro(titulo)) {
			return this.libros.get(titulo).sumaCopia();
		}
		else {
			System.out.println("la biblioteca " + this.nombre + " no posee " + titulo);
			return 0;
		}
	}
	
	public boolean existeLibro (String libro) {
		return (this.libros.containsKey(libro));
	}
	
	public void verTitulos () {
		
		
	}

}

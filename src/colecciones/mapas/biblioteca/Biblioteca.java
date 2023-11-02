package colecciones.mapas.biblioteca;

import java.util.Map;
import java.util.TreeMap;

import utils.EnumColor;

public class Biblioteca {

	private String nombre;
	private Map<String, Libro> libros = new TreeMap<>();

	public Biblioteca(String nombre) {
		super();
		this.nombre = nombre;
	}

	// funcion para agregar un nuevo libro
	// devuelve true si ya existia y false si el nuevo
	public boolean agregarLibro(Libro libro) {
		return (this.libros.put(libro.getTitulo().toLowerCase(), libro) != null);
	}
	

	// funcion para prestar un nuevo libro
	public void prestarLibro(String titulo) {

		titulo = titulo.toLowerCase();
		if (this.existeLibro(titulo)) {
			if (!this.libros.get(titulo).restaCopia()) {
				System.out.println("No hay copias disponibles de " + titulo);
			}
		} else {
			System.out.println("No existe el libro: " + titulo);
		}
	}

	// funcion para devolver un nuevo libro
	// devuelve el total de copias existentes
	public int devolverLibro(String titulo) {

		titulo = titulo.toLowerCase();
		if (existeLibro(titulo)) {
			return this.libros.get(titulo).sumaCopia();
		} else {
			System.out.println("la biblioteca \'" + this.nombre + "\' no posee " + titulo);
			return 0;
		}
	}

	public boolean existeLibro(String libro) {
		return (this.libros.containsKey(libro.toLowerCase()));
	}

	public void verTitulos() {
		System.out.println("La biblioteca \'" + this.nombre + "\' tiene estos libros:  ");
		for (Libro libro : this.libros.values()) {
			System.out.printf("%s%s (%d), ", libro.hayCopias() ? EnumColor.WHITE : EnumColor.RED, libro.getTitulo(),
					libro.getnCopias());
		}
		System.out.print(EnumColor.WHITE + ".\n");
	}

	// metodos get
	public String getNombre() {
		return nombre;
	}

	public Map<String, Libro> getLibros() {
		return libros;
	}

}

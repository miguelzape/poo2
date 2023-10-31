package colecciones.mapas.biblioteca;

import java.util.Comparator;

public class ComparaLibro implements Comparator<Libro> {
	
	public int compare(Libro l1,Libro l2) {
		return l1.getTitulo().compareTo(l2.getTitulo());
	}

}

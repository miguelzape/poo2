package colecciones.mapas.biblioteca;

import utils.Utilidades;

public class Libro {
	
	private String titulo;
	private String autor;
	private int nCopias;
	
	
	// Constructores
	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.nCopias=0;
	}

	public Libro(String titulo, String autor, int nCopias) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.nCopias = nCopias;
	}
	
	public Libro() {
		super();
		System.out.println("Introduzca los datos de un nuevo libro");
		this.titulo = Utilidades.pideCadena("Titulo: ");
		this.autor = Utilidades.pideCadena("Autor: ");
		this.nCopias = Utilidades.pideNumero("Numero de copias disponibles: ");
	}
	
	// funcion que dice se hay copias disponibles
	public boolean hayCopias() {
		return (this.nCopias>0);
	}
	
	
	// funcion que resta una copia
	// devuelve true si se puede restar y false si no existen copias
		public boolean restaCopia() {
			if (nCopias>0) {
				this.nCopias--;
				return true;
			}
			return false;
		}
		
	// funcion que añade una copia
	// devuelve el total disponible
		public int sumaCopia() {
			this.nCopias++;
			return (this.nCopias);
		}
		

	
	//metodos get y set
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getnCopias() {
		return nCopias;
	}

	public void setnCopias(int nCopias) {
		this.nCopias = nCopias<0 ? 0 : nCopias;
	}

	
	// metodo toString
	@Override
	public String toString() {
		return "Titulo=" + titulo + ", Autor=" + autor + ". Tenemos " + nCopias + " copias";
	}
	
	
	
	
}

package oop.herencia.Hospital;


public class Habitacion {
	private int numero;
	private Enfermo enfermo;
	private static int elementos=0;
	
	
	public Habitacion() {
		this.numero = ++elementos;
		this.enfermo = null;
	}


	public int getNumero() {
		return numero;
	}


	public Enfermo getEnfermo() {
		return enfermo;
	}
	
	
	public void setEnfermo(Enfermo enfermo) {
		this.enfermo = enfermo;
	}


	@Override
	public String toString() {
		return "Habitacion [numero=" + numero + ", enfermo=" + enfermo + "]";
	}
	
	
	
	
}

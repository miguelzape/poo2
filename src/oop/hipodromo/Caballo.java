package oop.hipodromo;

import utils.Utilidades;

public class Caballo {
	 private int id;
	 private String nombre;
	 private int dorsal;
	 private int edad;
	 private int velocidad;
     private int peso;
     private int avance;
     
	public Caballo(int id, String nombre, int dorsal, int edad, int velocidad, int peso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.edad = edad;
		this.velocidad = velocidad;
		this.peso = peso;
		this.avance=0;
	}
	
	public Caballo(int id, String nombre, int dorsal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.edad = (int) Utilidades.aleatorio(5, 20);
		this.velocidad = (int) Utilidades.aleatorio(40, 80);
		this.peso = (int) Utilidades.aleatorio(200, 400);
		this.avance=0;
		
	}

	@Override
	public String toString() {
		return "\n\t\tCaballo [id=" + id + ", nombre=" + nombre + ", dorsal=" + dorsal + ", edad=" + edad + ", velocidad="
				+ velocidad + ", peso=" + peso + "]";
	}

	public int correr()
	{
		int nuevo;
		nuevo=(int) ((this.velocidad * Utilidades.aleatorio(1, 20)) - (this.peso *Utilidades.aleatorio(1,3))
				- (this.edad*Utilidades.aleatorio(1, 3)));
		
		if (nuevo<0) nuevo=1;
		this.avance += nuevo;
		
		System.out.println("Caballo "+ this.dorsal + " avanza " + nuevo + " metros" );
		return(this.avance);
	}
	
	public void reset()
	{
		this.avance=0;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public int getEdad() {
		return edad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getPeso() {
		return peso;
	}

	public int getAvance() {
		return avance;
	}
	
	/* si es su id devuelve la informacion del caballo gador
	 * en caso contrario devuelve -1*/
	public String verDatosGanador() {
		String cadena=null;
		cadena=("Ha ganado " + this.nombre + ". Con dorsal nº" + this.dorsal);
		return cadena;
	}
	
	
	
}



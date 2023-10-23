package oop.hipodromo;

import java.util.Arrays;

public class Carrera {

//	Clase Carrera
//	+ id
//	+ nombre
//	+ Caballo[]
//	+ distancia
//	
//	iniciarCarrera()
//		todos los caballos asignados a la carrera se pongan a correr
//		
//	 Devolver caballo ganador

	private int id;
	private String nombre;
	private Caballo caballos[];
	private int distancia;


	public Carrera(int id, String nombre, int distancia, Caballo... caballos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.caballos = caballos;
		this.distancia = distancia;
	}

	// devuelve el id del caballo ganador
	public int iniciarCarrera() {

		// iniciar todos los caballos a avance 0
		for (Caballo c : this.caballos) {
			c.reset();
		}

		System.out.println("\nComienza la carrera de " + this.nombre);
		while (true) {
			for (int i = 0; i < this.caballos.length; i++) {
				Caballo c = this.caballos[i];
				
				if (c.correr() >= this.distancia) {
					System.out.println("Fin de la carrera");
					System.out.println("Ha ganado el caballo " + c.getNombre() + " con dorsal " + c.getDorsal());
					return c.getId();
				}
			}
		}
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Caballo[] getCaballos() {
		return caballos;
	}

	public int getDistancia() {
		return distancia;
	}

	@Override
	public String toString() {
		return "\n\tCarrera [id=" + id + ", nombre=" + nombre  + ", distancia="
				+ distancia + "m, caballos=" + Arrays.toString(caballos) + "]";
	}
	
	

}

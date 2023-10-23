package oop.herencia.Hospital;

import java.security.SecureRandom;

public abstract class Persona {
	private int id;
	private String nombre;
	private int edad;
	private static int elementos = 0;

	public Persona() {
		String nombres[] = { "Paco", "Juan", "Alicia", "Manolo", "Roberto", "Sara", "Maria", "Tamara", "Luis", "Tomas",
				"Lola", "Penelope", "Sancho", "Luna", "Angel", "Andres" };

		SecureRandom r = new SecureRandom();
		this.nombre = nombres[r.nextInt(0, nombres.length - 1)];
		this.id = ++elementos;
		this.edad = r.nextInt(18, 70);
	}

	public Persona(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}


	public abstract void comer();

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	

}

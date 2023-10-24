package utils;

import java.security.SecureRandom;

public class Persona {
	private int id;
	private String dni;
	private String nombre;
	private int edad;
	private static int elementos = 0;

	public Persona() {
		String nombres[] = { "Paco", "Juan", "Alicia", "Manolo", "Roberto", "Sara", "Maria", "Tamara", "Luis", "Tomas",
				"Lola", "Penelope", "Sancho", "Luna", "Angel", "Andres","Antonio","Lorena",
				 "David","Ana","Pedro","Pablo","Ramiro","Aitana","Nerea"};
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		// 23 letras
		
		SecureRandom r = new SecureRandom();
		this.nombre = nombres[r.nextInt(0, nombres.length - 1)];
		this.id = ++elementos;
		this.edad = r.nextInt(18, 70);
		
		int numeroDNI= r.nextInt(100,999);
		this.dni=String.format("%d%s",numeroDNI,letras[numeroDNI % 23]);
	}

	public Persona(int id, String dni,String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = (edad>=0) ? edad : 0;
		this.dni=dni;
	}


	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
	
	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	
	
	

}

package oop.hipodromo;

import java.util.Arrays;

public class GranPremio {
	private int id;
	private String nombre;
	private Carrera carreras[];
	
	
	public GranPremio(int id, String nombre, Carrera... carreras) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.carreras = carreras;
	}
	@Override
	public String toString() {
		return "GranPremio [id=" + id + ", nombre=" + nombre + ", carreras=" + Arrays.toString(carreras) + "]";
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Carrera[] getCarreras() {
		return carreras;
	}
	
	
	

}

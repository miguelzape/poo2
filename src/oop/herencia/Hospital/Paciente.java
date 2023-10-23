package oop.herencia.Hospital;

import java.security.SecureRandom;
import java.util.Arrays;

public final class Paciente extends Persona{
	private String sintomas[];
	
	public Paciente() {
		super();
		String Todos[]= {"Tos","Fiebre","Sueño","Hambre","Orina roja","Dolor de cabeza","Mareos",
	            "Insomnio","Apatia","Dolor de bolsillo","Dolor de pies","Alitosis"};
		SecureRandom r=new SecureRandom();
		this.sintomas = new String[]{Todos[r.nextInt(0,Todos.length)],Todos[r.nextInt(0,Todos.length)]};
	}
	
	
	public Paciente(int id, String nombre, int edad,String[] sintomas) {
		super(id, nombre, edad);
		this.sintomas=sintomas;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Paciente [sintomas=" + Arrays.toString(sintomas) + 
				", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + "]";
	}


	@Override
	public void comer() {
		System.out.println(this.getNombre() + " está comiendo en la cafeteria");
	}

	public String[] getSintomas() {
		return sintomas;
	}
	
	
	
	

}

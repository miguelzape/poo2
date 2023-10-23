package oop.herencia.Hospital;

public class Enfermo extends Persona {
	
	private String enfermedad;
	
	public Enfermo(String enfermedad) {
		super();
		this.enfermedad = enfermedad;
	}
	

	public Enfermo(int id, String nombre, int edad, String enfermedad) {
		super(id, nombre, edad);
		this.enfermedad=enfermedad;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void comer() {
		System.out.println(this.getNombre() + " está comiendo en la habitación");
	}

	public String getEnfermedad() {
		return enfermedad;
	}


	@Override
	public String toString() {
		String aux=super.toString();
		return "Enfermo [" + aux +" enfermedad=" + enfermedad + "]";
	}
	
	
}

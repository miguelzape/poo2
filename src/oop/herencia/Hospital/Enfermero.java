package oop.herencia.Hospital;



public final class Enfermero extends EmpleadoHospital {
	 private int planta;
	 
	 public Enfermero(int planta) {
		super();
		this.planta = planta;
	}
	 
	 
	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}


	public void atenderPaciente() {
		 
	
	 }
}

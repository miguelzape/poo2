package oop.herencia.Hospital;

import java.security.SecureRandom;

public class EmpleadoHospital extends Persona {
	
	Turno turno;

	public EmpleadoHospital() {
		super();
		SecureRandom r=new SecureRandom();
		int numero=r.nextInt(0,2);
		this.turno = Turno.values()[numero];
	}

	@Override
	public void comer() {
		System.out.println(this.getNombre() + " está comiendo en el comedor");
	}
	
	public void fichar() {
		System.out.println(this.getNombre() + " está fichando");		

		
	}
}

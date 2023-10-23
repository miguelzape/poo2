package oop.herencia.Hospital;

import java.security.SecureRandom;

import utils.Utilidades;

public class Doctor extends EmpleadoHospital {
	
	private String especialidad;

	public Doctor(String especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}
	
	public Enfermo diagnosticar(Paciente p) {
		SecureRandom r= new SecureRandom();
		int numero = r.nextInt(0,10);
		Enfermo enfermo=null;
		String enfermedad;
				
		if (numero >= 8) {
			System.out.printf("El paciente %s tiene estos sintomas\n", p.getNombre());
			System.out.println(p.getSintomas()[0]);
			System.out.println(p.getSintomas()[1]);
		    enfermedad=Utilidades.pideCadena("\n¿que enfermedad tiene este paciente?");  
		    enfermo=new Enfermo(p.getId(),p.getNombre(),p.getEdad(),enfermedad);
		}
		else
		{
			System.out.printf("El paciente %s está sano. Puede irse\n", p.getNombre());
		}
		return enfermo;
	}
	

}

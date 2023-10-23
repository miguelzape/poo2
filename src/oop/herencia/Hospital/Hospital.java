package oop.herencia.Hospital;

public class Hospital {

	String nombre;

	public static void main(String[] args) {
		Hospital hp = new Hospital("Hospital grande");
		hp.abrirHospital();

	}

	public Hospital(String nombre) {
		super();
		this.nombre = nombre;
	}

	private void abrirHospital() {
		Habitacion habitaciones[] = new Habitacion[2];
		habitaciones[0] = new Habitacion();
		habitaciones[1] = new Habitacion();
		Paciente pacientes[] = new Paciente[3];
		pacientes[0] = new Paciente();
		pacientes[1] = new Paciente();
		pacientes[2] = new Paciente();
		Enfermero enfermero = new Enfermero(1);
		Doctor doctor = new Doctor("Ninguna");
		Paciente salaEspera[] = pacientes;

		EmpleadoHospital empleados[] = { enfermero, doctor };

		System.out.println("Abre sus puertas el " + this.nombre);
		ficharTodos(empleados);
		comerTodos(empleados, pacientes);
		diagnosticaPacientes(salaEspera, doctor, habitaciones);
		
		for (Habitacion h:habitaciones)
		{
			System.out.println(h);
		}

	}

	private void ficharTodos(EmpleadoHospital... todos) {
		for (EmpleadoHospital e : todos) {
			e.fichar();
		}
	}

	private void comerTodos(Persona... todos) {
		for (Persona p : todos) {
			p.comer();
		}
	}

	private void comerTodos(Persona[] unos, Persona... otros) {
		for (Persona p : unos) {
			p.comer();
		}
		for (Persona p : otros) {
			p.comer();
		}
	}

	private void diagnosticaPacientes(Paciente[] salaEspera, Doctor doctor, Habitacion[] habitaciones) {
		int i = 0;
		Enfermo enf;
		int punteroHabitaciones = 0;
		for (Paciente p : salaEspera) {
			//System.out.println("Diagnosticando paciente " + i);
			enf = doctor.diagnosticar(p);
			salaEspera[i++] = null;
			if (enf != null) {
				if (punteroHabitaciones < 2) {
					habitaciones[punteroHabitaciones].setEnfermo(enf);
					System.out.printf("%s a ingresado en la habitacion %d\n", (p.getNombre()+1), punteroHabitaciones++);
				} else {
					System.out.printf("%s a ingresado en el pasillo\n", p.getNombre());
				}
			}
		}
	}

}

package oop;

//POJO
public class Persona {

	// Variables de instacia
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;

	// metodos
	public void correr() {
		System.out.println("La persona " + this + " esta corriendo.");
	}
	
	public String toString() {
		String cadena = nombre +":"+apellidos+":"+dni+":"+edad;
		return (cadena);
	}
	
	public void Persona(String...strings ) {
	
		if (strings.length>0) nombre=strings[0];
		if (strings.length>1) apellidos=strings[1];
		if (strings.length>2) dni=strings[2];
		if (strings.length>3) edad=Integer.parseInt(strings[3]);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}

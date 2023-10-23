package oop;

public class Alumno {
	String nombre;
	String apellidos;
	String dni;
	int nota;
	
	public Alumno() {}
	public Alumno(String dni, String nombre, String apellidos) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
	}
	
	public Alumno(String dni, String nombre, String apellidos,int nota) {
		this(dni,nombre,apellidos);
		this.nota=nota;
	}
	
	public Alumno(Alumno entrada) {
		this.clone(entrada);
	}
	
	public void estudiar() {
		int n=this.nota;
		String mensaje="";
		if (n==0) mensaje=" no ha estudiado nada";
		if (n>0 && n<5) mensaje=" ha estudiado poco";
		if (n>=5 && n<=9) mensaje=" ha estudiado mucho";
		if (n>9) mensaje=" es un genio";	
		System.out.println(this.nombre+ " "+ this.apellidos + mensaje);
	}
	
	public String toString()
	{
		return (nombre+":"+apellidos+":"+dni+":"+nota);
	}
	
	
	
	public void clone(Alumno entrada) {
		this.nombre=entrada.nombre;
		this.apellidos=entrada.apellidos;
		this.dni=entrada.dni;
		this.nota=entrada.nota;
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
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	

	
	
}

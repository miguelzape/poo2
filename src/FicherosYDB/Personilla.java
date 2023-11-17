package FicherosYDB;

public class Personilla {
	
	private String nombre;
	private String apellido;
	private String dni;
	private int extra1;
	private int extra2;
	
	
	public Personilla(String nombre, String apellido, String dni, int extra1, int extra2) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.extra1 = extra1;
		this.extra2 = extra2;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getDni() {
		return dni;
	}


	public int getExtra1() {
		return extra1;
	}


	public int getExtra2() {
		return extra2;
	}
	
	
	
	
	
	

}

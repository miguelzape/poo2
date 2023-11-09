package colecciones.mapas.futbol;

public class Jugador {
	private String nombre;
	private int edad;
	private String posicion;
	
	
	public Jugador(String nombre, int edad, String posicion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.posicion = posicion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	@Override
	public String toString() {
		//return  posicion + " se llama " + nombre + " y tiene " + edad + " años";
		return nombre + " es " + posicion + " de " + edad + " años";
	}
	
	
	
	

}

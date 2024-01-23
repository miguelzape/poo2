package propiedades;

import java.util.Arrays;

public class Ferreteria {
	
	private long id;
	private String nombre;
	private String direccion;
	private EnumTornillo[] tornillos;
	
	public Ferreteria(long id, String nombre, String direccion, EnumTornillo[] tornillos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tornillos = tornillos;
	}
	
	public Ferreteria() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public EnumTornillo[] getTornillos() {
		return tornillos;
	}

	public void setTornillos(EnumTornillo[] tornillos) {
		this.tornillos = tornillos;
	}

	@Override
	public String toString() {
		return "Ferreteria [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tornillos="
				+ Arrays.toString(tornillos) + "]";
	}
	
	
	
	
	
	

}

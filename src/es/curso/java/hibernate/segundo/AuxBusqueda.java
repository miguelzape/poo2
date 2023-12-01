package es.curso.java.hibernate.segundo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//@Entity
public class AuxBusqueda {
    //@Id
	private String tipo;
	private double precio;
	private long cuenta;
	
	
	public AuxBusqueda() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public AuxBusqueda(String tipo, double precio, long cuenta) {
		super();
		this.tipo = tipo;
		this.precio = precio;
		this.cuenta = cuenta;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public long getCuenta() {
		return cuenta;
	}


	public void setCuenta(long cuenta) {
		this.cuenta = cuenta;
	}


	@Override
	public String toString() {
		String respuesta = String.format
				("Tipo = %s, Precio medio = %.2f, Total = %d", tipo,precio,cuenta);
		return respuesta;
	}





	
	
	
}

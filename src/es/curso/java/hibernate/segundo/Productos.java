package es.curso.java.hibernate.segundo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name = "TB_Productos")
public class Productos {
	
//	NOMBRE;TIPO;FECHA_ALTA;PRECIO;UNIDADES
//	PRODUCTO1;TIPO1;2023-10-10;5000;3
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column (length=20)
	private String nombre;
	@Column (length=20)
	private String tipo;
	@Column (name="Fecha_Alta")
	private Date fechaAlta;
	private int precio;
	private int unidades;
	
	
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Productos(String nombre, String tipo, Date fechaAlta, int precio, int unidades) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.precio = precio;
		this.unidades = unidades;
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


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getUnidades() {
		return unidades;
	}


	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}


	@Override
	public String toString() {
		return "Producto: " + nombre + " de tipo=" + tipo + " con id=" + id 
				+", fecha de alta=" + fechaAlta.toGMTString()
				+ " y precio=" + precio + ". Stock=" + unidades + " unidades";
	}
	
	
	
	
	
	

}

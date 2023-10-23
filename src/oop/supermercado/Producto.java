package oop.supermercado;

import java.util.Random;

public class Producto {
	private int id;
	private String nombre;
	private float precio;
	private String tipo;
	private static int elementos = 0;

	public Producto(String nombre, float precio, String tipo) {
		super();
		Random r = new Random();
		this.id = ++elementos;
		this.nombre = nombre;
		this.precio = r.nextFloat(precio, precio + 2);
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getProducto();// "\nProducto [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ",
								// precio=" + precio + "]";
	}

	public float getPrecio() {
		return precio;
	}

	public String getProducto() {
		if (this != null) {
			return (this.tipo + " " + this.nombre);
		} else
			return "";
	}
	
	public static String[] nombres (Producto productos[]) {
		
		int productosValidos=0;
		for (Producto p:productos)
		{
			if (p!=null) ++productosValidos;
		}
		String cadenas[]= new String[productosValidos];
		for (int i=0, j=0;i<productos.length;i++)
		{
			if (productos[i] != null) { 
				cadenas[j]=productos[i].nombre;
				j++;
			}
		}
		return cadenas;
	}
	
	

}

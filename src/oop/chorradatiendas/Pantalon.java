package oop.chorradatiendas;

import utils.Utilidades;

public class Pantalon {
	private int id;
	private String color;
	private String talla;
	private float precio;
	private Boton boton;
	private static int elementos=0;
	/**
	 * @param id
	 * @param color
	 * @param talla
	 * @param precio
	 * @param boton
	 */
	public Pantalon(String color, String talla, Boton boton) {
		super();
		++elementos;
		this.id = elementos;
		this.color = color;
		this.talla = talla;
		this.precio = (float) Utilidades.aleatorio(15,70);
		this.boton = boton;
	}
	public Pantalon() {}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Boton getBoton() {
		return boton;
	}
	public void setBoton(Boton boton) {
		this.boton = boton;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "\n   Pantalon [id=" + id + ", color=" + color + ", talla=" + talla + ", precio=" + precio + ", boton="
				+ boton + "]";
	}
	
	
	
	
}

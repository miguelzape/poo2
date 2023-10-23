package oop.chorradatiendas;

import utils.Utilidades;

public class Vestido {
	private int id;
	 private String color;
	 private String talla;
	 private float precio;
	 private static int elementos=0;
	/**
	 * @param color
	 * @param talla
	 */
	public Vestido(String color, String talla) {
		super();
		++elementos;
		this.id=elementos;
		this.color = color;
		this.talla = talla;
		this.precio=(float) Utilidades.aleatorio(5,100);
	}
	public Vestido() {}
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
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "\n   Vestido [id=" + id + ", color=" + color + ", talla=" + talla + ", precio=" + precio + "]";
	}
	 
	 
}

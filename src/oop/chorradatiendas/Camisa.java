package oop.chorradatiendas;

import java.util.Arrays;

import utils.Utilidades;

public class Camisa {
	 private int id;
	 private String color;
	 private String talla;
	 private float precio;
	 private Boton botones[];
	 private static int elementos=0;
	/**
	 * @param color
	 * @param talla
	 * @param precio
	 * @param botones
	 */
	public Camisa(String color, String talla, Boton[] botones) {
		super();
		++elementos;
		this.id=elementos;
		this.color = color;
		this.talla = talla;
		this.precio = (float) Utilidades.aleatorio(10,80);
		this.botones = botones;	
	}
	public Camisa() {}
	
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
	public Boton[] getBotones() {
		return botones;
	}
	public void setBotones(Boton[] botones) {
		this.botones = botones;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "\n   Camisa [id=" + id + ", color=" + color + ", talla=" + talla + ", precio=" + precio + ", botones="
				+ Arrays.toString(botones) + "]";
	}
	 
	 
	 
	 

}

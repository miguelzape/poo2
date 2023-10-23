package oop.chorradatiendas;

public class Boton {
private int id;
private String forma;
private String color;
private int tamanio;
private static int elementos=0;
/**
 * @param id
 * @param forma
 * @param color
 * @param tamanio
 */
public Boton(String forma, String color, int tamanio) {
	super();
	++elementos;
	this.id = elementos;
	this.forma = forma;
	this.color = color;
	this.tamanio = tamanio;
}

public Boton() {}
public int getId() {
	return id;
}
//public void setId(int id) {
//	this.id = id;
//}
public String getForma() {
	return forma;
}
public void setForma(String forma) {
	this.forma = forma;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getTamanio() {
	return tamanio;
}
public void setTamanio(int tamanio) {
	this.tamanio = tamanio;
}
@Override
public String toString() {
	return "\n      Boton [id=" + id + ", forma=" + forma + ", color=" + color + ", tamaño=" + tamanio + "]";
}



}

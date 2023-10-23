package es.curso.java.funciones;

public class pruebas {
	public static void main(String[] args) {
		boolean w, x = true, y = true, z = false;
		w = x && y || x && z || y && z;
		System.out.print("El resultado es ");
		System.out.print(w);
	}
}
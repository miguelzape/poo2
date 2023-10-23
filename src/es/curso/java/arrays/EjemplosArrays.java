package es.curso.java.arrays;

public class EjemplosArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombres[] = { "uno", "dos", "tres", "cuatro","cinco"};
		int longitud;
		longitud = nombres.length;
		System.out.println(longitud);
		for (int i = 0; i < longitud; i++)
			System.out.println("nombre " + (i + 1) + ": " + nombres[i]);
	}
}


package oop.excepciones;

public class Cafeteria {

	private String nombre;

	public static void main(String[] args) {

		Cafeteria cft = new Cafeteria("La que no vende nada");
		cft.abrirCafeteria();
	}

	private void abrirCafeteria() {
		TazaCafe cafe;
		ClienteCafeteria pavo = new ClienteCafeteria("Tomasin");
		boolean clienteSatisfecho = false;
		
		System.out.printf("Se abre la cafeteria \"" + this.nombre + "\"\n");
	
		do {
			cafe = new TazaCafe();
			System.out.printf("Cafe a %.2f ºC\n", cafe.getTemperatura());
			try {
				clienteSatisfecho = pavo.tomarTazaCafe(cafe);
			} catch (TooColdTemperatureException e) {
				System.out.println("Está demasiado frio. Pongame otro");
			} catch (TooHotTemperatureExpection e) {
				System.out.println("Está demasiado caliente. Pongame otro");
			}
		} while (!clienteSatisfecho);
	}

	public Cafeteria(String nombre) {
		super();
		this.nombre = nombre;
	}

}

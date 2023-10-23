package es.curso.java.strings;

import java.util.Scanner;

public class ValidarCorreo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String correo = "";

		int aux1, aux2, aux3, aux4;
		// aux1 = indice de primera arroba
		// aux2 = indice de ultima arroba
		// aux3 = distancia entre @ y el siguiente punto (.)
		// aux4 = numero de caracteres despues del ultimo punto

		boolean c1, c2, c3, c4, c5;

		do {
			c3 = true;
			c4 = true;
			aux3 = -1;

			System.out.println("\nEscriba una direcion de correo para validarlo: ");
			correo = scan.nextLine();
			correo = correo.trim();
			

			// c1. comprobar si tiene una sola arroba
			aux1 = correo.indexOf('@');
			aux2 = correo.lastIndexOf('@');
			c1 = (aux1 > 0 && aux1 == aux2);

			// c2. comprobar si no contiene espacios en blanco intermedios
			c2 = correo.indexOf(' ') < 0;

			if (c1) {
				// estas comprobaciones solo se hacen si existe una arroba
				// c3. despues de la @ debe existir al menos un punto
				aux3 = correo.substring(aux1 + 1).indexOf('.');
				c3 = (aux3 >= 0);

				// c4. La distancia entre la @ y el primer '.' despues de esta debe ser al menos
				// 2 caracteres
				c4 = (aux3 >= 2);
			}

			// c5. Despues del ultimo punto debe haber entre 2 y 6 caracteres
			aux4 = (correo.length() - (correo.lastIndexOf('.') + 1));
			c5 = aux4 >= 2 && aux4 <= 6;


			if (c1 && c2 && c3 && c4 && c5)
				System.out.println("El correo es valido");
			else {
				System.out.println("El correo no es valido\n");
				if (!c1)
					System.out.println("Debe tener una y solo una arroba");
				if (!c2)
					System.out.println("No debe tener espacios en blanco en posiciones intermedias");
				if (!c3)
					System.out.println("Despues de la @ debe existir al menos un punto");
				if (!c4)
					System.out.println("La distancia entre la @ y el primer punto debe ser 2 o mas");
				if (!c5)
					System.out.println("Despues del ultimo punto debe haber entre 2 y 6 caracteres");
			}

		} while (!(c1 && c2 && c3 && c4 && c5));
		scan.close();
	}

}

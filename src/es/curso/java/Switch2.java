package es.curso.java;

import java.util.Scanner;

public class Switch2 {

	public static void main(String[] arg) {

		final String menu1 = "MENU\n\n1. Meses de cada estacion\n2. Leche\n3. Horchata\n4. Zumo\n5. Salir\n\nSelecciona una opción: ";
		final String menu2 = "ESTACIONES\n\n1. Primavera\n2. Verano\n3. Otoño\n4. Invierno\n\nSelecciona una opción para ver sus meses: ";
		final String estacionPrimavera = "Los meses de Primavera son: Abril, Mayo y Junio";
		final String estacionVerano = "Los meses de Verano son: Julio, Agosto y Septiembre";
		final String estacionOtono = "Los meses de Otoño son: Octubre, Noviembre y Diciembre";
		final String estacionInvierno = "Los meses de Invierno son: Enero, Febreno y Marzo";
		final String opcionIncorrecta = "Opción incorrecta";
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		int opcion2;

		while (opcion != 5) {

			System.out.println(menu1);
			opcion = scan.nextInt();
			switch (opcion) {
			case 1:
				System.out.println(menu2);
				opcion2 = scan.nextInt();
				switch (opcion2) {
				case 1:
					System.out.println(estacionPrimavera);
					break;
				case 2:
					System.out.println(estacionVerano);
					break;
				case 3:
					System.out.println(estacionOtono);
					break;
				case 4:
					System.out.println(estacionInvierno);
					break;
				default:
					System.err.println(opcionIncorrecta);
					break;
				}

				break;
			case 2:
				System.out.println("Leche");
				break;
			case 3:
				System.out.println("Horchata");
				break;
			case 4:
				System.out.println("Zumo");
				break;
			case 5:
				System.out.println("Hasta la vista");
				break;
			default:
				System.err.println(opcionIncorrecta);
			}
		}
		
		
		scan.close();

	}
}
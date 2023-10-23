package miniExamen;

import utils.Utilidades;

public class Calculadora {
	public static void main(String[] args) {
		calculadoraStandar();
	}

	static void calculadoraStandar() {
		int opcion;
		double valor = 0.0;
		int operador;
		final String MENU_SIMPLE[] = { "Suma", "Resta", "Multiplicacion", "Division", "Modo Cientifico", "Apagar" };

		System.out.println("El valor inicia para hacer calculos es " + valor);

		do {
			opcion = Utilidades.generaMenu(MENU_SIMPLE);

			switch (opcion) {
			case 1:
				operador = Utilidades.pideNumero("Valor a sumar: ");
				valor += operador;
				break;
			case 2:
				operador = Utilidades.pideNumero("Valor a restar: ");
				valor -= operador;
				break;
			case 3:
				operador = Utilidades.pideNumero("Valor para multiplicar: ");
				valor *= operador;
				break;
			case 4:
				operador = Utilidades.pideNumero("Valor para dividir: ");
				if (operador == 0)
					System.out.println("No se puede dividir entre 0");
				else
					valor /= operador;
				break;
			case 5:
				// Modo cientifico
				valor = calculadoraCientifica(valor);
				break;
			case 6:
				// salir
				break;
			}

			System.out.println("El resultado es: " + valor);

		} while (opcion != 6);
	}

	static double calculadoraCientifica(double valor) {
		int opcion;
		int operador;
		final String MENU_CIENTI[] = { "Potencia", "Raiz cuadrada", "Seno", "Coseno", "Modo Standar" };

		do {
			opcion = Utilidades.generaMenu(MENU_CIENTI);
			switch (opcion) {
			case 1:
				// calcular potencia
				operador = Utilidades.pideNumero("Valor para la potencia: ", -50, 50);
				valor = Math.pow(valor, operador);
				break;
			case 2:
				// calcular raiz cuadrada
				if (valor < 0)
					System.out.println("No existe la raiz de un número negativo");
				else
					valor = Math.sqrt(valor);
				break;
			case 3:
				// calcular seno
				valor = Math.sin(valor);
				break;
			case 4:
				// calcular coseno
				valor = Math.cos(valor);
				break;
			case 5:
				break;
			}
			System.out.println("El resultado es: " + valor);

		} while (opcion != 5);
		return valor;
	}

}

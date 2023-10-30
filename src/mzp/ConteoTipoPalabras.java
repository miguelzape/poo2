
package mzp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ConteoTipoPalabras {
	public static void main(String[] args) {
		// crea HashMap para almacenar claves String y valores Integer
		Map<String, Integer> miMap = new HashMap<>();

		crearMap(miMap); // crea un mapa con base en la entrada del usuario
		mostrarMap(miMap); // muestra el contenido del mapa
	}

	// crea mapa a partir de la entrada del usuario
	private static void crearMap(Map<String, Integer> mapa) {
		Scanner scanner = new Scanner(System.in); // crea scanner
		System.out.println("Escriba una cadena:"); // pide la entrada del usuario
		String entrada = scanner.nextLine().toLowerCase();

		// divide la entrada en tokens
		String[] tokens = entrada.split(" ");
		List<String> paraOrdenar = new ArrayList<>(Arrays.asList(tokens));

		Collections.sort(paraOrdenar);
		System.out.println("Las palabras anteriores, quedan asi ordenadas");
		System.out.println(paraOrdenar);

		// procesamiento del texto de entrada
		for (String token : tokens) {
			String palabra = token.toLowerCase(); // obtiene una palabra en minúsculas

			// si el mapa contiene la palabra
			if (mapa.containsKey(palabra)) // ¿está la palabra en el mapa?
			{
				int cuenta = mapa.get(palabra); // obtiene la cuenta actual
				mapa.put(palabra, cuenta + 1); // incrementa la cuenta
			} else
				mapa.put(palabra, 1); // agrega una nueva palabra con una cuenta de 1 al mapa
		}
	}

	// muestra el contenido del mapa
	private static void mostrarMap(Map<String, Integer> mapa) {
		Set<String> claves = mapa.keySet(); // obtiene las claves

		// ordena las claves
		TreeSet<String> clavesOrdenadas = new TreeSet<>(claves);

		System.out.printf("%nEl mapa contiene:%nClave\t\tValor%n");

		// genera la salida para cada clave en el mapa
		for (String clave : clavesOrdenadas)
			System.out.printf("%-10s%10s%n", clave, mapa.get(clave));

		System.out.printf("%nsize: %d%nisEmpty: %b%n", mapa.size(), mapa.isEmpty());
	}

}
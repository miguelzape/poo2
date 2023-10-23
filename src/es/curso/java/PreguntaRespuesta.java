package es.curso.java;
import java.util.Scanner;

public class PreguntaRespuesta {
	public static void main (String [] arg) {
		
		String entrada;
		String pregunta = "¿Cual es la capital de España?: ";
		String respuesta = "madrid"; // debe estar en minusculas
		Scanner scan = new Scanner (System.in);
		
		System.out.println(pregunta);
		entrada = scan.nextLine();
		
		System.out.println("Has tecleado: " + entrada);
		
		if (entrada.toLowerCase().equals(respuesta))
			System.out.println("Respuesta correcta");
		else
			System.out.println("Respuesta incorrecta");
		
		scan.close();
	}

}

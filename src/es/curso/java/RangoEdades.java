package es.curso.java;
import java.util.Scanner;

public class RangoEdades {
	public static void main(String[] arg) {

		int entrada;
		String pregunta = "¿Que edad tienes?: ";
		String respuesta;
		Scanner scan = new Scanner(System.in);

		System.out.println(pregunta);
		entrada = scan.nextInt();
	
		if (entrada <0)
			respuesta = "no se ha nacido";
		else if (entrada <= 5)
			respuesta = "se es un bebe";
		else if (entrada <= 11)
			respuesta = "se es un niño";
		else if (entrada <= 16)
			respuesta = "se es un adolescente";
		else if (entrada < 75)
			respuesta = "se es un adulto";
		else
			respuesta = "se es un anciano";
		
		System.out.println("Con " + entrada +" años de edad " + respuesta);
		scan.close();
	}
	
}

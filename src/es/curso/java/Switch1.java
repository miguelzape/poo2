package es.curso.java;

public class Switch1 {

	public static void main(String[] arg) {

		String mes = "aGosto";
		String mensaje;
		mes = mes.toLowerCase();

		switch (mes) {
		case "abril":
		case "mayo":
		case "junio":
			mensaje = "Es un mes de primavera";
			break;

		case "julio":
		case "agosto":
		case "septiembre":
			mensaje = "Es un mes de verano";
			if (mes.equals("agosto"))
				mensaje = mensaje.concat(" y ademas son vacaciones");
			break;

		case "octubre":
		case "noviembre":
		case "diciembre":
			mensaje = "Es un mes de otoño";
			if (mes.equals("diciembre"))
				mensaje = mensaje.concat(" y ademas es navidad");
			break;

		case "enero":
		case "febrero":
		case "marzo":
			mensaje = "Es un mes de invierno";
			break;

		default: 
			mensaje = "Eso no es un mes conocido";
		

		}
		System.out.println(mensaje);

	}
}

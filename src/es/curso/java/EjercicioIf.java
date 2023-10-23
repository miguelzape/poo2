package es.curso.java;

public class EjercicioIf {
	public static void main(String[] arg) {
		String mes = "aGosto";
		String mensaje;
		mes = mes.toLowerCase();

		if (mes.equals("abril") || mes.equals("mayo") || mes.equals("junio"))
			mensaje = "Es un mes de primavera";
		else if (mes.equals("julio") || mes.equals("agosto") || mes.equals("septiembre")) {
			mensaje = "Es un mes de verano";
			if (mes.equals("agosto"))
				mensaje = mensaje.concat(" y ademas son vacaciones");
		} else if (mes.equals("octubre") || mes.equals("noviembre") || mes.equals("diciembre")) {
			mensaje = "Es un mes de otoño";
			if (mes.equals("diciembre"))
				mensaje = mensaje.concat(" y ademas es navidad");
		} else if (mes.equals("enero") || mes.equals("febrero") || mes.equals("marzo"))
			mensaje = "Es un mes de invierno";
		else
			mensaje = "Eso no es un mes conocido";

		System.out.println(mensaje);

	}
}

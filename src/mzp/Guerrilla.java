package mzp;

import colecciones.guerra.Acorazado;
import colecciones.guerra.Batalla;
import colecciones.guerra.Guerrero;

public class Guerrilla {

	public static void main(String[] args) { 
		try {
			
			Acorazado otro = new Acorazado("Invitado", 10, 0,10);

			Batalla.nuevoVehiculo(otro);
		} catch (Exception e) {
			System.out.println("error al crear el acorazado invitado\n" + e.getMessage());
		}

	}

}

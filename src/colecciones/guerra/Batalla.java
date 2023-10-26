package colecciones.guerra;

import java.security.SecureRandom;

public class Batalla {
	
	
	private void comienzaBatalla(VehiculoGuerra local, VehiculoGuerra invitado) throws Exception{


			VehiculoGuerra[] combatientes = new VehiculoGuerra[2];
			
			if(local == null)
				combatientes[0] = new Acorazado("Ticonderoga", 3, 7,10);
			else 
				combatientes[0]=(VehiculoGuerra) local;
			
		
			if (invitado != null)
				combatientes[1] = (VehiculoGuerra) invitado;
			else {
				System.out.printf("\nNo se ha proporcionado ningun vehiculo de guerra");
				// crear acorazado y meter 10 guerreros
				combatientes[1] = new Fragata("Reagan", 4.0, 6.0);
				System.out.printf("\nSe genera uno aleatorio '%s'\n",combatientes[1].getNombre());
				SecureRandom r = new SecureRandom();
				for (int i = 0; i < 10; i++) {
					combatientes[1].embarcar(new Guerrero(r.nextDouble(3.0, 7.0)));
				}
			}

			System.out.printf("%60s\t[%s vs %s]\n","", combatientes[0].getNombre(), combatientes[1].getNombre());
			while (combatientes[0].getPuntosVida() > 0 && combatientes[0].getPuntosVida() > 0) {
				lucha(combatientes, 0, 1);

				if (combatientes[1].getPuntosVida() <= 0)
					break;

				lucha(combatientes, 1, 0);
			}
			
			int ganador =  (combatientes[0].getPuntosVida() > 0) ? 0 : 1;
			System.out.println("\nHa ganado " + combatientes[ganador].getNombre());


	}

	public void lucha(VehiculoGuerra[] combatientes, int a, int b) {
		double puntosAtaque;
		double puntosDanio;

		puntosAtaque = combatientes[a].atacar();
		puntosDanio = combatientes[b].defender(puntosAtaque);
		
		
	
		combatientes[b].recibirDanio(puntosDanio);
		System.out.printf("%s ataca con %.2f y %s recibe %.2f daños", combatientes[a].getNombre(), puntosAtaque,
				combatientes[b].getNombre(), puntosDanio);

		// aqui hago que el indice a siempre sea el menor de los dos
		// para que esta linea se imprima siempre en el mismo orden
		// independientemente de quien ataque o defienda
		if (b < a) {
			int aux = a;
			a = b;
			b = aux;
		}
		System.out.printf("\t[%.1f vs %.1f]\n", combatientes[a].getPuntosVida(), combatientes[b].getPuntosVida());
	}

	
	/**
	 * Crea una batalla a la que hay que facilitar un VehiculoGuerra que puede contener
	 * un maximo de CAPACIDAD_MAXIMA tripulantes
	 * @param invitado Es el VehiculoGuerra que participa en la batalla
	 */
	public static void nuevoVehiculo(VehiculoGuerra invitado) throws Exception{
		Batalla batalla = new Batalla();
		batalla.comienzaBatalla(null, invitado);
	}
	
	
	/**
	 * Crea una batalla a la que hay que facilitar dos VehiculoGuerra que puede contener
	 * un maximo de CAPACIDAD_MAXIMA tripulantes
	 * @param local Es el VehiculoGuerra que participa en la batalla
	 * @param invitado Es el VehiculoGuerra que participa en la batalla
	 */
	public static void nuevaBatalla(VehiculoGuerra local, VehiculoGuerra invitado) throws Exception{
		Batalla batalla = new Batalla();
		batalla.comienzaBatalla(local, invitado);
	}
	
	/**
	 * Crea una batalla a la que hay que facilitar dos VehiculoGuerra que puede contener
	 * un maximo de CAPACIDAD_MAXIMA tripulantes
	 * @param local Es el VehiculoGuerra que participa en la batalla
	 * @param invitado Es el VehiculoGuerra que participa en la batalla
	 */
	public static void nuevaBatalla(VehiculoGuerra... vehiculos) throws Exception{
		Batalla batalla = new Batalla();
		batalla.comienzaBatalla(vehiculos[0], vehiculos[1]);
	}

}

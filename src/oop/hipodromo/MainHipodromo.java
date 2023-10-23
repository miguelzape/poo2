package oop.hipodromo;

public class MainHipodromo {

	public static void main(String args[]) {

		// Caballo id,nombre,dorsal
		Caballo c1 = new Caballo(1, "Rapidin", 12);
		Caballo c2 = new Caballo(2, "Beodo", 77);
		Caballo c3 = new Caballo(3, "Tripode", 1);
		Caballo c4 = new Caballo(4, "Enano", 7);
		Caballo c5 = new Caballo(5, "Azulejo", 51);
		Caballo c6 = new Caballo(6, "Campeon", 33);
		Caballo c7 = new Caballo(7, "Aramis", 21);
		Caballo c8 = new Caballo(8, "Oso", 15);
		Caballo c9 = new Caballo(9, "Apple", 8);

		// Carrera id,nombre,metros,caballos
		Carrera r1 = new Carrera(1, "Malaga", 1500, c1, c2, c6, c7, c9, c4);
		Carrera r2 = new Carrera(2, "Madrid", 1100, c2, c7, c3, c9, c5, c8);
		Carrera r3 = new Carrera(3, "Oviedo", 2200, c6, c8, c9, c2, c3, c1);
		Carrera r4 = new Carrera(4, "Palma", 1000, c7, c2, c5, c4, c3, c6);
		Carrera r5 = new Carrera(5, "Zaragoza", 1800, c1, c9, c5, c8, c3, c7);

		// Gran premio id,nombre,carreras
		// GranPremio gp = new GranPremio(1,"España",r4,r2,r1,r5,r3);
		GranPremio gp = new GranPremio(1, "España", r4, r2);

		Apostante pepe = new Apostante("Pepe", 100);
		Apostante juan = new Apostante("Juan", 100);

		int idGanador;

		System.out.println(gp);

		System.out.println("Se inicia el Gran Premio " + gp.getNombre());

		for (Carrera carrera : gp.getCarreras()) {
			pepe.apostar(carrera.getNombre());
			juan.apostar(carrera.getNombre());
			idGanador = carrera.iniciarCarrera();
			pepe.comprobarApuesta(idGanador);
			juan.comprobarApuesta(idGanador);
		}
		System.out.println(juan.getNombre() + " ha terminado con " + juan.getSaldo() + " euros");
		System.out.println(pepe.getNombre() + " ha terminado con " + pepe.getSaldo() + " euros");

	}

}

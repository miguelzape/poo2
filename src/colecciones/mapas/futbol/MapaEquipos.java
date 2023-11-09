package colecciones.mapas.futbol;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapaEquipos {

	public static void main(String[] arg) {
		MapaEquipos me = new MapaEquipos();
		me.inicio();
	}

	private void inicio() {

		Map<Equipo, List<Jugador>> mapaEquipos = new HashMap<>();

		Jugador j1 = new Jugador("Pedro", 21, "delantero");
		Jugador j2 = new Jugador("Anton", 20, "portero");
		Jugador j3 = new Jugador("Toni", 23, "defensa");
		Jugador j4 = new Jugador("Chino", 21, "lateral");
		Jugador j5 = new Jugador("Catalan", 24, "delantero");
		Jugador j6 = new Jugador("Marco", 27, "defensa");

		Equipo e1 = new Equipo("Perdedores", 0, 0);
		Equipo e2 = new Equipo("Ganadores", 5, 6);

		/*
		 * List<Jugador> grupoJugadores = new ArrayList<>(); 
		 * grupoJugadores.add(j1);
		 * grupoJugadores.add(j5); 
		 * mapaEquipos.put(e1,grupoJugadores);
		 */

		mapaEquipos.put(e1, Arrays.asList(j1, j2, j3));
		mapaEquipos.put(e2, Arrays.asList(j4, j5, j6));

		// mostrar los nombres de los fugadores

		System.out.println("Lista de nombres de jugadores");
		for (Equipo e : mapaEquipos.keySet()) {
			for (Jugador j : mapaEquipos.get(e)) {
				System.out.println(j.getNombre());
			}
		}

		// Otra forma de hacer lo anterior sin usar las claves (key)
		System.out.println("\nOtra forma de hacer lo anterior");
		Collection<List<Jugador>> todosLosJugadores = mapaEquipos.values();
		for (List<Jugador> list : todosLosJugadores) {
			for (Jugador j : list) {
				System.out.println(j.getNombre());
			}
		}

		// Mostrar la información de un equipo y todos los datos de los jugadores del
		// equipo

		for (Equipo e : mapaEquipos.keySet()) {
			System.out.println("\n" + e);
			for (Jugador j : mapaEquipos.get(e)) {
				System.out.println("\t" + j);
			}
		}
		

		// Mostrar la información de un equipo y todos los datos de los jugadores del
		// equipo usando EntrySet

		System.out.println("\nSe repite usando EntrySet");
		Set<Entry<Equipo, List<Jugador>>> entrySet = mapaEquipos.entrySet();

		for (Entry<Equipo, List<Jugador>> entry : entrySet) {
			System.out.println("\n" + entry.getKey());

			for (Jugador j : entry.getValue()) {
				System.out.println("\t" + j);
			}
		}
	}

}

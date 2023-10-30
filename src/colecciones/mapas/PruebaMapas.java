package colecciones.mapas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PruebaMapas {

	public static void main(String[] args) {
		
		Map<Integer,String> mapa1 = new HashMap<>();
		
		//añadir informacion al mapa
		mapa1.put(1,"Amarillo");
		mapa1.put(2,"Azul");
		mapa1.put(3,"Verde");
		
		//ver si contiene cierta clave o cierto valor
		boolean b=mapa1.containsKey(1);
		boolean c=mapa1.containsValue("Verde");
		
		//obtener el conjunto de claves
		Set <Integer> claves = mapa1.keySet();
		
		//obtener el conjunto de claves
		Collection<String> valores = mapa1.values();
		
		//obtener un valor a partir de la clave
		String datos=mapa1.get(1);
		
		//obtener todo el contenido del mapa
		Set<Entry<Integer,String>> entries = mapa1.entrySet();
		
		//borrar entrada
		//esto borra la clave y valor asociada a clave 3
		mapa1.remove(3);
		
		// reeplaza el dato 4, solo si el viejo era "Naranja"
		mapa1.replace(4, "Naraja","Rosa");

	}

}
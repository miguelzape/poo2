package mzp;

import utils.Persona;
import utils.Utilidades;

public class pruebaRandom {
	public static void main(String args[]) {
		
		String[] cabecera= {"una","dos","tres","cuatro","cinco"};
		String[][] tabla = {{"a1345","b134","c1","d1","e13456789"},{"a2","b23456","c2","d2","e2"},
				           {"toro","vaca","mula","caballo","burro"},
					       {"malaga","toledo","cadiz","madrid","lugo"}};
		
		Utilidades.visualizaTabla(cabecera, tabla);
		
		Persona a1=new Persona();
		
		System.out.println(a1);
	
	}
			
	}


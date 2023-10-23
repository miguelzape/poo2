package colecciones;

import java.util.ArrayList;
import java.util.List;

import oop.Persona;

public class PruebaListas {

	public static void main(String[] args) {
		
	ArrayList lista1= new ArrayList();
	//List lista2 = new List();
	

	
	lista1.add("Rojo");
	lista1.add(5);
	lista1.add(new Persona());
	lista1.add("Mercedes");
	
	for (Object o:lista1) {
		System.out.println(o.toString());
		
	}
	
	lista1.stream().forEach(null);
	
	
	
		
		
	}

}

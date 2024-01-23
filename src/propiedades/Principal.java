package propiedades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Principal {

	public static void main(String[] args) {
		
		Principal p= new Principal();
		p.hacerCosas();	

	}
	
	private void hacerCosas() {
		Ferreteria ferreteria = new Ferreteria();
		InputStream archivo;
		
	
		try {
			archivo = new FileInputStream("./src/propiedades/config.properties");
			Properties p = new Properties(System.getProperties());
	        p.load(archivo);
	        //p.setProperty("mi.propiedad","Mi valor");
	        ferreteria.setId(Long.parseLong(p.getProperty("id")));
	        ferreteria.setNombre(p.getProperty("nombre"));
	        ferreteria.setDireccion(p.getProperty("direccion"));
	        ferreteria.setTornillos(EnumTornillo.values());
	        
	        System.out.println(ferreteria);
	        double suma = sumarTornillos(ferreteria.getTornillos());
	        System.out.println("el precio de todos los tornillos es: "+suma);
	        
	        
//	        List<EnumTornillo> prueba= new ArrayList<EnumTornillo>();
//	        prueba = Arrays.asList(EnumTornillo.values());
	        
//	        double total=0;
//	        prueba.forEach(t -> total += t.getPrecio());
        
	        
	        
	        
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private double sumarTornillos(EnumTornillo[] tornillos) {
		double total=0;
		for (EnumTornillo t : tornillos) {
			total += t.getPrecio();
		}
			
		return total;
		}
		
	}
	

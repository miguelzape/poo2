package es.curso.java.hibernate.biblio;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Principal {
	
	private static final Logger logger = LogManager.getLogger(Principal.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Principal p = new Principal();
		p.todo();
		logger.trace("Terminado");

	}
	
	
	public void todo() {
		
		
		UserDao udao = new UserDao("ejemploHibernateOracle");
		Direccion dir1=new Direccion("Mayor","28008");
		Direccion dir2=new Direccion("Prado","28010");
		Biblioteca b1=new Biblioteca("Nueva",dir1);
		Biblioteca b2=new Biblioteca("Otra",dir2);
		
		udao.insertarBiblios(Arrays.asList(b1,b2));
		
		List<Biblioteca> bibliotecas = udao.getbiblioteca();
		
		
		
		

	}
	
	

}

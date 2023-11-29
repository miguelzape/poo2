package es.curso.java.hibernate.segundo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class Principal {
	
	
	static EntityManager em;
	

	public static void main(String[] args) {
	
		Principal p = new Principal();
		p.inicio();
	

	}
	
	public void inicio() {
		
		em=JpaUtil.getEntityManager();
		//Insertar usuarios
		insertarUsuario(new Usuario("Pepe","Lopez","123A",new Date()));
		insertarUsuario(new Usuario("Juan","Botella","456B",new Date()));
		insertarUsuario(new Usuario("Ana","Pardo","789C",new Date()));
		
	
		List<Usuario> usuarios = em.createQuery("from Usuario", Usuario.class).getResultList();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		crearArchivo("auxiliar.txt",usuarios);
		
		
	}
	
	
	public void insertarUsuario (Usuario user) {
		 em.getTransaction().begin();
		 try {
			 em.persist(user);
			 
			 em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	     
	}
	
	public void crearArchivo(String nombre, List<Usuario> usuarios) {
		
		//ID;NOMBRE;APELLIDOS;
		File archivo = new File(nombre);
		
		try (PrintWriter buffer = new PrintWriter(archivo)) {
			// try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo))){

			buffer.println("ID;NOMBRE;APELLIDOS;DNI;FECHA_ALTA");
			for (Usuario u : usuarios) {
				
				Date fecha=u.getFechaAlta();
				
				String fechaConFormato = String.format("%04d%02d%02d"
						,(fecha.getYear() + 1900)  ,(fecha.getMonth()+1) ,fecha.getDate());
				
				buffer.println(u.getId()+";"+u.getNombre()+";"+u.getApellidos()
				+";"+u.getDni()+";"+fechaConFormato);
			}

			//buffer.close();
			System.out.println("El archivo se ha creado con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

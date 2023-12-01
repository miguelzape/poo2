package es.curso.java.hibernate.segundo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class Principal {

	private static final Logger logger = LogManager.getLogger(Principal.class);
	static EntityManager em;
	

	public static void main(String[] args) {
		Principal p = new Principal();
		p.inicio();
	}

	public void inicio() {

		em = JpaUtil.getEntityManager();
		UsuarioDAO udao = new UsuarioDAO(em);
		ProductosDAO pdao = new ProductosDAO(em);
		
		// Insertar usuarios
		udao.insertarUsuario(new Usuario("Pepe", "Lopez", "123A", new Date()));
		udao.insertarUsuario(new Usuario("Juan", "Botella", "456B", new Date()));
		udao.insertarUsuario(new Usuario("Ana", "Pardo", "789C", new Date()));
		
		logger.debug("3 usuarios creados en la tabla de oracle TB_Usuario");

		// visualizar los usuarios insertados en la base de datos
		List<Usuario> usuarios = udao.getAll();
		for (Usuario usuario : usuarios) {
			logger.debug(usuario);
		}

		// guardar la lista de usuarios anterior en un fichero 
		crearArchivo("auxiliar.txt", usuarios);
		logger.debug("datos");
		

		// leer datos de un fichero y guardarlos en la base de datos
		String ruta = "C:\\Users\\Tardes\\git\\cursogetafe\\enunciados\\hibernate\\fichero_carga_ejercicio2.txt";
		logger.debug("Lista de productos MIENTRAS son serializarlos");
		for (Productos p : cargarProductos(ruta)) {
			logger.debug(p);
			pdao.insertarProductos(p);
		}
		
	
		// mostrar los productos creados esta fecha
		Date fecha=crearDate(2023,10,14);
		logger.debug("productos con fecha de alta= " + fecha.toString());
		for (Productos p : pdao.getForDate(fecha)) {
			logger.debug(p);
		}
			
		//Mostrar para cada tipo de producto la media de precio y el total de productos
		for (AuxBusqueda ab : pdao.getEspecial()) {
			logger.debug(ab);
		}

		em.close();
	}

	
	
	public Date crearDate(int year,int month, int day) { 
	
		Calendar calendario = Calendar.getInstance();

        //calendario.set(2019, Calendar.SEPTEMBER, 25, 18, 20, 10);
        calendario.set(Calendar.YEAR, year - 1900);
        calendario.set(Calendar.MONTH, month -1 );  
        calendario.set(Calendar.DAY_OF_MONTH, day);
		return calendario.getTime();
	}
	

	// guarda en un archivo la lista de usuarios con un formato prefijado
	public void crearArchivo(String nombre, List<Usuario> usuarios) {

		// ID;NOMBRE;APELLIDOS;
		File archivo = new File(nombre);

		try (PrintWriter buffer = new PrintWriter(archivo)) {
			// try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo))){

			buffer.println("ID;NOMBRE;APELLIDOS;DNI;FECHA_ALTA");
			for (Usuario u : usuarios) {

				Date fecha = u.getFechaAlta();

				String fechaConFormato = String.format("%04d%02d%02d", (fecha.getYear() + 1900), (fecha.getMonth() + 1),
						fecha.getDate());

				buffer.println(u.getId() + ";" + u.getNombre() + ";" + u.getApellidos() + ";" + u.getDni() + ";"
						+ fechaConFormato);
			}

			// buffer.close();
			logger.debug("El archivo se ha creado con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// lee de un archivo una lista de datos con cabecera y los devuelve en una
	// lista de productos
	public List<Productos> cargarProductos(String ruta) {
		List<Productos> listaProductos = new ArrayList<>();
		File archivo = new File(ruta);
		try (Scanner s = new Scanner(archivo)) {

			s.useDelimiter("\n");
			int i = 0;
			while (s.hasNext()) {

				if (i == 0) {
					// se lee la cabecera del fichero y no se hace nada con ella
					s.next();
				} else {
					// PRODUCTO8;TIPO3;2023-10-17;15000;2
					String cadena = s.next();
					String[] datos = cadena.split(";");
					// formato fecha en fichero 2023-10-17
					String fecha = datos[2];
					int year = Integer.parseInt(fecha.substring(0, 4)) - 1900;
					int month = Integer.parseInt(fecha.substring(5, 7)) - 1;
					int day = Integer.parseInt(fecha.substring(8, 10));
					int posRC = datos[4].indexOf("\r");
					String canti = (posRC > 0) ? datos[4].substring(0, posRC) : datos[4];
					int cantidad = Integer.parseInt(canti);
					Date date = new Date(year, month, day);
					Productos p = new Productos(datos[0], datos[1], date, Integer.parseInt(datos[3]), cantidad);
					listaProductos.add(p);
				}

				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaProductos;
	}

}

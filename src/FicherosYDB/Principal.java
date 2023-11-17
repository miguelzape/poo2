package FicherosYDB;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.UtilsDB;


public class Principal {
	
	private static final Logger logger = LogManager.getLogger(Principal.class);

	public static void main(String[] args) {

		Principal base = new Principal();
		base.inicio();

	}
	
	public void inicio() {
		
		
		List<Personilla> lista = rellenaLista (leerArchivoAlumnos(".\\recursos\\alumnos.txt"));
		logger.trace("Se han creado " + lista.size() + " objetos"); 
		
		String[] bibliotecas = leeArchivoBibliotecas(".\\recursos\\bibliotecas.txt").split("\n");
		
		for (String b: bibliotecas) {
			logger.trace("insertar una biblioteca nueva");
			InsertarDatosBD(b);
		}
		
		
	}
	
	public List<Personilla> rellenaLista (List<String> lineas){
		String[] datos;
		List<Personilla> personillas=new ArrayList<Personilla>();
		
		for (String cadena : lineas) 
		{
			datos=cadena.split("\\|");
			int extra1= Integer.parseInt(datos[3]);
			int extra2= Integer.parseInt(datos[4].substring(0, 1));
			Personilla aux=new Personilla(datos[0],datos[1],datos[2],extra1,extra2);
			personillas.add(aux);
		}
		return personillas;
	}
	
	
	public List<String> leerArchivoAlumnos(String nombreFichero) {
		File archivo = new File(nombreFichero);
		List<String> lista = new ArrayList<String>();
		
		try (Scanner s = new Scanner(archivo)) {

			s.useDelimiter("\n");
			while (s.hasNext()) {
				lista.add(s.next());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public String leeArchivoBibliotecas(String nombreFichero) {
		File archivo = new File(nombreFichero);
		StringBuilder cadena = new StringBuilder();
		
		try (Scanner s = new Scanner(archivo)) {

			s.useDelimiter("\n");
			while (s.hasNext()) {
				cadena.append(s.next());
				cadena.append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena.toString();
	}
	
	private void InsertarDatosBD(String cadena) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs=null;
		
		String[] datos = cadena.split("\\|");

		String consulta1 = "INSERT INTO tb_direcciones (calle, numero) VALUES (?, ?);";
		String consulta2 = "SELECT numero FROM tb_direcciones WHERE calle = ? AND numero = ?;";
		String consulta3 = "INSERT INTO tb_bibliotecas (nombre, fk_dir_id) VALUES (?, ?);";
		

		try {
			connection = UtilsDB.getInstance();
			
			//insertar datos en la tabla direcciones
			prepareStament = connection.prepareStatement(consulta1);
			prepareStament.setString(1, datos[1]);
			prepareStament.setInt(2, Integer.parseInt(datos[4]));
		
			
			if (prepareStament.executeUpdate() == 0) {
				logger.trace("direccion no insertada");
			}
			
			prepareStament.close();
			
			// consultar el numero de id que se ha dado a la nueva direccion
			prepareStament = connection.prepareStatement(consulta2);
			prepareStament.setString(1, datos[1]);
			prepareStament.setInt(2, Integer.parseInt(datos[4]));
			
			rs=prepareStament.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			prepareStament.close();
			
			//insertar datos en la tabla biblioteca
			
			prepareStament = connection.prepareStatement(consulta3);
			prepareStament.setString(1, datos[5]);
			prepareStament.setInt(2, id);
			
			if (prepareStament.executeUpdate() == 0) {
				logger.trace("biblioteca no insertado");
			}
			
			
			
			

		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();

		} finally {

			try {
				// UtilsDB.cerrarConexion();
				prepareStament.close();
			} catch (Exception e) {
				System.out.println("Error SQL al cerrar");
			}
		}
	}
	
	

}

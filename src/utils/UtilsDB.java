package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UtilsDB {
	
private static Connection connection;
	
	/**
	 * Conexion por defecto a la base de datos curso de la maquina local
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getInstance () throws SQLException {
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
		String userName = "root";
		String password = "password";
		
		
		connection = getInstance(url, userName, password);
		
		return connection;
	}
	
	public static Connection getInstance (String url, String userName, String password) throws SQLException{

		if (connection==null) {
			connection = DriverManager.getConnection(url, userName, password);
		}
		return connection;
	}
	
	public static void cerrarConexion() throws SQLException {
		if (connection!=null) {
			connection.close();
			connection=null;
		}
	}
	
	

	public static void visualizaDBTabla(ResultSet rs) {

		ResultSetMetaData rsmd = null;
		String[] nombresColumnas;
		String campos="";
		String campo="";
		int nCol=0;
		int nFil=0;
		int anchoColumnas[];
		
		try {
			rsmd = rs.getMetaData();
			nCol = rsmd.getColumnCount();
			
			anchoColumnas = new int[nCol];
			
			// guardar numero de columnas y el nombre de cada una de ellas
			nombresColumnas = new String[nCol];
			for (int iter = 0; iter < nCol; iter++) {
				nombresColumnas[iter] = rsmd.getColumnName(iter+1);
			}
			
			// este bucle crea una cadena 'campos' con todo el contenido de la base
			// de datos con cada campo separado por ':' y cada linea separaad por '\n'
			int i=0;
			while (rs.next()){
			   for (int j=0;j<nCol;j++) {
				   campo=rs.getString(j+1);
				   if (campo==null) campo=" ";

				   if (j>0)
					   campos = campos + ":" +campo;
				   else
					   campos = campos +campo;
				   
				   if (i == 0) {
						anchoColumnas[j] = nombresColumnas[j].length();
					}

					if (campo.length() > anchoColumnas[j]) {
						anchoColumnas[j] = campo.length();
					}   
			   }
			   campos = campos + "\n";
			   nFil++;
			   i++;
			}
					
			
			Utilidades.visualizaTabla(nombresColumnas, campos , anchoColumnas);
			
		} catch (Exception e) {
			System.out.println("error en visualizaTabla " + e.getMessage());
		}
		
	}

}

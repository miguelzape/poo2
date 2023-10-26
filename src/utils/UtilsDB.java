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
		
		try {
			rsmd = rs.getMetaData();
			nCol=rsmd.getColumnCount();
			
			while (rs.next()){
			   for (int i=0;i<nCol;i++) {
				   campo=rs.getString(i+1);
				   if (campo==null) campo=" ";

				   if (i>0)
					   campos = campos + ":" +campo;
				   else
					   campos = campos +campo;
			   }
			   campos = campos + "\n";
			   nFil++;
			}
			
			//System.out.println("La tabla tiene " + nFil +" filas y " + nCol + " columnas");
			//System.out.println(campos);
			
			nombresColumnas = new String[nCol];

			for (int iter = 0; iter < nCol; iter++) {
				nombresColumnas[iter] = rsmd.getColumnName(iter+1);
			}
			
			Utilidades.visualizaTabla(nombresColumnas, campos ,nFil,nCol);
			
		} catch (Exception e) {
			System.out.println("error en visualizaTabla " + e.getMessage());
		}
		
	}

}

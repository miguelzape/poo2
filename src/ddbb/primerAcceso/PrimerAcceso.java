package ddbb.primerAcceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import utils.UtilsDB;

public class PrimerAcceso {
	
	
	public static void main(String[] args) {
		PrimerAcceso conexion = new PrimerAcceso();
		conexion.conecta();
		
	}
	
	private void conecta() {
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
	    String username = "root";
	    String password = "password";
	    
	    Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    ResultSetMetaData rsmd=null;
	    
	    Set<Facilities> lista = new LinkedHashSet<Facilities>();
	    Facilities f;
	    
		try {
			System.out.println("Estableciendo conexión");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexión establecida");
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM TB_FACILITIES ORDER BY guid DESC");
			rsmd = rs.getMetaData();
			
			UtilsDB.visualizaDBTabla(rs);
			
			rs = stmt.executeQuery("SELECT * FROM TB_FACILITIES ORDER BY guid DESC");
			rsmd = rs.getMetaData();
			System.out.println();
			
			while (rs.next()) {
				long i=rs.getLong("id");
				long g=rs.getLong("guid");
				String n=rs.getString("name");
				String a=rs.getString("address");
				String d=rs.getString("description");
				String c=rs.getString("category");
				double h=rs.getDouble("heigth");
				f=new Facilities(h,a,c,d,n,g,i);
				lista.add(f);
				System.out.println(f);
				
            }		
			
			System.out.println("Se han creado " + lista.size() + " objetos");
			
			for (Facilities facilities : lista) {
				 //Facilities.getName());
			}
			
			
			System.out.println("\nNombres de las columnas");
			for (int iter = 1; iter <= rsmd.getColumnCount(); iter++) { 
				System.out.printf("%s, ",rsmd.getColumnName(iter));
			}
					
			
		} catch (SQLException e) {
			System.err.println("Ha habido un error "+e.getMessage());
//			e.printStackTrace();
		}finally {
			try {
				if (connection != null) connection.close();
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

package ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBaseDeDatos {
	
	
	public static void main(String[] args) {
		ConexionBaseDeDatos conexion = new ConexionBaseDeDatos();
		conexion.conecta();
		
	}
	
	private void conecta() {
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
	    String username = "root";
	    String password = "password";
	    
	    Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
		try {
			System.out.println("Estableciendo conexión");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexión establecida");
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM TB_FACILITIES");
			while (rs.next()) {
				System.out.println(rs.getLong("id"));
				System.out.println(rs.getInt("guid"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("description"));
				System.out.println(rs.getString("category"));
				System.out.println("===============================");
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

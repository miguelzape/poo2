package ddbb.oracle;

import java.sql.Connection;
import java.sql.SQLException;

import utils.UtilsDBOracle;

public class UsarOracle {

	public static void main(String[] arg) {
		Connection connection;
		
		try {
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = UtilsDBOracle.getInstanceOracle();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al conectar a base de datos de oracle");

		} finally {
			try {
			//connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

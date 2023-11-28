package utils;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class UtilsDBOracle {

	static Connection connection;

	/**
	 * Conexion por defecto a la base de datos curso de la maquina local
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getInstanceOracle() throws SQLException {

		if (connection == null) {
			OracleDataSource ods = new OracleDataSource();
			//ods.setURL("jdbc:oracle:thin:curso/password@localHost:1521:XE");
			ods.setURL("jdbc:oracle:thin:@localHost:1521:XE");
			ods.setUser("curso");
			ods.setPassword("password");
			connection = ods.getConnection();
		}

		return connection;
	}

	public static void closeInstanceOracle() throws SQLException {

		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}

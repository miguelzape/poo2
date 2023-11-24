package ddbb.ejerciciosDelProfesor.biblioteca.dao;

import java.sql.Connection;
import java.sql.SQLException;

import utils.UtilsDB;

public abstract class ConexionDAO {
	private Connection conexion;

	public ConexionDAO() throws SQLException {
		super();
		this.conexion = UtilsDB.getInstance();
	}

	/**
	 * @return the conexion
	 */
	public Connection getConexion() {
		return conexion;
	}
	
	
	
}

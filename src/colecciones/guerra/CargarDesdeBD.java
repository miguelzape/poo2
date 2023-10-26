package colecciones.guerra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CargarDesdeBD {

	public static void main(String[] args) {
		CargarDesdeBD conexion = new CargarDesdeBD();
		conexion.conectaTryWithResources();

	}

	private void conectaTryWithResources() {
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
		String username = "root";
		String password = "password";

		List<VehiculoGuerra> combatientes = null;
		Acorazado ticonderoga = null;
		Fragata egpaniola = null;
		Guerrero guerrero = null;
		int indiceAcorazado = 0;
		int indiceFragata = 0;

		// Connection connection = null;//Conexion con la base de datos
		// Statement stmt = null;//Lanzar consulta
		// ResultSet rs = null;//Recoger datos de la consulta

		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM tb_vehiculos_guerra");) {

			combatientes = new ArrayList<VehiculoGuerra>();
			while (rs.next()) {
				String dbNombre = rs.getString("nombre");
				String dbTipo = rs.getString("tipo");
				int dbAtaque = rs.getInt("ataque");
				int dbDefensa = rs.getInt("defensa");
				int dbId = rs.getInt("id");

				if (dbTipo.equals("acorazado")) {
					ticonderoga = new Acorazado(dbNombre, dbAtaque, dbDefensa);
					combatientes.add(ticonderoga);
					indiceAcorazado = dbId;
				} else if (dbTipo.equals("fragata")) {
					egpaniola = new Fragata(dbNombre, dbAtaque, dbDefensa);
					combatientes.add(egpaniola);
					indiceFragata = dbId;
				}

			}

		} catch (SQLException e) {
			System.err.println("Ha habido un error en SQL" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha habido un error en VehiculoGuerra" + e.getMessage());
			e.printStackTrace();

		}

		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM tb_guerreros");) {

			while (rs.next()) {
				String dbNombre = rs.getString("nombre");
				String dbTipo = rs.getString("tipo");
				int dbFuerza = rs.getInt("fuerza");
				int dbResistencia = rs.getInt("resistencia");
				int dbVehiculo_id = rs.getInt("fk_vehiculo_id");

				guerrero = new Guerrero(dbNombre, dbTipo, dbFuerza, dbResistencia);

				if (dbVehiculo_id == indiceAcorazado) {
					ticonderoga.embarcar(guerrero);
				} else if (dbVehiculo_id == indiceFragata) {
					egpaniola.embarcar(guerrero);
				}

			}

		} catch (SQLException e) {
			System.err.println("Ha habido un error en SQL" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha habido un error en Guerro" + e.getMessage());
			e.printStackTrace();

		}

		System.out.println("Se han creado " + combatientes.size() + " combatientes\n");
		for (VehiculoGuerra v : combatientes) {
			System.out.println(v);
		}

		
		try {
			Batalla.nuevaBatalla(combatientes.get(0),combatientes.get(1));
			//Batalla.nuevaBatalla((VehiculoGuerra[]) combatientes.toArray());
		} catch (Exception e) {
			System.out.println("error al hacer batalla " + e.getMessage());
		}

	}

//	private void conecta() {
//		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
//		String username = "root";
//		String password = "password";
//
//		Connection connection = null;// Conexion con la base de datos
//		Statement stmt = null;// Lanzar consulta
//		ResultSet rs = null;// Recoger datos de la consulta
//		try {
//
//			System.out.println("Estableciendo conexión");
//			connection = DriverManager.getConnection(url, username, password);
//			System.out.println("Conexión establecida");
//			stmt = connection.createStatement();
//
//			rs = stmt.executeQuery("SELECT * FROM TB_FACILITIES");
//			while (rs.next()) {
//				System.out.println(rs.getLong("id"));
//				System.out.println(rs.getInt("guid"));
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getString("description"));
//				System.out.println(rs.getString("category"));
//				System.out.println("===============================");
//			}
//
//		} catch (SQLException e) {
//			System.err.println("Ha habido un error " + e.getMessage());
////			e.printStackTrace();
//		} finally {
//
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (stmt != null)
//					stmt.close();
//				if (rs != null)
//					rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
}

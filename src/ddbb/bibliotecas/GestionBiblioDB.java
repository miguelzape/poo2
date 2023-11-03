package ddbb.bibliotecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.Utilidades;
import utils.UtilsDB;

public class GestionBiblioDB {

	public static void main(String[] args) {

		GestionBiblioDB grupoBiblio = new GestionBiblioDB();
		grupoBiblio.todo();

	}

	private void todo() {

		String[] menu2 = { "Mostrar Info biblioteca", "Mostrar Libros de la biblioteca", "Buscar Libro",
				"Insertar Libro", "Modificar", "Borrar", "Volver" };

		String[] menu1;
		int opcionMenu1 = 9999;
		int opcionMenu2 = 9999;
		List<idMasNombre> lista= this.nombresBibliotecas();
		
		menu1= new String[lista.size() + 1];
		for (int i=0;i < lista.size();i++) {
			menu1[i]=lista.get(i).getNombre();
		}
		menu1[lista.size()]="Salir";
	

		while (opcionMenu1 != lista.size()) {
			opcionMenu1 = Utilidades.generaMenu("Seleccione una biblioteca", menu1);

			while (opcionMenu2 != 7 && opcionMenu1 != menu1.length) {
				opcionMenu2 = Utilidades.generaMenu(menu2);
				switch (opcionMenu2) {
				// mostrar info biblioteca
				case 1:
					this.mostrarInfoBiblioteca(menu1[opcionMenu1 - 1]);
					break;
				// Mostrar libros de la biblioteca
				case 2:
					break;
				// Buscar libro
				case 3:
					break;
				// Insertar libro
				case 4:
					break;
				// Modificar
				case 5:
					break;
				// Borrar
				case 6:
					break;
				}
			}

		}

		try {
			UtilsDB.cerrarConexion();
		} catch (Exception e) {
			System.out.println("Error al cerrar conexion");
		}

	}

	//private String[] nombresBibliotecas(String agregarAlFinal) {
	 private List<idMasNombre> nombresBibliotecas() {

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<idMasNombre> lista= new ArrayList<>();

		try {

			connection = UtilsDB.getInstance();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT nombre FROM tb_bibliotecas ORDER BY nombre ASC");

			while (rs.next()) {
				String n=rs.getString("nombre");
				int i=rs.getInt("id");
				lista.add(new idMasNombre(i,n));
			}


		} catch (Exception e) {
			System.out.println("Error SQL al abrir o leer en tb_bibliotecas");
			e.printStackTrace();

		} finally {

			try {
				// UtilsDB.cerrarConexion();
				stmt.close();
				rs.close();
			} catch (Exception e) {
				System.out.println("Error SQL al cerrar tb_bibliotecas");
			}
		}
		return lista;
	}

	private void mostrarInfoBiblioteca(String nombreBiblio) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		String consulta = "SELECT tb_bibliotecas.id, tb_bibliotecas.nombre, tb_direcciones.calle, tb_direcciones.numero"
				+ " FROM tb_bibliotecas" + " INNER JOIN tb_direcciones ON tb_bibliotecas.id=tb_direcciones.id"
				+ " WHERE tb_bibliotecas.nombre = ?";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setString(1, nombreBiblio);

			rs = prepareStament.executeQuery();
			// UtilsDB.visualizaDBTabla(rs);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String calle = rs.getString("calle");
				int numero = rs.getInt("numero");
				System.out.printf("id=%d nombre=%s calle=%s numero=%d\n", id, nombre, calle, numero);
			}

		} catch (Exception e) {
			System.out.println("Error SQL al abrir o leer en tb_bibliotecas");
			e.printStackTrace();

		} finally {

			try {
				// UtilsDB.cerrarConexion();
				prepareStament.close();
				rs.close();
			} catch (Exception e) {
				System.out.println("Error SQL al cerrar tb_bibliotecas");
			}
		}
	}

}

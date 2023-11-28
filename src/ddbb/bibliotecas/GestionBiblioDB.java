package ddbb.bibliotecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.Utilidades;
import utils.UtilsDB;

public class GestionBiblioDB {
	
private static final Logger logger = LogManager.getLogger(GestionBiblioDB.class);
	

	public static void main(String[] args) {

		GestionBiblioDB grupoBiblio = new GestionBiblioDB();
		logger.error("inicio");
		logger.info("inicio");
		logger.debug("inicio");
		grupoBiblio.todo();
		logger.error("fin");
	}

	private void todo() {

		String[] menu2 = { "Mostrar Info biblioteca", "Mostrar Libros de la biblioteca", "Buscar Libro",
				"Insertar Libro", "Modificar", "Borrar", "Precio Medio", "Volver" };

		String[] menu1;
		int[] idS = null;
		int opcionMenu1 = 9999;
		int opcionMenu2;
		List<idMasNombre> lista = this.nombresBibliotecas();

		menu1 = new String[lista.size() + 1];
		idS = new int[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			menu1[i] = lista.get(i).getNombre();
			idS[i] = lista.get(i).getId();
		}
		menu1[lista.size()] = "Salir";

		while (opcionMenu1 != menu1.length) {
			opcionMenu1 = Utilidades.generaMenu("Seleccione una biblioteca", menu1);
			opcionMenu2 = 9999;

			while (opcionMenu2 != 8 && opcionMenu1 != menu1.length) {
				System.out.println();
				opcionMenu2 = Utilidades.generaMenu(menu2);
				switch (opcionMenu2) {
				// mostrar info biblioteca
				case 1:
					this.mostrarInfoBiblioteca(idS[opcionMenu1 - 1]);
					break;
				// Mostrar libros de la biblioteca
				case 2:
					this.mostrarLibros(idS[opcionMenu1 - 1], 1);
					break;
				// Buscar libro
				case 3:
					this.buscarLibrosFiltrado(idS[opcionMenu1 - 1]);
					break;
				// Insertar libro
				case 4:
					this.InsertarLibro(idS[opcionMenu1 - 1]);
					break;
				// Modificar
				case 5:
					this.modificarLibro(idS[opcionMenu1 - 1]);
					break;
				// Borrar
				case 6:
					this.borrarLibro(idS[opcionMenu1 - 1]);
					break;
				// Calcular precio medio
				case 7:
					this.precioMedio();
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

	// private String[] nombresBibliotecas(String agregarAlFinal) {
	private List<idMasNombre> nombresBibliotecas() {

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<idMasNombre> lista = new ArrayList<>();

		try {

			connection = UtilsDB.getInstance();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT nombre, id FROM tb_bibliotecas ORDER BY nombre ASC");

			while (rs.next()) {
				String n = rs.getString("nombre");
				int i = rs.getInt("id");
				lista.add(new idMasNombre(i, n));
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

	private void mostrarInfoBiblioteca(int idBiblio) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		String consulta = "SELECT tb_bibliotecas.id, tb_bibliotecas.nombre, tb_direcciones.calle, tb_direcciones.numero"
				+ " FROM tb_bibliotecas" + " INNER JOIN tb_direcciones ON tb_bibliotecas.id=tb_direcciones.id"
				+ " WHERE tb_bibliotecas.id = ?";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setInt(1, idBiblio);

			rs = prepareStament.executeQuery();
			Utilidades.visualizaDBTabla(rs);

			/*
			 * while (rs.next()) { 
			 * int id = rs.getInt("id"); 
			 * String nombre =rs.getString("nombre"); 
			 * String calle = rs.getString("calle"); 
			 * int numero = rs.getInt("numero");
			 * System.out.printf("id=%d nombre=%s calle=%s numero=%d\n", id, nombre, calle, numero); }
			 */

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

	private void mostrarLibros(int biblioId, int numeroCadena) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		String consulta = "SELECT id, titulo, autor, precio FROM tb_libros WHERE fk_biblio_id = ?";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setInt(1, biblioId);

			rs = prepareStament.executeQuery();
			Utilidades.visualizaDBTabla(rs);

			/*
			 * while (rs.next()) { 
			 * int id = rs.getInt("id"); 
			 * String titulo = rs.getString("titulo");
			 * String autor = rs.getString("autor");
			 * 
			 * System.out.printf("id=%d titulo=%s autor=%s\n", id, titulo, autor); }
			 */

		} catch (SQLException e) {
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

	private void InsertarLibro(int idBiblioteca) {

		Connection connection = null;
		PreparedStatement prepareStament = null;

		String titulo = Utilidades.pideCadena("Titulo: ");
		String Autor = Utilidades.pideCadena("Autor: ");

		String consulta = "INSERT INTO tb_libros (titulo, autor, fk_biblio_id) VALUES (?, ?, ?);";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setString(1, titulo);
			prepareStament.setString(2, Autor);
			prepareStament.setInt(3, idBiblioteca);

			if (prepareStament.executeUpdate() > 0) {
				System.out.println("Libro insertado");
			} else {
				System.out.println("Libro no insertado");
			}

		} catch (SQLException e) {
			System.out.println("Error SQL al abrir o leer en tb_bibliotecas");
			e.printStackTrace();

		} finally {

			try {
				// UtilsDB.cerrarConexion();
				prepareStament.close();
			} catch (Exception e) {
				System.out.println("Error SQL al cerrar tb_bibliotecas");
			}
		}
	}

	private void borrarLibro(int idBiblioteca) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		int elementos;

		String titulo = Utilidades.pideCadena("Titulo del libro a borrar: ");

		String consulta = "DELETE FROM tb_libros WHERE titulo = ? ;";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setString(1, titulo);

			elementos = prepareStament.executeUpdate();
			if (elementos > 0) {
				System.out.println("Libro borrado. Habia " + elementos + " instancias");
			} else {
				System.out.println("No se puede borrar lo que no existe");
			}

		} catch (SQLException e) {
			System.out.println("Error SQL al abrir o leer en tb_bibliotecas");
			e.printStackTrace();

		} finally {

			try {
				// UtilsDB.cerrarConexion();
				prepareStament.close();
			} catch (Exception e) {
				System.out.println("Error SQL al cerrar tb_bibliotecas");
			}
		}
	}

	private void modificarLibro(int idBiblioteca) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		String tituloV = Utilidades.pideCadena("Titulo del libro que busca: ");

		String consulta1 = "SELECT id, autor FROM tb_libros WHERE titulo = ? AND fk_biblio_id = ?;";
		String consulta2 = "UPDATE tb_libros SET titulo = ?, autor = ? WHERE id = ?;";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta1);
			prepareStament.setString(1, tituloV);
			prepareStament.setInt(2, idBiblioteca);

			rs = prepareStament.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String autorV = rs.getString("autor");
				String tituloN = Utilidades.pideCadena("Nuevo Titulo: ");
				if (tituloN.length() == 0) {
					System.out.printf("Se usará el anterior titulo: %s\n", tituloV);
					tituloN = tituloV;
				}
				String autorN = Utilidades.pideCadena("Nuevo Autor: ");
				if (autorN.length() == 0) {
					System.out.printf("Se usará el anterior autor: %s\n", autorV);
					autorN = autorV;
				}

				prepareStament.close();

				prepareStament = connection.prepareStatement(consulta2);
				prepareStament.setString(1, tituloN);
				prepareStament.setString(2, autorN);
				prepareStament.setInt(3, id);

				if (prepareStament.executeUpdate() > 0) {
					System.out.println("Actualizado correctamente");
				}

			} else {
				System.out.printf("El libro %s NO está en esta biblioteca\n", tituloV);
			}

		} catch (Exception e) {
			System.out.println("Error SQL al abrir o leer en tb_bibliotecas");
			e.printStackTrace();

		} finally {

			try {
				// UtilsDB.cerrarConexion();
				prepareStament.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error SQL al cerrar tb_bibliotecas");
			}
		}
	}

	private void buscarLibrosFiltrado(int biblioId) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		String consulta = "SELECT id, titulo, autor, precio autor FROM tb_libros WHERE fk_biblio_id = ?";
		String titulo = Utilidades.pideCadena("Filtro por Titulo: ");
		// filtrar por titulo
		if (titulo.length() > 0) {
			consulta = consulta + " AND titulo = ?";
		}

		String autor = Utilidades.pideCadena("Filtro por Autor: ");
		// filtrar por autor
		if (autor.length() > 0) {
			consulta = consulta + " AND autor = ?";
		}

		System.out.printf("\nLa consulta es:\n%s", consulta);

		int contadorParametros = 1;
		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setInt(contadorParametros++, biblioId);
			if (titulo.length() > 0) {
				prepareStament.setString(contadorParametros++, titulo);
			}

			if (autor.length() > 0) {
				prepareStament.setString(contadorParametros++, autor);
			}

			rs = prepareStament.executeQuery();
			Utilidades.visualizaDBTabla(rs);

		} catch (SQLException e) {
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

	private void precioMedio() {

		Connection connection = null;
		Statement stnt = null;
		ResultSet rs = null;

		String consulta = "SELECT tb_bibliotecas.nombre AS 'Biblioteca', COUNT(precio) AS 'cantidad', FORMAT(AVG(precio),2) AS 'precio_medio' \r\n"
				+ "FROM tb_libros INNER JOIN tb_bibliotecas ON tb_libros.fk_biblio_id=tb_bibliotecas.id GROUP BY tb_libros.fk_biblio_id\r\n"
				+ "ORDER BY AVG(precio) ASC";

		try {
			connection = UtilsDB.getInstance();
			stnt = connection.createStatement();

			rs = stnt.executeQuery(consulta);
			Utilidades.visualizaDBTabla(rs);

		} catch (Exception e) {
			System.out.println("Error SQL al abrir o leer en tb_bibliotecas");
			e.printStackTrace();

		} finally {

			try {
				// UtilsDB.cerrarConexion();
				stnt.close();
				rs.close();
			} catch (Exception e) {
				System.out.println("Error SQL al cerrar tb_bibliotecas");
			}
		}
	}

}

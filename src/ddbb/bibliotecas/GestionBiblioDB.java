package ddbb.bibliotecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		int[] idS=null;
		int opcionMenu1 = 9999;
		int opcionMenu2;
		List<idMasNombre> lista= this.nombresBibliotecas();
		
		menu1= new String[lista.size()+1];
		idS= new int[lista.size()];
		for (int i=0;i < lista.size();i++) {
			menu1[i]=lista.get(i).getNombre();
			idS[i]=lista.get(i).getId();
		}
		menu1[lista.size()]="Salir";
		

		while (opcionMenu1 != menu1.length) {
			opcionMenu1 = Utilidades.generaMenu("Seleccione una biblioteca", menu1);
			opcionMenu2 = 9999;

			while (opcionMenu2 != 7 && opcionMenu1 != menu1.length) {
				System.out.println();
				opcionMenu2 = Utilidades.generaMenu(menu2);
				switch (opcionMenu2) {
				// mostrar info biblioteca
				case 1:
					this.mostrarInfoBiblioteca(idS[opcionMenu1 - 1]);
					break;
				// Mostrar libros de la biblioteca
				case 2:
					this.todosLibrosBiblioteca(idS[opcionMenu1 - 1]);
					break;
				// Buscar libro
				case 3:
					this.buscarLibro(idS[opcionMenu1 - 1]);
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
			rs = stmt.executeQuery("SELECT nombre, id FROM tb_bibliotecas ORDER BY nombre ASC");

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
			UtilsDB.visualizaDBTabla(rs);

	/*		while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String calle = rs.getString("calle");
				int numero = rs.getInt("numero");
				System.out.printf("id=%d nombre=%s calle=%s numero=%d\n", id, nombre, calle, numero);
			}   */

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
	
	
	private void todosLibrosBiblioteca(int biblioId) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		String consulta = "SELECT id, titulo, autor FROM tb_libros WHERE fk_biblio_id = ?";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setInt(1, biblioId);

			rs = prepareStament.executeQuery();
			UtilsDB.visualizaDBTabla(rs);

	/*		while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");

				System.out.printf("id=%d titulo=%s autor=%s\n", id, titulo, autor);
			}   */

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
	
	private void buscarLibro(int  idBiblioteca) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;
		
		String titulo=Utilidades.pideCadena("Titulo del libro que busca: ");

		String consulta = "SELECT * FROM tb_libros WHERE titulo = ? AND fk_biblio_id = ?;";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setString(1, titulo);
			prepareStament.setInt(2, idBiblioteca);

			rs = prepareStament.executeQuery();
			// UtilsDB.visualizaDBTabla(rs);

			//falta mostrar algo cuando no se encuetra el titulo
			
			if (rs.next()) {
				System.out.printf("El libro %s está en esta biblioteca\n",titulo);
			}
			else {
				System.out.printf("El libro %s NO está en esta biblioteca\n",titulo);
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
	
	
	
	private void InsertarLibro(int  idBiblioteca) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		
		String titulo=Utilidades.pideCadena("Titulo: ");
		String Autor=Utilidades.pideCadena("Autor: ");

		String consulta = "INSERT INTO tb_libros (titulo, autor, fk_biblio_id) VALUES (?, ?, ?);";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setString(1, titulo);
			prepareStament.setString(2, Autor);
			prepareStament.setInt(3, idBiblioteca);

			if (prepareStament.executeUpdate() > 0) {
				System.out.println("Libro insertado");
			}
			else
			{
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
	
	
	private void borrarLibro(int  idBiblioteca) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		int elementos;
		
		String titulo=Utilidades.pideCadena("Titulo del libro a borrar: ");

		String consulta = "DELETE FROM tb_libros WHERE titulo = ? ;";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setString(1, titulo);

			elementos=prepareStament.executeUpdate();
			if ( elementos > 0) {
				System.out.println("Libro borrado. Habia " + elementos + " instancias");
			}
			else
			{
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
	
	
	
	private void modificarLibro(int  idBiblioteca) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;
		
		String tituloV=Utilidades.pideCadena("Titulo del libro que busca: ");

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
				String autorV= rs.getString("autor");
				String tituloN=Utilidades.pideCadena("Nuevo Titulo: ");
				if (tituloN.length() == 0) {
					System.out.printf("Se usará el anterior titulo: %s\n",tituloV);
					tituloN=tituloV;
				}
				String autorN=Utilidades.pideCadena("Nuevo Autor: ");
				if (autorN.length() == 0) {
					System.out.printf("Se usará el anterior autor: %s\n",autorV);
					autorN=autorV;
				}
				
				prepareStament.close();
				
				prepareStament = connection.prepareStatement(consulta2);
				prepareStament.setString(1, tituloN);
				prepareStament.setString(2, autorN);
				prepareStament.setInt(3, id);
				
				if (prepareStament.executeUpdate() > 0) {
					System.out.println("Actualizado correctamente");
				}
				
			}
			else {
				System.out.printf("El libro %s NO está en esta biblioteca\n",tituloV);
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
	
	private void busarLibrosFiltrado(int biblioId) {

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		String consulta = "SELECT id, titulo, autor FROM tb_libros WHERE fk_biblio_id = ?";

		try {
			connection = UtilsDB.getInstance();
			prepareStament = connection.prepareStatement(consulta);
			prepareStament.setInt(1, biblioId);

			rs = prepareStament.executeQuery();
			UtilsDB.visualizaDBTabla(rs);

	/*		while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");

				System.out.printf("id=%d titulo=%s autor=%s\n", id, titulo, autor);
			}   */

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

}

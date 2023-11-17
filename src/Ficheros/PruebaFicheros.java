package Ficheros;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaFicheros {

	private static final Logger logger = LogManager.getLogger(PruebaFicheros.class);

	public static void main(String[] args) {

		PruebaFicheros prueba = new PruebaFicheros();
		prueba.inicio();

	}

	public void inicio() {
		
		File dirInicial = new File(".\\recursos\\directorios2");
		File nuevoDirectorio = new File(".\\recursos\\nuevoDeMiguel");
		cuantosJpg(dirInicial);
		ficherosEsteAnio(dirInicial);
		File renombrado = renombrarCiertoFichero(dirInicial);
		moverFichero(renombrado, nuevoDirectorio);
	}
	
	private void moverFichero(File f, File nuevoDirectorio) {
		if (!nuevoDirectorio.mkdir()) {
			logger.warn("No se ha creado el directorio " + nuevoDirectorio.getAbsolutePath());
		}

		if (f != null && f.exists()) {
			if (f.renameTo(new File(nuevoDirectorio, f.getName()))) {
				logger.debug("Movido fichero " + f.getName() + " a " + nuevoDirectorio.getAbsolutePath());
			}
		}
	}

	private void cuantosJpg(File rutaDirectorio) {

		int contador = 0;
		for (File f : dirAll(rutaDirectorio)) {
			if (f.getName().endsWith("jpg")) {
				contador++;
			}
		}
		logger.debug("Hay " + contador + " archivos jpg");
	}

	private void ficherosEsteAnio(File rutaDirectorio) {
		int year = LocalDate.now().getYear();
		logger.debug("Lista de ficheros que tienen este año en su nombre: ");
		for (File f : dirAll(rutaDirectorio)) {
			if (f.getName().contains(String.valueOf(year))) {
				logger.debug(f);
			}
		}
	}

	private File renombrarCiertoFichero(File rutaDirectorio) {

		// Vais a renombrar (asdasd.txt.done) el fichero que tenga en el
		// nombre el año siguiente pero en el mes actual en el que estamos

		int year = LocalDate.now().getYear();
		int mes = LocalDate.now().getMonthValue();
		++year;
		File nuevoFichero = null;
		

		for (File f : dirAll(rutaDirectorio)) {
			if (f.getName().contains(String.valueOf(year))) {
				if (f.getName().contains(String.valueOf(mes))) {
					logger.debug("Encontrado y renombrado " + f.getName());
					File newFile = new File(f.getParent(), "asdasd.txt.done");
					logger.debug("Nuevo nombre " + newFile);
					f.renameTo(newFile);
					nuevoFichero = newFile;
				}
			}
		}

		return nuevoFichero;
	}

	/**
	 * Devuelva la lista de files con todos los ficheros que contiene el 'dir' y sus
	 * subcartetas.
	 * 
	 * @param dir
	 * @param inicio
	 */
	private static void dirAllaux(File dir, List<File> inicio) {

		if (dir.isDirectory()) {

			File[] arrayFicheros = dir.listFiles();
			for (File fichero : arrayFicheros) {
				if (fichero.isDirectory()) {
					dirAllaux(fichero, inicio);
				} // cierra if
				else {
					inicio.add(fichero.getAbsoluteFile());
				} // cierra else
			} // cierra for
		} // cierra if

	}

	public List<File> dirAll(File dir) {
		List<File> lista = new ArrayList<File>();
		dirAllaux(dir, lista);
		return lista;
	}

}

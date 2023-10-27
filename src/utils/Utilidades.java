package utils;

/*   https://github.com/joselllorente/cursogetafe.git

	 https://github.com/miguelzape/examen1.git

	 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   */

import java.util.Random;
import java.util.Scanner;

public class Utilidades {
	
	// anchura maxima para imprimir en pantalla tablas de datos
	static final int ANCHURA_MAXIMA = 120;

	/**
	 * muestra en pantalla la cadena de entrada y pide por teclado una cadena de
	 * texto que devuelve la funcion no se hace ninguna comprobacion
	 * 
	 * @param pregunta String con el mensaje que se muestra antes leer la cadena
	 * @return cadena de texto recogida desde el teclado
	 */
	static public String pideCadena(String pregunta) {
		Scanner scan = new Scanner(System.in);
		System.out.println(pregunta);
		String cadena = scan.nextLine();
		/*
		 * System.in.close(); scan.close(); scan=null;
		 */
		return (cadena);
	}

	/**
	 * Muestra en pantalla la cadena de entrada y pide por teclado una cadena de
	 * texto que devuelve la funcion
	 *
	 * Se comprueba que el numero de caracteres introducidos este en el rango
	 * indicado por min y max. Si no lo esta se muestra un aviso y se solicita de
	 * nuevo.
	 * 
	 * @param pregunta String con el mensaje que se muestra antes leer la cadena
	 * @param min      numero minimo de caracteres
	 * @param max      numero maximo de caracteres
	 * @return cadena de texto recogida desde el teclado
	 */
	static public String pideCadena(String pregunta, int min, int max) {

		String respuesta;
		int nCaracteres;
		compruebaErrorMinMax(min, max);

		while (true) {
			respuesta = pideCadena(pregunta);
			nCaracteres = respuesta.length();
			if (nCaracteres < min || nCaracteres > max) {
				System.out
						.println("Longitud incorrecta\n" + "Debe escribir entre " + min + " y " + max + " caracteres");
			} else
				return (respuesta);
		}
	}

	/**
	 * Muestra en pantalla la cadena de entrada y pide por teclado un numero que
	 * devuelve la funcion. Devuelve un long.
	 *
	 * Se comprueba que lo escrito sea un numero entero En caso contrario se da un
	 * aviso y solicita de nuevo
	 * 
	 * @param pregunta String con el mensaje que se muestra antes leer el numero.
	 * @return long numero entero largo con el valor introducido por el usuario
	 */
	static public long pideNumeroL(String pregunta) {
		String respuesta;
		while (true) {
			respuesta = pideCadena(pregunta);
			if (respuesta.matches("[0-9]++"))
				return (Long.parseLong(respuesta));
			else
				System.out.println("No ha introducido un número");
		}
	}

	/**
	 * Muestra en pantalla la cadena de entrada y pide por teclado un numero que
	 * devuelve la funcion. Devuelve un int.
	 *
	 * Se comprueba que lo escrito sea un numero entero En caso contrario se da un
	 * aviso y solicita de nuevo
	 * 
	 * @param pregunta String con el mensaje que se muestra antes leer el numero.
	 * @return int numero entero con el valor introducido por el usuario
	 */
	static public int pideNumero(String pregunta) {
		return ((int) pideNumeroL(pregunta));
	}

	/**
	 * Muestra en pantalla la cadena de entrada y pide por teclado un numero que
	 * devuelve la funcion. Devuelve un int.
	 *
	 * Se comprueba que lo escrito sea un numero entero, en caso contrario se da un
	 * aviso y solicita de nuevo Se comprueba que el valor introducido este en el
	 * rango indicado por min y max. Si no lo esta se muestra un aviso y se solicita
	 * de nuevo.
	 * 
	 * @param pregunta String con el mensaje que se muestra antes leer el numero.
	 * @param min      valor minimo aceptado
	 * @param max      valor maximo aceptado
	 * @return int numero entero con el valor introducido por el usuario
	 */
	static public int pideNumero(String pregunta, int min, int max) {
		int numero;
		String preguntaCompuesta;
		compruebaErrorMinMax(min, max);
		preguntaCompuesta = pregunta + " [" + min + " a " + max + "]: ";
		numero = (int) pideNumeroL(preguntaCompuesta);

		while (numero < min || numero > max) {
			System.out.println("Ese número esta fuera de rango");
			numero = (int) pideNumeroL(preguntaCompuesta);
		}
		return (numero);
	}

	/**
	 * Muestra en pantalla la cadena de entrada y pide por teclado un numero que
	 * devuelve la funcion. Devuelve un double.
	 *
	 * Se comprueba que lo escrito sea un numero decimal En caso contrario se da un
	 * aviso y solicita de nuevo
	 * 
	 * @param pregunta String con el mensaje que se muestra antes leer el numero.
	 * @return double con el valor introducido por el usuario
	 */
	static public double pideNumeroD(String pregunta) {
		String respuesta;
		while (true) {
			respuesta = pideCadena(pregunta).trim().replace(',', '.');
			if (respuesta.matches("[0-9]++.?[0-9]*"))
				return (Double.parseDouble(respuesta));
			else
				System.out.println("No ha introducido un número");
		}
	}

	/**
	 * Muestra en pantalla la cadena de entrada y pide por teclado un numero que
	 * devuelve la funcion. Devuelve un double.
	 *
	 * Se comprueba que lo escrito sea un numero decimal En caso contrario se da un
	 * aviso y solicita de nuevo
	 * 
	 * @param pregunta String con el mensaje que se muestra antes leer el numero.
	 * @return double con el valor introducido por el usuario
	 */
	static public double pideDecimal(String pregunta) {
		return pideNumeroD(pregunta);
	}

	/**
	 * Si min >= max, se muestra en pantalla un mensaje de error y se detiene la
	 * ejecucion del programa. No devuelve nada
	 * 
	 * @param min. Valor minimo
	 * @param max. valor maximo
	 */
	static void compruebaErrorMinMax(int min, int max) {
		if (min >= max) {
			// int error;
			String origen = new String(Thread.currentThread().getStackTrace()[2].getMethodName());
			System.out.println("Error al usar " + origen + ". El valor MIN debe ser menor que MAX");
			/*
			 * se hace una division entre cero para generar un error y que se detenga el
			 * programa. Lo hago porque hay un fallo en la programacion
			 */
			// error=1/0;
			throw new ArithmeticException("Maximo debe ser mayor que minimo.");

		}
	}

	/**
	 * Escribe en pantalla los arrays del string en forma de menu (uno en cada linea
	 * con el numero de opcion delante) y espera a que el usuario elija una opcion.
	 * Si la opcion elejida no esta dentro de rango valido se da un aviso y se
	 * vuelve a solicitar
	 * 
	 * @param opciones Array de String con las opciones del menu.(SIN NUMEROS DE
	 *                 OPCION)
	 * @return Int con la opcion del menu seleccionada .
	 */
	static public int generaMenu(String opciones[]) {
		int longitud = opciones.length;

		System.out.println("Menu de opciones");
		for (int i = 0; i < longitud; i++) {
			System.out.println((i + 1) + ". " + opciones[i]);
		}
		return (pideNumero("\nElija una opción", 1, longitud));
	}

	/**
	 * Escribe en pantalla el String en forma de menu (cada opcion en una linea con
	 * el numero de opcion delante) y espera a que el usuario elija una opcion. Si
	 * la opcion elejida no esta dentro de rango valido se da un aviso y se vuelve a
	 * solicitar
	 * 
	 * @param opciones String con las opciones del menu separadas por '\n'. (SIN
	 *                 NUMEROS DE OPCION)
	 * @return Int con la opcion del menu seleccionada.
	 */
	static public int generaMenu(String opciones) {
		return (generaMenu(opciones.split("\n")));
	}

	/**
	 * Escribe en pantalla los arrays del string en forma de menu (uno en cada linea
	 * con el numero de opcion delante) y espera a que el usuario elija una opcion.
	 * Si la opcion elejida no esta dentro de rango valido se da un aviso y se
	 * vuelve a solicitar
	 * 
	 * @param cabecera texto que encabeza el menu
	 * @param opciones Array de String con las opciones del menu.(SIN NUMEROS DE
	 *                 OPCION)
	 * @return Int con la opcion del menu seleccionada .
	 */
	static public int generaMenu(String cabecera, String opciones[]) {
		int longitud = opciones.length;

		System.out.println(cabecera);
		for (int i = 0; i < longitud; i++) {
			System.out.println((i + 1) + ". " + opciones[i]);
		}
		return (pideNumero("\nElija una opción", 1, longitud));
	}

	/**
	 * Escribe en pantalla los arrays del string en forma de menu (uno en cada linea
	 * con el numero de opcion delante) y espera a que el usuario elija una opcion.
	 * Si la opcion elejida no esta dentro de rango valido se da un aviso y se
	 * vuelve a solicitar
	 * 
	 * @param cabecera texto que encabeza el menu
	 * @param opciones Array de String con las opciones del menu.(SIN NUMEROS DE
	 *                 OPCION)
	 * @param salida   texto para la opcion que cierra el menu
	 * @return Int con la opcion del menu seleccionada .
	 */
	static public int generaMenu(String cabecera, String opciones[], String salida) {
		int longitud = opciones.length;

		System.out.println(cabecera);
		for (int i = 0; i < longitud; i++) {
			System.out.println((i + 1) + ". " + opciones[i]);
		}
		System.out.println((longitud + 1) + ". " + salida);
		return (pideNumero("\nElija una opción", 1, longitud + 1));
	}

	static public double aleatorio(int min, int max) {
		Random r = new Random();

		// compruebaErrorMinMax(min,max);
		// double n=Math.random();
		double n = r.nextDouble(min, max);

		// n=(n*(max-min))+min;
		return n;
	}
	
	
	// Modificar esta funcion para que trabaje con los arrays de String segun
	// se van haciendo los Split, y no como ahora que se guarda en un array de 
	// 2 dimensiones de String y luego se recoge desde alli
	static int visualizaTabla(String[] cabecera, String campos,int[] anchoColumnas,int nFilas) {
		
		int nColumnas = anchoColumnas.length;
		String[][] tabla = new String[nFilas][nColumnas];
		String[] filas;
		
		filas =campos.split("\n");
		
		for (int i=0;i < nFilas;i ++) {
			tabla[i] = filas[i].split(":");
		}
	
		// si la anchura total a imprimir supera el MAXIMO es un error y se acaba el
		// proceso
		int anchura = nColumnas + 1;
		for (int i : anchoColumnas) anchura += i;
		if (anchura > ANCHURA_MAXIMA) {
			System.out.println("La anchura de la tabla es " + anchura + ", superando el limite de " + ANCHURA_MAXIMA);
			return anchura;
		}
			

		imprimirLineaSinDatos(anchoColumnas,1);
		
		// si es true. Imprime cabecera ancha
		// si es false. Imprime cabecera estrecha
		if (true) {
			imprimirLineaDatos(anchoColumnas, cabecera, Color.WHITE_BOLD);
			imprimirLineaSinDatos(anchoColumnas,3);
		}
		else imprimirLineaDatos(anchoColumnas, cabecera, Color.WHITE_UNDERLINED);
		

		int h = 0;
		Color color;
		for (String[] fila : tabla) {
			color= (h % 2)==0 ? Color.YELLOW : Color.WHITE;
			imprimirLineaDatos(anchoColumnas, fila, color);
			h++;
		}

		imprimirLineaSinDatos(anchoColumnas,100);
		return 0;
	}
	
	
	

	public static int visualizaTabla(String[] cabecera, String[][] tabla) {
		
		int nColCabecera = cabecera.length;
		int nFilTabla = tabla.length;
		int nColTabla = tabla[0].length;
		// si el numero de columnas de tabla y cabecera no coincide es un error y se
		// acaba el proceso
		
		
		if (nColCabecera != nColTabla) {
			System.out.printf("\nnColCabera %d\nnFilTabla %d\nnColTabla %d\n", nColCabecera, nFilTabla, nColTabla);
			return 1;
		}
		
		// anchoColumnas guardara la anchura maxima de cada columna.
		int anchoColumnas[] = new int[nColCabecera];
		for (int i = 0; i < nFilTabla; i++) {
			for (int j = 0; j < nColTabla; j++) {
				if (i == 0) {
					anchoColumnas[j] = cabecera[j].length();
				}

				if (tabla[i][j].length() > anchoColumnas[j]) {
					anchoColumnas[j] = tabla[i][j].length();
				}
			}
		}

		int anchura = 0;
		for (int i : anchoColumnas) {
			// System.out.println(i);
			anchura += i;
		}
		anchura = anchura + nColTabla + 1;

		// si la anchura total a imprimir supera el MAXIMO es un error y se acaba el
		// proceso
		if (anchura > ANCHURA_MAXIMA) {
			System.out.println("La anchura de la tabla es " + anchura + ", superando el limite de " + ANCHURA_MAXIMA);
			return anchura;
		}
			

		imprimirLineaSinDatos(anchoColumnas,1);
		
		// si es true. Imprime cabecera ancha
		// si es false. Imprime cabecera estrecha
		if (true) {
			imprimirLineaDatos(anchoColumnas, cabecera, Color.WHITE_BOLD);
			imprimirLineaSinDatos(anchoColumnas,3);
		}
		else imprimirLineaDatos(anchoColumnas, cabecera, Color.WHITE_UNDERLINED);
		

		int h = 0;
		Color color;
		for (String[] fila : tabla) {
			color= (h % 2)==0 ? Color.YELLOW : Color.WHITE;
			imprimirLineaDatos(anchoColumnas, fila, color);
			h++;
		}

		imprimirLineaSinDatos(anchoColumnas,100);

		// si ha funcionado correctamente se devuelve el codigo 0. Sin error.
		return 0;
	}

	
	private static void imprimirLineaSinDatos(int[] anchoColumnas, int linea) {

		char inicio;
		char medio;
		char fin;

		if (linea == 1) {
			inicio = '╔';
			medio = '╦';
			fin = '╗';
		} else if (linea == 3 || linea == 2) {
			inicio = '╠';
			medio = '╬';
			fin = '╣';
		} else {
			inicio = '╚';
			medio = '╩';
			fin = '╝';

		}

		String str = "═";
		System.out.print("\n" + inicio);

		for (int i = 0; i < anchoColumnas.length; i++) {
			System.out.print(str.repeat(anchoColumnas[i]));
			if (i < (anchoColumnas.length - 1)) {
				System.out.print(medio);
			}
		}
		System.out.print(fin);

	}

	private static void imprimirLineaDatos(int[] anchoColumnas, String[] contenido, Color color) {

		String formato;
		System.out.print("\n║");

		for (int i = 0; i < anchoColumnas.length; i++) {

			// estos simbolos raros determinan el color y tipo de letra
			// aqui se alterna entre lineas blancas y amarillas
			formato = String.format(color.toString()+"%%-%ds", anchoColumnas[i]);
			System.out.printf(formato, contenido[i]);
			// aqui se reestablece el tipo estandar. letra blancas
			System.out.print(Color.WHITE.toString() + '║');
		}
	}

}

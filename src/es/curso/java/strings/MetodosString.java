package es.curso.java.strings;

public class MetodosString {

	public static void main(String[] args) {

		String nombre1 = "Jose Luis";
		String nombre2 = nombre1;

		nombre1 = nombre1.toUpperCase();

		System.out.println(nombre1 + " ");
		System.out.println(nombre2);

		System.out.println (nombre1.charAt(0));

		System.out.println(nombre1.concat(nombre2));

		String result = nombre1 + "|" + nombre2 + "|" + "Eva";
		System.out.println(result);

		System.out.println(nombre1.toLowerCase().contains("se"));

		System.out.println(nombre1.endsWith(".txt"));
		System.out.println(nombre1.startsWith("JO"));

		// "JOSE LUIS werwr"
		System.out.println(nombre1.indexOf("S"));
		System.out.println(nombre1.lastIndexOf("S"));

		String var3 = "      ";
		System.out.println(var3.isBlank());
		System.out.println(var3.isEmpty());

		System.out.println(nombre1.length());

		System.out.println(nombre1.replace("E", "I"));
		System.out.println(nombre1);

		String var4 = "EEEEE";
		System.out.println(var4.replace("E", "I"));

		String var5 = "    Esto es una prueba      ";
		String var6 = var5.substring(8);
		System.out.println(var6);
		String var7 = var5.substring(8, 11);
		System.out.println(var7);

		System.out.println(var5.trim());

	}
}
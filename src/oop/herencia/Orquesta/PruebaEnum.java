package oop.herencia.Orquesta;

public enum PruebaEnum {
	UNO (1,"uno"),
	DOS (2,"dos"),
	TRES (3,"tres");

	
	private int numero;
	private String cadena;
	
	private PruebaEnum(int numero, String cadena) {
		this.numero = numero;
		this.cadena = cadena;
	}

	public int getNumero() {
		return numero;
	}

	public String getCadena() {
		return cadena;
	}
}

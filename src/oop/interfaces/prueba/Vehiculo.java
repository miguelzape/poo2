package oop.interfaces.prueba;

public abstract class Vehiculo extends SistemaEncendidoC{
	
	private int id; 
	private String matricula;
	private String marca;
	private static int elementos=0;
	
	public Vehiculo(String matricula, String marca) {
		super(false);
		this.id = ++elementos;
		this.matricula = matricula;
		this.marca = marca;
	}

	
	public int getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public static int getElementos() {
		return elementos;
	}

	public static void setElementos(int elementos) {
		Vehiculo.elementos = elementos;
	}
	
	
	
	

}

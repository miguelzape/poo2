package oop.herencia.Orquesta;

public abstract class Instrumento {
	private String nombre;
	private String tipo;
	
	
	public Instrumento(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public void afinar()
	{
		System.out.println("afinando instrumento "+ this.nombre);
	}
	
	public void tocar()
	{
		System.out.println("tocando instrumento "+ this.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}
	
	
	
	

//	afinar() --> Afinando instrumento nombre
//	tocar() --> Tocando instrumento nombre

}

package oop.herencia.Orquesta;

public class Guitarra extends Instrumento {
	
private int numCuerdas;
	
    @Override
	public void afinar()
	{
		System.out.println("afinando guitarra");
	}

	public Guitarra(String nombre, String tipo, int numCuerdas) {
		super(nombre, tipo);
		this.numCuerdas = numCuerdas;
	}

	public int getNumCuerdas() {
		return numCuerdas;
	}

}

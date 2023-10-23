package oop.interfaces.prueba;

public final class Coche extends Vehiculo {
	
	private int numPuertas;

	public Coche(String matricula, String marca, int numPuertas) {
		super(matricula, marca);
		this.numPuertas = (numPuertas >= 1 && numPuertas <= 7)? numPuertas:5;
	}
	
	@Override
	public void encender() {
		this.setEstado(true);
		System.out.println("Coche encendido");
	}

	@Override
	public void apagar() {
		this.setEstado(false);
		System.out.println("Coche apagado");
	}
	
	
	public int getNumPuertas() {
		return numPuertas;
	}



}

package oop.interfaces.prueba;

public class Moto extends Vehiculo {
	
	private int numRuedas;

	public Moto(String matricula, String marca, int numRuedas) {
		super(matricula, marca);
		this.numRuedas = (numRuedas >= 1 && numRuedas <= 3)? numRuedas:2;
	}
	
	@Override
	public void encender() {
		this.setEstado(true);
		System.out.println("Motocicleta encendida");
	}

	@Override
	public void apagar() {
		this.setEstado(false);
		System.out.println("Motocicleta apagada");
	}


	public int getNumRuedas() {
		return numRuedas;
	}
	
	
	
	

}

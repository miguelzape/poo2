package oop.herencia.Orquesta;

public class Piano extends Instrumento {

	private int numeroOctavas;
	private String tipoPiano;
	
	
	public Piano(String lNombre, String lTipo, int lNumeroOctavas, String lTipoPiano) {
		super(lNombre, lTipo);
		this.numeroOctavas = lNumeroOctavas;
		this.tipoPiano = lTipoPiano;
	}
	

	@Override
	public void afinar() {
		System.out.println("afinando piano");
	}


	public int getNumeroOctavas() {
		return numeroOctavas;
	}


	public String getTipoPiano() {
		return tipoPiano;
	}
	
	
	

}

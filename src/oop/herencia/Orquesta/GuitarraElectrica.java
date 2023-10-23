package oop.herencia.Orquesta;

public class GuitarraElectrica extends Guitarra {
	
	private float potencia;

	public GuitarraElectrica(String lNombre, String lTipo, int lNumCuerdas, float lPotencia) {
		super(lNombre, lTipo, lNumCuerdas);
		this.potencia=lPotencia;
	}

	public void tocar()
	{
		super.tocar();
		System.out.println("tocando muy alto");
	}
	
	public float getPotencia() {
		return potencia;
	}
	
	

}

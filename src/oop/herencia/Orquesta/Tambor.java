package oop.herencia.Orquesta;

public class Tambor extends Instrumento {
	
	private String material;

	public Tambor(String nombre, String tipo) {
		super(nombre, tipo);
	}

	public Tambor(String lNombre, String lTipo, String lMaterial) {
		super(lNombre, lTipo);
		this.material = lMaterial;
	}

	@Override
	public void afinar() {
		System.out.println("afinanco tambor");
	}

	public void aporrear() {
		super.tocar();
		System.out.println("aporreando tambor");
	}

	public String getMaterial() {
		return material;
	}

	
	
	
}

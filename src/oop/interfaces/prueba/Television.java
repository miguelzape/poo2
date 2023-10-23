package oop.interfaces.prueba;

public class Television extends SistemaElectronico {
	
	private int hdmi;
	
	

	public Television(float precio, String fabricante, int hdmi) {
		super(precio, fabricante);
		this.hdmi = hdmi;
	}
	
	public int getHdmi() {
		return hdmi;
	}

}

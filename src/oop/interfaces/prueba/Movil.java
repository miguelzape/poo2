package oop.interfaces.prueba;

public class Movil extends SistemaElectronico {
	private String sistemaOperativo;

	public Movil(float precio, String fabricante, String sistemaOperativo) {
		super(precio, fabricante);
		this.sistemaOperativo = sistemaOperativo;
	}


	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	

}

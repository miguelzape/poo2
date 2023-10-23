package oop.interfaces.prueba;

public class SistemaElectronico extends SistemaEncendidoC {
	
	private int id;
	private float precio;
	private String fabricante;
	private static int elementos=0;
	
	

	public SistemaElectronico(float precio, String fabricante) {
		super(false);
		this.id = ++elementos;
		this.precio = precio>0?precio:0;
		this.fabricante = fabricante;
	}

	@Override
	public void encender() {
		this.setEstado(true);
		System.out.println("Sistema electronico encendido");
	}

	@Override
	public void apagar() {
		this.setEstado(false);
		System.out.println("Sistema electronico apagado");
	}

	public int getId() {
		return id;
	}

	public float getPrecio() {
		return precio;
	}

	public String getFabricante() {
		return fabricante;
	}
	
	

}

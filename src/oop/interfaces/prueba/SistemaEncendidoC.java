package oop.interfaces.prueba;

public abstract class SistemaEncendidoC implements SistemaEncendido {
	
	private boolean estado;
	
	public SistemaEncendidoC(boolean estado) {
		super();
		this.estado = estado;
	}

	protected boolean isEstado() {
		return estado;
	}
	
	
	protected void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public abstract void encender();

	@Override
	public abstract void apagar();

}

package oop.herencia.Hospital;

public enum Turno {
	MANANA (7,15,"Mañana"),
	TARDE (15,23,"Tarde"),
	NOCHE (23,7,"Noche");
	
	int horaEntrada;
	int horaSalida;
    String texto;
    
	private Turno(int horaEntrada, int horaSalida, String texto) {
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.texto = texto;
	}

	public int getHoraEntrada() {
		return horaEntrada;
	}
	
	public int getHoraSalida() {
		return horaSalida;
	}

	public String getTexto() {
		return texto;
	}
       
}

package oop.excepciones;

public class ClienteCafeteria {
	private String nombre;

	public ClienteCafeteria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean tomarTazaCafe (TazaCafe taza) throws TooColdTemperatureException,TooHotTemperatureExpection{
		float temp = taza.getTemperatura();
		boolean clienteSatisfecho=false;
		if (temp < 20) {
			throw new TooColdTemperatureException();
		} else if (temp > 80) {
			throw new TooHotTemperatureExpection();
		}
		System.out.printf("%s está tomando felizmente su café a %.2f grados", this.nombre, taza.getTemperatura());
		clienteSatisfecho=true;
		return clienteSatisfecho;
	}

	

}

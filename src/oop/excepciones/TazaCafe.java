package oop.excepciones;

import java.util.Random;

public class TazaCafe {
	
	private float temperatura;

	public TazaCafe() {
		super();
		Random r = new Random();
		this.temperatura = r.nextFloat(0,100);
	}

	public float getTemperatura() {
		return temperatura;
	}
	
	
	

}

package colecciones.guerra;

import java.security.SecureRandom;

public class Acorazado extends VehiculoGuerra {
	

	public Acorazado(String nombre, double ataque, double defensa, int numeroPasajeros) throws Exception {
		super(nombre, ataque, defensa, numeroPasajeros);
	}
	
	public Acorazado(String nombre, double ataque, double defensa) throws Exception {
		super(nombre, ataque, defensa);
	}

	@Override
	public double atacar() {
		SecureRandom r=new SecureRandom();	
		double sumaFuerzas=0.0;
		double danio;
		
		for (Guerrero g : this.getPasaje()) {
			sumaFuerzas += g.getFuerza();
		}
		
		danio = (this.getAtaque()*r.nextDouble(0,1) + sumaFuerzas*r.nextDouble(0,0.5));
		//System.out.println(this.getNombre() + " ataca con " + danio);
		
		return danio;
		
	}

	@Override
	public double defender(double ataque) {
		SecureRandom r=new SecureRandom();	
		double sumaResistencias=0.0;
		double defensa;
		double danio;
		
		for (Guerrero g : this.getPasaje()) {
			sumaResistencias += g.getResistencia();
		}
		defensa = (this.getDefensa()*r.nextDouble(0,1) + sumaResistencias*r.nextDouble(0,0.5));
		danio = (ataque > defensa) ? ataque-defensa : 0;
		//this.recibirDanio(danio); 
		
		//System.out.println(this.getNombre() + " se defiende con " + danio);
		return danio;
	}
	
	@Override
	public int numeroPasajeros() {
		return (this.getPasaje().size());
	}

	@Override
	public String toString() {
		return "Nombre=" + getNombre() + ", numero Pasajeros=" + numeroPasajeros() +  ", Ataque="
				+ getAtaque() + ", Defensa=" + getDefensa();
	}

	
	
	
	

}

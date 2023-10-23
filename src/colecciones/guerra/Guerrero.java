package colecciones.guerra;

public class Guerrero {
	
private double fuerza;
private double resistencia;
private String nombre;
private String tipo;


Guerrero(double fuerza, double resistencia) throws DesajusteFuerzasException {
	super();
	this.nombre="generico";
	this.tipo="humano";
	
	if (fuerza+resistencia > 10)
		throw new DesajusteFuerzasException("Desajuste fuerzas al crear guerrero");
	
	this.fuerza = fuerza;
	this.resistencia = resistencia;
}

public Guerrero(double fuerza) {
	super();
	if (fuerza > 10) fuerza=5;
	this.nombre="generico";
	this.tipo="humano";
	this.fuerza = fuerza;
	this.resistencia = 10 - fuerza;
}

public Guerrero(String nombre, String tipo, double fuerza, double resistencia) throws DesajusteFuerzasException{
	this(fuerza,resistencia);
	
	this.nombre = nombre;
	this.tipo = tipo; 
}

public double getFuerza() {
	return fuerza;
}

public double getResistencia() {
	return resistencia;
}

public String getNombre() {
	return nombre;
}

public String getTipo() {
	return tipo;
}







}

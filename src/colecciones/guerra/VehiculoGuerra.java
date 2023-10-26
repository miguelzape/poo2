package colecciones.guerra;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public abstract class VehiculoGuerra implements Tripulable {
//public abstract class VehiculoGuerra {
	
	private double puntosVida;
	private double ataque;
	private double defensa;
	private String nombre;
	private List<Guerrero> pasaje;
	final int CAPACIDAD_MAXIMA=10;
	
	
	/**
	 * Crea un vehiculo de guerra que incluye tripulantes (pasajeros)
	 * @param nombre del vehiculo
	 * @param ataque puntos de ataque
	 * @param defensa puntos de defensa
	 * @param numeroPasajeros pasajeros que se incluyen dentro del vehiculo de forma aleatoria
	 * @throws Exception
	 */
	public VehiculoGuerra( String nombre,double ataque, double defensa, int numeroPasajeros) throws Exception{
		this(nombre,ataque,defensa);
		
		if (numeroPasajeros > CAPACIDAD_MAXIMA) 
			throw new ExcesoCapacidadVehiculoException("Excedido el limite de pasajeros");
		
		SecureRandom r=new SecureRandom();
		
		for (int i=0;i<numeroPasajeros;i++)
		{
			this.embarcar(new Guerrero(r.nextDouble(3.0,7.0)));
		}
	
	}
	
	/**
	 * Crea un vehiculo de guerra vacio
	 * @param nombre del vehiculo
	 * @param ataque puntos de ataque
	 * @param defensa puntos de defensa
	 * @throws Exception
	 */
	public VehiculoGuerra( String nombre,double ataque, double defensa) throws Exception{
		super();
		this.puntosVida = PUNTOS_VIDA;
		this.ataque = ataque;
		this.defensa = defensa;
		this.nombre = nombre;
		this.pasaje = new ArrayList<Guerrero>();
		
		if (ataque+defensa > 10 ) throw new DesajusteFuerzasException("Fuerzas descompensadas al crear vehiculo");
	}
	
	
	
	
	
	/**
	 * Crea un vehiculo de guerra con ataque=5 y defensa=5
	 * y se llena automaticamente con pasajeros (guerreros) aleatorios
	 * @param nombre del vehiculo
	 * @param ataque puntos de ataque
	 * @param defensa puntos de defensa
	 * @throws Exception
	 */
	public VehiculoGuerra( String nombre, int numeroPasajeros) throws Exception{
		    this(nombre, 5.0, 5.0, numeroPasajeros); 
	}
	
	
	
	public abstract int numeroPasajeros();
	
	
	/**
	 * Informa de si el vehiculo esta lleno (CAPACIDAD_MAXIMA tripulantes)
	 * @return
	 */
	public boolean IsFull()
	{
		
		return (this.pasaje.size() >= CAPACIDAD_MAXIMA);
	}
	
	/**
	 * Informa de si el vehiculo esta vacio (0 tripulantes)
	 * @return
	 */
	public boolean IsEmpty()
	{
		
		return (this.pasaje.size() == 0);
	}
	
	

	public double getPuntosVida() {
		return puntosVida;
	}
	
	
	void recibirDanio(double puntosDanio) {
		this.puntosVida -= puntosDanio;
	}


	public double getAtaque() {
		return ataque;
	}


	public double getDefensa() {
		return defensa;
	}


	public String getNombre() {
		return nombre;
	}
	

	public List<Guerrero> getPasaje() {
		return pasaje;
	}
	

	/**
	 * agregar un guerero al vehiculo de guerra
	 * @param agrega un Guerro al vehiculo de guerra
	 * @throws Exception
	 */
	public void embarcar(Guerrero g) throws Exception{
		
		if (this.IsFull()) 
			throw new ExcesoCapacidadVehiculoException("Vehiculo lleno. no adminte mas personal");
		else this.pasaje.add(g);
	}

	@Override
	public abstract double atacar();

	@Override
	public abstract double defender(double d);

}

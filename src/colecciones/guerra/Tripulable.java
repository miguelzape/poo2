package colecciones.guerra;

public interface Tripulable {
	
	double PUNTOS_VIDA=1000.0;
	
	/**
	 * Genera los puntos de ataque de forma aleatoria
	 * @return puntos de ataque
	 */
	public double atacar ();
	
	
	/**
	 * Metodo que devuelve la diferencia entre el ataque recibido y la defensa generada
	 * @param puntos de ataque del atacante 
	 * @return daño recibido (defensa - ataque) nunca sera negativo
	 */
	public double defender (double ataque);
	

}

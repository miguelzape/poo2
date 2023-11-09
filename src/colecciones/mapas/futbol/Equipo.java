package colecciones.mapas.futbol;

public class Equipo {
	private String nombre;
	private int numLigas;
	private int numChampions;
	
	public Equipo(String nombre, int numLigas, int numChampions) {
		super();
		this.nombre = nombre;
		this.numLigas = numLigas;
		this.numChampions = numChampions;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumLigas() {
		return numLigas;
	}

	public void setNumLigas(int numLigas) {
		this.numLigas = numLigas;
	}

	public int getNumChampions() {
		return numChampions;
	}

	public void setNumChampions(int numChampions) {
		this.numChampions = numChampions;
	}

	@Override
	public String toString() {
		return "El equipo \'" + nombre + "\' ha ganado " + numLigas + " ligas y " + numChampions + " champions";
	}
	
	
	
	
}

package propiedades;

public enum EnumTornillo {

	NORMAL(1, "gris", 8, 3, 0.15), 
	PEQUE(2, "negro", 4, 2, 0.02), 
	GRANDE(3, "blanco", 15, 4, 0.25);

	private long id;
	private String color;
	private double longitud;
	private double diametro;
	private double precio;

	private EnumTornillo(int id, String color, double longitud, double diametro, double precio) {
		this.id = id;
		this.color = color;
		this.longitud = longitud;
		this.diametro = diametro;
		this.precio = precio;
	}

	public long getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public double getLongitud() {
		return longitud;
	}

	public double getDiametro() {
		return diametro;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "\n   id=" + id + " color=" + color + " longitud=" + longitud 
				+ " diametro=" + diametro + " precio=" + precio;
	}

}

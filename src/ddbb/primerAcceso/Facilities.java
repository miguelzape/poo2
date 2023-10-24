package ddbb.primerAcceso;

public class Facilities {
	private double heigth;
	private String address;
	private String category;
	private String descripcion;
	private String name;
	private long guid;
	private long id;
	
	
	// Constructor
	public Facilities(double heigth, String address, String category, String descripcion, String name, long guid,
			long id) {
		super();
		this.heigth = heigth;
		this.address = address;
		this.category = category;
		this.descripcion = descripcion;
		this.name = name;
		this.guid = guid;
		this.id = id;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Facilities [heigth=" + heigth + ", address=" + address + ", category=" + category + ", descripcion="
				+ descripcion + ", name=" + name + ", guid=" + guid + ", id=" + id + "]";
	}




	// metodos get y set
	public double getHeigth() {
		return heigth;
	}
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getGuid() {
		return guid;
	}
	public void setGuid(long guid) {
		this.guid = guid;
	}
	public long getId() {
		return id;
	}
	
	
	
	
}

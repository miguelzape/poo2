package oop.chorradatiendas;

public class Maniqui {
	private int id;
	private Vestido vestido;
	private Pantalon pantalon;
	private Camisa camisa;
	private static int elementos=0;
	/**
	 * @param vestido
	 * @param pantalon
	 * @param camisa
	 */
	public Maniqui(Vestido vestido, Camisa camisa) {
		super();
		++elementos;
		this.id=elementos;
		this.vestido = vestido;
		this.camisa = camisa;
	}
	
	public Maniqui(Pantalon pantalon, Camisa camisa) {
		super();
		++elementos;
		this.id=elementos;
		this.pantalon = pantalon;
		this.camisa = camisa;
	}
	
	public Maniqui() {++elementos;this.id=elementos;}
	public Vestido getVestido() {
		return vestido;
	}
	public void setVestido(Vestido vestido) {
		this.vestido = vestido;
	}
	public Pantalon getPantalon() {
		return pantalon;
	}
	public void setPantalon(Pantalon pantalon) {
		this.pantalon = pantalon;
	}
	public Camisa getCamisa() {
		return camisa;
	}
	public void setCamisa(Camisa camisa) {
		this.camisa = camisa;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Maniqui [id=" + id + ", vestido=" + vestido + ", pantalon=" + pantalon + ", camisa=" + camisa + "]";
	}
	
	public float precio() {
		float suma=0;
		if (this.camisa != null) suma += this.camisa.getPrecio();
		if (this.pantalon != null) suma += this.pantalon.getPrecio();
		if (this.vestido != null) suma += this.vestido.getPrecio();
		
		return (suma);
	}
	
	public void vestir(Vestido v,Camisa c)
	{
		this.desvestir();
		this.setVestido(v);
		this.setCamisa(c);
	}
	
	public void vestir(Pantalon p,Camisa c)
	{
		this.desvestir();
		this.setCamisa(c);
		this.setPantalon(p);
	}
	
	public void desvestir()
	{
//		this.vestido=new Vestido();
//		this.pantalon=new Pantalon();
//		this.camisa=new Camisa();
		
		this.vestido=null;
		this.pantalon=null;
		this.camisa=null;
	}
}

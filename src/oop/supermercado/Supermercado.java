package oop.supermercado;


public class Supermercado {

	private String nombre;
	private Cajera cajeras[];

	public Supermercado(String nombre_super, String... nombre_cajeras) {
		super();

		this.nombre = nombre_super;
		this.cajeras=new Cajera[nombre_cajeras.length];
		int i = 0;
		for (String nomCaj : nombre_cajeras) {
			this.cajeras[i++] = new Cajera(nomCaj);
		}
	}

	public void abrirSupermercado() {

		Producto pro1 = new Producto("La que moja", 0.5f, "agua");
		Producto pro2 = new Producto("La de burbujas", 1, "agua");
		Producto pro3 = new Producto("Los amarillos", 2.2f, "platanos");
		Producto pro4 = new Producto("Los azules", 2, "platanos");
		Producto pro5 = new Producto("0.0", 0.8f, "yogures");
		Producto pro6 = new Producto("griego", 1.5f, "yogures");
		Producto pro7 = new Producto("bio", 2, "yogures");
		Producto pro8 = new Producto("verdes", 3, "aceitunas");
		Producto pro9 = new Producto("negras", 3, "aceitunas");
		Producto productos[] = {pro1,pro2,pro3,pro4,pro5,pro6,pro7,pro8,pro9};
		
//		String cadenas[]=Producto.nombres(productos);
//		System.out.println(cadenas.toString());
		

		Cliente cli1 = new Cliente("Juan", 200,false, pro1, pro3, pro8, pro9);
		Cliente cli2 = new Cliente("Pepe", 180,false, pro3, pro4, pro9);
		Cliente cli3 = new Cliente("Tomas", 210,true, pro2, pro1, pro5, pro7);
		Cliente cli4 = new Cliente("Pedro", 150,false, pro2, pro1);
		Cliente clientes[] = { cli1, cli2, cli3, cli4 };
		
		
	    cli1.agregarProducto(productos);
	    cli2.agregarProducto(productos);
	    cli3.agregarProducto(productos);
	    cli4.agregarProducto(productos);


		// hacer que las cajeras cobren a los clientes
		int numCajeras = this.cajeras.length;
		for (int i=0;i<clientes.length;i++)
		{
			cajeras[(i%numCajeras)].cobraCliente(clientes[i]);
		}

	}

}

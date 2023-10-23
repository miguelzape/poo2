package oop.supermercado;

import utils.Utilidades;

public class Cajera {
	private int id;
	private String nombre;
	private static int elementos = 0;

	public Cajera(String nombre) {
		super();
		this.id = ++elementos;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cajera [id=" + id + ", nombre=" + nombre + "]";
	}

	public void cobraCliente(Cliente cliente) {
		float debe = 0;
		for (Producto p : cliente.getCarritoCompra()) {
			if (p != null) {
				debe += p.getPrecio();
				System.out.println(this.nombre + " cobra a " + cliente.getNombre() + " producto " + p.getProducto()
						+ " que cuesta " + p.getPrecio());
			}
		}
		if (cliente.isVip()) {
			System.out.println("El cliente tiene un descuento de 15%");
			debe *= 0.85;
		}
		cliente.paga(debe);
		
		System.out.println(cliente.getNombre() + " paga " + debe + " y le queda " + cliente.getSaldo() + "\n");
	}

}

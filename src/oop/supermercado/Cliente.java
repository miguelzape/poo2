package oop.supermercado;

import java.util.Arrays;

import utils.Utilidades;

public class Cliente {
	private int id;
	private String nombre;
	private Producto carritoCompra[];
	private int nProAgregados;
	private boolean vip;
	private float saldo;
	private static int elementos = 0;

	public Cliente(String nombre, float saldo, boolean vip, Producto... carritoCompra) {
		super();
		this.id = ++elementos;
		this.nombre = nombre;
		this.vip = vip;
		// this.carritoCompra = carritoCompra;
		this.carritoCompra = new Producto[10];
		this.nProAgregados = carritoCompra.length;
		for (int i = 0; i < this.carritoCompra.length; i++) {
			this.carritoCompra[i] = (i < carritoCompra.length) ? carritoCompra[i] : null;
		}

		this.saldo = saldo;
	}

	public void agregarProducto(Producto disponibles[]) {
		int seleccion;
		int nProdispo = disponibles.length;
		System.out.println(nombre + " tiene en su carrito: " + Arrays.toString(carritoCompra));
		String nombresProductos[] = new String[nProdispo];
		for (int i = 0; i < nProdispo; i++) {
			nombresProductos[i] = disponibles[i].getProducto();
		}

		do {
			seleccion = Utilidades.generaMenu("\nLos productos disponibles son: ", nombresProductos,
					"Dejar de comprar");
			if (seleccion != (nProdispo + 1) && nProAgregados < 10) {
				this.carritoCompra[this.nProAgregados++] = disponibles[seleccion-1];
			}

		} while (seleccion != (nProdispo + 1) && nProAgregados < 10);

	}

	@Override
	public String toString() {
		return "cliente [id=" + id + ", nombre=" + nombre + ", vip=" + vip + ", carritoCompra="
				+ Arrays.toString(carritoCompra) + "]";
	}

	public void paga(float importe) {
		this.saldo -= importe;
	}

	public Producto[] getCarritoCompra() {
		return carritoCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public float getSaldo() {
		return saldo;
	}

	public boolean isVip() {
		return vip;
	}

}

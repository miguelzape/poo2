package oop.hipodromo;

import utils.Utilidades;

public class Apostante {
	private String nombre;
	private int saldo;
	private int dineroApuesta;
	private int IdCaballoApuesta;

	public Apostante(String nombre, int saldo) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
		this.dineroApuesta = 0;
		IdCaballoApuesta = -1;
	}

	public void comprobarApuesta(int idGanador) {
		if (this.IdCaballoApuesta == idGanador ) {
			System.out.println("El apostante " + this.nombre + " ha ganado " + (this.dineroApuesta * 5));
			this.saldo += (this.dineroApuesta * 5);
		}

	}

	public void apostar(String carrera) {
		 String cadena="Cantidad que apuesta " + this.nombre + " en la carrera " + carrera + ": ";
		 int dineroApostado=Utilidades.pideNumero(cadena,1,this.saldo);
		 
		 this.IdCaballoApuesta=Utilidades.pideNumero("Id del caballo apostado:  ");
		 
		 this.dineroApuesta= (this.saldo >= dineroApostado) ? dineroApostado : this.saldo;
		 this.saldo -= this.dineroApuesta;
		 
	}

	public int getDineroApuesta() {
		return dineroApuesta;
	}

	public void setDineroApuesta(int dineroApuesta) {
		this.dineroApuesta = dineroApuesta;
	}

	public int getIdCaballoApuesta() {
		return IdCaballoApuesta;
	}

	public void setIdCaballoApuesta(int idCaballoApuesta) {
		IdCaballoApuesta = idCaballoApuesta;
	}

	public String getNombre() {
		return nombre;
	}

	public int getSaldo() {
		return saldo;
	}

}

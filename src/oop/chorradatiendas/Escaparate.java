package oop.chorradatiendas;

public class Escaparate {

	public static void main(String[] arg) {

		Boton boton1 = new Boton("ovalado", "gris", 2);
		Boton boton2 = new Boton("cuadrado", "blanco", 3);
		Boton botones[] = { boton1, boton1, boton2, boton2 };
		Pantalon pantalon = new Pantalon("negro", "M", boton1);
		Camisa camisa = new Camisa("rojo", "XL", botones);
		Camisa camisa2 = new Camisa("verde", "S", botones);
		Vestido vestido = new Vestido("Amarillo", "M");

		Maniqui mDesnudo = new Maniqui();
		Maniqui mVestido = new Maniqui(pantalon, camisa);

		Escaparate esca = new Escaparate();
		esca.mostrarEscaparate(mDesnudo, mVestido);

		mDesnudo.vestir(vestido, camisa2);

		System.out.println("\n\nDespues de vestir a mDesnudo: ");
		esca.mostrarEscaparate(mDesnudo, mVestido);

		mVestido.desvestir();

		System.out.println("\n\nDespues de desvestir a mVestido: ");
		esca.mostrarEscaparate(mDesnudo, mVestido);

	}

	void mostrarEscaparate(Maniqui... M) {
		if (M.length > 0) {
			for (Maniqui m : M) {
				System.out.println(m);
			}

			for (Maniqui m : M) {
				System.out.println("La ropa del maniqui " + m.getId() + " cuesta " + m.precio());
			}
		}
		else System.out.println("Escaparate vacio");
	}

}

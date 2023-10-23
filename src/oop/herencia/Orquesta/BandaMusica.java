package oop.herencia.Orquesta;

public class BandaMusica {

	private String nombre;

	public BandaMusica(String lNombre) {
		this.nombre = lNombre;
	}

	public static void main(String[] args) {

		BandaMusica banda = new BandaMusica("Incompetentes");
		banda.empezarConcierto();

	}

	private void empezarConcierto() {
		Guitarra guitarra = new Guitarra("unaGuitarra", "acustica", 6);
		GuitarraElectrica guitarraE = new GuitarraElectrica("otraGuitarra", "electrica", 6, 1200);
		Piano piano = new Piano("unPiano", "piano", 18, "compacto");
		Tambor tambor = new Tambor("unTambor", "tambor", "nylon");
/*		PruebaEnum paco;
		paco=PruebaEnum.DOS;
		
		switch(paco) {
		case UNO:
			break;
		case DOS:
			break;
		case TRES:
			break;
		}			*/
		
		
		Instrumento orquesta[] = { guitarra, guitarraE, piano, tambor };

		afinarInstrumentos(orquesta);
		tocarInstrumentos(orquesta);
		
		
	}

	private void afinarInstrumentos(Instrumento... orquesta) {
		for (Instrumento i : orquesta) {
			i.afinar();
		}
	}

	private void tocarInstrumentos(Instrumento... orquesta) {
		System.out.println("\nEmpieza a tocar la banda: " + this.nombre);

		for (Instrumento i : orquesta) {
			if (i instanceof Tambor) {
				((Tambor) i).aporrear();
			} else {
				i.tocar();
			}
		}
	}

}

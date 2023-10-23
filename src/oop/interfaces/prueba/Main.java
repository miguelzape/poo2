package oop.interfaces.prueba;

public class Main {

	public static void main(String[] args) {
		Main cosa=new Main();
		cosa.crearCosas();
	}
	
	
	
	private void crearCosas()
	{
	Movil movil1 = new Movil(130,"Invest","Androide");
	Television tele1= new Television(450,"LG",4);
	Moto moto1=new Moto("HB4512","Honda",2);
	Coche coche1=new Coche("JX4765","Mercedes",5);
	
	Usuario pepe=new Usuario(movil1,moto1,coche1,tele1);
	
	pepe.movil.encender();
	pepe.moto.encender();
	pepe.television.encender();
	pepe.coche.encender();
	
	encenderCosasClase(movil1);
	encenderCosasClase(moto1);
	encenderCosasClase(tele1);
	encenderCosasClase(coche1);
	
	encenderCosasInterface(movil1);
	encenderCosasInterface(moto1);
	encenderCosasInterface(tele1);
	encenderCosasInterface(coche1);
	}
	
	private void encenderCosasClase (SistemaEncendidoC aparato)
	{
		aparato.encender();
	}
	
	private void encenderCosasInterface (SistemaEncendido aparato)
	{
		aparato.encender();
	}

	
	
	
}



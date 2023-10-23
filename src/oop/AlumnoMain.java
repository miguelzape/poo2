package oop;

public class AlumnoMain {

	public static void main(String[] args) {
		Alumno al1,al2,al3,al4;
		
		al1=new Alumno();
		al2=new Alumno("10000Z","Manuel","Gordillo");
		al3=new Alumno("20000P","Tamara","Villa",7);
		al4=new Alumno(al3);
		
		al1.nombre="Pedro";
		al1.apellidos="Lopez";
		al1.dni="30000T";
		al1.nota=10;
		
		al2.nota=3;
		
		al1.estudiar();
		al2.estudiar();
		al3.estudiar();
		
	   //Alumno clase[]= {al1,al2,al3}; 
		
//		Alumno clase[]=new Alumno[3];	
//		clase[0]=new Alumno(al1);
//		clase[1]=new Alumno(al2);
//		clase[2]=new Alumno(al3);
		
		Alumno clase[]= {new Alumno(al1),new Alumno(al2),new Alumno(al3)};
		
		AlumnoMain kk = new AlumnoMain();
		kk.verAprobados (clase);
		
		al1.nombre="Emilio";
		kk.verAprobados (clase);
	
		
	}
	
	void verAprobados(Alumno clase[]) {
		System.out.println("\nLos alumnos aprobados son:");
		for (Alumno uno:clase) {
			if (uno.nota >=5) System.out.println(uno);
		}
	}

}

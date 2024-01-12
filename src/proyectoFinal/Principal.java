package proyectoFinal;

import java.util.Date;
import java.util.List;

import proyectoFinal.Daos.UserDao;
import utils.EnumColor;

public class Principal {

	public static void main(String[] args) {
		
		Principal p = new Principal();
		p.hacerTodo();

	}
	
	public void hacerTodo() {
		
		UserDao udao= new UserDao();
		User u1 = new User("user","clave","nombre","apellidos","dni","V","user@dominio.es",916050000,new Date());
		User u2 = new User("user2","clave2","nombre2","apellidos2","dni2","V","user2@dominio.es",916050002,new Date());
		
		udao.putUser(u1);
		udao.putUser(u2);
		
	
		for (User u: udao.getUsers()) {
			System.out.println(u);
		}
		
		System.out.printf(EnumColor.BLUE_BRIGHT.toString() + 
				"Existe el usuario user = %b",udao.existUsuario("user"));
		System.out.printf("Existe el usuario paco = %b",udao.existUsuario("paco"));
		System.out.printf("Existe el usuario user2 = %b",udao.existUsuario("user2"));
		System.out.printf("Existe el usuario leon = %b",udao.existUsuario("leon"));
		
		long respuesta = udao.validarUser("user","clave");
		
		System.out.printf(EnumColor.MAGENTA.toString() + "Id con user + clave = %d",respuesta);
		System.out.printf("Id con kk + p2 = %d",udao.validarUser("kk","p2"));
		
	
		
		
		
		
		
		
		
		
		udao.close();
	}

}

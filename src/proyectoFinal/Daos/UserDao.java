package proyectoFinal.Daos;



import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import proyectoFinal.entities.User;
import utils.JpaUtil;

public class UserDao {
	
	private EntityManager em;

	public UserDao() {
		em = JpaUtil.getEM("ejemploHibernate");
	}
	
	public void close() {
		if (em!=null) {
			em.close();
			em=null;
		}
	}
	

	public List<User> getUsers (){
		List<User> users;
		
		users = em.createQuery("from User", User.class)
			.getResultList();
		
		return users;
	}
	
	
	/**
	 * Esta funcion devuelve el userID que concuerde con el usuario y clave facilitados
	 * en caso de no exister ese usuario se devuelve un -1
	 * @param usuario
	 * @param clave
	 * @return Devuelve un long con el idUsuario. -1 si no existe
	 */
	public long validarUser (String usuario, String clave){
		List<User> users;
	
		
		TypedQuery<User> query = em.createQuery("from User c where c.usuario=?1", User.class);
		query.setParameter(1, usuario);
		
		users = query.getResultList();
		if (users.size()<1) {
			return -1;
		}
		for (User u : users) {
			if (Arrays.equals(u.getClave(),clave.getBytes())) { 
				return u.getIdUsuario();
			}
		}
		return -1L;
	}
	
	
	public List<User> getUserByUsuario (String usuario){
	
		TypedQuery<User> query = em.createQuery(
				"from User c where c.usuario=?1", User.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}
	
	public boolean existUsuario (String usuario){
		
		TypedQuery<User> query = em.createQuery( "from User c where c.usuario=?1", User.class);
		query.setParameter(1, usuario);
		return (query.getResultList().size())>0;
		
	}
	
	
	
	public void putUser (User u) {
		 em.getTransaction().begin(); 
		 try {
			 em.persist(u);
			 em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	}
	


	
}


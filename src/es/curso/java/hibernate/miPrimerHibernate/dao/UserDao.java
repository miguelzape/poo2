package es.curso.java.hibernate.miPrimerHibernate.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.curso.java.hibernate.miPrimerHibernate.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtil;

public class UserDao {
	
	private static final Logger logger = LogManager.getLogger(UserDao.class);
	private static EntityManager em;
	
	public UserDao() {
		super();
		em = JpaUtil.getEntityManager();
		// TODO Auto-generated constructor stub
	}

	public List <Usuario> getUsers() {
		logger.trace("Consultar todos los registros de la tabla Usuario");
		List<Usuario> usuarios = em.createQuery("FROM Usuario", Usuario.class).getResultList();
        //usuarios.forEach(System.out::println);//Método Referencia
        return(usuarios);
	}
	
	public List <Usuario> getUsersByName(String name) {
		logger.trace("Buscar los registros con nombre = " + name);
		// probar a modificar esto borrando el alias
		List<Usuario> usuarios; 
		
		Query query = em.createQuery("FROM Usuario ue WHERE ue.nombre=?1", Usuario.class);
		query.setParameter(1, name);
		//usuarios = query.getSingleResult()
		usuarios = query.getResultList();
		
        return(usuarios);
	}
	
	public List <Usuario> getUsersByDate(Date fecha) {
		logger.trace("Buscar los registros con fecha = " + fecha.toString());
		// probar a modificar esto borrando el alias
		List<Usuario> usuarios; 
		
		Query query = em.createQuery("FROM Usuario ue WHERE ue.FechaAlta>=?1", Usuario.class);
		query.setParameter(1, fecha);	
		return (query.getResultList());
	}



	public void insertaUsuarios(){
		Usuario user1 = new Usuario("Paco", "Porras", "123A", new Date());
		Usuario user2 = new Usuario("Benito", "Sobao", "456B", new Date());
		Usuario user3 = new Usuario("Alejo", "Mulejo", "789C", new Date());
		logger.debug("Empezando carga inicial de datos");
		try {
			em.getTransaction().begin();
			em.persist(user1);
			em.persist(user2);
			em.persist(user3);
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Error al insertar alumnos " + e.getMessage());
			em.getTransaction().rollback();
		}
		logger.debug("Termina");
	}

}

package es.curso.java.hibernate.miPrimerHibernate;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.curso.java.hibernate.basics.daos.AlumnoHibernateDAO;
import es.curso.java.hibernate.miPrimerHibernate.dao.UserDao;
import es.curso.java.hibernate.miPrimerHibernate.entities.Usuario;

public class Principal {

	private static final Logger logger = LogManager.getLogger(AlumnoHibernateDAO.class);

	public static void main(String[] args) {

		UserDao userDao = new UserDao();

		for (Usuario u : userDao.getUsers()) {
			logger.trace(u);
		}

	}

//	public void insertaUsuarios(){
//		Usuario user1 = new Usuario("Paco", "Porras", "123A", new Date());
//		Usuario user2 = new Usuario("Benito", "Sobao", "456B", new Date());
//		Usuario user3 = new Usuario("Alejo", "Mulejo", "789C", new Date());
//		logger.debug("Empezando carga inicial de datos");
//		try {
//			em.getTransaction().begin();
//			em.persist(user1);
//			em.persist(user2);
//			em.persist(user3);
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			logger.error("Error al insertar alumnos " + e.getMessage());
//			em.getTransaction().rollback();
//		}
//		logger.debug("Termina");
//	}

}

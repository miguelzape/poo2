package es.curso.java.hibernate.segundo;

import java.util.List;

import jakarta.persistence.EntityManager;

public class UsuarioDAO {
	
	private static EntityManager em;


	public UsuarioDAO(EntityManager em) {
		super();
		this.em=em;
	}
	
	public void insertarUsuario(Usuario user) {
		em.getTransaction().begin();
		try {
			em.persist(user);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
	
	public List<Usuario> getAll(){
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}
	
	

}

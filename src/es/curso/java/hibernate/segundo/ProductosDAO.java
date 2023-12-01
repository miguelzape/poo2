package es.curso.java.hibernate.segundo;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Parameter;
import jakarta.persistence.TypedQuery;

public class ProductosDAO {

	private static EntityManager em;

	
	public ProductosDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertarProductos(Productos p) {
		em.getTransaction().begin();
		try {
			em.persist(p);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public List<Productos> getAll() {
		return em.createQuery("from Productos", Productos.class).getResultList();

	}

	// mostrar los productos creados esta fecha
	public List<Productos> getForDate(Date fecha) {

		TypedQuery<Productos> query = em.createQuery("from Productos where fechaAlta=?1", Productos.class);

		query.setParameter(1, fecha);
		return query.getResultList();
	}

	public List<AuxBusqueda> getEspecial() {
		TypedQuery<AuxBusqueda> query = em.createQuery("SELECT NEW es.curso.java.hibernate.segundo.AuxBusqueda(tipo,AVG(precio),COUNT(id)) FROM Productos GROUP BY tipo",AuxBusqueda.class);
		return query.getResultList();		 
	}
}

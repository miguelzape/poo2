package es.curso.java.hibernate.basics;

import java.util.Scanner;

import es.curso.java.hibernate.basics.entities.Cliente;
import jakarta.persistence.EntityManager;
import utils.UtilsDB;

public class HibernateEliminar {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar:");
        Long id = scan.nextLong();
        EntityManager em = UtilsDB.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            //Cliente cliente1 = new Cliente();
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

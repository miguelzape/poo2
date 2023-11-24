package es.curso.java.hibernate.basics;

import java.util.Scanner;

import es.curso.java.hibernate.basics.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.UtilsDB;

public class HibernateSingleResultWhere {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        EntityManager em = UtilsDB.getEntityManager();
        Query query = em.createQuery("from Cliente c where c.formaPago=?1", Cliente.class);
        System.out.println("Ingrese una forma de pago: ");
        String pago = scan.next();
        query.setParameter(1, pago);
        query.setMaxResults(1);
        Cliente cliente = (Cliente) query.getSingleResult();
        System.out.println(cliente);
        em.close();
    }
}

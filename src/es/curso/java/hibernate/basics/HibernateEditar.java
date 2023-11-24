package es.curso.java.hibernate.basics;

import javax.swing.JOptionPane;

import es.curso.java.hibernate.basics.entities.Cliente;
import jakarta.persistence.EntityManager;
import utils.UtilsDB;

public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = UtilsDB.getEntityManager();
        try {

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
            Cliente cliente = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:", cliente.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:", cliente.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:", cliente.getFormaPago());
            
            em.getTransaction().begin();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(pago);
            em.merge(cliente);
            em.getTransaction().commit();

            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

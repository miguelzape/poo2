package es.curso.java.hibernate.biblio;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="TB_BIBLIS")
public class Biblioteca implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="BIBLIGEN", sequenceName="BIBLI_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BIBLIGEN")
	@Column(name="ID", nullable=false, updatable=false)
	private long id;
	private String nombre;
	@OneToOne (cascade={CascadeType.PERSIST, CascadeType.REMOVE})  //optional=false, fetch = fetchType.LAZY
    @PrimaryKeyJoinColumn//Si no se pone,aparece una nueva columna indicando la FK a la direccion
    //@JoinColumn(Table="FK_DIRECCION",referencedColumNsme = "FK_DIRECCION")
	private Direccion direccion;
	
	public Biblioteca() {
		super();
	}
	
	


	public Biblioteca(String nombre, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Biblioteca [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	
}




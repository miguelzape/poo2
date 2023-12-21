package es.curso.java.hibernate.biblio;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_DIRECCIONES")
public class Direccion implements Serializable
{
	@Id
	@SequenceGenerator(name="DIRECCIONESGEN", sequenceName="DIRECCIONES_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIRECCIONESGEN")
	@Column(name="ID", nullable=false, updatable=false)
    private long id;
    private String calle;
    private String codigoPostal;

    public Direccion()
    {
    }
    
    

    public Direccion(String calle, String codigoPostal) {
		super();
		this.calle = calle;
		this.codigoPostal = codigoPostal;
	}



	public long getId()
    {
        return id;
    }

    protected void setId(long id)
    {
        this.id = id;
    }
    
    public String getCalle()
    {
        return calle;
    }

    public void setCalle(String calle)
    {
        this.calle = calle;
    }

    public String getCodigoPostal()
    {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }
}
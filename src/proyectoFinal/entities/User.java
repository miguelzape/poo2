package proyectoFinal.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import es.curso.java.hibernate.relations.unomuchos.entities.Libro;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="TB_USERS")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idUsuario;
	
	@Column(length = 20, nullable=false) 
	private String usuario;
	@Column(length = 12, nullable=false) 
	private byte[] clave;
	@Column(length = 20) 
	private String nombre;
	@Column(length = 20) 
	private String apellidos;
	@Column(length = 9) 
	private String dni;
	@Column(length = 1) 
	private String sexo;
	private String email;
	private long telefono;
	private Date nacimiento;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="idUser")
	private List<Rol> roles = new ArrayList<Rol>();
	
	
	//Constructor vacio
	public User() {
		super();
	}
	
	//Constructor con todos los parametros
	public User(String usuario, String clave, String nombre, String apellidos, String dni, String sexo, String email,
			long telefono, Date nacimiento,List<Rol> roles) {
		super();
		this.usuario = usuario;
		this.clave = clave.getBytes();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.email = email;
		this.telefono = telefono;
		this.nacimiento = nacimiento;
		this.roles = roles;
	}
	
	// añadir un rol nuevo a la lista de roles
	public void addRol(Rol rol) {
		this.roles.add(rol);
	}
	
	

	//Metodos Get y Set
	
	
	public String getUsuario() {
		return usuario;
	}
	

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public byte[] getClave() {
	    return this.clave;
	}

	public void setClave(byte[] clave) {
	    this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	
	
	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	//metodo toString
	@Override
	public String toString() {
		return "User [idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + new String(clave)
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sexo=" + sexo + ", email="
				+ email + ", telefono=" + telefono + ", nacimiento=" + nacimiento + "]";
	}
	

}

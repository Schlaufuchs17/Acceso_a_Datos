package modelo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Libreria")
public class Libreria {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String nombreDueño;
	private String direccion;
		
	@ManyToMany(mappedBy = "libreria", cascade=CascadeType.ALL)
	private Libro libro;


	public Libreria(Integer id, String nombre, String nombreDueño, String direccion, Libro libro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreDueño = nombreDueño;
		this.direccion = direccion;
		this.libro = libro;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombreDueño() {
		return nombreDueño;
	}


	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
}

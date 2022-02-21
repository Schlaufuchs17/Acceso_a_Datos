package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_autor;
	
	private String nombre ;
	private String apellidos;
	private String fecha_Nacimiento;
	
	@OneToMany(mappedBy="autor", cascade=CascadeType.ALL)
	private List<Libro> libros;
	
	public Autor() {
		super();
		libros = new ArrayList<Libro>();
	}
	public Autor(String nombre, String apellidos, String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_Nacimiento = fechaNacimiento;
		libros = new ArrayList<Libro>();
	}
	public int getId() {
		return id_autor;
	}
	public void setId(int id) {
		this.id_autor = id;
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
	public String getFechaNacimiento() {
		return fecha_Nacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fecha_Nacimiento = fechaNacimiento;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_Nacimiento="
				+ fecha_Nacimiento + ", libros=" + libros + "]";
	}
	public void añadirLibro(Libro l1) {
		libros.add(l1);
		
	}

	
	
	
}

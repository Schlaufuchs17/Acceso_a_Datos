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
@Table(name="editoriales")

public class Editorial {
	
	@Override
	public String toString() {
		return "Editorial [id_editorial=" + id_editorial + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", librosPublicados=" + librosPublicados + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_editorial;
	
	private String nombre;
	private String direccion;
	
	
	@OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
	private List<Libro> librosPublicados;
	
	
	public Editorial() {
		super();
		librosPublicados = new ArrayList<Libro>();
	}
	public Editorial(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		librosPublicados = new ArrayList<Libro>();
	}
	public int getId() {
		return id_editorial;
	}
	public void setId(int id) {
		this.id_editorial = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Libro> getLibrosPublicados() {
		return librosPublicados;
	}
	public void setLibrosPublicados(ArrayList<Libro> librosPublicados) {
		this.librosPublicados = librosPublicados;
	}
	
	public void añadirLibro(Libro l1) {
		librosPublicados.add(l1);
		
	}
}

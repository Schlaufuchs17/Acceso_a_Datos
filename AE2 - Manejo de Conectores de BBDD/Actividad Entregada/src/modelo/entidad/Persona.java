package modelo.entidad;

public class Persona {

	int id;
	String nombre;
	int edad;
	int peso;
	int id_coches;
	public int getId_coches() {
		return id_coches;
	}
	public void setId_coches(int id_coches) {
		this.id_coches = id_coches;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", id_coches="
				+ id_coches + "]";
	}
	
	

	
	
	
	
	
	
	
	
}

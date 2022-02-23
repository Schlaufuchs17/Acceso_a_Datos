package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coches;

public interface DaoCoche {

	// Esta interfaz define un CRUD para el objeto persona
	// es decir, las operaciones básicas que podemos hacer con una entidad
	// Create
	// Read
	// Update
	// Delete

	public boolean alta(Coches p);

	public boolean baja(int id);

	public boolean modificar(Coches p);

	public Coches consultar(int id);// este es el de consultar por id

	public List<Coches> listar();// este es todo el listado de coches
}
package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Persona;

public interface DaoPersona {

	// Esta interfaz define un CRUD para el objeto persona
	// es decir, las operaciones b�sicas que podemos hacer con una entidad
	// Create
	// Read
	// Update
	// Delete

	public boolean alta(Persona p);// a�adir personas tabla personas

	public boolean baja(int id);// borrar personas tabla personas

	public boolean modificar(Persona p);

	public Persona consultar(int id);// este es el de consultar por id

	public List<Persona> listar();// este es todo el listado de personas en general

	public boolean a�adirPersona_coche(Persona p);

	public boolean Eliminar_pasajero(Persona p);

	public Persona consultar_persona_coche(int id);

}
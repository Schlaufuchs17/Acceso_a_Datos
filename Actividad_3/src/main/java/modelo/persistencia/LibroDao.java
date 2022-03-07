package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Libro;


public class LibroDao {
	private EntityManager en;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("JPA");
			en = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean cerrarConexion(){
		try {
			en.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int insertar(Libro libro) {
		if(!abrirConexion()) {
			return 0;
		}
		EntityTransaction et = en.getTransaction();
		et.begin();
		en.persist(libro);
		et.commit();
		cerrarConexion();
		
		return libro.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Libro> listar() {
		if(!abrirConexion()) {
			return null;
		}		
		//para hacer la consulta debemos de usar JPQL
		Query query = en.createQuery("select libro from Libro libro");
		List<Libro> libros = query.getResultList();
		return libros;
	}
}

package operacion; //Cambiar package antes llamado operaciones

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Autor;

public class _01_Alta_Autores {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("AI3"); //Creando el nombre de la entidad persistente
			
		EntityManager em = null;	
		
		//Dar de alta tres autores
		Autor a1 = new Autor(null, "Stephen", "King", null);
		Autor a2 = new Autor(null, "Anne", "Rice", null);
		Autor a3 = new Autor(null, "JRR", "Tolkien", null);
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		
		em.getTransaction().commit(); 
		em.close();		
		
		emf.close();		
	}
}

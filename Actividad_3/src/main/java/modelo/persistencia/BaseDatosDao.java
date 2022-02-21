package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Autor;

import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class BaseDatosDao {
	
	
	public void init() {
		//3 autores,
		Autor autor1 = new Autor("AUTOR-1", "LLLLL", "22-3-45");
		Autor autor2 = new Autor("AUTOR-2", "HHHHH ", "12-2-32");
		Autor autor3 = new Autor("AUTOR-3", "JJJJJ", "10-2-45");
		
		//2 editoriales
	
		
		Editorial editorial1 = new Editorial("editorial1", "cccc");
		Editorial editorial2 = new Editorial("editorial2", "fffff");


	
		Libro libro1 = new Libro("libro1", 33);
	
		libro1.setAutor(autor1);
		libro1.setEditorial(editorial1);
		autor1.añadirLibro(libro1);
		editorial1.añadirLibro(libro1);
		
		Libro libro2 = new Libro("libro2", 66, editorial2, autor2);
		
		libro2.setAutor(autor2);
		libro2.setEditorial(editorial2);
		autor2.añadirLibro(libro2);
		editorial2.añadirLibro(libro2);
		
		Libro libro3 = new Libro("libro3", 11, editorial1, autor3); 
		
		libro3.setAutor(autor3);
		libro3.setEditorial(editorial1);
		autor3.añadirLibro(libro3);
		editorial1.añadirLibro(libro3);
		Libro libro4 = new Libro("libro4", 2, editorial2, autor1);
		
		libro4.setAutor(autor1);
		libro4.setEditorial(editorial2);
		autor1.añadirLibro(libro4);
		editorial2.añadirLibro(libro4);
		
		Libro libro5 = new Libro("libro5", 88, editorial1, autor2);
		libro5.setAutor(autor2);
		libro5.setEditorial(editorial1);
		autor2.añadirLibro(libro5);
		editorial1.añadirLibro(libro5);
		
		Libro libro6 = new Libro("libro6", 55, editorial2, autor3);
		libro6.setAutor(autor3);
		libro6.setEditorial(editorial2);
		autor3.añadirLibro(libro6);
		editorial2.añadirLibro(libro6);
		
		Libro libro7 = new Libro("libro7", 99, editorial1, autor1);
		libro7.setAutor(autor1);
		libro7.setEditorial(editorial1);
		autor1.añadirLibro(libro7);
		editorial1.añadirLibro(libro7);
		
		Libro libro8 = new Libro("libro8", 88, editorial2, autor2);
		libro8.setAutor(autor2);
		libro8.setEditorial(editorial2);
		autor2.añadirLibro(libro8);
		editorial2.añadirLibro(libro8);

	
		
		
		Libreria libreria1 = new Libreria("libreria1", "aaaaa", "direccion");
		Libreria libreria2 = new Libreria("libreria2", "bbbbb", "direccion");
		
	
		List<Libreria> librerias1 = new ArrayList<Libreria>();
		List<Libreria> librerias2 = new ArrayList<Libreria>();
		List<Libro> libros1 = new ArrayList<Libro>();
		List<Libro> libros2 = new ArrayList<Libro>();
		
		librerias1.add(libreria1);
		
		libros1.add(libro1);
		libros1.add(libro2);
		libros1.add(libro3);
		libros1.add(libro4);
	
		libro1.setLibrerias(librerias1);
		libro2.setLibrerias(librerias1);
		libro3.setLibrerias(librerias1);
		libro4.setLibrerias(librerias1);
		
		libreria1.setColeccionLibros(libros1); 

	
		librerias2.add(libreria2);
		librerias2.add(libreria1);
		
		libros2.add(libro5);
		libros2.add(libro6);
		libros2.add(libro7);
		libros2.add(libro8);
	
		libro5.setLibrerias(librerias2);
		libro6.setLibrerias(librerias2);
		libro7.setLibrerias(librerias2);
		libro8.setLibrerias(librerias2);
	
		libreria2.setColeccionLibros(libros2);
		
		AutorDao autorDao = new AutorDao();
		autorDao.insertar(autor1);

	}

	public boolean conValores() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		long numeroFilas = (long) em.createQuery("SELECT COUNT(a.id) FROM Autor a").getSingleResult();
		et.commit();
		em.close();
		factory.close();
		if (numeroFilas > 0)
			return true;
		return false;
	}
}

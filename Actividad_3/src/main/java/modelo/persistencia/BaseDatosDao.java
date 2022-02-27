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
		
		// 3 AUTORES NOMBRE-DIRECCION-FECHA NACIMIENTO, EL ID SE AUTOINCREMENTA
		
		Autor autor1 = new Autor("AUTOR-1", "CALLE MORENO 33, 2 A, LEGANES", "22-3-45");
		Autor autor2 = new Autor("AUTOR-2", "CALLE ALCALA 66, 1 B ", "12-2-32");
		Autor autor3 = new Autor("AUTOR-3", "CALLE SIERRA MORENA 99", "10-2-45");
		
		//2 EDITORIALES NOMBRE-DIRECCION, EL ID SE AUTOINCREMENTA
	
		
		Editorial editorial1 = new Editorial("EDITORIAL 1", "CALLE MADRID 45, 3A");
		Editorial editorial2 = new Editorial("EDITORIAL 2", "CALLE OROPESA 55");


	// 8 LIBROS TITULO-PRECIO-EDITORIAL-AUTOR, ID SE AUTOINCREMENTA
		//LIBRO 1
		Libro libro1 = new Libro("libro1", 55,editorial1,autor1);
		Libro libro2 = new Libro("libro2", 02, editorial2, autor2);
		Libro libro3 = new Libro("libro3", 8, editorial1, autor3); 
		Libro libro4 = new Libro("libro4", 29, editorial2, autor1);
		Libro libro5 = new Libro("libro5", 9, editorial1, autor2);
		Libro libro6 = new Libro("libro6", 34, editorial2, autor3);
		Libro libro7 = new Libro("libro7", 89, editorial1, autor1);
		Libro libro8 = new Libro("libro8", 77, editorial2, autor2);
		
		// 2 LIBRRERIAS CON NOMBRE-DUEÑO-DIRECCION, ID SE AUTOINCREMENTA
		
		Libreria libreria1 = new Libreria("libreria1", "PUTIN", "PLAZA ROJA, MOSCU NUMERO 1");
		Libreria libreria2 = new Libreria("libreria2", "ZELESNKI", "PLAZA INDEPENDENCIA KIEV, NUMERO 1");
				
		// Todas estas entidades tendrán relaciones bidireccionales.
		
		
		
		//LIBRO1
		
		libro1.setEditorial(editorial2);
		autor1.añadirLibro(libro1);
		libro1.setAutor(autor2);
		editorial2.añadirLibro(libro1);
		
		
		//LIBRO2
		
		
		libro2.setAutor(autor1);
		libro2.setEditorial(editorial1);
		autor2.añadirLibro(libro2);
		editorial2.añadirLibro(libro2);
		
	
		//LIBRO3
		libro3.setAutor(autor3);
		libro3.setEditorial(editorial2);
		autor3.añadirLibro(libro3);
		editorial1.añadirLibro(libro3);
		
		
		//LIBRO4
		libro4.setAutor(autor3);
		libro4.setEditorial(editorial1);
		autor1.añadirLibro(libro4);
		editorial2.añadirLibro(libro4);
		
		
		//LIBRO5
		libro5.setAutor(autor3);
		libro5.setEditorial(editorial2);
		autor2.añadirLibro(libro5);
		editorial1.añadirLibro(libro5);
		
		
		//LIBRO6
		libro6.setAutor(autor3);
		libro6.setEditorial(editorial1);
		autor3.añadirLibro(libro6);
		editorial2.añadirLibro(libro6);
		
		
		//LIBRO7
		libro7.setAutor(autor3);
		libro7.setEditorial(editorial2);
		autor1.añadirLibro(libro7);
		editorial1.añadirLibro(libro7);
		
		
		//LIBRO8
		libro8.setAutor(autor1);
		libro8.setEditorial(editorial1);
		autor2.añadirLibro(libro8);
		editorial2.añadirLibro(libro8);
        
	
		
		
		
	    //ARRAYLIST DE LIBRERIAS
		List<Libreria> librerias1 = new ArrayList<Libreria>();
		List<Libreria> librerias2 = new ArrayList<Libreria>();
		librerias1.add(libreria1);
		
		//ARRAYLIST DE LIBROS
		List<Libro> libros1 = new ArrayList<Libro>();
		List<Libro> libros2 = new ArrayList<Libro>();
		
		
		//BIDIRECCIONAL
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
		
		libros2.add(libro4);
		libros2.add(libro8);
		libros2.add(libro1);
		libros2.add(libro2);
	
		libro5.setLibrerias(librerias2);
		libro6.setLibrerias(librerias2);
		libro7.setLibrerias(librerias2);
		libro8.setLibrerias(librerias2);
	
		libreria2.setColeccionLibros(libros2);
		
		AutorDao autorDao = new AutorDao();
		autorDao.insertar(autor1);

	}
        //Tenemos que apoyarnos en un lenguaje auxiliar que es JPQL para hacer esta consulta
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

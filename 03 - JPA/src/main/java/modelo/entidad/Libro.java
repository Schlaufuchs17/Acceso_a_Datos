package modelo.entidad;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Libro")
public class Libro {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String titulo;
		private Integer precio;
		
		@OneToOne(mappedBy = "libro", cascade=CascadeType.ALL)
		private Editorial editorial;
		
		
		@OneToOne(mappedBy = "libro", cascade=CascadeType.ALL)
		private Autor autor;


		public Libro(Integer id, String titulo, Integer precio, Editorial editorial, Autor autor) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.precio = precio;
			this.editorial = editorial;
			this.autor = autor;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getTitulo() {
			return titulo;
		}


		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


		public Integer getPrecio() {
			return precio;
		}


		public void setPrecio(Integer precio) {
			this.precio = precio;
		}


		public Editorial getEditorial() {
			return editorial;
		}


		public void setEditorial(Editorial editorial) {
			this.editorial = editorial;
		}


		public Autor getAutor() {
			return autor;
		}


		public void setAutor(Autor autor) {
			this.autor = autor;
		}
		
}
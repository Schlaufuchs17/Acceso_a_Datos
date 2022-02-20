package modelo.entidad;// CAMBIADO

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generar identidad
	private Integer id; //Generar id
	private String nombre; //Generar nombre
	private String apellidos; //Generar apellidos
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento; //Declararlo como private para que no se pueda acceder

	public Autor(Integer id, String nombre, String apellidos, Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
		
}
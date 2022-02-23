package vehiculo;
import java.io.Serializable;
import java.util.Objects;

public class Coche implements Serializable,Comparable<Coche> {
    private static final long serialversionUID = 1L;

/* Creamos las variables */
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;

/* Los constructores los creamos vacios */
    public Coche(String marca, String color, String modelo, String matricula) {
        super();
        this.id = id;
        this.marca = marca;
        this.matricula = matricula;
        this.color = color;
        this.modelo = modelo;
    }
    public Coche(){
        super();
    }
    
/* Introducimos los metodos set-get, con los que accederemos a las propiedades del coche*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
/* Crearemos el metodo tostring para convertir a cadena los archivos */ 
    @Override
    public String toString() { 
        return "Coche{" +
                "ID: " + id +
                ", Marca: '" + marca + '\'' +
                ", Color: '" + color + '\'' +
                ", Modelo: '" + modelo + '\'' +
                ", Matricula: '" + matricula + '\'' +
                '}';
    }

/* Con el metodo equals comprobaremos si los objetos que intrduzcamos coinciden en el nombre y son del mismo tipo */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return id == coche.id && matricula.equals(coche.matricula) && marca.equals(coche.marca) && modelo.equals(coche.vehiculo) && color.equals(coche.color);
    }
/* Con hashscode devolvera el numero entero */
    @Override
    public int hashCode() {
        return Objects.hash(id, matricula, marca, modelo, color);
    }
/* Con compareto comprobaremos que las dos cadenas son iguales */
    @Override
    public int compareTo(Coche o) {
        return 0;
    }
}
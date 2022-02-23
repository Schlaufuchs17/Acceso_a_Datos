package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coches;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche {

	private Connection conexion;

	public boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean alta(Coches p) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		String query = "insert into coches (COLOR,MARCA,MATRICULA,MODELO) " + " values(?,?,?,?)";
		try {
			// preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getColor());
			ps.setString(2, p.getMarca());
			ps.setString(3, p.getMatricula());
			ps.setString(4, p.getModelo());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return alta;
	}

	@Override
	public boolean baja(int id) {
		if (!abrirConexion()) {
			return false;
		}

		boolean borrado = true;
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			// sustituimos la primera interrgante por la id
			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja" + " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;
	}

	@Override
	public boolean modificar(Coches p) {
		if (!abrirConexion()) {
			return false;
		}
		boolean modificado = true;
		String query = "update coches set MATRICULA=?, MARCA=?,MODELO=?,COLOR=? " + " WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getMatricula());
			ps.setString(2, p.getMarca());
			ps.setString(3, p.getModelo());
			ps.setString(4, p.getColor());
			ps.setInt(5, p.getId());
			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				modificado = false;
		} catch (SQLException e) {

			System.out.println("modificar -> error al modificar la " + " coche " + p);
			modificado = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return modificado;
	}

	@Override
	public Coches consultar(int id) {
		if (!abrirConexion()) {
			return null;
		}
		Coches coches = null;

		String query = "select ID,MATRICULA,MARCA,MODELO,COLOR from coches " + "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coches = new Coches();
				coches.setId(rs.getInt(1));
				coches.setMatricula(rs.getString(2));
				coches.setMarca(rs.getString(3));
				coches.setModelo(rs.getString(4));
				coches.setColor(rs.getString(5));

			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener la " + "coche con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return coches;
	}

	@Override
	public List<Coches> listar() {
		if (!abrirConexion()) {
			return null;
		}
		List<Coches> listaCoches = new ArrayList<>();

		String query = "select ID,MATRICULA,MARCA,MODELO,COLOR from coches";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Coches coches = new Coches();
				coches.setId(rs.getInt(1));
				coches.setMatricula(rs.getString(2));
				coches.setMarca(rs.getString(3));
				coches.setModelo(rs.getString(4));
				coches.setColor(rs.getString(5));

				listaCoches.add(coches);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los " + "coches");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return listaCoches;
	}

}

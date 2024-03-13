package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Perro;
import utils.DBUtils;

public class GestorTablaPerros {

	/**
	 * Inicio de las Select de Perros
	 * @return
	 */
	public List<Perro> obtenerPerros(){
		
		List<Perro> perros = new ArrayList<Perro>();
		
		String sql = "select * from perros";
		
		Connection connection = null;
		Statement stm = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(DBUtils.DRIVER);
			
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			
			stm = connection.createStatement();
			resultSet = stm.executeQuery(sql);
			
			while (resultSet.next()) {
				Perro perro = new Perro();
				perro.setId(resultSet.getInt("id"));
				perro.setNombre(resultSet.getString("nombre"));
				perro.setRaza(resultSet.getString("raza"));
				perro.setVacunado(resultSet.getBoolean("vacunado"));
				
				perros.add(perro);
			}
			
		}catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarconnectionBBDD(connection, stm, resultSet);
		}
		
		return perros;
	}
	
	private void cerrarconnectionBBDD(Connection connection, Statement stm, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {	
				// Nothing
			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				// Nothing
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// Nothing
			}
		}
	}
}

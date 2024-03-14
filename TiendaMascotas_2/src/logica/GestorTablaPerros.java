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

public class GestorTablaPerros implements GestorInterfaz<Perro> {

	/**
	 * I get the list of dogs by Select
	 * @return
	 */
	public List<Perro> obtenerTodos(){
		
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
	
	
	/**
	 * I get the list of dogs by Id
	 */
	@Override
	public List<Perro> obtenerPorId(int id) {
		
		List<Perro> perros = new ArrayList<Perro>();
		
		String sql = "select * from perros where id = ?";
		
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
	
	/**
	 * This is to close the connection with the database
	 * Nothing should go in the catch
	 * @param connection
	 * @param stm
	 * @param resultSet
	 */
	private void cerrarconnectionBBDD(Connection connection, Statement stm, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {	
				
			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
	}

}

package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Cocodrilo;
import utils.DBUtils;

public class GestorTablaCocodrilos implements GestorInterfaz<Cocodrilo>{
	
	/**
	 * I get the list of cocodrile by Select
	 * @return
	 */
	public List<Cocodrilo> obtenerTodos(){
		
		List<Cocodrilo> cocodrilos = new ArrayList<Cocodrilo>();
		
		String sql = "select * from Cocodrilo";
		
		Connection connection = null;
		Statement stm = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(DBUtils.DRIVER);
			
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			
			stm = connection.createStatement();
			resultSet = stm.executeQuery(sql);
			
			while (resultSet.next()) {
				Cocodrilo cocodrilo = new Cocodrilo();
				cocodrilo.setId(resultSet.getInt("id"));
				cocodrilo.setEspecie(resultSet.getString("especie"));
				cocodrilo.setNumeroDientes(resultSet.getInt("numeroDientes"));
				cocodrilo.setTipoAgua(resultSet.getString("tipoAgua"));
				
				cocodrilos.add(cocodrilo);
			}
			
		}catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarconnectionBBDD(connection, stm, resultSet);
		}
		
		return cocodrilos;
	}

	@Override
	public List<Cocodrilo> obtenerPorId(int id) {
		
List<Cocodrilo> cocodrilos = new ArrayList<Cocodrilo>();
		
		String sql = "select * from Cocodrilo where id = ?";
		
		Connection connection = null;
		Statement stm = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(DBUtils.DRIVER);
			
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			
			stm = connection.createStatement();
			resultSet = stm.executeQuery(sql);
			
			while (resultSet.next()) {
				Cocodrilo cocodrilo = new Cocodrilo();
				cocodrilo.setId(resultSet.getInt("id"));
				cocodrilo.setEspecie(resultSet.getString("especie"));
				cocodrilo.setNumeroDientes(resultSet.getInt("numeroDientes"));
				cocodrilo.setTipoAgua(resultSet.getString("tipoAgua"));
				
				cocodrilos.add(cocodrilo);
			}
			
		}catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarconnectionBBDD(connection, stm, resultSet);
		}
		
		return cocodrilos;
	}

	@Override
	public Cocodrilo addPet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cocodrilo eliminatePet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cocodrilo modifyPet() {
		// TODO Auto-generated method stub
		return null;
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

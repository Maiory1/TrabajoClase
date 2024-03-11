package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Gato;
import pojo.Perro;
import pojo.Tortuga;

public class DBAccessSelects {
	
	/**
	 * Metodo que devuelve todos los gatos
	 * @return
	 */
	
	public List<Gato> obtenerGatos() {
		
		List<Gato> gatos = new ArrayList<Gato>();
		
		String sql = "select * from gatos";
		
		Connection connection = null;
		
		Statement stm = null;
		ResultSet resultSet = null;
	
		
		try {
			Class.forName(DBUtils.DRIVER);
			
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			
			stm = connection.createStatement();
			resultSet = stm.executeQuery(sql);
			
			while (resultSet.next()) {
				Gato gato = new Gato();
				gato.setIdCollarG(resultSet.getInt("idCollarG"));
				gato.setNomGato(resultSet.getString("nomGato"));
				gato.setRazaG(resultSet.getString("razaG"));
				
				gatos.add(gato);
			}
			
		}catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarconnectionBBDD(connection, stm, resultSet);
		}
		
		return gatos;
		
	}
	
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
				perro.setIdCollarP(resultSet.getInt("idCollarP"));
				perro.setNomPerro(resultSet.getString("nomPerro"));
				perro.setRazaP(resultSet.getString("razaP"));
				perro.setVacunado(resultSet.getString("vacunado"));
				
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
	
	public List<Tortuga> obtenerTortugas(){
			
			List<Tortuga> tortugas = new ArrayList<Tortuga>();
			
			String sql = "select * from tortugas";
			
			Connection connection = null;
			Statement stm = null;
			ResultSet resultSet = null;
			
			try {
				Class.forName(DBUtils.DRIVER);
				
				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				
				stm = connection.createStatement();
				resultSet = stm.executeQuery(sql);
				
				while (resultSet.next()) {
					Tortuga tortuga = new Tortuga();
					tortuga.setIdTortuga(resultSet.getInt("idTortuga"));
					tortuga.setEspecie(resultSet.getString("especie"));
					tortuga.setTipoAgua(resultSet.getString("tipoAgua"));
					
					tortugas.add(tortuga);
				}
				
			}catch (SQLException e) {
				System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("ERROR GENERICO :" + e.getMessage());
			} finally {
				cerrarconnectionBBDD(connection, stm, resultSet);
			}
			
			return tortugas;
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

package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Tortuga;
import utils.DBUtils;

public class GestorTablaTortugas {
	
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
				tortuga.setId(resultSet.getInt("id"));
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

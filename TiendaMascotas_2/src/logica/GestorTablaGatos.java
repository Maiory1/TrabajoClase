package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Gato;
import utils.DBUtils;


public class GestorTablaGatos {

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
				gato.setId(resultSet.getInt("id"));
				gato.setNombre(resultSet.getString("nombre"));
				gato.setRaza(resultSet.getString("raza"));
				gato.setColor(resultSet.getString("color"));
				
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

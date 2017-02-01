/**
 * 
 */
package fr.imie.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author imiedev
 *
 */
public class ConnexionManagement implements IConnexionManagement {
	private String url = "jdbc:postgresql://localhost:5432/fcpe";
    private String username = "postgres";   
    private String password = "postgres";
    
    public ConnexionManagement() {
		super();
	}
	
    @Override
    public Connection getConnection() throws SQLException {
    	Connection connection = null;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    
    @Override
    public void closeConnection(Connection connection, ResultSet resultSet, Statement statement) {
    	try {
    		if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}

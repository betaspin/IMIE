package imie.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import imie.model.UserDTO;

public class UserDAO {
	
	public UserDTO getUser(String login, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDTO user = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TPJSP2", "postgres", "postgres");
			
			String selectUserQuery = "SELECT firstname, lastname, email, password FROM users WHERE email=? AND password=?";
			statement = connection.prepareStatement(selectUserQuery);
			statement.setString(1, login);
			statement.setString(2, password);			
			resultSet = statement.executeQuery();
			if(resultSet != null){
				resultSet.next();
				user = new UserDTO(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("email"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return user;
	}
}

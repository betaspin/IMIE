package fr.imie.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface IConnexionManagement {
	public Connection getConnection() throws SQLException;
	public void closeConnection(Connection connection, ResultSet resultSet, Statement statement);
}

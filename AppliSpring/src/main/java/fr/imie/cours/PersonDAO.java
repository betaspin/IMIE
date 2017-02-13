package fr.imie.cours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.imie.cours.Person;

public class PersonDAO extends ADAO<Person>{

	@Override
	public List<Person> findAll() {
		
		String sql = "SELECT id, firstname, lastname FROM person";
				
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery()){
			List<Person> list = new ArrayList<>();
			while(resultset.next()){
				Person person = new Person();
				person.setId(resultset.getInt("id"));
				person.setFirstname(resultset.getString("firstname"));
				person.setLastname(resultset.getString("lastname"));
				list.add(person);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Person findOne(Person data) {
		
		return findOne(data.getId());

	}

	@Override
	public Person findOne(Integer i) {
		
		String sql = "SELECT id, firstname, lastname FROM person WHERE id = ?";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				){
					
			statement.setInt(1, i);
			
			ResultSet resultset = statement.executeQuery();
			resultset.next();
			Person person = new Person();
			person.setId(resultset.getInt("id"));
			person.setFirstname(resultset.getString("firstname"));
			person.setLastname(resultset.getString("lastname"));
			return person;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Person insert(Person data) {
		
		String sql = " INSERT INTO person ( firstname , lastname ) VALUES ( ? , ? ) ";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
			
			statement.setString(1, data.getFirstname());
			statement.setString(2, data.getLastname());
			
			statement.executeUpdate();
			
			ResultSet keys = statement.getGeneratedKeys();
			
			keys.next();
			
			data.setId(keys.getInt(1));
			return data;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Person update(Person data) {
		
		String sql = "UPDATE person set firstname = ? , lastname = ? WHERE id = ?";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			
			statement.setString(1, data.getFirstname());
			statement.setString(2, data.getLastname());
			statement.setInt(3, data.getId());
			
			statement.executeUpdate();

			return data;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void delete(Person data) {
		
		String sql = "DELETE FROM person WHERE id = ?";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			
			statement.setInt(1, data.getId());
			
			statement.executeUpdate();

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		
	}

	@Override
	public void delete(Integer i) {
		
		String sql = "DELETE FROM person WHERE id = ?";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			
			statement.setInt(1, i);
			
			statement.executeUpdate();

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		
	}

	@Override
	public void deleteAll() {
		
		String sql = "DELETE FROM person";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			
			statement.executeUpdate();

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		
	}

}

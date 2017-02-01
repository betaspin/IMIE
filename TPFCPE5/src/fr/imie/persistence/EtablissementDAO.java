/**
 * 
 */
package fr.imie.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.model.AdresseDTO;
import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public class EtablissementDAO implements IEtablissementDAO {

	@Override
	public List<EtablissementDTO> listAllEtablissement() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<EtablissementDTO> etablissementDTOs = new ArrayList<>();
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fcpe", "postgres", "postgres");
			String selectAllEtablissementQuery = "Select id, nom, num_rue, nom_rue, code_postal, ville from etablissement";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectAllEtablissementQuery);
			while (resultSet.next()) {
				// System.out.println(resultSet.getString("nom"));

				AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
						resultSet.getString("nom_rue"), resultSet.getString("code_postal"),
						resultSet.getString("ville"));
				EtablissementDTO etablissement = new EtablissementDTO().initDTO(resultSet.getString("nom"), adresseDTO);
				etablissement.setId(resultSet.getInt("id"));
				etablissementDTOs.add(etablissement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return etablissementDTOs;
	}

	@Override
	public EtablissementDTO createEtablissement(EtablissementDTO etablissementDTO) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		EtablissementDTO etablissementOut=null;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fcpe", "postgres", "postgres");
			String insertEtablissementQuery = "INSERT INTO etablissement(nom, num_rue, nom_rue, code_postal, ville) VALUES (?,?,?,?,?) returning id, nom, num_rue, nom_rue, code_postal, ville";
			statement = connection.prepareStatement(insertEtablissementQuery);
			statement.setString(1, etablissementDTO.getNom());
			statement.setInt(2, etablissementDTO.getAdresse().getNumero());
			statement.setString(3, etablissementDTO.getAdresse().getNomVoie());
			statement.setString(4, etablissementDTO.getAdresse().getCP());
			statement.setString(5, etablissementDTO.getAdresse().getVille());

			resultSet = statement.executeQuery();
			resultSet.next();
			// System.out.println(resultSet.getString("nom"));

			AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
					resultSet.getString("nom_rue"), resultSet.getString("code_postal"), resultSet.getString("ville"));
			etablissementOut = new EtablissementDTO().initDTO(resultSet.getString("nom"), adresseDTO);
			etablissementOut.setId(resultSet.getInt("id"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return etablissementOut;

	}

	@Override
	public void deleteEtablissement(EtablissementDTO etablissementDTOToDelete) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fcpe", "postgres", "postgres");
			String insertEtablissementQuery = "delete from etablissement where id=?";
			statement = connection.prepareStatement(insertEtablissementQuery);
			statement.setInt(1, etablissementDTOToDelete.getId());
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTOToUpdate) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		EtablissementDTO etablissementOut=null;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fcpe", "postgres", "postgres");
			String insertEtablissementQuery = "UPDATE etablissement set nom=?, num_rue=?, nom_rue=?, code_postal=?, ville=? where id=? returning id, nom, num_rue, nom_rue, code_postal, ville";
			statement = connection.prepareStatement(insertEtablissementQuery);
			statement.setString(1, etablissementDTOToUpdate.getNom());
			statement.setInt(2, etablissementDTOToUpdate.getAdresse().getNumero());
			statement.setString(3, etablissementDTOToUpdate.getAdresse().getNomVoie());
			statement.setString(4, etablissementDTOToUpdate.getAdresse().getCP());
			statement.setString(5, etablissementDTOToUpdate.getAdresse().getVille());
			statement.setInt(6, etablissementDTOToUpdate.getId());

			resultSet = statement.executeQuery();
			resultSet.next();
			// System.out.println(resultSet.getString("nom"));

			AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
					resultSet.getString("nom_rue"), resultSet.getString("code_postal"), resultSet.getString("ville"));
			etablissementOut = new EtablissementDTO().initDTO(resultSet.getString("nom"), adresseDTO);
			etablissementOut.setId(resultSet.getInt("id"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return etablissementOut;
		
	}

}

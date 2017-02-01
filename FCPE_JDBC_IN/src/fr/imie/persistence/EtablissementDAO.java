/**
 * 
 */
package fr.imie.persistence;

import java.sql.Connection;
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
public class EtablissementDAO implements IEtablissementDAO{
	private IConnexionManagement connexionManagement;	
	
	
	public EtablissementDAO(IConnexionManagement connexionManagement) {
		super();
		this.connexionManagement = connexionManagement;
	}

	@Override
	public List<EtablissementDTO> listAllEtablissement() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<EtablissementDTO> etablissementDTOs = new ArrayList<>();
		
		try {
			connection = connexionManagement.getConnection();
			String selectAllEtablissementQuery = "Select id, nom, num_rue, nom_rue, code_postal, ville from etablissement";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectAllEtablissementQuery);
			while (resultSet.next()) {
				// System.out.println(resultSet.getString("nom"));

				AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
						resultSet.getString("nom_rue"), resultSet.getString("code_postal"),
						resultSet.getString("ville"));
				EtablissementDTO etablissement = new EtablissementDTO().initDTO(resultSet.getInt("id"), resultSet.getString("nom"), adresseDTO);

				etablissementDTOs.add(etablissement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexionManagement.closeConnection(connection, resultSet, statement);
		}
		return etablissementDTOs;
	}

	@Override
	public void creerEtablissement(EtablissementDTO etablissement) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = connexionManagement.getConnection();
			String createEtablissementQuery = "INSERT INTO etablissement (nom, num_rue, nom_rue, code_postal, ville) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(createEtablissementQuery);
			pstmt.setString(1, etablissement.getNom());
			pstmt.setInt(2, etablissement.getAdresse().getNumero());
			pstmt.setString(3, etablissement.getAdresse().getNomVoie());
			pstmt.setString(4, etablissement.getAdresse().getCP());
			pstmt.setString(5, etablissement.getAdresse().getVille());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connexionManagement.closeConnection(connection, null, statement);
		}
	}

	@Override
	public void supprimerEtablissement(EtablissementDTO etablissement) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = connexionManagement.getConnection();
			String createEtablissementQuery = "DELETE FROM etablissement WHERE id = ?";
			PreparedStatement pstmt = connection.prepareStatement(createEtablissementQuery);
			pstmt.setInt(1, etablissement.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connexionManagement.closeConnection(connection, null, statement);
		}
	}

	@Override
	public void modifierEtablissement(EtablissementDTO etablissement) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = connexionManagement.getConnection();
			String createEtablissementQuery = "UPDATE etablissement SET nom = ?, num_rue = ?, nom_rue = ?, code_postal = ?, ville = ? WHERE id = ?";
			PreparedStatement pstmt = connection.prepareStatement(createEtablissementQuery);
			pstmt.setString(1, etablissement.getNom());
			pstmt.setInt(2, etablissement.getAdresse().getNumero());
			pstmt.setString(3, etablissement.getAdresse().getNomVoie());
			pstmt.setString(4, etablissement.getAdresse().getCP());
			pstmt.setString(5, etablissement.getAdresse().getVille());
			pstmt.setInt(6, etablissement.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connexionManagement.closeConnection(connection, null, statement);
		}
	}

	@Override
	public EtablissementDTO getEtablissement(Integer id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		EtablissementDTO etablissement = null;
		
		try {
			connection = connexionManagement.getConnection();
			String createEtablissementQuery = "SELECT * FROM etablissement WHERE id = ?";
			PreparedStatement pstmt = connection.prepareStatement(createEtablissementQuery);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			resultSet.next();
			AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
					resultSet.getString("nom_rue"), resultSet.getString("code_postal"),
					resultSet.getString("ville"));
			etablissement = new EtablissementDTO().initDTO(resultSet.getInt("id"), resultSet.getString("nom"), adresseDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connexionManagement.closeConnection(connection, resultSet, statement);
		}	
		

		return etablissement;	
	}
}

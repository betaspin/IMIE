/**
 * 
 */
package fr.imie.model;

/**
 * @author imiedev
 *
 */
public class EtablissementDTO {

	private Integer id;
	private String nom;
	private AdresseDTO adresse;
	
	
	
	public EtablissementDTO initDTO(Integer id, String nom, AdresseDTO adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		return this;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public AdresseDTO getAdresse() {
		return this.adresse;
	}
	
	public void setAdresse(AdresseDTO adresse) {
		this.adresse = adresse;
	}
	
	

}

/**
 * 
 */
package fr.imie.model;

/**
 * @author imiedev
 *
 */
public class EtablissementDTO {

	private String nom;
	private AdresseDTO adresse;
	
	
	
	public EtablissementDTO initDTO(String nom, AdresseDTO adresse) {
		this.nom = nom;
		this.adresse = adresse;
		return this;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public AdresseDTO getAdresse() {
		return adresse;
	}
	public void setAdresse(AdresseDTO adresse) {
		this.adresse = adresse;
	}
	
	

}

/**
 * 
 */
package fr.imie.model;

/**
 * @author imiedev
 *
 */
public class AdresseDTO {

	private Integer numero;
	private String nomVoie;
	private String CP;
	private String ville;

	public AdresseDTO initDTO(Integer numero, String nomVoie, String CP, String ville) {
		this.numero = numero;
		this.nomVoie = nomVoie;
		this.CP = CP;
		this.ville = ville;
		return this;
	}

	public String getMergedAdress() {
		return String.format("%s %s %S %s\n", this.getNumero(), this.getNomVoie(), this.getCP(), this.getVille());
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String CP) {
		this.CP = CP;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}

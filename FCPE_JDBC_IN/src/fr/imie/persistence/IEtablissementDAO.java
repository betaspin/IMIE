/**
 * 
 */
package fr.imie.persistence;

import java.util.List;

import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public interface IEtablissementDAO {
	public abstract List<EtablissementDTO> listAllEtablissement();
	public abstract void creerEtablissement(EtablissementDTO etablissement);
	public abstract void supprimerEtablissement(EtablissementDTO etablissement);
	public abstract void modifierEtablissement(EtablissementDTO etablissement);
	public abstract EtablissementDTO getEtablissement(Integer id);
}

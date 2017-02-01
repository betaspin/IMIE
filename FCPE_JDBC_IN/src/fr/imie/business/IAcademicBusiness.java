/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public interface IAcademicBusiness {	
	public abstract List<EtablissementDTO> listAllEtablissement();
	public abstract void creerEtablissement(EtablissementDTO etablissement);
	public abstract void supprimerEtablissement(EtablissementDTO etablissement);
	public abstract void modifierEtablissement(EtablissementDTO etablissement);
	public abstract EtablissementDTO getEtablissement(Integer id);
}

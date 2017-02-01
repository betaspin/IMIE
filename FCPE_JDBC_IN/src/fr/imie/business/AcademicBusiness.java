/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.model.EtablissementDTO;
import fr.imie.persistence.IEtablissementDAO;

/**
 * @author imiedev
 *
 */
public class AcademicBusiness implements IAcademicBusiness {

	private IEtablissementDAO etablissementDAO;

	public AcademicBusiness(IEtablissementDAO etablissementDAO) {
		this.etablissementDAO = etablissementDAO;
	}

	@Override
	public List<EtablissementDTO> listAllEtablissement() {
		return etablissementDAO.listAllEtablissement();
	}	

	@Override
	public void creerEtablissement(EtablissementDTO etablissement) {
		this.etablissementDAO.creerEtablissement(etablissement);		
	}

	@Override
	public void supprimerEtablissement(EtablissementDTO etablissement) {
		this.etablissementDAO.supprimerEtablissement(etablissement);		
	}

	@Override
	public void modifierEtablissement(EtablissementDTO etablissement) {
		this.etablissementDAO.modifierEtablissement(etablissement);		
	}

	@Override
	public EtablissementDTO getEtablissement(Integer id) {
		return this.etablissementDAO.getEtablissement(id);	
	}

}

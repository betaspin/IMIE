/**
 * 
 */
package fr.imie.application;

import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public interface IApplication {
	public void start();
	public void listAllEtablissement();
	public void creerEtablissement();
	public void supprimerEtablissement();
	public void modifierEtablissement();
	public EtablissementDTO getEtablissement(Integer id);
}

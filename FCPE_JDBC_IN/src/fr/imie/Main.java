package fr.imie;

import fr.imie.application.Application;
import fr.imie.application.IApplication;
import fr.imie.business.AcademicBusiness;
import fr.imie.business.IAcademicBusiness;
import fr.imie.persistence.ConnexionManagement;
import fr.imie.persistence.EtablissementDAO;
import fr.imie.persistence.IConnexionManagement;
import fr.imie.persistence.IEtablissementDAO;

/**
 * @author imiedev
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IConnexionManagement connexionManagement = new ConnexionManagement();
		IEtablissementDAO etablissementDAO = new EtablissementDAO(connexionManagement);
		IAcademicBusiness academicBusiness = new AcademicBusiness(etablissementDAO);
		IApplication application = new Application(academicBusiness);
		
		application.start();
	}

}

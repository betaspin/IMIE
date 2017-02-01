package fr.imie;

import java.util.Scanner;

import fr.imie.business.AcademicBusiness;
import fr.imie.business.IAcademicBusiness;
import fr.imie.model.AdresseDTO;
import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IAcademicBusiness academicBusiness = new AcademicBusiness();
		String inputString;
		do {
			
			System.out.format("----------------\n");

			for (EtablissementDTO etablissementDTO : academicBusiness.listAllEtablissement()) {
				System.out.format("id:%s | nom:%s | adresse:%s\n",etablissementDTO.getId(), etablissementDTO.getNom(),
						etablissementDTO.getAdresse().getMergedAdress());
			}

			Scanner scanner = new Scanner(System.in);

			EtablissementDTO etablissementDTO = new EtablissementDTO();
			AdresseDTO adresseDTO = new AdresseDTO();
			etablissementDTO.setAdresse(adresseDTO);
			System.out.format("création d'un Etablissement\n");
			
			System.out.format("Nom:\n");
			inputString = scanner.nextLine();
			etablissementDTO.setNom(inputString);
			System.out.format("Numero de la rue:\n");
			inputString = scanner.nextLine();
			adresseDTO.setNumero(Integer.parseInt(inputString));
			System.out.format("Nom de la voie:\n");
			inputString = scanner.nextLine();
			adresseDTO.setNomVoie(inputString);
			System.out.format("Code Postal:\n");
			inputString = scanner.nextLine();
			adresseDTO.setCP(inputString);
			System.out.format("Ville:\n");
			inputString = scanner.nextLine();
			adresseDTO.setVille(inputString);
			EtablissementDTO newEtablissementDTO = academicBusiness.createEtablissement(etablissementDTO);
			System.out.format("id:%s | nom:%s | adresse:%s\n",newEtablissementDTO.getId(), newEtablissementDTO.getNom(),
					newEtablissementDTO.getAdresse().getMergedAdress());
			System.out.format("Voulez vous continuer? O/N \n");
			inputString = scanner.nextLine();
			
			
		} while (inputString.equals("O"));

	}

}

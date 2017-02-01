/**
 * 
 */
package fr.imie.application;

import java.util.Scanner;

import fr.imie.business.IAcademicBusiness;
import fr.imie.model.AdresseDTO;
import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public class Application implements IApplication {
	private IAcademicBusiness academicBusiness;	
	
	public Application(IAcademicBusiness academicBusiness) {
		this.academicBusiness = academicBusiness;
	}
	
	@Override
	public void start() {
		
		String response ="";
		
		Scanner sc = new Scanner(System.in);
		
		do{			
			System.out.println("Quelle action souhaitez-vous faire ?");
			System.out.println("1 - Lister les établissement");
			System.out.println("2 - Ajouter un établissement");
			System.out.println("3 - Supprimer un établissement");
			System.out.println("4 - Modifier un établissement");
			System.out.println("X - Sortir\n");
			
			response = sc.nextLine();
			if (response.equals("X")){
				break;
			}
			
			switch (response) {
				case "1":
					this.listAllEtablissement();
					break;
				case "2":
					this.creerEtablissement();
					break;
				case "3":
					this.supprimerEtablissement();
					break;
				case "4":
					this.modifierEtablissement();
					break;
				default:
					break;
			}
			
		}while(true);
		
		sc.close();
	}
	
	@Override
	public void listAllEtablissement() {
		for (EtablissementDTO etablissementDTO : academicBusiness.listAllEtablissement()) {
			System.out.format("%d:%s\n", etablissementDTO.getId(), etablissementDTO.getNom());
			System.out.format("adresse:%s\n", etablissementDTO.getAdresse().getMergedAdress());
		}		
	}

	@Override
	public void creerEtablissement(){
		Scanner sc = new Scanner(System.in);
		EtablissementDTO etablissement = new EtablissementDTO();
		
		System.out.println("Nom de l'établissement :");
		etablissement.setNom(sc.nextLine());
		
		AdresseDTO adresse = new AdresseDTO();
		System.out.println("Numéro de la voie :");
		adresse.setNumero(Integer.parseInt(sc.nextLine()));
		System.out.println("Nom de la voie :");
		adresse.setNomVoie(sc.nextLine());
		System.out.println("Code postal :");
		adresse.setCP(sc.nextLine());
		System.out.println("Ville :");
		adresse.setVille(sc.nextLine());
		etablissement.setAdresse(adresse);
		
		sc.close();
		
		this.academicBusiness.creerEtablissement(etablissement);
	}
	
	@Override
	public void supprimerEtablissement(){		
		Scanner sc = new Scanner(System.in);
		EtablissementDTO etablissement = new EtablissementDTO();
		
		System.out.println("Id de l'établissement :");
		etablissement.setId(Integer.parseInt(sc.nextLine()));
		
		sc.close();
		
		this.academicBusiness.supprimerEtablissement(etablissement);
	}

	@Override
	public void modifierEtablissement() {
		Scanner sc = new Scanner(System.in);
		EtablissementDTO etablissement = new EtablissementDTO();
		AdresseDTO adresse = new AdresseDTO();
		
		System.out.println("Id de l'établissement à modifier :");
		etablissement = this.getEtablissement(Integer.parseInt(sc.nextLine()));
		adresse = etablissement.getAdresse();
		
		String response ="";
		
		do{			
			System.out.println("Quel champ souhaitez-vous mofifier ?");
			System.out.println("1 - Nom");
			System.out.println("2 - Numéro de la voie");
			System.out.println("3 - Nom de la voie");
			System.out.println("4 - Code postal");
			System.out.println("5 - Vlille");
			System.out.println("S - Sauvegarder\n");

			response = sc.nextLine();
			if (response.equals("S")){
				this.academicBusiness.modifierEtablissement(etablissement);
				break;
			}
			
			switch (response) {
				case "1":
					System.out.println("Entrez le nom : ");
					etablissement.setNom(sc.nextLine());
					break;
				case "2":
					System.out.println("Entrez le numéro de la voie : ");
					adresse.setNumero(Integer.parseInt(sc.nextLine()));
					break;
				case "3":
					System.out.println("Entrez le nom de la voie : ");
					adresse.setNomVoie(sc.nextLine());
					break;
				case "4":
					System.out.println("Entrez le code postal : ");
					adresse.setCP(sc.nextLine());
					break;
				case "5":
					System.out.println("Entrez la ville : ");
					adresse.setVille(sc.nextLine());
					break;
				default:
					break;
			}
		}while(true);
		
		sc.close();
	}

	@Override
	public EtablissementDTO getEtablissement(Integer id) {
		return this.academicBusiness.getEtablissement(id);		
	}
}

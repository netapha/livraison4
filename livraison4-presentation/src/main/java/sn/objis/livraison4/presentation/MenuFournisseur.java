package sn.objis.livraison4.presentation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import sn.objis.livraison4.domaine.Fournisseur;
import sn.objis.livraison4.service.IServiceFournisseurImpl;
/**
 * Cette classe represente le menu qui permet de faire des manipulations sur un fournisseur.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 18/09/2018
 */

public class MenuFournisseur {
	
	
	static boolean isOk = false;
	static String reponse;
	static char premierCaractere;
	public static Scanner sc = new Scanner(System.in);
	public static int choixFournisseur;
	static List<Fournisseur> listFournisseur = null;
	public static  IServiceFournisseurImpl serviceFournisseur = new IServiceFournisseurImpl();
	public static Fournisseur fournisseur;
	static String nomFournisseur;
	static String prenomFournisseur;
	static String adresseFournisseur;
	/**
     * Cette m�thode propose diff�rentes options pour faire des manipulations sur un fournisseur.
	 */
	public static void afficherMenuFournisseur(){
		do{
		try {
			System.out.println("Taper 1 pour ajouter un nouveau fournisseur.");
			System.out.println("Taper 2 pour modifier les informations d'un fournisseur.");
			System.out.println("Taper 3 pour lister les fournisseurs de la base de donn�es.");
			System.out.println("Taper 4 pour rechercher un fournisseur dans la base de donn�es.");
			System.out.println("Taper 5 pour supprimer un fournisseur.");
			System.out.println("Taper 6 pour quitter l'application.");                                //A GERER
			System.out.println("Veuillez faire votre choix.");
			choixFournisseur = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
			
		}
	
	switch (choixFournisseur){
	case 1:
		try {
			System.out.println("Veuillez entrer le nom du fournisseur � ajouter.");
			sc.nextLine();
			nomFournisseur = sc.nextLine();
			System.out.println("Veuillez entrer le prenom du fournisseur � ajouter.");
			prenomFournisseur = sc.nextLine();
			System.out.println("Veuillez entrer l'adresse du fournisseur � ajouter.");
			adresseFournisseur = sc.nextLine();
			fournisseur = new Fournisseur(nomFournisseur, prenomFournisseur, adresseFournisseur);
			serviceFournisseur.creer(fournisseur);
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
		}
		break;
	case 2:
		Fournisseur fournisseurAModifier;
		try {
			sc.nextLine();
			System.out.println("Entrez l'identifiant du fournisseur concern�");  
			int identifiantFournisseurAModifier = sc.nextInt();
			fournisseurAModifier = serviceFournisseur.rechercherParIdentifiant(identifiantFournisseurAModifier);
			    sc.nextLine();
				System.out.println("Entrez le nouveau nom.");
				String nouveauNom = sc.nextLine();
				System.out.println("Entrez le nouveau prenom.");
				String nouveauPrenom = sc.nextLine();
				System.out.println("Entrez la nouvelle adresse.");
				String nouvelleAdresse = sc.nextLine();
				fournisseurAModifier.setNomFournisseur(nouveauNom);
				fournisseurAModifier.setPrenomFournisseur(nouveauPrenom);
				fournisseurAModifier.setAdresseFournisseur(nouvelleAdresse);
				serviceFournisseur.modifier(fournisseurAModifier);
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
		}

			System.out.println("Les mis � jour sur le client ont �t� appliqu�s avec succ�s." );
		break;
	case 3:
		
		System.out.println("Voici la liste des fournisseurs pr�sents dans la base de donn�es.");
		System.out.println("************************************************************");	
		listFournisseur = serviceFournisseur.lister();
	    Stream <Fournisseur> s = listFournisseur.stream();
		s.forEach(System.out::println);
		break;
	case 4:
		try {
			System.out.println("Entrez l'identifiant du fournisseur que vous recherchez.");    
			//sc.nextLine();
			int identifiantFournisseurARechercher = sc.nextInt();
			serviceFournisseur.rechercherParIdentifiant(identifiantFournisseurARechercher);
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
		}
		break;
		
	case 5 : 
		try {
			sc.nextLine();
			System.out.println("Entrez l'identifiant du fournisseur � supprimer.");    
			int identifiantFournisseurASupprimer = sc.nextInt();
			Fournisseur fournisseurASupprimer = serviceFournisseur.rechercherParIdentifiant(identifiantFournisseurASupprimer);
				
			serviceFournisseur.supprimer(fournisseurASupprimer);
				System.out.println("La suppression �t� effectu�e avec succ�s." );
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
		}	
		break;
	case 6:
		System.out.println("Nous vous remercions de votre visite.");
		System.exit(0);
		break;
	default:
		System.out.println("Cette option n'est pas prise en compte.");
		break;                                                                                          
	}

	do {
		System.out.println("Voulez-vous continuer ? : o/n");
		reponse = sc.nextLine();
		if (reponse.matches("^[oOnN]+$")) {
			premierCaractere = reponse.charAt(0);
			if (premierCaractere == 'o' || premierCaractere == 'O') {
				isOk = true;
			} else {
				System.out.println("Nous vous remercions de votre visite.");
				System.exit(0);
			}
		} //else {
			//System.out.println(
					//"Le caract�re que vous avez entr� n'est pas autoris�. Veuillez r�essayer s'il vous plait.");
		//}
	}while (isOk == false);

}
while( isOk == true);
	
	}	
} 

package sn.objis.livraison4.presentation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import sn.objis.livraison4.domaine.Client;
import sn.objis.livraison4.service.IServiceClientImpl;
/**
 * Cette classe represente le menu qui permet de faire des manipulations sur un client.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 18/09/2018
 */
public class MenuClient {
	
	static boolean isOk = false;
	static String reponse;
	static char premierCaractere;
	public static Scanner sc = new Scanner(System.in);
	public static int choixClient;
	static List<Client> listClient = null;
	public static  IServiceClientImpl serviceClient = new IServiceClientImpl();
	public static Client client;
	static String nomClient;
	static String prenomClient;
	static String adresseClient;
	 static int identifiantClientAModifier;
	 static Client clientAModifier;
	/**
	 * Cette methode propose differentes options pour faire des manipulations sur un client.
	 */
	public static void afficherMenuClient(){
		do{
		try {
			System.out.println("Taper 1 pour ajouter un nouveau client.");
			System.out.println("Taper 2 pour modifier les informations d'un client.");
			System.out.println("Taper 3 pour lister les clients de la base de donn�es.");
			System.out.println("Taper 4 pour rechercher un client dans la base de donn�es.");
			System.out.println("Taper 5 pour supprimer un client.");
			System.out.println("Taper 6 pour quitter l'application.");                                
			System.out.println("Veuillez faire votre choix.");
			choixClient = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
			
		}
	
	switch (choixClient){
	case 1:
		try {
			System.out.println("Veuillez entrer le nom du client � ajouter.");
			sc.nextLine();
			nomClient = sc.nextLine();
			System.out.println("Veuillez entrer le prenom du client � ajouter.");
			prenomClient = sc.nextLine();
			System.out.println("Veuillez entrer l'adresse du client � ajouter.");
			adresseClient = sc.nextLine();
			client = new Client(nomClient,prenomClient,adresseClient);
			serviceClient.creer(client);
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
			
		}
		break;
	case 2:
		//sc.nextLine();
		
		try {
			System.out.println("Entrez l'identifiant du client concern�");  
			   identifiantClientAModifier = sc.nextInt();
			clientAModifier = serviceClient.rechercherParIdentifiant(identifiantClientAModifier);
			    sc.nextLine();
				System.out.println("Entrez le nouveau nom.");
				String nouveauNom = sc.nextLine();
				System.out.println(nouveauNom);
				System.out.println("Entrez le nouveau prenom.");
				String nouveauPrenom = sc.nextLine();
				System.out.println("Entrez la nouvelle adresse.");
				String nouvelleAdresse = sc.nextLine();
				//clientAModifier.setIdClient(identifiantClientAModifier);
				//clientAModifier.setNomClient(null);
				clientAModifier.setNomClient(nouveauNom);
				clientAModifier.setPrenomClient(nouveauPrenom);
				clientAModifier.setAdresseClient(nouvelleAdresse);
				serviceClient.modifier(clientAModifier);
				System.out.println("Les mis � jour sur le client ont �t� appliqu�s avec succ�s." );
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
		}

		
		break;
	case 3:
		
		System.out.println("Voici la liste des clients pr�sents dans la base de donn�es.");
		System.out.println("************************************************************");
		//serviceClient.lister();	
		listClient = serviceClient.lister();
	    Stream <Client> s = listClient.stream();
		s.forEach(System.out::println);
		break;
	case 4:
		try {
			System.out.println("Entrez l'identifiant du client que vous recherchez.");    
			//sc.nextLine();
			int identifiantClientARechercher = sc.nextInt();
			serviceClient.rechercherParIdentifiant(identifiantClientARechercher);
		} catch (InputMismatchException e) {
			System.out.println("Le caractere entre n'est pas autorise.");
		}
		break;
		
	case 5 : 
		sc.nextLine();
		try {
			System.out.println("Entrez l'identifiant du client � supprimer.");    
			int identifiantClientASupprimer = sc.nextInt();
			Client clientASupprimer = serviceClient.rechercherParIdentifiant(identifiantClientASupprimer);
				
				serviceClient.supprimer(clientASupprimer);
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

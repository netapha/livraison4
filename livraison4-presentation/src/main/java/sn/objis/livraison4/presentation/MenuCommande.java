package sn.objis.livraison4.presentation;
import sn.objis.livraison4.presentation.Main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import sn.objis.livraison4.domaine.Commande;
import sn.objis.livraison4.service.IServiceCommandeImpl;
/**
 * Cette classe repr�sente le menu qui permet de faire des manipulations sur une commande.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 18/09/2018
 */
public class MenuCommande {
	static boolean isOk = false;
	static String reponse;
	static char premierCaractere;
	public static Scanner sc = new Scanner(System.in);
	public static int choixCommande;
	static List<Commande> listCommande = null;
	public static  IServiceCommandeImpl serviceCommande = new IServiceCommandeImpl();
    static Commande commande;
	static String statutCommande;
	//static Date dateCommande;

	/**
	 * Cette m�thode propose diff�rentes options pour faire des manipulations sur une commande.
	 */
	
	
		public static void afficherMenuCommande(){			
			do{
				
			try {
				System.out.println("Taper 1 pour ajouter une nouvelle commande.");
				System.out.println("Taper 2 pour modifier les informations d'une commande.");
				System.out.println("Taper 3 pour lister les commandes de la base de donn�es.");
				System.out.println("Taper 4 pour rechercher une commande dans la base de donn�es.");
				System.out.println("Taper 5 pour supprimer une commande.");
				System.out.println("Taper 6 pour quitter l'application.");                                
				System.out.println("Veuillez faire votre choix.");
				choixCommande = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Le caract�re entr� n'est pas autoris�.");
			}
		
		switch (choixCommande){
		case 1:
			try {
				System.out.println("Veuillez entrer le statut de la commande: Livr�e / En cours");
				sc.nextLine();
				statutCommande = sc.nextLine();
				commande = new Commande(statutCommande, new java.sql.Date(System.currentTimeMillis()));
				serviceCommande.creer(commande);
			} catch (InputMismatchException e) {
				System.out.println("Le caract�re entr� n'est pas autoris�.");
			}
			break;
		case 2:
			sc.nextLine();
			try {
				System.out.println("Entrez l'identifiant de la commande concern�e");  
				int identifiantCommandeAModifier = sc.nextInt();
				Commande commandeAModifier = serviceCommande.rechercherParIdentifiant(identifiantCommandeAModifier);
				    sc.nextLine();
					System.out.println("Entrez le nouveau statut.");
					String nouveauStatut = sc.nextLine();
					commandeAModifier.setStatutCommande(nouveauStatut);
					//commandeAModifier.setDateCommande(nouvelleDate);
					serviceCommande.modifier(commandeAModifier);
					System.out.println("Les mis � jour sur la commande ont �t� appliqu�s avec succ�s." );
			} catch (InputMismatchException e) {
				System.out.println("Le caract�re entr� n'est pas autoris�.");
			}
			break;
		case 3:
			
			System.out.println("Voici la liste des commandes de la base de donn�es.");
			System.out.println("************************************************************");	
			listCommande = serviceCommande.lister();
		    Stream <Commande> s = listCommande.stream();
			s.forEach(System.out::println);
			break;
		case 4:
			try {
				System.out.println("Entrez l'identifiant de la commande que vous recherchez.");    
				//sc.nextLine();
				int identifiantCommandeARechercher = sc.nextInt();
				serviceCommande.rechercherParIdentifiant(identifiantCommandeARechercher);
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 5 : 
			try {
				sc.nextLine();
				System.out.println("Entrez l'identifiant de la commande � supprimer.");    
				int identifiantCommandeASupprimer = sc.nextInt();
				Commande commandeASupprimer = serviceCommande.rechercherParIdentifiant(identifiantCommandeASupprimer);
					
				serviceCommande.supprimer(commandeASupprimer);
					System.out.println("La suppression a �t� effectu�e avec succ�s." );
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

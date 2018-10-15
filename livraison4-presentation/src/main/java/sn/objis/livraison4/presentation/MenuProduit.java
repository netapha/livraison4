package sn.objis.livraison4.presentation;
import java.util.InputMismatchException;
/**
 * Cette classe repr�sente le menu qui permet de faire des manipulations sur un produit.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 18/09/2018
 */
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import sn.objis.livraison4.domaine.Produit;
import sn.objis.livraison4.service.IServiceProduitImpl;

public class MenuProduit {

	static boolean isOk = false;
	static String reponse;
	static char premierCaractere;
	public static Scanner sc = new Scanner(System.in);
	public static int choixProduit;
	static List<Produit> listProduit = null;
	public static  IServiceProduitImpl serviceProduit = new IServiceProduitImpl();
	public static Produit produit;
	static String nomProduit;
	static int stockProduit;
	static float prixDachatProduit;
	static float prixDeVenteProduit;
	/**
	 * Cette m�thode propose diff�rentes options pour faire des manipulations sur un produit.
	 */
	public static void afficherMenuProduit() {
		do{
			
		 try {
			 
		System.out.println("Taper 1 pour ajouter un nouveau produit.");
		System.out.println("Taper 2 pour modifier les informations d'un produit.");
		System.out.println("Taper 3 pour lister les produits de la base de donn�es.");
		System.out.println("Taper 4 pour rechercher un produit dans la base de donn�es.");
		System.out.println("Taper 5 pour supprimer un produit.");
		System.out.println("Taper 6 pour quitter l'application");                                                     
		System.out.println("Veuillez faire votre choix.");
			choixProduit = sc.nextInt();
			 	
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
		}
			
	switch (choixProduit){
	case 1:
		try{
		System.out.println("Veuillez entrer le nom du produit � ajouter.");
		sc.nextLine();
		nomProduit = sc.nextLine();
		System.out.println("Veuillez entrer la quantit� de stock du produit � ajouter.");
		stockProduit = sc.nextInt();
		System.out.println("Veuillez entrer le prix d'achat du produit � ajouter.");
		prixDachatProduit = sc.nextFloat();
		System.out.println("Veuillez entrer le prix de vente du produit � ajouter.");
		prixDeVenteProduit = sc.nextFloat();
		} catch (InputMismatchException e) {
			System.out.println("La valeur  entr�e n'est pas autoris�e.");
		}
		produit = new Produit(nomProduit, stockProduit, prixDachatProduit, prixDeVenteProduit);
	    serviceProduit.creer(produit);
	    System.out.println("Le nouveau produit a �t� ajout� avec succ�s dans la base de donn�es.");
		break;
	case 2:
		sc.nextLine();
		try{
		System.out.println("Entrez l'identifiant du produit concern�");  
	    int identifiantProduitAModifier = sc.nextInt();
	    Produit produitAModifier = serviceProduit.rechercherParIdentifiant(identifiantProduitAModifier);
	    sc.nextLine();
		System.out.println("Entrez le nouveau nom.");
		String nouveauNom = sc.nextLine();
		System.out.println("Entrez la nouvelle quantit� de stock.");
		int nouveauStock = sc.nextInt();
		System.out.println("Entrez le nouveau prix d'achat.");
		float nouveauPrixDachat = sc.nextFloat();
		System.out.println("Entrez le nouveau prix de vente.");
		float nouveauPrixDeVente = sc.nextFloat();
		produitAModifier.setNomProduit(nouveauNom);
		produitAModifier.setStockProduit(nouveauStock);
		produitAModifier.setPrixDachat(nouveauPrixDachat);
		produitAModifier.setPrixDeVente(nouveauPrixDeVente);
		serviceProduit.modifier(produitAModifier);
		
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� n'est pas autoris�.");
		}
			System.out.println("Les mis � jour sur le produit ont �t� appliqu�s avec succ�s.");	

		

		break;
	case 3:
		
		System.out.println("Voici la liste des produits pr�sents dans la base de donn�es.");
		System.out.println("************************************************************");	
		listProduit = serviceProduit.lister();
	    Stream <Produit> s = listProduit.stream();
		s.forEach(System.out::println);
		break;
	case 4:
		try {
			System.out.println("Entrez l'identifiant du produit que vous recherchez.");    
			//sc.nextLine();
			int identifiantProduitARechercher = sc.nextInt();
			serviceProduit.rechercherParIdentifiant(identifiantProduitARechercher);
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� est invalide.");
		}
		break;
		
	case 5 : 
		try {
			sc.nextLine();
			System.out.println("Entrez l'identifiant du produit � supprimer.");    
			int identifiantProduitASupprimer = sc.nextInt();
			Produit produitASupprimer = serviceProduit.rechercherParIdentifiant(identifiantProduitASupprimer);
				
			serviceProduit.supprimer(produitASupprimer);
				System.out.println("La suppression a �t� effectu�e avec succ�s." );
		} catch (InputMismatchException e) {
			System.out.println("Le caract�re entr� est invalide.");
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

package sn.objis.livraison4.presentation;

import java.util.Scanner;
/**
 * Cette classe repr�sente la classe principale de l'application.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 18/09/2018
 */
public class Main {
	/**
	 * Cette m�thode repr�sente le point d'entr�e de l'application.
	 * @param args: type String, repr�sente l'argument � renseigner au moment de l'execution.
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choix = 0;
		
		System.out.println("Taper 1 si vous souhaitez effectuer des manipulations sur une commande.");
		System.out.println("Taper 2 si vous souhaitez effectuer des manipulations sur un client.");
		System.out.println("Taper 3 si vous souhaitez effectuer des manipulations sur un fournisseur.");	
		System.out.println("Taper 4 si vous souhaitez effectuer des manipulations sur un produit.");
		System.out.println("Taper 5 si vous souhaitez quitter l'application.");	
		choix = sc.nextInt();
		switch(choix){
		case 1 : 
			MenuCommande.afficherMenuCommande();
			break;
			
		case 2 : 
			MenuClient.afficherMenuClient();
			break;
			
		case 3 : 
			MenuFournisseur.afficherMenuFournisseur();
			break;
		case 4:
			MenuProduit.afficherMenuProduit();
			break;
			
		case 5 : 
			System.out.println("Nous vous remercions de votre visite.");
			System.exit(0);
			break;
		}
		

	}

}

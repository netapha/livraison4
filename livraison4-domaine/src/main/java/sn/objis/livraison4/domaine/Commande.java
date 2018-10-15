package sn.objis.livraison4.domaine;

import java.util.Date;

/**
 * Cette classe permet de representer une commande.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 26/09/2018
 */
public class Commande {

	private int idCommande;
	private String statutCommande;
	private Date dateCommande;

	/**
	 * Constructeur sans parametre
	 */
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Constructeur avec tous les parametres
	 * 
	 * @param idCommande
	 *            : type int, represente l'identifiant d'une commande.
	 * @param statutCommande
	 *            : type String, represente le statut d'une commande (livree ou
	 *            en cours de livraison.
	 * @param dateCommande
	 *            : type Date, represente la date de validation d'une commande.
	 */

	public Commande(int idCommande, String statutCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.statutCommande = statutCommande;
		this.dateCommande = dateCommande;
	}
	

	/**
	 * Constructeur avec tous les parametres sauf l'identifiant de la commande
	 * 
	 * @param statutCommande : type String, represente le statut d'une commande (livree ou en cours de livraison).
	 * @param dateCommande : type Date, represente la date de validation d'une commande.
	 */
	

public Commande(String statutCommande, Date dateCommande) {
	super();
	this.statutCommande = statutCommande;
	this.dateCommande = dateCommande;
}
	
/**
 * Constructeur avec le parametre statut commande.
 * @param statutCommande : type String, represente le statut d'une commande (livree ou en cours de livraison).
 */


	public Commande(String statutCommande) {
		this.statutCommande = statutCommande;
	}

/**
 * Constructeur avec duex parametres : idCommande et statutCommande
 * @param idCommande
 *            : type int, represente l'identifiant d'une commande.
 * @param statutCommande : type String, represente le statut d'une commande (livree ou en cours de livraison).
 */
	private Commande(int idCommande, String statutCommande) {
		super();
		this.idCommande = idCommande;
		this.statutCommande = statutCommande;
	}


	/**
     * Red�finition de la methode toString, permet l'affichage d'une commande.
	 */
	@Override
	public String toString() {
		return "******************************\nIdentifiant Commande : " + idCommande  + "\nStatut Commande : " + statutCommande
				+ "\nDate Commande : " + dateCommande+"\n**********************************";
	}

	/**
	 * Getters et Setters
	 * 
	 */
	public int getIdCommande() {
		return idCommande;
	}


	public String getStatutCommande() {
		return statutCommande;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}


	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

}
	

	
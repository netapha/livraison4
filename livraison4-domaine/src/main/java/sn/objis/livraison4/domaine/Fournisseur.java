package sn.objis.livraison4.domaine;

/**
 * Cette classe permet de representer un fournisseur.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 26/09/2018
 */

public class Fournisseur {

	private int idFournisseur;
	private String nomFournisseur;
	private String prenomFournisseur;
	private String adresseFournisseur;

	/**
	 * Constructeur sans parametre.
	 */
	public Fournisseur() {
		super();
	}

	/**
	 * Constructeur avec tous les parametres.
	 * 
	 * @param idFournisseur : type int, represente l'identifiant du fournisseur.
	 * @param nomFournisseur : type String, represente le nom du fournisseur.
	 * @param prenomFournisseur : type String, represente le prenom du fournisseur.
	 * @param adresseFournisseur : type String, represente l'adresse du fournisseur.
	 */
	public Fournisseur(int idFournisseur, String nomFournisseur, String prenomFournisseur, String adresseFournisseur) {
		super();
		this.idFournisseur = idFournisseur;
		this.nomFournisseur = nomFournisseur;
		this.prenomFournisseur = prenomFournisseur;
		this.adresseFournisseur = adresseFournisseur;
	}

	/**
	 * Constructeur avec tous les parametres sauf l'identifiant du fournisseur
	 * 
	 * @param nomFournisseur : type String, represente le nom du fournisseur.
	 * @param prenomFournisseur : type String, represente le prenom du fournisseur.
	 * @param adresseFournisseur : type String, represente l'adresse du fournisseur.
	 */
	public Fournisseur(String nomFournisseur, String prenomFournisseur, String adresseFournisseur) {
		super();
		this.nomFournisseur = nomFournisseur;
		this.prenomFournisseur = prenomFournisseur;
		this.adresseFournisseur = adresseFournisseur;
	}

	/**
	 * Getters et Setters
	 * 
	 */
	public int getIdFournisseur() {
		return idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public String getPrenomFournisseur() {
		return prenomFournisseur;
	}

	public String getAdresseFournisseur() {
		return adresseFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public void setPrenomFournisseur(String prenomFournisseur) {
		this.prenomFournisseur = prenomFournisseur;
	}

	public void setAdresseFournisseur(String adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}

	/**
     * Red�finition de la m�thode toString, permet l'affichage d'un fournisseur.
	 */
	@Override
	public String toString() {	
		
		return 	"*******************************\nNom : " + nomFournisseur+"\n"+ "Prenom : " + prenomFournisseur +"\n"+ "Adresse : " + adresseFournisseur+"\n*******************************";
		
	}

}

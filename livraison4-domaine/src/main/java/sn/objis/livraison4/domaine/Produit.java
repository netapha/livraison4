package sn.objis.livraison4.domaine;

/**
 * Cette classe permet de representer un produit.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 27/09/2018
 */
public class Produit {

	private int idProduit;
	private String nomProduit;
	private int stockProduit;
	private float prixDachat;
	private float prixDeVente;
	/**
	 * Constructeur sans parametre.
	 */
	public Produit() {
		super();
	}
	/**
	 * Constructeur avec tous les parametres.
	 * @param idProduit : type int, represente l'identifiant du produit.
	 * @param nomProduit : type String, represente le nom du produit.
	 * @param stockProduit : type int, represente la quantite de stock du produit.
	 * @param prixDachat : type float, represente le prix d'achat du produit.
	 * @param prixDeVente : type float, represente le prix de vente du produit.
	 */
	
	public Produit(int idProduit, String nomProduit, int stockProduit, float prixDachat, float prixDeVente) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.stockProduit = stockProduit;
		this.prixDachat = prixDachat;
		this.prixDeVente = prixDeVente;
	}
	/**
	 * Constructedur avec tous les parametres sauf l'identifiant du produit.
	 * @param nomProduit : type String, represente le nom du produit.
	 * @param stockProduit : type int, represente la quantite de stock du produit.
	 * @param prixDachat : type float, represente le prix d'achat du produit.
	 * @param prixDeVente : type float, represente le prix de vente du produit.
	 */
	public Produit(String nomProduit, int stockProduit, float prixDachat, float prixDeVente) {
		super();
		this.nomProduit = nomProduit;
		this.stockProduit = stockProduit;
		this.prixDachat = prixDachat;
		this.prixDeVente = prixDeVente;
	}
	/**
	 * Getters et setters
	 */
	public int getIdProduit() {
		return idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public int getStockProduit() {
		return stockProduit;
	}
	public float getPrixDachat() {
		return prixDachat;
	}
	public float getPrixDeVente() {
		return prixDeVente;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public void setStockProduit(int stockProduit) {
		this.stockProduit = stockProduit;
	}
	public void setPrixDachat(float prixDachat) {
		this.prixDachat = prixDachat;
	}
	public void setPrixDeVente(float prixDeVente) {
		this.prixDeVente = prixDeVente;
	}
	
	/**
	 * Redefinition de la methode toString, permet l'affichage d'un produit.
	 */
	@Override
	public String toString() {
		return "****************************************\nNom Produit : " + nomProduit + "\nStock Produit : " + stockProduit
				+ "\nPrix Dachat : " + prixDachat + "\nPrix De Vente : " + prixDeVente+"\n****************************************";
	}
	
	

}

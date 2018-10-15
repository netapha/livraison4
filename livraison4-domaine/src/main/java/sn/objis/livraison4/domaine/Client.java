package sn.objis.livraison4.domaine;

/**
 * Cette classe permet de representer un client.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 26/09/2018
 */
public class Client {
	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;

	/**
	 * Constructeur sans parametre
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur avec tous les parametres
	 * 
	 * @param idClient : type int, represente l'identifiant du client.
	 * @param nomClient : type String, represente le nom du client.
	 * @param prenomClient : type String, represente le prenom du client.
	 * @param adresseClient : type String, represente l'adresse du client.
	 */

	public Client(int idClient, String nomClient, String prenomClient, String adresseClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
	}

	/**
	 * Constructeur avec tous les parametres sans l'identifiant du client
	 * 
	 * @param nomClient : type String, represente le nom du client.
	 * @param prenomClient : type String, represente le prenom du client.
	 * @param adresseClient : type String, represente l'adresse du client.
	 */

	public Client(String nomClient, String prenomClient, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
	}

	/**
	 * Getters et Setters
	 * 
	 */
	public int getIdClient() {
		return idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	/**
     * Redefinition de la methode toString, permet l'affichage d'un client.
	 */
	@Override
	public String toString() {
		return "*******************************\nnomClient : " + nomClient+"\n"+ "prenomClient : " + prenomClient +"\n"+ "adresseClient : " + adresseClient+"\n*******************************";
	}

}

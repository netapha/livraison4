package sn.objis.livraison4.dao;
/**
 * Cette classe permet d'implementer les methodes metiers qui concernent l'objet Client.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 18/09/2018
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.livraison4.domaine.Client;
import sn.objis.livraison4.utils.MysqlConnection;


public class IDaoClientImpl implements IDaoClient {
	Connection connection = MysqlConnection.connexionALaBase();
	/**
	 * Redefinition de la methode create qui permet d'ajouter un nouveau client dans la base de donnees. 
	 * @param 
	 *      c: type Client, represente le nouveau client a ajouter dans la base de donnees. 
	 */
	
	@Override
	public void create(Client c) {
		String sql = "INSERT INTO client(nom_client,prenom_client,adresse_client) VALUES(?,?,?)";
		try {
			// Etape 1 : cr�ation d'une zone de requete
			PreparedStatement ps = connection.prepareStatement(sql);
			// Etape 2 : r�cup�ration des valeurs
			ps.setString(1,c.getNomClient());
			ps.setString(2,c.getPrenomClient());
			ps.setString(3,c.getAdresseClient());
			//Execution de la requete
			ps.executeUpdate();
			System.out.println("Ajout d'un nouveau client r�ussi.");
		} catch (SQLException e) {
			System.out.println("Erreur dans la requete.");
			e.printStackTrace();
		}

	}

	/**
	 * Redefinition de la methode read qui permet de lister les clients de la base de donnees. 
	 * 
	 */
	@Override
	public List<Client> read() {
		List<Client> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM client";
			// Etape 1 : cr�ation d'une zone de requete
			Statement st = connection.createStatement();
			//Execution de la requete
			ResultSet resultSet = st.executeQuery(sql);
			//Traitement du r�sultat de la requete
			
			while(resultSet.next()){
				Client client = new Client();
				client.setNomClient(resultSet.getString("nom_client"));
				client.setPrenomClient(resultSet.getString("prenom_client"));
				client.setAdresseClient(resultSet.getString("adresse_client"));
				list.add(client);
			}
			//System.out.println("Voici la liste des clients de la base");
			//System.out.println("\n");
		} catch (SQLException e) {
			System.out.println("Erreur dans la requete.");
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * Redefinition de la methode update qui permet de mettre a jour les informations d'un client de la base de donnees. 
	 * @param 
	 *      c: type Client, represente le client sur lequel des modiications doivent etre apportees. 
	 */
	@Override
	public void update(Client c) {
		try {
			// Etape 1 : cr�ation d'une zone de requete
			String sql = "UPDATE client SET nom_client=?, prenom_client=?, adresse_client=?" + " WHERE id_client=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			//R�cup�ration des valeurs
			ps.setString(1,c.getNomClient() );
			ps.setString(2,c.getPrenomClient() );
			ps.setString(3,c.getAdresseClient() );
			ps.setInt(4,c.getIdClient() );
			//Execution de la requete
			ps.executeUpdate();
			System.out.println("Les modifications ont �t� prises en compte avec succ�s.");
			
		} catch (SQLException e) {
			System.out.println("Erreur dans la requete.");
			e.printStackTrace();
		}

	}

	
	/**
	 * Redefinition de la methode delete qui permet de supprimer un client de la base de donnees. 
	 * @param 
	 *      c: type Client, represente le client a supprimer de la base de donnees. 
	 */
	@Override
	public void delete(Client c) {
		
		try {
			// Cr�ation de la zone de requete
			String sql = "DELETE FROM client WHERE id_client=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			//R�cup�ration de la valeur
			ps.setInt(1, c.getIdClient());
			
			
			//Execution de la requete
			ps.executeUpdate();
			System.out.println("Votre demande de suppression a bien �t� prise en compte.");
			
		} catch (SQLException e) {
			System.out.println("Erreur dans la requete.");
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * Redefinition de la methode findById qui permet de rechercher un client a partir de son numero d'identification. 
	 * @param 
	 *      idClient: type int, represente l'identifiant du client a rechercher dans la base de donnees.  
	 */

	@Override
	public Client findById(int idClient) {
		Client c = null;
		

			try {
				// �tape 1:cr�ation de la zone de requ�te
				String sql = "Select * From client where id_client=?";
				
				PreparedStatement ps = connection.prepareStatement(sql);

				// etape 3:transmission des valeurs
				ps.setInt(1,idClient);

				// �tape 4: execution de la requ�te
				ResultSet rs = ps.executeQuery();
				// etape 5: traitement des donn�es du resultat
				while (rs.next()) {
					int idRecup = rs.getInt("id_client");
					String nomRecup = rs.getString("nom_client");
					String prenomRecup = rs.getString("prenom_client");
					String adresseRecup = rs.getString("adresse_client");
					c = new Client(idRecup, nomRecup, prenomRecup, adresseRecup);

				}
				if(c != null) {
					System.out.println("Voici le client correspondant à l'identifiant que vous avez entré : \n"+ c);
				}else if(c == null){
					System.out.println("Ce client n'existe pas dans la base.");
				}
			} catch (SQLException e) {
				System.out.println("Erreur dans la syntaxe.");
				e.printStackTrace();
			}
		return c;
	
	}
}


package sn.objis.livraison4.dao;
/**
 * Cette classe permet d'implementer les methodes metiers qui concernent l'objet Commande.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 18/09/2018
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import sn.objis.gestionboutiqueenlignelivrable3.domaine.Client;

import sn.objis.livraison4.domaine.Commande;
import sn.objis.livraison4.utils.MysqlConnection;

public class IDaoCommandeImpl implements IDaoCommande {
//Client client = new Client();                              
Connection connection = MysqlConnection.connexionALaBase();


/**
 * Redefinition de la methode create qui permet d'ajouter une nouvelle commande dans la base de donnees. 
 * @param 
 *      c: type Commande, represente la nouvelle commande a ajouter dans la base de donnees. 
 */
	@Override
	public void create(Commande c) {
		try {
			//Cr�ation de la zone de requete
			String sql = "INSERT INTO commande(statut_commande, date_commande)" + "VALUES(?,?)";	
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			// R�up�ration des valeurs
			ps.setString(1, c.getStatutCommande());
			//ps.setDate(2,(Date) c.getDateCommande());
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			
			
			//Execution de la requete
			ps.executeUpdate();
			System.out.println("Ajout d'une nouvelle commande r�ussi.");
			
			
		} catch (SQLException e) {
			System.out.println("Erreur dans la requete.");
			e.printStackTrace();
		}

	}

	
	/**
	 * Redefinition de la methode read qui permet de lister les commandes de la base de donnees. 
	 * 
	 * 
	 */
	@Override
	public List<Commande> read() {
		List<Commande> list = new ArrayList<>();
		try {
			//Cr�ation de la zone de requete
			String sql = "SELECT * FROM commande";
			Statement st = connection.createStatement();
			
			//Traitement du r�sultat
			ResultSet resultSet = st.executeQuery(sql);
			
			//R�cup�ration du r�sultat
			while(resultSet.next()){
				Date dat = new java.sql.Date(System.currentTimeMillis());
				Commande commande = new Commande();
				commande.setStatutCommande(resultSet.getString("statut_commande"));
				commande.setDateCommande(dat);
				//commande.setDateCommande(resultSet.getDate("date_commande"));
				list.add(commande);
			}
			//System.out.println("Voici la liste des commandes de la base de donn�es:");
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe");
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	/**
	 * Redefinition de la methode update qui permet de mettre a jour les informations d'une commande de la base de donnees. 
	 * @param 
	 *      c: type Commande, represente la commande sur laquelle des modiications doivent etre apportees. 
	 */
	@Override
	public void update(Commande c) {
		try {
			String sql = "UPDATE commande SET statut_commande = ? " + "WHERE id_commande = ?";
			
			//Cr�ation de la zone de requete
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			//R�cup�ration des valeurs
			ps.setString(1, c.getStatutCommande());
			ps.setInt(2, c.getIdCommande());
			
			// Execution de la requete
			ps.executeUpdate();
			System.out.println("Les modifications ont �t� prises en compte avec succ�s.");
			
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}

	}

	
	
	/**
	 * Redefinition de la methode delete qui permet de supprimer une commande de la base de donnees. 
	 * @param 
	 *      c: type Commande, represente la commande a supprimer de la base de donnees.  
	 */
	@Override
	public void delete(Commande c) {
		try {
			//Cr�ation de la zone de requete
			String sql = "DELETE FROM commande WHERE id_commande = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			//R�cup�ration de la valeur
			ps.setInt(1, c.getIdCommande());
			
			//Execution de la requete
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}

	}

	/**
	 * Redefinition de la methode findById qui permet de rechercher une commande. 
	 * @param 
	 *      idCommande: type int, represente l'identifiant de la commande a rechercher dans la base de donnees.  
	 */
	@Override
	public Commande findById(int idCommande) {
		Commande c = null;
		
		try {
			// �tape 1:cr�ation de la zone de requ�te
			String sql = "Select * From commande where id_commande=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			// etape 2:transmission des valeurs
			ps.setInt(1, idCommande);

			// �tape 3: execution de la requ�te
			ResultSet rs = ps.executeQuery();
			// etape 4: traitement des donn�es du resultat
			while (rs.next()) {
				int idRecup = rs.getInt("id_commande");
				String statutRecup = rs.getString("statut_commande");
				c = new Commande(statutRecup);

			}
			if(c != null) {
				System.out.println("Voici la commande que vous cherchez : "+ c);
			}else{
				System.out.println("Cette commande n'existe pas dans la base de donn�es.");
			}
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}
		return c;
	}

}

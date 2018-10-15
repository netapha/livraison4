package sn.objis.livraison4.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Cette classe permet d'implementer les methodes metiers qui concernent l'objet Fournisseur.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 24/09/2018
 */
import java.util.List;

import sn.objis.livraison4.domaine.Fournisseur;
import sn.objis.livraison4.utils.MysqlConnection;

public class IDaoFournisseurImpl implements IDaoFournisseur {
	Fournisseur fournisseur = new Fournisseur();
	Connection connection = MysqlConnection.connexionALaBase();
	
	/**
	 * Redefinition de la methode create qui permet d'ajouter un nouveau fournisseur dans la base de donnees. 
	 * @param 
     *      f: type Fournisseur, represente le nouveau fournisseur a ajouter dans la base de donnees. 
	 */

	@Override
	public void create(Fournisseur f) {
	try {
		//Cr�ation de la zone de requete
		String sql = "INSERT INTO founisseur(nom_fournisseur,prenom_fournisseur,adresse_fournisseur)" + "VALUES(?,?,?)";	
		PreparedStatement ps = connection.prepareStatement(sql);
		
		
		// R�up�ration des valeurs
		ps.setString(1, f.getNomFournisseur());
		ps.setString(2, f.getPrenomFournisseur());
		ps.setString(3, f.getAdresseFournisseur());
		
		
		//Execution de la requete
		ps.executeUpdate();
		System.out.println("Ajout d'un nouveau fournisseur reussi.");
		
		
	} catch (SQLException e) {
		System.out.println("Erreur dans la requete.");
		e.printStackTrace();
	}
	}

	
	
	/**
	 * Redefinition de la methode read qui permet de lister les fournisseurs de la base de donnees. 
	 * 
	 */
	@Override
	public List<Fournisseur> read() {
		List<Fournisseur> list = new ArrayList<>();
		try {
			//Cr�ation de la zone de requete
			String sql = "SELECT * FROM founisseur";
			Statement st = connection.createStatement();
			
			//Traitement du r�sultat
			ResultSet resultSet = st.executeQuery(sql);
			
			//R�cup�ration du r�sultat
			while(resultSet.next()){
				fournisseur.setNomFournisseur(resultSet.getString("nom_fournisseur"));
				fournisseur.setPrenomFournisseur(resultSet.getString("prenom_fournisseur"));
				fournisseur.setAdresseFournisseur(resultSet.getString("adresse_fournisseur"));
				list.add(fournisseur);
			}
			System.out.println("Voici la liste des fournisseurs de la base de donnees:");
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe");
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	/**
	 * Redefinition de la methode update qui permet de mettre a jour les informations d'un fournisseur de la base de donnees. 
	 * @param 
	 *      f: type Fournisseur, represente le fournisseur sur lequel des modiications doivent etre apportees. 
	 */
	@Override
	public void update(Fournisseur f) {
		try {
			// Cr�ation de la zone de requete
			String sql = "UPDATE founisseur SET nom_fournisseur = ?, prenom_fournisseur = ?, adresse_fournisseur = ? WHERE id_fournisseur = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			// R�cup�ration des valeurs
			ps.setString(1, f.getNomFournisseur());
			ps.setString(2, f.getPrenomFournisseur());
			ps.setString(3, f.getAdresseFournisseur());
			ps.setInt(4, f.getIdFournisseur());
			
			//Execution de la requete
			ps.executeUpdate();
			System.out.println("Les modifications ont ete prises en compte avec succes.");
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}

	}

	
	/**
	 * Redefinition de la methode delete qui permet de supprimer un fournisseur de la base de donnees. 
	  * @param 
	 *      f: type Fournisseur, represente le fournisseur a supprimer de la base de donnees.
	 */

	@Override
	public void delete(Fournisseur f) {
		try {
			// Cr�ation de la zone de requete
			String sql = "DELETE FROM founisseur WHERE id_fournisseur = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			//R�cup�ration de la valeur
			ps.setInt(1, f.getIdFournisseur());
			
			
			//Execution de la requete
			ps.executeUpdate();
			System.out.println("Votre demande de suppression a bien ete prise en compte.");
		} catch (SQLException e) {
			System.out.println("Erreur dans la requete.");
			e.printStackTrace();
		}
		
	
	}
	/**
	 * Redefinition de la methode findById qui permet de rechercher un fournisseur grace a son numero d'identification. 
	 * @param 
	 *      idFournisseur: type int, represente l'identifiant du fournisseur a rechercher dans la base de donnees.  
	 */


	@Override
	public Fournisseur findById(int idFournisseur) {
		
		Fournisseur f = null;
		try {
			// �tape 1:cr�ation de la zone de requ�te
			String sql = "Select * From founisseur where id_fournisseur = ?";
			PreparedStatement ps = connection.prepareStatement(sql);

			// etape 2:transmission des valeurs
			ps.setInt(1, idFournisseur);

			// �tape 3: execution de la requ�te
			ResultSet rs = ps.executeQuery();
			// etape 4: traitement des donn�es du resultat
			while (rs.next()) {
				int idRecup = rs.getInt("id_fournisseur");
				String nomRecup = rs.getString("nom_fournisseur");
				String prenomRecup = rs.getString("prenom_fournisseur");
				String adresseRecup = rs.getString("adresse_fournisseur");
				f = new Fournisseur(idRecup, nomRecup,prenomRecup,adresseRecup);

			}
				
			
			
			if(f != null) {
				System.out.println("Voici le fournisseur que vous cherchez : "+ f);
			}else{
				System.out.println("Ce produit n'existe pas dans la base de donn�es.");
			}
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}
		return f;
	}

	

}

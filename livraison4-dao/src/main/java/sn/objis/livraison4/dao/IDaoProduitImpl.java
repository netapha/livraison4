package sn.objis.livraison4.dao;
/**
 * Cette classe permet d'implementer les methodes metiers qui concernent l'objet Produit.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 24/09/2018
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.livraison4.domaine.Fournisseur;
import sn.objis.livraison4.domaine.Produit;
import sn.objis.livraison4.utils.MysqlConnection;

public class IDaoProduitImpl implements IDaoProduit {
	
	Connection connection = MysqlConnection.connexionALaBase();
	Fournisseur fournisseur = new Fournisseur();
	Produit produit = new Produit();

	/**
	 * Redefinition de la methode create qui permet d'ajouter un nouveau produit dans la base de donnees. 
	 * @param 
     *      p: type Produit, represente le nouveau produit a ajouter dans la base de donnees.  
	 */
	@Override
	public void create(Produit p) {
		try {
			//Cr�ation de la zone de requete
			String sql = "INSERT INTO produit"+" VALUES (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			//R�cup�ration des valeurs
			ps.setInt(1, fournisseur.getIdFournisseur());
			ps.setString(2, p.getNomProduit());
			ps.setInt(3, p.getStockProduit());
			ps.setFloat(4, p.getPrixDachat());
			ps.setFloat(5,p.getPrixDeVente());
			
			//Execution de la requete
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}

	}

	
	/**
	 * Redefinition de la methode read qui permet de lister les produits de la base de donnees. 
	 * 
	 */
	@Override
	public List<Produit> read() {
		List<Produit> list = new ArrayList<>();
		try {
			//Cr�ation de zone de requete
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM produit";
			
			
			//Execution de la requete
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				produit.setNomProduit(resultSet.getString("nom_produit"));
				produit.setStockProduit(resultSet.getInt("stock_produit"));
				produit.setPrixDachat(resultSet.getFloat("prix_dachat_produit"));
				produit.setPrixDeVente(resultSet.getFloat("prix_de_vente_produit"));
				list.add(produit);
				
			}
			//System.out.println("Voici la liste des produits de la base de donn�es : " + produit);
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}
		
		return list;
	}

	
	/**
	 * Redefinition de la methode update qui permet de mettre a jour les informations d'un produit de la base de donnees. 
	 * @param 
	 *      p: type Produit, represente le fournisseur sur lequel des modiications doivent etre apportees. 
	 */
	@Override
	public void update(Produit p) {
		try {
			// Ce�ation de la zone de requete
			String sql = "UPDATE produit SET nom_produit=?, stock_produit=?, prix_dachat_produit=?, prix_de_vente_produit=? WHERE id_produit=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			//R�cup�ration des valeurs
			ps.setString(1, p.getNomProduit());
			ps.setInt(2, p.getStockProduit());
			ps.setFloat(3, p.getPrixDachat());
			ps.setFloat(4, p.getPrixDeVente());
			ps.setInt(5, p.getIdProduit());
			
			
			//Execution de la requete
			ps.executeUpdate();
			System.out.println("Les modifications ont �t� prises en compte avec succ�s.");
			
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}

	}

	
	/**
	 * Redefinition de la methode delete qui permet de supprimer un produit de la base de donnees. 
	 * @param 
	 *      p: type Produit, represente le produit a supprimer de la base de donnees.
	 */
	@Override
	public void delete(Produit p) {
		try {
			// Cr�ation de la zone de requete
						String sql = "DELETE FROM produit WHERE id_produit = ?";
						PreparedStatement ps = connection.prepareStatement(sql);
						//R�cup�ration de la valeur
						ps.setInt(1, p.getIdProduit());
						
						
						//Execution de la requete
						ps.executeUpdate();
						System.out.println("Votre demande de suppression a bien �t� prise en compte.");
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}
					

	}
	/**
	 * Redefinition de la methode findById qui permet de rechercher un fournisseur. 
	 * @param 
	 *      idProduit: type int, represente l'identifiant du produit a rechercher dans la base de donnees.  
	 */

	@Override
	public Produit findById(int idProduit) {
		Produit p = null;
		try {
			// �tape 1:cr�ation de la zone de requ�te
						String sql = "Select * From produit where id_produit=?";
						PreparedStatement ps = connection.prepareStatement(sql);

						// etape 2:transmission des valeurs
						ps.setInt(1, idProduit);

						// �tape 3: execution de la requ�te
						ResultSet rs = ps.executeQuery();
						// etape 4: traitement des donn�es du resultat
						while (rs.next()) {
							int idRecup = rs.getInt("id_produit");
							String nomRecup = rs.getString("nom_produit");
							int stockRecup = rs.getInt("stock_produit");
							float prixDachatRecup = rs.getFloat("prix_dachat_produit");
							float prixDeVenteRecup = rs.getFloat("prix_de_vente_produit");
							p = new Produit(idRecup, nomRecup,stockRecup,prixDachatRecup,prixDeVenteRecup);

						}
						if(p != null) {
							System.out.println("Voici l'identifiant du produit entr� : "+ p);
						}else{
							System.out.println("Ce produit n'existe pas dans la base de donn�es.");
						}
		} catch (SQLException e) {
			System.out.println("Erreur dans la syntaxe.");
			e.printStackTrace();
		}
		return p;
	}

}

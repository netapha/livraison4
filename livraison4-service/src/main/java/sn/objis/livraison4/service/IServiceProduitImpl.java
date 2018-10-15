package sn.objis.livraison4.service;
/**
 * Cette classe permet redefinir les methodes metiers de l'objet Produit.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 27/09/2018
 */
import java.util.List;

import sn.objis.livraison4.dao.IDaoProduitImpl;
import sn.objis.livraison4.domaine.Produit;

public class IServiceProduitImpl implements IServiceProduit {
private IDaoProduitImpl dao = new IDaoProduitImpl();

/**
 * Red�finition de la methode creer qui permet d'ajouter un produit dans la base de donnees.
 */
	@Override
	public void creer(Produit p) {
		dao.create(p);
		
	}
	/**
	 * Redefinition de la methode lister qui permet d'afficher les produits de la base de donnees.
	 */
	@Override
	public List<Produit> lister() {
		return dao.read();
	}
	/**
	 * Redefinition de la methode modifier qui permet de modifier les informations d'un produit de la base de donnees.
	 */
	@Override
	public void modifier(Produit p) {
		dao.update(p);
		
	}
	/**
	 * Redefinition de la methode supprimer qui permet de supprimer un produit de la base de donnees.
	 */
	@Override
	public void supprimer(Produit p) {
		dao.delete(p);
		
	}
	/**
	 * Redefinition de la methode rechercher qui permet rechercher un produit dans la base de donnees.
	 */
	@Override
	public Produit rechercherParIdentifiant(int idProduit) {
		return dao.findById(idProduit);
		
	}

	

}

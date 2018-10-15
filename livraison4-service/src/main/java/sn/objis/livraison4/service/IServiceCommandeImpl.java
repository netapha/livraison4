package sn.objis.livraison4.service;
/**
 * Cette classe permet de redefinir les methodes metiers de l'objet Commande.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 26/09/2018
 */
import java.util.List;

import sn.objis.livraison4.dao.IDaoCommandeImpl;
import sn.objis.livraison4.domaine.Commande;

public class IServiceCommandeImpl implements IServiceCommande {
private IDaoCommandeImpl dao = new IDaoCommandeImpl();
/**
 * Redefinition de la methode creer qui permet d'ajouter une commande dans la base de donnees.
 */
	@Override
	public void creer(Commande c) {
		dao.create(c);

	}
	/**
	 * Redefinition de la methode lister qui permet d'afficher les commandes de la base de donnees.
	 */
	@Override
	public List<Commande> lister() {
		return dao.read();
	}
	/**
	 * Redefinition de la methode modifier qui permet de modifier les informations d'une commande de la base de donnees.
	 */
	@Override
	public void modifier(Commande c) {
		dao.update(c);

	}
	/**
	 * Redefinition de la methode supprimer qui permet de supprimer une commande de la base de donnees.
	 */
	@Override
	public void supprimer(Commande c) {
		dao.delete(c);

	}
	/**
	 * Redefinition de la methode rechercher qui permet rechercher une commande dans la base de donnees.
	 */
	@Override
	public Commande rechercherParIdentifiant(int idCommande) {
		return    dao.findById(idCommande);
		 
	}

}

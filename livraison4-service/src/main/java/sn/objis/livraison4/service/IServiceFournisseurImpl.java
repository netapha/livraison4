package sn.objis.livraison4.service;
/**
 * Cette classe permet de redefinir les methodes metiers de l'objet Fournisseur.
 */
import java.util.List;

import sn.objis.livraison4.dao.IDaoFournisseurImpl;
import sn.objis.livraison4.domaine.Fournisseur;

public class IServiceFournisseurImpl implements IServiceFournisseur {
private IDaoFournisseurImpl dao = new IDaoFournisseurImpl();
/**
 * Redefinition de la methode creer qui permet d'ajouter un fournisseur dans la base de donnees.
 */
	@Override
	public void creer(Fournisseur f) {
		dao.create(f);

	}
	/**
	 * Redefinition de la methode lister qui permet d'afficher les fournisseurs de la base de donnees.
	 */
	@Override
	public List<Fournisseur> lister() {
		return dao.read();
	}
	/**
	 * Redefinition de la methode modifier qui permet de modifier les informations d'un fournisseur de la base de donnees.
	 */
	@Override
	public void modifier(Fournisseur f) {
		dao.update(f);

	}
	/**
	 * Redefinition de la methode supprimer qui permet de supprimer un fournisseur de la base de donnees.
	 */
	@Override
	public void supprimer(Fournisseur f) {
		dao.delete(f);

	}
	/**
	 * Redefinition de la methode rechercher qui permet rechercher un fournisseur dans la base de donnees.
	 */
	@Override
	public Fournisseur rechercherParIdentifiant(int idFournisseur) {
		return dao.findById(idFournisseur);
		
	}

}

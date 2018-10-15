package sn.objis.livraison4.service;
/**
 * Cette classe permet de redefinir les methodes metiers de l'objet Client.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 26/09/2018
 */
import java.util.List;
import sn.objis.livraison4.dao.IDaoClientImpl;
import sn.objis.livraison4.domaine.Client;

public class IServiceClientImpl implements IServiceClient {
private IDaoClientImpl dao = new IDaoClientImpl();
/**
 * Redefinition de la methode creer qui permet d'ajouter un client dans la base de donnees.
 */
	@Override
	public void creer(Client c) {
	dao.create(c);

	}
	/**
	 * Redefinition de la methode lister qui permet d'afficher les clients de la base de donnees.
	 */
	@Override
	public List<Client> lister() {
		
		return dao.read();
	}
	/**
	 * Redefinition de la methode modifier qui permet de modifier les informations d'un client de la base de donnees.
	 */
	@Override
	public void modifier(Client c) {
		dao.update(c);

	}
	/**
	 * Redefinition de la methode supprimer qui permet de supprimer un client de la base de donnees.
	 */
	@Override
	public void supprimer(Client c) {
		dao.delete(c);

	}
	/**
	 * Redefinition de la methode rechercher qui permet rechercher un client dans la base de donnees.
	 */
	@Override
	public Client rechercherParIdentifiant(int idClient) {
		return	dao.findById(idClient);
		 
	}

	

}

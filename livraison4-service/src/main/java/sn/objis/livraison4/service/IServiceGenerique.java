package sn.objis.livraison4.service;

import java.util.List;

import sn.objis.livraison4.domaine.Client;
/**
 * Cette interface represente une interface generique qui contient toutes les  methodes generiques de l'application.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
  * @since 26/09/2018
 */
public interface IServiceGenerique <T>{

	
	public void creer(T t);
	public List <T> lister();
	public void modifier(T t);
	public void supprimer (T t);
	public T rechercherParIdentifiant(int id);
}

package sn.objis.livraison4.dao;
/**
 * Cette interface represente une interface generique qui contient toutes les  methodes generiques de l'application
 * @author Bineta THIAM
 * @version 3.0 SNAPSHOT
  * @since 02/08/2018
 */
import java.util.List;
public interface IDaoGenerique <T>{
	
	public void create(T t);
	public List <T> read();
	public void update(T t);
	public void delete (T t);
	public T findById(int id);

}

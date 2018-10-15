package sn.objis.livraison4.utils;
/**
 * Cette classe permet de controler l'acces a la base de donnees.
 * @author Bineta THIAM
 * @version 4.0 SNAPSHOT
 * @since 27/09/2018
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	//private static String url = "jdbc:mysql://host/Base";
	private static String url = "jdbc:mysql://localhost/gestionboutique?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String nomBaseDeDonnees = "gestionboutiqueenligne";
	private static String userBaseDeDonnees = "objis";
	private static String mdpBaseDeDonnees = "objis";
	private static Connection connection = null;

	/**
	 * Constructeur sans parametre declare prive permettant de bloquer la
	 * creation d'instance de la classe.
	 */
	private MysqlConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * Cette methode permet d'etablir la connexion entre l'application et la base de donnees.
 * @return : return un objet de type Connection
 */
	public static Connection connexionALaBase() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, userBaseDeDonnees, mdpBaseDeDonnees);
			System.out.println("***************Connexion �tablie*****************");
			System.out.println("\n");
			} catch (SQLException e) {
				System.out.println("Probl�me de connexion.");
				e.printStackTrace();
			}

		}

		return connection;
	}

}

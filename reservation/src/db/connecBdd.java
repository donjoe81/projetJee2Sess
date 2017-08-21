package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connecBdd {
	public static Connection getConnec(){
		
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println ("driver etablie");
		} catch (ClassNotFoundException e) {
			System.out.println ("driver not found");
			e.printStackTrace();
		}			   
 
		String hote = "char-oracle11.condorcet.be";//localhost";//
	    String URL = "jdbc:oracle:thin:@"+hote+":1521:xe";
	    String USER = "exa5";//"facsys";// 
	    String PASSWD = "root1"; 
 
	    try {
			con =DriverManager.getConnection(URL,USER, PASSWD);
			System.out.println ("connexion  base orcl etablie");
		} catch (SQLException e) {
			System.out.println ("pas de connexion");
			e.printStackTrace();
		}
		return con;
	}

}

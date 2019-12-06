/**
 * 
 */
package projetH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author François
 *
 */
public class ajoutService {

	/**
	 * @param args
	 */
	public ajoutService(String nom, int litTot, int litRest) {
		String url = "jdbc:mysql://localhost/hopital";
		String login ="Francois";
		String passwd ="1234";
		Connection cn = null;
		Statement st =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO service(nom, litTot, litRest) VALUES ('"+nom+"','"+litTot+"', '"+litRest+"')";
			
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

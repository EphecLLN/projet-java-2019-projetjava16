/**
 * 
 */
package projetH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

/**
 * @author François
 *
 */
public class afficherPatients {

	/**
	 * @param args
	 */
	
	public afficherPatients() {
		String url = "jdbc:mysql://localhost/hopital";
		String login ="Francois";
		String passwd ="1234";
		Connection cn = null;
		Statement st =null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "SELECT idPatient , Nom , Prenom , Age FROM patient";
			
			rs = (ResultSet) st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print("IdPatient : ");
				System.out.println(rs.getInt("idPatient"));
				System.out.print("Nom : ");
				System.out.println(rs.getString("Nom"));
				System.out.print("Prenom : ");
				System.out.println(rs.getString("Prenom"));
				System.out.print("Age : ");
				System.out.println(rs.getInt("Age"));
				System.out.println("--------");
				
			}
			
			
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

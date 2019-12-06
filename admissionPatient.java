/**
 * 
 */
package projetH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author François
 *
 */
public class admissionPatient {

	/**
	 * @param args
	 */
	public admissionPatient(){
		
		
		String url = "jdbc:mysql://localhost/hopital";
		String login ="Francois";
		String passwd ="1234";
		Connection cn = null;
		Statement st =null;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("entrez un id de patient:");
		int idPatient = sc.nextInt();
		System.out.println("entrez un id de Service:");
		int idService = sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO admission(idPatient, idService) VALUES ('"+idPatient+"','"+idService+"')";
			
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

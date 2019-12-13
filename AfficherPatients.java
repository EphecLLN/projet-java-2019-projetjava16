package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class AfficherPatients {
	/**
	 * @param args
	 */	
	public AfficherPatients() {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM patient";
			
			rs = (ResultSet) st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print("IdPatient : ");
				System.out.println(rs.getInt("idPatient"));
				System.out.print("Nom : ");
				System.out.println(rs.getString("nom"));
				System.out.print("Prenom : ");
				System.out.println(rs.getString("prenom"));
				System.out.print("Genre : ");
				System.out.println(rs.getString("genre").charAt(0));
				System.out.print("Date de naissance : ");
				System.out.println(rs.getDate("naissance"));
				System.out.println("--------");
				
			}		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			} 
			catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
	}
}

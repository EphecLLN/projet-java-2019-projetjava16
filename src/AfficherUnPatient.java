package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class AfficherUnPatient {
	/**
	 * @param args
	 */	
	public AfficherUnPatient() {
		
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrez le nom du famille du patient à afficher:");
		String nom = sc.next();
		
		System.out.println("entrez le prénom du patient à afficher:");
		String prenom = sc.next();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM patient WHERE nom ='" + nom + "'" + " AND prenom ='" + prenom + "'";
			
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

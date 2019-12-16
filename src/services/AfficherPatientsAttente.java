package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;


public class AfficherPatientsAttente {
	/**
	 * @param args
	 */
	public AfficherPatientsAttente() {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
			
		System.out.println("entrez l'id du service auquel vous voulez voir les patients en attente : ");
		int idService = sc.nextInt();
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT idPatient, nom, prenom, numTel, enregistrement FROM patient NATURAL JOIN attente WHERE idService = '" + idService + "' ORDER BY enregistrement asc" ;
			rs = (ResultSet) st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print("(Confidentiel) Id du patient : ");
				System.out.println(rs.getInt("idPatient"));
				System.out.print("Nom : ");
				System.out.println(rs.getString("nom"));
				System.out.print("Prenom : ");
				System.out.println(rs.getString("prenom"));
				System.out.print("Numéro de contact : ");
				System.out.println(rs.getString("numTel"));
				System.out.print("Date d'enregistrement : ");
				System.out.println(rs.getString("enregistrement"));
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
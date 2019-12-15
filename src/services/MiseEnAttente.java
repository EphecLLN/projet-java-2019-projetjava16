package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.time.LocalDateTime;


public class MiseEnAttente {
	/**
	 * @param args
	 */
	public MiseEnAttente() {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrez l'id du patient qui attend d'être hospitalisé(e) : ");
		int idPatient = sc.nextInt();
		
		System.out.println("entrez l'id du service auquel le patient attend d'être hospitalisé(e) : ");
		int idService = sc.nextInt();
		
		LocalDateTime enregistrement = LocalDateTime.now();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO attente(idPatient, idService, enregistrement) VALUES ('" + idPatient + "','" + idService + "','" + enregistrement + "')";
			st.executeUpdate(sql);	
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
		System.out.println("Le patient à l'id : " + idPatient + " est mis en attente pour le service à l'id : " + idService);
	}
	
	public static void main(String[] args) {
	}
}
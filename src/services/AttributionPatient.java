package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AttributionPatient {
	/**
	 * @param args
	 */
	public AttributionPatient(){
			
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Entrez l'id du patient :");
		int idPatient = sc.nextInt();
		System.out.println("Entrez l'id du service :");
		int idService = sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO admission(idPatient, idService) VALUES ('" + idPatient+ "','" + idService + "')";
			st.executeUpdate(sql);
			sql = "UPDATE nombrelits NATURAL JOIN admission SET nombreLitsRestants = nombreLitsRestants-1 WHERE idPatient = '" + idPatient + "' AND nombreLitsRestants > 0";
			st.executeUpdate(sql);
			sql = "DELETE FROM attente WHERE idPatient = '" + idPatient + "'";
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
		System.out.println("\nLe patient à l'id : " + idPatient + " a été rajouté au service à l'id : " + idService + "\n");
	}
	
	public static void main(String[] args) {
	}
}

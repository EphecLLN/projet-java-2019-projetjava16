package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AttribuerChambre {
	/**
	 * @param args
	 */
	public AttribuerChambre(){
			
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Entrez l'id du patient :");
		int idPatient = sc.nextInt();
		System.out.println("Entrez l'id de la chambre :");
		int idChambre = sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO patientchambre(idPatient, idChambre) VALUES ('" + idPatient+ "','" + idChambre + "')";
			st.executeUpdate(sql);
			sql = "UPDATE chambreLits NATURAL JOIN patientchambre SET nombreLitsRestants = nombreLitsRestants-1 WHERE idPatient = '" + idPatient + "'";
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
		System.out.println("\nLe patient à l'id : " + idPatient + " a été rajouté à la chambre id : " + idChambre + "\n");
	}
	
	public static void main(String[] args) {
	}
}

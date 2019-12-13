package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdmissionPatient {
	/**
	 * @param args
	 */
	public AdmissionPatient(){
			
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		
		Scanner sc = new Scanner(System.in);
			
		System.out.println("entrez un id de patient:");
		int idPatient = sc.nextInt();
		System.out.println("entrez un id de service:");
		int idService = sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			
			String sql = "INSERT INTO admission(idPatient, idService) VALUES ('" + idPatient+ "','" + idService + "')";
			
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

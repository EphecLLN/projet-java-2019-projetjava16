package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DesistementPatient {
	/**
	 * @param args
	 */
	public DesistementPatient() {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrez l'id du patient qui a désisté son hospitalisation : ");
		int idPatient = sc.nextInt();
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "DELETE FROM attente WHERE idPatient = '" + idPatient + "'";
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
		System.out.println("Le patient à l'id : " + idPatient + " a été retiré de la liste en attente.");
	}
	
	public static void main(String[] args) {
	}
}
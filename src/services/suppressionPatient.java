package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SuppressionPatient {
	public SuppressionPatient(){
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrez l'id du patient � supprimer :");
		int idPatient = sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "DELETE FROM admission WHERE idPatient = '"+ idPatient + "'";
			st.executeUpdate(sql);
			sql = "DELETE FROM patient WHERE idPatient ='" + idPatient + "'";
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
		System.out.println("\nLe patient � l'id : " + idPatient + " a �t� supprim�. \n");
	}
}
package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class StructureChambre {
	/**
	 * @param args
	 */
	public StructureChambre() {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrez l'id de la chambre à configurer : ");
		int idChambre = sc.nextInt();
		
		System.out.println("entrez le nombre de lits disponibles pour cette chambre : ");
		int lits = sc.nextInt();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO chambrelits(idChambre, nombreLitsTotal, nombreLitsRestants) VALUES ('" + idChambre + "','" + lits + "','" + lits + "')";
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
		System.out.println("La chambre à l'id : " + idChambre + " dispose dorénavant de " + lits + " lits disponibles.");
	}
	
	public static void main(String[] args) {
	}
}
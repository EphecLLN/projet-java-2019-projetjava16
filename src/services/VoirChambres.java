package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class VoirChambres {
	/**
	 * @param args
	 */	
	public VoirChambres() {
		
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez l'id du service lequel vous voulez afficher les chambres : ");
		int idService = sc.nextInt();
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT idChambre, numero, nombreLitsRestants FROM chambre NATURAL JOIN chambrelits WHERE idService = '" + idService + "' ORDER BY nombreLitsRestants asc";
			
			rs = (ResultSet) st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print("(Confidentiel) Id de la chambre : ");
				System.out.println(rs.getInt("idChambre"));
				System.out.print("Numéro de la chambre : ");
				System.out.println(rs.getInt("numero"));
				System.out.print("Nombre de places restantes : ");
				System.out.println(rs.getInt("nombreLitsRestants"));
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
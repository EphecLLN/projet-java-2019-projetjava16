package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class StructurationService {
	/**
	 * @param args
	 */
	public StructurationService() {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrez l'id du service à configurer : ");
		int idService = sc.nextInt();
		
		System.out.println("entrez le nombre de lits disponibles pour ce service : ");
		int lits = sc.nextInt();
		
		int rep = 1;
		int compteurChambre = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO nombreLits(idService, nombreLitsTotal, nombreLitsRestants) VALUES ('" + idService + "','" + lits + "','" + lits + "')";
			st.executeUpdate(sql);
			do {
				sql = "INSERT INTO chambre(idService, numero) VALUES ('" + idService + "','";
				System.out.println("Veuillez encoder un numéro de chambre pour ce service : (Tapez 0 pour stopper !)");
				int numero = sc.nextInt();
				if (numero == 0) {
					rep = 0;
					return;
				}
				else {
					sql += numero + "')";
					st.executeUpdate(sql);
					compteurChambre++;
				}
				
			} while(rep != 0);
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
		System.out.println("Le service à l'id : " + idService + " dispose dorénavant de " + lits + " lits disponibles et de " + compteurChambre + " chambres.");
	}
	
	public static void main(String[] args) {
	}
}
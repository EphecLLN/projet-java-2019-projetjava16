package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class StructurationService {
	/**
	 * @param args
	 */
	int id;
	public StructurationService(String Jsp,int b) {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String recupid = "select idService from service where nom = '"+ Jsp+"'";
			rs = (ResultSet) st.executeQuery(recupid);
			while(rs.next()) {id =rs.getInt("idService");}
			String sql = "INSERT INTO nombreLits( idService, nombreLitsTotal, nombreLitsRestants) VALUES ('"+ id+"','"+ b + "','" + b + "')";
			st.executeUpdate(sql);
			System.out.println("Le service "+Jsp+ "a bien été ajouté avec "+b+ " lits disponible.");
			
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
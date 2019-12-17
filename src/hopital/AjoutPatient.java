package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class AjoutPatient {
	
	public AjoutPatient(String nom, String prenom, char genre, LocalDate naissance, String numero) {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO patient(nom, prenom, genre, naissance, numTel) VALUES ('" + nom + "','" + prenom + "','" + genre + "','" + naissance + "','" + numero + "')";
			st.executeUpdate(sql);
			System.out.println(nom+" "+prenom+" a été ajouté dans la base de données.");
			
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
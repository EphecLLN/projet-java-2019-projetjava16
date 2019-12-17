package hopital;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AfficherUnPatient {
	/**
	 * @param args
	 */	
	String nom;
	String prenom;
	String genre;
	Date naissance;
	String numTel;
	
	public AfficherUnPatient(int idPatient) {
		
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
			String sql = "SELECT nom, prenom, genre, naissance, numTEL FROM patient WHERE idPatient = "+idPatient;
			
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				genre = rs.getString("genre");
				naissance = rs.getDate("naissance");
				numTel = rs.getString("numTel");
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
	public String getNom(){
		return nom;
	};
	public String getPrenom() {
		return prenom;
	}
	public String getGenre() {
		return genre;
	}
	@SuppressWarnings("exports")
	public Date getNaissance() {
		return naissance;
	}
	public String getNumTel() {
		return numTel;
	}
	
	public static void main(String[] args) {
		
	}
}

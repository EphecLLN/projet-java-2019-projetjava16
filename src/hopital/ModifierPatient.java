package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;

public class ModifierPatient {
	int results;
	public ModifierPatient(String a, String b, char c, LocalDate d, String ee,int idPatient) {
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
			String sql = "select idPatient from patient where idPatient = "+idPatient;
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {results = rs.getInt("idPatient");}
			if(results != 0) {
				sql = "UPDATE patient SET nom = '"+ a + "', prenom ='"+ b +"', genre = '"+ c +
						"', naissance ='"+ d + "',numTel = '"+ ee +"'where idPatient = "+idPatient;				
				st.executeUpdate(sql);
				
			}
			else {		
				System.out.println("Le patient demandé n'existe pas dans la base de données.");
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
}
	

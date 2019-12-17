package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DesistementPatient {
	
	int results;
	public DesistementPatient(int idPatient) {
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
			String sql = "select idPatient from attente where idPatient = "+idPatient;
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {results = rs.getInt("idPatient");}
				if(results != 0) {
					sql = "DELETE FROM attente WHERE idPatient = '" + idPatient + "'";
					st.executeUpdate(sql);
					System.out.println("Le patient n°"+idPatient+" a bien été retiré de la liste d'attente.");
				}
				else {
					System.out.println("Le patient demandé ne se trouve pas dans la liste d'attente.");
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
				rs.close();
			} 
			catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
	}
}
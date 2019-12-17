package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AttributionPatient {
	/**
	 * @param args
	 */
	int retour ;
	public AttributionPatient(int idPatient,int idService){
			
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
			String sql = "SELECT nombreLitsRestants FROM nombrelits WHERE idService = "+ idService;
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {retour = rs.getInt("nombreLitsRestants");}
			
				if(retour != 0) {
					sql = "INSERT INTO admission(idPatient, idService) VALUES ('" + idPatient+ "','" + idService + "')";
					st.executeUpdate(sql);
					sql = "UPDATE nombrelits NATURAL JOIN admission SET nombreLitsRestants = nombreLitsRestants-1 WHERE idPatient = '" + idPatient + "' AND nombreLitsRestants > 0";
					st.executeUpdate(sql);
					sql = "DELETE FROM attente WHERE idPatient = '" + idPatient + "'";
					st.executeUpdate(sql);
					System.out.println("Le patient n°"+ idPatient +" a été admis dans le service n°"+ idService);
				}
				else {
					System.out.println("Il n'y a plus de place dans le service, le patient n°"+ idPatient +" est mis sur liste d'attente.");
				
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

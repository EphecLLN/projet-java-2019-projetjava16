package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResiliationPatient {
	public ResiliationPatient(int idPatient){
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs= null;
		int idService = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			
			String sql = "select idService from admission where idPatient ="+idPatient;
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {idService = rs.getInt("idService");}
			
			sql = "UPDATE nombreLits NATURAL JOIN admission SET nombreLitsRestants = nombreLitsRestants+1  WHERE idPatient = '" + idPatient + "' AND nombreLitsRestants < nombreLitsTotal";
			st.executeUpdate(sql);
			
			sql = "DELETE FROM admission WHERE idPatient = '" + idPatient + "'";
			st.executeUpdate(sql);
			
			System.out.println("\nLe patient à l'id : " + idPatient + " est sorti(e). \n");
			
			sql = "SELECT * FROM attente where idService ="+idService+" ORDER BY `enregistrement` ASC  LIMIT 1;" ;
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {idPatient = rs.getInt("idPatient");}
			
			if(idPatient !=0) {new AttributionPatient(idPatient, idService);}
			else {System.out.println("Personne en attente pour ce service.");}
			
			
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
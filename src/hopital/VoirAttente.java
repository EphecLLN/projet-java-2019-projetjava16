package hopital;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VoirAttente {
    public VoirAttente(){
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
            String sql = "SELECT * FROM attente";
            rs = (ResultSet)st.executeQuery(sql);

            while(rs.next()) {
            	System.out.print("\n(Confidentiel) id Patient: ");
                System.out.println(rs.getString("idPatient"));
            	System.out.print("id Service : ");
                System.out.println(rs.getString("idService"));
            	System.out.print("Enregistement le 	 : ");
                System.out.println(rs.getDate("enregistement"));                
                System.out.println("--------");
            }
        }
        catch (SQLException var20) {
            var20.printStackTrace();
        } 
		catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        } 
		finally {
            try {
                cn.close();
                st.close();
            } 
			catch (SQLException var19) {
                var19.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
	}
}
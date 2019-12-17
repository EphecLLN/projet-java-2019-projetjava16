package hopital;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VoirPatient {
    public VoirPatient(){
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
            String sql = "SELECT * FROM Patient";
            rs = (ResultSet)st.executeQuery(sql);

            while(rs.next()) {
            	System.out.print("\n(Confidentiel) id : ");
                System.out.println(rs.getInt("idPatient"));
            	System.out.print("Nom : ");
                System.out.println(rs.getString("nom"));
            	System.out.print("Prenom : ");
                System.out.println(rs.getString("prenom"));
            	System.out.print("Genre : ");
                System.out.println(rs.getString("genre"));
                System.out.println("Naissance : ");
                System.out.println(rs.getDate("naissance"));
                System.out.println("Numéro de Téléphone : ");
                System.out.println(rs.getString("numTel"));
                
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

package hopital;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VoirService {
    public VoirService(){
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
            String sql = "SELECT * FROM service natural join nombrelits";
            rs = (ResultSet)st.executeQuery(sql);

            while(rs.next()) {
            	System.out.print("\n(Confidentiel) id : ");
                System.out.println(rs.getInt("idService"));
            	System.out.print("Service : ");
                System.out.println(rs.getString("nom"));
            	System.out.print("nombreLitsTotal : ");
                System.out.println(rs.getInt("nombreLitsTotal"));
            	System.out.print("nombreLitsRestants : ");
                System.out.println(rs.getInt("nombreLitsRestants"));
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
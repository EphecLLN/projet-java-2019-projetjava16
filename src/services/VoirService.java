package hopital;

import com.mysql.jdbc.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VoirService {
    public VoirService(){
        String url = "jdbc:mysql://localhost/hopital";
        String login = "root";
		String passwd = "";
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("entrez le nom du service à voir:");
        String nom = sc.next();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            String sql = "SELECT * FROM service WHERE nom ='" + nom + "'";
            rs = (ResultSet)st.executeQuery(sql);

            while(rs.next()) {
            	System.out.print("\n(Confidentiel) id du service : ");
                System.out.println(rs.getInt("idService"));
            	System.out.print("Service : ");
                System.out.println(rs.getString("nom"));
            }
            
            sql = "SELECT nombreLitsTotal, nombreLitsRestants FROM nombreLits NATURAL JOIN service WHERE nom = '" + nom + "'";
            rs = (ResultSet)st.executeQuery(sql);
            
            while(rs.next()) {
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
}
package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.mysql.jdbc.ResultSet;

public class EnleverLitServ {
	
    public EnleverLitServ(){
        String url = "jdbc:mysql://localhost/hopital";
        String login = "root";
		String passwd = "";
        Connection cn = null;
        Statement st = null;
       
        Scanner sc = new Scanner(System.in);
        System.out.println("entrez le nom du service disposant d'un lit de moins :");
        String nom = sc.next();

        try{
			Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            String sql = "UPDATE service SET litRest = litRest-1 WHERE nom = '" + nom + "' AND litRest > 0";
          
            st.executeUpdate(sql);
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
        System.out.println("\nLe service " + nom + " dispose d'un lit de moins.\n");
    }
}
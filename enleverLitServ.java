package projetH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class enleverLitServ {
    public enleverLitServ(){
        String url = "jdbc:mysql://localhost/hopital";
        String login = "Francois";
        String passwd = "1234";
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("entrez le nom du service du patient entrant:");
        String nom = sc.next();

        try{
           Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            String sql = "update service set litRest = litRest-1 where nom = '" + nom + "'";
          
            st.executeUpdate(sql);
        }
        catch (SQLException var20) {
            var20.printStackTrace();
        } catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException var19) {
                var19.printStackTrace();
            }

        }

    }
}

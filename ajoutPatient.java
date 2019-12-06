package projetH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class ajoutPatient {
	


	public ajoutPatient(String nom,String prenom) {
		String url = "jdbc:mysql://localhost/hopital";
		String login ="Francois";
		String passwd ="1234";
		Connection cn = null;
		Statement st =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO patient(Nom,Prenom) VALUES ('"+nom+"','"+prenom+"')";
			
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
			
	}
	
	
	
	public static void lectureEnBase() {
		String url = "jdbc:mysql://localhost/hopital";
		String login ="Francois";
		String passwd ="1234";
		Connection cn = null;
		Statement st =null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "SELECT Nom , Prenom , age FROM patient";
			
			rs = (ResultSet) st.executeQuery(sql);
			
			while (rs.next()) {
				/*System.out.print("IdPatient : ");
				System.out.println(rs.getInt("idPatient"));*/
				System.out.print("Nom : ");
				System.out.println(rs.getString("Nom"));
				System.out.print("Prenom : ");
				System.out.println(rs.getString("Prenom"));
				System.out.print("Age : ");
				System.out.println(rs.getInt("age"));
				System.out.println("--------");
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/*private static void ajoutPatient() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 
		 System.out.println("entrez un Nom:");
		 String nom = sc.next();
			
		 System.out.println("entrez un Prenom");
		 String prenom = sc.next();
		 
		 System.out.println("entrez l'age: ");
		 int age = sc.nextInt();
		 
		 
		 
		 
		 System.out.println(nom +" "+ prenom +" vient d'être hospitalisé.");
		 
		 ajoutEnBase(nom,prenom,age);
			lectureEnBase();
	}*/
	
	public static void main(String[] args) {
		
		System.out.println("--------------------- Effectué --------------------------");
		lectureEnBase();
	}

	
}

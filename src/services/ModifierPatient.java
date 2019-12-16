package hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class ModifierPatient {
	
	public ModifierPatient() {
		String url = "jdbc:mysql://localhost/hopital";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez encoder l'id de la personne à modifier.");
		int idPatient = Integer.parseInt(sc.next());
		String changement;
		
		do {
			System.out.println("Quelle modifications voulez-vous faire pour le patient ? (Tapez le numéro ou une autre touche pour stopper.)\n"
					+ "1) Le nom \n"
					+ "2) Le prénom \n"
					+ "3) Le genre \n"
					+ "4) La date de naissance \n"
					+ "5) Le numéro de contact \n"
					);
			
			int choix = sc.nextInt();
			
			switch(choix) {
				case 1 :
					changement = "nom";
					break;
				case 2 :
					changement = "prenom";
					break;
				case 3 :
					changement = "genre";
					break;
				case 4 :
					changement = "naissance";
					break;
				case 5 :
					changement = "numTel";
					break;
				default : 
					System.out.println("Ceci ne correspond à aucune des informations potentiellement modifiable !");
					return;
			}
		} while (changement == null);
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "UPDATE patient SET " + changement + " = '";
			
			if (changement == "naissance") {
				System.out.println("entrez la date de naissance du patient (Format : aaaa-mm-jj) : \n");
				LocalDate naissance = LocalDate.parse(sc.next());
				sql +=  naissance + "' WHERE idPatient = '" + idPatient + "'";
			}
			
			else if (changement == "genre") {
				System.out.println("entrez le genre/sexe du patient (M/F/T/N) traduction -> (Male/Femelle/Transgenre/Non binaire) : \n"); 
				char genre = sc.next().charAt(0);
				while (genre != 'M' & genre != 'F' & genre != 'T' & genre != 'N') {
					 System.out.println("Erreur : Ceci n'est pas une possibilité ! Entrez le genre/sexe du patient (M/F/T/N) traduction -> (Male/Femelle/Transgenre/Non binaire) : ");
					 genre = sc.nextLine().charAt(0);
				}
				sql +=  genre + "' WHERE idPatient = '" + idPatient + "'";
			}
			
			else {
				System.out.println("Veuillez entrer les modifications :\n");
				String aChanger = sc.next();
				sql +=  aChanger + "' WHERE idPatient = '" + idPatient + "'";
			}
				
			st.executeUpdate(sql);
			
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
	

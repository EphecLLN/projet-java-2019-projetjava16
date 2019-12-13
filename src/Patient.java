package hopital;

import java.util.Scanner;
import java.time.LocalDate;

public class Patient {
	/**
	 * @param args
	 */
	 String nom;
	 String prenom;
	 LocalDate naissance;
	 char genre;
	 
	 public Patient() {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("entrez le nom de famille du patient :");
		 String nom = sc.nextLine();
			
		 System.out.println("entrez le prénom du patient : ");
		 String prenom = sc.nextLine();
		 
		 System.out.println("entrez le genre/sexe du patient (m/f) : ");
		 char genre = sc.nextLine().charAt(0);
		 
		 System.out.println("entrez la date de naissance du patient (Format : aaaa-mm-jj) : ");
		 LocalDate naissance = LocalDate.parse(sc.nextLine());
		 
		 this.nom = nom;
		 this.prenom = prenom;
		 this.genre = genre;
		 this.naissance = naissance;
		 
		 String appellation = (this.genre == 'm')? "M." : "Mme";
		 	 
		 AjoutPatient nouveau = new AjoutPatient(nom, prenom, genre, naissance);
		 
		 System.out.println(appellation + " " + nom + " vient d'être hospitalisé. \n");
	 }
		   
	public static void main(String[] args) {
	}
}

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
	 String numeroTelephone;
	 
	 public Patient() {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("entrez le nom de famille du patient :");
		 String nom = sc.nextLine();
			
		 System.out.println("entrez le prénom du patient : ");
		 String prenom = sc.nextLine();
		 
		 System.out.println("entrez le genre/sexe du patient (M/F/T/N) traduction -> (Male/Femelle/Transgenre/Non binaire) : ");
		 char genre = sc.nextLine().charAt(0);
		 while (genre != 'M' & genre != 'F' & genre != 'T' & genre != 'N') {
			 System.out.println("Erreur : Ceci n'est pas une possibilité ! Entrez le genre/sexe du patient (M/F/T/N) traduction -> (Male/Femelle/Transgenre/Non binaire) : ");
			 genre = sc.nextLine().charAt(0);
		 }
		 
		 System.out.println("entrez la date de naissance du patient (Format : aaaa-mm-jj) : ");
		 LocalDate naissance = LocalDate.parse(sc.nextLine());
		
		 System.out.println("Encodez un numéro de téléphone.");
		 String numeroTelephone = sc.nextLine();
		 
		 this.nom = nom;
		 this.prenom = prenom;
		 this.genre = genre;
		 this.naissance = naissance;
		 this.numeroTelephone = numeroTelephone;
		 	 
		 AjoutPatient nouveau = new AjoutPatient(nom, prenom, genre, naissance, numeroTelephone);
		 
		 System.out.println("Le patient vient d'être enregistré !");
	 }
		   
	public static void main(String[] args) {
	}
}

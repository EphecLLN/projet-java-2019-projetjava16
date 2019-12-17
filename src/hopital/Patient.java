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
	 
	int idPatient;
	 Scanner sc = new Scanner(System.in);
	 
	 public Patient() {
		 
		 System.out.println("Veuillez encoder le nom du patient:");
			nom = sc.next();
			System.out.println("Veuillez encoder le prénom du patient:");
			prenom = sc.next();
			System.out.println("Veuillez encoder la date de naissance sous le format 'yyyy-mm-dd':");
			naissance = LocalDate.parse(sc.next());
			System.out.println("Veuillez encoder le genre du Patient:");
			genre = sc.next().charAt(0);
			System.out.println("Veuillez saisir le numéro de téléphone:");
			numeroTelephone = sc.next();
		 	 
	 }
	 public void nouveau() {
		 new AjoutPatient(nom, prenom, genre, naissance, numeroTelephone);
	 }
	 public void modifier() {
		 System.out.print("Insérer l'id du patient à modifier:");
		 idPatient = Integer.parseInt(sc.next());
		 new ModifierPatient(nom,prenom, genre,naissance,numeroTelephone, idPatient);
	 }
		   
	public static void main(String[] args) {
	}
}

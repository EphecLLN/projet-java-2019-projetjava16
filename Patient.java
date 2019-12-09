/**
 * 
 */
package projetH;

import java.util.Scanner;

/**
 * @author user
 *
 */
public class Patient {

	/**
	 * @param args
	 */
	 String nom;
	 String prenom;
	 
	 
	 //constructeur
	 public Patient() {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("entrez un Nom:");
		 String nom = sc.nextLine();
			
		 System.out.println("entrez un Prenom");
		 String prenom = sc.nextLine();
		 
		 this.nom = nom;
		 this.prenom = prenom;
		 
		 System.out.println(nom +" "+ prenom +" vient d'être hospitalisé.");
		 
		 ajoutPatient nouveau = new ajoutPatient(nom, prenom);
		
		 
	 }
		   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

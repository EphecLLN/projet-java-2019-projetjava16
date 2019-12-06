/**
 * 
 */
package projetH;

import java.util.Scanner;

/**
 * @author François
 *
 */
public class Service {

	/**
	 * @param args
	 */
	
	String nom;
	int litTot;
	int litRest;
	int count = 0;
	
	// constructeur 
	public Service(){
		 
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("entrez un service:");
		String nom = sc.nextLine();
		
		
		
		System.out.println("entrez nombre de lits:");
		int lit =sc.nextInt();
		
		
		this.nom = nom;
		this.litTot = lit;
		this.litRest = lit;
		
		System.out.println(nom + " possède " + litTot + " lits dont " + litRest +" sont encore dispo.");
		
		ajoutService ajout = new ajoutService(nom, litTot, litRest);
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		
	}

}

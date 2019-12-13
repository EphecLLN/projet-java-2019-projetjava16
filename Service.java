package hopital;

import java.util.Scanner;

public class Service {
	/**
	 * @param args
	 */	
	String nom;
	int litTot;
	int litRest;
	int count = 0;
	
	public Service(){
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrez un nouveau service:");
		String nom = sc.nextLine();
		
		System.out.println("entrez nombre de lits:");
		int lit = sc.nextInt();
		
		this.nom = nom;
		this.litTot = lit;
		this.litRest = lit;
		
		AjoutService ajout = new AjoutService(nom, litTot, litRest);
		
		System.out.println(nom + " possède " + litTot + " lits dont " + litRest + " sont encore disponibles.");	
	}	
	
	public static void main(String[] args) {
	}
}


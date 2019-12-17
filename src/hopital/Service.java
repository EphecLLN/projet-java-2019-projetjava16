package hopital;

import java.util.Scanner;

public class Service {
	String nom;
	int lits;
	Scanner sc = new Scanner(System.in);
	
	public Service() {
		System.out.println("Veuillez encoder le nom du service.");
		nom = sc.next();
		System.out.println("Veuillez encoder le nombre de lits du service.");
		lits = Integer.parseInt(sc.next());
		
		new AjoutNomService(nom);
		new StructurationService(nom,lits);
		
		System.out.println("Le service "+ nom +" avec "+ lits + " lits disponibles.");
		System.out.println("--------------------------------------------------------------");
		
	};
	public String getNom() {
		return nom;
	};
	public int getNombreLitsTot() {
		return lits;
	};
	public int getNombreLitsRest() {
		return lits;
	};

	public static void main(String[] args) {

	}

}

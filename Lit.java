// Temmerman François 
package projetH;

import java.util.Scanner;

public class Lit {

		private int numero; 
		//Chambre chambre = null; // numero par étage et ailes?
		//Patient patient = null; // int pour numero d'identification ? num registre national?
		
		public String toString() {
		       return "Lit{" +
		               "numero='" + this.numero + '\'' +
		               ", chambre='" + //this.chambre + '\'' +
		               ", patient=" + //this.patient + '\'
		               '}';
		   }

		
		/*public void setPatient(int patient) {
			this.patient = patient;
		}
		public void setChambre(int chambre) {
			this.chambre = chambre;
		}*/
		public void setNumero(int numero) {
			this.numero = numero;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lit lit = new Lit(); 
		Scanner sc = new Scanner(System.in);
		int tabLit[]= new int[10];
		int chambre;
		
		//lit.setNumero(15); 
		
		//System.out.println(lit.toString());
		
		System.out.println("entrez un numero de lit: ");
		int num =+
		System.out.println("Lit numero : " + num + " est enregistrer");
		tabLit[0] = num;
		
		for(int i=0; i<tabLit.length;  i++) {
		System.out.println(tabLit[i]);
		}
	}

}

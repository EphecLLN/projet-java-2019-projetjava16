package hopital;

import java.util.Scanner;

public class Lit {

	private String numero; 
	
	public String toString() {
		   return "Lit{" + "numero='" + this.numero + '\'' + '}';
	}
		
	public static void main(String[] args) {	
		Lit lit = new Lit(); 
		Scanner sc = new Scanner(System.in);
		String tabLit[]= new String[10];
		
		System.out.println("entrez un numero de lit: ");
		lit.numero =  sc.nextLine();
		System.out.println("Lit numero : " + lit.numero + " est enregistré");
		tabLit[0] = lit.numero;
		
		for(int i = 0; i < tabLit.length;  i++) {
			System.out.println(tabLit[i].toString());
		}
		
		sc.close();
	}
}
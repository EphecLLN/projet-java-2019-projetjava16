/**
 * 
 */
package projetH;

import java.util.*;
import java.util.Scanner;

/**
 * @author François
 *
 */
public class test {
	
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char rep='o';
		int choix=0;
		//System.out.println("voulez vous continuer le programme?(o)");
		
		
		do {
		
			System.out.println("voulez vous continuer le programme?(o/n)");
			String str = sc.next();
			rep = str.charAt(0);
			
			// lance menu while rep = o
			if(rep == 'o') { 
				System.out.println("faites votre choix:\n"
						+ "1)Ajout service\n"
						+ "2)Modifier service\n"
						+ "3)Voir Service\n"
						+ "4)Nouveau Patient\n"
						+ "5) Supprimer un patient\n"
						+ "6) afficher les patients\n"
						+ "7) afficher patient en particulier\n"
						+ "8) admission d'un patient\n"
						+"9) ajoutLitServ\n"
						+"10) enlever lit service"
						);
				choix = sc.nextInt();
				
				switch(choix) {
				
				case 1:
					Service service = new Service();
					break;
				case 2:
					System.out.println("choix 2");
					break;
				case 3:
					voirService voirServ = new voirService();
					break;
				case 4:
					Patient patient = new Patient();
					break;
				case 5:
					suppressionPatient suppPatient = new suppressionPatient();
					break;
				case 6:
					afficherPatients affPatient = new afficherPatients();
					break;
				case 7 :
					afficherUnPatient affUnPat = new afficherUnPatient();
					break;
				case 8:
					admissionPatient admPat = new admissionPatient();
					break;
				case 9:
					ajoutLitServ ajoutLitS = new ajoutLitServ();
					break;
				case 10:
					enleverLitServ enleverLitS = new enleverLitServ();
					break;
				default:
					System.out.println("erreur");
					
				}
			}
			// sinon stop
			else {
			break;
			}
			
		}
		while(rep == 'o') ;
		
		System.out.println("bye");
	}

}

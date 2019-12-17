package view;

import java.util.Scanner;

import hopital.*;
public class ConsoleView {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			int choix = 0;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Pressez 'c' pour commencer !(ou une autre touche pour arrêter)");
			String str = sc.next();
			char rep = str.charAt(0);
			
			if (!(rep == 'c')) {
				System.out.println("D'accord, au revoir !");
				sc.close();
				return;
			}
				
			while (rep == 'c') { 
				System.out.println("Tapez le numéro du service désirée !\n"
						+ "----------- Création------------\n"
						+ "1) Nouveau Service\n"
						+ "2) Nouveau Patient\n"
						+ "3) Admission Patient\n"
						+ "4) Annulation Attente\n"
						+ "5) Modifier un Patient\n"
						+ "6) Fin Hospitalisation\n"
						+ "7) Voir tout les services\n"
						+ "8) Voir tout les patients\n"
						+ "9) Voir tout les patients qui attendes"
						);
				choix = sc.nextInt();
				
				switch(choix) {
					case 1:
						new Service();
						break;
					case 2:
						Patient patient = new Patient();
						patient.nouveau();
						break;
					case 3:
						new AdmissionC();
						break;
					case 4:
						DesistementC supp = new DesistementC();
						supp.desistement();
						break;
					case 5:
						Patient nouveau = new Patient();
						nouveau.modifier();
						break;
					case 6:
						DesistementC sort = new DesistementC();
						sort.fin();
						break;
					case 7:
						new VoirService();
						break;
					case 8:
						new VoirPatient();
						break;
					case 9:
						new VoirAttente();
						break;
					default:
						System.out.println("Ce que vous avez entrez ne correspond à aucun service !");
						break;
				}
				System.out.println("Pressez 'c' pour continuer !(ou une autre touche pour arrêter)");
				str = sc.next();
				rep = str.charAt(0);
			}
					
			sc.close();
			System.out.println("D'accord, au revoir !");
		}

	}



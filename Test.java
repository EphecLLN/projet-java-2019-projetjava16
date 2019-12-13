package hopital;

import java.util.Scanner;

public class Test {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			int choix = 0;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Pressez 'c' pour commencer !");
			String str = sc.next();
			char rep = str.charAt(0);
			
			if (!(rep == 'c')) {
				System.out.println("D'accord, au revoir !");
				sc.close();
				return;
			}
				
			while (rep == 'c') { 
				System.out.println("Tapez le numéro du service désirée !\n"
						+ "1) Ajouter un service\n"
						+ "2) Examiner un service\n"
						+ "3) Ajouter un patient\n"
						+ "4) Supprimer un patient\n"
						+ "5) Afficher les patients\n"
						+ "6) Afficher un patient en particulier\n"
						+ "7) Admission d'un patient\n"
						+ "8) Ajouter un lit disponible à un service\n"
						+ "9) Enlever un lit disponible à un service\n"
						);
				choix = sc.nextInt();
				
				switch(choix) {
					case 1:
						Service service = new Service();
						break;
					case 2:
						VoirService voirServ = new VoirService();
						break;
					case 3:
						Patient patient = new Patient();
						break;
					case 4:
						SuppressionPatient suppPatient = new SuppressionPatient();
						break;
					case 5:
						AfficherPatients affPatient = new AfficherPatients();
						break;
					case 6:
						AfficherUnPatient affUnPat = new AfficherUnPatient();
						break;
					case 7:
						AdmissionPatient admPat = new AdmissionPatient();
						break;
					case 8:
						AjoutLitServ ajoutLitS = new AjoutLitServ();
						break;
					case 9:
						EnleverLitServ enleverLitS = new EnleverLitServ();
						break;
					default:
						System.out.println("Ce que vous avez entrez ne correspond à aucun service !");
						break;
				}
				System.out.println("Pressez 'c' pour continuer !");
				str = sc.next();
				rep = str.charAt(0);
			}
					
			sc.close();
			System.out.println("D'accord, au revoir !");
		}

	}



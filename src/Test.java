package hopital;

import java.util.Scanner;

public class Test {
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
						+ "----------- Affichage------------\n"
						+ "1) Afficher les données d'un patient\n"
						+ "2) Afficher les données d'un service\n"
						+ "3) Afficher les patients en attente pour un service\n"
						+ "4) Afficher les chambres disponibles pour un service\n"
						+ "----------- Ajout/Modification------------\n"
						+ "5) Ajouter un patient\n"
						+ "6) Attribution d'un patient à un service\n"
						+ "7) Attribuer une chambre à un patient\n"
						+ "8) Libérer un patient d'un service\n"
						+ "9) Modifier un patient\n"
						+ "10) Mettre en attente un patient pour un service\n"
						+ "11) Désistement d'un patient pour hospitalisation (Suppression de la mise en attente)\n"
						+ "----------- Structure ou Restructuration------------\n"
						+ "12) Ajouter un nom de service\n"
						+ "13) Configurer un service\n"
						+ "14) Configurer une chambre"
						);
				choix = sc.nextInt();
				
				switch(choix) {
					case 1:
						AfficherUnPatient affUnPat = new AfficherUnPatient();
						break;
					case 2:
						VoirService voirServ = new VoirService();
						break;
					case 3:
						AfficherPatientsAttente affPatAtt = new AfficherPatientsAttente();
						break;
					case 4:
						VoirChambres affChambre = new VoirChambres();
						break;
					case 5:
						Patient patient = new Patient();
						break;
					case 6:
						AttributionPatient attPat = new AttributionPatient();
						break;
					case 7:
						AttribuerChambre attChambre = new AttribuerChambre();
						break;
					case 8:
						ResiliationPatient resPatient = new ResiliationPatient();
						break;
					case 9 : 
						ModifierPatient modifPat = new ModifierPatient();
						break;
					case 10 : 
						MiseEnAttente att = new MiseEnAttente();
						break;
					case 11 : 
						DesistementPatient desistPat = new DesistementPatient();
						break;
					case 12 : 
						AjoutNomService service = new AjoutNomService();	
						break;
					case 13 : 
						StructurationService structServ = new StructurationService();
						break;
					case 14 :
						StructureChambre structChambre = new StructureChambre();
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



package hopital;

import java.util.Scanner;

public class AdmissionC {
	int idService;
	int idPatient;
	Scanner sc = new Scanner(System.in);
	
	public AdmissionC() {
		System.out.println("Veuillez indiquer l'id du Service:");
		idService = Integer.parseInt(sc.next());
		System.out.println("Veuillez indiquer l'id du Patient:");
		idPatient = Integer.parseInt(sc.next());
		
		new MiseEnAttente(idPatient,idService);
		new AttributionPatient(idPatient,idService);
	}
	
	public static void main(String[] args) {
		

	}

}

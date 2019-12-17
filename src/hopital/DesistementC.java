package hopital;

import java.util.Scanner;

public class DesistementC {
	
	int idPatient;
	Scanner sc = new Scanner(System.in);
	
	public DesistementC() {
		System.out.println("Insérer id du patient qui part:");
		idPatient = Integer.parseInt(sc.next());
		
		
	}
	public void desistement() {
		new DesistementPatient(idPatient);
	}
	public void fin() {
		new ResiliationPatient(idPatient);
	}
	
}

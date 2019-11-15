// Temmerman François 
package projetH;

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
		
		lit.setNumero(15); 
		
		System.out.println(lit.toString());
		
	}

}

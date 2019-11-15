/**
 * 
 */

/**
 * @author user
 *Thomas Namurois class Service
 */
public class Service {

		// arg
		
		String nomService;
		int litsTotal;
		int litsRestant;
		int chambreTotal;
		int chambreRestant;
		
		
		
		@Override
		public String toString() {
			return "Service [nomService=" + nomService + ", litsTotal=" + litsTotal + ", litsRestant=" + litsRestant
					+ ", chambreTotal=" + chambreTotal + ", chambreRestant=" + chambreRestant + "]";
		}
		//méthode lits
		public void increLits(int n){
			litsRestant += n;
		}
		public void decreLits(int n){
			litsRestant -= n;
		}
		
		//méthode chambre
		//public void totChambre(int n){}
		public void increChambre(int n){
			chambreRestant += n;
		}
		public void decreChambre(int n){
			chambreRestant -= n;
		}
		
		//constructeur
		void creerService(String nom){
			this.nomService = nom;
		}
		void creerService(String nomService, int nLitTot, int nLitRest) {
			this.nomService = nomService;
			this.litsTotal = nLitTot;
			this.litsRestant = nLitRest;
		}
		void creerService(String nomService, int nLitTot, int nLitRest, int nChambreTot, int nChambreRest) {
			this.nomService = nomService;
			this.litsTotal = nLitTot;
			this.litsRestant = nLitRest;
			this.chambreTotal = nChambreTot;
			this.chambreRestant = nChambreRest;
		}
		
}


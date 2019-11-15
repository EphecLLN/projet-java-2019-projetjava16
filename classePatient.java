import java.util.Date;

public class Patient {
   private String nom;
   private String prenom;
   private Date naissance;
   private String numeroNational;
   private Date entree = new Date();
   Chambre numeroChambre = null;

   @Override
   public String toString() {
       return "Patient{" +
               "nom='" + this.nom + '\'' +
               ", prenom='" + this.prenom + '\'' +
               ", naissance=" + this.naissance +
               ", nationalNumero=" + this.numeroNational +
               ", entree=" + this.entree +
               ", chambre=" + this.numeroChambre +
               '}';
   }

   public void setNom(String nom) {
       this.nom = nom;
   }
   public void setPrenom(String prenom) {
       this.prenom = prenom;
   }
   public void setNaissance(Date naissance) {
       this.naissance = naissance;
   }
   
   public void setNumeroNational(String numeroNational) {
       this.numeroNational = numeroNational;
   }
   public void setEntree(Date entree) {
       this.entree = entree;
   }


  void sortie(){
       // Le patient sort et son objet est supprimé !
       /**
        * Un appel vers la base de données pour retirer le patient des patients en attente ou listés.
        * Via a Webservice
        */
   }
   void changementService(){
       /** Le patient est déplacé vers la chambre d'un autre service.
        * Le patient est retiré de la chambre et remis dans une autre appartenant à un autre service.
        * Via Webservice
        */
   }

   void creerPatient(String nom, String prenom) { 
       this.setNom(nom);
       this.setPrenom(prenom);
   }

   void creerPatient(String nom, String prenom, Date naissance) {
       this.setNom(nom);
       this.setPrenom(prenom);
       this.setNaissance(naissance);
   }

   void creerPatient(String nom, String prenom, Date naissance, String numeroNational) {
       this.setNom(nom);
       this.setPrenom(prenom);
       this.setNaissance(naissance);
       this.setNumeroNational(numeroNational);
   }

   public static void main(String [] args) {
       Patient numberOne = new Patient();
       numberOne.creerPatient("Duponteuil", "Jean-Michel", new Date(1986, 9, 26));
       numberOne.toString();
   }
}

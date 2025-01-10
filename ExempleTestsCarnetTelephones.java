
/**
 * Cette classe montre un exemple de tests pouvant etre effectues pour tester 
 * PARTIELLEMENT la classe CarnetTelephones. 
 * 
 * Chaque test affiche la valeur obtenue suivie de la valeur attendue entre 
 * parenthèses. Un test est reussi si la valeur obtenue est egale a la valeur 
 * attendue.
 * 
 * CETTE CLASSE NE FOURNIT PAS DES TESTS COMPLETS, CE N'EST QU'UN PETIT EXEMPLE 
 * POUR VOUS AIDER A CREER VOS PROPRES TESTS. Evidemment, vous pouvez separer vos
 * tests en differentes methodes appelees dans la mehtode main.
 * 
 * @author melanie lord
 * @version H24
 */
public class ExempleTestsCarnetTelephones {
   
   public static void main (String [] args) {
      Telephone t1 = null;
      Telephone t2 = null;
      Telephone t3 = null;
      Telephone t4 = null;
      Telephone t5 = null;
      boolean b;
      
      //creation de quelques telephones pour executer les tests
      try {
         t1 = new Telephone("nom1", "prenom1", "1234567", 0);
         t2 = new Telephone("nom2", "prenom2", "8889023", 0);
         t3 = new Telephone("nom3", "prenom3", "4501252223", 0);
         t4 = new Telephone("nom4", "prenom4", "17562340749", 0);
         t5 = new Telephone("nom5", "prenom5", "2223443", 0);
      } catch (TelephoneInvalideException e) {
         //ne devrait pas se produire.
         e.printStackTrace();
      }
      
      //creation d'un carnet de telephones
      CarnetTelephones carnet = new CarnetTelephones();
      
      //Verifier que la taille du carnet est bien 0
      System.out.println (carnet.obtenirTailleCarnet() + " (0)");
      
      //ajout d'un telephone au carnet
      b = carnet.ajouterTelephone(t1);
      
      //verifier que la taille du carnet est bien 1
      System.out.println(carnet.obtenirTailleCarnet() + " (1)");
      
      //verifier que la valeur de retour est bien true
      System.out.println(b + " (true)");
      
      //ajouter 3 autres telephones
      b = carnet.ajouterTelephone(t2);
      b = carnet.ajouterTelephone(t3);
      b = carnet.ajouterTelephone(t4);
      
      //verifier que la taille du carnet est bien 4
      System.out.println(carnet.obtenirTailleCarnet() + " (4)");
      
      //tentative d'ajout d'un telephone null
      b = carnet.ajouterTelephone(null);
      
      //verifier que la valeur de retour est false
      System.out.println(b + " (false)");
      
      //verifier que la taille du carnet est encore 4
      System.out.println(carnet.obtenirTailleCarnet() + " (4)");
      
      //verifier methode obtenirTelephone
      System.out.println(carnet.obtenirTelephone(1) + " (" + t1 + ")");
      System.out.println(carnet.obtenirTelephone(2) + " (" + t2 + ")");
      System.out.println(carnet.obtenirTelephone(3) + " (" + t3 + ")");
      System.out.println(carnet.obtenirTelephone(4) + " (" + t4 + ")");
      System.out.println(carnet.obtenirTelephone(5) + " (null)");
      System.out.println(carnet.obtenirTelephone(-1) + " (null)");
      
      //supprimer 1 telephone
      b = carnet.supprimerTelephone(2);
      
      //verifier que la taille du carnet = 3
      System.out.println(carnet.obtenirTailleCarnet() + " (3)");
      
      //verifier que la valeur retournee est true
      System.out.println(b + " (true)");
      
      //tentative de supprimer 1 telephone inexistant
      b = carnet.supprimerTelephone(-1);
      
      //verifier que le carnet contient toujours 3 telephones
      System.out.println(carnet.obtenirTailleCarnet() + " (3)");
      
      //verifier que la valeur retournee est false
      System.out.println(b + " (false)");
      
      //afficher les telephones avec obtenirTelephone
      System.out.println(carnet.obtenirTelephone(1) + " (" + t1 + ")");
      System.out.println(carnet.obtenirTelephone(2) + " (" + t3 + ")");
      System.out.println(carnet.obtenirTelephone(3) + " (" + t4 + ")");
      System.out.println(carnet.obtenirTelephone(4) + " (null)");
   
      //ajouter un telephone
      carnet.ajouterTelephone(t5);
      
      //afficher les telephones avec obtenirTelephone
      System.out.println(carnet.obtenirTelephone(1) + " (" + t1 + ")");
      System.out.println(carnet.obtenirTelephone(2) + " (" + t5 + ")");
      System.out.println(carnet.obtenirTelephone(3) + " (" + t3 + ")");
      System.out.println(carnet.obtenirTelephone(4) + " (" + t4 + ")");
      System.out.println(carnet.obtenirTelephone(5) + " (null)");
      
      
      //etc...
      
   }
   
}

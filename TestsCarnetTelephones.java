
/**
 * Cette classe contient des tests pour le TP3.
 *
 * @author Charles Ally
 * @version 2024-04-22
 */
public class TestsCarnetTelephones {
    public static void main (String [] args) {
        Telephone t1 = null;
        Telephone t2 = null;
        Telephone t3 = null;
        Telephone t4 = null;
        Telephone t5 = null;
        CarnetTelephones carnet = new CarnetTelephones();
        CarnetTelephones autreCarnet = new CarnetTelephones();
        boolean b;
        
        try {
            t1 = new Telephone("nom1", "prenom1", "1234567", 0);
            t2 = new Telephone("Bouchard", "Gabriel", "8889023", 0);
            t3 = new Telephone("Boucher", "Jean", "4501252223", 0);
            t4 = new Telephone("Lavoie", "Jacob", "17562340749", 0);
            t5 = new Telephone("Menard", "Alex", "2223443", 0);   
        } catch (TelephoneInvalideException e) {
            e.printStackTrace();
        }
        
        
        //TESTS DES SETTERS
        try {
            t1.setNom("Tremblay");
            t1.setPrenom("Alexis");
            t1.setNoTel("2345678901");
            t1.setType(2);
        } catch (TelephoneInvalideException e){
            System.out.println("Erreur");
        }
        
        System.out.println(carnet.obtenirTailleCarnet());
        
        //TESTS TAILLE CARNET + AJOUTER + SUPPRIMER
        b = carnet.ajouterTelephone(t1);
        b = carnet.ajouterTelephone(t3);
        b = carnet.ajouterTelephone(t5);
        b = carnet.ajouterTelephone(t4);
        b = carnet.supprimerTelephone(2);
        b = carnet.ajouterTelephone(t2);
        b = carnet.supprimerTelephone(1);
        b = carnet.supprimerTelephone(4);
        System.out.println(b);
        carnet.ajouterTelephone(t4);
        carnet.viderCarnet();
        
        
        
        System.out.println(carnet.obtenirTelephone(1));
        System.out.println(carnet.obtenirTelephone(2));
        System.out.println(carnet.obtenirTelephone(3));
        System.out.println(carnet.obtenirTelephone(4));
        System.out.println(carnet.obtenirTailleCarnet());
        /*
       
        b = carnet.supprimerTelephone(2);
        b = carnet.supprimerTelephone(2);
        
        System.out.println(carnet.obtenirTelephone(1));
        System.out.println(carnet.obtenirTelephone(2));
        
        b = carnet.ajouterTelephone(t2);
        b = carnet.ajouterTelephone(t3);
        
        
        System.out.println(carnet.obtenirTelephone(1));
        System.out.println(carnet.obtenirTelephone(2));
        System.out.println(carnet.obtenirTelephone(3));
        System.out.println(carnet.obtenirTelephone(4));
        */
        //TESTS DE MODIFICATION
        b = carnet.modifierNomTelephone(3, "Lord");
        b = carnet.modifierPrenomTelephone(2, "Alexandre");
        b = carnet.modifierTypeTelephone(1, 3);
        b = carnet.modifierNoTelephone(1, "3456781032");
        
                
        /*
        System.out.println(carnet.obtenirTelephone(1));
        System.out.println(carnet.obtenirTelephone(2));
        System.out.println(carnet.obtenirTelephone(3));
        
        //RECHERCHE DE MOTIFS
        Telephone [] tab = carnet.rechercherTelephones("alex");
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);    
        }
        System.out.println(tab.length);
        
        b = autreCarnet.ajouterTelephone(t5);
        b = carnet.supprimerTelephone(2);
        Telephone [] tableau = autreCarnet.rechercherTelephones("mena");
        for (int i = 0; i < tableau.length; i++) {
            System.out.println(tableau[i]);
        }
        System.out.println(tableau.length);
        
        //FUSION CARNETS
        
        System.out.println(carnet.obtenirTailleCarnet());
        System.out.println(autreCarnet.obtenirTailleCarnet());
        carnet.fusionnerCarnets(autreCarnet);
        
        System.out.println(carnet.obtenirTelephone(1));
        System.out.println(carnet.obtenirTelephone(2));
        System.out.println(carnet.obtenirTelephone(3));
        System.out.println(carnet.obtenirTelephone(4));
        System.out.println(carnet.obtenirTelephone(5));
        System.out.println(carnet.obtenirTelephone(6));
        System.out.println(autreCarnet.obtenirTailleCarnet());
        autreCarnet.supprimerTelephone(1);
        System.out.println(autreCarnet.obtenirTailleCarnet());
        
        //VIDER CARNET
        
        carnet.viderCarnet();
        System.out.println(carnet.obtenirTelephone(1));
        System.out.println(carnet.obtenirTelephone(2));
        System.out.println(carnet.obtenirTelephone(3));
        System.out.println(carnet.obtenirTelephone(4));
        System.out.println(carnet.obtenirTelephone(5));
        System.out.println(carnet.obtenirTailleCarnet());
        */
        
        
        
        
        
        /*
        System.out.println(carnet.obtenirTailleCarnet() + " (0)");
        b = carnet.ajouterTelephone(t1);
        System.out.println(carnet.obtenirTailleCarnet() + " (1)");
        System.out.println(b + " (true)");
        b = carnet.ajouterTelephone(t2);
        b = carnet.ajouterTelephone(t3);
        b = carnet.ajouterTelephone(t4);
        System.out.println(carnet.obtenirTailleCarnet() + " (4)");
        b = carnet.ajouterTelephone(null);
        System.out.println(b + " (false)");
        System.out.println(carnet.obtenirTailleCarnet() + " (4)");
        System.out.println(carnet.obtenirTelephone(1) + " (" + t1 + ") ");
        System.out.println(carnet.obtenirTelephone(2) + " (" + t2 + ") ");
        System.out.println(carnet.obtenirTelephone(3) + " (" + t3 + ") ");
        System.out.println(carnet.obtenirTelephone(4) + " (" + t4 + ") ");
        System.out.println(carnet.obtenirTelephone(5) + " (null) ");
        System.out.println(carnet.obtenirTelephone(-1) + " (null) ");
        b = carnet.supprimerTelephone(2);
        System.out.println(carnet.obtenirTailleCarnet() + " (3)");
        System.out.println(b + " (true)");
        b = carnet.supprimerTelephone(-1);
        System.out.println(carnet.obtenirTailleCarnet() + " (3)");
        System.out.println(b + " (false)");
        System.out.println(carnet.obtenirTelephone(1) + " (" + t1 + ")");
        System.out.println(carnet.obtenirTelephone(2) + " (" + t3 + ")");
        System.out.println(carnet.obtenirTelephone(3) + " (" + t4 + ")");
        System.out.println(carnet.obtenirTelephone(4) + " (null)");
        
        carnet.ajouterTelephone(t5);
        System.out.println(carnet.obtenirTelephone(1) + " (" + t1 + ")");
        System.out.println(carnet.obtenirTelephone(2) + " (" + t5 + ")");
        System.out.println(carnet.obtenirTelephone(3) + " (" + t3 + ")");
        System.out.println(carnet.obtenirTelephone(4) + " (" + t4 + ")");
        System.out.println(carnet.obtenirTelephone(5) + " (null)");
        */
    }
    
}   

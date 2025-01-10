
/**
 * Cette classe permet d'executer un programme qui permet d'évaluer un budget mensuel. 
 * L’utilisateur choisit un mois et une année et peut rentrer des revenus et des dépenses, 
 * puis consulter un bilan représentant les revenus, les dépenses ainsi que le solde.
 *
 * @author Charles Ally 
 * Code permanent : ALLC75020409
 * Courriel : dj491943@ens.uqam.ca
 * Cours : INF1120-20
 * @version 2024-02-14
 */
public class Budget {
    
    //----------
    //CONSTANTES
    //----------
    
    //Message de présentation
    public static final String MSG_PRES = "Ce programme permet la tenue d'un budget" 
        + " mensuel.\n\nAppuyez sur <ENTREE> pour continuer...";
    
    //Message de solicitation pour le mois
    public static final String MSG_SOL_MOIS = "Entrez le mois du budget : ";
    
    //Message d'erreur pour un mois invalide
    public static final String MSG_ERR_MOIS = "Mois invalide." 
        + " Saisir une valeur entre 1 et 12... Recommencez !";
        
    //Bornes de validation pour le mois
    public static final int MOIS_MIN = 1;
    public static final int MOIS_MAX = 12;
    
    //Message de solicitation pour l'année
    public static final String MSG_SOL_ANNEE = "Entrez l'annee du budget : ";
    
    //Message d'erreur pour une annee invalide
    public static final String MSG_ERR_ANNEE = "Annee invalide." 
        + " Saisir une valeur entre 2024 et 9999... Recommencez !";
    
    //Bornes de validation pour l'année
    public static final int ANNEE_MIN = 2024;
    public static final int ANNEE_MAX = 9999;
        
    //Menu
    public static final String MENU = "1. Entrer des revenus\n" 
        + "2. Entrer des depenses\n" + "3. Afficher le bilan\n" 
        + "4. Reinitialiser le bilan\n" + "5. Quitter";
        
    //Message de solicitation au menu
    public static final String MSG_SOL_MENU = "Entrez votre choix : ";

    //Message d'erreur menu
    public static final String MSG_ERR_MENU = "Menu invalide." 
        + "Saisir une valeur entre 1 et 5... Recommencez !";
        
    //Message de solicitation de revenus (Option 1)
    public static final String MSG_SOL_REV = "Entrez le montant du revenu" 
        + " (0 pour terminer) : ";
    
    //Message d'erreur pour le revenu (Option 1)
    public static final String MSG_ERR_REV = "Montant invalide." 
        + "Saisir une valeur superieure ou egale a 0... Recommencez !";
    
    //Revenu minimale (Option 1)
    public static final int REV_MIN = 0;
        
    //Message de solicitation des depenses (Option 2)
    public static final String MSG_SOL_DEP = "Entrez le montant de la depense" 
        + " (0 pour terminer) : ";
    
    //Message d'erreur pour les dépenses (Option 2)
    public static final String MSG_ERR_DEP  = "Montant invalide." 
        + "Saisir une valeur superieure ou egale a 0... Recommencez !";
    
    //Dépenses minimales (Option 2)
    public static final int DEP_MIN = 0;
        
    //Solde minimale (Option 3)
    public static final int SOLDE_MIN = 0;
    
    //Pourcentage minimale (Option 3)
    public static final int POURCENTAGE_MIN = 0;
    
    //Retour au menu (Option 3)
    public static final String RETOUR_MENU = "Appuyez sur <ENTREE> pour continuer...";
    
    //Message de reinitialisation (Option 4)
    public static final String MSG_REINIT = "LE BUDGET A ETE REINITIALISE.";
    
    //Message de fin
    public static final String MSG_FIN = "AUREVOIR !";
    
    /**
    * Application de calcul de budget mensuel pour un mois et une année donnés
    * ainsi que selon des revenus et des dépenses entrés par un utilisateur.
    * @param params (aucun)
    */
    
    public static void main(String[] params) {
        //declaration des variables
        int mois;                            //le nombre sélectionné pour représenter le mois (1 à 12) au début du programme
        int annee;                           //l'année sélectionnée au début de programme
        char choixMenu;                      //le nombre (1 à 5) sélectionné dans le menu
        double revenus = 0;                  //montant entré pour chaque revenu dans l'option 1
        double depenses = 0;                 //le montant entré pour chaque dépense dans l'option 2
        double solde = 0;                    //la différence entre les revenus et les dépenses
        double revenusTotaux = 0;            //La somme des revenus entrés dans l'option 1
        double depensesTotales = 0;          //La somme des dépenses entrées dans l'option 2
        double pourcentageDepenses = 0;      //Le pourcentage de depenses du revenu total
        String moisEcrit;                    //le mois correspondant au nombre entré au début du programme
           
        //Presentation du logiciel 
        System.out.println(MSG_PRES);
        Clavier.lireFinLigne();
       
        //Solicitation du mois et vérification
        do {
            System.out.print(MSG_SOL_MOIS);
            mois = Clavier.lireInt();
            if (mois < MOIS_MIN || mois > MOIS_MAX){
                System.out.println("\n" + MSG_ERR_MOIS);
            } //fin if
        } while (mois < MOIS_MIN || mois > MOIS_MAX); //fin while
       
        //Solicitation de l'année et vérification
        do {
            System.out.print(MSG_SOL_ANNEE);
            annee = Clavier.lireInt();
            if (annee < ANNEE_MIN || annee > ANNEE_MAX){
                System.out.println("\n" + MSG_ERR_ANNEE);
            } //fin if
        } while (annee < ANNEE_MIN || annee > ANNEE_MAX); //fin while
       
        //Affichage du menu
        //Affichage du nom du mois correspondant à la variable mois
        if (mois == 1) {
            moisEcrit = "JANVIER";
        } else if (mois == 2) {
            moisEcrit = "FEVRIER";
        } else if (mois == 3) {
            moisEcrit = "MARS";
        } else if (mois == 4) {
            moisEcrit = "AVRIL";
        } else if (mois == 5) {
            moisEcrit = "MAI";
        } else if (mois == 6) {
            moisEcrit = "JUIN";
        } else if (mois == 7) {
            moisEcrit = "JUILLET";
        } else if (mois == 8) {
            moisEcrit = "AOUT";
        } else if (mois == 9) {
            moisEcrit = "SEPTEMBRE";
        } else if (mois == 10) {
            moisEcrit = "OCTOBRE";
        } else if (mois == 11) {
            moisEcrit = "NOVEMBRE";
        } else {
            moisEcrit = "DECEMBRE";
        } //fin if
           
        do {
            System.out.println("\n-----------------------\n" + "BUDGET - " 
                + moisEcrit + " " + annee + "\n-----------------------");
            System.out.println(MENU);
            System.out.print("\n" + MSG_SOL_MENU);
            choixMenu = Clavier.lireCharLn();
           
            //Option 1 : Revenus
            if (choixMenu == '1') {
                do {
                    do {
                        System.out.print(MSG_SOL_REV);
                        revenus = Clavier.lireDouble();
                        if (revenus < REV_MIN){
                            System.out.println("\n" + MSG_ERR_REV);
                        } //fin if
                    } while (revenus < REV_MIN); //fin while
                    revenusTotaux = revenusTotaux + revenus;
                }while (revenus != 0); //fin while
           
            //Option 2 : Dépenses
            }else if (choixMenu == '2'){
                 do {
                     do {
                         System.out.print(MSG_SOL_DEP);
                         depenses = Clavier.lireDouble();
                         if (depenses < DEP_MIN) {
                             System.out.println("\n" + MSG_ERR_DEP);
                         } //fin if
                     } while (depenses < DEP_MIN); //fin while
                     depensesTotales = depensesTotales + depenses;
                 }while (depenses != 0); //fin while
               
            //Option 3 : Bilan
            } else if (choixMenu == '3') {
                solde = revenusTotaux - depensesTotales;
                System.out.println("\nBILAN\n--------------------------------------" 
                    + "---------------------");
                System.out.printf("%18s |%18s |%18s\n", "REVENUS", "DEPENSES", "SOLDE");
                System.out.println("-------------------------------------------------" 
                    + "----------");
                System.out.printf("%16.2f $ |%16.2f $ |%16.2f $\n", revenusTotaux,
                    depensesTotales, solde);
                System.out.println("------------------------------------------" 
                    + "-----------------");
                if (depensesTotales == DEP_MIN && revenusTotaux == REV_MIN) {
                    pourcentageDepenses = POURCENTAGE_MIN;
                    System.out.printf("\nVous avez depense %.2f%% de votre revenu total.\n",
                        pourcentageDepenses);
                } else if (solde >= SOLDE_MIN) {
                    pourcentageDepenses = ( depensesTotales / revenusTotaux * 100);
                    System.out.printf("\nVous avez depense %.2f%% de votre revenu total.\n",
                        pourcentageDepenses);
                } else if  (solde < SOLDE_MIN) {
                    System.out.printf("\n***ATTENTION***\n" + "Vous avez un deficit de" 
                        + " %.2f $.\n", -solde);
                } //fin if
                System.out.println(RETOUR_MENU);
                Clavier.lireFinLigne();
               
            //Option 4 : Reinitialisation
            } else if (choixMenu == '4') {
                System.out.println("\n" + MSG_REINIT);
                revenusTotaux = 0;
                revenus = 0;
                depensesTotales = 0;
                depenses = 0;
                solde = 0;
                
            //Erreur choix menu
            } else if (choixMenu != '5') {
                 do {
                     if (choixMenu < '1' | choixMenu > '5') {
                         System.out.println("\n" + MSG_ERR_MENU);
                         System.out.print(MSG_SOL_MENU);
                         choixMenu = Clavier.lireCharLn();
                     } //fin if
                 } while (choixMenu < '1' | choixMenu > '5'); //fin while
            } //fin if
        } while (choixMenu != '5'); //fin while
       
        //Option 5 : Quitter
        System.out.println("\n" + MSG_FIN);
                 
    }

}
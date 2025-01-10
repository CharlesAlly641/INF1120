
/**
 * Cette classe permet d'exécuter diverses requêtes pour rechercher des livres 
 * dans une bibliothèque (liste de livres) donnée.Elle permet de faire des recherches
* par catégorie(s), par expression dans le titre, et par auteur dans cette bibliothèque.
 *
 * @author Charles Ally 
 * Code permanent : ALLC75020409
 * Courriel : dj491943@ens.uqam.ca
 * Cours : INF1120-20
 * @version 2024-03-26
 */
public class ModuleRecherche {
    //----------
    //CONSTANTES
    //----------
    //Message de présentation
    public static final String MSG_PRES = 
        "Cette application permet d'executer diverses requetes pour rechercher des livres \n"
        + "dans une bibliotheque donnee. Elle permet plus particulierement de faire des \n" 
        + "recherches par categorie(s), par expression dans le titre, et par auteur.";
    
    //Menu
    public static final String MENU = "-----------------\n" 
        + "MENU DE RECHERCHE\n" + "-----------------\n" 
        + "1. Recherche par categorie(s)\n" 
        + "2. Recherche par titre\n" + "3. Recherche par auteur\n" 
        + "4. Quitter";
    
    //Message de sollicitation au menu
    public static final String MSG_SOL_MENU = "\n\nEntrez votre choix : ";
    
    //Message d'erreur au menu
    public static final String MSG_ERR_MENU = "Erreur, choix invalide! Recommencez...\n";
    
    //Bornes de validation au menu
    public static final String MIN_MENU = "1";
    public static final String MAX_MENU = "4";
    
    //Option au menu
    public static final String OPTION_1 = "1";
    public static final String OPTION_2 = "2";
    public static final String OPTION_3 = "3";
    public static final String OPTION_4 = "4";
    
    //Chaine vide (lorsque l'utilisateur n'entre rien)
    public static final String CHAINE_VIDE = "";
        
    //Liste des catégories (option 1)
    public static final String GENRE_1 = "SCIENCE FICTION";
    public static final String GENRE_2 = "ROMANCE";
    public static final String GENRE_3 = "THRILLER";
    public static final String GENRE_4 = "POLICIER";
    public static final String GENRE_5 = "HUMOUR";
    public static final String GENRE_6 = "DRAME";
    public static final String LISTE_CATEGORIES = "LISTE DES CATEGORIES :\n"
        + "    1. Science Fiction\n" + "    2. Romance\n"
        + "    3. Thriller\n" + "    4. Policier\n"
        + "    5. Humour\n" + "    6. Drame";
    
    //Message de confirmation du choix (option 1)
    public static final String MSG_OPTION_1 = "*** RECHERCHE PAR CATEGORIE(S) ***";
    public static final String MSG_OPTION_2 = "*** RECHERCHE PAR TITRE ***";
    public static final String MSG_OPTION_3 = "*** RECHERCHE PAR AUTEUR ***";
    
    //Message de sollicitation pour la recherche par conjonction ou disjonction (option 1)
    public static final String MSG_SOL_CONJ = "Recherche par (C)onjonction ou (D)isjonction : ";
    
    //Connecteur pour la disjonction et la conjonction (option 1)
    public static final String CONNECTEUR_DISJ = " ou ";
    public static final String CONNECTEUR_CONJ = " et ";
    
    //Message d'erreur pour la recherche par conjonction ou disjonction (option 1) 
    public static final String MSG_ERR_CONJ = "Erreur, entrez C ou D ! Recommencez...";
    
    //Bornes minimale et maximale de la recherche par conjonction ou disjonction (option 1)
    public static final String MAX_CONJ = "D";
    public static final String MIN_CONJ = "C";
    
    //Message de sollicitation pour les categories (Option 1)
    public static final String MSG_SOL_CATEGO = 
        "Entrez un numero de categorie (0 pour terminer) : ";
    
    //Message d'erreur pour les categories (Option 1)
    public static final String MSG_ERR_CATEGO = 
        "Erreur, numero de categorie invalide! Recommencez...";
    
    //Bornes minimale et maximale pour les categories (Option 1)
    public static final String MAX_CATEGO = "6";
    public static final String MIN_CATEGO = "0";
    
    //Chaine de caractere pour signifier la fin de l'entrée des categories (option 1)
    public static final String FIN_CATEGO = "0";
    
    //Message de confirmation du choix (option 2)
    public static final String RECHERCHE_ANNULEE = "RECHERCHE ANNULEE.";
    
    //Message de confirmation du titre recherché (option 2)
    public static final String REQUETE_TITRE = 
        "REQUETE : Le titre contient l'expression ";
    
    //Message de sollicitation pour le titre (option 2) 
    public static final String MSG_SOL_TITRE = 
        "Entrez le titre ou une partie du titre (<ENTREE> pour terminer) : ";
    
    //Message d'erreur pour le titre (option 2) 
    public static final String MSG_ERR_TITRE = 
        "Erreur, le titre doit contenir au moins 5 caracteres ! Recommencez...";
    
    //Nombre de caractères minimales pour le titre (option 2)
    public static final int LONG_MIN_TITRE = 5; 
    
    //Caractère pour signifier la fin (option 2)
    public static final String CHAINE_FIN_TITRE = "";
        
    //Message de pause pour l'utilisateur
    public static final String MSG_PAUSE = "Tapez <ENTREE> pour revenir au menu de recherche...";
    
    //Résultats des recherches (option 2 & 3)
    public static final String RESULTATS_RECHERCHE = "\nRESULTAT(S) DE RECHERCHE : "
        +"\n--------------------------";
    public static final String AUCUN_RESULTAT = "\nAUCUN LIVRE TROUVE.";
    
    //Message de sollicitation pour l'auteur (option 3) 
    public static final String MSG_SOL_AUTEUR = 
        "Entrez le nom de l'auteur (<ENTREE> pour terminer) : ";
    
    //Message d'erreur pour l'auteur (option 3) 
    public static final String MSG_ERR_AUTEUR = 
        "Erreur, le nom de l'auteur doit contenir au moins 3 caracteres ! Recommencez...";
    
    //Nombre de caractères minimales pour l'auteur (option 3)
    public static final int LONG_MIN_AUTEUR = 3; 
    
    //Message de confirmation de l'auteur recherché (option 3)
    public static final String REQUETE_AUTEUR = "REQUETE : Le nom de l'auteur est ";
    
    //Caractère pour signifier la fin (option 3)
    public static final String CHAINE_FIN_AUTEUR = "";
    
    //Message de requete 
    public static final String REQUETE = "\nREQUETE : ";
        
    //Message de fin
    public static final String MSG_FIN = "AUREVOIR !";
    
    
    //Ce bloc de methodes contient des methodes generales
    /**
     * Cette methode affiche un message de presentation.
     */
    public static void afficherPres() {
        System.out.println(MSG_PRES);
        System.out.println();
        System.out.println();
    }
           
    /**
     * Cette methode affiche un menu de 4 options.
     */
    public static void afficherMenu ( ) {
        System.out.println (MENU);
        System.out.println();
    } 
    
    /**
     * Cette methode affiche la confirmation d'un choix au menu.
     * @param type le type de recherche que l'utilisateur effectue.
     */
    public static void confirmationRecherche(String type) {
        switch (type) {
            case ("1") :
                System.out.println(MSG_OPTION_1);
                break;
            case ("2") :
                System.out.println(MSG_OPTION_2);
                break;
            case ("3") :
                System.out.println(MSG_OPTION_3);
                break;
        }
        System.out.println();
    }
     
    /**
     * Cette methode marque une pause en demandant a l'utilisateur
     * d'appuyer sur la touche [ENTREE] pour continuer. 
     * @param msg le message affiché pour inciter l'utilisateur 
     * à peser sur [ENTREE].
     */
    public static void pause(String msg) { 
         System.out.print(msg);
         System.out.println();
         System.out.println();
         Clavier.lireFinLigne(); 
    }   
    
    /**
     * Cette methode affiche un message disant à l'utilisateur
     * d'appuyer sur entrée pour continuer si une recherche a eu lieu.
     * @param s la chaine de caractere entrée par l'utilisateur.
     */
    public static void afficherPause (String s) {
        if (!s.equals(CHAINE_VIDE)) {
            pause("\n" + MSG_PAUSE);
        } //fin if
    }
    
    /**
     * Cette methode affiche un message de fin du programme.
     */
    public static void afficherFinProg() {
        System.out.println("\n" + MSG_FIN);
    }
    
    /**
     * Cette methode formate la reponse sous la forme désirée.
     * @param titre le titre du livre analysé.
     * @param date la date de publication du livre analysé.
     * @param auteurSubString le nom de l'auteur du livre analysé.
     * @param genre le(s) genre(s) contenus dans le livre analysé.
     */
    public static void formater (String titre, String date, 
        String auteurSubString, String genre) {
        System.out.println("- " + titre.toUpperCase() + " (" + date + "), " 
                        + auteurSubString.toUpperCase() + " [ " 
                        + genre.toLowerCase() + " ] "); 
    }
                    
    /**
     * Cette methode affiche une requete unique entre par l'utilisateur.
     * @param entréUtilisateur l'entré par l'utilisateur.
     * @param msgRequete le message confirmant la requete.
     * @param chaineFin le caractere qui signifie la fin de l'annulation d'une requete.
     * @return la chaine de caractere representant le nom de l'auteur.
     */
    public static String requete(String entreUtilisateur, String msgRequete,
        String chaineFin) {
        if (!entreUtilisateur.equals(chaineFin)) {
            System.out.println(msgRequete + entreUtilisateur.toUpperCase());
        } //fin if
        return entreUtilisateur;
    }
    
    /**
     * Cette methode donne la sous chaine contenant le titre d'un livre.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param debut l'indice du premier caractere de la ligne analysée.
     * @param fin l'indice du dernier caractere de la ligne analysée.
     * @return la sous chaine contenant le titre du livre.
     */
    public static String titre (String biblio, int debut, int fin){
        String titre;       //le titre du livre
        titre = biblio.substring(debut, biblio.indexOf("\t", debut + 1)).trim();
        return titre;
    }
    
    /**
     * Cette methode donne la sous chaine contenant la date de publication
     * d'un livre.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param debut l'indice du premier caractere de la ligne analysée.
     * @param fin l'indice du dernier caractere de la ligne analysée.
     * @return la sous chaine contenant la date de publication du livre.
     */
    public static String date (String biblio, int debut, int fin){
        String date;        //la date de publication du livre
        date = biblio.substring(biblio.indexOf("\t", biblio.indexOf("\t",
            debut + 1) + 1), biblio.indexOf("\t", biblio.indexOf("\t",
            biblio.indexOf("\t", debut + 1) + 1) + 1)).trim();
        return date;
    }
    
    /**
     * Cette methode donne la sous chaine contenant les initiales du
     * prenom et le nom de l'auteur d'un livre.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param debut l'indice du premier caractere de la ligne analysée.
     * @param fin l'indice du dernier caractere de la ligne analysée.
     * @return la sous chaine contenant le nom de l'auteur du livre.
     */
    public static String auteur (String biblio, int debut, int fin){
        String auteur;      //le prenom et nom de l'auteur d'un livre
        auteur = biblio.substring(biblio.indexOf("\t", debut + 1) + 1, 
            biblio.indexOf("\t", biblio.indexOf("\t", debut + 1) + 1)).trim();
        return auteur;
    }
    
    /**
     * Cette methode donne la sous chaine contenant le nom de l'auteur.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param debut l'indice du premier caractere de la ligne analysée.
     * @param fin l'indice du dernier caractere de la ligne analysée.
     * @return la sous chaine contenant le nom de l'auteur du livre.
     */
    public static String nomAuteur(String biblio, int debut, int fin) {
        String auteurSubString;     //le prenom et nom de l'auter
        int dernierEspace;
        String auteur;              //le nom de l'auteur
        auteurSubString = auteur(biblio, debut,fin);
        dernierEspace = auteurSubString.lastIndexOf(" ");
        auteur = auteurSubString.substring(dernierEspace + 1);
        return auteur;
    }
    
    /**
     * Cette methode donne la sous chaine contenant le(s) genre(s)
     * d'un livre.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param debut l'indice du premier caractere de la ligne analysée.
     * @param fin l'indice du dernier caractere de la ligne analysée.
     * @return la sous chaine contenant le(s) genre(s) du livre.
     */
    public static String genre (String biblio, int debut, int fin){
        String genre;       //le(s) genre(s0 d'un livre
        genre = biblio.substring(biblio.indexOf("\t", biblio.indexOf("\t", 
            biblio.indexOf("\t", debut + 1) + 1) + 1) + 1, 
            biblio.indexOf("\n", debut + 1)).trim().replace("\t", ", ");
        return genre;
    }
    
    //Ce bloc de methodes contient des boucles de validation
    /**
     * Cette methode saisit et valide une chaine de caractere ignorant si les
     * lettres sont des majuscules ou des minuscules et se trouvant entre des 
     * bornes de longueur 1.
     * @param msgSoll le message de sollicitation pour la chaine de caractere.
     * @param msgErr le message d'erreur pour une chaine de caractere invalide.
     * @param stringMin la borne inferieure d'une chaine de caractere valide.
     * @param stringMax la borne superieure d'une chaine de caractere valide.
     * @return la chaine de caractere saisi et valide.
     * 
     */
    public static String validerString (String msgSoll, String msgErr, 
        String stringMin, String stringMax) {
        //declaration des variables
        String s;
        //Boucle de validation
        do {
            //solicitation et validation d'une valeur
            System.out.print(msgSoll);
            s = Clavier.lireString().toUpperCase();
            if (s.length() > 1) {
                System.out.println(msgErr);
            } else if (s.compareTo(stringMax) > 0) {
                System.out.println(msgErr);
            } else if (s.compareTo(stringMin) < 0) {
                System.out.println(msgErr);
            } //fin if
        } while (s.compareTo(stringMin) < 0 
                || s.compareTo(stringMax) > 0 || s.length() > 1); //fin while
        System.out.println();
        return s;
    }
    
    /**
     * Cette methode saisit et valide une chaine de caractere entre stringMin et stringMax
     * de longueur 1 inclusivement tant que l'utilisateur n'entre pas fin. 
     * S'il entre la valeur fin avant toute valeur valide, le programme affiche msgFin.
     * @param msgSoll le message de sollicitation pour la chaine de caractere.
     * @param msgErr le message d'erreur pour une chaine de caractere invalide.
     * @param msgFin le message de fin pour aucune valeur valide.
     * @param stringMin la borne inferieure d'une chaine de caractere valide.
     * @param stringMax la borne superieure d'une chaine de caractere valide.
     * @param stringFin la chaine qui termine le programme.
     * @return l'ensemble des valeurs valides saisies sous forme de chaine de caractere.
     */
    public static String validerStringFin (String msgSoll, String msgErr, String msgFin, 
        String stringMin, String stringMax, String stringFin) {
        //declaration des variables
        String s;
        String option = "";
        int tentative = 0;
        //boucle de validation
        do {
            tentative ++;
            //solicitation et validation de la chaine de caractere
            System.out.print(msgSoll);
            s = Clavier.lireString();
            //entrée de la valeur stringFin lors à la première saisie
            if (s.compareTo(stringFin) == 0 && tentative == 1) { 
                System.out.println();
                System.out.println(msgFin);
                System.out.println();
                System.out.println();
            } //fin if
            //valeur invalide
            while (s.length() > 1 || s.compareTo(stringMax) > 0 
                || s.compareTo(stringMin) < 0) { 
                System.out.println("\n" + msgErr);
                System.out.print(msgSoll);
                s = Clavier.lireString();
                //entrée de la valeur stringFin avant une valeur valide
                if (s.compareTo(stringFin) == 0 && tentative == 1) { 
                    System.out.println();
                    System.out.println(msgFin);
                    System.out.println();
                    System.out.println();
                } //fin if
            } //fin while
            option = option + s;
        } while (!(s.length() > 1 || s.compareTo(stringMax) > 0 
                || s.compareTo(stringMin) < 0 || s.compareTo(stringFin) == 0)); //fin while
        return option;
    }
    
    /**
     * Cette methode saisit et valide l'entrée d'une chaine de caractere de
     * longueur minimale longMin. Le programme se termine si fin est entrée
     * par l'utilisateur.
     * @param msgSoll le message de sollicitation pour la chaine de caractere.
     * @param msgErr le message d'erreur pour une chaine de caractere invalide.
     * @param msgFin le message affichée lorsque fin est entrée.
     * @param longMin la longueur minimale de la chaine de caractere.
     * @param fin la chaine de caractere qui doit etre entré pour terminer le programme.
     * @return la chaine de caractere saisie et valide.
     */
    public static String validerStringLong (String msgSoll, String msgErr, 
        String msgFin, int longMin, String fin) {
        //declaration des variables
        String s;
        //saisie et validation de la chaine de caractere entrée
        System.out.print(msgSoll);
        s = Clavier.lireString();
        //l'utilisateur entre fin
        if (s.equals(fin)) {
            System.out.println();
            System.out.println(msgFin);
            System.out.println();
        } else {
            //l'entrée de l'utilisateur ne respecte pas longMin
            while (s.length() < longMin && !s.equals(fin)) {
                System.out.println("\n" + msgErr);
                System.out.print(msgSoll);
                s = Clavier.lireString();
                //l'utilisateur entre fin avant une valeur valide
                if (s.equals(fin)) {
                    System.out.println();
                    System.out.println(msgFin);
                    System.out.println();
                } 
            }
        }   
        System.out.println();
        return s;
    }
        
    
    //Ce bloc de methodes contient les methodes utiles à l'option 1
    /**
     * Cette methode affiche la liste des categories pouvant se trouver
     * dans une ligne d'information concernant un livre.
     */
    public static void listeCategories() {
        System.out.println(LISTE_CATEGORIES);
        System.out.println();
    }
    
    /**
     * Cette methode permet à l'utilisateur de choisir une recherche
     * par conjonction/disjonction. Par la suite, il peut choisir entre 
     * plusieurs categories par lesquelles il peut rechercher des livres
     * de la bibliothèque. Il confirme ensuite et affiche sa requete.
     * @param conjonction le choix de l'utilisateur entre la recherche par
     * conjonction ou disjonction.
     * @param choixCategories la chaine de caractere correspond à tous
     * les genres valides selectionnes par l'utilisateur.
     * @return la chaine de caractere comprenant tous les genres valides 
     * selectionnés par l'utilisateur.
     */
    public static String requeteGenre(String conjonction, 
        String choixCategories) {
        //declaration des variables
        String genre = "";      //le genre représenté par la categorie selectionnee
        String requete = "";    //la requete de l'utilisateur 
        //affichage de la requete de l'utilisateur
        for (int i = 0; i <= choixCategories.length() 
                && choixCategories.charAt(i) != '0'; i++) {
            if (choixCategories.charAt(i) == '1' 
                    && !requete.contains(GENRE_1)) {
                genre = GENRE_1;
            } else if (choixCategories.charAt(i) == '2') {
                genre = GENRE_2;
            } else if (choixCategories.charAt(i) == '3') {
                genre = GENRE_3;
            } else if (choixCategories.charAt(i) == '4') {
                genre = GENRE_4;
            } else if (choixCategories.charAt(i) == '5') {
                genre = GENRE_5;
            } else if (choixCategories.charAt(i) == '6') {
                genre = GENRE_6;
            } //fin if
            if (!requete.contains(genre)) {
                requete = requete + genre + "\t";
            } //fin if
        } //fin for
        if (!requete.equals(CHAINE_VIDE)) {
            if (conjonction.equals(MAX_CONJ)) {
                requete = requete.trim().replace("\t", CONNECTEUR_DISJ);
                System.out.println(REQUETE + requete);
            } else if (conjonction.equals(MIN_CONJ)) {
                requete = requete.trim().replace("\t", CONNECTEUR_CONJ);
                System.out.println(REQUETE + requete);
            } //fin if
        } //fin if
        return requete;
    }
    
    /**
     * Cette méthode permet de savoir s'il existe des résultats à la
     * recherche par conjonction.
     * @param genreUtilisateur la requete de l'utilisateur.
     * @param genre les genres contenus sur une ligne d'information.
     * @return contientGenreC true si les genres sont contenus sur la ligne.
     */
    public static boolean resultatsConjonction (String genreUtilisateur, String genre) {
        //declaration des variables
        String genre1 = "";         //chaine pleine si genre1 inclus et chaine vide si genre exclus
        String genre2 = "";         //chaine pleine si genre2 inclus et chaine vide si genre exclus
        String genre3 = "";         //chaine pleine si genre3 inclus et chaine vide si genre exclus
        String genre4 = "";         //chaine pleine si genre4 inclus et chaine vide si genre exclus
        String genre5 = "";         //chaine pleine si genre5 inclus et chaine vide si genre exclus
        String genre6 = "";         //chaine pleine si genre6 inclus et chaine vide si genre exclus
        boolean contientGenreC = false;     //l'expression qui exprime si plusieurs genres sont contenus dans le livre
        if (genreUtilisateur.contains(CONNECTEUR_CONJ.toUpperCase())) {
                if (genreUtilisateur.contains(GENRE_1)) {
                    genre1 = GENRE_1;
                } //fin if
                if (genreUtilisateur.contains(GENRE_2)) {
                    genre2 = GENRE_2;
                } //fin if
                if (genreUtilisateur.contains(GENRE_3)) {
                    genre3 = GENRE_3;
                } //fin if
                if (genreUtilisateur.contains(GENRE_4)) {
                    genre4 = GENRE_4;
                } //fin if
                if (genreUtilisateur.contains(GENRE_5)) {
                    genre5 = GENRE_5;
                } //fin if
                if (genreUtilisateur.contains(GENRE_6)) {
                    genre6 = GENRE_6;
                } //fin if
                if ((genre.contains(genre1)) && (genre.contains(genre2)) 
                        && (genre.contains(genre3)) && (genre.contains(genre4)) 
                        && (genre.contains(genre5)) && (genre.contains(genre6))) {
                    contientGenreC = (genre.contains(genre1)) && (genre.contains(genre2)) 
                        && (genre.contains(genre3)) && (genre.contains(genre4)) 
                        && (genre.contains(genre5)) && (genre.contains(genre6)); 
                } //fin if
        } //fin if
        return contientGenreC;
    }
    
    /**
     * Cette méthode permet de savoir s'il existe des résultats à la
     * recherche par disjonction.
     * @param genreUtilisateur la requete de l'utilisateur.
     * @param genre les genres contenus sur une ligne d'information.
     * @return contientGenreD true si au moins un des genres est contenu sur la ligne.
     */
    public static boolean resultatsDisjonction (String genreUtilisateur, String genre){
        boolean contientGenreD = false;     //l'expression qui exprime si certains genres sont contenus dans le livre
        if (genreUtilisateur.contains(CONNECTEUR_DISJ.toUpperCase())) {
                if ((genre.contains(GENRE_1) && genreUtilisateur.contains(GENRE_1)) 
                        || (genre.contains(GENRE_2) && genreUtilisateur.contains(GENRE_2)) 
                        || (genre.contains(GENRE_3) && genreUtilisateur.contains(GENRE_3)) 
                        || (genre.contains(GENRE_4) && genreUtilisateur.contains(GENRE_4)) 
                        || (genre.contains(GENRE_5) && genreUtilisateur.contains(GENRE_5)) 
                        || (genre.contains(GENRE_6) && genreUtilisateur.contains(GENRE_6))){
                    contientGenreD = (genre.contains(GENRE_1) && genreUtilisateur.contains(GENRE_1)) 
                        || (genre.contains(GENRE_2) && genreUtilisateur.contains(GENRE_2)) 
                        || (genre.contains(GENRE_3) && genreUtilisateur.contains(GENRE_3)) 
                        || (genre.contains(GENRE_4) && genreUtilisateur.contains(GENRE_4)) 
                        || (genre.contains(GENRE_5) && genreUtilisateur.contains(GENRE_5)) 
                        || (genre.contains(GENRE_6) && genreUtilisateur.contains(GENRE_6));
                } //fin if
        }
        return contientGenreD;
    }
    
    /**
     * Cette méthode permet de savoir s'il existe des résultats à
     * une recherche pour un seul genre un particulier.
     * @param genreUtilisateur la requete de l'utilisateur.
     * @param genre les genres contenus sur une ligne d'information.
     * @return contientGenre true si le genre recherché est contenu sur la ligne.
     */
    public static boolean resultats (String genreUtilisateur, String genre){
        boolean contientGenre = false;      //l'expression qui exprime si un genre est contenu dans le livre
        if (genre.contains(genreUtilisateur)) {
            contientGenre = genre.contains(genreUtilisateur);
        } //fin if
        return contientGenre;
    }
    
    /**
     * Cette methode determine s'il existe des resultats à la recherche des
     * livres par categorie(s).
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param genreUtilisateur la requête correspondant au(x) genre(s) 
     * recherché(s) par l'utilisateur.
     * @return la chaine de caractere comprenant tous les genres valides 
     * selectionnés par l'utilisateur.
     */
    public static String resultatsGenre(String biblio, String genreUtilisateur) {
        //declaration des variables
        String ligne;                           //la sous chaine contenant une ligne (un livre)
        String genre;                           //la sous chaine contenant le genre du livre
        boolean contientGenreC = false;         //l'expression qui exprime si plusieurs genres sont contenus dans le livre
        boolean contientGenreD = false;         //l'expression qui exprime si certains genres sont contenus dans le livre
        boolean contientGenre = false;          //l'expression qui exprime si un genre est contenu dans le livre
        int debut = 0;                          //l'indice de debut d'une ligne
        int fin = biblio.indexOf("\n", debut + 1);   //l'indice de fin d'une ligne
        //Analyse ligne par ligne
        while (fin != -1) {
            ligne = biblio.substring(debut, fin);
            genre = genre(biblio, debut,fin);
            if (genreUtilisateur.contains(CONNECTEUR_CONJ.toUpperCase()) && !contientGenreC) {
                contientGenreC = 
                    resultatsConjonction(genreUtilisateur.toUpperCase(), genre);
            } else if (genreUtilisateur.contains(CONNECTEUR_DISJ.toUpperCase()) && !contientGenreD) {
                contientGenreD = 
                    resultatsDisjonction(genreUtilisateur.toUpperCase(), genre);
            } else if (!genreUtilisateur.equals(CHAINE_VIDE) && !contientGenre) {
                contientGenre = 
                    resultats(genreUtilisateur.toUpperCase(), genre);
            } //fin if
            debut = debut + ligne.length() + 1;
            fin = biblio.indexOf("\n", debut + 1);
        } //fin while
        if (contientGenreC || contientGenreD || contientGenre) {
            System.out.println(RESULTATS_RECHERCHE);
        } else if (!genreUtilisateur.equals(CHAINE_VIDE)) {
            System.out.println(AUCUN_RESULTAT);
        } //fin if
        return genreUtilisateur;
    }
    
    /**
     * Cette methode affiche les résultats de la recherche, soit les livres contenant les
     * genres sélectionnés dépendamment de la recherche par conjonction/disjonction.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param genreUtilisateur la requête correspondant au(x) genre(s) 
     * recherché(s) par l'utilisateur.
     * @return la chaine de caractere comprenant tous les genres valides 
     * selectionnés par l'utilisateur.
     */
    public static String afficherGenre(String biblio, String genreUtilisateur) {
        //declaration des variables
        String ligne;                         //la sous chaine contenant une ligne (un livre)
        String titre;                         //la sous chaine contenant le titre d'un livre
        String auteurSubString;               //la sous chaine contenant le prenom et nom de l'auteur
        String date;                          //la sous chaine contenant la date de publication
        String genre;                         //la sous chaine contenant le genre du livre
        boolean contientGenreC = false;       //l'expression qui exprime si plusieurs genres sont contenus dans le livre
        boolean contientGenreD = false;       //l'expression qui exprime si certains genres sont contenus dans le livre
        boolean contientGenre = false;        //l'expression qui exprime si un genre est contenu dans le livre
        int debut = 0;                        //l'indice de debut d'une ligne
        int fin = biblio.indexOf("\n", debut + 1); //l'indice de fin d'une ligne
        //Analyse ligne par ligne
        while (fin != -1) {
            ligne = biblio.substring(debut, fin);
            titre = titre (biblio, debut, fin);
            auteurSubString = auteur(biblio, debut, fin);
            date = date(biblio, debut, fin);
            genre = genre(biblio, debut,fin);
            if (genreUtilisateur.contains(CONNECTEUR_CONJ.toUpperCase())) {
                contientGenreC = 
                    resultatsConjonction(genreUtilisateur.toUpperCase(), genre);
                if (contientGenreC) {
                    formater(titre,date,auteurSubString,genre);  
                }
            } else if (genreUtilisateur.contains(CONNECTEUR_DISJ.toUpperCase())) {
                contientGenreD = 
                    resultatsDisjonction(genreUtilisateur.toUpperCase(), genre);
                if (contientGenreD) {
                    formater(titre,date,auteurSubString,genre);   
                }
            } else if (!genreUtilisateur.equals(CHAINE_VIDE)) {
                contientGenre = 
                    resultats(genreUtilisateur.toUpperCase(), genre);
                if (contientGenre) {
                    formater(titre,date,auteurSubString,genre); 
                }
            } //fin if
            debut = debut + ligne.length() + 1;
            fin = biblio.indexOf("\n", debut + 1);
        } //fin while
        return genreUtilisateur;
    }
    
    /**
     * Cette methode execute les operations de l'option 1.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     */
    public static void option1(String biblio) {
        //declaration des variables
        String conjonction;         //le choix de l'utilisateur pour la recherche par conjonction/disjonction
        String choixCategories;     //la chaine de caractere representant les categories valides selectionnes par l'utilisateur
        //option 1
        confirmationRecherche(OPTION_1);
        conjonction = validerString(MSG_SOL_CONJ, "\n" + MSG_ERR_CONJ,
            MIN_CONJ, MAX_CONJ);
        listeCategories();
        choixCategories = validerStringFin(MSG_SOL_CATEGO, MSG_ERR_CATEGO, 
            RECHERCHE_ANNULEE, MIN_CATEGO, MAX_CATEGO, FIN_CATEGO);
        afficherPause(afficherGenre(biblio, resultatsGenre(biblio,
            requeteGenre(conjonction, choixCategories).toUpperCase())));
    }
     
    //Ce bloc de methodes contient les methodes utiles à l'option 2
    /**
     * Cette methode determine si l'entree de l'utilisateur donne des 
     * resultats.
     * @param titreUtilisateur le titre entré par l'utilisateur.
     * @param titre le titre de l'oeuvre contenu sur une ligne.
     * @return contientTitre true si titreUtilisateur fait partie de titre.
     */
    public static boolean resultatsTitre (String titreUtilisateur, String titre) {
        boolean contientTitre = false;  //l'expression qui exprime si un titre contient une partie du titre recherche
        if (titre.contains(titreUtilisateur) 
                && !titreUtilisateur.equals(CHAINE_VIDE)) {
            contientTitre = titre.contains(titreUtilisateur) 
                && !titreUtilisateur.equals(CHAINE_VIDE); 
        } //fin if
        return contientTitre;
    }
    
    /**
     * Cette methode affiche s'il existe des resultats à la recherche par
     * titre.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param titreUtilisateur le segment de titre entré par l'utilisateur.
     * @return la chaine de caractere representant le titre du livre.
     */
    public static String afficherResultatsTitre (String biblio, String titreUtilisateur) {
        //declaration des variables
        String titre;                           //la sous chaine contenant le titre d'un livre
        String ligne;                           //la sous chaine contenant une ligne (un livre)
        int debut = 0;                          //l'indice de debut d'une ligne
        int fin = biblio.indexOf("\n", debut + 1);   //l'indice de fin d'une ligne
        boolean contientTitre = false;          //l'expression qui exprime si un titre contient une partie du titre recherche
        //Analyse ligne par ligne
        while (fin != -1) {
            ligne = biblio.substring(debut, fin);
            titre = titre(biblio, debut,fin);
            //determination de la presence partielle dans la bibliotheque
            if (titre.contains(titreUtilisateur) 
                    && !titreUtilisateur.equals(CHAINE_VIDE) && !contientTitre) {
                contientTitre = resultatsTitre(titreUtilisateur, titre);
            }
            debut = debut + ligne.length() + 1;
            fin = biblio.indexOf("\n", debut + 1);
        } //fin while
        if (contientTitre) {
            System.out.println(RESULTATS_RECHERCHE);
        } else if (!titreUtilisateur.equals(CHAINE_VIDE)) {
            System.out.println(AUCUN_RESULTAT);
        } //fin if
        return titreUtilisateur;
    }
    
    /**
     * Cette methode affiche les livres dont le titre contient la requete de
     * l'utilisateur.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param titreUtilisateur le segment de titre entré par l'utilisateur.
     * @return la chaine de caractere representant le titre du livre.
     */
    public static String afficherTitre(String biblio, String titreUtilisateur) {
        //declaration des variables
        String titre;                              //la sous chaine contenant le titre d'un livre
        String auteurSubString;                    //la sous chaine contenant le prenom et nom de l'auteur
        String date;                               //la sous chaine contenant la date de publication
        String genre;                              //la sous chaine contenant le genre du livre
        String ligne;                              //la sous chaine contenant une ligne (un livre)
        int debut = 0;                             //l'indice de debut d'une ligne
        int fin = biblio.indexOf("\n", debut + 1);      //l'indice de fin d'une ligne
        //Analyse ligne par ligne
        while (fin != -1) {
            ligne = biblio.substring(debut, fin);
            titre = titre(biblio, debut,fin);
            auteurSubString = auteur(biblio, debut,fin);
            date = date(biblio,debut,fin);
            genre = genre(biblio,debut,fin);
            //determination de la presence partielle dans la bibliotheque
            if (titre.contains(titreUtilisateur) 
                    && !titreUtilisateur.equals(CHAINE_VIDE)){
                formater(titre,date,auteurSubString,genre);
            } //fin if
            debut = debut + ligne.length() + 1;
            fin = biblio.indexOf("\n", debut + 1);
        } //fin while
        return titreUtilisateur;
    }
    
    /**
     * Cette methode execute les opérations de l'option 2.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     */
    public static void option2 (String biblio) { 
        //declaration des variables
        String titre;           //la saisie de l'utilisateur pour le titre
        //option 2
        confirmationRecherche(OPTION_2);
        titre = validerStringLong(MSG_SOL_TITRE, MSG_ERR_TITRE, 
            RECHERCHE_ANNULEE, LONG_MIN_TITRE, CHAINE_FIN_TITRE);
        afficherPause(afficherTitre(biblio, afficherResultatsTitre(biblio,
            requete(titre,REQUETE_TITRE, CHAINE_FIN_TITRE).toUpperCase())));
    }
    
    
    //Ce bloc de methodes contient les methodes utiles à l'option 3
    /**
     * Cette methode determine si l'entree de l'utilisateur donne des 
     * resultats.
     * @param auteurUtilisateur le nom entré par l'utilisateur.
     * @param auteur l'auteur l'oeuvre contenu sur une ligne.
     * @return auteurExiste true si auteurExiste se retrouve parmi les
     * noms des auteurs.
     */
    public static boolean resultatsAuteur (String auteurUtilisateur, String auteur) {
        boolean auteurExiste = false;   //l'expression qui exprime si l'auteur recherché existe
        if (auteur.equals(auteurUtilisateur)) {
                auteurExiste = auteur.equals(auteurUtilisateur);
            } //fin if
        return auteurExiste;
    }
    
    /**
     * Cette méthode détermine si le nom de l'auteur entré par l'utilisateur 
     * est présent dans la bibliothèque.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param auteurUtilisateur le nom d'auteur entré par l'utilisateur.
     * @return la chaine de caractere representant le nom de l'auteur.
     */
    public static String afficherResultatsAuteur(String biblio, 
        String auteurUtilisateur) { 
        //declaration des variables 
        String auteur;                          //la sous chaine contenant le nom de l'auteur
        String ligne;                           //la sous chaine contenant une ligne (un livre)
        int debut = 0;                          //l'indice de debut d'une ligne
        int fin = biblio.indexOf("\n", debut + 1);   //l'indice de fin d'une ligne
        boolean auteurExiste = false;           //l'expression qui exprime si l'auteur recherché existe
        //Analyse ligne par ligne
        while (fin != -1) {
            ligne = biblio.substring(debut, fin);
            auteur = nomAuteur(biblio,debut,fin);
            //si le nom entré par l'utilisateur correspond au nom d'un auteur dans la bibliotheque
            if (auteur.equals(auteurUtilisateur)) {
                auteurExiste = resultatsAuteur(auteurUtilisateur, auteur);
            } //fin if
            debut = debut + ligne.length() + 1;
            fin = biblio.indexOf("\n", debut + 1);
        } //fin while
        if (auteurExiste) {
            System.out.println(RESULTATS_RECHERCHE);
        } else if (!auteurUtilisateur.equals(CHAINE_VIDE)) {
            System.out.println(AUCUN_RESULTAT);
        } //fin if
        return auteurUtilisateur;
    }
    
    /**
     * Cette methode affiche les livres dont le nom de l'auteur est le même 
     * que celui figurant dans la requête de l'utilisateur.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     * @param auteurUtilisateur le nom d'auteur entré par l'utilisateur.
     * @return la chaine de caractere representant le nom de l'auteur.
     */
    public static String afficherAuteur(String biblio, String auteurUtilisateur) {
        //declaration des variables
        String auteurSubString;                 //la sous chaine contenant le prenom et nom de l'auteur
        String auteur;                          //la sous chaine contenant le nom de l'auteur
        String ligne;                           //la sous chaine contenant une ligne (un livre)
        String titre;                           //la sous chaine contenant le titre d'un livre
        String date;                            //la sous chaine contenant la date de publication
        String genre;                           //la sous chaine contenant le genre d'un livre
        int debut = 0;                          //l'indice de debut d'une ligne
        int fin = biblio.indexOf("\n", debut + 1);   //l'indice de fin d'une ligne
        //Analyse ligne par ligne
        while (fin != -1) {
            ligne = biblio.substring(debut, fin);
            auteurSubString = auteur(biblio,debut,fin);
            auteur = nomAuteur(biblio,debut,fin);
            titre = titre(biblio,debut,fin);
            date = date(biblio,debut,fin);
            genre = genre(biblio,debut,fin);
            //si le nom entré par l'utilisateur correspond au nom d'un auteur dans la bibliotheque
            if (auteur.equals(auteurUtilisateur) 
                    && !auteurUtilisateur.equals(CHAINE_VIDE)) {
                formater(titre,date,auteurSubString,genre);
            } //fin if
            debut = debut + ligne.length() + 1;
            fin = biblio.indexOf("\n", debut + 1);
        } //fin while
        return auteurUtilisateur;
    }
    
    /**
     * Cette methode execute l'option 3.
     * @param biblio la chaine de caractere representant les livres de la bibliotheque.
     */
    public static void option3 (String biblio) { 
        //declaration des variables
        String auteur;      //la saisie de l'utilisateur pour le nom de l'auteur
        //option 3
        confirmationRecherche(OPTION_3);
        auteur = validerStringLong(MSG_SOL_AUTEUR, MSG_ERR_AUTEUR, 
            RECHERCHE_ANNULEE, LONG_MIN_AUTEUR, CHAINE_FIN_AUTEUR);
        afficherPause(afficherAuteur(biblio, afficherResultatsAuteur(biblio,
            requete(auteur, REQUETE_AUTEUR, CHAINE_FIN_AUTEUR).toUpperCase())));
    }
   
    
    /**
     * Application qui permet d'exécuter diverses requêtes pour rechercher des 
     * livres dans une bibliothèque (liste de livres) donnée.  
     * @param params (aucun).
     */
    public static void main (String [] args) {
        //declaration des variables
        String choixMenu;                                         //le choix au menu de l'utilisateur
        String conjonction;                                       //le choix de l'utilisateur pour la recherche par conjonction/disjonction
        String choixCategories;                                   //la chaine de caractere representant les categories valides selectionnes par l'utilisateur
        String biblio = (UtilitaireTP2.lireBibliotheque().trim()  //la bibliotheque contenant les livres
            + "\n").toUpperCase();   
        
        //Message de presentation
        afficherPres();
        do {
            //Saisie et validation du choix au menu
            choixMenu = validerString(MENU + MSG_SOL_MENU, MSG_ERR_MENU,
                        MIN_MENU, MAX_MENU);
            //Option 1
            if (choixMenu.compareTo(OPTION_1) == 0) {
                option1(biblio);
                
            //Option 2
            } else if (choixMenu.equals(OPTION_2)) {
                option2(biblio);
                
            //Option 3
            } else if (choixMenu.equals(OPTION_3)) {
                option3(biblio);
            }
        } while (!choixMenu.equals(OPTION_4));
        
        //Option 4
        afficherFinProg();
       
    }
}
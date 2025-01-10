
/**
 * Cette classe modelise le Telephone d'un contact personnel.
 * Classe fournie dans le cadre du TP3 INF1120 H24
 * @author melanie lord
 * @version H24
 *
 * Modifications faites par :
 * Charles Ally (ALLC75020409)
 */
public class Telephone {
   
   /*************************************
    * CONSTANTE DE CLASSE
    *************************************/
   
   //Les divers types de telephones
   public static final String [] TYPES_TEL 
           = {"DOMICILE", "CELLULAIRE", "TRAVAIL", "AUTRE"};
   
   /*************************************
    * ATTRIBUTS D'INSTANCE
    *************************************/
   
   //Le nom de famille de la personne qui possede le noTel de ce Telephone
   private String nom;
   
   //Le prenom de la personne qui possede le noTel de ce Telephone
   private String prenom;
   
   //Le numero de telephone de ce Telephone. Chaine de longueur 7, 10 ou 11.
   private String noTel;
   
   //le type de ce telephone. Un entier entre 0 et TYPES_TEL.length - 1 
   //inclusivement : 0 = DOMICILE, 1 = CELLULAIRE, etc. (VOIR TYPES_TEL) 
   //Le nom du type de telephone est obtenu par TYPES_TEL[type].
   private int type;
   
   /*************************************
    * CONSTRUCTEUR
    *************************************/
   
   /**
    * Construit un objet Telephone initialise avec les valeurs donnees en 
    * parametres. 
    * 
    * @param nom le nom de famille de la personne ayant le noTel donne.
    *            Un nom valide est une chaine non null et de longueur > 0.
    * @param prenom le prenom de la personne ayant le noTel donne.
    *               Un prenom valide est une chaine non null et de longueur > 0.
    * @param noTel le numero de telephone
    *              Un noTel valide est une chaine non null et de longueur egale
    *              a 7, 10 ou 11.
    * @param type le type du numero de telephone.
    *             Un type est valide s'il se trouve entre 0 et TYPES_TEL.length - 1
    *             inclusivement. Le nom du type de telephone est obtenu par 
    *             TYPES_TEL[type].
    * @throws TelephoneInvalideException lorsqu'un des parametres est invalide.
    */
   public Telephone (String nom, String prenom, String noTel, int type)
           throws TelephoneInvalideException {
      if (nom == null || nom.length() <= 0) {
          throw new TelephoneInvalideException();    
      }
      if (prenom == null || prenom.length() <= 0) {
          throw new TelephoneInvalideException();    
      }
      if (noTel == null || (noTel.length() != 7 
              && noTel.length() != 10 && noTel.length() != 11)) {
          throw new TelephoneInvalideException();
      }
      if (!(type >= 0 && type <= TYPES_TEL.length - 1)) {
          throw new TelephoneInvalideException();    
      }
      this.nom = nom;
      this.prenom = prenom;
      this.noTel = noTel;
      this.type = type;
   }
   
   /*************************************
    * METHODES PUBLIQUES
    *************************************/

   /**
    * Permet d'obtenir le nom de famille de la personne ayant le noTel de ce
    * Telephone.
    * 
    * @return le nom de famille de la personne ayant le noTel de ce
    *         Telephone.
    */
   public String getNom() {
      return nom;
   }

   /**
    * Permet de modifier le nom de famille de la personne ayant le noTel de ce 
    * Telephone.
    * 
    * @param nom le nouveau nom de famille pour ce Telephone, s'il est valide. 
    *            Un nom de famille est valide s'il est non null et de longueur > 0.
    * @throws TelephoneInvalideException lorsque nom invalide.
    */
   public void setNom(String nom) throws TelephoneInvalideException {
      if (nom == null || nom.length() <= 0) {
          throw new TelephoneInvalideException();    
      }
      this.nom = nom;
   }

   /**
    * Permet d'obtenir le prenom de la personne ayant le noTel de ce
    * Telephone.
    * 
    * @return le prenom de la personne ayant le noTel de ce Telephone.
    */
   public String getPrenom() {
      return prenom;
   }

   /**
    * Permet de modifier le prenom de la personne ayant le noTel de ce Telephone.
    * 
    * @param prenom le nouveau prenom pour ce Telephone, s'il est valide. 
    *               Un prenom est valide s'il est non null et de longueur > 0.
    * @throws TelephoneInvalideException lorsque prenom invalide.
    */
   public void setPrenom(String prenom) throws TelephoneInvalideException {   
      if (prenom == null || prenom.length() <= 0) {
          throw new TelephoneInvalideException();    
      }
      this.prenom = prenom;
   }

   /**
    * Permet d'obtenir le numero de telephone de ce Telephone.
    * 
    * @return le numero de telephone de ce Telephone.
    */
   public String getNoTel() {
      return noTel;
   }

   /**
    * Permet de modifier le numero de ce telephone.
    * 
    * @param noTel le nouveau numero pour ce Telephone, s'il est valide. 
    *               Un numero est valide s'il est non null et de longueur 7, 10
    *               ou 11.
    * @throws TelephoneInvalideException lorsque noTel invalide.
    */
   public void setNoTel(String noTel) throws TelephoneInvalideException {
      if (noTel == null || (noTel.length() != 7 
              && noTel.length() != 10 && noTel.length() != 11)) {
          throw new TelephoneInvalideException();
      }
      this.noTel = noTel;
   }

   /**
    * Permet d'obtenir le type de ce Telephone.
    * 
    * @return le type de ce Telephone.
    */
   public int getType() {
      return type;
   }

   /**
    * Permet de modifier le type de ce Telephone.
    * 
    * @param type le nouveau type pour ce Telephone, s'il est valide. 
    *             Un type est valide s'il se trouve entre 0 et TYPES_TEL.length - 1
    *             inclusivement. 
    * @throws TelephoneInvalideException lorsque type invalide.
    */
   public void setType(int type) throws TelephoneInvalideException { 
      if (!(type >= 0 && type <= TYPES_TEL.length - 1)) {
          throw new TelephoneInvalideException();    
      }
      this.type = type;
   }
   
   /**
    * Permet d'obtenir le nom du type de ce Telephone sous forme de chaine
    * de caracteres.
    * 
    * @return le nom du type de ce Telephone.
    */
   public String getNomType() {
      return TYPES_TEL[type];
   }
   
   /**
    * Retourne une representation sous forme de chaine de caracteres de ce 
    * Telephone.
    *    Exemples : 
    *       Hugo Lafond : 746-1890 [CELLULAIRE]
    *       Hugo Lafond : (450) 746-1890 [TRAVAIL]
    *       Hugo Lafond : 1 (450) 746-1890 [DOMICILE]
    * 
    * @return une representation sous forme de chaine de caracteres de ce 
    *         Telephone.
    */
   public String toString() {
      return prenom + " " + nom + " : " + formaterNoTel() 
              + " [" + TYPES_TEL[type] + "]"; 
   }
   
   /****************************************
    * METHODE D'INSTANCE PRIVEE
    ****************************************/ 
   
   /**
    * Formate le noTel de ce Telephone selon sa longueur.
    * On suppose le noTel valide (chaine non null de longueur 7, 10 ou 11).
    * Exemples :
    *    - noTel de longueur 7 = "1234567" retourne "123-4567"
    *    - noTel de longueur 10 = "5141234567" retourne "(514) 123-4567"
    *    - noTel de longueur 11 = "15141234567" retourne "1 (514) 123-4567"
    * 
    * @return une chaine de caracteres representant le noTel formate selon sa 
    *         longueur.
    */
   private String formaterNoTel() {
      String noTelFormate;
      
      switch(noTel.length()) {
         case 7 : 
            noTelFormate = noTel.substring(0, 3) + "-" + noTel.substring(3);
            break;
         case 10 :
            noTelFormate = "(" + noTel.substring(0, 3) + ") " 
                 + noTel.substring(3, 6) + "-" + noTel.substring(6); 
            break;
         default : 
            noTelFormate = noTel.substring(0,1) + " (" + noTel.substring(1, 4) + ") " 
                 + noTel.substring(4, 7) + "-" + noTel.substring(7);
      }
      
      return noTelFormate;
   }
}


/**
 * Cette classe modelise un carnet de telephones pouvant conserver les
 * numeros de telephone de vos contacts personnels. Les telephones sont 
 * stockés dans un tableau d'objet de type Telephone.
 *
 * @author Charles Ally 
 * Code permanent : ALLC75020409
 * Courriel : dj491943@ens.uqam.ca
 * Cours : INF1120-20
 * @version 2024-04-22
 */
public class CarnetTelephones {
    //CONSTANTES DE CLASSE PUBLIQUE
    public static final int LNG_INIT_TAB = 2; //la longueur initiale du tableau
    
    //ATTRIBUTS D'INSTANCE
    private Telephone [] lesTelephones; //le carnet contenant la liste des telephones
    private int nbrTelephones;          //le nombre de telephones contenus dans le carnet
    
    //CONSTRUCTEUR
    public CarnetTelephones () {
        lesTelephones = new Telephone [LNG_INIT_TAB];
        nbrTelephones = 0;
    }
    
    //SETTERS
    public void setLesTelephones (Telephone[] lesTelephones) {
        this.lesTelephones = lesTelephones;
    }
    
    public void setNbrTelephones (int nbrTelephones) {
        this.nbrTelephones = nbrTelephones;
    }
    
    //GETTERS
    public Telephone[] getLesTelephones () {
        return lesTelephones;
    }
    
    public int getNbrTelephones () {
        return nbrTelephones;    
    }
    
    //METHODES D'INSTANCE PUBLIQUES
    /**
     * Cette methode permet d'obtenir le nombre de telephones
     * dans ce carnet de telephones.
     * @return le nombre de telephones dans le carnet.
     */
    public int obtenirTailleCarnet () {
        return getNbrTelephones();
    }
    
    /**
     * Cette methode permet d'ajouter le tel donne a ce CarnetTelephones.
     * Si tel est null, il n'est pas ajouté. La methode retourne true si le
     * telephone a bien ete ajoute, false sinon. Si tel n'est pas null, tel
     * est ajoute dans la premiere case vide à partir du debut du tableau. Si 
     * aucune place n'est disponible, le nombre de case du tableau est doublé.
     * @param tel le telephone a ajouter dans le carnet.
     * @return true si le telephone a bien ete ajoute.
     */
    public boolean ajouterTelephone (Telephone tel) {
        boolean ajout = false;
        int j = 0;
        //Le tableau est rempli
        if (nbrTelephones == lesTelephones.length) {
            doublerTableau();
        } //fin if
        if (tel == null) {
            ajout = false;
        } else {
            //Identification de la premiere case null
            while (j < lesTelephones.length && lesTelephones[j] != null) {
                j++;
            } //fin while
            if (lesTelephones[j] == null) {
                lesTelephones[j] = tel;    
                nbrTelephones++;
                ajout = true;
            } //fin if
        } //fin if
        return ajout;
    }
    
    /**
     * Cette methode permet de supprimer le ieme telephone dans ce 
     * CarnetTelephones. Si ieme est invalide, aucun telephone n'est
     * supprime. La methode retourne true si le telephone a bien ete
     * supprime, false sinon.
     * NOTE : le ieme telephone correspond au ieme telephone non null.
     * NOTE : supprimer le telephone a un indice j consiste a lui 
     * affecter la veleur null a la case lesTelephones[j].
     * @param ieme le ieme telephone non null a supprimer.
     * @return true si le telephone a bien ete supprime.
     */
    public boolean supprimerTelephone (int ieme) {
        boolean supprime = false;
        int j;
        int telephoneNonNull;
        if (ieme >= 1 && ieme <= nbrTelephones) {
            //Identification de la ieme case non null
            telephoneNonNull = iemeCaseNonNull(ieme);
            if (telephoneNonNull == ieme) {
                j = indiceIemeCaseNonNull(ieme);
                lesTelephones[j - 1] = null;
                supprime = true;
                nbrTelephones--; 
            }
        }
        return supprime;
    }
    
    /**
     * Cette methode permet de modifier le nom de famille du ieme telephone
     * dans ce CarnetTelephones par le nouveau nom donne en parametre. Si
     * ieme n'est pas valide, la modification n'a pas lieu. La methode retourne
     * true si la modification est effectue, false sinon.
     * @param ieme le ieme telephone dont on souhaite modifier le nom.
     * @param nouveauNom le nouveau nom a assigner au ieme telephone.
     * @return true si le modification est effectue.
     */
    public boolean modifierNomTelephone (int ieme, String nouveauNom) {
        boolean modif = false;
        int telephoneNonNull;
        int j;
        if (ieme >= 1 && ieme <= nbrTelephones) {
            //Identification de la ieme case non null
            telephoneNonNull = iemeCaseNonNull(ieme);
            if (telephoneNonNull == ieme) {
                try {
                    j = indiceIemeCaseNonNull(ieme);
                    lesTelephones[j - 1].setNom(nouveauNom);
                    modif = true;
                } catch (TelephoneInvalideException e) {
                    modif = false;
                }
            }     
        }
        return modif;
    }
    
    /**
     * Cette methode permet de modifier le prenom du ieme telephone dans ce 
     * CarnetTelephones par le nouveau prenom donne en parametre. Si ieme 
     * n'est pas valide, la modification n'a pas lieu. La methode retourne
     * true si la modification est effectue, false sinon.
     * @param ieme le ieme telephone dont on souhaite modifier le prenom.
     * @param nouveauPrenom le nouveau prenom a assigner au ieme telephone.
     * @return true si le modification est effectue.
     */
    public boolean modifierPrenomTelephone (int ieme, String nouveauPrenom) {
        boolean modif = false;
        int telephoneNonNull;
        int j;
        if (ieme >= 1 && ieme <= nbrTelephones) {
            //Identification de la ieme case non null
            telephoneNonNull = iemeCaseNonNull(ieme);
            if (telephoneNonNull == ieme) {
                try {
                    j = indiceIemeCaseNonNull(ieme);
                    lesTelephones[j - 1].setPrenom(nouveauPrenom);
                    modif = true;
                } catch (TelephoneInvalideException e) {
                    modif = false;    
                }
            }     
        }
        return modif;
    }
    
    /**
     * Cette methode permet de modifier le type du ieme telephone dans ce
     * CarnetTelephone par le nouveau type donne en parametre. Si ieme 
     * n'est pas valide, la modification n'a pas lieu. La methode retourne
     * true si la modification est effectue, false sinon.
     * @param ieme le ieme telephone dont on souhaite modifier le type.
     * @param nouveauType le nouveau type a assigner au ieme telephone.
     * @return true si la modification est effectue.
     */
    public boolean modifierTypeTelephone (int ieme, int nouveauType) {
        boolean modif = false;
        int telephoneNonNull ;
        int j;
        if (ieme >= 1 && ieme <= nbrTelephones) {
            //Identification de la ieme case non null
            telephoneNonNull = iemeCaseNonNull(ieme);
            if (telephoneNonNull == ieme) {
                try {
                    j = indiceIemeCaseNonNull(ieme);
                    lesTelephones[j - 1].setType(nouveauType);
                    modif = true;
                } catch (TelephoneInvalideException e) {
                    modif = false;
                }
            }     
        }
        return modif;
    }
    
    /**
     * Cette methode permet de modifier le numero du ieme telephone dans ce
     * CarnetTelephones par le nouveau numero donne en parametre. Si ieme
     * n'est pas valide, la modification n'a pas lieu. La methode retourne
     * true si la modification est effectue, false sinon.
     * @param ieme le ieme telelphone dont on souhaite modifier le numéro.
     * @param nouveauNoTel le nouveau numero a assigner au ieme telephone.
     * @return true si la modification est effectue.
     */
    public boolean modifierNoTelephone (int ieme, String nouveauNoTel) {
        boolean modif = false;
        int telephoneNonNull;
        int j;
        if (ieme >= 1 && ieme <= nbrTelephones) {
            //Identification de la ieme case non null
            telephoneNonNull = iemeCaseNonNull(ieme);
            if (telephoneNonNull == ieme) {
                try {
                    j = indiceIemeCaseNonNull(ieme);
                    lesTelephones[j - 1].setNoTel(nouveauNoTel);
                    modif = true;
                } catch (TelephoneInvalideException e) {
                    modif = false;
                }
            }     
        }
        return modif;
    }
    
    /**
     * Cette methode permet de rechercher les telephones dont le nom ou le
     * prenom contient le motif donne. La methode retourne un tableau contenant
     * les telephones trouves. La longueur du tableau retourne est egale au 
     * nombre de telephones trouves. Si le motif est null, alors le tableau est
     * de longueur 0.
     * NOTE : les telephones dans le tableau retourne doivent conserver l'ordre
     * dans lequel ils apparaissent dans le tableau lesTelephones.
     * @param motif le motif a trouver dans le nom ou prenom des telephones a
     * retourner.
     * @return un tableau contenant les telephones trouves.
     */
    public Telephone [] rechercherTelephones (String motif) {
        Telephone [] tab = {};
        int nbr = 0;
        int j = 0;
        if (motif != null && motif.length() != 0) {
            motif = motif.toLowerCase();
            //Parcours du tableau pour identifier le nombre de resultats
            for (Telephone tel : lesTelephones) {
                if (tel != null && (tel.getPrenom().toLowerCase().contains(motif) 
                        || tel.getNom().toLowerCase().contains(motif))) {
                    nbr++;
                }  
            }
            tab = new Telephone [nbr];
            //Insertion des resultats dans le nouveau tableau
            for (Telephone tel : lesTelephones) {
                if (tel != null && (tel.getPrenom().toLowerCase().contains(motif) 
                        || tel.getNom().toLowerCase().contains(motif))) {
                    tab[j] = tel;
                    j++;
                }
            }
        }
        return tab;
    }
    
    /**
     * Cette methode permet d'obtenir le ieme telephone dans ce CarnetTelephones.
     * Si ieme n'est pas valide, la methode retourne null.
     * @param ieme le ieme telephone du carnet a retourner.
     * @return le ieme telephone contenu dans le CarnetTelephones.
     */
    public Telephone obtenirTelephone (int ieme) {
        boolean modif = false;
        int telephoneNonNull;
        int j;
        Telephone tel = null;
        if (ieme >= 1 && ieme <= nbrTelephones) {
            //Identification de la ieme case non null
            telephoneNonNull = iemeCaseNonNull(ieme);
            if (telephoneNonNull == ieme) {
                j = indiceIemeCaseNonNull(ieme);
                tel = lesTelephones[j - 1];
            }     
        }
        return tel;
    }
    
    /**
     * Cette methode supprime tous les telephones de ce CarnetTelephones.
     * Après l'appel de cette methode, le carnet est vide et sa taille est
     * de 0.
     * NOTE : supprimer le telephone a un indice j consiste a lui 
     * affecter la valeur null a la case lesTelephones[j].
     */
    public void viderCarnet () {
        nbrTelephones = 0;
        for (int i = 0; i < lesTelephones.length; i++) {
            lesTelephones[i] = null;    
        }
    }
    
    /**
     * Cette methode ajoute, dans ce carnet de telephones, tous les telephones
     * (non null) contenus dans autreCarnet. Les telephones sont ajoutes dans ce
     * carnet dans l'ordre où ils apparaissent dans autreCarnet. Si autreCarnet
     * est null, la methode ne fait rien et ce CarnetTelephones demeure inchange.
     * @param autreCarnet le carnet a fusionner avec ce CarnetTelephones.
     */
    public void fusionnerCarnets (CarnetTelephones autreCarnet) {
        if (autreCarnet != null) {
            for (Telephone tel : autreCarnet.lesTelephones) {
                if (tel != null) {
                    this.ajouterTelephone(tel);
                }
            }
        }
    }
    
    //AUTRES METHODES D'INSTANCE PRIVEES
    /**
     * Cette methode double la taille du tableau lesTelephones.
     */
    private void doublerTableau () {
        Telephone [] tab = new Telephone [2 * lesTelephones.length];
        for (int i = 0; i < lesTelephones.length; i++) {
            tab[i] = lesTelephones[i];    
        }
        lesTelephones = tab;
    }
    
    /**
     * Cette methode permet de trouver la ieme case non null du tableau
     * lesTelephones. Elle incremente le nombre de telephone non null chaque
     * fois que la case est non null jusqu'a ce que ce nombre corresponde 
     * jusqu'a l'indice ieme donné en parametre ou jusqu'a ce qu'on rencontre
     * la fin du tableau. 
     * @int ieme le ieme telephone du carnet a retourner.
     * @return telephoneNonNull le nombre de telephone non null rencontré.
     */
    private int iemeCaseNonNull (int ieme) {
        int telephoneNonNull = 0;
        int j = 0;
        while (telephoneNonNull != ieme && j < lesTelephones.length) {
            if (lesTelephones[j] != null) {
                telephoneNonNull++;
            }
            j++;
        }    
        return telephoneNonNull;
    }
    
    /**
     * Cette methode permet de trouver la ieme case non null du tableau 
     * lesTelephones. Elle permet aussi de connaitre l'indice de la
     * position de la case correspondant a la position du ieme telephone + 1.
     * @int ieme le ieme telephone du carnet a retourner.
     * @return j l'indice de la case où la boucle arrête de tourner.
     */
    private int indiceIemeCaseNonNull (int ieme) {
        int telephoneNonNull = 0;
        int j = 0;
        while (telephoneNonNull != ieme && j < lesTelephones.length) {
            if (lesTelephones[j] != null) {
                telephoneNonNull++;
            }
            j++;
        }    
        return j;
    }
}

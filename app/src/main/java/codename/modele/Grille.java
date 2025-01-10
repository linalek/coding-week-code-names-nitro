package codename.modele;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Objet grille
 */
public class Grille {
    private int nbRouge;
    private int nbBleue;
    private int taille; // la longueur et largeur de notre grille carrée.
    private int type; // type vaut 0 si on joue en mots, et il vaut 1 si on joue en image.
    private Tuile[][] tableauTuiles;
    List<Integer> repartitionTuiles;  //liste des affectations des tuiles
    private List<String> motUtilises; // liste de mot déjà utilisés dans la partie.
    List<String> listOfThemes;

    public Grille(int taille, int type, List<String> listOfThemes){
        this.taille = taille;
        this.type = type;
        this.tableauTuiles = null;
        this.listOfThemes = listOfThemes;
        this.motUtilises = new ArrayList<>();
        repartitionTuiles = createRepartitionTuiles();
        createTableauTuiles();
    }

    public Grille( int taille, int type){
        this.taille = taille;
        this.type = type;
        this.repartitionTuiles = createRepartitionTuiles();
        this.motUtilises = new ArrayList<>();
        this.tableauTuiles = null;
        this.listOfThemes = null;
        this.motUtilises = new ArrayList<>();
        repartitionTuiles = createRepartitionTuiles();
        createTableauTuiles();

    }

    public Grille( int type){
        this.taille = 5;
        this.type = type;
        this.tableauTuiles = null;
        this.listOfThemes = null;
        this.motUtilises = new ArrayList<>();
        repartitionTuiles = createRepartitionTuiles();
        createTableauTuiles();
    }

    public Grille(){
        this.taille = 5;
        this.type = 0;
        repartitionTuiles = createRepartitionTuiles();
        this.tableauTuiles = null;
        this.listOfThemes = null;
        this.motUtilises = new ArrayList<>();
        createTableauTuiles();
    }

    /*
     * Créer une liste de tuiles avec des -1,0,1 ou 2 selon la couleur (assassin, blanche, bleu ou rouge).
     * Renvoie cette liste avec une repartition de 70% de tuiles bleues/rouges, 1 tuile assassin
     * et le reste en tuiles blanches.
    */
    public List<Integer> createRepartitionTuiles(){
        int totalTuiles = taille * taille;
        this.nbRouge = (int) (totalTuiles * 0.35);
        this.nbBleue = (int) (totalTuiles * 0.35)+1;
        int nbNoire = 1;
        int nbBlanche = totalTuiles - (nbRouge + nbBleue + nbNoire);

        List<Integer> repartitionTuiles = new ArrayList<>();
        for (int i = 0; i < nbBlanche; i++){
            repartitionTuiles.add(0);
        }
        for (int i = 0; i < nbRouge; i++){
            repartitionTuiles.add(2);
        }
        for (int i = 0; i < nbBleue; i++){
            repartitionTuiles.add(1);
        }
        repartitionTuiles.add(-1); // Adding the single black tile
        Collections.shuffle(repartitionTuiles);
        return repartitionTuiles;
    }

    public int getTaille(){
        return taille;
    }
    public Tuile[][] getTableauTuiles(){
        if (tableauTuiles == null){
            createTableauTuiles();
        }
        return tableauTuiles;
    }
/*
createTableauTuiles créé le tableau de tuiles en fonction de si on joue en mode image ou en mode mot.
 */
    public void createTableauTuiles(){
        tableauTuiles = new Tuile[taille][taille];
        motUtilises.clear();
        if (type == 1){
            for (int i = 0; i < taille; i++){
                for (int j = 0; j < taille; j++){
                    tableauTuiles[i][j]= configurerTuileImage();
                }
            }
        }
        else {
            for (int i = 0; i < taille; i++){
                for (int j = 0; j < taille; j++){
                    tableauTuiles[i][j]= configurerTuileMot();
                }
            }
        }
    }


    public TuileImage configurerTuileImage(){
        int equipe = repartitionTuiles.removeFirst();
        TuileImage myTuile = new TuileImage(equipe);
        String mot;
        do {
            myTuile.setRandomImageAdress(listOfThemes);
            mot = myTuile.getImageAdress();
        } while (motUtilises.contains(mot));
        motUtilises.add(mot);
        myTuile.setRandomImageAdress();
        return myTuile;
    }

    /*
     * Méthode qui assigne un mot à une tuile et l'ajoute à la liste de mots déjà utilisés.
    */
    public TuileMot configurerTuileMot(){
        int equipe = repartitionTuiles.removeFirst();
        TuileMot myTuile = new TuileMot(equipe);
        String mot;
        do {
            myTuile.setRandomMot(listOfThemes);
            mot = myTuile.getMot();
        } while (motUtilises.contains(mot));
        motUtilises.add(mot);
        return myTuile;
    }

    public int getNbBleue() {
        return nbBleue;
    }
    public int getNbRouge() {
        return nbRouge;
    }
    public Tuile getTuile(int i, int j){
        return tableauTuiles[i][j];
    }
    public void setTuile(int i, int j, Tuile tuile){
        tableauTuiles[i][j] = tuile;
    }
}

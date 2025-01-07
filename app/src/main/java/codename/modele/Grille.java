package codename.modele;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Grille {
    private int nbRouge;
    private int nbBleue;
    private final int taille; // la longueur et largeur de notre grille carrée.
    private final int type; // type vaut 0 si on joue en mots, et il vaut 1 si on joue en image.
    private Tuile[][] tableauTuiles;
    List<Integer> repartitionTuiles;  //liste des affectations des tuiles

    public Grille(int taille, int type){
        this.taille = taille;
        this.type = type;
        repartitionTuiles = createRepartitionTuiles();
        this.tableauTuiles = null;
    }

    /*
     * Créer une liste de tuiles avec des -1,0,1 ou 2 selon la couleur (assassin, blanche, bleu ou rouge).
     * Renvoie cette liste avec une repartition de 70% de tuiles bleues/rouges, 1 tuile assassin
     * et le reste en tuiles blanches.
    */
    public List<Integer> createRepartitionTuiles(){
        int totalTuiles = taille * taille;
        this.nbRouge = (int) (totalTuiles * 0.35);
        this.nbBleue = (int) (totalTuiles * 0.35);
        int nbNoire = 1;
        int nbBlanche = totalTuiles - (nbRouge + nbBleue + nbNoire);

        List<Integer> repartitionTuiles = new ArrayList<>();
        for (int i = 0; i < nbBlanche; i++){
            repartitionTuiles.add(0);
        }
        for (int i = 0; i < nbRouge; i++){
            repartitionTuiles.add(1);
        }
        for (int i = 0; i < nbBleue; i++){
            repartitionTuiles.add(2);
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

    public void createTableauTuiles(){
        tableauTuiles = new Tuile[taille][taille];
        if (type == 1){
            for (int i = 0; i < taille; i++){
                for (int j = 0; j < taille; j++){
                    ajouterTuileImage();
                }
            }
        }
        else {
            for (int i = 0; i < taille; i++){
                for (int j = 0; j < taille; j++){
                    tableauTuiles[i][j]=ajouterTuileMot();
                }
            }
        }
    }

    public void ajouterTuileImage(){
        int equipe = repartitionTuiles.removeFirst();
        TuileImage myTuile = new TuileImage(equipe);
        myTuile.setRandomImageAdress();


    }

    public TuileMot ajouterTuileMot(){
        int equipe = repartitionTuiles.removeFirst();
        TuileMot myTuile = new TuileMot(equipe);
        myTuile.setRandomMot();
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
}

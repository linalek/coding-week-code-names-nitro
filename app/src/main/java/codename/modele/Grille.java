package codename.modele;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Grille {
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
        int equipeA = (taille*taille*100)/70;
        equipeA = (equipeA/2)*2;
        int equipeB = equipeA+1;
        int blanche = taille - (equipeA + equipeB + 1);
        List<Integer> repartitionTuiles = new ArrayList<>();
        for (int i = 0; i < blanche; i++){
            repartitionTuiles.add(0);
        }
        for (int i = 0; i < equipeA; i++){
            repartitionTuiles.add(1);
        }
        for (int i = 0; i < equipeB; i++){
            repartitionTuiles.add(2);
        }
        repartitionTuiles.add(-1);
        Collections.shuffle(repartitionTuiles);
        for (Integer i : repartitionTuiles){
            System.out.println(i);
        }
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

}

package codename.modele;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.File;
import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Jeu {
    private Grille grille;
    private int nbMotsBleu;
    private int nbMotsRouge;
    private int tour; // 0 pour l'équipe bleu, 1 pour l'équipe rouge
    private int tourRole; //vaut 0 pour tour de l'Espion et 1 pour tour de l'Agent
    private int statusPartie; // 0 pour partie en cours, 1 pour bleu win, 2 pour rouge win
    private int nombreTuileARretourner;
    private String indice;
    private int taille;
    private Equipe equipeRouge;
    private Equipe equipeBleue;
    private final int nombreAgentsParEquipe;
    private int timer;


    public Jeu(int taille, int type, int nombreAgentsParEquipe, int timer, List<String> listeDesThemes) {
        this.grille = new Grille(taille, type, listeDesThemes);
        this.nbMotsBleu = grille.getNbBleue();
        this.nbMotsRouge = grille.getNbRouge();
        this.tour = 0;
        this.statusPartie = 0;
        this.equipeRouge = new Equipe();
        this.equipeBleue = new Equipe();
        this.nombreAgentsParEquipe = nombreAgentsParEquipe;
        this.timer = timer;
    }

    public Jeu() {
        this.grille = new Grille(5, 0);
        this.nbMotsBleu = grille.getNbBleue();
        this.nbMotsRouge = grille.getNbRouge();
        this.tour = 0;
        this.statusPartie = 0;
        this.equipeRouge = new Equipe();
        this.equipeBleue = new Equipe();
        this.nombreAgentsParEquipe = 1;
    }

    public void changerTour() {
        tour = (tour == 0) ? 1 : 0;
    }

    /*
    checkWinner check si l'une des deux équipes a retournée toutes ses cartes.
     */
    private void updateRegularWinner() {
        if (nbMotsBleu == 0) {
            statusPartie = 1;
        } else if (nbMotsRouge == 0) {
            statusPartie = 2;
        }
    }

    public boolean isThereWinner() {
        if (statusPartie == 1 || statusPartie == 2) {
            return true;
        } else {
            return false;
        }
    }

    /*
    retournerTuile permet de mettre à jour la grille en retournant la carte en position [i][j] si elle ne l'est pas déja.
    elle met ensuite à jour le tour si la carte retournée est celle de l'autre équipe.
    elle met aussi à jour statusPartie en cas de victoire par l'une des 2 équipes, si une a retournée la carte noire ou si une a retournée toutes ses cartes.
     */
    public int retournerTuile(int i, int j) {
        Tuile theTuile = grille.getTuile(i, j);
        if (!theTuile.isEstRetournee()) {
            theTuile.setEstRetournee();
            switch (theTuile.getEquipe()) {
                case -1 -> {
                    if (tour == 0) {
                        statusPartie = 2;
                    } else {
                        statusPartie = 1;
                    }
                }
                case 0 -> changerTour();
                case 1 -> {
                    nbMotsBleu--;
                    if (tour == 1) {
                        changerTour();
                    }
                }
                case 2 -> {
                    nbMotsRouge--;
                    if (tour == 0) {
                        changerTour();
                    }
                }
            }
            updateRegularWinner();
        }
        return statusPartie;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getIndice() {
        return indice;
    }

    public Tuile getTuile(int i, int j) {
        return grille.getTuile(i, j);
    }

    public void setTuile(int i, int j, Tuile theTuile) {
        grille.setTuile(i, j, theTuile);
    }

    public int getTaille() {
        return grille.getTaille();
    }

    public void parle(String endroit) {
    }

    public int getStatusPartie() {
        return statusPartie;
    }

    public int getTour() {
        return tour;
    }

    public Equipe getEquipeBleue() {
        return equipeBleue;
    }

    public Equipe getEquipeRouge() {
        return equipeRouge;
    }
    public int getNombreAgentsParEquipe() {
        return nombreAgentsParEquipe;
    }
    public int getTimer(){
        return timer;
    }
    public void setTourRole(int tourRole) {
        this.tourRole = tourRole;
    }
    public int getTourRole(){
        return tourRole;
    }

    public static void sauvegarder(Jeu jeu, String cheminFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(cheminFichier), jeu);
    }

    public static Jeu charger(String cheminFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(cheminFichier), Jeu.class);
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }


    public void setEquipeRouge(Equipe equipeRouge) {
        this.equipeRouge = equipeRouge;
    }

    public void setNombreTuileARretourner(int nombreTuileARretourner) {
        this.nombreTuileARretourner = nombreTuileARretourner;
    }

    public int getNombreTuileARretourner() {
        return nombreTuileARretourner;
    }

    public Grille getGrille() {
        return grille;
    }
}
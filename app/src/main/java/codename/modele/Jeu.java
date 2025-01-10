package codename.modele;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

/**
 * Objet Jeu
 */
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
    private int type;
    private Equipe equipeRouge;
    private Equipe equipeBleue;
    private int nbCartes;
    private boolean modeBlitz;
    @JsonIgnore
    private Timer timer; // Timer pour le décompte
    private int timerSelected;
    private long remainingTime; // Temps restant en millisecondes (30 secondes)
    private Runnable onTimeOut; // Action à exécuter lorsque le temps est écoulé
    private Runnable onTick; // Action à exécuter à chaque tick
    private final int nombreAgentsParEquipe;

    private static final long TEMPS_PAR_TOUR = 30000; // 30 secondes

    public Jeu(int taille, int type, boolean modeBlitz, int nombreAgentsParEquipe, List<String> listeDesThemes) {
        this.grille = new Grille(taille, type, listeDesThemes);
        this.nbMotsBleu = grille.getNbBleue();
        this.nbMotsRouge = grille.getNbRouge();
        this.tour = 0;
        this.statusPartie = 0;
        this.equipeRouge = new Equipe();
        this.equipeBleue = new Equipe();
        this.modeBlitz = modeBlitz;
        this.timer = new Timer();
        this.remainingTime = TEMPS_PAR_TOUR;
        this.nombreAgentsParEquipe = nombreAgentsParEquipe;
        //this.timerSelected = timerSelected;
        this.type = type;
    }

    public Jeu(int type) {
        this.grille = new Grille(5, type);
        this.nbMotsBleu = grille.getNbBleue();
        this.nbMotsRouge = grille.getNbRouge();
        this.tour = 0;
        this.statusPartie = 0;
        this.equipeRouge = new Equipe();
        this.equipeBleue = new Equipe();
        this.modeBlitz = false;
        this.nombreAgentsParEquipe = 1;
        this.type = type;
    }
    public Jeu() {
        this.grille = new Grille(5, 0);
        this.nbMotsBleu = grille.getNbBleue();
        this.nbMotsRouge = grille.getNbRouge();
        this.tour = 0;
        this.statusPartie = 0;
        this.equipeRouge = new Equipe();
        this.equipeBleue = new Equipe();
        this.modeBlitz = false;
        this.nombreAgentsParEquipe = 1;
        this.type = 0;
    }

    public void changerTour() {
        tour = (tour == 0) ? 1 : 0;
        if (modeBlitz) {
            resetTimer();
        }
    }

    public void commencerTour(Runnable onTimeOut, Runnable onTick) {
        this.onTimeOut = onTimeOut;
        this.onTick = onTick;

        if (modeBlitz) {
            resetTimer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    remainingTime -= 1000;
                    if (remainingTime <= 0) {
                        stopTimer();
                        if (onTimeOut != null) {
                            onTimeOut.run();
                        }
                    } else if (onTick != null) {
                        onTick.run();
                    }
                }
            }, 0, 1000); // Tick toutes les secondes
        }
    }

    private void resetTimer() {
        stopTimer();
        remainingTime = TEMPS_PAR_TOUR;
    }

    public Timer getTimerBlitz() {
        return timer;
    }

    public void setTimerBlitz(Timer timer) {
        this.timer = timer;
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = new Timer();
        }
    }

    public void finirTour() {
        stopTimer();
        changerTour();
    }

    public boolean isModeBlitz() {
        return modeBlitz;
    }

    public void setModeBlitz(boolean modeBlitz) {
        this.modeBlitz = modeBlitz;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    private void updateRegularWinner() {
        if (nbMotsBleu == 0) {
            statusPartie = 1;
        } else if (nbMotsRouge == 0) {
            statusPartie = 2;
        }
    }

    public boolean isThereWinner() {
        return statusPartie == 1 || statusPartie == 2;
    }

    /**
    *retournerTuile permet de mettre à jour la grille en retournant la carte en position [i][j] si elle ne l'est pas déja.
    *Elle met ensuite à jour le tour si la carte retournée est celle de l'autre équipe.
    *Elle met aussi à jour statusPartie en cas de victoire par l'une des 2 équipes, si une a retournée la carte noire ou si une a retournée toutes ses cartes.
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


    public int getTaille() {
        return grille.getTaille();
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
        return timerSelected;
    }

    public void setTourRole(int tourRole) {
        this.tourRole = tourRole;
    }
    public int getTourRole(){
        return tourRole;
    }
    public int getType(){return type;}

    public static void sauvegarder(Jeu jeu, String cheminFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(cheminFichier), jeu);
    }

    public static Jeu charger(String cheminFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(cheminFichier), Jeu.class);
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
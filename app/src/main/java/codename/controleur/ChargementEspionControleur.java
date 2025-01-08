package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Contrôleur de la vue de chargement pour changer de joueur.
 */
public class ChargementEspionControleur {

    @FXML
    private Label tourLabel;

    @FXML
    private Button goButton;

    private GlobalControleur globalControleur;
    private int prochainTour;

    /**
     * Initialise le contrôleur.
     */
    public void initialize() {
        // Par défaut, rien n'est affiché. Le texte sera défini dynamiquement.
    }

    /**
     * Définit le contrôleur global pour naviguer entre les vues.
     * @param globalControleur Le contrôleur global de l'application.
     */
    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    /**
     * Définit le texte du tour actuel.
     * @param prochainTour Le texte indiquant quel joueur est concerné.
     */
    public void setTour(int prochainTour) {
        this.prochainTour = prochainTour;
        tourLabel.setText(prochainTour + ", c'est ton tour !");
    }
    public int getProchainTour(){
        return this.prochainTour;
    }

    /**
     * Gère l'événement lorsque le bouton "Go" est cliqué.
     */
    @FXML
    private void handleGo() {
        globalControleur.afficherEspion();
    }
}

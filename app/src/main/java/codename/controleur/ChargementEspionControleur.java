package codename.controleur;

import codename.modele.Jeu;
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
    private Jeu jeuEnCours;

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
     */
    public void setTour() {
        if (jeuEnCours.getTour()==0) {
            tourLabel.setStyle("-fx-font-size: 30px;");
            tourLabel.setText("Au tour de l'espion Bleu !");
        }
        else {
            tourLabel.setStyle("-fx-font-size: 30px;");
            tourLabel.setText("Au tour de l'espion Rouge !");
        }
    }

    /**
     * Gère l'événement lorsque le bouton "Go" est cliqué.
     */
    @FXML
    private void handleGo() {
        globalControleur.afficherEspion();
    }

    /**
     * Définit le jeu en cours.
     * @param jeuEnCours
     */
    public void setJeuEnCours(Jeu jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }
}

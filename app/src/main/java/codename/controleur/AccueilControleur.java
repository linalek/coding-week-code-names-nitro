package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

/**
 * Contrôleur pour la vue d'accueil, cela permet de gérer le passage à la vue du plateau de jeu avec l'appuie du bouton "jouer"
 */
public class AccueilControleur {
    @FXML
    public StackPane accueil;
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    public void handleJouer() {
        if (globalControleur != null) {
            globalControleur.lancerJeu();
        }
    }
}


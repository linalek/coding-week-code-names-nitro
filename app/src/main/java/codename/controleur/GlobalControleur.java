package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

/**
 * Contrôleur pour la vue principale de l'application : permet de switcher entre les différentes vues.
 */
public class GlobalControleur {

    @FXML
    private BorderPane root;

    // Initialisation du contrôleur après le chargement du fichier FXML
    @FXML
    public void initialize() {
        System.out.println("GlobalControleur initialisé.");
    }
}

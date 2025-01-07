package codename.controleur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Contrôleur pour la vue d'accueil, cela permet de gérer le passage à la vue du plateau de jeu avec l'appuie du bouton "jouer"
 */
public class AccueilControleur {
    @FXML
    public StackPane accueil;

    @FXML
    public void handleJouer() {
        try {
            // Chargez le fichier Plateau.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/codename/vue/Plateau.fxml"));
            Parent plateauView = loader.load();

            // Ajoutez la vue Plateau au StackPane
            accueil.getChildren().clear(); // Nettoie le contenu actuel
            accueil.getChildren().add(plateauView);

            System.out.println("Passage à la page Plateau.fxml");
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de Plateau.fxml : " + e.getMessage());
            e.printStackTrace();
        }
    }
}


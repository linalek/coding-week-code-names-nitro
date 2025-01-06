package codename.controleur;

import codename.vue.VuePlateau;
import javafx.stage.Stage;

public class AccueilControleur {
    private Stage primaryStage;  // Référence au Stage principal

    // Méthode pour injecter le Stage principal dans le contrôleur
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    } // Référence au Stage principal

    // Constructeur sans argument (nécessaire pour FXML)
    public AccueilControleur() {
    }

    // Constructeur pour injecter le Stage
    public AccueilControleur(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void handleJouer() {
        // Créez une instance de VuePlateau et affichez-la
        VuePlateau vuePlateau = new VuePlateau();
        vuePlateau.afficher(primaryStage);
    }
}


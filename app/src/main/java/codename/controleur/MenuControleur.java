package codename.controleur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException; 

/**
 * Contrôleur pour le menu principal de l'application : permet de gérer les actions du menu.
 */
public class MenuControleur {

    @FXML
    public MenuItem bouttonNouveau;

    @FXML
    public MenuItem bouttonRestaurer;

    @FXML
    public MenuItem bouttonSauvegarder;

    @FXML
    public MenuItem bouttonQuitter;

    @FXML
    public MenuItem bouttonBlitz;

    @FXML
    public MenuItem bouttonSolo;

    @FXML
    public MenuItem bouttonImage;

    @FXML
    public MenuItem bouttonStats;

    @FXML
    public MenuItem bouttonModif;

    @FXML
    public MenuItem bouttonRegles;

    @FXML
    public MenuItem bouttonApropos;

    @FXML
    public MenuItem bouttonCustom;
    
    @FXML
    public void partieBlitz() {
    }

    @FXML
    public void partieSolo() {
    }

    @FXML
    public void partieCustom() {
    }

    /**
     * Méthode pour affihcer les règles du jeu à partir d'un fichier HTML permettant une mise en page propre du fichier, si le fichier est introuvable, une erreur est renvoyée à l'utilisateur
     * @throws IOException si le fichier HTML des règles n'est pas trouvé
     */
    @FXML
    public void afficherRegles() {
        javafx.stage.Stage fenetreRegles = new javafx.stage.Stage();
        fenetreRegles.setTitle("Règles du Jeu");

        javafx.scene.web.WebView webView = new javafx.scene.web.WebView();

        try {
            // Chemin absolu vers le fichier (remplacez par le chemin réel sur votre machine)
            String cheminFichier = "src/main/resources/public/regles_du_jeu.html";
            File fichierHtml = new File(cheminFichier);

            // Vérifiez si le fichier existe
            if (fichierHtml.exists()) {
                webView.getEngine().load(fichierHtml.toURI().toString());
            } else {
                throw new IOException("Fichier HTML non trouvé.");
            }
        } catch (IOException e) {
            javafx.scene.control.Alert errorAlert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText("Impossible de charger les règles du jeu");
            errorAlert.setContentText("Le fichier HTML des règles est introuvable.");
            errorAlert.showAndWait();
            return;
        }

        javafx.scene.Scene scene = new javafx.scene.Scene(webView, 800, 600);
        fenetreRegles.setScene(scene);
        fenetreRegles.show();
    }

    @FXML
    public void afficherApropos() {
    }
    
    public void partieImage() {
    }
    
    @FXML
    public void quitterApplication() {
        System.exit(0);
    }
    @FXML
    public void creerNouvellePartie() {
    }

    @FXML
    public void restaurerPartie() {
    }

    @FXML
    public void sauvegarderPartie() {
    }

    /**
     * Méthode pour affihcer les statistiques du jeu
     * @throws IOException si le fichier FXML des statistiques n'est pas trouvé
     */
    @FXML
    public void afficherStats() {
        try {
            // Charger le fichier FXML pour la fenêtre de statistiques
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/codename/vue/Statistiques.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle scène avec le fichier FXML chargé
            Stage fenetreStat = new Stage();
            fenetreStat.setTitle("Statistiques du jeu");
            fenetreStat.setScene(new Scene(root, 800, 600));

            // Afficher la fenêtre
            fenetreStat.show();

        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de Statistiques.fxml : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void modifierCartes() {
    }



}

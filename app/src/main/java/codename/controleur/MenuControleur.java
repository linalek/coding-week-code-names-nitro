package codename.controleur;

import java.io.File;
import java.io.IOException;

import codename.DictionnaireThemes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

/**
 * Contrôleur pour le menu principal de l'application : permet de gérer les actions du menu.
 */
public class MenuControleur {

    @FXML
    public MenuItem bouttonRestaurer;
    
    @FXML
    public MenuItem bouttonSauvegarder;
    
    @FXML
    public MenuItem bouttonRetour;
    
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
        javafx.stage.Stage fenetreFormulaire = new javafx.stage.Stage();
        fenetreFormulaire.setTitle("Paramètres de la Partie Custom");

        javafx.scene.control.Label labelNbJoueurs = new javafx.scene.control.Label("Nombre de joueurs (1-10):");
        javafx.scene.control.Slider sliderNbJoueurs = new javafx.scene.control.Slider(1, 10, 1);
        sliderNbJoueurs.setMajorTickUnit(1);
        sliderNbJoueurs.setSnapToTicks(true);
        sliderNbJoueurs.setShowTickMarks(true);
        sliderNbJoueurs.setShowTickLabels(true);

        javafx.scene.control.Label labelTailleGrille = new javafx.scene.control.Label("Taille de la grille:");
        javafx.scene.control.TextField textFieldTailleGrille = new javafx.scene.control.TextField();

        javafx.scene.control.Label labelThemes = new javafx.scene.control.Label("Thèmes:");
        javafx.scene.control.ChoiceBox<String> choiceBoxThemes = new javafx.scene.control.ChoiceBox<>();
        choiceBoxThemes.getItems().addAll(DictionnaireThemes.getThemes());

        javafx.scene.control.Button boutonLancerPartie = new javafx.scene.control.Button("Lancer la Partie");

        // Ajouter les éléments à un layout
        javafx.scene.layout.VBox layout = new javafx.scene.layout.VBox(10);
        layout.getChildren().addAll(labelNbJoueurs, sliderNbJoueurs, labelTailleGrille, textFieldTailleGrille, labelThemes, choiceBoxThemes, boutonLancerPartie);

        // Configurer la scène et la fenêtre
        javafx.scene.Scene scene = new javafx.scene.Scene(layout, 300, 300);
        fenetreFormulaire.setScene(scene);
        fenetreFormulaire.show();

        // Ajouter un gestionnaire d'événements pour le bouton
        boutonLancerPartie.setOnAction(event -> {
            int nbJoueurs = (int) sliderNbJoueurs.getValue();
            String tailleGrille = textFieldTailleGrille.getText();
            String themeChoisi = choiceBoxThemes.getValue();

            // Lancer la partie avec les paramètres choisis
            // handleJouer(nbJoueurs, tailleGrille, themeChoisi);

            fenetreFormulaire.close();
        });
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
        javafx.stage.Stage fenetreRegles = new javafx.stage.Stage();
        fenetreRegles.setTitle("À Propos des développeurs");

        javafx.scene.web.WebView webView = new javafx.scene.web.WebView();

        try {
            String cheminFichier = "src/main/resources/public/apropos.html";
            File fichierHtml = new File(cheminFichier);

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
    public void partieImage() {
    }
    
    @FXML
    public void quitterApplication() {
        System.exit(0);
    }
    @FXML
    public void retourMenu() {
    }


    @FXML
    public void restaurerPartie() {
    }

    @FXML
    public void sauvegarderPartie() {
    }

    /**
     * Méthode pour affihcer les statistiques du jeu
     * @throws IOException ?
     */
    @FXML
    public void afficherStats() {
        javafx.stage.Stage fenetreStat = new javafx.stage.Stage();
        fenetreStat.setTitle("Statistiques du jeu");

        Label label = new Label("Bonjour, JavaFX!");

        javafx.scene.Scene scene = new javafx.scene.Scene(label, 800, 600);
        fenetreStat.setScene(scene);
        fenetreStat.show();
    }

    @FXML
    public void modifierCartes() {
    }



}

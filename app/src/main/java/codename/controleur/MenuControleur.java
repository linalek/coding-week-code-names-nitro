package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    @FXML
    public void afficherRegles() {
        // Chemin vers le fichier contenant les règles
        String cheminFichier = "public/regles_du_jeu.txt";

        try {
            // Lire le contenu du fichier
            String contenuRegles = Files.readString(Path.of(cheminFichier));

            // Afficher les règles dans une boîte de dialogue
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Règles du Jeu");
            alert.setHeaderText("Voici les règles du jeu :");
            alert.setContentText(contenuRegles);
            alert.showAndWait();
        } catch (IOException e) {
            // Gérer les erreurs si le fichier n'existe pas ou est inaccessible
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText("Impossible de charger les règles du jeu");
            errorAlert.setContentText("Vérifiez que le fichier existe et est accessible :\n" + cheminFichier);
            errorAlert.showAndWait();
        }
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

    @FXML
    public void afficherStats() {
    }

    @FXML
    public void modifierCartes() {
    }



}

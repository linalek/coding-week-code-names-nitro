package codename.controleur;

import codename.modele.Grille;
import codename.modele.Jeu;
import codename.modele.TuileMot;
import codename.modele.Tuile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Contrôleur pour la vue du plateau de jeu, cela permet de créer le plateau de jeu
 */
public class PlateauEspionControleur implements Initializable {

    @FXML
    private GridPane grilleAffichage;
    private EspionControleur espionControleur;
    private GlobalControleur globalControleur;
    private Jeu jeuEnCours;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configuration de base de la grille
        grilleAffichage.setAlignment(Pos.CENTER);
        grilleAffichage.setHgap(10);
        grilleAffichage.setVgap(10);
    }

    public void readyToContinue(){
        // Remplir la grille avec les tuiles
        mettreAJourGrille();
    }

    public void mettreAJourGrille() {
        grilleAffichage.getChildren().clear();

        for (int i = 0; i < jeuEnCours.getTaille(); i++) {
            for (int j = 0; j < jeuEnCours.getTaille(); j++) {
                TuileMot tuileMot = (TuileMot) jeuEnCours.getTuile(i,j);
                StackPane cellule = creerCellule(tuileMot);
                grilleAffichage.add(cellule, j, i);
            }
        }
    }

    private StackPane creerCellule(TuileMot tuileMot) {
        StackPane cellule = new StackPane();
        cellule.setPrefSize(150, 150); // Taille de chaque cellule

        Text texte = new Text(tuileMot.getMot());
        texte.setFill(Color.WHITE);
        texte.setFont(new Font(25));
        texte.setFont(Font.font("Arial", FontWeight.BOLD, 25));

        cellule.setStyle("-fx-background-color: " + obtenirCouleurDeFond(tuileMot.getEquipe()) + ";");
        cellule.getChildren().add(texte);
        cellule.setAlignment(Pos.CENTER);

        if ("#FFFFFF".equals(obtenirCouleurDeFond(tuileMot.getEquipe()))) {
            texte.setFill(Color.BLACK);
        } else {
            texte.setFill(Color.WHITE);
        }

        return cellule;
    }

    private String obtenirCouleurDeFond(int valeur) {
        return switch (valeur) {
            case -1 -> "#000000"; // Noir
            case 0 -> "#e0ceb3"; // Beige
            case 1 -> "#e44f43"; // Rouge
            case 2 -> "#3ca6b2"; // Bleu
            default -> "#FF8000"; // Orange par défaut
        };
    }
    public void setEspionControleur(EspionControleur espionControleur) {
        this.espionControleur = espionControleur;
    }

    public void setJeu(Jeu jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }


}

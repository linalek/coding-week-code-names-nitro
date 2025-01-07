package codename.controleur;

import codename.modele.Grille;
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
public class PlateauControleur implements Initializable {

    @FXML
    private GridPane grilleAffichage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("PlateauControleur initialisé.");
        // Configuration de base de la grille
        grilleAffichage.setAlignment(Pos.CENTER);
        grilleAffichage.setHgap(10);
        grilleAffichage.setVgap(10);

        // Remplir la grille avec les tuiles
        mettreAJourGrille();
    }

    public void mettreAJourGrille() {
        grilleAffichage.getChildren().clear();
        Grille grille = new Grille(5, 0); // Exemple : grille de 5x5
        Tuile[][] mygrille = grille.getTableauTuiles();

        for (int i = 0; i < mygrille.length; i++) {
            for (int j = 0; j < mygrille[i].length; j++) {
                TuileMot tuileMot = (TuileMot) mygrille[i][j];
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
}

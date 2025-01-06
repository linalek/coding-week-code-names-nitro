package codename.vue;

import codename.modele.Grille;
import codename.modele.TuileMot;
import codename.modele.Tuile;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


import javafx.scene.control.Alert;

public class VuePlateau {
    private GridPane grilleAffichage;

    public VuePlateau() {
        grilleAffichage = new GridPane();
        grilleAffichage.setAlignment(Pos.CENTER);
        grilleAffichage.setHgap(10);
        grilleAffichage.setVgap(10);
        mettreAJourGrille();
    }

    public void mettreAJourGrille() {
        grilleAffichage.getChildren().clear();
        Grille grille = new Grille(5,0);
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
        cellule.setPrefSize(300, 300);

        Text texte = new Text(tuileMot.getMot());
        texte.setFill(Color.WHITE);

        cellule.setStyle("-fx-background-color: " + obtenirCouleurDeFond(tuileMot.getEquipe()) + ";");
        cellule.getChildren().add(texte);
        cellule.setAlignment(Pos.CENTER);

        return cellule;
    }

    private String obtenirCouleurDeFond(int valeur) {
        return switch (valeur) {
            case -1 -> "#000000";
            case 0 -> "#FFFFFF";
            case 1 -> "#FF0000";
            case 2 -> "#0000FF";
            default -> "#FF8000";
        };
    }

    public GridPane getGrilleAffichage() {
        return grilleAffichage;
    }

    public void afficher(Stage primaryStage) {
        // Contenu de la vue
        StackPane root = new StackPane();
        root.getChildren().add(getGrilleAffichage());

        // Création de la scène
        Scene scene = new Scene(root, 400, 300);

        // Configuration et affichage de la scène
        primaryStage.setTitle("Vue Plateau");
        primaryStage.setScene(scene);
        primaryStage.show();
    }






}


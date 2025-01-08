package codename.controleur;

import codename.modele.Grille;
import codename.modele.Jeu;
import codename.modele.Tuile;
import codename.modele.TuileMot;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Contrôleur pour la vue du plateau de jeu, cela permet de créer le plateau de jeu
 */
public class PlateauAgentControleur implements Initializable {

    private AgentControleur agentControleur;
    private Jeu jeuEnCours;

    @FXML
    private GridPane grilleAffichage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("PlateauControleur initialise.");
        // Configuration de base de la grille
        grilleAffichage.setAlignment(Pos.CENTER);
        grilleAffichage.setHgap(10);
        grilleAffichage.setVgap(10);
    }

    public void readyToContinue(){
        mettreAJourGrille();
    }

    public void mettreAJourGrille() {
        grilleAffichage.getChildren().clear();
        for (int i = 0; i < jeuEnCours.getTaille(); i++) {
            for (int j = 0; j < jeuEnCours.getTaille(); j++) {
                TuileMot tuileMot = (TuileMot) jeuEnCours.getTuile(i,j);
                StackPane cellule = creerCelluleMot(tuileMot);
                cellule.setOnMouseClicked(event -> handleCellClick(event));
                grilleAffichage.add(cellule, j, i);
            }
        }
    }

    private StackPane creerCelluleMot(TuileMot tuileMot) {
        StackPane cellule = new StackPane();
        cellule.setPrefSize(150, 150); // Taille de chaque cellule

        Text texte = new Text(tuileMot.getMot());
        texte.setFill(Color.WHITE);
        texte.setFont(new Font(25));
        texte.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        String tuilecolor;
        if (tuileMot.isEstRetournee()){
            tuilecolor = obtenirCouleurDeFond(tuileMot.getEquipe());
        }
        else {
            tuilecolor = "#FFFFFF";
        }
        cellule.setStyle("-fx-background-color: " + tuilecolor + ";");
        cellule.getChildren().add(texte);
        cellule.setAlignment(Pos.CENTER);
        if (tuilecolor.equals("#FFFFFF")) {
            texte.setFill(Color.BLACK);
        }
        else {
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

    private void handleCellClick(MouseEvent event) {

        // Récupérer la cellule cliquée
        Pane clickedCell = (Pane) event.getSource();
        Integer i = GridPane.getRowIndex(clickedCell);
        Integer j = GridPane.getColumnIndex(clickedCell);
        TuileMot tuileMot = (TuileMot) jeuEnCours.getTuile(i,j);
        tuileMot.setEstRetournee();
        mettreAJourGrille();
    }
    public void setAgentControleur(AgentControleur agentControleur) {
        this.agentControleur = agentControleur;
    }
    public void setJeu(Jeu jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }
}


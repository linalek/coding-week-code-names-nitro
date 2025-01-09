package codename.controleur;

import codename.DictionnaireThemes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class CustomControleur {

    @FXML
    public SplitMenuButton nombreJoueurs;

    @FXML
    public SplitMenuButton tailleGrille;

    @FXML
    private ChoiceBox<String> choiceBoxThemes;

    @FXML
    private CheckBox checkboxModeTempsLimite;

    @FXML
    private TextField inputTemps;

    @FXML
    private CheckBox checkboxModeImage;

    @FXML
    private CheckBox checkboxModeMot;

    private GlobalControleur globalControleur;
    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    private void initialize() {
        // Initialisation des thèmes dans le ChoiceBox
        choiceBoxThemes.getItems().addAll(DictionnaireThemes.getThemes());
    }

    /**
     * Gère l'événement de sélection d'un nombre de joueurs.
     */
    @FXML
    private void handleNombreJoueurSelection(javafx.event.ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String nbJoueurs = menuItem.getText();
        nombreJoueurs.setText(nbJoueurs);
        try {
            System.out.println("Nombre de joueurs : " + nbJoueurs );
        } catch (NumberFormatException e) {
            System.out.println("La sélection n'est pas valide.");
        }
    }
    /**
     * Gère la sélection de la taille de la grille
     */
    @FXML
    private void handleTailleGrilleSelection(javafx.event.ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String tGrille = menuItem.getText();
        tailleGrille.setText(tGrille);
        try {
            System.out.println("Taille de la grille : " + tailleGrille);
        } catch (NumberFormatException e) {
            System.out.println("La sélection n'est pas valide.");
        }
    }
    /**
     * Rendre visible le choix du temps
     */
    @FXML
    private void handleCheckboxAction() {
        // Affiche ou masque le TextField en fonction de l'état du CheckBox
        inputTemps.setVisible(checkboxModeTempsLimite.isSelected());
    }
    /**
     * gérer le check des modes images/mots
     */
    @FXML
    private void handleModeSelection() {
        if (checkboxModeImage.isSelected()) {
            checkboxModeMot.setSelected(false); // Décoche "Mot"
        } else if (checkboxModeMot.isSelected()) {
            checkboxModeImage.setSelected(false); // Décoche "Image"
        }
    }
    /**
     * lancer la partie
     */
    @FXML
    private void handleLancerPartie() {
        String nbJoueurs = nombreJoueurs.getText();
        String formatGrille = tailleGrille.getText();
        String themeChoisi = choiceBoxThemes.getValue();
        String tempsChoisi = inputTemps.getText();
        List<String> themes = new ArrayList<>();
        themes.add(themeChoisi);
        int type = 0;
        if (checkboxModeImage.isSelected()) {
            type = 1;
        }
        // Lancer la partie avec les paramètres choisis
        System.out.println("Nombre de joueurs : " + nbJoueurs);
        System.out.println("Taille de la grille : " + formatGrille);
        System.out.println("Thème choisi : " + themeChoisi);
        System.out.println("Temps limité : " + tempsChoisi);
        if (checkboxModeImage.isSelected()) {
            System.out.println("Mode Image");
        } else if (checkboxModeMot.isSelected()) {
            System.out.println("Mode mot");
        }
        if (globalControleur != null) {
            globalControleur.lancerJeuCustom( Integer.parseInt(formatGrille), type, Integer.parseInt(nbJoueurs), Integer.parseInt(tempsChoisi), themes);
        }
    }
}


package codename.controleur;

import codename.DictionnaireThemes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CustomControleur {

    public SplitMenuButton nombreJoueurs;
    @FXML
    private Slider sliderNbJoueurs;

    @FXML
    private TextField textFieldTailleGrille;

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

    @FXML
    private void handleLancerPartie() {
        int nbJoueurs = (int) sliderNbJoueurs.getValue();
        String tailleGrille = textFieldTailleGrille.getText();
        String themeChoisi = choiceBoxThemes.getValue();

        // Lancer la partie avec les paramètres choisis
        System.out.println("Nombre de joueurs: " + nbJoueurs);
        System.out.println("Taille de la grille: " + tailleGrille);
        System.out.println("Thème choisi: " + themeChoisi);
    }

    /**
     * Gère l'événement de sélection d'un nombre de joueurs.
     */
    @FXML
    private void handleNombreJoueurSelection(javafx.event.ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        try {
            int nbJoueurs = Integer.parseInt(menuItem.getText());
            sliderNbJoueurs.setValue(nbJoueurs); // Synchronise le Slider
            nombreJoueurs.setText("Nombre de joueurs : " + nbJoueurs); // Met à jour le SplitMenuButton
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
}


package codename.controleur;

import codename.DictionnaireThemes;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class CustomControleur {

    @FXML
    private Slider sliderNbJoueurs;

    @FXML
    private TextField textFieldTailleGrille;

    @FXML
    private ChoiceBox<String> choiceBoxThemes;

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
}

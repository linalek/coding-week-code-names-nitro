package codename.controleur;

import codename.DictionnaireThemes;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;

import java.util.ArrayList;
import java.util.List;

public class CustomControleur {

    @FXML
    public SplitMenuButton nombreJoueurs;

    @FXML
    public SplitMenuButton tailleGrille;

    @FXML
    public Label tempsLimite;

    @FXML
    public ListView listViewThemes;

    @FXML
    private ChoiceBox<String> choiceBoxThemes;

    @FXML
    private CheckBox checkboxModeTempsLimite;

    @FXML
    private CheckBox checkboxNotModeTempsLimite;

    @FXML
    private TextField inputTemps;

    @FXML
    private CheckBox checkboxModeImage;

    @FXML
    private CheckBox checkboxModeMot;

    private GlobalControleur globalControleur;
    private ObservableList<String> themes = FXCollections.observableArrayList();
    private List<String> selectedThemes = new ArrayList<>();
    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    private void initialize() {
        // Charger les thèmes depuis le dictionnaire
        themes.setAll(DictionnaireThemes.getThemes());
        listViewThemes.setItems(themes);

        // Ajouter des cases à cocher pour chaque thème
        listViewThemes.setCellFactory(CheckBoxListCell.forListView(theme -> {
            BooleanProperty selected = new SimpleBooleanProperty(false);
            selected.addListener((obs, wasSelected, isNowSelected) -> {
                if (isNowSelected) {
                    selectedThemes.add(theme.toString());
                } else {
                    selectedThemes.remove(theme);
                }
            });
            return selected;
        }));
    }

    /**
     * Gère l'événement de sélection d'un nombre de joueurs.
     */
    @FXML
    private void handleNombreJoueurSelection(ActionEvent event) {
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
    private void handleTailleGrilleSelection(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String tGrille = menuItem.getText();
        tailleGrille.setText(tGrille);
        try {
            System.out.println("Taille de la grille : " + tGrille);
        } catch (NumberFormatException e) {
            System.out.println("La sélection n'est pas valide.");
        }
    }

    /**
     * Rendre visible le choix du temps
     */
    @FXML
    private void handleModeTempsLimite() {
        if (checkboxModeTempsLimite.isSelected()) {
            checkboxNotModeTempsLimite.setSelected(false);
            inputTemps.setVisible(true);
        } else if (checkboxNotModeTempsLimite.isSelected()) {
            checkboxModeTempsLimite.setSelected(false);
            inputTemps.setVisible(false);
        }
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
        if (selectedThemes.size() < 4 && !selectedThemes.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Sélection insuffisante");
            alert.setContentText("Vous devez sélectionner au moins 4 thèmes !");
            alert.showAndWait();
        } else {
            if (selectedThemes.isEmpty()) {
                selectedThemes=null;
            }
            String nbJoueurs = nombreJoueurs.getText();
            String tGrille = tailleGrille.getText();

            int tempsChoisi = 0;
            if (checkboxModeTempsLimite.isSelected()) {
                tempsChoisi = Integer.parseInt(inputTemps.getText());
            }

            int type = 0;
            if (checkboxModeImage.isSelected()) {
                type = 1;
            }

            if (checkboxModeTempsLimite.isSelected()) {
                System.out.println("Temps limité : " + inputTemps.getText());
            } else if (checkboxNotModeTempsLimite.isSelected()) {
                System.out.println("Pas de temps limité");
            }
            if (checkboxModeImage.isSelected()) {
                System.out.println("Mode Image");
            } else if (checkboxModeMot.isSelected()) {
                System.out.println("Mode mot");
            }
            if (globalControleur != null) {
                globalControleur.lancerJeuCustom(Integer.parseInt(tGrille), type, Integer.parseInt(nbJoueurs)-1, tempsChoisi, selectedThemes);
            }
        }
    }
}


package codename.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import codename.DictionnaireThemes;

public class AjoutMotsDicoControleur implements Initializable {

    @FXML
    private ComboBox<String> themeComboBox;
    @FXML
    private ListView<String> wordsListView;
    @FXML
    private TextField addWordTextField;
    @FXML
    private Button addWordButton;
    @FXML
    private TextField newThemeTextField;
    @FXML
    private TextField newThemeWordTextField;
    @FXML
    private Button addNewThemeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // On initialise la ComboBox avec la liste des thèmes existants
        themeComboBox.setItems(FXCollections.observableArrayList(DictionnaireThemes.getThemes()));

        // Quand on sélectionne un thème, on charge la liste des mots
        themeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                refreshWordsList(newValue);
            }
        });

        // Bouton "Ajouter" pour ajouter un mot au thème sélectionné
        addWordButton.setOnAction(event -> {
            String selectedTheme = themeComboBox.getValue();
            if (selectedTheme != null && !selectedTheme.isEmpty()) {
                String newWord = addWordTextField.getText();
                if (newWord != null && !newWord.isBlank()) {
                    DictionnaireThemes.ajouterMotAuTheme(selectedTheme, newWord);
                    refreshWordsList(selectedTheme);
                    addWordTextField.clear();
                }
            } else {
                System.out.println("Veuillez selectionner un theme avant d'ajouter un mot.");
            }
        });

        // Bouton "Créer le thème" pour créer un nouveau thème et y ajouter un premier mot
        addNewThemeButton.setOnAction(event -> {
            String newTheme = newThemeTextField.getText();
            String firstWord = newThemeWordTextField.getText();

            if (newTheme != null && !newTheme.isBlank() &&
                    firstWord != null && !firstWord.isBlank()) {

                // Ajoute le nouveau thème et son premier mot
                DictionnaireThemes.ajouterMotAuTheme(newTheme, firstWord);

                // Ajoute ce nouveau thème dans la ComboBox, si besoin
                if (!themeComboBox.getItems().contains(newTheme)) {
                    themeComboBox.getItems().add(newTheme);
                }

                // Sélectionne automatiquement le nouveau thème
                themeComboBox.setValue(newTheme);

                // Nettoie les champs
                newThemeTextField.clear();
                newThemeWordTextField.clear();
            } else {
                System.out.println("Veuillez saisir un nom de theme et un premier mot.");
            }
        });
    }

    /**
     * Met à jour la liste des mots pour le thème donné.
     */
    private void refreshWordsList(String theme) {
        wordsListView.setItems(
                FXCollections.observableArrayList(DictionnaireThemes.getMotsParTheme(theme))
        );
    }
}

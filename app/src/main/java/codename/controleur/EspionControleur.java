package codename.controleur;

import codename.modele.Jeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

/**
 * Contrôleur de la fenêtre Espion.
 * Permet de saisir un indice + le nombre de cartes, puis de valider.
 */
public class EspionControleur {

    private Jeu jeuEnCours;

    @FXML
    private SplitMenuButton nombreCartesButton;
    @FXML
    private TextField indiceTextField;
    private int nombreCartes = 1;
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    private void handleNombreCartesSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedNumber = selectedItem.getText();
        nombreCartesButton.setText(selectedNumber);
        try {
            nombreCartes = Integer.parseInt(selectedNumber);
        } catch (NumberFormatException e) {
            nombreCartes = 1;
        }
    }

    @FXML
    private void handleValider(ActionEvent event) {
        String indice = indiceTextField.getText();
        System.out.println("Indice saisi : " + indice);
        System.out.println("Nombre de cartes selectionne : " + nombreCartes);
        if (globalControleur != null) {
            globalControleur.afficherAgent(indice,nombreCartes);
            System.out.println("Passage a la vue Agent.");
        } else {
            System.err.println("GlobalControleur non initialise.");
        }
    }
    public void setJeu(Jeu jeuEnCours){
        this.jeuEnCours= jeuEnCours;
    }
}


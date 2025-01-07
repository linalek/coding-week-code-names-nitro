
package codename.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

/**
 * Contrôleur de la fenêtre "IndiceEspion" (Spymaster).
 * Permet de saisir un indice + le nombre de cartes, puis de valider.
 */
public class EspionControleur {

    @FXML
    private SplitMenuButton nombreCartesButton;

    // Autres éléments et méthodes du contrôleur...

    @FXML
    private void handleNombreCartesSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedNumber = selectedItem.getText();
        nombreCartesButton.setText(selectedNumber);
    }

    @FXML
    private void handleValider(ActionEvent event) {
        // Votre logique pour le bouton "Valider"
    }
}


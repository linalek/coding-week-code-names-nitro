package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AgentControleur {

    @FXML
    private Label indiceDisplayLabel;

    @FXML
    private Label nombreCartesDisplayLabel;

    /**
     * Initialise les valeurs par défaut des Labels.
     * Cette méthode est appelée automatiquement après le chargement du fichier FXML.
     */
    @FXML
    private void initialize() {
        // Valeurs par défaut
        indiceDisplayLabel.setText("Aucun");
        nombreCartesDisplayLabel.setText("0");
    }

    /**
     * Méthode pour mettre à jour l'indice affiché.
     * @param indice La nouvelle valeur de l'indice.
     */
    public void setIndice(String indice) {
        if (indice != null && !indice.trim().isEmpty()) {
            indiceDisplayLabel.setText(indice);
        } else {
            indiceDisplayLabel.setText("Aucun");
        }
    }

    /**
     * Méthode pour mettre à jour le nombre de cartes affiché.
     * @param nombre Le nouveau nombre de cartes.
     */
    public void setNombreCartes(int nombre) {
        nombreCartesDisplayLabel.setText(String.valueOf(nombre));
    }
}

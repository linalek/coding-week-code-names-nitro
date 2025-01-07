package codename.controleur;

import codename.modele.Jeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AgentControleur {

    private Jeu jeuEnCours;
    @FXML
    private Label indiceDisplayLabel;
    @FXML
    private Label nombreCartesDisplayLabel;
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

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

    public void handleValider(ActionEvent event) {
        if (globalControleur != null) {
            globalControleur.afficherEspion();
            System.out.println("Passage a la vue Espion.");
        }
    }

    public void setJeu(Jeu jeuEnCours){
        this.jeuEnCours= jeuEnCours;
    }
}

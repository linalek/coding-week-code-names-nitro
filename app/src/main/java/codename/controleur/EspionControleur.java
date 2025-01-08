package codename.controleur;

import codename.modele.Jeu;
import codename.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Contrôleur de la fenêtre Espion.
 * Permet de saisir un indice + le nombre de cartes, puis de valider.
 */
public class EspionControleur {

    private Jeu jeuEnCours;
    private PlateauEspionControleur plateauEspionControleur;
    @FXML
    private BorderPane rootEspion;
    @FXML
    private VBox redTeamBox;
    @FXML
    private VBox blueTeamBox;
    @FXML
    private SplitMenuButton nombreCartesButton;
    @FXML
    private TextField indiceTextField;

    private GlobalControleur globalControleur;

    public void readyToContinue() {
        try {
            for (Joueur joueur : jeuEnCours.getEquipeRouge().getJoueurs()){
                addRedPlayer(joueur.getNom());
            }
            for (Joueur joueur : jeuEnCours.getEquipeBleue().getJoueurs()){
                addBluePlayer(joueur.getNom());
            }
            FXMLLoader plateauEspionLoader = new FXMLLoader(getClass().getResource("/codename/vue/PlateauEspion.fxml"));
            Node plateauEspionPane = plateauEspionLoader.load();
            plateauEspionControleur = plateauEspionLoader.getController();
            plateauEspionControleur.setEspionControleur(this);
            plateauEspionControleur.setJeu(jeuEnCours);
            plateauEspionControleur.readyToContinue();
            rootEspion.setCenter(plateauEspionPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    private void handleNombreCartesSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedNumber = selectedItem.getText();
        nombreCartesButton.setText(selectedNumber);
        try {
            jeuEnCours.setNombreTuileARretourner(Integer.parseInt(selectedNumber));
            System.out.println(jeuEnCours.getNombreTuileARretourner());
        } catch (NumberFormatException e) {
            jeuEnCours.setNombreTuileARretourner(1);
        }
    }

    @FXML
    private void handleValider(ActionEvent event) {
        jeuEnCours.setIndice(indiceTextField.getText());
        System.out.println(jeuEnCours.getIndice());
        if (globalControleur != null) {
            globalControleur.afficherChargementAgent();
        } else {
            System.err.println("GlobalControleur non initialise.");
        }
    }
    public void setJeu(Jeu jeuEnCours){
        this.jeuEnCours= jeuEnCours;
    }

    public void addRedPlayer(String playerName) {
        Label newPlayer = new Label(playerName);
        newPlayer.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        redTeamBox.getChildren().add(newPlayer);
    }
    public void addBluePlayer(String playerName) {
        Label newPlayer = new Label(playerName);
        newPlayer.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        blueTeamBox.getChildren().add(newPlayer);
    }
}


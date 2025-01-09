package codename.controleur;

import codename.modele.Jeu;
import codename.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AgentControleur {

    private Jeu jeuEnCours;
    private PlateauAgentControleur plateauAgentControleur;
    private BorderPane root;
    @FXML
    private Label indiceDisplayLabel;
    @FXML
    private VBox redTeamBox;
    @FXML
    private VBox blueTeamBox;

    @FXML
    private Label nombreCartesDisplayLabel;
    private GlobalControleur globalControleur;
    @FXML
    private BorderPane rootAgent;

    public void readyToContinue() {
        setIndice();
        setNombreCartes();
        try {
            for (Joueur joueur : jeuEnCours.getEquipeRouge().getJoueurs()){
                addRedPlayer(joueur.getNom());
            }
            for (Joueur joueur : jeuEnCours.getEquipeBleue().getJoueurs()){
                addBluePlayer(joueur.getNom());
            }
            FXMLLoader plateauAgentLoader = new FXMLLoader(getClass().getResource("/codename/vue/PlateauAgent.fxml"));
            Node plateauAgentPane = plateauAgentLoader.load();
            plateauAgentControleur = plateauAgentLoader.getController();
            plateauAgentControleur.setAgentControleur(this);
            plateauAgentControleur.setJeu(jeuEnCours);
            plateauAgentControleur.readyToContinue();
            rootAgent.setCenter(plateauAgentPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
     */
    public void setIndice() {
        String indice = jeuEnCours.getIndice();
        if (indice != null && !indice.trim().isEmpty()) {
            indiceDisplayLabel.setText(indice);
        } else {
            indiceDisplayLabel.setText("Aucun");
        }
    }

    /**
     * Méthode pour mettre à jour le nombre de cartes affiché.
     */
    public void setNombreCartes() {
        nombreCartesDisplayLabel.setText(String.valueOf(jeuEnCours.getNombreTuileARretourner()));
    }

    public void handleValider(ActionEvent event) {
        jeuEnCours.setTourRole(0);
        if (globalControleur != null) {
            globalControleur.afficherChargementEspion();
        }
    }

    public void aPerdu(){
        if (globalControleur != null) {
            globalControleur.afficherChargementEspion();
            System.out.println("Passage a la vue  de chargement pour l'espion Espion.");
        }
    }
    public void aGagne(int equipe){
        if (equipe==1){
            if (globalControleur != null) {
                globalControleur.afficherBleuGagnant();
                System.out.println("Passage a la vue  de victoire pour l'équipe bleu.");
            }
        }
        else {
            if (globalControleur != null) {
                globalControleur.afficherRougeGagnant();
                System.out.println("Passage a la vue  de victoire pour l'équipe rouge.");
            }
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
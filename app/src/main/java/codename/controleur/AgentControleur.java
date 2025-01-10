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

/**
 * Contrôleur pour la vue Agent.
 */
public class AgentControleur {

    private Jeu jeuEnCours;
    private PlateauAgentControleur plateauAgentControleur;
    private BorderPane root;

    /*Pour le mode Blitz*/
    @FXML
    private Label labelTempsRestant;

    /**
     * Met à jour le label du temps restant.
     * @param text
     */
    public void updateLabel(String text) {
        if (labelTempsRestant == null) {
            System.out.println("labelTempsRestant est null dans AgentControleur !");
        } else {
            labelTempsRestant.setText(text);
        }
    }
    


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

    /**
     * Méthode pour initialiser le contrôleur.
     */
    public void readyToContinue() {
        setIndice();
        setNombreCartes();
        try {
            for (Joueur joueur : jeuEnCours.getEquipeRouge().getJoueurs()){
                addRedPlayer(joueur.getNom() + " : " + joueur.getRole());
            }
            for (Joueur joueur : jeuEnCours.getEquipeBleue().getJoueurs()){
                addBluePlayer(joueur.getNom() + " : " + joueur.getRole());
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

    /**
     * Méthode pour gérer le clic sur le bouton "Valider".
     * @param event
     */
    public void handleValider(ActionEvent event) {
        jeuEnCours.setTourRole(0);
        if (globalControleur != null) {
            globalControleur.afficherChargementEspion();
        }
    }

    /**
     * Méthode pour gérer le clic sur le bouton "Passer".
     */
    public void aPerdu(){
        if (globalControleur != null) {
            globalControleur.afficherChargementEspion();
        }
    }

    /**
     * Méthode pour gérer le clic sur le bouton "Gagner".
     * @param equipe
     */
    public void aGagne(int equipe){
        if (equipe==1){
            if (globalControleur != null) {
                globalControleur.afficherBleuGagnant();
            }
        }
        else {
            if (globalControleur != null) {
                globalControleur.afficherRougeGagnant();
            }
        }
    }

    /**
     * Méthode pour gérer le clic sur le bouton "Recommencer"
     * @param jeuEnCours
     */
    public void setJeu(Jeu jeuEnCours){
        this.jeuEnCours= jeuEnCours;
    }

    /**
     * Méthodes pour ajouter un joueur à l'équipe rouge.
     * @param playerName
     */
    public void addRedPlayer(String playerName) {
        Label newPlayer = new Label(playerName);
        newPlayer.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
        redTeamBox.getChildren().add(newPlayer);
    }

    /**
     * Méthodes pour afficher à qui est le tour de jouer.
     */
    public void addRedTurn() {
        Label tour = new Label("A ton tour !");
        tour.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        redTeamBox.getChildren().add(tour);
    }

    /**
     * Méthodes pour ajouter un joueur à l'équipe bleue.
     * @param playerName
     */
    public void addBluePlayer(String playerName) {
        Label newPlayer = new Label(playerName);
        newPlayer.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
        blueTeamBox.getChildren().add(newPlayer);
    }
    public void addBlueTurn() {
        Label tour = new Label("A ton tour !");
        tour.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        blueTeamBox.getChildren().add(tour);
    }
}
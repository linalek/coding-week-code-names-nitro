package codename.controleur;

import codename.modele.Equipe;
import codename.modele.Joueur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ConfigurationEquipeControleur {

    @FXML
    private TextField nomAgentRouge;

    @FXML
    private TextField nomEspionRouge;

    @FXML
    private TextField nomAgentBleu;

    @FXML
    private TextField nomEspionBleu;

    private Equipe equipeRouge;
    private Equipe equipeBleue;

    @FXML
    public void initialize() {
        equipeRouge = new Equipe("Rouge", List.of());
        equipeBleue = new Equipe("Bleue", List.of());
    }

    @FXML
    public void validerEquipes() {
        // Récupération des noms des joueurs
        String agentRouge = nomAgentRouge.getText().trim();
        String espionRouge = nomEspionRouge.getText().trim();
        String agentBleu = nomAgentBleu.getText().trim();
        String espionBleu = nomEspionBleu.getText().trim();

        if (!agentRouge.isEmpty() && !espionRouge.isEmpty()) {
            equipeRouge.addJoueur(new Joueur(agentRouge, "Agent", "Rouge"));
            equipeRouge.addJoueur(new Joueur(espionRouge, "Espion", "Rouge"));
        }

        if (!agentBleu.isEmpty() && !espionBleu.isEmpty()) {
            equipeBleue.addJoueur(new Joueur(agentBleu, "Agent", "Bleue"));
            equipeBleue.addJoueur(new Joueur(espionBleu, "Espion", "Bleue"));
        }

        System.out.println("Équipe Rouge : " + equipeRouge.getJoueurs());
        System.out.println("Équipe Bleue : " + equipeBleue.getJoueurs());

        try {
            // Charger la nouvelle scène depuis agent.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/codename/vue/Espion.fxml"));
            Parent root = loader.load();

            // Récupérer le contrôleur de la nouvelle scène si besoin
            EspionControleur espionControleur = loader.getController();
            //espionControleur.setEquipes(equipeRouge, equipeBleue); // Passe les équipes au contrôleur Agent

            // Afficher la nouvelle scène
            Stage stage = (Stage) nomAgentRouge.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Page Agent");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void annuler() {
        try {
            // Récupérer la fenêtre actuelle
            Stage stage = (Stage) nomAgentRouge.getScene().getWindow();

            // Vérifier si la scène actuelle est déjà celle de l'accueil
            String currentFXML = stage.getScene().getRoot().getId();

            if ("acceuil".equals(currentFXML)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Retour au Menu");
                alert.setHeaderText(null);
                alert.setContentText("Vous êtes déjà dans le menu principal.");
                alert.showAndWait();
            } else {
                // Charger la page d'accueil
                Parent root = FXMLLoader.load(getClass().getResource("/codename/vue/Global.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Impossible de retourner au menu principal.");
            alert.showAndWait();
        }
    }

    public Equipe getEquipeRouge() {
        return equipeRouge;
    }

    public Equipe getEquipeBleue() {
        return equipeBleue;
    }
}

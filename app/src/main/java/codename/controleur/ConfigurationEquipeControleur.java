package codename.controleur;

import codename.modele.Equipe;
import codename.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.ArrayList;

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
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    public void initialize() {
        equipeRouge = new Equipe("Rouge", new ArrayList<>());
        equipeBleue = new Equipe("Bleue", new ArrayList<>());
    }

    @FXML
    public void validerEquipes() {
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

        if (globalControleur != null) {
            globalControleur.setEquipes(equipeRouge, equipeBleue);
            System.out.println("Equipes validées : " + equipeRouge.getJoueurs() + " - " + equipeBleue.getJoueurs());
            globalControleur.lancerJeu();
        } else {
            System.err.println("GlobalControleur non initialisé.");
        }
    }

    @FXML
    public void annuler() {
        if (globalControleur != null) {
            globalControleur.afficherAccueil();
        } else {
            System.err.println("GlobalControleur non initialisé.");
        }
    }

    public Equipe getEquipeRouge() {
        return equipeRouge;
    }

    public Equipe getEquipeBleue() {
        return equipeBleue;
    }
}

package codename.controleur;

import codename.modele.Equipe;
import codename.modele.Jeu;
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

    private Jeu jeuEnCours;
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    public void initialize() {

    }

    @FXML
    public void validerEquipes() {
        String agentRouge = nomAgentRouge.getText().trim();
        String espionRouge = nomEspionRouge.getText().trim();
        String agentBleu = nomAgentBleu.getText().trim();
        String espionBleu = nomEspionBleu.getText().trim();

        if (!agentRouge.isEmpty() && !espionRouge.isEmpty()) {
            jeuEnCours.getEquipeRouge().addJoueur(new Joueur(agentRouge, "Agent", "Rouge"));
            jeuEnCours.getEquipeRouge().addJoueur(new Joueur(espionRouge, "Espion", "Rouge"));
        }

        if (!agentBleu.isEmpty() && !espionBleu.isEmpty()) {
            jeuEnCours.getEquipeBleue().addJoueur(new Joueur(agentBleu, "Agent", "Bleue"));
            jeuEnCours.getEquipeBleue().addJoueur(new Joueur(espionBleu, "Espion", "Bleue"));
        }

        if (globalControleur != null) {
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

    public void setJeuEnCours(Jeu jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }
}

package codename.controleur;

import codename.modele.Jeu;
import codename.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConfigurationEquipeControleur {

    @FXML
    private TextField nomAgentRouge;

    @FXML
    private TextField nomEspionRouge;

    @FXML
    private TextField nomAgentBleu;

    @FXML
    private TextField nomEspionBleu;

    @FXML
    private VBox listeJoueursRouge;

    @FXML
    private VBox listeJoueursBleu;

    private Jeu jeuEnCours;
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    public void initialize() {

    }

    public void readyToContinue(){
        addEspionRow(listeJoueursRouge);
        addEspionRow(listeJoueursBleu);
        for (int i = 0; i<jeuEnCours.getNombreAgentsParEquipe(); i++){
            addAgentRow(listeJoueursRouge);
            addEspionRow(listeJoueursBleu);
        }
    }

    private void addEspionRow(VBox container) {
        HBox row = new HBox(15);
        row.setStyle("-fx-alignment: CENTER;");

        Label label = new Label("Nom de l'Espion :");
        label.setStyle("-fx-font-size: 14px;");

        TextField textField = new TextField();
        textField.setPrefWidth(200);

        row.getChildren().addAll(label, textField);
        container.getChildren().add(row);
    }

    private void addAgentRow(VBox container) {
        HBox row = new HBox(15);
        row.setStyle("-fx-alignment: CENTER;");

        Label label = new Label("Nom de l'Agent :");
        label.setStyle("-fx-font-size: 14px;");

        TextField textField = new TextField();
        textField.setPrefWidth(200);

        row.getChildren().addAll(label, textField);
        container.getChildren().add(row);
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
            globalControleur.afficherEspion();
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

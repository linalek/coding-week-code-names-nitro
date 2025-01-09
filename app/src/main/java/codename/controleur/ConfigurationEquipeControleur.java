package codename.controleur;

import codename.modele.Jeu;
import codename.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationEquipeControleur {


    private List<TextField> listeNomsAgentRouge;


    private TextField nomEspionRouge;


    private List<TextField> listeNomAgentBleu;


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
        listeNomsAgentRouge = new ArrayList<>();
        listeNomAgentBleu = new ArrayList<>();
    }

    public void readyToContinue(){
        nomEspionRouge = addEspionRow(listeJoueursRouge);
        nomEspionBleu = addEspionRow(listeJoueursBleu);
        for (int i = 0; i<jeuEnCours.getNombreAgentsParEquipe(); i++){
            listeNomsAgentRouge.add(addAgentRow(listeJoueursRouge));
            listeNomAgentBleu.add(addAgentRow(listeJoueursBleu));
        }
    }

    private TextField addEspionRow(VBox container) {
        HBox row = new HBox(15);
        row.setStyle("-fx-alignment: CENTER;");

        Label label = new Label("Nom de l'Espion :");
        label.setStyle("-fx-font-size: 14px;");

        TextField textField = new TextField();
        textField.setPrefWidth(200);

        row.getChildren().addAll(label, textField);
        container.getChildren().add(row);
        return textField;
    }

    private TextField addAgentRow(VBox container) {
        HBox row = new HBox(15);
        row.setStyle("-fx-alignment: CENTER;");

        Label label = new Label("Nom de l'Agent :");
        label.setStyle("-fx-font-size: 14px;");

        TextField textField = new TextField();
        textField.setPrefWidth(200);

        row.getChildren().addAll(label, textField);
        container.getChildren().add(row);
        return textField;
    }

    @FXML
    public void validerEquipes() {
        String espionRouge = nomEspionRouge.getText().trim();
        if (!espionRouge.isEmpty()) {
            jeuEnCours.getEquipeRouge().addJoueur(new Joueur(espionRouge, "Espion", "Rouge"));
        }
        String espionBleu = nomEspionBleu.getText().trim();
        if (!espionBleu.isEmpty()) {
            jeuEnCours.getEquipeBleue().addJoueur(new Joueur(espionBleu, "Espion", "Bleue"));
        }
        for (TextField element : listeNomsAgentRouge){
            String agentRouge = element.getText().trim();
            if (!agentRouge.isEmpty()) {
                jeuEnCours.getEquipeRouge().addJoueur(new Joueur(agentRouge, "Agent", "Rouge"));
            }
        }
        for (TextField element : listeNomAgentBleu) {
            String agentBleu = element.getText().trim();
            if (!agentBleu.isEmpty()) {
                jeuEnCours.getEquipeBleue().addJoueur(new Joueur(agentBleu, "Agent", "Bleue"));
    }
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

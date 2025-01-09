package codename.controleur;

import java.io.File;
import java.io.IOException;

import codename.DictionnaireThemes;
import codename.modele.Jeu;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Contrôleur pour le menu principal de l'application : permet de gérer les actions du menu.
 */
public class MenuControleur {

    private EspionControleur espionControleur;
    private AgentControleur agentControleur;

    public void setEspionControleur(EspionControleur controleur) {
        this.espionControleur = controleur;
        System.out.println("EspionControleur initialisé !");
    }
    
    public void setAgentControleur(AgentControleur controleur) {
        this.agentControleur = controleur;
        System.out.println("AgentControleur initialisé !");
    }

    @FXML
    private void initialize() {
        try {
            // Chargement de la vue Espion
            FXMLLoader espionLoader = new FXMLLoader(getClass().getResource("/codename/vue/Espion.fxml"));
            Parent espionRoot = espionLoader.load();
            EspionControleur espionControleur = espionLoader.getController();
            setEspionControleur(espionControleur); // Assignez le contrôleur Espion

            // Chargement de la vue Agent
            FXMLLoader agentLoader = new FXMLLoader(getClass().getResource("/codename/vue/Agent.fxml"));
            Parent agentRoot = agentLoader.load();
            AgentControleur agentControleur = agentLoader.getController();
            setAgentControleur(agentControleur); // Assignez le contrôleur Agent

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void partieBlitz() {
        if (espionControleur != null) {
            espionControleur.updateLabel("Temps restant : 30s");
        } else {
            System.out.println("EspionControleur non initialisé !");
        }

        if (agentControleur != null) {
            agentControleur.updateLabel("Temps restant : 30s");
            System.out.println("Blitz1");
        } else {
            System.out.println("AgentControleur non initialisé !");
        }

        System.out.println("Mode Blitz activé !");
    }

    

    @FXML
    public MenuItem bouttonRestaurer;
    
    @FXML
    public MenuItem bouttonSauvegarder;
    
    @FXML
    public MenuItem bouttonRetour;
    
    @FXML
    public MenuItem bouttonQuitter;

    @FXML
    public MenuItem bouttonBlitz;

    @FXML
    public MenuItem bouttonSolo;

    @FXML
    public MenuItem bouttonImage;

    @FXML
    public MenuItem bouttonStats;

    @FXML
    public MenuItem bouttonModif;

    @FXML
    public MenuItem bouttonRegles;

    @FXML
    public MenuItem bouttonApropos;

    @FXML
    public MenuItem bouttonCustom;

    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }
    
    @FXML
    public void partieSolo() {
    }

    @FXML
    public void partieCustom() {
        if (globalControleur != null) {
            globalControleur.afficherCustom();
            System.out.println("custom");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Affichage statistiques impossible");
            alert.setContentText("GlobalControleur est null. Assurez-vous qu'il est correctement initialisé.");
            alert.showAndWait();
        }
    }

    /**
     * Méthode pour afficher les règles du jeu à partir d'un fichier HTML permettant une mise en page propre du fichier, si le fichier est introuvable, une erreur est renvoyée à l'utilisateur
     * throws IOException si le fichier HTML des règles n'est pas trouvé
     */
    @FXML
    public void afficherRegles() {
        javafx.stage.Stage fenetreRegles = new javafx.stage.Stage();
        fenetreRegles.setTitle("Règles du Jeu");

        javafx.scene.web.WebView webView = new javafx.scene.web.WebView();

        try {
            String cheminFichier = "src/main/resources/public/regles_du_jeu.html";
            File fichierHtml = new File(cheminFichier);

            if (fichierHtml.exists()) {
                webView.getEngine().load(fichierHtml.toURI().toString());
            } else {
                throw new IOException("Fichier HTML non trouvé.");
            }
        } catch (IOException e) {
            javafx.scene.control.Alert errorAlert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText("Impossible de charger les règles du jeu");
            errorAlert.setContentText("Le fichier HTML des règles est introuvable.");
            errorAlert.showAndWait();
            return;
        }

        javafx.scene.Scene scene = new javafx.scene.Scene(webView, 800, 600);
        fenetreRegles.setScene(scene);
        fenetreRegles.show();
    }

    /**
     * Méthode pour afficher les informations sur les développeurs du jeu
     */
    @FXML
    public void afficherApropos() {
        javafx.stage.Stage fenetreRegles = new javafx.stage.Stage();
        fenetreRegles.setTitle("À Propos des développeurs");

        javafx.scene.web.WebView webView = new javafx.scene.web.WebView();

        try {
            String cheminFichier = "src/main/resources/public/apropos.html";
            File fichierHtml = new File(cheminFichier);

            if (fichierHtml.exists()) {
                webView.getEngine().load(fichierHtml.toURI().toString());
            } else {
                throw new IOException("Fichier HTML non trouvé.");
            }
        } catch (IOException e) {
            javafx.scene.control.Alert errorAlert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText("Impossible de charger les règles du jeu");
            errorAlert.setContentText("Le fichier HTML des règles est introuvable.");
            errorAlert.showAndWait();
            return;
        }

        javafx.scene.Scene scene = new javafx.scene.Scene(webView, 800, 600);
        fenetreRegles.setScene(scene);
        fenetreRegles.show();
    }
    
    @FXML
    public void partieImage() {
    }
    
    @FXML
    public void quitterApplication() {
        System.exit(0);
    }

    /**
     * Méthode pour retourner au menu principal
     */
    @FXML
    public void retourMenu() {
        if (globalControleur != null) {
            globalControleur.afficherAccueil();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Retour au menu principal impossible");
            alert.setContentText("GlobalControleur est null. Assurez-vous qu'il est correctement initialisé.");
            alert.showAndWait();
            }
    }

    @FXML
    public void sauvegarderPartie() {
        Jeu jeu = globalControleur.getJeuEnCours();
        if (jeu != null) {
            try {
                Jeu.sauvegarder(jeu, "partie.json");
                System.out.println("Partie sauvegardee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void restaurerPartie() {
        try {
            Jeu partieChargee = Jeu.charger("partie.json");
            System.out.println("Partie restauree");
            globalControleur.setJeuEnCours(partieChargee);
            globalControleur.afficherEspion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Méthode pour affihcer les statistiques du jeu
     * @throws IOException si le fichier FXML des statistiques n'est pas trouvé
     */
    @FXML
    public void afficherStats() {
        if (globalControleur != null) {
            globalControleur.afficherStatistique();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Affichage statistiques impossible");
            alert.setContentText("GlobalControleur est null. Assurez-vous qu'il est correctement initialisé.");
            alert.showAndWait();
        }
    }

    @FXML
    public void modifierCartes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/codename/vue/AjoutMotsDico.fxml"));
            Parent newRoot = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Modifier le dictionnaire");
            stage.setScene(new Scene(newRoot));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package codename.controleur;

import codename.modele.Equipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Contrôleur pour la vue principale de l'application : permet de switcher entre les differentes vues.
 */
public class GlobalControleur {

    @FXML
    private BorderPane root;
    private AccueilControleur accueilControleur;
    private ConfigurationEquipeControleur configurationEquipeControleur;
    private EspionControleur espionControleur;
    private AgentControleur agentControleur;
    private ChargementEspionControleur chargementEspionControleur;
    private ChargementAgentControleur chargementAgentControleur;

    /** Gestion des équipes */
    private Equipe equipeRouge;
    private Equipe equipeBleue;

    public void setEquipes(Equipe equipeRouge, Equipe equipeBleue) {
        this.equipeRouge = equipeRouge;
        this.equipeBleue = equipeBleue;
    }

    public Equipe getEquipeRouge() {
        return equipeRouge;
    }

    public Equipe getEquipeBleue() {
        return equipeBleue;
    }

    /** Gestion des affichages indice et nombre de cartes*/
    private String indice;
    private int nombresCartes;

    public String getIndice(){
        return this.indice;
    }
    public void setIndice(String indice){
        this.indice = indice;
    }

    public int getNombresCartes(){
        return this.nombresCartes;
    }
    public void setNombresCartes(int nombresCartes){
        this.nombresCartes = nombresCartes;
    }
    /**
     * Methode d'initialisation appelee automatiquement après le chargement du fichier FXML.
     */
    @FXML
    public void initialize() {
        try {
            FXMLLoader accueilLoader = new FXMLLoader(getClass().getResource("/codename/vue/Accueil.fxml"));
            Node accueilPane = accueilLoader.load();
            AccueilControleur accueilControleur = accueilLoader.getController();
            accueilControleur.setGlobalControleur(this);
            root.setCenter(accueilPane);
            System.out.println("Accueil.fxml charge et affiche dans le centre.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour afficher la vue Accueil dans le BorderPane.
     */
    public void afficherAccueil() {
        try {
            FXMLLoader accueilLoader = new FXMLLoader(getClass().getResource("/codename/vue/Accueil.fxml"));
            Node accueilPane = accueilLoader.load();
            accueilControleur = accueilLoader.getController();
            accueilControleur.setGlobalControleur(this);
            root.setCenter(accueilPane);
            System.out.println("Accueil.fxml charge et affiche dans le centre.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour afficher la vue ConfigurationEquipe dans le BorderPane.
     */
    public void afficherConfigurationEquipe() {
        try {
            FXMLLoader configLoader = new FXMLLoader(getClass().getResource("/codename/vue/ConfigurationEquipe.fxml"));
            Node configPane = configLoader.load();
            configurationEquipeControleur = configLoader.getController();
            configurationEquipeControleur.setGlobalControleur(this);
            root.setCenter(configPane);
            System.out.println("ConfigurationEquipe.fxml charge et affiche dans le centre.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour afficher la vue Espion dans le BorderPane.
     */
    public void afficherEspion() {
        try {
            FXMLLoader espionLoader = new FXMLLoader(getClass().getResource("/codename/vue/Espion.fxml"));
            Node espionPane = espionLoader.load();
            espionControleur = espionLoader.getController();
            espionControleur.setGlobalControleur(this);
            root.setCenter(espionPane);
            System.out.println("Espion.fxml charge et affiche dans le centre.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Méthode pour afficher la page de chargement pour l'espion
     */
    public void afficherChargementEspion(){
        try {
            FXMLLoader chargementLoader = new FXMLLoader(getClass().getResource("/codename/vue/ChargementEspion.fxml"));
            Node chargementPane = chargementLoader.load();
            chargementEspionControleur = chargementLoader.getController();
            chargementEspionControleur.setGlobalControleur(this);
            root.setCenter(chargementPane);
            System.out.println("ChargementEspion.fxml charge et affiche dans le centre.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour afficher la page de chargement pour l'agent
     */
    public void afficherChargementAgent(String indice, int nombresCartes){
        setIndice(indice);
        setNombresCartes(nombresCartes);
        try {
            FXMLLoader chargementLoader = new FXMLLoader(getClass().getResource("/codename/vue/ChargementAgent.fxml"));
            Node chargementPane = chargementLoader.load();
            chargementAgentControleur = chargementLoader.getController();
            chargementAgentControleur.setGlobalControleur(this);
            root.setCenter(chargementPane);
            System.out.println("ChargementAgent.fxml charge et affiche dans le centre.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour afficher la vue Agent dans le BorderPane.
     */
    public void afficherAgent(String indice, int nombreCartes) {
        try {
            FXMLLoader agentLoader = new FXMLLoader(getClass().getResource("/codename/vue/Agent.fxml"));
            Node agentPane = agentLoader.load();
            agentControleur = agentLoader.getController();
            agentControleur.setGlobalControleur(this);
            agentControleur.setIndice(indice);
            agentControleur.setNombreCartes(nombreCartes);
            root.setCenter(agentPane);
            System.out.println("Agent.fxml charge et affiche dans le centre.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

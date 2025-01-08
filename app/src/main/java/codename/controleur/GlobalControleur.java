package codename.controleur;

import codename.modele.Jeu;
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
    private Jeu jeuEnCours;
    private ChargementEspionControleur chargementEspionControleur;
    private ChargementAgentControleur chargementAgentControleur;
    private BleuGagneControleur bleuGagneControleur;
    private RougeGagneControleur rougeGagneControleur;


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
            configurationEquipeControleur.setJeuEnCours(jeuEnCours);
            root.setCenter(configPane);
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
            espionControleur.setJeu(jeuEnCours);
            espionControleur.setGlobalControleur(this);
            //espionControleur.setRoot(root);
            root.setCenter(espionPane);
            espionControleur.readyToContinue();
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
            agentControleur.setJeu(jeuEnCours);
            agentControleur.readyToContinue();
            root.setCenter(agentPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lancerJeu() {
        jeuEnCours = new Jeu();
        afficherConfigurationEquipe();
    }
    public void afficherBleuGagnant(){
        try {
            FXMLLoader gagnantLoader = new FXMLLoader(getClass().getResource("/codename/vue/BleuGagne.fxml"));
            Node gagnantPane = gagnantLoader.load();
            bleuGagneControleur = gagnantLoader.getController();
            bleuGagneControleur.setGlobalControleur(this);
            root.setCenter(gagnantPane);
            System.out.println("BleuGagnant.fxml charge et affiche dans le centre.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void afficherRougeGagnant(){
        try {
            FXMLLoader gagnantLoader = new FXMLLoader(getClass().getResource("/codename/vue/RougeGagne.fxml"));
            Node gagnantPane = gagnantLoader.load();
            rougeGagneControleur = gagnantLoader.getController();
            rougeGagneControleur.setGlobalControleur(this);
            root.setCenter(gagnantPane);
            System.out.println("RougeGagnant.fxml charge et affiche dans le centre.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

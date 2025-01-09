package codename.controleur;

import codename.modele.Jeu;
import codename.modele.Equipe;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.List;

/**
 * Contrôleur principal gérant la vue Global.fxml (BorderPane),
 * et qui affiche le Menu, l'Accueil, etc.
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
    private StatistiquesControleur statistiquesControleur;
    private CustomControleur customControleur;
    private BleuGagneControleur bleuGagneControleur;
    private RougeGagneControleur rougeGagneControleur;

    private Parent espionRoot;
    private EspionControleur espionControleur;

    private Parent agentRoot;
    private AgentControleur agentControleur;

    private int remainingTime = 30; // Temps initial
    private int blitzSecondsRemaining = 30;
    private Timeline blitzTimeline;
    private int currentPhase = 0; // Initial phase

    @FXML
    private MenuControleur menuBarController;
    private String lastView = "accueil";
    private String previousView = "accueil";

    /** Gestion des affichages indice et nombre de cartes */
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
     * Méthode d'initialisation appelée automatiquement après le chargement du fichier FXML.
     */
    @FXML
    public void initialize() {
        try {
            FXMLLoader accueilLoader = new FXMLLoader(getClass().getResource("/codename/vue/Accueil.fxml"));
            Node accueilPane = accueilLoader.load();
            accueilControleur = accueilLoader.getController();
            accueilControleur.setGlobalControleur(this);

            FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/codename/vue/Menu.fxml"));
            Node menuPane = menuLoader.load();
            MenuControleur menuControleur = menuLoader.getController();
            menuControleur.setGlobalControleur(this);

            root.setTop(menuPane);
            root.setCenter(accueilPane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Méthode pour afficher la vue Accueil dans le BorderPane.
     */
    public void afficherAccueil() {
        try {
            FXMLLoader accueilLoader = new FXMLLoader(getClass().getResource("/codename/vue/Accueil.fxml"));
            Node accueilPane = accueilLoader.load();
            accueilControleur = accueilLoader.getController();
            accueilControleur.setGlobalControleur(this);
            root.setCenter(accueilPane);
            lastView = "accueil";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour afficher la vue ConfigurationEquipe dans le BorderPane.
     */
    public void afficherConfigurationEquipe() {
        try {
            FXMLLoader configLoader = new FXMLLoader(getClass().getResource("/codename/vue/ConfigurationEquipe.fxml"));
            Node configPane = configLoader.load();
            configurationEquipeControleur = configLoader.getController();
            configurationEquipeControleur.setGlobalControleur(this);
            configurationEquipeControleur.setJeuEnCours(jeuEnCours);
            configurationEquipeControleur.readyToContinue();
            root.setCenter(configPane);
            lastView = "configuration";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour afficher la vue Espion dans le BorderPane.
     * À chaque fois, on (re)charge Espion.fxml.
     */
    public void afficherEspion() {
    try {
        FXMLLoader espionLoader = new FXMLLoader(getClass().getResource("/codename/vue/Espion.fxml"));
        Parent espionPane = espionLoader.load();
        espionControleur = espionLoader.getController();
        espionControleur.setGlobalControleur(this);
        espionControleur.setJeu(jeuEnCours);

        espionRoot = espionPane;
        root.setCenter(espionPane);

        espionControleur.readyToContinue();
        lastView = "espion";
        if (jeuEnCours.isModeBlitz()) {
            partieBlitz();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void afficherAgent() {
    try {
        FXMLLoader agentLoader = new FXMLLoader(getClass().getResource("/codename/vue/Agent.fxml"));
        Node agentPane = agentLoader.load();
        agentControleur = agentLoader.getController();
        agentControleur.setGlobalControleur(this);
        agentControleur.setJeu(jeuEnCours);
        agentControleur.readyToContinue();

        root.setCenter(agentPane);
        lastView = "agent";
        if (jeuEnCours.isModeBlitz()) {
            partieBlitz();
        }

    } catch (Exception e) {
        e.printStackTrace();
        }
    }


    public void partieBlitz() {
        jeuEnCours.setModeBlitz(true); // CETTE LIGNE FAIT TOUT et EST SUPER IMPORTANTE

        if (blitzTimeline != null) {
            blitzTimeline.stop();
        }


        blitzSecondsRemaining = 30;

        if (espionControleur != null) {
            espionControleur.updateLabel("30s");
        }
        if (agentControleur != null) {
            agentControleur.updateLabel("30s");
        }

        blitzTimeline = new Timeline(
            new KeyFrame(Duration.seconds(1), event -> {
                blitzSecondsRemaining--;

                if (jeuEnCours.getTour() == 0 && blitzSecondsRemaining <=0 ) { // Si l'équipe en cours est Bleu
                    blitzSecondsRemaining = 30;
                    afficherRougeGagnant();


            } else if (jeuEnCours.getTour() == 1 && blitzSecondsRemaining <=0) { // Si l'équipe en cours est Rouge
                    blitzSecondsRemaining = 30;
                    afficherBleuGagnant();


                } else {
                    if (espionControleur != null) {
                        espionControleur.updateLabel(blitzSecondsRemaining + "s");
                    }
                    if (agentControleur != null) {
                        agentControleur.updateLabel(blitzSecondsRemaining + "s");
                    }
                }
            })
        );

        blitzTimeline.setCycleCount(Animation.INDEFINITE);
        blitzTimeline.play();
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
            chargementEspionControleur.setJeuEnCours(jeuEnCours);
            chargementEspionControleur.setTour();
            root.setCenter(chargementPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour afficher la page de chargement pour l'agent
     */
    public void afficherChargementAgent(){
        try {
            FXMLLoader chargementLoader = new FXMLLoader(getClass().getResource("/codename/vue/ChargementAgent.fxml"));
            Node chargementPane = chargementLoader.load();
            chargementAgentControleur = chargementLoader.getController();
            chargementAgentControleur.setGlobalControleur(this);
            chargementAgentControleur.setJeuEnCours(jeuEnCours);
            chargementAgentControleur.setTour();
            root.setCenter(chargementPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour afficher la vue Statistiques dans le BorderPane.
     */
    public void afficherStatistique() {
        try {
            previousView = lastView;
            FXMLLoader statLoader = new FXMLLoader(getClass().getResource("/codename/vue/Statistiques.fxml"));
            Node statPane = statLoader.load();
            statistiquesControleur = statLoader.getController();
            statistiquesControleur.setGlobalControleur(this);
            lastView = "statistiques";
            statistiquesControleur.chargerStatistiques();
            root.setCenter(statPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour customiser une partie
     */
    public void afficherCustom() {
        try {
            System.out.println("afficher");
            FXMLLoader customLoader = new FXMLLoader(getClass().getResource("/codename/vue/Custom.fxml"));
            Node customPane = customLoader.load();
            CustomControleur customControleur = customLoader.getController();
            customControleur.setGlobalControleur(this);
            root.setCenter(customPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lancerJeu() {
        jeuEnCours = new Jeu();
        afficherConfigurationEquipe();
    }
    public void lancerJeuCustom(int taille, int type, int nombreJoueursParEquipe, int timer, List<String> listeDesThemes){
        jeuEnCours = new Jeu(taille, type, nombreJoueursParEquipe, timer,listeDesThemes);
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

    public Jeu getJeuEnCours() {
        return jeuEnCours;
    }

    public void setJeuEnCours(Jeu jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }

    public Equipe getEquipeRouge() {
        return (jeuEnCours != null) ? jeuEnCours.getEquipeRouge() : null;
    }

    public Equipe getEquipeBleue() {
        return (jeuEnCours != null) ? jeuEnCours.getEquipeBleue() : null;
    }

    public String getLastView() {
        return lastView;
    }

    public void setLastView(String lastView) {
        this.lastView = lastView;
    }

    public String getPreviousView() {
        return previousView;
    }

    public void setPreviousView(String previousView) {
        this.previousView = previousView;
    }

    public void retournerVuePrecedente() {
        // Selon la valeur de previousView, on appelle la bonne méthode d’affichage
        switch (previousView) {
            case "espion":
                afficherEspion();
                break;
            case "agent":
                afficherAgent();
                break;
            case "configuration":
                afficherConfigurationEquipe();
                break;
            case "accueil":
            default:
                afficherAccueil();
                break;
        }
    }
}

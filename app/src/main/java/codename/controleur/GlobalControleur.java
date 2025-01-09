package codename.controleur;

import codename.modele.Jeu;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import java.io.IOException;

/**
 * Contrôleur principal gérant la vue Global.fxml (BorderPane),
 * et qui affiche le Menu, l'Accueil, etc.
 */
public class GlobalControleur {

    @FXML
    private BorderPane root;

    private AccueilControleur accueilControleur;
    private ConfigurationEquipeControleur configurationEquipeControleur;
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
    private int blitzSecondsRemaining;
    private Timeline blitzTimeline;

    @FXML
    private MenuControleur menuBarController;

    /** Gestion des affichages indice et nombre de cartes */
    private String indice;
    private int nombresCartes;

    public String getIndice() {
        return this.indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public int getNombresCartes() {
        return this.nombresCartes;
    }

    public void setNombresCartes(int nombresCartes) {
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

            root.setCenter(configPane);
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
            if (espionRoot == null) {
                // => C'est la première fois qu'on veut afficher Espion,
                // on charge depuis le FXML
                FXMLLoader espionLoader = new FXMLLoader(getClass().getResource("/codename/vue/Espion.fxml"));
                Parent loadedPane = espionLoader.load();

                this.espionControleur = espionLoader.getController();
                this.espionControleur.setGlobalControleur(this);
                this.espionControleur.setJeu(jeuEnCours);

                // On stocke la racine chargée
                this.espionRoot = loadedPane;

                // Appel d'une méthode perso s'il y a (facultatif)
                this.espionControleur.readyToContinue(); 
            }

            // Maintenant, on place la racine dans le center
            root.setCenter(espionRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void afficherAgent() {
        try {
            if (agentRoot == null) {
                // => Première fois qu'on veut afficher Agent
                FXMLLoader agentLoader = new FXMLLoader(getClass().getResource("/codename/vue/Agent.fxml"));
                Parent loadedPane = agentLoader.load();

                this.agentControleur = agentLoader.getController();
                this.agentControleur.setGlobalControleur(this);
                this.agentControleur.setJeu(jeuEnCours);

                // On stocke la racine
                this.agentRoot = loadedPane;
            }

            // Et on place agentRoot dans le center
            root.setCenter(agentRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void partieBlitz() {
    // On (ré)initialise le compteur à 30
    blitzSecondsRemaining = 30;

    // Si les contrôleurs existent déjà, on met immédiatement "30s"
    if (espionControleur != null) {
        espionControleur.updateLabel("30s");
    } else {
        System.out.println("[GlobalControleur] EspionControleur est null (non chargé)");
    }

    if (agentControleur != null) {
        agentControleur.updateLabel("30s");
    } else {
        System.out.println("[GlobalControleur] AgentControleur est null (non chargé)");
    }

    System.out.println("Mode Blitz activé !");

    // Si un Timeline existe déjà, on l'arrête pour en recréer un
    if (blitzTimeline != null) {
        blitzTimeline.stop();
    }

    // Création du Timeline : décrémente blitzSecondsRemaining toutes les 1s
    blitzTimeline = new Timeline(
        new KeyFrame(Duration.seconds(1), event -> {
            blitzSecondsRemaining--;

            // Quand on arrive à zéro, on arrête le timer
            if (blitzSecondsRemaining <= 0) {
                blitzTimeline.stop();
                // Optionnel : mettre quelque chose quand le temps est écoulé
                if (espionControleur != null) {
                    espionControleur.updateLabel("Temps écoulé !");
                }
                if (agentControleur != null) {
                    agentControleur.updateLabel("Temps écoulé !");
                }
            } else {
                // Sinon, on met à jour les labels
                if (espionControleur != null) {
                    espionControleur.updateLabel(blitzSecondsRemaining + "s");
                }
                if (agentControleur != null) {
                    agentControleur.updateLabel(blitzSecondsRemaining + "s");
                }
            }
        })
    );
    // Nombre de répétitions : indéfini (on s'arrêtera manuellement)
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
            FXMLLoader statLoader = new FXMLLoader(getClass().getResource("/codename/vue/Statistiques.fxml"));
            Node statPane = statLoader.load();
            statistiquesControleur = statLoader.getController();
            statistiquesControleur.setGlobalControleur(this);
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
}

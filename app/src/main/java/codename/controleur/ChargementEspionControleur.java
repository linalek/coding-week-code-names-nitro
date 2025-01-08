package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Contrôleur de la vue de chargement pour changer de joueur.
 */
public class ChargementEspionControleur {

    @FXML
    private Label tourLabel;

    @FXML
    private Button goButton;

    private GlobalControleur globalControleur;
    private String prochainTour;

    /**
     * Initialise le contrôleur.
     */
    public void initialize() {
        // Par défaut, rien n'est affiché. Le texte sera défini dynamiquement.
    }

    /**
     * Définit le contrôleur global pour naviguer entre les vues.
     * @param globalControleur Le contrôleur global de l'application.
     */
    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    /**
     * Définit le texte du tour actuel.
     * @param prochainTour Le texte indiquant quel joueur est concerné.
     */
    public void setTour(String prochainTour) {
        this.prochainTour = prochainTour;
        tourLabel.setText(prochainTour + ", c'est ton tour !");
    }

    /**
     * Gère l'événement lorsque le bouton "Go" est cliqué.
     */
    @FXML
    private void handleGo() {
        System.out.println("Bouton Go cliqué.");
        globalControleur.afficherEspion();
//        String indice = "Aucun";
//        int nombreCartes = 0;
//
//        if (globalControleur != null) {
//            switch (prochainTour) {
//                case "Espion Rouge":
//                    globalControleur.afficherEspion();
//                    System.out.println("Espion Rouge");
//                    break;
//                case "Agent Rouge":
//                    globalControleur.afficherEspion();
//                    System.out.println("Agent Rouge");
//                    break;
//                case "Espion Bleu":
//                    globalControleur.afficherEspion();
//                    System.out.println("Espion Bleu");
//                    break;
//                case "Agent Bleu":
//                    globalControleur.afficherEspion();
//                    System.out.println("Agent Bleu");
//                    break;
//                default:
//                    System.err.println("Vue inconnue pour : " + prochainTour);
//            }
//        } else {
//            System.err.println("GlobalControleur non initialisé.");
//        }
    }
}

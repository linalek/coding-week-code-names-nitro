package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuControleur {

    @FXML
    public MenuItem bouttonNouveau;

    @FXML
    public MenuItem bouttonRestaurer;

    @FXML
    public MenuItem bouttonSauvegarder;

    @FXML
    public MenuItem bouttonQuitter;
    
    @FXML
    public void quitterApplication() {
        System.exit(0);
    }
    @FXML
    public void creerNouvellePartie() {
        // Code to create a new game
    }

    @FXML
    public void restaurerPartie() {
        // Code to restore a game
    }

    @FXML
    public void sauvegarderPartie() {
        // Code to save a game
    }

}

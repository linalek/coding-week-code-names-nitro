package codename;

import codename.controleur.AccueilControleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Charger le fichier fxml global
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/codename/vue/Global.fxml")));
        //Créer la scène
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        //Nommer la fenêtre
        primaryStage.setTitle("Code Name Nitro");
        //Afficher la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

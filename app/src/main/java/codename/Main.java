package codename;

import codename.controleur.GlobalControleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static codename.DictionnaireThemes.sauvegarderDictionnaire;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                Objects.requireNonNull(getClass().getResource("/codename/vue/Global.fxml"))
        );
        Parent root = loader.load();
        GlobalControleur globalControleur = loader.getController();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Code Name Nitro");
        primaryStage.setOnCloseRequest(event -> {
            try {
                sauvegarderDictionnaire("dictionnaire.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

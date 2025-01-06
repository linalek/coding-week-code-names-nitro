package codename;

import codename.controleur.AccueilControleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML de la vue d'accueil (si vous avez un fichier FXML)
        // Si vous n'avez pas de FXML, vous pouvez créer l'interface directement en Java comme montré précédemment

        // Par exemple, si vous avez un FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/codename/vue/Accueil.fxml"));
        Scene scene = new Scene(loader.load());

        // Récupérer le contrôleur depuis l'FXMLLoader
        AccueilControleur accueilControleur = loader.getController();

        // Passer le primaryStage au contrôleur
        accueilControleur.setPrimaryStage(primaryStage);

        primaryStage.setTitle("Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

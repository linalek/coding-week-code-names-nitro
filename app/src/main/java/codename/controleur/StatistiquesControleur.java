package codename.controleur;

import codename.modele.Equipe;
import codename.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class StatistiquesControleur {
////TODO : ajouter un choix des noms et des équipes pour pouvoir le lier aux statistiques
//    @FXML
//    private TableView<Joueur> tableStatistiques;
//
//    @FXML
//    private TableColumn<Joueur, String> colNomJoueur;
//
//    @FXML
//    private TableColumn<Joueur, Integer> colScore;
//
//    private ObservableList<Joueur> listeJoueurs = FXCollections.observableArrayList();
//
//    public void initialize() {
//        // Lier les colonnes aux propriétés des objets Joueur
//        colNomJoueur.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNom()));
//        colScore.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getScore()));
//
//        // Charger les données (exemple statique, remplacez par vos données réelles)
//        chargerStatistiques();
//    }
//
//    private void chargerStatistiques() {
//        Equipe equipe = new Equipe("Rouge", List.of(
//                new Joueur("Alice", 50),
//                new Joueur("Bob", 75),
//                new Joueur("Charlie", 30)
//        ));
//
//        listeJoueurs.addAll(equipe.getJoueurs());
//        tableStatistiques.setItems(listeJoueurs);
//    }
//
//    @FXML
//    public void fermerFenetre() {
//        Stage stage = (Stage) tableStatistiques.getScene().getWindow();
//        stage.close();
//    }
}

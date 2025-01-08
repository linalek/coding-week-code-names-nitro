package codename.controleur;

import codename.modele.Equipe;
import codename.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class StatistiquesControleur {
//TODO : ajouter un choix des noms et des équipes pour pouvoir le lier aux statistiques
    @FXML
    private TableView<Joueur> tableStatistiques;

    @FXML
    private TableColumn<Joueur, String> colNomJoueur;

    @FXML
    private TableColumn<Joueur, Integer> colScore;

    private ObservableList<Joueur> listeJoueurs = FXCollections.observableArrayList();
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    public void initialize() {
        // Lier les colonnes aux propriétés des objets Joueur
        colNomJoueur.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNom()));
        // Charger les données (exemple statique, remplacez par vos données réelles)
        //chargerStatistiques();
    }

//    private void chargerStatistiques() {
//        Equipe equipe = new Equipe();
//
//        listeJoueurs.addAll(equipe.getJoueurs());
//        tableStatistiques.setItems(listeJoueurs);
//    }

    @FXML
    public void fermerFenetre() {
        globalControleur.afficherAccueil();
    }
}

package codename.controleur;

import codename.modele.Equipe;
import codename.modele.Joueur;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatistiquesControleur {

    @FXML
    private TableView<Joueur> tableStatistiques;

    @FXML
    private TableColumn<Joueur, String> colNomJoueur;

    @FXML
    private TableColumn<Joueur, Number> colScore;

    private ObservableList<Joueur> listeJoueurs = FXCollections.observableArrayList();

    private GlobalControleur globalControleur;

    /**
     * Méthode appelée juste après le chargement du FXML.
     */
    @FXML
    public void initialize() {
        // Lier la colonne du nom du joueur à la propriété 'nom'
        colNomJoueur.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNom())
        );

        // Lier la colonne du score à la propriété 'motsDonnes' (ou ce que vous décidez)
        // Par exemple, si vous souhaitez utiliser partiesGagnees :
        // colScore.setCellValueFactory(cellData ->
        //     new SimpleIntegerProperty(cellData.getValue().getPartiesGagnees())
        // );
        colScore.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getMotsDonnes())
        );
    }

    /**
     * Appelée pour donner au contrôleur une référence vers le GlobalControleur.
     */
    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    /**
     * Charge et affiche la liste des joueurs (rouges et bleus).
     * Peut être appelée depuis le GlobalControleur après avoir créé la vue.
     */
    public void chargerStatistiques() {
        // Vider la liste pour la recharger
        listeJoueurs.clear();

        // Récupérer l'équipe Rouge
        Equipe equipeRouge = globalControleur.getEquipeRouge();
        if (equipeRouge != null) {
            listeJoueurs.addAll(equipeRouge.getJoueurs());
        }

        // Récupérer l'équipe Bleue
        Equipe equipeBleue = globalControleur.getEquipeBleue();
        if (equipeBleue != null) {
            listeJoueurs.addAll(equipeBleue.getJoueurs());
        }

        // Associer la liste au TableView
        tableStatistiques.setItems(listeJoueurs);
    }

    /**
     * Bouton "Fermer" pour revenir à l'accueil.
     */
    @FXML
    public void fermerFenetre() {
        if (globalControleur != null) {
            globalControleur.retournerVuePrecedente();
        }
    }
}

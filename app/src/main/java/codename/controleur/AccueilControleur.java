package codename.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

/**
 * Contrôleur pour la vue d'accueil, cela permet de gérer le passage à la vue du plateau de jeu avec l'appuie du bouton "jouer"
 */
public class AccueilControleur {
    @FXML
    public StackPane accueil;
    private GlobalControleur globalControleur;

    public void setGlobalControleur(GlobalControleur globalControleur) {
        this.globalControleur = globalControleur;
    }

    @FXML
    private Button playPauseButton; // Bouton pour jouer/pause la musique

    @FXML
    private Slider volumeSlider; // Slider pour contrôler le volume

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    public void initialize() {
        try {
            // Charger la ressource depuis le classpath
            URL mediaUrl = getClass().getResource("/audio/music2.mp3");
            if (mediaUrl == null) {
                throw new IllegalArgumentException("Fichier média introuvable!");
            }
            String mediaPath = mediaUrl.toExternalForm();
            Media media = new Media(mediaPath);
            mediaPlayer = new MediaPlayer(media);

            volumeSlider.setValue(50); // Valeur initiale (50%)
            mediaPlayer.setVolume(volumeSlider.getValue() / 100);

            volumeSlider.valueProperty().addListener((observable, oldValue, newValue) ->
                    mediaPlayer.setVolume(newValue.doubleValue() / 100)
            );

            playPauseButton.setOnAction(event -> togglePlayPause());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Mise à jour du texte du bouton
     */
    private void togglePlayPause() {
        if (isPlaying) {
            mediaPlayer.pause();
            playPauseButton.setText("Play"); // Mettre à jour le texte du bouton
        } else {
            mediaPlayer.play();
            playPauseButton.setText("Pause");
        }
        isPlaying = !isPlaying;
    }

    /**
     * Lancer la partie en mode basique (grille 5x5, 4 joueurs, 2 équipes, sans chronomètre, mode mot)
     */
    @FXML
    public void handleJouer() {
        if (globalControleur != null) {
            globalControleur.lancerJeu();
        }
    }
}

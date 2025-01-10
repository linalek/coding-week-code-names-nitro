package codename;

import codename.modele.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JeuTest {

    private Jeu jeu;

    @BeforeEach
    void setUp() {
        jeu = new Jeu(5, 0, true, 2, List.of("theme1", "theme2"));
    }

    @Test
    void testChangerTour() {
        assertEquals(0, jeu.getTour());
        jeu.changerTour();
        assertEquals(1, jeu.getTour());
        jeu.changerTour();
        assertEquals(0, jeu.getTour());
    }

    @Test
    void testRetournerTuile() {


        assertEquals(0, jeu.getStatusPartie());
        int couleur = jeu.getGrille()
        int resultat = jeu.retournerTuile(0, 0);
        assertEquals(0, resultat);
        assertTrue(jeu.getTuile(0, 0).isEstRetournee());
        assertEquals(1, jeu.getTour());

        resultat = jeu.retournerTuile(0, 1);
        assertEquals(0, resultat);
        assertTrue(jeu.getTuile(0, 1).isEstRetournee());
        assertEquals(0, jeu.getTour());
    }

    @Test
    void testModeBlitz() {
        assertTrue(jeu.isModeBlitz());

        jeu.commencerTour(() -> System.out.println("Time Out"),
                () -> System.out.println("Tick"));

        jeu.finirTour();
        assertEquals(30000, jeu.getRemainingTime());
    }

    @Test
    void testSauvegarderEtCharger() throws IOException {
        String cheminFichier = "test_sauvegarde_jeu.json";

        Jeu.sauvegarder(jeu, cheminFichier);
        File fichier = new File(cheminFichier);
        assertTrue(fichier.exists());

        Jeu jeuCharge = Jeu.charger(cheminFichier);
        assertEquals(jeu.getTaille(), jeuCharge.getTaille());
        assertEquals(jeu.getTour(), jeuCharge.getTour());
        assertEquals(jeu.isModeBlitz(), jeuCharge.isModeBlitz());

        fichier.delete();
    }

    @Test
    void testFinirTour() {
        jeu.finirTour();
        assertEquals(1, jeu.getTour());
        assertEquals(30000, jeu.getRemainingTime());
    }

    @Test
    void testSettersAndGetters() {
        jeu.setIndice("TestIndice");
        assertEquals("TestIndice", jeu.getIndice());

        jeu.setTourRole(1);
        assertEquals(1, jeu.getTourRole());

        jeu.setNombreTuileARretourner(3);
        assertEquals(3, jeu.getNombreTuileARretourner());

        jeu.setEquipeRouge(new Equipe());
        assertNotNull(jeu.getEquipeRouge());
    }

    @Test
    void testIsThereWinner() {
        assertFalse(jeu.isThereWinner());

        jeu.retournerTuile(0, 0); // Simule le retour de toutes les tuiles d'une équipe
        jeu.retournerTuile(0, 1);

        assertFalse(jeu.isThereWinner());
    }
}


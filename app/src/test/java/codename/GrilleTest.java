package codename;

import org.junit.jupiter.api.Test;
import codename.modele.Grille;
import codename.modele.Tuile;
import codename.modele.TuileMot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class GrilleTest {

    /**
     * Teste la création d'une grille.
    */
    @Test
    public void testGrilleCreation() {
        Grille grille = new Grille(5, 0);
        assertEquals(5, grille.getTaille());
        assertNotNull(grille.createRepartitionTuiles());
        System.out.println("Test testGrilleCreation réussi.");
    }

    /*
     * Teste la création et la l'existence de la répartition des tuiles.
    */
    @Test
    public void testCreateRepartitionTuiles() {
        Grille grille = new Grille(5, 0);
        assertEquals(25, grille.createRepartitionTuiles().size());
        assertTrue(grille.createRepartitionTuiles().contains(-1));
        assertFalse(grille.createRepartitionTuiles().contains(3));
        System.out.println("Test testCreateRepartitionTuiles réussi.");
    }

    @Test
    public void testGetTableauTuiles() {
        Grille grille = new Grille(5, 0);
        assertNotNull(grille.getTableauTuiles());
        assertEquals(5, grille.getTableauTuiles().length);
        assertEquals(5, grille.getTableauTuiles()[0].length);
        System.out.println("Test testGetTableauTuiles réussi.");
    }

    @Test
    public void testCreateTableauTuiles() {
        Grille grille = new Grille(5, 0);
        grille.createTableauTuiles();
        assertNotNull(grille.getTableauTuiles());
        System.out.println("Test testCreateTableauTuiles réussi.");
    }

    @Test
    public void testMotsUniquesDansLaGrille() {
        int taille = 5;
        int type = 0;
        Grille grille = new Grille(taille, type);
        Tuile[][] tableauTuiles = grille.getTableauTuiles();
        Set<String> motsUniques = new HashSet<>();
        boolean tousLesMotsSontUniques = true;

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                Tuile tuile = tableauTuiles[i][j];
                if (tuile instanceof TuileMot) {
                    String mot = ((TuileMot) tuile).getMot();
                    if (!motsUniques.add(mot)) {
                        tousLesMotsSontUniques = false;
                        break;}
                }
            }
            if (!tousLesMotsSontUniques)break;
        }
        assertTrue(tousLesMotsSontUniques, "Tous les mots de la grille doivent être uniques.");
    }
}

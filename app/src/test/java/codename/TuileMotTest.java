package codename;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
import java.util.List;

import org.junit.jupiter.api.Test;

import codename.modele.TuileMot;

public class TuileMotTest {

    /*
     * Teste la création d'une tuile avec un mot hardcodé.
    */
    @Test 
    public void testGetMot() {
        TuileMot tuileMot = new TuileMot("test", 1);
        assertEquals("test", tuileMot.getMot());
        System.out.println("Test testGetMot réussi.");
    }

    /*
     * Teste la création d'une tuile avec un mot aléatoire.
    */
    @Test
    public void testGetMot2() {
        String motAleatoire = TuileMot.getRandomMot(null);
    
        assertNotNull(motAleatoire, "Le mot aléatoire ne devrait pas être null.");
    
        List<String> allMots = DictionnaireThemes.getAllMots();
        assertEquals(true, allMots.contains(motAleatoire), "Le mot aléatoire doit exister dans la liste des mots.");
    
        System.out.println("Mot aléatoire: " + motAleatoire);
    }
    
    // @Test
    // public void testGetMotWithTheme() {
    //     List<String> themes = List.of("Corps Humain"); // Utilisation de la casse correcte
    //     String motAleatoire = TuileMot.getRandomMot(themes);
    
    //     assertNotNull(motAleatoire, "Le mot aléatoire ne devrait pas être null.");
    
    //     Collection<? extends String> motsParTheme = DictionnaireThemes.getMotsParTheme("Corps Humain");
    //     assertEquals(true, motsParTheme.contains(motAleatoire), "Le mot aléatoire doit exister dans la liste des mots du thème 'Corps Humain'.");
    
    //     System.out.println("Mot aléatoire pour le thème 'Corps Humain': " + motAleatoire);
    // }
}
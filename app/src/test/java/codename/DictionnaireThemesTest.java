package codename;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DictionnaireThemesTest {
    @Test
    public void testGetAllMots() {
        List<String> mots = DictionnaireThemes.getAllMots();
        assertEquals(369, mots.size());
        System.out.println("Le test testGetAllMots a passé avec succès !");
    }

    @Test
    public void testGetThemes() {
        assertEquals(17, DictionnaireThemes.getThemes().size());
        System.out.println("Le test testGetThemes a passé avec succès !");
    }

    @Test
    public void testGetMotsParTheme() {
        assertEquals(20, DictionnaireThemes.getMotsParTheme("Personnes Célèbres").size());
        System.out.println("Le test testGetMotsParTheme a passé avec succès !");
    }
    
    @Test
    public void testAjouterMotAuTheme() {
        String theme = "Personnes Célèbres";
        String nouveauMot = "Gauss";

        List<String> motsAvantAjout = (List<String>) DictionnaireThemes.getMotsParTheme(theme);

        if (!motsAvantAjout.contains(nouveauMot)) {
            DictionnaireThemes.ajouterMotAuTheme(theme, nouveauMot);
        }

        List<String> motsApresAjout = (List<String>) DictionnaireThemes.getMotsParTheme(theme);
        assertEquals(motsAvantAjout.size() + 1, motsApresAjout.size());
        assertTrue(motsApresAjout.contains(nouveauMot));
        System.out.println("Le test testAjouterMotAuTheme a passé avec succès !");
    }
    
    
}

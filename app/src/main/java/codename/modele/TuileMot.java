package codename.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import codename.DictionnaireThemes;

public class TuileMot extends Tuile {
    private String mot;

    public TuileMot(String mot, int equipe) {
        super(equipe);
        this.mot = mot;
    }

    public TuileMot(int equipe) {
        super(equipe);
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    @Override
    public String toString() {
        return "Tuiles{" +
                "mot='" + mot + '\'' +
                ", equipe=" + equipe +
                ", estTrouve=" + estRetournee +
                '}';
    }

    /*
     * Cette méthode permet de renvoyer une TuileMot avec un mot assigné aléatoirement,
     * selon si une liste de thèmes est fournie ou non.
    */
    public static String getRandomMot(List<String> themes) {
        List<String> mots = new ArrayList<>();
        if (themes == null || themes.size() < 3) {
            mots = DictionnaireThemes.getAllMots();
        } else {
            for (String theme : themes) {
                mots.addAll(DictionnaireThemes.getMotsParTheme(theme));
            }
        }
        Random random = new Random();
        return mots.get(random.nextInt(mots.size()));
    }
    public void setRandomMot(List<String> themes){
        setMot(getRandomMot(themes));
    }
    public void setRandomMot(){
        setMot(getRandomMot(null));
    }
}
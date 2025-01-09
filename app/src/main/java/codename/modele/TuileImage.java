package codename.modele;

import codename.DictionnaireThemes;
import codename.DictionnaireThemesImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TuileImage extends Tuile {
    private String imageAdress;

    public TuileImage() {
        super(0);
    }

    public TuileImage(String imageAdress, int equipe) {
        super(equipe);
        this.imageAdress = imageAdress;
    }

    public TuileImage(int equipe) {
        super(equipe);
    }

    public String getImageAdress() {
        return imageAdress;
    }

    public static String getRandomImageAdress() {
        List<String> imageAdresses = new ArrayList<>();

            imageAdresses = DictionnaireThemesImage.getImageAdresses();
        Random random = new Random();
        return imageAdresses.get(random.nextInt(imageAdresses.size()));
    }

    public void setImageAdress(String imageAdress) {
        this.imageAdress = imageAdress;
    }

    public void setRandomImageAdress(List<String> themes) {

    }



    @Override
    public String toString() {
        return "Tuiles{" +
                "adresse de l'image='" + imageAdress + '\'' +
                ", equipe=" + equipe +
                ", estTrouve=" + estRetournee +
                '}';
    }
}

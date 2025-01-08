package codename.modele;

import java.util.List;

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

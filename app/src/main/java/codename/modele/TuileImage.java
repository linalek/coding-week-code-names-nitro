package codename.modele;

public class TuileImage extends Tuile {
    private String imageAdress;


    public TuileImage(String imageAdress, int equipe) {
        super(equipe);
        this.imageAdress = imageAdress;
    }

    public String getImageAdress() {
        return imageAdress;
    }

    public void setImageAdress(String imageAdress) {
        this.imageAdress = imageAdress;
    }

    @Override
    public String toString() {
        return "Tuiles{" +
                "adresse de l'image='" + imageAdress + '\'' +
                ", equipe=" + equipe +
                ", estTrouve=" + estTrouve +
                '}';
    }
}

package codename.modele;

public class TuileMot extends Tuile {
    private String mot;

    public TuileMot(String mot, int equipe) {
        super(equipe);
        this.mot = mot;
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
                ", estTrouve=" + estTrouve +
                '}';
    }

    // public void 
}
package codename.modele;

import javafx.scene.image.Image;

/*
 * Tuiles est la classe des tuiles avec des mots
*/
public class Tuiles {
    public String mot;
    public Image image; // pour les images
    public int equipe; // 0 pour l'équipe bleu, 1 pour l'équipe rouge
    public boolean estTrouve; // 0 si la carte est trouvé, 1 sinon

    public Tuiles(String mot, int equipe) {
        this.mot = mot;
        this.equipe = equipe;
        this.estTrouve = false;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

    public boolean isEstTrouve() {
        return estTrouve;
    }

    public void setEstTrouve(boolean estTrouve) {
        this.estTrouve = estTrouve;
    }

    @Override
    public String toString() {
        return "Tuiles{" +
                "mot='" + mot + '\'' +
                ", equipe=" + equipe +
                ", estTrouve=" + estTrouve +
                '}';
    }
    
}

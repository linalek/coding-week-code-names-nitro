package codename.modele;

public class Jeu {
    public Tuile[][] grille;
    public int nbMotsBleu;
    public int nbMotsRouge;
    public int nbMotsNeutre;
    public int nbMotsNoir;
    public int tour; // 0 pour l'équipe bleu, 1 pour l'équipe rouge
    public boolean estFini;
    public boolean estGagne;
    public boolean estPerdu;
    public boolean estMatchNul;

    public Jeu(int rows, int cols) {
        this.grille = new Tuile[rows][cols];
        this.nbMotsBleu = 0;
        this.nbMotsRouge = 0;
        this.nbMotsNeutre = 0;
        this.nbMotsNoir = 0;
        this.tour = 0;
        this.estFini = false;
        this.estGagne = false;
        this.estPerdu = false;
        this.estMatchNul = false;
    }

    public void changerTour() {
        tour = (tour == 0) ? 1 : 0;
    }

    public void verifierMatchNul() {
        if (nbMotsBleu == 0 && nbMotsRouge == 0) {
            estMatchNul = true;
            estFini = true;
        }
    }
    
}

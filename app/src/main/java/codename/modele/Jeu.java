package codename.modele;

public class Jeu {
    private Grille grille;
    private int nbMotsBleu;
    private int nbMotsRouge;
    private int tour; // 0 pour l'équipe bleu, 1 pour l'équipe rouge
    private int statusPartie; // 0 pour partie en cours, 1 pour bleu win, 2 pour rouge win


    public Jeu(int taille, int type) {
        this.grille = new Grille(taille,type);
        this.nbMotsBleu = grille.getNbBleue();
        this.nbMotsRouge = grille.getNbRouge();
        this.tour = 0;
        this.statusPartie = 0;
    }

    public void changerTour() {
        tour = (tour == 0) ? 1 : 0;
    }

    public boolean checkWinner() {
        if (nbMotsBleu == 0) {
            statusPartie=1;
            return true;
        }
        else if (nbMotsRouge == 0) {
            statusPartie=2;
            return true;
        }
        else {
            return false;
        }
    }

    public int retournerTuile(int i, int j){
        Tuile theTuile = grille.getTuile(i,j);
        if (!theTuile.isEstTrouve()) {
            switch (theTuile.getEquipe()){
                case -1 -> {
                    if (tour==0){statusPartie=2;}
                    else {statusPartie=1;}
                }
                case 0 -> changerTour();
                case 1 -> {
                    nbMotsBleu--;
                    if (tour == 1){changerTour();}
                }
                case 2 -> {
                    nbMotsRouge--;
                    if (tour == 0){changerTour();}
                }
            }
            checkWinner();
        }
        return statusPartie;
    }


    
}

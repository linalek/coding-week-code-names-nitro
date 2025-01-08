package codename.modele;

import java.util.ArrayList;

public class Equipe {
    private ArrayList<Joueur> joueurs;

    public Equipe() {
        this.joueurs = new ArrayList<>();
    }



    public ArrayList<Joueur> getJoueurs() { return joueurs; }
    public void addJoueur(Joueur joueur) { joueurs.add(joueur); }
    public void removeJoueur(Joueur joueur) { joueurs.remove(joueur); }

    public boolean contains(Joueur joueur) { return joueurs.contains(joueur); }
    public int getNbJoueurs() { return joueurs.size(); }
}

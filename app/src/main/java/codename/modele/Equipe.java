package codename.modele;

import java.util.ArrayList;

public class Equipe {
    private String couleur;
    private ArrayList<Joueur> joueurs;

    public Equipe(String couleur, ArrayList<Joueur> joueurs) {
        this.couleur = couleur;
        this.joueurs = joueurs;
    }

    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    public ArrayList<Joueur> getJoueurs() { return joueurs; }
    public void addJoueur(Joueur joueur) { joueurs.add(joueur); }
    public void removeJoueur(Joueur joueur) { joueurs.remove(joueur); }

    public boolean contains(Joueur joueur) { return joueurs.contains(joueur); }
    public int getNbJoueurs() { return joueurs.size(); }
}

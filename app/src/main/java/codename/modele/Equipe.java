package codename.modele;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String couleur;
    private ArrayList<Joueur> joueurs;

    public Equipe(String couleur, ArrayList<Joueur> joueurs) {
        this.couleur = couleur;
        this.joueurs = joueurs;
    }

    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
    public void removeJoueur(Joueur joueur) {
        joueurs.remove(joueur);
    }
    public void addJoueur(Joueur joueur) {
        joueurs.add(joueur);
    }
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
    public int getNbJoueurs() {
        return joueurs.size();
    }
    public Joueur getJoueur(int index) {
        return joueurs.get(index);
    }
    public boolean contains(Joueur joueur) {
        return joueurs.contains(joueur);
    }
}

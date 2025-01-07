package codename.modele;

/*
 * Tuiles est la classe des tuiles avec des mots
*/
public abstract class Tuile {
    protected int equipe; // -1 si carte noire 0 si carte blanche, 1 pour l'équipe bleu, 2 pour l'équipe rouge
    protected boolean estTrouve; // true si la carte est trouvé, false sinon

    public Tuile(int equipe) {
        this.equipe = equipe;
        this.estTrouve = false;
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

    public void setEstTrouve() {
        if (!this.estTrouve){
            this.estTrouve = true;
        };
    }

    @Override
    public String toString() {
        return "Tuiles{" +
                ", equipe=" + equipe +
                ", estTrouve=" + estTrouve +
                '}';
    }
    
}

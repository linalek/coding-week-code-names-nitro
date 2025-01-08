package codename.modele;

public class Joueur {
    private String nom;
    private String role; // Agent ou Espion
    private String equipe; // Rouge ou Bleue

    // Statistiques
    private int motsDonnes = 0;
    private int partiesJouees = 0;
    private int partiesGagnees = 0;
    private int partiesPerdues = 0;

    public Joueur(String nom, String role, String equipe) {
        this.nom = nom;
        this.role = role;
        this.equipe = equipe;
    }

    // Getters et setters
    public String getNom() { return nom; }
    public String getRole() { return role; }
    public String getEquipe() { return equipe; }

    public int getMotsDonnes() { return motsDonnes; }
    public void incrementerMotsDonnes() { motsDonnes++; }

    public int getPartiesJouees() { return partiesJouees; }
    public void incrementerPartiesJouees() { partiesJouees++; }

    public int getPartiesGagnees() { return partiesGagnees; }
    public void incrementerPartiesGagnees() { partiesGagnees++; }

    public int getPartiesPerdues() { return partiesPerdues; }
    public void incrementerPartiesPerdues() { partiesPerdues++; }

    @Override
    public String toString() {
        return nom + " (" + role + " - " + equipe + ")";
    }
}

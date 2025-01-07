package codename.modele;

public class Joueur {
    private String nom;
    private String role; // Agent ou Espion
    private String equipe; // Rouge ou Bleue

    public Joueur(String nom, String role, String equipe) {
        this.nom = nom;
        this.role = role;
        this.equipe = equipe;
    }

    public String getNom() {
        return nom;
    }

    public String getRole() {
        return role;
    }

    public String getEquipe() {
        return equipe;
    }

    @Override
    public String toString() {
        return nom + " (" + role + " - " + equipe + ")";
    }
}


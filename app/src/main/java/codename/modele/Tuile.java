package codename.modele;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TuileMot.class, name="Mot"),
        @JsonSubTypes.Type(value = TuileImage.class, name="Image")
})

/*
 * Tuiles est la classe des tuiles avec des mots
*/
public abstract class Tuile {
    protected int equipe; // -1 si carte noire 0 si carte blanche, 1 pour l'équipe bleu, 2 pour l'équipe rouge
    protected boolean estRetournee; // true si la carte est trouvé, false sinon

    public Tuile() { }

    public Tuile(int equipe) {
        this.equipe = equipe;
        this.estRetournee = false;
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

    public boolean isEstRetournee() {
        return estRetournee;
    }

    public void setEstRetournee() {
        if (!this.estRetournee){
            this.estRetournee = true;
        };
    }

    @Override
    public String toString() {
        return "Tuiles{" +
                ", equipe=" + equipe +
                ", estTrouve=" + estRetournee +
                '}';
    }
    
}

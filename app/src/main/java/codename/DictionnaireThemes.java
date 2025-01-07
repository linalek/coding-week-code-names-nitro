package codename;

import java.util.*;

public class DictionnaireThemes {
    private static Map<String, List<String>> themes = new HashMap<>(); // Map<Theme, List<Mots>> est un dico pour 

    static {
        themes.put("Géographie", Arrays.asList(
            "Afrique", "Allemagne", "Amérique", "Australie", "Angleterre",
            "Canada", "Chine", "Grèce", "Russie", "Espagne", "Europe",
            "Berlin", "Londres", "New-York", "Paris", "Rome", "Tokyo",
            "Himalaya", "Forêt", "Jungle", "Temple", "Atlantique", "Baie"
        ));

        themes.put("Nature et Animaux", Arrays.asList(
            "Aiguille", "Aile", "Air", "Alien", "Alpes", "Araignée",
            "Baleine", "Chat", "Chien", "Cochon", "Canard", "Pingouin",
            "Serpent", "Lion", "Kangourou", "Licorne", "Oiseau", "Grenade",
            "Requin", "Herbe", "Feuille", "Chou", "Fraise", "Pomme",
            "Neige", "Orage", "Vague", "Glace", "Vent", "Feu", "Terre", "Eau"
        ));

        themes.put("Alimentation et Boissons", Arrays.asList(
            "Banane", "Poire", "Orange", "Kiwi", "Camembert", "Bière",
            "Vin", "Champagne", "Café", "Chocolat", "Miel", "Pain",
            "Poisson", "Pêche", "Fraise", "Chou"
        ));

        themes.put("Objets et Outils", Arrays.asList(
            "Appareil", "Avion", "Bouteille", "Boîte", "Bureau", "Machine", 
            "Microscope", "Portable", "Radio", "Couteau", "Brique", "Paille", 
            "Corde", "Marteau", "Clé", "Colle", "Fer", "Papier", "Table", 
            "Chaise", "Lit", "Meuble", "Ampoule", "Bougie", "Balle", "Ballon", 
            "Bouchon", "Bouton", "Boule", "Bouteille"
        ));

        themes.put("Transports", Arrays.asList(
            "Avion", "Bateau", "Voiture", "Train", "Vaisseau", "Camion", 
            "Pilote", "Route", "Piste", "Pont", "Port", "Quai"
        ));

        themes.put("Émotions et Concepts Abstraits", Arrays.asList(
            "Amour", "Peur", "Joie", "Tristesse", "Espoir", "Argent", "Chance", 
            "Égalité", "Liberté", "Justice", "Révolution", "Vie", "Maladie", 
            "Mort", "Pensée", "Cœur"
        ));

        themes.put("Mythologie et Fiction", Arrays.asList(
            "Dragon", "Licorne", "Vampire", "Fantôme", "Sirène", "Astérix", 
            "Schtroumpf", "Ninja", "Héros", "Sorcière"
        ));

        themes.put("Professions et Rôles", Arrays.asList(
            "Docteur", "Marin", "Pilote", "Policier", "Pirate", "Avocat", 
            "Ingénieur", "Enseignant", "Roi", "Reine", "Princesse", "Soldat", 
            "Voleur"
        ));

        themes.put("Sciences et Éducation", Arrays.asList(
            "Physique", "Chimie", "Biologie", "Astronomie", "École", "Classe", 
            "Étude", "Mémoire"
        ));

        themes.put("Arts et Divertissements", Arrays.asList(
            "Peinture", "Musique", "Danse", "Cinéma", "Théâtre", "Jeu", 
            "Cirque", "Casino", "Club", "Concert"
        ));

        themes.put("Corps Humain", Arrays.asList(
            "Main", "Pied", "Tête", "Œil", "Langue", "Visage", "Nez", "Oreille", 
            "Bouche"
        ));

        themes.put("Temps et Calendrier", Arrays.asList(
            "Jour", "Nuit", "Mois", "Année", "Hiver", "Été", "Printemps", 
            "Automne", "Temps"
        ));

        themes.put("Divers", Arrays.asList(
            "Étoile", "Croix", "Cercle", "Triangle", "Zéro", "Sept", "Lettre", 
            "Numéro", "Magie", "Technologie", "Guerre", "Paix", "Vol", "Volume"
        ));
    }


    /*
     * Cette méthode permet de renvoyer tous les mots du dictionnaire,
     * peu importe le thème.
    */
    public static List<String> getAllMots() {
        List<String> allMots = new ArrayList<>();
        for (List<String> mots : themes.values()) {
            allMots.addAll(mots);
        }
        return allMots;
    }

    /*
     * Cette méthode permet de renvoyer tous les thèmes du dictionnaire.
    */
    public static Set<String> getThemes() {
        return themes.keySet();
    }

    /*
     * Cette méthode permet de renvoyer tous les mots du dictionnaire,
     * en fonction du thème fourni.
    */
    public static Collection<? extends String> getMotsParTheme(String theme) {
        return themes.getOrDefault(theme, Collections.emptyList());
    }

    /*
     * Cette fonction vérifie si un thème existe afin de lui ajouter un mot,
     * ou le crée s'il n'existe pas.
    */
    public static void ajouterMotAuTheme(String theme, String mot) {
        if (themes.containsKey(theme)) {
            List<String> mots = themes.get(theme);
            if (!mots.contains(mot)) {
                mots.add(mot);
            } else {
                System.out.println("Le mot existe déjà dans le thème : " + theme);
            }
        } else {
            List<String> nouveauxMots = new ArrayList<>();
            nouveauxMots.add(mot);
            themes.put(theme, nouveauxMots);
            System.out.println("Nouveau thème créé : " + theme);
        }
    }
}
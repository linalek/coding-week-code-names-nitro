package codename;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DictionnaireThemes {
    private static Map<String, List<String>> themes = new HashMap<>(); // Map<Theme, List<Mots>> est un dico pour 

    static {
        themes.put("Géographie", Arrays.asList(
            "Afrique", "Allemagne", "Amérique", "Australie", "Angleterre",
            "Canada", "Chine", "Grèce", "Russie", "Espagne", "Europe",
            "Berlin", "Londres", "New-York", "Paris", "Rome", "Tokyo",
            "Himalaya", "Forêt", "Jungle", "Temple", "Atlantique", "Baie",
            "Montagne", "Rivière", "Lac", "Désert", "Volcan", "Océan"
        ));
        
        themes.put("Nature et Animaux", Arrays.asList(
            "Aiguille", "Aile", "Air", "Alien", "Alpes", "Araignée",
            "Baleine", "Chat", "Chien", "Cochon", "Canard", "Pingouin",
            "Serpent", "Lion", "Kangourou", "Licorne", "Oiseau", "Grenade",
            "Requin", "Herbe", "Feuille", "Chou", "Fraise", "Pomme",
            "Neige", "Orage", "Vague", "Glace", "Vent", "Feu", "Terre", "Eau",
            "Loup", "Renard", "Hibou", "Écureuil", "Tigre", "Girafe"
        ));
        
        themes.put("Alimentation et Boissons", Arrays.asList(
            "Banane", "Poire", "Orange", "Kiwi", "Camembert", "Bière",
            "Vin", "Champagne", "Café", "Chocolat", "Miel", "Pain",
            "Poisson", "Pêche", "Fraise", "Chou",
            "Pizza", "Hamburger", "Spaghetti", "Sandwich", "Tarte", "Lait"
        ));
        
        themes.put("Objets et Outils", Arrays.asList(
            "Appareil", "Avion", "Bouteille", "Boîte", "Bureau", "Machine", 
            "Microscope", "Portable", "Radio", "Couteau", "Brique", "Paille", 
            "Corde", "Marteau", "Clé", "Colle", "Fer", "Papier", "Table", 
            "Chaise", "Lit", "Meuble", "Ampoule", "Bougie", "Balle", "Ballon", 
            "Bouchon", "Bouton", "Boule", "Bouteille",
            "Tournevis", "Lampe", "Ordinateur", "Écran", "Clavier", "Chaîne"
        ));
        
        themes.put("Transports", Arrays.asList(
            "Avion", "Bateau", "Voiture", "Train", "Vaisseau", "Camion", 
            "Pilote", "Route", "Piste", "Pont", "Port", "Quai",
            "Vélo", "Tramway", "Métro", "Scooter", "Fusée", "Montgolfière"
        ));
        
        themes.put("Émotions et Concepts Abstraits", Arrays.asList(
            "Amour", "Peur", "Joie", "Tristesse", "Espoir", "Argent", "Chance", 
            "Égalité", "Liberté", "Justice", "Révolution", "Vie", "Maladie", 
            "Mort", "Pensée", "Cœur",
            "Courage", "Honte", "Bonheur", "Curiosité", "Inspiration"
        ));
        
        themes.put("Mythologie et Fiction", Arrays.asList(
            "Dragon", "Licorne", "Vampire", "Fantôme", "Sirène", "Astérix", 
            "Schtroumpf", "Ninja", "Héros", "Sorcière",
            "Phoenix", "Centaure", "Golem", "Zombie", "Elfe"
        ));
        
        themes.put("Professions et Rôles", Arrays.asList(
            "Docteur", "Marin", "Pilote", "Policier", "Pirate", "Avocat", 
            "Ingénieur", "Enseignant", "Roi", "Reine", "Princesse", "Soldat", 
            "Voleur",
            "Dentiste", "Architecte", "Plombier", "Cuisinier", "Jardinier"
        ));
        
        themes.put("Sciences et Éducation", Arrays.asList(
            "Physique", "Chimie", "Biologie", "Astronomie", "École", "Classe", 
            "Étude", "Mémoire",
            "Mathématiques", "Histoire", "Géographie", "Informatique", "Programmation"
        ));
        
        themes.put("Arts et Divertissements", Arrays.asList(
            "Peinture", "Sculpture", "Musique", "Danse", "Théâtre",
            "Cinéma", "Photographie", "Dessin", "Calligraphie", "Graffiti",
            "Architecture", "Fresque", "Opéra", "Mosaïque", "Illustration",
            "Céramique", "Tapisserie", "Gravure", "Vitrail", "Performance",
            "Pop Art", "Renaissance", "Cubisme"
        ));
        
        themes.put("Corps Humain", Arrays.asList(
            "Main", "Pied", "Tête", "Œil", "Langue", "Visage", "Nez", "Oreille", 
            "Bouche",
            "Épaule", "Genou", "Coude", "Ventre", "Cheveux"
        ));
        
        themes.put("Temps et Calendrier", Arrays.asList(
            "Jour", "Nuit", "Mois", "Année", "Hiver", "Été", "Printemps", 
            "Automne", "Temps",
            "Minute", "Seconde", "Heure", "Décennie", "Jour férié"
        ));
        
        themes.put("Divers", Arrays.asList(
            "Étoile", "Croix", "Cercle", "Triangle", "Zéro", "Sept", "Lettre", 
            "Numéro", "Magie", "Technologie", "Guerre", "Paix", "Vol", "Volume",
            "Robot", "Galaxie", "Univers", "Planète", "Satellite"
        ));

        themes.put("Les Méchants dans les Films", Arrays.asList(
            "Voldemort", "Vader", "Joker", "Thanos", "Lecter",
            "Palpatine","Jafar", "Hades", "Ursula",
            "Hans", "Lotso","Grinch","Maléfique", "Cruella"
        ));

        themes.put("Technologie", Arrays.asList(
            "Python", "Java", "Rust", "Go", "Docker", 
            "Kubernetes", "Git", "Linux", "Bash", "Cloud",
            "CI/CD", "Ansible", "Terraform", "PostgreSQL", "MySQL",
            "Redis", "MongoDB", "React", "Node", "Angular",
            "API", "Microservice", "Container", "Pipeline", "Nginx",
            "Apache", "Prometheus", "Grafana", "Jenkins", "Cassandra"
        ));
        themes.put("Histoire", Arrays.asList(
            "Renaissance", "Vikings", "Empire", "Égypte", "Rome",
            "Moyen Âge", "Révolution", "Guillotine", "Pharaon", "Chevalier",
            "Incas", "Napoléon", "Châteaux", "Guerre", "Croisade",
            "Samouraï", "Colonisation", "Pré-histoire", "Gladiateur", "Pirate",
            "Troie", "Spartiate", "Dynastie", "Reine", "Roi"
        ));
        themes.put("Personnes Célèbres", Arrays.asList(
            "Napoléon", "Einstein", "Darwin", "Mozart", "Picasso",
            "Newton", "Tesla", "Platon", "Aragon", "Homère",
            "V. Hugo", "Curie", "S. Jobs", "Gandhi", "Luther",
            "Molière", "Freud", "Brahms", "Fermat", "Cézanne"
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
    
            if (!(mots instanceof ArrayList)) {
                mots = new ArrayList<>(mots);
                themes.put(theme, mots); 
            }
    
            if (!mots.contains(mot)) {
                mots.add(mot);
            } else {
                System.out.println("Le mot existe deja dans le theme : " + theme);
            }
        } else {
            List<String> nouveauxMots = new ArrayList<>();
            nouveauxMots.add(mot);
            themes.put(theme, nouveauxMots);
            System.out.println("Nouveau theme cree : " + theme);
        }
    }

    public static void sauvegarderDictionnaire(String cheminFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(cheminFichier), themes);
        System.out.println("Dictionnaire sauvegarde");
    }

    public static void chargerDictionnaire(String cheminFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, List<String>> loaded = mapper.readValue(
                    new File(cheminFichier),
                    new TypeReference<Map<String, List<String>>>() {}
            );
            themes = loaded;
            System.out.println("Dictionnaire chargé depuis " + cheminFichier);
        } catch (FileNotFoundException e) {
            System.out.println("Aucun dictionnaire sauvegarde trouve ("
                    + cheminFichier + ") => on part d'un dico par defaut.");
        }
    }

}
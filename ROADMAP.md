# ROADMAP 

## TODOLIST

### JOUR 1

- Le système des tuiles de grille et du jeu en lui-même qui fonctionne.

### JOUR 2

- Créer un bouton de retour.
- il faut que le bouton Play pose les questions pour les réglages.

- attention à ce qu'il n'y ai pas 2x le meme mot
- Essayer d’avoir un jeu qui fonctionne pour deux personnes.
- Ajouter la sauvegarde et la possibilité de restaurer une partie après avoir fermé l’application.
- Implémenter le jeu à plusieurs utilisateurs.
- Implémenter le jeu en Blitz avec le sablier et les partis custom.

### JOUR 3

- Ajouter les statistiques.
- Fonction d'ajout de ses propres mots.

### JOURS SUIVANTS

- Ajouter une musique et un bouton de volume.
- Se pencher sur les Fonctionnalités avancées.


## RÉALISÉ

### Jour 1
- Création du projet et de la structure de base avec Gradle et JavaFX.
- réflexion sur l'architecture du projet : différentes vues
- Importation du dictionnaire des mots du jeu
- Création du menu : bouton quitter et règles du jeu fonctionnel
- Création de la page d'accueil : style et bouton "Jouer"
- Création de la grille de jeu : tuiles de jeu et grille de jeu
- Création de la classe Tuile et de la classe Grille
- Implémentation de tests unitaires pour les classes du modele
- Implémentation de la classe Jeu
- Implémentation du plateau de Jeu

### Jour 2
- Jeu : ajout des variables nécessaires à la création du jeu et méthode retournerTuile
- Grille : prise en compte de la sélection de mot par thème
- Repasser sur tuile
- Mise en place de la structure pour les espions : vue et controleur
- Restructure du front : utilisation de fxml pour les objets et les vues
- Correction de l'affichage du menu et du plateau
- Fonction pour afficher les statistiques
- Vue agent et espion et le globalControleur qui gère les switches entres les différentes vues
- Tuiles cliquables
- Création des 2 versions du plateau
- Bouton du menu
- Interface d'affichage des éuquipes
- Page de configuration des équipes
- classe Joueur et Equipe
- Intégration du jeu
- Gestion des equipes et des joueurs
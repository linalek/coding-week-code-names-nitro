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

- Faire le lien avec le jeu.
- Implémentation de la création des équipes
- Ajouter les statistiques
- Ajouter les ecrans de chargement entre le mode agent et le mode espion
- Implémenter le jeu en Blitz avec le sablier
- Implémenter le lien entre le fenêtre custom et la customisation d'une partie
- Fonction d'ajout de ses propres mots : modifier le dictionnaire
- Sauvegarde/restauration de la partie
- Mode Image ?

### JOUR 4

- (Ajouter une musique et un bouton de volume)
- Sauvegarde / restauration de la partie : Hugo
- Equipes visibles : Julien
- liaison avec les statistiques : gestion des statistiques : Lina
- jeu en blitz = intégrer un sablier pour limiter le temps de réflexion de l'espion : Lucie
- customisation de partie : Lina
- mode image
- test unitaire : Lucie
- page de chargement en fonction des équipes : Lina
- mode solo : indices préprogrammés
- mode plusieurs joueurs
- afficher qui est l'agent et qui est l'espion sur la box 
- Modification dans le dictionnaire fonctionne ?
- utiliser le design pattern observer
- vérifier qu'il n'y a aucun élément de design dans le code : Lina
- prendre en compte que l'équipe qui commence doit faire deviner un mot de plus (9 et 8 mois)
- ajouter des commentaires permettant de comprendre ce que fais chaque classe/fonction
- documenter l'installation et l'éxecution du jeu : Readme.md

### JOUR 5
- vidéo démo du jeu : audio + screncast à publier (youtube ou dailymotion) avec le lien dans le readme.md

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

### Jour 3
- Stockage des équipes dans le GlobalControleur
- Ajout des pages de chargement entre les différentes phases du jeu
- Liaison avec la classe Jeu
- Système de jeu qui fonctionne
- Ajout de dictionnaire
- Correction sur le menu
- Correction de vue fxml
- Ajout des pages victoire
- Fonctionnalité d'ajout de mots et de thèmes 

### Jour 4
- Visibilité des équipes sur les pages de jeu
- Ajout de l'indice avec le nombre de cartes dans le jeu
- Ajout des changement de vue agent/espion dynamique 
- premier jet pour la sauvegarde
- fix de l'inversement des cartes et des couleurs
# Code Names Nitro - CodingWeek 2025
**TELECOM Nancy - 06/01 au 10/01**

**Code Names Nitro** est une application Java/JavaFX inspirée du jeu de société CodeNames™. 
Ce jeu d'association d'idées et de déduction propose des fonctionnalités interactives pour des parties captivantes entre 2 à 8 joueurs (ou plus, en équipes).

## Fonctionnalités principales

1. **Configuration personnalisée des parties :**
    - Taille de la grille (par défaut : 5x5).
    - Sélection de la thématique des mots (par défaut : aléatoire dans tous les thèmes du dictionnaire).
    - Nombre de joueurs (par défaut : 4 joueurs en 2 équipes).
    - Limitation du temps de réflexion.

2. **Jeu interactif :**
    - Respect des règles du jeu original.
    - Alternance entre mode agent et mode espion, permettant de jouer sur un même écran.

3. **Sauvegarde et chargement de parties :**
    - Reprendre une partie sauvegardée.

4. **Gestion des listes de mots :**
    - Création et édition de nouvelles listes/thématiques.

5. **Support des extensions :**
    - Mode "blitz" (temps limité).
    - Mode "images" : utilisation de cartes avec des images.
    - Statistiques des parties et des joueurs.
    - Mode Solo : indisponible.

## Installation et exécution

### Prérequis
- Java 17 ou supérieur.
- [Gradle](https://gradle.org/) pour la gestion des dépendances.

### Instructions
1. **Cloner le dépôt :**
   ```bash
   git clone <URL_DU_DÉPÔT>
   cd coding-week-code-names-nitro
   ```

2. **Exécution :**

   Lancer l'application :
   ```bash
   java --module-path ${JAVAFX_HOME}/lib --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.web -jar codename.jar
   ```

4. **Tests :**
   Exécuter les tests unitaires pour vérifier la stabilité du logiciel :
   ```bash
   gradle test
   ```

## Structure du projet

- `src/main/java/` : Code source principal.
- `src/main/resources/` : Fichiers FXML et ressources statiques.
- `src/test/java/` : Tests unitaires.
- `build.gradle` : Configuration Gradle.

## Utilisation

1. Lancez l'application.
2. Lancer le jeu en mode normal ou dans n'importe quel mode proposé.
3. Commencez à jouer en respectant les règles.
4. Sauvegardez votre partie à tout moment.
5. Consultez les statistiques après chaque partie.

Différents modes se présentent à vous :
- Mode normal : Jouez à Code Names Nitro en respectant les règles du jeu original.
- Mode blitz : Jouez à Code Names Nitro avec un temps limité pour chaque tour.
- Mode images : Jouez à Code Names Nitro avec des cartes images.
- Mode solo : Jouez à Code Names Nitro en solo. (indisponible)
- Statistiques : Consultez les statistiques des parties et des joueurs.
- Personalisation : Personnalisez votre partie en choisissant la taille de la grille, la thématique des mots, le nombre de joueurs, en mode blitz ou images.

## Démonstration

Une démonstration vidéo de l'application est disponible ici : [Lien vers la vidéo](https://youtu.be/NtQGSZoFMNM).

## Contributions

Le développement a été réalisé dans le cadre de la CodingWeek 2025. Chaque contribution est tracée via Git, et les commits de tous les membres de l'équipe sont visibles dans l'historique.

## Groupe **Discord Nitro**
- Lucie Correia
- Lina Lekbouri
- Julien Marland
- Hugo Werck

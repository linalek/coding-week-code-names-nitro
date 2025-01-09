import os

def lister_fichiers_jpeg():
    # Récupérer le chemin du répertoire contenant le script
    dossier_actuel = os.path.dirname(os.path.abspath(__file__))

    # Lister les fichiers JPEG dans le dossier
    fichiers_jpeg = [f for f in os.listdir(dossier_actuel) if f.lower().endswith('.jpg')]

    # Créer une liste directement assignable à un List<String> en Java
    fichiers_jpeg_java = ", ".join(f'"{f}"' for f in fichiers_jpeg)
    return f'List<String> fichiers = Arrays.asList({fichiers_jpeg_java});'

if __name__ == "__main__":
    liste_fichiers_java = lister_fichiers_jpeg()
    print(liste_fichiers_java)

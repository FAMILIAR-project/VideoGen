# VideoGen [Pull&Play]

Ce dépôt contient toutes les dépendances nécessaires (librairie FFMPEG, les vidéos). Il suffit de le pull et d'exécuter les fichiers Xtend (videogen/src/videogen/*.xtend).  
Les dossiers Gif et Thumbnails sont volontairement vides. Les fichiers résultats seront automatiquement créés grâce aux fichiers Xtend.


A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  

# Réponses aux questions

## Question 12

#### Implémenter une telle solution en effectuant une requête à un serveur Web (via JavaScript) lors du clique du bouton « Generate » ; le serveur génèrerait alors une nouvelle playlist aléatoirement.

Pour implémenter cette solution, on pourrait établir un serveur Web classique et faire un appel AJAX sur le clic du bouton "Generate", qui genererait une séquence de vidéos aléatoire.
Pour ce faire, une route spéciale doit être implémentée (http://www.urlduserveur.fr/generate/). Cette route générant une vidéo aléatoire permet d'accéder au script (J2EE, PHP ...), créant alors le fichier playlist .m3u interprété par le lecteur Web.

## Question 13

#### Implémenter une solution en effectuant une requête à un serveur Web (via JavaScript) qui génèrerait alors la playlist correspondante aux choix de l’utilisateur.

Pour cette question, on reprendrait l'implémentation de la question précédente en modifiant les données envoyées sur le clic par l'utilisateur (les vidéos choisies, les priorités, leurs pourcentages de chances d'apparaître ...). Ces données, envoyées sous forme de paramètres POST (via un script AJAX), seraient traîtées par le script d'arrivée, qui génèrererait alors une playlist .videogen.
Cette playlist serait créée par parse des données en entrée, dans une boucle, qui créerait alors les lignes dans le fichier playlist.videogen. Une fois cette playlist créée, le serveur lancerait la commande "ffprobe.exe" afin de générer la playlist .m3u.
Une fois les données établies, on renvoie le lien de la playlist .m3u créée à l'utilisateur, en paramètre du lecteur vidéo.

## Question 14

#### Formaliser les exigences sous forme d’un feature model. L’idée est qu’à partir d’une configuration du feature model (eg mode crazy sans sauvegarde mais avec visualisation des vignettes) on déploie un nouveau site Web avec Jhipster. Vous utiliserez FAMILIAR et son DSL externe.

* Le VideoGenerator possède deux modes : Aléatoire, Composé ou Probabiliste
* Le mode Composé (composition de vidéos à la demande de l'utilisateur) est lié soit à une vidéo Alternative, soit une vidéo Probabiliste

## Question 15

#### Démontrer que vous êtes d'ores et déjà capable de déployer un Jhipster / VideoGen en fonction de certaines configurations valides de votre feature model.

Nous avons créé un fichier Xtend qui vérifie que la configuration envoyée par l'utilisateur est valide (pas de vidéos dupliquées, pas d'ID dupliqués, les sommes de probabilité supérieures à 100 ...).  
En cas d'erreur, un message est envoyé à l'utilisateur pas le biais d'une AlertBox.  
Dans les cas valides, la playlist ainsi créée est jouée par le lecteur vidéo.

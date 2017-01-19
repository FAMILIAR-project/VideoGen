# VideoGen

A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  


## Fichiers et Dossiers
Réponses aux questions du TP : 
* **_videogen/src/videogen/Answers.xtend_** : Transformations xtend permettant de répondre aux questions
* **_videogen/src/videogen/IdmUtil.xtend_** : Méthodes statiques communes à plusieurs fichiers xtend permettant par exemple de charger un modéle de `VideoGen`, créer un fichier, de vérifier un modèle de `VideoGen`
* **_videogen/quest_rep_files_** : Dossier qui ontient les fichiers (ffmpeg, m3u) générés par les transformations xtend
* **_videogen/videos.videogen, videogen/videos.videogen-fail-location.videogen, videogen/videos.videogen-fail-proba.videogen_** : les fichiers videogen utilisés pour les transformations xtend
* **_videogen/vignettes_** : Dossier qui contient les vignettes générées à partir des vidéos, ainsi que les fichiers html

<br>Exercices complémentaires : 

* **_videogen/src/videogen/InsertText.xtend_** : Transformations xtend permettant d'insérer du texte dans une vidéo
* **_videogen/inserted_text_** : Dossier contenant les vidéos avec le texte inséré
* **_videogen/src/videogen/Gification.xtend_** : Transformations xtend permettant de créer des gif à partir de vidéos
* **_videogen/gification_** : Dossier contenant les gifs et le fichier ffmpeg générés


## Question 14

`fmGen = FM (VideoGenerator: Mode ; Mode: (Random|Probability|Configurator|Crazy); Random: WithRandom; Probability:                      WithProbability; Configurator: (Basic|Hybrid); Basic: WithConfig; Hybrid: WithConfig (WithRandom|WithProbability);              Crazy: WithRandom [WithProbability] [WithConfig];)`

* **Mode** : soit Random, soit Probability, soit Configurator ou soit Crazy
* **Random** : utilise seulement de l'aléatoire avec WithRandom
* **Probability** : utilise seulement des probabilités avec WithProbability
* **Configurator** : soit Basic, soit Hybride
* **Basic** : utilise seulement de la configuration avec WithConfig
* **Hybrid** : utilise de la configuration (WithConfig) plus soit de l'aléatoire (WithRandom), soit des probabilités (WithProbability)
* **Crazy** : utilise de l'aléatoire (WithRandom) et de la configuration (WithConfig) ou non et des probabilités (WithProbability) ou non

## Question 15

Les modes Random et Configurator de notre feature model sont déjà disponibles grâce aux questions 12 et 13 (même si ce n'est pas fait dans notre tp). Nous avons des transformations xtend qui décrivent et implémentent nos modes. Et avec Jhipster nous avons un site web qui permet d'appeler et d'exécuter ces modes via une interface graphique.<br>
Pour implémenter les autres modes il faudrait donc écrire des transformations xtend, puis ensuite enrichier notre site web pour permettre d'exécuter ces nouveaux modes en faisant appel à ces transformations xtend.

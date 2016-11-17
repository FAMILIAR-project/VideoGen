# VideoGen

A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  

## Answers
Q1: Création d'une classe xtend VideoGenToFFMPEG.xtend
Q2/Q3: Modèle intermedaire plus couteux à mettre en oeuvre qu'une model-to-text direct
Q4: Création d'une classe xtend VideoGenToM3U
Q5: Besoin de rajouter le temps sur le modèle intermedaire, donc sur le modèle primaire. Utiliser FFMPEG qui peut renvoyer directement le temps de la vidéo ?
Q6: Pas d'utilisation d'un modèle intermediaire vu qu'on compte changer le méta-modèle VideoGen -> perte de temps. Un model-to-text est plus rentable à implémenter.

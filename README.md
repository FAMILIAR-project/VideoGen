# VideoGen

A configurable generator of generator of video variants 

## Dossiers ajoutés

* concatenationVideos = contient les fichiers qui ont été générés par la fonctionnalité de concaténation des videos.
* generatedPlayList = contient des examples de fichiers m3u générés par notre application.
* gif = contient les fichiers .gif résultat de l'exécution de la classe "VideoDemostratorConvertToGif.xtend"
* vignettes = contient les images extraites des videos grâce à ffmpeg, des pages HTML qui répondent à la question 9 et 11 et un fichier css pour le style des pages.

## Model Ecore PlayList

https://github.com/SandraIsabel/videogenPlayList


## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  

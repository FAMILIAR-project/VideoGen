# VideoGen

A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  

##Question 14

fmGen = FM (VideoGenerator: Mode; Mode: (Random|Probability|Configurator); Configurator: (WithRandom|WithProbability); ) 

* VideoGenerator a un mode 
* une Mode est soit Random, Probability ou Configurator
* Configurator est associé à Probability ou alternative

##Question 15
* Creation d'un script Jhipster qui prend en parametre la configuration

* Selon le type de config, lancer la bonne commande Jhipster pour le site 

	* mode Aléatoire : qu'un bouton à generer
	
	* mode Probabilité : qu'un bouton à generer
	
	* mode Configurator : ajouter un champ pour choisir l'aléatoire ou probabilité et videogen les ajoutera aux videos 		obligatoires
	

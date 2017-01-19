# VideoGen

A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  


## Fichiers et Dossiers

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


# VideoGen

A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  


## Fichiers et Dossiers

## Question 14

`fmGen = FM (VideoGenerator: Mode ; Mode: (Random|Probability|Configurator|Crazy); Random: WithRandom; Probability:                      WithProbability; Configurator: (Basic|Hybrid); Basic: WithConfig; Hybrid: WithConfig (WithRandom|WithProbability);              Crazy: [WithProbability] [WithConfig];)`


## Question 15

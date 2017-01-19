# VideoGen

A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  


##Verification of specifications

The project includes a method that reads a videogen file and emits warnings through the java Logger.
- Normal warning if 2 different videos share the same path or id.
- Severe warning if at some point in the file a probability greater than 100 is specified.

The method is the method "CheckSpecs" from the file Specifications.extend.

##Familiar

The project supports the generation of familiar files from a videogen file. The method `toFamiliar(String input, String output)` takes a file from the specified input location and generate a videogen file with the specified output name. All videos and alternative list must have a id or else the generator will throw a nullPointerException.


## Web app
Launch the fr.istic.idm.VideoGenApp.java to launch the wepapp
Them open a browser and go to http://127.0.0.1:8080
Sign in by using login: admin pwd: admin
The generate button trigger the generation of the vignettes for the q10.videogen in the folder src/main/resources/videogen

# VideoGen

A configurable generator of video variants. This is a fork of original project to realise a Student Project for IDM course (M2 Miage).

## Motivation

The purpose of this project is to generate randomly a new video with some "samples" videos . We want to choose which video is mandatory, which video is optional or to choose one video between n videos to make a new video sequence.  
Also, we want to add some options/treatments like generating picture, adding text, making some statistics, etc... and we want to create differents output formats (ffmpeg or M3U).  

This project allows to discover,to use, DSL by creating grammar, making model-to-text or model-to-model transformation, and learn to use some libraries for manipulate videos.  

## Technology
Technologies used for this project:  
-Xtext to create grammar,to generate meta-model and to create model editor.  
-Xtend to use grammar and models in order to generate something usable (scripts, files...).  
-FFmpeg to transform videos and to read generated scripts.  
-Familiar project tool to create Feature model.  

## Project structure

-org.xtext.example.videogenerator\src\org\xtext\example\mydsl\VideoGen.xtext : Grammar of DSL.  
-PlayListMeta: projet to create and new DSL for playlists (model-to-model).   
-VideoGenForked\videogen\src\videogen: Folder where all xtend (=transformation) are created.  
  
-"Réponses aux questions.txt" File with all responses about IDM Student Project.  
-"Q14 - Feature model.txt" Feature model for answer to question 14.  



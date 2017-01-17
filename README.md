# VideoGen

A configurable generator of video variants. This is a fork of original project for realise a Student Project for IDM course (M2 Miage).

## Motivation

The purpose of this project is generate randomly a new video with few "samples" videos . We want chose which video is mandatory, which video is optional or choose one video between n videos for make a video sequence.
Also we want add some options/treatments like generate picture, add text, make few statistics, etc... and we want create different format output (ffmpeg or M3U).

This project allows to discover, use DSL by creating grammar, making model-to-text or model-to-model transformation, and using some libraries for manipulate videos.

## Technology

Technologies uses for this project:  
-Xtext for create grammar, generate meta-model and create model editor.  
-Xtend for use grammar and model in order to generate something usable (scripts, files...).  
-FFmpeg for transform videos and read generated scripts.  
-Familiar project tool for create Feature model.  

## Project structure

-org.xtext.example.videogenerator\src\org\xtext\example\mydsl\VideoGen.xtext : Grammar of DSL.  
-PlayListMeta: projet to create and new DSL for playlists (model-to-model).   
-VideoGenForked\videogen\src\videogen: Folder where all xtend (=transformation) are created.  
  
-"Réponses aux questions.txt" file with all responses about IDM Student Project.  
-"Q14 - Feature model.txt" Feature model for answer to question 14.  



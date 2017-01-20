# VideoGen - IDM Project (M2GLA2016-17) - Nirina RANAIVOSON

This fork is an extension of this project realized in the context of IDM (Model Driven Engineering) course @Istic, Rennes.

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation. I've put my own extension into this project and will explain them later.

`playlist` is a Xtext projects to define a new Model which can be transformed into FFMpeg or m3u playlist

## Questions done
I've worked on the five first parts of the subject, and answered two more questions : VideoGen Specification Synthesis & some metrics computation.

Part 1 : `ModelToText.xtend` generates a ffmpeg playlist file from a given videogen specification.

Part 2 : `VideogenToPlaylist.xtend` generates a Playlist object from a given videogen specification and writes it into a .m3u file or a ffmpeg playlist.

Part 3 : `DurationComputation.xtend` from a Videogen specification, compute duration for each videos and generates a playlist into m3uext format.

Part 4 : `ThumbnailGenerator.xtend` from a Videogen specification, generates thumbnail for each videos and present them in a simple .html file.

Part 5 : `VideogenChecking.xtend` checks some properties from a Videogen specification. If IDs are absent or not unique, if probability properties are not conformant (100% for Mandatory videos, sum of 100% for Alternatives), and check if files are present @location. It prints on screen the invalidited properties.

(optional) VideoGen Specification Synthesis : `SpecificationGenerator.xtend`, from a given folder, generates a specification with following rules : 
 - at first level we should only find folders. Files would not be taken in and would raise a onscreen Warning
 - folders should not be empty and contains only files. SubFolder would raise a Warning
 - if the folder contains only one file, it becomes a Mandatory Video, else they are subitems of an Alternative Video

(optional) some Metrics Computation : `MetricsComputation.xtend` takes a Videogen specification and compute some metrics on it. The specification is supposed to be valid (IDs not null). The metrics computed are :
 - total number of playlist variation
 - mean, max and min length
 - mean, max and min filesize
It also compute at most 10 variation and writes them with their length and filesize in .csv file

# VideoGen

A configurable generator of generator of video variants 

## Project structure

`org.xtext.example.videogenerator.*` are Xtext projects with the grammar and an extension to "tune" the IDE behavior (checking of unique IDs on the fly). 

`videogen` is a Java/Xtend project that uses the Xtext project and shows how to transform a VideoGen transformation.  


Project 1: Text inside Video

result inside JUnit:
---------------------------
Mandatory
debut
ffmpeg -i C:/Users/kaoutar/git/VideoGen/videogen/videosTel/nancyagram.mp4 -vf drawtext='fontsize=15:fontfile=FreeSerif.ttf:text=Mandatory:y=100:x=100' -codec:a copy C:/Users/kaoutar/git/VideoGen/videogen/videosTel/nancyagram-2.mp4

C:/Users/kaoutar/git/VideoGen/videogen/videosTel/nancyagram-2.mp4
Optional
debut
ffmpeg -i C:/Users/kaoutar/git/VideoGen/videogen/videosTel/vdf.mp4 -vf drawtext='fontsize=15:fontfile=FreeSerif.ttf:text=Optional:y=100:x=100' -codec:a copy C:/Users/kaoutar/git/VideoGen/videogen/videosTel/vdf-2.mp4

Optional
Optional
debut
ffmpeg -i C:/Users/kaoutar/git/VideoGen/videogen/videosTel/videoplayback.mp4 -vf drawtext='fontsize=15:fontfile=FreeSerif.ttf:text=Optional:y=100:x=100' -codec:a copy C:/Users/kaoutar/git/VideoGen/videogen/videosTel/videoplayback-2.mp4

Alternatives
debut
ffmpeg -i C:/Users/kaoutar/git/VideoGen/videogen/videosTel/standbyme.mp4 -vf drawtext='fontsize=15:fontfile=FreeSerif.ttf:text=Alternative:y=100:x=100' -codec:a copy C:/Users/kaoutar/git/VideoGen/videogen/videosTel/standbyme-2.mp4

-------------------------------------------------------------------

In Cmd console:

![alt tag](https://github.com/kaouthare/VideoGen/tree/master/videogen/textrep.png)

So, UNRESOLVED BUG about bad path or unknown fonts




# VideoGen

A configurable generator of generator of video variants 

## Note
The project is calling FFMPEG in some Xtend transformations as follow: "val pb = new ProcessBuilder("CMD", "/C", cmd)".
It is not sure if the project will work on any other OS than Windows since the code specifically calls the CMD.
As of today, it has only be tested on Windows.

## Location

Xtend transformation: https://github.com/RomainG93/VideoGen/blob/master/videogen/src/videogen/VideoDemonstrator.xtend

Playlist Project: The Playlist project was created in a different folder from this project so it has been added manually here:
https://github.com/RomainG93/VideoGen/tree/master/Instruction/playlist

VideoGen model: Available here: https://github.com/RomainG93/VideoGen/blob/master/videogen/web/data/test1.videogen

Back-end VideoGen routes: https://github.com/RomainG93/VideoGen/blob/master/videogen/web/src/main/java/com/istic/videogen/web/rest/VideogenResource.java

Videos: videos are to be put here: https://github.com/RomainG93/VideoGen/tree/master/videogen/web/src/main/webapp/data/videos

## Installation

The project uses FFMPEG for video manipulation and JHipster for application generation.

FFMPEG installation: https://ffmpeg.org/download.html

Jhipster (install dependencies): https://jhipster.github.io/installation/

To have a set of videos, unzip the ".rar" archive located at https://github.com/RomainG93/VideoGen/tree/master/videogen/web/src/main/webapp/data/videos 
You should have the following hierarchy: 
VideoGen/tree/master/videogen/web/src/main/webapp/data/video1.mp4
VideoGen/tree/master/videogen/web/src/main/webapp/data/video2.mp4
etc

You can now the command "mvn" (path: /VideoGen/tree/master/videogen/web) to start the web server.
The application is available at "http://localhost:8080/#/videogen"

## Features / Screencast

### Random Mode
  A random playlist can be generated from the video list. Here, the basic rules are applied meaning mandatory videos are always picked and Optional and Alternative videos are picked base on their probabilities.
  The playlist is then rendered with flowplayer.
    
### Config Mode
  A custom playlist can be generated from the video list based on user choice.
  Here, mandatory videos are always picked. However, the user can select which optional and alternative videos are added to the playlist.
 The playlist is then rendered with flowplayer.

### Thumbnails
  Thumbnails of videos are generated during the loading of the page.
  Thumbnails are created in the folder VideoGen/tree/master/videogen/web/src/main/webapp/data/thumbnails

### GIF
  Gifs can be generated from the current playlist. All gifs will have a small part of each videos of the current playlist.
  All gifs are created in the folder https://github.com/RomainG93/VideoGen/tree/master/videogen/web/src/main/webapp/data/gifs
  
### Add text
  It is possible to add a text on a video or a set of videos. The text as well as the position of the text inside the video (top, middle, bottom) is defined by the user.
  This feature was tested on local server only and it took a while to generate a new video with a text on it due to the fact that the server was always restarting in order to update the classpath.
  

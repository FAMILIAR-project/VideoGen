PITON Stephen       M2GLA
EL GHZIZAL Yousra   M2GLA

----------------------
Our Architecture
----------------------

                |-------------------------| Emplacement |--------------------------------------------------------------------------|
Grammar:      |     VideoGen.xtext      =============> org.xtext.example.videogenerator/src/org/xtext/example/mydsl/VideoGen.xtext
                |-------------------------|             |--------------------------------------------------------------------------|  

                |-------------------------| Emplacement |--------------------------------------------------------------------------|
Méta-Model      |     VideoGen.ecore      =============> org.xtext.example.videogenerator/model/generated/VideoGen.ecore
VideoGen :      |-------------------------|             |--------------------------------------------------------------------------|  


                |-------------------------| Emplacement |--------------------------------------------------------------------------|
Méta-Model      |     playlist.ecore      =============> projet idm Q2/projet idm Q2/src/playlist.ecore
Playlist :      |-------------------------|             |--------------------------------------------------------------------------|  


Principal class
that contains
the responses 
Of the Project: |-------------------------| Emplacement |------------------------------------------------|
                |transformationsVideo.xtend=============>videogen/src/videogen/transformationsVideo.xtend
                |-------------------------|             |------------------------------------------------| 
		
                      
The test of the functions of our project is carried out in a Main class:
                |-------------------------| Emplacement |------------------------------------------------|
                |     Main.xtend           =============> videogen/src/videogen/Main.xtend
                |-------------------------|             |------------------------------------------------| 
                

The videos on which we did our tests are at a Repository at the root:
                |-------------------------| Emplacement |------------------------------------------------|
                |     dossier des videos   =============> videogen/v
                |-------------------------|             |------------------------------------------------|  

----------------------------
Remarks on Question 2
----------------------------  
For this question we created a new project for the playlist where we defined the meta_model 
of this playlist:

                |-------------------------| Emplacement |------------------------------------------------|
                |     playlist.ecore      =============>projet idm Q2/projet idm Q2/src/playlist.ecore
                |-------------------------|             |------------------------------------------------|  
 

----------------------------
Answer to Question 5
----------------------------

-Recommendations: It was necessary to calculate and insert the duration of the video in the transformation
 
----------------------------
Answer to Question 6
----------------------------
The expected benefits during the development of the intermediate playlist metamodel is to be able
to apply easily the transformations of additional model as well as model to text transformations
 while remaining in conformity with the grammar of the beginning and it was necessary to
  add a duration attribute to the MediaFile Playlist.
-The difficulties encountered: mastery of all classes generated, and check well
Naming variables when creating the ecore file.
-Recommendations: It was necessary to specify  additional informations like the duration of the
 videos that must be able to be provided without having to calculate it.
      
-------------------------------
Remarks on Question 11Bis
-------------------------------
For this question, we managed the interpretation of certain data:
● Identifiers must be unique
● Sequence videos must be unique
● Probabilities must be consistent (a probability of a video sequence)
Our management of these data was thanks to Eclipse OCL which you can  install 
(help ---> Eclipse Marketplace ---> Eclipse OCL install)
Error messages appear in the editor when the user writes a VideoGen specification that does not 
respect the properties mentioned above.
We have defined our conditions in the file: org.textxt.example.videogenerator / model / generated / VideoGen.ecore 
(right click ---> OCLinEcore Editor)

-------------------------------------------------- -----------------------
Remarks on Question 12: dynamic random generation of variants
-------------------------------------------------- -----------------------
-We generated a new jhipster project named "video-gen-application", in which
We added an entity named "generator" which allows to display a web page containing
Our thumbnails(vignettes), a button to generate a random video and a button to view the
 corresponding video.
When the "Generate" button is clicked, we have a generation of a new Variant of video and we 
reload the new page. And when we click on the "generateVideo" button, a video that concat
all our sequences selected randomly appears.


-------------------------------------------------- ----------------------
Notes on Exercise SUP1: Synthesizing a VideoGen Specification

-------------------------------------------------- ----------------------

For this exercise, we created a script "scriptVG.sh" (location: videogen / scriptVG.sh) which
 allows to retrieve the folder containing subfolders where there are our videos, and it checks
 if for each subfolder the Number of videos is equal to 1: it copies the location to a file,
otherwise if this number is> 1, it traverses this folder to retrieve all the locations of the
 videos.


-------------------------------------------------- ----------------------
Notes on Exercise SUP2: Apply treatments on videos
-------------------------------------------------- ----------------------
For this exercise we modified the grammar by adding a "filter" attribute in the description
of the video seq, so we let the choice to the user to apply the filter that he wants, 
and we implemented an xtend function that allows to apply filters.
Among the filters that can be applied:
ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, vectorscope"  videoResult.mp4
 ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, waveform"  videoResult.mp4
 ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, crop=320:240"  videoResult.mp4
 ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, ciescope"  videoResult.mp4 






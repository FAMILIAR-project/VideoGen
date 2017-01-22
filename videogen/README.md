# VideoGen project
## Benjamin Prunier and Guillaume Chopin

### Usage and implementation

To launch the project, the main class is video-gen-web-app/src/main/java/fr.istic.idm/VideoGenWebApp.java
The REST API is defined in fr.istic.idm.web.rest/VideoGen.java in the same project.

This class starts the web server generated with JHipster on the default address : 127.0.0.1:8080/
The main page contains a 'Generate' button which shows the content of a generated playlist.
This button actually calls a REST API which generates a playlistand returns its content in the JSON format. This generation is based on a videogen specification file set at the root of the web server (the directory is 'website'). The specification file is set in the REST function and is currently called "mastaconcat.videogen". The generation is random and does not make use of the 'probability' attributes.

On the main page, the content of the playlist appears. It is a list of thumbnails for every video clip used in the playlist. The actual playlist in generated in "play.m3u" in the root folder of the web server.

We also started working on the configuration mode for the generator. That is the mode where the user selects the alternative videos he wants to put in the playlist, and whether or not optional videos make their way to the playlist. We experienced issues on the front-end of the website when working with HTML, AngularJS and JavaScript, along with the frameworks coming with a JHipster project.

The REST API is visible in the Administration tab on the JHipster generated website, in the API menu. There are two queries available : one to get a random playlist for the generation mode, and the other to get the videogen specification for the configuration mode.

It is possible to modify the videogen specification without having to re-generate the whole website. Refreshing the page is enough, because it is at the REST API level that the videogen specification comes into play (to create a random playlist for example).

We added the FAMILIAR specification of the website configuration, as asked for in question 14. It is under the website project called "video-gen-web-app", or in the "website" directory. The file is called "configuration.fml".

### Playlist

A playlist is specified by a second metamodel (the first one being for a videogen specification). It is generated with a Model-to-Model transformation starting from a videogen model. It contains the paths for the videos and the thumbnails. We get it through the REST API in JSON format.

### Bonus questions

We did three of the bonus questions : 

### Convention over Configuration

The script is written in Java and is available in the "scripts" package of the "videogen" project. It takes a folder path (written at the beginning of the script) and outputs the videogen specification in this folder.
The folder must contain subfolders named "v%d" where %d is a positive integer. These folders must contain videos (an empty directory is ignored). Everything that is not a directory will be considered as a video. One video in the directory means that it is mandatory, whereas multiple videos are set as alternatives. The videogen specification file can be edited to add more information such as identifiers for videos (which will be automatically generated otherwise) for example.

### FFMPEG filters

We extended the XText grammar to add three types of filters : Black and White, Negate, and Flip (horizontal or vertical). You can only use one per video clip.
```java
VideoDescription : 'videoseq' (videoid=ID)? location=STRING
	(LEFT_BRACKET
	 ('duration' duration=INT)?
	 ('probability' probability=INT)?
	 ('size' size=INT)?
	 ('description' description=STRING)? 
	 ('filter' filter=Filter)?
	RIGHT_BRACKET)?
;

Filter : FlipFilter | NegateFilter | BlackWhiteFilter;

BlackWhiteFilter: {BlackWhiteFilter}
	'b&w'
;

NegateFilter: {NegateFilter}
	'negate'
;

FlipFilter:
	'flip' orientation=('h' | 'horizontal' | 'v' | 'vertical')
;
```
The filtered video is generated next to the original one in a "filtered" directory. Its name is modified to specify the filter type so it does not have to be generated every time. This does not break the convention set by the first bonus question because the filtered videos are in a directory that is not considered by our script.

### VideoGen to Feature model

We added a script to transform a videogen specification to a feature model written with the FAMILIAR syntax. The script is at the same place as the other one. We used a Model-to-Text transformation to write the .fml file from a videogen model, loaded from the specification file.
----------------------
Notre Architecture
----------------------

                |-------------------------| Emplacement |--------------------------------------------------------------------------|
Grammaire:      |     VideoGen.xtext      =============> org.xtext.example.videogenerator/src/org/xtext/example/mydsl/VideoGen.xtext
                |-------------------------|             |--------------------------------------------------------------------------|  

                |-------------------------| Emplacement |--------------------------------------------------------------------------|
Méta-Model      |     VideoGen.ecore      =============> org.xtext.example.videogenerator/model/generated/VideoGen.ecore
VideoGen :      |-------------------------|             |--------------------------------------------------------------------------|  


                |-------------------------| Emplacement |--------------------------------------------------------------------------|
Méta-Model      |     playlist.ecore      =============> projet idm Q2/projet idm Q2/src/playlist.ecore
Playlist :      |-------------------------|             |--------------------------------------------------------------------------|  


Classe de réponses
aux questions
du Projet:      |-------------------------| Emplacement |------------------------------------------------|
                |transformationsVideo.xtend=============>videogen/src/videogen/transformationsVideo.xtend
                |-------------------------|             |------------------------------------------------| 
		
                      
Le test des fonctions de notre projet est réalisé dans une classe Main: 
                |-------------------------| Emplacement |------------------------------------------------|
                |     Main.xtend           =============> videogen/src/videogen/Main.xtend
                |-------------------------|             |------------------------------------------------| 
                

Les vidéos sur lesquelles on fait nos tests sont un dossier à la racine : 
                |-------------------------| Emplacement |------------------------------------------------|
                |     dossier des videos   =============> videogen/v
                |-------------------------|             |------------------------------------------------|  



----------------------------
Remarques sur la Question 2
----------------------------  
Pour cette question on a crée un nouveau projet pour la playlist où on a définit le méta_model de cette playlist:

                |-------------------------| Emplacement |------------------------------------------------|
                |     playlist.ecore      =============>projet idm Q2/projet idm Q2/src/playlist.ecore
                |-------------------------|             |------------------------------------------------|  
 

----------------------------
Réponse de la Question 6 
----------------------------


-------------------------------
Remarques sur la Question 11Bis
-------------------------------
Pour cette question, on a gérée l’interprétation de certaines données:
● Les identifieurs doivent être uniques
● Les localisations des videos seq doivent être uniques
● Les probabilités doivent être cohérentes (une probabilité d’une séquence vidéo
notre gestion de ces données était grâce à Eclipse OCL qu'il faut installer(help--->Eclipse Marketplace--->install Eclipse OCL)
Des messages d’erreurs apparaissent dans l’éditeur lorsque l’utilisateur écrit une spécification VideoGen ne respectant pas les propriétés mentionnées ci-dessus.
nous avons définis nos conditions dans le fichier : org.xtext.example.videogenerator/model/generated/VideoGen.ecore(clic droit ---> OCLinEcore Editor)

 
------------------------------------------------------------------------
Remarques sur l'Exercice SUP1 : Synthétiser une spécification VideoGen

------------------------------------------------------------------------
Pour cet exercice, on a crée un script "scriptVG.sh"(emplacement: videogen/scriptVG.sh) qui permet de récuperer le dossier contenant des sous-dossiers où il y a nos vidéos, et il vérifie si pour chaque sous dossier le nombre de videos est égale à 1 : il copie la localisation dans un fichier, sinon si ce nombre est > 1, il parcours ce dossier pour récupérer toutes les localisations des vidéos.


------------------------------------------------------------------------
Remarques sur l'Exercice SUP2 : Appliquer des traitements sur les vidéos
------------------------------------------------------------------------
Pour cet exercice on a modifié la grammaire en ajoutant un attribut "filter" dans la description de la video seq, du coups on laisse le choix 
à l'utilisateur d'appliquer le filtre qu'il voudrais, et on a implémenté une fonction xtend qui permet d'appliquer les filtres
Parmi les filtres qui peuvent être appliqués:
 ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, vectorscope"  videoResult.mp4
 ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, waveform"  videoResult.mp4
 ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, crop=320:240"  videoResult.mp4
 ffmpeg -i videoSource.mp4 -strict -2  -vf "format=yuva444p9, ciescope"  videoResult.mp4 







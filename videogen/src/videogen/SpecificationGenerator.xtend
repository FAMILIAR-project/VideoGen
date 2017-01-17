package videogen

import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.util.HashMap
import java.io.File
import org.xtext.example.mydsl.videoGen.VideoGenFactory

class SpecificationGenerator {
	//Question subsidiaire : Synthétiser une spécification VideoGen
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	def generateSpecification(String folder,URI specifname){
		var subFolders = new File(folder).listFiles();
		var videogen = VideoGenFactory.eINSTANCE.createVideoGeneratorModel
		for (sfolder : subFolders){
			if (sfolder.isFile()){
				println("Warning : we didn't expect a file ("+sfolder.getName+") at this level")
			}else{
				var id = sfolder.getName
				//println(id)
				//var location = sfolder.getPath
				//println(location)
				var listOfFiles = sfolder.listFiles()
				if (listOfFiles.length==1){
					//println(id)
					var manda = VideoGenFactory.eINSTANCE.createMandatoryVideoSeq
					//var videoid = manda.description.videoid
					manda.description.videoid = id
					//videoid = id
					print("test : "+manda.description.videoid)
					//manda.description.location = location
					videogen.videoseqs.add(manda)
				}
				if (listOfFiles.length==0){
					println("Warning : folder "+id+" is empty")
				}
				if (listOfFiles.length>1){
					var altern = VideoGenFactory.eINSTANCE.createAlternativeVideoSeq
					altern.videoid = id
					for (file : listOfFiles){
						if (file.isFile()){
							//pour le moment, pas de vérification que le fichier soit valide
							var aid = file.getName
							var alocation = file.getPath
							var videodesc = VideoGenFactory.eINSTANCE.createVideoDescription
							videodesc.videoid = aid
							videodesc.location = alocation
							altern.videodescs.add(videodesc)
						}else{
							println("Warning : we didn't expect a folder ("+file.getName+") at this level")
						}
					}
					videogen.videoseqs.add(altern)
				}
			}
		}
		saveVideoGenerator(specifname,videogen)
	}
	
	def static void main(String[] args) {
		val dc = new SpecificationGenerator
		val folder = "/home/nirina/Vidéos"
		val specifname = URI.createURI("videoperso.videogen")
		dc.generateSpecification(folder,specifname)
	}
}
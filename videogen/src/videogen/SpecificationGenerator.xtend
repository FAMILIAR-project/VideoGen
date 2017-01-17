package videogen

import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.util.HashMap
import java.io.File
import org.xtext.example.mydsl.videoGen.VideoGenFactory
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated

class SpecificationGenerator {
	//Question subsidiaire : Synthétiser une spécification VideoGen
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var Resource rs = new ResourceSetImpl().createResource(uri);
		//println(pollS)
		//println(uri)
		//println(rs.getContents) 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	def generateSpecification(String folder,URI specifname){
		var subFolders = new File(folder).listFiles();
		var videogen = VideoGenFactory.eINSTANCE.createVideoGeneratorModel
		//var videoseqs = VideoGenFactory.eINSTANCE.c
		for (sfolder : subFolders){
			if (sfolder.isFile()){
				println("Warning : we didn't expect a file ("+sfolder.getName+") at this level")
			}else{
				var id = sfolder.getName
				//println(id)
				var listOfFiles = sfolder.listFiles()
				if (listOfFiles.length==1){
					var manda = VideoGenFactory.eINSTANCE.createMandatoryVideoSeq
					var desc = VideoGenFactory.eINSTANCE.createVideoDescription
					println(listOfFiles.get(0).getName.toString.split("\\.").get(0))
					desc.videoid = "m"+listOfFiles.get(0).getName.split("\\.").get(0)
					desc.location = listOfFiles.get(0).getPath
					manda.description = desc
					videogen.videoseqs.add(manda)
				}
				if (listOfFiles.length==0){
					println("Warning : folder "+id+" is empty")
				}
				if (listOfFiles.length>1){
					var altern = VideoGenFactory.eINSTANCE.createAlternativeVideoSeq
					altern.videoid = "a"+id
					for (file : listOfFiles){
						if (file.isFile()){
							//pour le moment, pas de vérification que le fichier soit valide
							//var aid = file.getName
							//println(aid.split(".").length)
							var aid = "av"+file.getName.split("\\.").get(0)
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
		//println(videogen.toString)
		saveVideoGenerator(specifname,videogen)
	}
	
	def static void main(String[] args) {
		val dc = new SpecificationGenerator
		val folder = "/home/nirina/Vidéos"
		val specifname = URI.createURI("videoperso.videogen")
		dc.generateSpecification(folder,specifname)
	}
}
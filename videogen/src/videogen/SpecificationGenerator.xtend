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
				print("Warning : we didn't expect a file ("+sfolder.getName+") at this level")
			}else{
				var id = sfolder.getName
				var location = sfolder.getPath
				var listOfFiles = sfolder.listFiles()
				if (listOfFiles.length==1){
					var manda = VideoGenFactory.eINSTANCE.createMandatoryVideoSeq
					manda.description.videoid = id
					manda.description.location = location
					videogen.videoseqs.add(manda)
				}
				if (listOfFiles.length==0){
					print("Warning : folder "+id+" is empty")
				}
				if (listOfFiles.length>1){
					var altern = VideoGenFactory.eINSTANCE.createAlternativeVideoSeq
					for (file : listOfFiles){
						var aid = file.getName
						var alocation = file.getPath
						var videodesc = VideoGenFactory.eINSTANCE.createVideoDescription
						videodesc.videoid = aid
						videodesc.location = alocation
						altern.videodescs.add(videodesc)
					}
					videogen.videoseqs.add(altern)
				}
			}
		}
		saveVideoGenerator(specifname,videogen)
	}
	
	def static void main(String[] args) {
		val dc = new SpecificationGenerator
		val folder = "specif"
		val specifname = URI.createURI("specif.videogen")
		dc.generateSpecification(folder,specifname)
	}
}
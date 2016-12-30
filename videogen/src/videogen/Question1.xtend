package videogen

import java.nio.file.Files
import java.nio.file.Paths
import java.util.ArrayList
import java.util.HashMap
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

class Question1 {
	
	def static loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def static saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	/**
	 * A partir d'un fichier videogen, crée la liste des URL des vidéos choisies
	 * Concatène avec ffmpeg
	 */
	def static main(String[] args)
	{
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		val list = new ArrayList()
		val rand = new Random()
		val entry = "file '%s'"
		val cmd = "ffmpeg -y -f concat -i params.txt -c copy result.mp4"
		videoGen.videoseqs.forEach[videoseq|
			if(videoseq instanceof MandatoryVideoSeq)
			{
				list.add(String.format(entry,(videoseq as MandatoryVideoSeq).description.location))
			}
			if(videoseq instanceof OptionalVideoSeq)
			{
				if(rand.nextInt(2) == 1)
				{
					list.add(String.format(entry,(videoseq as OptionalVideoSeq).description.location))
				}
			}
			if(videoseq instanceof AlternativeVideoSeq)
			{
				val listAlt = (videoseq as AlternativeVideoSeq).videodescs
				val quicesera = rand.nextInt(listAlt.size)
				list.add(String.format(entry,listAlt.get(quicesera).location))
			}
		
		]
		Files.write(Paths.get("params.txt"), list)
		Runtime.runtime.exec(cmd)
		return
	}
	
}
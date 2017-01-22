package videogen

import java.io.File
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
import org.xtext.example.mydsl.videoGen.BlackWhiteFilter
import org.xtext.example.mydsl.videoGen.FlipFilter
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.NegateFilter
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

class ConcatFFMPEG {
	
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
	 * Utilise les filtres
	 */
	def static main(String[] args)
	{
		var videoGen = loadVideoGenerator(URI.createURI("/home/guillaume/Bureau/IDM/CoC/CoC.videogen"))
		val list = new ArrayList()
		val rand = new Random()
		val entry = "file '%s'"
		
		var i = 0
		while((new File("result"+i+".mp4")).exists){
			i++;
		}
		
		val cmd = "ffmpeg -y -f concat -safe 0 -i params.txt -c copy result"+i+".mp4"
		videoGen.videoseqs.forEach[videoseq|
			var String filtered = null
			
			if(videoseq instanceof MandatoryVideoSeq)
			{
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.filter != null){
					filtered = applyFilter(desc)
				}
				if(filtered != null){
					list.add(String.format(entry, filtered))
				}else{
					list.add(String.format(entry, desc.location))
				}
			}
			if(videoseq instanceof OptionalVideoSeq)
			{
				if(rand.nextInt(2) == 1)
				{
					val desc = (videoseq as OptionalVideoSeq).description
					if(desc.filter != null){
						filtered = applyFilter(desc)
					}
					if(filtered != null){
						list.add(String.format(entry, filtered))
					}else{
						list.add(String.format(entry, desc.location))
					}
				}
			}
			if(videoseq instanceof AlternativeVideoSeq)
			{
				val listAlt = (videoseq as AlternativeVideoSeq).videodescs
				val quicesera = rand.nextInt(listAlt.size)
				
				val desc = listAlt.get(quicesera)
				if(desc.filter != null){
					filtered = applyFilter(desc)
				}
				if(filtered != null){
					list.add(String.format(entry, filtered))
				}else{
					list.add(String.format(entry, desc.location))
				}
			}
		
		]
		Files.write(Paths.get("params.txt"), list)
		val resultFile = new File("result"+i+".mp4")
		println("Concaténation des vidéos dans : "+resultFile.absolutePath)
		val process = Runtime.runtime.exec(cmd)
		process.waitFor
		if(resultFile.exists){
			println("Résultat écrit dans : "+ resultFile.absolutePath)
		}
		else{
			println("Erreur dans l'écriture du résultat")
			println(cmd)
		}
		return
	}
	
	def static applyFilter(VideoDescription desc) {
		val filter = desc.filter
		if(filter != null){
			val input = desc.location
			val inputFile = new File(input)
			if(!inputFile.exists){
				return null
			}
			
			val outputBasename = inputFile.name.substring(0, inputFile.name.lastIndexOf('.'))
			val outputExtension = inputFile.name.substring(inputFile.name.lastIndexOf('.'))
			
			var String outputName = null
			var String filtre = null
			
			if(filter instanceof FlipFilter){
				val flip = filter as FlipFilter
				if(flip.orientation.equalsIgnoreCase("h") 
					|| flip.orientation.equalsIgnoreCase("horizontal")){
					
					outputName = outputBasename + "_hflip" + outputExtension
					filtre = "-vf hflip"
				
				}else if(flip.orientation.equalsIgnoreCase("v") 
					|| flip.orientation.equalsIgnoreCase("vertical")){
					
					outputName = outputBasename + "_hflip" + outputExtension
					filtre = "-vf vflip"
					
				}
			}else if(filter instanceof NegateFilter){
				
				outputName = outputBasename + "_negate" + outputExtension
				filtre = "-vf negate"
				
			}else if(filter instanceof BlackWhiteFilter){
				
				outputName = outputBasename + "_bw" + outputExtension
				filtre = "-vf hue=s=0"
				
			}
			
			if(outputName != null && filtre != null){
				val filteredDir = new File(inputFile.parentFile, "filtered")
				filteredDir.mkdirs
				val outputPath = filteredDir.path + "/" + outputName
				
				if(!(new File(outputPath)).exists){
					val cmd = "ffmpeg -i "+ input + " " + filtre + " " + outputPath
					println("Applique le filtre sur : "+input)
					println(cmd)
					val process = Runtime.runtime.exec(cmd)
					process.waitFor
					println("Enregistré dans : "+outputPath)
				}
				
				return outputPath
			}
		}
		return null
	}
	
}
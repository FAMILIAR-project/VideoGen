package videogen

import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.ecore.resource.Resource
import java.util.HashMap
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.util.Scanner
import java.util.regex.Pattern
import org.xtext.example.mydsl.videoGen.VideoDescription
import java.nio.file.Paths
import org.xtext.example.mydsl.videoGen.VideoSeq
import org.junit.Test


class VideoGenGenerator {
	
	@Test
	def testGeneration(){
		generate("videos/montage.videogen")
	}
	
	def generate(String path){
		var videoGen = loadVideoGenerator(URI.createURI(path)) 
		generateId(videoGen)
		generateDuration(videoGen)
		saveVideoGenerator(URI.createURI(path), videoGen)
		metrics(videoGen)
		//return generateM3U(videoGen)
	}

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	/*
	 * Generators
	 * 
	 */
	 
	 def generateId(VideoGeneratorModel videoGen){
	 	videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty)  desc.videoid = genID()		
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID() 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
				}
			}
		]
	 }
	 
	 def generateDuration(VideoGeneratorModel videoGen){
	 	videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				desc.duration = genDuration(desc.location)		
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				desc.duration = genDuration(desc.location)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					val desc = (vdesc as VideoDescription)
					desc.duration = genDuration(desc.location)	
				}
			}
		]
	 }
	 
	 def generateThumbnails(VideoGeneratorModel videoGen){
	 	videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				genVignette(desc.location);
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(Math.random()*1>0.5){
					genVignette(desc.location);
				}
			}
			else{
				val altvid = (videoseq as AlternativeVideoSeq)
				if (altvid.videodescs.size > 0){ // there are vid seq alternatives
					var i = (Math.random()*altvid.videodescs.size)
					genVignette((altvid.videodescs.get(i as int).location));
				}
			}
		]
	}
	
	def metrics(VideoGeneratorModel videoGen){
		var duree_max = 0;
		var duree_min = 0;
		var duree_avg = 0;
		
		var size_max = 0
		var size_min = 0
		var size_avg = 0
		var nb_sol = 0;
		
		for(VideoSeq videoseq:videoGen.videoseqs){
	 		if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				nb_sol++;
				duree_min+=videoseq.description.duration
				duree_max+=videoseq.description.duration
				duree_avg+=videoseq.description.duration
				size_min+=videoseq.description.duration
				size_max+=videoseq.description.duration
				size_avg+=videoseq.description.duration				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				nb_sol*=2;
				duree_max+=(videoseq.description.duration)
				duree_avg+=(videoseq.description.duration)/2
				size_max+=(videoseq.description.duration)
				size_avg+=(videoseq.description.duration)/2
				
			}
			else{
				val altvid = (videoseq as AlternativeVideoSeq)
				var duree_alt_tot=0
				var duree_alt_max=0
				var duree_alt_min=0
				var size_alt_tot=0
				var size_alt_max=0
				var size_alt_min=0
				if (altvid.videodescs.size > 0){ // there are vid seq alternatives
					nb_sol*=altvid.videodescs.size
					for(VideoDescription videodesc:altvid.videodescs) {
						if(videodesc.duration>duree_alt_max)
							duree_alt_max=videodesc.duration
						if(videodesc.duration<duree_alt_min)
							duree_alt_min=videodesc.duration
						duree_alt_tot += videodesc.duration
						if(videodesc.size>size_alt_max)
							size_alt_max=videodesc.size
						if(videodesc.size<duree_alt_min)
							size_alt_min=videodesc.size
						size_alt_tot += videodesc.size
					}
					duree_max+=duree_alt_max
					duree_min+=duree_alt_min
					duree_avg+=duree_alt_tot/altvid.videodescs.size
					
					size_max+=size_alt_max
					size_min+=size_alt_min
					size_avg+=size_alt_tot/altvid.videodescs.size
				}
			}
	 	}
	 	System.out.println("Nombre de variantes : "+nb_sol+
	 		"\n Duree Moyenne : "+duree_avg+"\n Duree Max : "+duree_max+
	 		"\n Duree Min : "+duree_min+"\n Taille Moyenne : "+size_avg+
	 		"\n Taille Max : "+size_max+"\n Taille Min : "+size_min
	 	)	 	
	}
	def genVignette(String path) {
		var cmd = "ffmpeg -y -i "+path+" -r 1 -t 00:00:01 -f image2 "+Paths.get(path).getParent().getFileName().toString()+"/vignette-"+Paths.get(path).getFileName().toString().replaceFirst("[.][^.]+$", "")+".png";
		var r = Runtime.getRuntime();
		var p = r.exec(cmd);
	}
	 
	 def generateM3U(VideoGeneratorModel videoGen){
	 	var m3u=""
	 	m3u+="#EXTM3U\n"
	 	for(VideoSeq videoseq:videoGen.videoseqs){
	 		if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				m3u+="#EXTINF:\n"+desc.location+'\n'
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(Math.random()*1>0.5) 
					m3u+="#EXTINF:\n"+desc.location+'\n'
			}
			else{
				val altvid = (videoseq as AlternativeVideoSeq)
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					m3u+="#EXTINF:\n"+altvid.videodescs.get((Math.random()*altvid.videodescs.size) as int).location+'\n'
			}
	 	}
	 	return m3u;
	 }
	 
	 /*
	  * Utils
	  * 
	  */
	 def int genDuration(String path){
		var cmd = "ffprobe -i "+path;
		var r = Runtime.getRuntime();
		var p = r.exec(cmd);
		var sc = new Scanner(p.getErrorStream());
		
        // Find duration
        var durPattern = Pattern.compile("(?<=Duration: )[^,]*");
        var dur = sc.findWithinHorizon(durPattern, 0);
        if (dur == null)
          throw new RuntimeException("Could not parse duration.");
        var String[] hms = dur.split(":");
        var totalSecs = Integer.parseInt(hms.get(0)) * 3600
                         + Integer.parseInt(hms.get(1)) *   60
                         + Double.parseDouble(hms.get(2));
		return totalSecs as int;
	}
	
	static var i = 0;
	
	def genID() {
		"v" + i++
	}
	
}
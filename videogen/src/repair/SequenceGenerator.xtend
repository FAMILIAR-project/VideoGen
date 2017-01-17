package repair

import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.ArrayList
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import java.util.Random
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException
import java.nio.charset.Charset
import java.io.File

/**
 * Sequence generator
 */
class SequenceGenerator {
	

	private VideoGeneratorModel data;
	
	
	/**
	 * Constructor
	 */
	new(VideoGeneratorModel data){
		this.data=data
		repair();
	}
	
	/**
	 * Sequence getter
	 */
	def VideoGeneratorModel getRepairedModel(){
		data
	}
	
	
	def double getDuration(String location){
		var String result = "";
		try {
		    var Runtime r = Runtime.getRuntime();                    
		
    		//var Process p = Runtime.getRuntime().exec("/usr/bin/ffprobe -i \""+location+"\" -show_format -v quiet | sed -n \'s/duration=//p\'") 
		
			var Process processDuration = new ProcessBuilder("ffmpeg", "-i", location).redirectErrorStream(true).start();
			var StringBuilder strBuild = new StringBuilder();
			
			var BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(processDuration.getInputStream(), Charset.defaultCharset()))
			    var String line;
			    while ((line = processOutputReader.readLine()) != null) {

					if(line.contains("Duration")){
						line=line.trim
						line=line.split(" ").get(1).split(",").get(0)
						var hours=Integer.parseInt(line.split(":").get(0))
						var mins=Integer.parseInt(line.split(":").get(1))
						var secs=Double.parseDouble(line.split(":").get(2))
						return (3600*hours)+(60*mins)+secs
						
					}			        
			    }
			    processDuration.waitFor();
			
		
		} catch (IOException e) {
		    System.out.println(e);
		}
		    return 0

	}

	/**
	 * Repair
	 */
	def void repair(){		
		data.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				fix(desc)				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				fix(desc)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (desc : altvid.videodescs) {
					fix(desc)
				}
				
			}
		]
	}
	
	def double getSize(VideoDescription desc){
		var File file =new File(desc.location);
		if(file.exists){
			var double bytes = file.length();
			var double kilobytes = (bytes / 1024);
			var double megabytes = (kilobytes / 1024);
			return megabytes
		}
		
		return 0
	}
	
	def void fix(VideoDescription desc){
		if(desc.duration == 0){
			desc.duration=getDuration(desc.location) as int
					
		}
		if(desc.size==0){
			desc.size=getSize(desc) as int
		}
		
		
	}
}
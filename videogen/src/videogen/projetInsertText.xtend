package videogen

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

class projetInsertext {

	
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
	
	def static double getDuration(String videoLocation){
		var Process process = Runtime.getRuntime().exec("ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation );
		
		process.waitFor();

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
		return Math.round(Double.parseDouble(outputJson))-1;
	}
	
	def static String insertText(String videoLocation, String text){
		System.out.println("debut")
		
		var String[] name = videoLocation.split("\\.(?=[^\\.]+$)");
	    
		var cmd = "ffmpeg -i "+ videoLocation +" -vf drawtext='fontsize=15:fontfile=FreeSerif.ttf:text="+text+":y=100:x=100' -codec:a copy " + name.get(0) + "-2.mp4"	    
	    
		//var cmd	= 'ffmpeg -i '+ videoLocation +' -vf drawtext="fontfile=/path/to/font.ttf:\\text='+ text +': fontcolor=white: fontsize=24: box=1: boxcolor=black@0.5:\\boxborderw=5: x=(w-text_w)/2: y=(h-text_h)/2" -codec:a copy ' + name.get(0) + '-2.mp4';    
   
	
	    System.out.println(cmd)

		var Process process = Runtime.getRuntime().exec(cmd);
		process.waitFor();
		
		
		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
	    System.out.println(outputJson.toString())
	    
	   return name.get(0) + '-2.mp4'
	}
	
	
	
	
	
	
	static var i = 0;
	
	File ffmpeg
	
	def static genID() {
		"" + i++
	}

}

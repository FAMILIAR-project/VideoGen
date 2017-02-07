package videogen

import java.nio.file.Paths
import java.io.File
import java.util.Scanner

class FFMPEGHelpere {
	
	def void executeCmd(String location, String name){
		
	 var command = "ffmpeg -y -i " + "./" + location + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f image2 screenshot/" + name + ".png"
        var p = Runtime.runtime.exec(command)
        p.waitFor
	}
	
    def void executeCmdGIF(String input, String outputname){
    			
	var command = "ffmpeg -i "+input+" "+outputname+".gif"

        var p = Runtime.runtime.exec(command)
        p.waitFor
	}
	
	def void executeCmdIncrustText(String input, String outputname, String t){
	    	
	    	var f = new File(input)
	    	var path = f.absolutePath
	    			
	var command ="ffmpeg -i "+path+" -vf drawtext=fontfile=/path/to/font.ttf:text=\'"+ t
	+"\':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:y=(h-text_h)/2 -codec:a copy "+path+outputname+".mp4"
       
        var p = Runtime.runtime.exec(command)
        p.waitFor
	}
	
	def void executeCmdFilterBlackAndWhite(String input, String output){
	    	
	    	var f = new File(input)
	    	var path = f.absolutePath
	    			
	     var command = "ffmpeg -i "+ path+" -vf hue=s=0 -c:a copy "+path+output+".mp4"
       
        var p = Runtime.runtime.exec(command)
        p.waitFor
	}
	
	def void executeCmdFilterLighter(String input, String output){
	    	
	    	var f = new File(input)
	    	var path = f.absolutePath   			
	    var command = "ffmpeg -i "+ path+" -vf curves=preset=lighter -c:a copy "+path+output+".mp4"
       
        var p = Runtime.runtime.exec(command)
        p.waitFor
	}

	def executeCmdGetDuration(String input){
	    	
	   	var f = new File(input)
	   	var path = f.absolutePath   			
	     var command = "ffprobe -i "+path+" -show_entries format=duration -v quiet -of csv=p=0"
        var p = Runtime.runtime.exec(command)
        p.waitFor
        var str = new Scanner(p.inputStream).useDelimiter("\\A")
        if(str.hasNext())
         str.next().trim
	}	
	
}
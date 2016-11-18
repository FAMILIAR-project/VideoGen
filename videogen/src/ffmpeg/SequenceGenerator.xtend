package ffmpeg

import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.ArrayList
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import java.util.Random


/**
 * Sequence generator
 */
class SequenceGenerator {
	
	// Alternatives
	private ArrayList< ArrayList<VideoDescription>> alts=new ArrayList<ArrayList<VideoDescription>>()
	// Optionals
	private ArrayList<VideoDescription> opts=new ArrayList<VideoDescription>()
	// Mandatory
	private ArrayList<VideoDescription> md=new ArrayList<VideoDescription>()
	// Final Sequence
	private ArrayList<String> sequence=new ArrayList<String>()
	// VideoGen Model
	private VideoGeneratorModel data;
	
	
	/**
	 * Constructor
	 */
	new(VideoGeneratorModel data){
		this.data=data
		buildArray() // Build array from data
		buildMandatory() // Build mandatory
		// Build optional
		var currentOpts=getAnOptional(opts)
		for(o:currentOpts){
			appendVideo(o.location)
		}
		buildAlternative() // Build alternative
	}
	
	/**
	 * Sequence getter
	 */
	def ArrayList<String> getSequence(){
		sequence
	}
	
	/**
	 * Build alternative entries
	 */
	def void buildAlternative(){
		for(a: alts){
			var  opt=getAnOptional(a)
			for(o:opt){
				appendVideo(o.location)
			}
		}
	}
	
	/**
	 * Build mandatory entries
	 */
	def void buildMandatory(){
		for(v: md){
			appendVideo(v.location)
		}
	}

	/**
	 * Get optionnal sequence entries
	 */
	def ArrayList<VideoDescription> getAnOptional(ArrayList<VideoDescription> opts){
		var ArrayList<VideoDescription> finalOpts=new ArrayList<VideoDescription>()
		for(o:opts){
			if(o.probability!=0){
				if(random(1,100)<=o.probability){
					finalOpts.add(o)
				}
			}
			else{
				if(random(1,100)<=50){
					finalOpts.add(o)
				}
				
			}
		}
		finalOpts
		
	}
	
	/**
	 * Get random number from a range
	 */
	def  int random(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		return new Random().nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Add location to the sequence
	 */
	def void appendVideo(String file){
		sequence.add("file \""+file+"\"")
	}

	/**
	 * Build usable arrays
	 */
	def void buildArray(){		
		data.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				md.add(desc) 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				opts.add(desc)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val current=new ArrayList<VideoDescription>();
				for (vdesc : altvid.videodescs) {
					current.add(vdesc)
				}
				alts.add(current)
				
			}
		]
	}
}
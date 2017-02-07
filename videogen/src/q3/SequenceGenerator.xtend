package q3

import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.ArrayList
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import java.util.Random
import M3UPlaylist.Playlist
import M3UPlaylist.M3UPlaylistFactory
import M3UPlaylist.Entry

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
	// M3UPlaylist model
	private Playlist playlist=M3UPlaylistFactory.eINSTANCE.createPlaylist()
	
	
	/**
	 * Constructor
	 */
	new(VideoGeneratorModel data){
		this.data=data
		buildArray() // Build array from data
		buildMandatory() // Build mandatory
		// Build optional
		var currentOpt=getAnOptional(opts)
		if(currentOpt!=null){
			appendVideo(currentOpt.location)
		}
		buildAlternative() // Build alternative
		
		for(file:sequence){
			var Entry entry=M3UPlaylistFactory.eINSTANCE.createEntry()
			entry.path=file
			playlist.entries.add(entry)
		}
	}
	
	/**
	 * Sequence getter
	 */
	def Playlist getPlaylist(){
		playlist
	}
	
	/**
	 * Build alternative entries
	 */
	def void buildAlternative(){
		for(a: alts){
			var  opt=getAnOptional(a)
			if(opt!=null){
				appendVideo(opt.location)
				
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
	def VideoDescription getAnOptional(ArrayList<VideoDescription> opts){
		var ArrayList<VideoDescription> finalOpts=new ArrayList<VideoDescription>()
		for(o:opts){
			if(o.probability!=0){
				if(random(1,100)<=o.probability){
					return o;
				}
			}
			else{
				if(random(1,100)<=50){
					return o;
				}
				
			}
		}
		return null;
		
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
		sequence.add(file)
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
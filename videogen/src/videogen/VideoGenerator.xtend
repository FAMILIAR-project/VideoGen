package videogen

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.PlaylistStandaloneSetupGenerated
import org.xtext.example.mydsl.playlist.PlaylistGeneratorModel
import org.xtext.example.mydsl.playlist.PlaylistFactory
import org.xtext.example.mydsl.playlist.impl.PlaylistFactoryImpl
import org.xtext.example.mydsl.playlist.Mediafile
import java.util.List
import java.util.ArrayList
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class VideoGenerator {
	
	private int seqId = 0
	private List<String> ids = new ArrayList()
	
	def public void generateSequence(String videogenFile, String outPath, String playlistName) {
		var VideoGeneratorModel videogen = loadVideoGeneratorModel(URI.createURI(videogenFile))
		var PlaylistGeneratorModel playlistModel = generatePlaylistModel(videogen)
		
		generateM3UExtFile(playlistModel, outPath + '/' + playlistName)
	}
	
	def public PlaylistGeneratorModel generatePlaylistModel(VideoGeneratorModel videoGeneratorModel) {
		val PlaylistFactory playlistFactory = new PlaylistFactoryImpl()
		val PlaylistGeneratorModel playlistGen = playlistFactory.createPlaylistGeneratorModel()
		
		videoGeneratorModel.videoseqs.forEach[videoSeq | 
			
			if(videoSeq instanceof MandatoryVideoSeq) {
				var desc = (videoSeq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				
				checkIds(desc.videoid)
				
				val Mediafile mediafile = playlistFactory.createMediafile()
				
				mediafile.setId(desc.videoid)
				mediafile.setLocation(desc.location)
				mediafile.setDuration(getDuration(mediafile.getLocation()))
				
				playlistGen.mediafiles.add(mediafile)
			}
			
			if(videoSeq instanceof OptionalVideoSeq) {
				var desc = (videoSeq as OptionalVideoSeq).description
				
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				
				checkIds(desc.videoid)
				
				val probability = Math.random() * 100
				
				if((probability < desc.probability)) {
					val Mediafile mediafile = playlistFactory.createMediafile()
					
					mediafile.setId(desc.videoid)
					mediafile.setLocation(desc.location)
					mediafile.setDuration(getDuration(mediafile.getLocation()))
					
					playlistGen.mediafiles.add(mediafile)
				}
			}
			
			if(videoSeq instanceof AlternativeVideoSeq) {
				val altvid = (videoSeq as AlternativeVideoSeq)
				
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				
				checkIds(altvid.videoid)
				checkAlternativeVideos(altvid)
				
				val altSeq = alternativeRandomizer(altvid);
				val Mediafile mediafile = playlistFactory.createMediafile()
				
				mediafile.setLocation(altSeq.location)
				mediafile.setId(altSeq.videoid)
				mediafile.setDuration(getDuration(mediafile.getLocation()))
				
				playlistGen.mediafiles.add(mediafile)
			}
		]
		
		return playlistGen	
	}
	
	def public String getSequenceHtml(VideoGeneratorModel videogen, String thumbsPath) {	
		return htmlTemplate(videogen, thumbsPath).toString()
	}
	
	def public void generateVideogenThumbnails(String videogenPath, String outPath) {
		val VideoGeneratorModel videoGen = loadVideoGeneratorModel(URI.createURI(videogenPath))
		
		videoGen.videoseqs.forEach[videoSeq |
			if(videoSeq instanceof MandatoryVideoSeq) {
				if(videoSeq.description.videoid.isNullOrEmpty) videoSeq.description.videoid = genID()
				Runtime.runtime.exec(thumbnailFFMpegCommand(videoSeq.description.location, videoSeq.description.videoid, outPath).toString)
			}
			if(videoSeq instanceof AlternativeVideoSeq) {
				if(videoSeq.videoid.isNullOrEmpty) videoSeq.videoid = genID()
				checkAlternativeVideos(videoSeq)
				videoSeq.videodescs.forEach[desc |
					Runtime.runtime.exec(thumbnailFFMpegCommand(desc.location, desc.videoid, outPath).toString)
				]
			}
			if(videoSeq instanceof OptionalVideoSeq) {
				if(videoSeq.description.videoid.isNullOrEmpty) videoSeq.description.videoid = genID()
				Runtime.runtime.exec(thumbnailFFMpegCommand(videoSeq.description.location, videoSeq.description.videoid, outPath).toString)
			}
		]
	}
	
	def public ArrayList<String> generateConfigThumbnails(String videogenPath, String outPath) {
		val VideoGeneratorModel videoGen = loadVideoGeneratorModel(URI.createURI(videogenPath))
		return generateConfigThumbnails(videoGen, outPath)
	}
	
	def public ArrayList<String> generateConfigThumbnails(VideoGeneratorModel videoGen, String outPath) {
		val ArrayList<String> ids = new ArrayList()
		
		videoGen.videoseqs.forEach[ videoseq | 
			if(videoseq instanceof AlternativeVideoSeq) {
				if(videoseq.videoid.isNullOrEmpty) videoseq.videoid = genID()
				checkAlternativeVideos(videoseq)
				videoseq.videodescs.forEach[desc |
					Runtime.runtime.exec(thumbnailFFMpegCommand(desc.location, desc.videoid, outPath).toString)
					ids.add(desc.videoid)
				]
			}
			if(videoseq instanceof OptionalVideoSeq) {
				if(videoseq.description.videoid.isNullOrEmpty) videoseq.description.videoid = genID()
				Runtime.runtime.exec(thumbnailFFMpegCommand(videoseq.description.location, videoseq.description.videoid, outPath).toString)
				ids.add(videoseq.description.videoid)
			}
		]
		return ids;
	}
	
	def public ArrayList<String> generatePlaylistThumbnails(PlaylistGeneratorModel playlist, String outPath) {
		val ArrayList<String> ids = new ArrayList();
		
		playlist.mediafiles.forEach[mediafile |
			Runtime.getRuntime().exec(thumbnailFFMpegCommand(mediafile.location, mediafile.id, outPath).toString())	
			ids.add(mediafile.id)
		]
		return ids;
	}
	
	def public void generateVideoFile(String videogenFile, String filename, String outpath) {
		var VideoGeneratorModel videogen = loadVideoGeneratorModel(URI.createURI(videogenFile))
		var PlaylistGeneratorModel playlist = generatePlaylistModel(videogen)
		
		generateFile(outpath + '/' + filename + ".txt", ffmpegPlaylist(playlist).toString)
		val Process pr = Runtime.runtime.exec(ffmpegConcatenateCommand(outpath + '/' + filename + ".txt", outpath + '/' + filename).toString)
		while(pr.isAlive) {}
	}
	
	def private VideoGeneratorModel loadVideoGeneratorModel(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		return res.contents.get(0) as VideoGeneratorModel
	}
	
	def private PlaylistGeneratorModel loadPlaylistGeneratorModel(URI uri) {
		new PlaylistStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		return res.contents.get(0) as PlaylistGeneratorModel
	}
	
	def private void generateM3UExtFile(PlaylistGeneratorModel playlist, String filename) {
			generateFile(filename,m3uExtendTemplate(playlist).toString())
	}
		
	def private String genID() {
		"sequence" + seqId++
	}
	
	def private Float getDuration(String videoLocation) {
		val Process pr = Runtime.getRuntime().exec(durationFFProbeCommand(videoLocation).toString())
		val BufferedReader resBuffer = new BufferedReader(new InputStreamReader(pr.getInputStream()))
		return Float.parseFloat(resBuffer.readLine())
	}
	
	def private void checkIds(String id) {
		if(ids.contains(id)) {
			throw new Exception("ID : " + id + " already exist !")
		}
		else {
			ids.add(id)	
		}
	}
	
	def private void checkAlternativeVideos(AlternativeVideoSeq altvid) {
		var altPropability = 0
		
		for (vdesc : altvid.videodescs) {
			if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = altvid.videoid + genID()
			checkIds(altvid + vdesc.videoid)
			altPropability += vdesc.probability
		}
		
		if(altPropability > 100) throw new Exception("Probability could not exceed 100 !")
	}
	
	def private VideoDescription alternativeRandomizer(AlternativeVideoSeq altvid) {
		val probability = Math.random() * 100
		var cumulativeProbability = 0
		
		for (vdesc : altvid.videodescs) {
			if(probability > cumulativeProbability && probability <= vdesc.probability + cumulativeProbability){
				return vdesc
			}	
			cumulativeProbability += vdesc.probability
		}
	}
	
	def private void generateFile(String filename, String data) {
		val BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))
		try {
			buffer.write(data)
		}
		catch(IOException e) {
			throw e
		}
		finally {
			buffer.close()
		}
	}
	
	def private durationFFProbeCommand(String videopath)'''
		ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 «videopath»
	'''
	
	def private thumbnailFFMpegCommand(String videoLocation, String videoId, String outPath)'''
		ffmpeg -i «videoLocation» -ss 00:05 -vframes 1 «outPath»/«videoId».png
	'''
	
	def private htmlTemplate(VideoGeneratorModel videoGen, String imgPath)'''
		<ul>
		«FOR videoSeq: videoGen.videoseqs»
			«IF videoSeq instanceof MandatoryVideoSeq»
			<li id="«videoSeq.description.videoid»" data-type="mandatory">
				<img src="«imgPath»/«videoSeq.description.videoid»"/>
			</li>
			«ENDIF»
			«IF videoSeq instanceof OptionalVideoSeq»
			<li id="«videoSeq.description.videoid»" data-type="optional">
				<img src="«imgPath»/«videoSeq.description.videoid»"/>
			</li>
			«ENDIF»
			«IF videoSeq instanceof AlternativeVideoSeq»
			<li id="«videoSeq.videoid»" data-type="alternative">
				<img src="«imgPath»/«videoSeq.videoid»"/>
			</li>
			«ENDIF»
		«ENDFOR»
		</ul>
	'''
	
	def private m3uExtendTemplate(PlaylistGeneratorModel playlist)'''
		#EXTM3U
		«FOR mediafile: playlist.mediafiles»
		#EXT-X-DISCONTINUITY
		#EXTINF: «mediafile.duration», «mediafile.id»
		«mediafile.location»
		«ENDFOR»
		#EXT-X-ENDLIST
	'''
	
	def private ffmpegPlaylist(PlaylistGeneratorModel playlist)'''
		«FOR mediafile: playlist.mediafiles»
		file '«System.getProperty("user.dir")»/«mediafile.location»'
		«ENDFOR»
	'''
	
	def private ffmpegConcatenateCommand(String mpegPlaylistFile, String outputPath)'''
		ffmpeg -y -f concat -safe 0 -i «mpegPlaylistFile» -c copy «outputPath»
	'''
}
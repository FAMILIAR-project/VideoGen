package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoDemonstratorQ3 {
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorQ3.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  /**
   * @Test
   * def TpQ3() {
   * var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen"))
   * var fact = new VideogenPlayListFactoryImpl()
   * var playlist= fact.createPlayList()
   * assertNotNull(videoGen)
   * 
   * // MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
   * for(videoseq : videoGen.videoseqs.toSet) {
   * if (videoseq instanceof MandatoryVideoSeq) {
   * 
   * println("Mandatory")
   * val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
   * 
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = fileLocation
   * mediaFile.duration =  getDuration(fileLocation)
   * 
   * playlist.mediaFile.add(mediaFile)
   * 
   * } else if (videoseq instanceof OptionalVideoSeq) {
   * println("Optional")
   * val rand = new Random().nextInt(2);
   * // Random between 0-1
   * if (rand == 0) {
   * val fileLocation = (videoseq as OptionalVideoSeq).description.location;
   * 
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = fileLocation
   * mediaFile.duration =  getDuration(fileLocation)
   * playlist.mediaFile.add(mediaFile)
   * }
   * }
   * else {
   * println("Alternatives")
   * val size = (videoseq as AlternativeVideoSeq).videodescs.size;
   * var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).location;
   * 
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = fileLocation
   * mediaFile.duration =  getDuration(fileLocation)
   * playlist.mediaFile.add(mediaFile)
   * }
   * }
   * 
   * try {
   * val pl = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\playlistq3.m3u");
   * if (!pl.exists()) {
   * pl.createNewFile();
   * }
   * val fw = new FileWriter(pl.getAbsoluteFile());
   * val bw = new BufferedWriter(fw);
   * bw.write("#EXTM3U" +System.lineSeparator)
   * for( MediaFile mediafile : playlist.mediaFile){
   * bw.write("#EXTINF:" + mediafile.duration+ " ,Example Artist - Example title " + System.lineSeparator + mediafile.location + System.lineSeparator);
   * }
   * 
   * bw.close();
   * 
   * } catch (IOException e) {
   * e.printStackTrace
   * }
   * 
   * }
   */
  @Test
  public void test1() {
    URI _createURI = URI.createURI("fooVideos.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        if (_isNullOrEmpty) {
          String _genID = this.genID();
          desc.setVideoid(_genID);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_1 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          if (_isNullOrEmpty_1) {
            String _genID_1 = this.genID();
            desc_1.setVideoid(_genID_1);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_2 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          if (_isNullOrEmpty_2) {
            String _genID_2 = this.genID();
            altvid.setVideoid(_genID_2);
          }
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _videoid_3 = vdesc.getVideoid();
            boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
            if (_isNullOrEmpty_3) {
              String _genID_3 = this.genID();
              vdesc.setVideoid(_genID_3);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    URI _createURI_1 = URI.createURI("foo2bis.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("foo2bis.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
  }
  
  /**
   * def void printToM3u(VideoGeneratorModel videoGen) {
   * 
   * val fact = new VideogenPlayListFactoryImpl()
   * var playlist= fact.createPlayList()
   * 
   * for (videoseq : videoGen.videoseqs.toSet) {
   * if (videoseq instanceof MandatoryVideoSeq) {
   * println("Mandatory")
   * 
   * val desc = (videoseq as MandatoryVideoSeq).description.location;
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = desc
   * playlist.mediaFile.add(mediaFile)
   * 
   * } else if (videoseq instanceof OptionalVideoSeq) {
   * println("Optional")
   * val unsurDeux = new Random().nextInt(2);
   * 
   * if(unsurDeux ==0){
   * val desc = (videoseq as OptionalVideoSeq).description.location;
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = desc
   * playlist.mediaFile.add(mediaFile)
   * }
   * } else {
   * println("Alternative")
   * val altvidsize = (videoseq as AlternativeVideoSeq).videodescs.size;
   * val desc = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(altvidsize)).location;
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = desc
   * playlist.mediaFile.add(mediaFile)
   * }
   * }
   * try {
   * val CPlaylist = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\playlistq3.m3u");
   * if (!CPlaylist.exists()) {
   * CPlaylist.createNewFile();
   * }
   * println(CPlaylist.path);
   * 
   * val fw = new FileWriter(CPlaylist.getAbsoluteFile());
   * val bw = new BufferedWriter(fw);
   * bw.write("#EXTM3U" + System.lineSeparator);
   * for (MediaFile mediafile : playlist.mediaFile){
   * bw.write("#EXTINF:-1, Example Artist - Example title" + System.lineSeparator + mediafile.location + System.lineSeparator );
   * }
   * bw.close();
   * 
   * } catch (IOException e) {
   * e.printStackTrace
   * }
   * 
   * 
   * }
   */
  public VideoGeneratorModel loadVideoGenerator(final URI uri) {
    VideoGeneratorModel _xblockexpression = null;
    {
      VideoGenStandaloneSetupGenerated _videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated();
      _videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration();
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      Resource res = _resourceSetImpl.getResource(uri, true);
      EList<EObject> _contents = res.getContents();
      EObject _get = _contents.get(0);
      _xblockexpression = ((VideoGeneratorModel) _get);
    }
    return _xblockexpression;
  }
  
  public void saveVideoGenerator(final URI uri, final VideoGeneratorModel pollS) {
    try {
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      Resource rs = _resourceSetImpl.createResource(uri);
      EList<EObject> _contents = rs.getContents();
      _contents.add(pollS);
      HashMap<Object, Object> _hashMap = new HashMap<Object, Object>();
      rs.save(_hashMap);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static double getDuration(final String videoLocation) {
    try {
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(("C:\\Users\\kaoutar\\Downloads\\ffmpeg-20161204-1f5630a-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        outputJson = (outputJson + line);
      }
      double _parseDouble = Double.parseDouble(outputJson);
      long _round = Math.round(_parseDouble);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

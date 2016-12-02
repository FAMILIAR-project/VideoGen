package videogen;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import playlist.MediaFile;
import playlist.Playlist;
import playlist.PlaylistFactory;

@SuppressWarnings("all")
public class transformModelToText {
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
  
  public void transform() {
    try {
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final PrintWriter writer = new PrintWriter("/home/yousra/workspaceIDM/VideoGen/videogen/src/videogen/videogenresult.txt", "UTF-8");
      final Random random = new Random();
      random.nextInt(101);
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          writer.println(((((("file" + " ") + "\'") + desc) + "\'") + "\n"));
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            int proba = random.nextInt(1);
            if ((proba == 1)) {
              writer.println(((((("file" + " ") + "\'") + desc_1) + "\'") + "\n"));
            }
            InputOutput.<String>println(((("proba " + desc_1) + " ") + Integer.valueOf(proba)));
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            ArrayList<Object> l = new ArrayList<Object>();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            int proba_1 = random.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_1.get(proba_1);
            String _location = vaa.getLocation();
            String _plus = ((("file" + " ") + "\'") + _location);
            String _plus_1 = (_plus + "\'");
            String _plus_2 = (_plus_1 + "\n");
            writer.println(_plus_2);
          }
        }
      };
      _videoseqs.forEach(_function);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = transformModelToText.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  public Playlist playlist() {
    Playlist _xblockexpression = null;
    {
      final Playlist playlist = PlaylistFactory.eINSTANCE.createPlaylist();
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final Random random = new Random();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          MediaFile MF = PlaylistFactory.eINSTANCE.createMediaFile();
          MF.setLocation(desc);
          EList<MediaFile> _videos = playlist.getVideos();
          _videos.add(MF);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            int proba = random.nextInt(1);
            if ((proba == 1)) {
              MediaFile MF_1 = PlaylistFactory.eINSTANCE.createMediaFile();
              MF_1.setLocation(desc_1);
              EList<MediaFile> _videos_1 = playlist.getVideos();
              _videos_1.add(MF_1);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            ArrayList<Object> l = new ArrayList<Object>();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            int proba_1 = random.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_1.get(proba_1);
            MediaFile MF_2 = PlaylistFactory.eINSTANCE.createMediaFile();
            String _location = vaa.getLocation();
            MF_2.setLocation(_location);
            EList<MediaFile> _videos_2 = playlist.getVideos();
            _videos_2.add(MF_2);
          }
        }
      };
      _videoseqs.forEach(_function);
      _xblockexpression = playlist;
    }
    return _xblockexpression;
  }
  
  public void transformationPlaylistToFileM3U(final Playlist playlist) {
    try {
      final PrintWriter writer = new PrintWriter("result.m3u");
      EList<MediaFile> _videos = playlist.getVideos();
      for (final MediaFile element : _videos) {
        String _location = element.getLocation();
        String _plus = (_location + "\n");
        writer.write(_plus);
      }
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

package videogen;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import playList.MediaFile;
import playList.PlayList;
import playList.PlayListFactory;

@SuppressWarnings("all")
public class ModelToModel {
  public static VideoGeneratorModel loadVideoGenerator(final URI uri) {
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
  
  public static void modelToPlayList() {
    try {
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
      final PlayList playlist = PlayListFactory.eINSTANCE.createPlayList();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          final MediaFile mediaFile = PlayListFactory.eINSTANCE.createMediaFile();
          String _location = desc.getLocation();
          mediaFile.setLocation(_location);
          EList<MediaFile> _vids = playlist.getVids();
          _vids.add(mediaFile);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            Random _random = new Random();
            final int i = _random.nextInt(1);
            if ((i == 0)) {
              final MediaFile mediaFile_1 = PlayListFactory.eINSTANCE.createMediaFile();
              String _location_1 = desc_1.getLocation();
              mediaFile_1.setLocation(_location_1);
              EList<MediaFile> _vids_1 = playlist.getVids();
              _vids_1.add(mediaFile_1);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            Random _random_1 = new Random();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            final int j = _random_1.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vid = _videodescs_1.get(j);
            final MediaFile mediaFile_2 = PlayListFactory.eINSTANCE.createMediaFile();
            String _location_2 = vid.getLocation();
            mediaFile_2.setLocation(_location_2);
            EList<MediaFile> _vids_2 = playlist.getVids();
            _vids_2.add(mediaFile_2);
          }
        }
      };
      _videoseqs.forEach(_function);
      final String playlistOnString = ModelToModel.convertPlaylistIntoFormat(playlist, "M3U");
      File file = new File("playlist.m3u");
      FileWriter filewriter = new FileWriter(file);
      filewriter.write(playlistOnString);
      filewriter.flush();
      filewriter.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String convertPlaylistIntoFormat(final PlayList playlist, final String ext) {
    String _xblockexpression = null;
    {
      String data = "";
      boolean _equals = "M3U".equals(ext);
      if (_equals) {
        final EList<MediaFile> vids = playlist.getVids();
        for (final MediaFile f : vids) {
          String _data = data;
          String _location = f.getLocation();
          String _plus = (_location + "\n");
          data = (_data + _plus);
        }
      }
      _xblockexpression = data;
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    ModelToModel.modelToPlayList();
  }
}

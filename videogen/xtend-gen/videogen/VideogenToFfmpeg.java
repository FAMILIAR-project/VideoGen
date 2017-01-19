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
public class VideogenToFfmpeg {
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
  
  @Test
  public void test1() {
    URI _createURI = URI.createURI("foo1.videogen");
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
    URI _createURI_1 = URI.createURI("fooQ1bis.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("fooQ1bis.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
    this.toFFmpeg(videoGen);
  }
  
  public void toFFmpeg(final VideoGeneratorModel videoGen) {
    try {
      String content = "";
      final File file = new File("playList.txt");
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      }
      final FileWriter writer = new FileWriter(file);
      String _content = content;
      content = (_content + "# this is a comment \n");
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq video : _videoseqs) {
        if ((video instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) video).getDescription();
          String _videoid = desc.getVideoid();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
          boolean _not_1 = (!_isNullOrEmpty);
          if (_not_1) {
            String _content_1 = content;
            String _location = desc.getLocation();
            String _plus = ("file \'" + _location);
            String _plus_1 = (_plus + "\'\n");
            content = (_content_1 + _plus_1);
          }
        } else {
          if ((video instanceof OptionalVideoSeq)) {
            Random _random = new Random();
            int _nextInt = _random.nextInt(2);
            boolean _equals = (_nextInt == 0);
            if (_equals) {
              final VideoDescription desc_1 = ((OptionalVideoSeq) video).getDescription();
              String _videoid_1 = desc_1.getVideoid();
              boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
              boolean _not_2 = (!_isNullOrEmpty_1);
              if (_not_2) {
                String _content_2 = content;
                String _location_1 = desc_1.getLocation();
                String _plus_2 = ("file \'" + _location_1);
                String _plus_3 = (_plus_2 + "\'\n");
                content = (_content_2 + _plus_3);
              }
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) video);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            final int nbAltVids = _videodescs.size();
            Random _random_1 = new Random();
            final int i = _random_1.nextInt(nbAltVids);
            String _content_3 = content;
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            VideoDescription _get = _videodescs_1.get(i);
            String _location_2 = _get.getLocation();
            String _plus_4 = ("file \'" + _location_2);
            String _plus_5 = (_plus_4 + "\'\n");
            content = (_content_3 + _plus_5);
          }
        }
      }
      writer.write(content);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideogenToFfmpeg.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}

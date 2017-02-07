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
import org.eclipse.xtext.xbase.lib.InputOutput;
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
import playlist.Playlist;

@SuppressWarnings("all")
public class Demonstration {
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
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    int _size = _videoseqs.size();
    Assert.assertEquals(7, _size);
    EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
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
    _videoseqs_1.forEach(_function);
    URI _createURI_1 = URI.createURI("foo2bis.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("foo2bis.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
    this.printToHTML(videoGen);
  }
  
  @Test
  public void test3() {
    try {
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      Assert.assertNotNull(videoGen);
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      int _size = _videoseqs.size();
      Assert.assertEquals(7, _size);
      final File outputFile = new File("outagain.txt");
      final FileWriter out = new FileWriter(outputFile);
      EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        try {
          if ((videoseq instanceof MandatoryVideoSeq)) {
            VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
            final String chem = _description.getLocation();
            out.write(chem);
            out.write("\n");
          } else {
            if ((videoseq instanceof OptionalVideoSeq)) {
              final Random optional = new Random(2);
              int _nextInt = optional.nextInt();
              boolean _equals = (_nextInt == 1);
              if (_equals) {
                VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
                final String chem_1 = _description_1.getLocation();
                out.write(chem_1);
                out.write("\n");
              }
            } else {
              final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
              EList<VideoDescription> _videodescs = altvid.getVideodescs();
              final int size = _videodescs.size();
              Random _random = new Random();
              EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
              int _size_1 = _videodescs_1.size();
              final int optional_1 = _random.nextInt(_size_1);
              EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
              VideoDescription _get = _videodescs_2.get(optional_1);
              String _location = _get.getLocation();
              String _plus = (_location + "\n");
              out.write(_plus);
            }
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      _videoseqs_1.forEach(_function);
      out.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public Object test4() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createMediafile() is undefined for the type PlaylistFactory"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method createMediafile() is undefined for the type PlaylistFactory"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method createMediafile() is undefined for the type PlaylistFactory"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method convertPlaylistIntoFormat(Playlist, String) from the type Demonstration refers to the missing type Object"
      + "\nlocation cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public Object convertPlaylistIntoFormat(final Playlist p, final String format) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method or field location is undefined for the type Object"
      + "\nThe method location(Object) is undefined for the type Object"
      + "\nThe method or field location is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nforEach cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public void printToHTML(final VideoGeneratorModel videoGen) {
    InputOutput.<String>println("<ul>");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _videoid_1 = desc.getVideoid();
          String _plus = ("<li>" + _videoid_1);
          String _plus_1 = (_plus + "</li>");
          InputOutput.<String>println(_plus_1);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_2 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _videoid_3 = desc_1.getVideoid();
            String _plus_2 = ("<li>" + _videoid_3);
            String _plus_3 = (_plus_2 + "</li>");
            InputOutput.<String>println(_plus_3);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_4 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_4);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            String _videoid_5 = altvid.getVideoid();
            String _plus_4 = ("<li>" + _videoid_5);
            String _plus_5 = (_plus_4 + "</li>");
            InputOutput.<String>println(_plus_5);
          }
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            InputOutput.<String>println("<ul>");
          }
          EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs_1) {
            String _videoid_6 = vdesc.getVideoid();
            boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_6);
            boolean _not_3 = (!_isNullOrEmpty_3);
            if (_not_3) {
              String _videoid_7 = vdesc.getVideoid();
              String _plus_6 = ("<li>" + _videoid_7);
              String _plus_7 = (_plus_6 + "</li>");
              InputOutput.<String>println(_plus_7);
            }
          }
          EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
          int _size_1 = _videodescs_2.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            InputOutput.<String>println("</ul>");
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<String>println("</ul>");
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = Demonstration.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}

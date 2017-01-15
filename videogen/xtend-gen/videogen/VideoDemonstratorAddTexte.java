package videogen;

import com.google.common.base.Objects;
import java.util.HashMap;
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
import org.xtext.example.mydsl.videoGen.Subtitle;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

/**
 * Transformation xtend pour rajouter un durée dans le fichier du model
 */
@SuppressWarnings("all")
public class VideoDemonstratorAddTexte {
  private static String pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
  
  private static String pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/";
  
  private static String pathVideoSubtitle = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/Subs";
  
  private static String pathFontSubtitle = "C:/Windows/Fonts/Arial.ttf";
  
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
    URI _createURI = URI.createURI("fooRealSub.videogen");
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
    URI _createURI_1 = URI.createURI("fooRealOutSub.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("fooRealOutSub.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
    this.addSub(videoGen);
  }
  
  public void addSub(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        if (((!StringExtensions.isNullOrEmpty(desc.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc.getLocation())))) {
          Subtitle _subtitle = desc.getSubtitle();
          InputOutput.<Subtitle>println(_subtitle);
          if (((!Objects.equal(desc.getSubtitle(), null)) && (!StringExtensions.isNullOrEmpty(desc.getSubtitle().getText())))) {
            Subtitle _subtitle_1 = desc.getSubtitle();
            String text = _subtitle_1.getText();
            String color = null;
            int fontSize = 0;
            Subtitle _subtitle_2 = desc.getSubtitle();
            String _size = _subtitle_2.getSize();
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_size);
            boolean _not = (!_isNullOrEmpty);
            if (_not) {
              Subtitle _subtitle_3 = desc.getSubtitle();
              String _size_1 = _subtitle_3.getSize();
              int _parseInt = Integer.parseInt(_size_1);
              fontSize = _parseInt;
            } else {
              fontSize = 20;
            }
            Subtitle _subtitle_4 = desc.getSubtitle();
            String _colorfont = _subtitle_4.getColorfont();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_colorfont);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              Subtitle _subtitle_5 = desc.getSubtitle();
              String _colorfont_1 = _subtitle_5.getColorfont();
              color = _colorfont_1;
            } else {
              color = "white";
            }
            String _location = desc.getLocation();
            String _plus = (VideoDemonstratorAddTexte.pathVideo + _location);
            String _videoid = desc.getVideoid();
            VideoDemonstratorAddTexte.addSubtitle(_plus, _videoid, text, color, Integer.valueOf(fontSize));
          }
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if (((!StringExtensions.isNullOrEmpty(desc_1.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc_1.getLocation())))) {
            Subtitle _subtitle_6 = desc_1.getSubtitle();
            InputOutput.<Subtitle>println(_subtitle_6);
            if (((!Objects.equal(desc_1.getSubtitle(), null)) && (!StringExtensions.isNullOrEmpty(desc_1.getSubtitle().getText())))) {
              Subtitle _subtitle_7 = desc_1.getSubtitle();
              String text_1 = _subtitle_7.getText();
              String color_1 = null;
              int fontSize_1 = 0;
              Subtitle _subtitle_8 = desc_1.getSubtitle();
              String _size_2 = _subtitle_8.getSize();
              boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_size_2);
              boolean _not_2 = (!_isNullOrEmpty_2);
              if (_not_2) {
                Subtitle _subtitle_9 = desc_1.getSubtitle();
                String _size_3 = _subtitle_9.getSize();
                int _parseInt_1 = Integer.parseInt(_size_3);
                fontSize_1 = _parseInt_1;
              } else {
                fontSize_1 = 20;
              }
              Subtitle _subtitle_10 = desc_1.getSubtitle();
              String _colorfont_2 = _subtitle_10.getColorfont();
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_colorfont_2);
              boolean _not_3 = (!_isNullOrEmpty_3);
              if (_not_3) {
                Subtitle _subtitle_11 = desc_1.getSubtitle();
                String _colorfont_3 = _subtitle_11.getColorfont();
                color_1 = _colorfont_3;
              } else {
                color_1 = "white";
              }
              String _location_1 = desc_1.getLocation();
              String _plus_1 = (VideoDemonstratorAddTexte.pathVideo + _location_1);
              String _videoid_1 = desc_1.getVideoid();
              VideoDemonstratorAddTexte.addSubtitle(_plus_1, _videoid_1, text_1, color_1, Integer.valueOf(fontSize_1));
            }
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            if (((!StringExtensions.isNullOrEmpty(vdesc.getVideoid())) && (!StringExtensions.isNullOrEmpty(vdesc.getLocation())))) {
              Subtitle _subtitle_12 = vdesc.getSubtitle();
              InputOutput.<Subtitle>println(_subtitle_12);
              if (((!Objects.equal(vdesc.getSubtitle(), null)) && (!StringExtensions.isNullOrEmpty(vdesc.getSubtitle().getText())))) {
                Subtitle _subtitle_13 = vdesc.getSubtitle();
                String text_2 = _subtitle_13.getText();
                String color_2 = null;
                int fontSize_2 = 0;
                Subtitle _subtitle_14 = vdesc.getSubtitle();
                String _size_4 = _subtitle_14.getSize();
                boolean _isNullOrEmpty_4 = StringExtensions.isNullOrEmpty(_size_4);
                boolean _not_4 = (!_isNullOrEmpty_4);
                if (_not_4) {
                  Subtitle _subtitle_15 = vdesc.getSubtitle();
                  String _size_5 = _subtitle_15.getSize();
                  int _parseInt_2 = Integer.parseInt(_size_5);
                  fontSize_2 = _parseInt_2;
                } else {
                  fontSize_2 = 20;
                }
                Subtitle _subtitle_16 = vdesc.getSubtitle();
                String _colorfont_4 = _subtitle_16.getColorfont();
                boolean _isNullOrEmpty_5 = StringExtensions.isNullOrEmpty(_colorfont_4);
                boolean _not_5 = (!_isNullOrEmpty_5);
                if (_not_5) {
                  Subtitle _subtitle_17 = vdesc.getSubtitle();
                  String _colorfont_5 = _subtitle_17.getColorfont();
                  color_2 = _colorfont_5;
                } else {
                  color_2 = "white";
                }
                String _location_2 = vdesc.getLocation();
                String _plus_2 = (VideoDemonstratorAddTexte.pathVideo + _location_2);
                String _videoid_2 = vdesc.getVideoid();
                VideoDemonstratorAddTexte.addSubtitle(_plus_2, _videoid_2, text_2, color_2, Integer.valueOf(fontSize_2));
              }
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorAddTexte.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  /**
   * Paramêtre:
   * path: chemin de la video
   * name: nom de la video en sortie
   * texte: le texte de la video
   * color: couleur du texte
   * size: taille du texte
   * (Note: on peut jouer sur d'autres paramêtres pour cela completer la grammair xtext)
   */
  public static void addSubtitle(final String path, final String name, final String texte, final String color, final Integer size) {
    System.out.println((((((((((((((("ffmpeg -i " + path) + " -vf drawtext=\"fontfile=") + VideoDemonstratorAddTexte.pathFontSubtitle) + ": \\text=\'") + texte) + "\': fontcolor=") + color) + ": fontsize=") + size) + ": box=1: boxcolor=black@0.5: \\ boxborderw=5: x=(w-text_w)/2: y=(h-text_h)/2\" -codec:a copy ") + VideoDemonstratorAddTexte.pathVideoSubtitle) + "/") + name) + ".mp4"));
  }
}

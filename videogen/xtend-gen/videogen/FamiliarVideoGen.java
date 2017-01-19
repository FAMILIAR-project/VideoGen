package videogen;

import com.google.common.base.Objects;
import fr.unice.polytech.modalis.familiar.fm.basic.FMLFeatureModelReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
public class FamiliarVideoGen {
  private FMLFeatureModelReader myvar = new FMLFeatureModelReader();
  
  private String res = "";
  
  private ArrayList<String> alternativeList = new ArrayList<String>();
  
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
  
  @Test
  public void testing() {
    this.toFamiliar("foo3.videogen", "foo3.fml");
  }
  
  public void toFamiliar(final String input, final String output) {
    try {
      URI _createURI = URI.createURI(input);
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      Assert.assertNotNull(videoGen);
      this.res = "fmVideoGen = FM (VideoGen: ";
      ArrayList<String> _arrayList = new ArrayList<String>();
      this.alternativeList = _arrayList;
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid = _description.getVideoid();
          boolean _equals = Objects.equal(_videoid, null);
          if (_equals) {
            throw new NullPointerException("all videos must have a identifier to generate a fml file");
          }
          String _res = this.res;
          VideoDescription _description_1 = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid_1 = _description_1.getVideoid();
          String _plus = (_videoid_1 + " ");
          this.res = (_res + _plus);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_2 = _description_2.getVideoid();
            boolean _equals_1 = Objects.equal(_videoid_2, null);
            if (_equals_1) {
              throw new NullPointerException("all videos must have a identifier to generate a fml file");
            }
            String _res_1 = this.res;
            VideoDescription _description_3 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_3 = _description_3.getVideoid();
            String _plus_1 = ("[" + _videoid_3);
            String _plus_2 = (_plus_1 + "] ");
            this.res = (_res_1 + _plus_2);
          } else {
            String _videoid_4 = ((AlternativeVideoSeq) videoseq).getVideoid();
            boolean _equals_2 = Objects.equal(_videoid_4, null);
            if (_equals_2) {
              throw new NullPointerException("all videos must have a identifier to generate a fml file");
            }
            String _res_2 = this.res;
            String _videoid_5 = ((AlternativeVideoSeq) videoseq).getVideoid();
            String _plus_3 = (_videoid_5 + " ");
            this.res = (_res_2 + _plus_3);
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            String _videoid_6 = ((AlternativeVideoSeq) videoseq).getVideoid();
            String tmp = (_videoid_6 + ": (");
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                String _videoid_7 = vdesc.getVideoid();
                boolean _equals_3 = Objects.equal(_videoid_7, null);
                if (_equals_3) {
                  throw new NullPointerException("all videos must have a identifier to generate a fml file");
                }
                String _tmp = tmp;
                String _videoid_8 = vdesc.getVideoid();
                String _plus_4 = (_videoid_8 + "|");
                tmp = (_tmp + _plus_4);
              }
            }
            int _length = tmp.length();
            int _minus = (_length - 1);
            String _substring = tmp.substring(0, _minus);
            tmp = _substring;
            String _tmp = tmp;
            tmp = (_tmp + ");\n");
            this.alternativeList.add(tmp);
          }
        }
      };
      _videoseqs.forEach(_function);
      String _res = this.res;
      this.res = (_res + ";\n");
      for (final String entry : this.alternativeList) {
        String _res_1 = this.res;
        this.res = (_res_1 + entry);
      }
      String _res_2 = this.res;
      this.res = (_res_2 + ")");
      final PrintWriter file = new PrintWriter(output, "UTF-8");
      file.println(this.res);
      file.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

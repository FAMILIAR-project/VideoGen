package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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

/**
 * Transformation xtend pour faire des calculs métriques (projet 1)
 */
@SuppressWarnings("all")
public class VideoDemonstratorCalculMetrique {
  private static String pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
  
  private static String pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/";
  
  private static int borneCsv = 100;
  
  private final HashMap<Integer, Integer> tailleVar = new HashMap<Integer, Integer>();
  
  private final HashMap<Integer, Integer> dureeVar = new HashMap<Integer, Integer>();
  
  private final HashMap<Integer, String> idVar = new HashMap<Integer, String>();
  
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
    URI _createURI = URI.createURI("fooReal.videogen");
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
    URI _createURI_1 = URI.createURI("fooRealOut.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("fooRealOut.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
    this.findSequence(videoGen);
  }
  
  public void findSequence(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        if (((!StringExtensions.isNullOrEmpty(desc.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc.getLocation())))) {
          String _location = desc.getLocation();
          String _plus = (VideoDemonstratorCalculMetrique.pathVideo + _location);
          int duree = VideoDemonstratorCalculMetrique.getDuration(_plus);
          boolean _isEmpty = this.tailleVar.isEmpty();
          if (_isEmpty) {
            this.tailleVar.put(Integer.valueOf(1), Integer.valueOf(1));
            this.dureeVar.put(Integer.valueOf(1), Integer.valueOf(duree));
            String _videoid = desc.getVideoid();
            this.idVar.put(Integer.valueOf(1), _videoid);
          } else {
            Set<Map.Entry<Integer, Integer>> _entrySet = this.tailleVar.entrySet();
            for (final Map.Entry<Integer, Integer> variante : _entrySet) {
              Integer _key = variante.getKey();
              Integer _value = variante.getValue();
              int _plus_1 = ((_value).intValue() + 1);
              this.tailleVar.put(_key, Integer.valueOf(_plus_1));
            }
            Set<Map.Entry<Integer, Integer>> _entrySet_1 = this.dureeVar.entrySet();
            for (final Map.Entry<Integer, Integer> variante_1 : _entrySet_1) {
              Integer _key_1 = variante_1.getKey();
              Integer _value_1 = variante_1.getValue();
              int _plus_2 = ((_value_1).intValue() + duree);
              this.dureeVar.put(_key_1, Integer.valueOf(_plus_2));
            }
            Set<Map.Entry<Integer, String>> _entrySet_2 = this.idVar.entrySet();
            for (final Map.Entry<Integer, String> variante_2 : _entrySet_2) {
              Integer _key_2 = variante_2.getKey();
              String _value_2 = variante_2.getValue();
              String _plus_3 = (_value_2 + " ");
              String _videoid_1 = desc.getVideoid();
              String _plus_4 = (_plus_3 + _videoid_1);
              this.idVar.put(_key_2, _plus_4);
            }
          }
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if (((!StringExtensions.isNullOrEmpty(desc_1.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc_1.getLocation())))) {
            String _location_1 = desc_1.getLocation();
            String _plus_5 = (VideoDemonstratorCalculMetrique.pathVideo + _location_1);
            int duree_1 = VideoDemonstratorCalculMetrique.getDuration(_plus_5);
            boolean _isEmpty_1 = this.tailleVar.isEmpty();
            if (_isEmpty_1) {
              this.tailleVar.put(Integer.valueOf(1), Integer.valueOf(1));
              this.dureeVar.put(Integer.valueOf(1), Integer.valueOf(duree_1));
              String _videoid_2 = desc_1.getVideoid();
              this.idVar.put(Integer.valueOf(1), _videoid_2);
              this.tailleVar.put(Integer.valueOf(2), Integer.valueOf(0));
              this.dureeVar.put(Integer.valueOf(2), Integer.valueOf(0));
              this.idVar.put(Integer.valueOf(2), "");
            } else {
              HashMap<Integer, Integer> tailleVarNew = new HashMap<Integer, Integer>();
              HashMap<Integer, Integer> dureeVarNew = new HashMap<Integer, Integer>();
              HashMap<Integer, String> idVarNew = new HashMap<Integer, String>();
              int t = 0;
              int d = 0;
              int i = 0;
              Set<Map.Entry<Integer, Integer>> _entrySet_3 = this.tailleVar.entrySet();
              for (final Map.Entry<Integer, Integer> variantet : _entrySet_3) {
                {
                  t++;
                  int _size = this.tailleVar.size();
                  int _plus_6 = (_size + t);
                  Integer _value_3 = variantet.getValue();
                  int _plus_7 = ((_value_3).intValue() + 1);
                  tailleVarNew.put(Integer.valueOf(_plus_6), Integer.valueOf(_plus_7));
                }
              }
              Set<Map.Entry<Integer, Integer>> _entrySet_4 = this.dureeVar.entrySet();
              for (final Map.Entry<Integer, Integer> varianted : _entrySet_4) {
                {
                  d++;
                  int _size = this.dureeVar.size();
                  int _plus_6 = (_size + d);
                  Integer _value_3 = varianted.getValue();
                  int _plus_7 = ((_value_3).intValue() + duree_1);
                  dureeVarNew.put(Integer.valueOf(_plus_6), Integer.valueOf(_plus_7));
                }
              }
              Set<Map.Entry<Integer, String>> _entrySet_5 = this.idVar.entrySet();
              for (final Map.Entry<Integer, String> variantei : _entrySet_5) {
                {
                  i++;
                  int _size = this.idVar.size();
                  int _plus_6 = (_size + i);
                  String _value_3 = variantei.getValue();
                  String _plus_7 = (_value_3 + " ");
                  String _videoid_3 = desc_1.getVideoid();
                  String _plus_8 = (_plus_7 + _videoid_3);
                  idVarNew.put(Integer.valueOf(_plus_6), _plus_8);
                }
              }
              this.tailleVar.putAll(tailleVarNew);
              this.dureeVar.putAll(dureeVarNew);
              this.idVar.putAll(idVarNew);
            }
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          boolean _isEmpty_2 = this.tailleVar.isEmpty();
          if (_isEmpty_2) {
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                String _location_2 = vdesc.getLocation();
                String _plus_6 = (VideoDemonstratorCalculMetrique.pathVideo + _location_2);
                int duree_2 = VideoDemonstratorCalculMetrique.getDuration(_plus_6);
                int _size = this.tailleVar.size();
                int _plus_7 = (_size + 1);
                this.tailleVar.put(Integer.valueOf(_plus_7), Integer.valueOf(1));
                int _size_1 = this.dureeVar.size();
                int _plus_8 = (_size_1 + 1);
                this.dureeVar.put(Integer.valueOf(_plus_8), Integer.valueOf(duree_2));
                int _size_2 = this.idVar.size();
                int _plus_9 = (_size_2 + 1);
                String _videoid_3 = vdesc.getVideoid();
                this.idVar.put(Integer.valueOf(_plus_9), _videoid_3);
              }
            }
          } else {
            HashMap<Integer, Integer> tailleVarNew_1 = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> dureeVarNew_1 = new HashMap<Integer, Integer>();
            HashMap<Integer, String> idVarNew_1 = new HashMap<Integer, String>();
            int t_1 = 0;
            int d_1 = 0;
            int i_1 = 0;
            boolean first = true;
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            for (final VideoDescription vdesc_1 : _videodescs_1) {
              {
                String _location_2 = vdesc_1.getLocation();
                String _plus_6 = (VideoDemonstratorCalculMetrique.pathVideo + _location_2);
                int duree_2 = VideoDemonstratorCalculMetrique.getDuration(_plus_6);
                if (first) {
                  Set<Map.Entry<Integer, Integer>> _entrySet_6 = this.tailleVar.entrySet();
                  for (final Map.Entry<Integer, Integer> variante_3 : _entrySet_6) {
                    Integer _key_3 = variante_3.getKey();
                    Integer _value_3 = variante_3.getValue();
                    int _plus_7 = ((_value_3).intValue() + 1);
                    tailleVarNew_1.put(_key_3, Integer.valueOf(_plus_7));
                  }
                  Set<Map.Entry<Integer, Integer>> _entrySet_7 = this.dureeVar.entrySet();
                  for (final Map.Entry<Integer, Integer> variante_4 : _entrySet_7) {
                    Integer _key_4 = variante_4.getKey();
                    Integer _value_4 = variante_4.getValue();
                    int _plus_8 = ((_value_4).intValue() + duree_2);
                    dureeVarNew_1.put(_key_4, Integer.valueOf(_plus_8));
                  }
                  Set<Map.Entry<Integer, String>> _entrySet_8 = this.idVar.entrySet();
                  for (final Map.Entry<Integer, String> variante_5 : _entrySet_8) {
                    Integer _key_5 = variante_5.getKey();
                    String _value_5 = variante_5.getValue();
                    String _plus_9 = (_value_5 + " ");
                    String _videoid_3 = vdesc_1.getVideoid();
                    String _plus_10 = (_plus_9 + _videoid_3);
                    idVarNew_1.put(_key_5, _plus_10);
                  }
                  first = false;
                } else {
                  Set<Map.Entry<Integer, Integer>> _entrySet_9 = this.tailleVar.entrySet();
                  for (final Map.Entry<Integer, Integer> variantet_1 : _entrySet_9) {
                    {
                      t_1++;
                      int _size = this.tailleVar.size();
                      int _plus_11 = (_size + t_1);
                      Integer _value_6 = variantet_1.getValue();
                      int _plus_12 = ((_value_6).intValue() + 1);
                      tailleVarNew_1.put(Integer.valueOf(_plus_11), Integer.valueOf(_plus_12));
                    }
                  }
                  Set<Map.Entry<Integer, Integer>> _entrySet_10 = this.dureeVar.entrySet();
                  for (final Map.Entry<Integer, Integer> varianted_1 : _entrySet_10) {
                    {
                      d_1++;
                      int _size = this.dureeVar.size();
                      int _plus_11 = (_size + d_1);
                      Integer _value_6 = varianted_1.getValue();
                      int _plus_12 = ((_value_6).intValue() + duree_2);
                      dureeVarNew_1.put(Integer.valueOf(_plus_11), Integer.valueOf(_plus_12));
                    }
                  }
                  Set<Map.Entry<Integer, String>> _entrySet_11 = this.idVar.entrySet();
                  for (final Map.Entry<Integer, String> variantei_1 : _entrySet_11) {
                    {
                      i_1++;
                      int _size = this.idVar.size();
                      int _plus_11 = (_size + i_1);
                      String _value_6 = variantei_1.getValue();
                      String _plus_12 = (_value_6 + " ");
                      String _videoid_4 = vdesc_1.getVideoid();
                      String _plus_13 = (_plus_12 + _videoid_4);
                      idVarNew_1.put(Integer.valueOf(_plus_11), _plus_13);
                    }
                  }
                }
              }
            }
            this.tailleVar.putAll(tailleVarNew_1);
            this.dureeVar.putAll(dureeVarNew_1);
            this.idVar.putAll(idVarNew_1);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<HashMap<Integer, Integer>>println(this.tailleVar);
    InputOutput.<HashMap<Integer, Integer>>println(this.dureeVar);
    InputOutput.<HashMap<Integer, String>>println(this.idVar);
    VideoDemonstratorCalculMetrique.exportCSV(this.tailleVar, this.dureeVar, this.idVar);
  }
  
  public static void exportCSV(final HashMap<Integer, Integer> tailleVar, final HashMap<Integer, Integer> dureeVar, final HashMap<Integer, String> idVar) {
    int tailleMin = (-1);
    int tailleMoy = (-1);
    int tailleMax = (-1);
    int dureeMin = (-1);
    int dureeMoy = (-1);
    int dureeMax = (-1);
    int nbsequence = tailleVar.size();
    String contentsCSV = "Sequence;Taille;Duree\n";
    int i = 1;
    while (((i < nbsequence) && (i < VideoDemonstratorCalculMetrique.borneCsv))) {
      {
        String _contentsCSV = contentsCSV;
        String _get = idVar.get(Integer.valueOf(i));
        String _plus = (_get + ";");
        contentsCSV = (_contentsCSV + _plus);
        String _contentsCSV_1 = contentsCSV;
        Integer _get_1 = tailleVar.get(Integer.valueOf(i));
        String _plus_1 = (_get_1 + ";");
        contentsCSV = (_contentsCSV_1 + _plus_1);
        String _contentsCSV_2 = contentsCSV;
        Integer _get_2 = dureeVar.get(Integer.valueOf(i));
        String _plus_2 = (_get_2 + "\n");
        contentsCSV = (_contentsCSV_2 + _plus_2);
        i++;
      }
    }
    Set<Map.Entry<Integer, Integer>> _entrySet = tailleVar.entrySet();
    for (final Map.Entry<Integer, Integer> variantet : _entrySet) {
      {
        if (((tailleMin == (-1)) || (tailleMin > (variantet.getValue()).intValue()))) {
          Integer _value = variantet.getValue();
          tailleMin = (_value).intValue();
        }
        if (((tailleMax == (-1)) || (tailleMax < (variantet.getValue()).intValue()))) {
          Integer _value_1 = variantet.getValue();
          tailleMax = (_value_1).intValue();
        }
        int _tailleMoy = tailleMoy;
        Integer _value_2 = variantet.getValue();
        tailleMoy = (_tailleMoy + (_value_2).intValue());
      }
    }
    Set<Map.Entry<Integer, Integer>> _entrySet_1 = dureeVar.entrySet();
    for (final Map.Entry<Integer, Integer> varianted : _entrySet_1) {
      {
        if (((dureeMin == (-1)) || (dureeMin > (varianted.getValue()).intValue()))) {
          Integer _value = varianted.getValue();
          dureeMin = (_value).intValue();
        }
        if (((dureeMax == (-1)) || (dureeMax < (varianted.getValue()).intValue()))) {
          Integer _value_1 = varianted.getValue();
          dureeMax = (_value_1).intValue();
        }
        int _dureeMoy = dureeMoy;
        Integer _value_2 = varianted.getValue();
        dureeMoy = (_dureeMoy + (_value_2).intValue());
      }
    }
    dureeMoy = (dureeMoy / nbsequence);
    tailleMoy = (tailleMoy / nbsequence);
    System.out.println(((((("Taille max: " + Integer.valueOf(tailleMax)) + " Taille min: ") + Integer.valueOf(tailleMin)) + " Taille moy: ") + Integer.valueOf(tailleMoy)));
    System.out.println(((((("Duree max: " + Integer.valueOf(dureeMax)) + " Duree min: ") + Integer.valueOf(dureeMin)) + " Duree moy: ") + Integer.valueOf(dureeMoy)));
    System.out.println(("Nb Séquence: " + Integer.valueOf(nbsequence)));
    try {
      PrintWriter writer = new PrintWriter("exportCsv.csv", "UTF-8");
      writer.println(contentsCSV);
      writer.close();
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        StackTraceElement[] _stackTrace = e.getStackTrace();
        System.out.println(_stackTrace);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static int getDuration(final String path) {
    try {
      String pathnorm = path.replace("/", "\\");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec((((VideoDemonstratorCalculMetrique.pathFFmpeg + "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"") + pathnorm) + "\""));
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        outputJson = (outputJson + line);
      }
      float _parseFloat = Float.parseFloat(outputJson);
      int _round = Math.round(_parseFloat);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorCalculMetrique.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}

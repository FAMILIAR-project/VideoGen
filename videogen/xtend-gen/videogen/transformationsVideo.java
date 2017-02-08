package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class transformationsVideo {
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
      final PrintWriter writer = new PrintWriter("videogenresult.txt", "UTF-8");
      final Random random = new Random();
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
    int _plusPlus = transformationsVideo.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  /**
   * Question 2 : Voir le nouveau projet qu'on a crée pour définir la playlist,
   * nommé : projet idm Q2
   */
  public double calculDuree(final String videoLocation) {
    try {
      double _xblockexpression = (double) 0;
      {
        String cmd = ("ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation);
        Runtime _runtime = Runtime.getRuntime();
        Process p = _runtime.exec(cmd);
        InputStream _inputStream = p.getInputStream();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
        BufferedReader reader = new BufferedReader(_inputStreamReader);
        double line = 0.0;
        String truc = reader.readLine();
        double _xifexpression = (double) 0;
        boolean _notEquals = (!Objects.equal(truc, null));
        if (_notEquals) {
          double _xblockexpression_1 = (double) 0;
          {
            double _parseDouble = Double.parseDouble(truc);
            line = _parseDouble;
            _xblockexpression_1 = line;
          }
          _xifexpression = _xblockexpression_1;
        } else {
          _xifexpression = 1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void creationVignette(final String videoLocation, final int tempsCapture, final String chemin) {
    try {
      Runtime _runtime = Runtime.getRuntime();
      Process p1 = _runtime.exec("pwd");
      InputStream _inputStream = p1.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader1 = new BufferedReader(_inputStreamReader);
      String pwd = reader1.readLine();
      InputOutput.<String>println((((((("vignette : " + videoLocation) + " to ") + chemin) + " at ") + Integer.valueOf(tempsCapture)) + "s"));
      String cmd = ((((("ffmpeg -y -i " + videoLocation) + " -r 1 -t 00:00:01 -ss 00:00:") + Integer.valueOf(tempsCapture)) + " ") + chemin);
      InputOutput.<String>println(("with cmd : " + cmd));
      Runtime _runtime_1 = Runtime.getRuntime();
      Process p = _runtime_1.exec(cmd);
      while (p.isAlive()) {
        boolean _isAlive = p.isAlive();
        boolean _not = (!_isAlive);
        if (_not) {
          return;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Question 10:transformation qui prend en entrée une spécification VideoGen et qui
   * génère en sortie une page Web affichant les vignettes
   */
  public void printToHTML(final VideoGeneratorModel videoGen) {
    try {
      final PrintWriter writer = new PrintWriter("PageHTMLvideogen.html");
      InputOutput.<String>println("<ul>");
      writer.write("<ul>\n");
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          double _calculDuree = this.calculDuree(desc);
          int _intValue = Double.valueOf(_calculDuree).intValue();
          int _divide = (_intValue / 2);
          this.creationVignette(desc, _divide, (desc + ".png"));
          InputOutput.<String>println(((("<li>" + "<img src=") + desc) + ".png/></li>"));
          writer.write(((("<li>" + "Mandatory<img src=") + desc) + ".png/></li>\n"));
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            double _calculDuree_1 = this.calculDuree(desc_1);
            int _intValue_1 = Double.valueOf(_calculDuree_1).intValue();
            int _divide_1 = (_intValue_1 / 2);
            this.creationVignette(desc_1, _divide_1, (desc_1 + ".png"));
            InputOutput.<String>println(((("<li>" + "<img src=") + desc_1) + ".png/></li>"));
            writer.write(((("<li>" + "Optional<img src=") + desc_1) + ".png/></li>\n"));
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              InputOutput.<String>println("<ul>");
            }
            writer.write("<ul>\n");
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs_1) {
              {
                String _location = vdesc.getLocation();
                String _location_1 = vdesc.getLocation();
                double _calculDuree_2 = this.calculDuree(_location_1);
                int _intValue_2 = Double.valueOf(_calculDuree_2).intValue();
                int _divide_2 = (_intValue_2 / 2);
                String _location_2 = vdesc.getLocation();
                String _plus = (_location_2 + ".png");
                this.creationVignette(_location, _divide_2, _plus);
                String _location_3 = vdesc.getLocation();
                String _plus_1 = (("<li>" + "<img src=") + _location_3);
                String _plus_2 = (_plus_1 + ".png/></li>");
                InputOutput.<String>println(_plus_2);
                String _location_4 = vdesc.getLocation();
                String _plus_3 = (("<li>" + "Alternative<img src=") + _location_4);
                String _plus_4 = (_plus_3 + ".png/></li>\n");
                writer.write(_plus_4);
              }
            }
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            int _size_1 = _videodescs_2.size();
            boolean _greaterThan_1 = (_size_1 > 0);
            if (_greaterThan_1) {
              InputOutput.<String>println("</ul>");
            }
            writer.write("</ul>\n");
          }
        }
      };
      _videoseqs.forEach(_function);
      InputOutput.<String>println("</ul>");
      writer.write("<ul>\n");
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Question 11 : transformation qui prend en entrée une spécification VideoGen et qui
   * vérifie:
   * L'unicité des ID
   * L'unicité des localisations des videos seq
   * une probabilité d’une séquence vidéo “optionnelle” ne peut dépasser 1 (100%);
   * la somme des probabilités ne doit pas dépasser 100% pour les séquences video “alternatif”
   */
  public void verify() {
    try {
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      String idOp = "";
      String idAl = "";
      String idM = "";
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid = _description.getVideoid();
          idM = _videoid;
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(idM);
          if (_isNullOrEmpty) {
            String _genID = this.genID();
            idM = _genID;
          }
          if ((Objects.equal(idM, idOp) || Objects.equal(idM, idAl))) {
            throw new Exception();
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final int probabilite = _description_1.getProbability();
            VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_1 = _description_2.getVideoid();
            idOp = _videoid_1;
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(idOp);
            if (_isNullOrEmpty_1) {
              String _genID_1 = this.genID();
              idOp = _genID_1;
            }
            if (((Objects.equal(idOp, idM) || Objects.equal(idOp, idAl)) || (probabilite > 1))) {
              throw new Exception();
            }
          } else {
            int totalProb = 0;
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                String _videoid_2 = vdesc.getVideoid();
                idAl = _videoid_2;
                final int probabilite_1 = vdesc.getProbability();
                boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(idAl);
                if (_isNullOrEmpty_2) {
                  String _genID_2 = this.genID();
                  idAl = _genID_2;
                }
                if ((Objects.equal(idAl, idOp) || Objects.equal(idAl, idM))) {
                  throw new Exception();
                }
                int _talProb = totalProb;
                totalProb = (_talProb + probabilite_1);
              }
            }
            if ((totalProb > 1)) {
              throw new Exception();
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void printToHTMLWithRandom(final VideoGeneratorModel playlist) {
    try {
      final PrintWriter writer = new PrintWriter("PageHTMLvideogen2.html");
      final PrintWriter writer2 = new PrintWriter("ffmpegConcatFile");
      final Random random = new Random();
      InputOutput.<String>println("<ul>");
      writer.write("<ul>\n");
      EList<VideoSeq> _videoseqs = playlist.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          double _calculDuree = this.calculDuree(desc);
          int _intValue = Double.valueOf(_calculDuree).intValue();
          int _divide = (_intValue / 2);
          this.creationVignette(desc, _divide, (desc + ".png"));
          InputOutput.<String>println(((("<li>" + "<img src=") + desc) + ".png/></li>"));
          writer.write(((("<li>" + "Mandatory<img src=") + desc) + ".png/></li>\n"));
          writer2.write((("file \'" + desc) + "\'\n"));
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            int proba = random.nextInt(2);
            InputOutput.<String>println(("proba :" + Integer.valueOf(proba)));
            if ((proba == 1)) {
              double _calculDuree_1 = this.calculDuree(desc_1);
              int _intValue_1 = Double.valueOf(_calculDuree_1).intValue();
              int _divide_1 = (_intValue_1 / 2);
              this.creationVignette(desc_1, _divide_1, (desc_1 + ".png"));
              InputOutput.<String>println(((("<li>" + "<img src=") + desc_1) + ".png/></li>"));
              writer.write(((("<li>" + "Optional<img src=") + desc_1) + ".png/></li>\n"));
              writer2.write((("file \'" + desc_1) + "\'\n"));
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              InputOutput.<String>println("<ul>");
            }
            writer.write("<ul>\n");
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            int _size_1 = _videodescs_1.size();
            int proba_1 = random.nextInt(_size_1);
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_2.get(proba_1);
            String _location = vaa.getLocation();
            String _location_1 = vaa.getLocation();
            double _calculDuree_2 = this.calculDuree(_location_1);
            int _intValue_2 = Double.valueOf(_calculDuree_2).intValue();
            int _divide_2 = (_intValue_2 / 2);
            String _location_2 = vaa.getLocation();
            String _plus = (_location_2 + ".png");
            this.creationVignette(_location, _divide_2, _plus);
            String _location_3 = vaa.getLocation();
            String _plus_1 = (("<li>" + "<img src=") + _location_3);
            String _plus_2 = (_plus_1 + ".png/></li>");
            InputOutput.<String>println(_plus_2);
            String _location_4 = vaa.getLocation();
            String _plus_3 = (("<li>" + "Alternative<img src=") + _location_4);
            String _plus_4 = (_plus_3 + ".png/></li>\n");
            writer.write(_plus_4);
            String _location_5 = vaa.getLocation();
            String _plus_5 = ("file \'" + _location_5);
            String _plus_6 = (_plus_5 + "\'\n");
            writer2.write(_plus_6);
          }
        }
        InputOutput.<String>println("</ul>");
        writer.write("</ul>\n");
      };
      _videoseqs.forEach(_function);
      InputOutput.<String>println("</ul>");
      writer.write("<ul>\n");
      writer.close();
      writer2.close();
      String cmd = "ffmpeg -f concat -i ffmpegConcatFile -c copy output.mp4";
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(cmd);
      while (p.isAlive()) {
        boolean _isAlive = p.isAlive();
        boolean _not = (!_isAlive);
        if (_not) {
          return;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void createVideoGen() {
    try {
      String cmd = "./scriptVG.sh";
      Runtime _runtime = Runtime.getRuntime();
      Process execCommande = _runtime.exec(cmd);
      while (execCommande.isAlive()) {
        boolean _isAlive = execCommande.isAlive();
        boolean _not = (!_isAlive);
        if (_not) {
          return;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String applyFilter(final String filter, final String inputVideo) {
    try {
      String _xblockexpression = null;
      {
        InputOutput.<String>println("appel filter");
        String cmd = (((((("ffmpeg -i " + inputVideo) + " -strict -2  -vf \"format=yuva444p9, ") + filter) + "\"  ") + inputVideo) + 
          ".avecfilter.mp4");
        InputOutput.<String>println(("cmd :" + cmd));
        Runtime _runtime = Runtime.getRuntime();
        Process execCommande = _runtime.exec(cmd);
        int _waitFor = execCommande.waitFor();
        String _plus = ("exit code : " + Integer.valueOf(_waitFor));
        InputOutput.<String>println(_plus);
        InputOutput.<String>println(
          "la commande est bonne, si vous copier la cmd depuis le dossier videogen dans un terminal elle fonctionne");
        InputStream _inputStream = execCommande.getInputStream();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
        BufferedReader reader = new BufferedReader(_inputStreamReader);
        String truc = reader.readLine();
        while ((!Objects.equal(truc, null))) {
          {
            InputOutput.<String>println(truc);
            String _readLine = reader.readLine();
            truc = _readLine;
          }
        }
        _xblockexpression = InputOutput.<String>println("leaving filter");
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void filters(final VideoGeneratorModel playlist) {
    try {
      final PrintWriter writer = new PrintWriter("PageHTMLvideogen2.html");
      final PrintWriter writer2 = new PrintWriter("ffmpegConcatFile");
      final Random random = new Random();
      InputOutput.<String>println("<ul>");
      writer.write("<ul>\n");
      EList<VideoSeq> _videoseqs = playlist.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          double _calculDuree = this.calculDuree(desc);
          int _intValue = Double.valueOf(_calculDuree).intValue();
          int _divide = (_intValue / 2);
          this.creationVignette(desc, _divide, (desc + ".png"));
          InputOutput.<String>println(((("<li>" + "<img src=") + desc) + ".png/></li>"));
          writer.write(((("<li>" + "Mandatory<img src=") + desc) + ".png/></li>\n"));
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            int proba = random.nextInt(2);
            InputOutput.<String>println(("proba :" + Integer.valueOf(proba)));
            if ((proba == 1)) {
              double _calculDuree_1 = this.calculDuree(desc_1);
              int _intValue_1 = Double.valueOf(_calculDuree_1).intValue();
              int _divide_1 = (_intValue_1 / 2);
              this.creationVignette(desc_1, _divide_1, (desc_1 + ".png"));
              InputOutput.<String>println(((("<li>" + "<img src=") + desc_1) + ".png/></li>"));
              writer.write(((("<li>" + "Optional<img src=") + desc_1) + ".png/></li>\n"));
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              InputOutput.<String>println("<ul>");
            }
            writer.write("<ul>\n");
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            int _size_1 = _videodescs_1.size();
            int proba_1 = random.nextInt(_size_1);
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_2.get(proba_1);
            String _location = vaa.getLocation();
            String _location_1 = vaa.getLocation();
            double _calculDuree_2 = this.calculDuree(_location_1);
            int _intValue_2 = Double.valueOf(_calculDuree_2).intValue();
            int _divide_2 = (_intValue_2 / 2);
            String _location_2 = vaa.getLocation();
            String _plus = (_location_2 + ".png");
            this.creationVignette(_location, _divide_2, _plus);
            String _location_3 = vaa.getLocation();
            String _plus_1 = (("<li>" + "<img src=") + _location_3);
            String _plus_2 = (_plus_1 + ".png/></li>");
            InputOutput.<String>println(_plus_2);
            String _location_4 = vaa.getLocation();
            String _plus_3 = (("<li>" + "Alternative<img src=") + _location_4);
            String _plus_4 = (_plus_3 + ".png/></li>\n");
            writer.write(_plus_4);
          }
        }
        InputOutput.<String>println("</ul>");
        writer.write("</ul>\n");
      };
      _videoseqs.forEach(_function);
      InputOutput.<String>println("</ul>");
      writer.write("<ul>\n");
      writer.close();
      writer2.close();
      String cmd = "ffmpeg -f concat -i ffmpegConcatFile -c copy output.mp4";
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(cmd);
      while (p.isAlive()) {
        boolean _isAlive = p.isAlive();
        boolean _not = (!_isAlive);
        if (_not) {
          return;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void createFeatureModel() {
    try {
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final Random random = new Random();
      final PrintWriter writer = new PrintWriter("fmVideoGen.fm");
      String c1 = "";
      String c2 = "";
      String c3 = "";
      String c6 = "";
      String c8 = "";
      String c9 = "";
      String c10 = "";
      c1 = "fmVideoGen=FM(VideoGen:";
      writer.write(c1);
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid = _description.getVideoid();
          c2 = _videoid;
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(c2);
          if (_isNullOrEmpty) {
            String _genID = this.genID();
            c2 = _genID;
          }
          writer.write(c2);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_1 = _description_1.getVideoid();
            c3 = _videoid_1;
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(c3);
            if (_isNullOrEmpty_1) {
              String _genID_1 = this.genID();
              c3 = _genID_1;
            }
            writer.write((("[" + c3) + "]"));
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            String _videoid_2 = altvid.getVideoid();
            c6 = _videoid_2;
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(c6);
            if (_isNullOrEmpty_2) {
              String _genID_2 = this.genID();
              c6 = _genID_2;
            }
            writer.write(c6);
          }
        }
      }
      EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
      for (final VideoSeq videoseq_1 : _videoseqs_1) {
        if ((videoseq_1 instanceof AlternativeVideoSeq)) {
          final AlternativeVideoSeq altvid_1 = ((AlternativeVideoSeq) videoseq_1);
          String _videoid_3 = altvid_1.getVideoid();
          c8 = _videoid_3;
          EList<VideoDescription> _videodescs = altvid_1.getVideodescs();
          int count = _videodescs.size();
          boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(c8);
          if (_isNullOrEmpty_3) {
            String _genID_3 = this.genID();
            c8 = _genID_3;
          }
          EList<VideoDescription> _videodescs_1 = altvid_1.getVideodescs();
          int _size = _videodescs_1.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            c9 = (((";" + c8) + ":") + "(");
            writer.write(c9);
            EList<VideoDescription> _videodescs_2 = altvid_1.getVideodescs();
            for (final VideoDescription vdesc : _videodescs_2) {
              {
                if ((count > 1)) {
                  String _videoid_4 = vdesc.getVideoid();
                  c10 = _videoid_4;
                  boolean _isNullOrEmpty_4 = StringExtensions.isNullOrEmpty(c10);
                  if (_isNullOrEmpty_4) {
                    String _genID_4 = this.genID();
                    c10 = _genID_4;
                  }
                  writer.write((c10 + "|"));
                } else {
                  String _videoid_5 = vdesc.getVideoid();
                  c10 = _videoid_5;
                  boolean _isNullOrEmpty_5 = StringExtensions.isNullOrEmpty(c10);
                  if (_isNullOrEmpty_5) {
                    String _genID_5 = this.genID();
                    c10 = _genID_5;
                  }
                  writer.write((c10 + ")"));
                }
                count = (count - 1);
              }
            }
          } else {
            c9 = ((";" + c8) + ":");
            writer.write(c9);
            EList<VideoDescription> _videodescs_3 = altvid_1.getVideodescs();
            for (final VideoDescription vdesc_1 : _videodescs_3) {
              {
                String _videoid_4 = vdesc_1.getVideoid();
                c10 = _videoid_4;
                boolean _isNullOrEmpty_4 = StringExtensions.isNullOrEmpty(c10);
                if (_isNullOrEmpty_4) {
                  String _genID_4 = this.genID();
                  c10 = _genID_4;
                }
                writer.write(c10);
              }
            }
          }
        }
      }
      writer.write(";)");
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void printToHTML() {
    try {
      final PrintWriter writer = new PrintWriter("src/main/webapp/generatedPageHTMLvideogen.html");
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel playlist = this.loadVideoGenerator(_createURI);
      long _currentTimeMillis = System.currentTimeMillis();
      String _plus = ("" + Long.valueOf(_currentTimeMillis));
      writer.write(_plus);
      final PrintWriter writer2 = new PrintWriter("ffmpegConcatFile");
      final Random random = new Random();
      InputOutput.<String>println("<ul>");
      writer.write("<ul>\n");
      EList<VideoSeq> _videoseqs = playlist.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          double _calculDuree = this.calculDuree(desc);
          int _intValue = Double.valueOf(_calculDuree).intValue();
          int _divide = (_intValue / 2);
          this.creationVignette(desc, _divide, (desc + ".png"));
          InputOutput.<String>println(((("<li>" + "<img src=") + desc) + ".png/></li>"));
          writer.write(((("<li>" + "Mandatory<img src=") + desc) + ".png/></li>\n"));
          writer2.write((("file \'src/main/webapp/" + desc) + "\'\n"));
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            int proba = random.nextInt(2);
            InputOutput.<String>println(("proba :" + Integer.valueOf(proba)));
            if ((proba == 1)) {
              double _calculDuree_1 = this.calculDuree(desc_1);
              int _intValue_1 = Double.valueOf(_calculDuree_1).intValue();
              int _divide_1 = (_intValue_1 / 2);
              this.creationVignette(desc_1, _divide_1, (desc_1 + ".png"));
              InputOutput.<String>println(((("<li>" + "<img src=") + desc_1) + ".png/></li>"));
              writer.write(((("<li>" + "Optional<img src=") + desc_1) + ".png/></li>\n"));
              writer2.write((("file \'src/main/webapp/" + desc_1) + "\'\n"));
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              InputOutput.<String>println("<ul>");
            }
            writer.write("<ul>\n");
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            int _size_1 = _videodescs_1.size();
            int proba_1 = random.nextInt(_size_1);
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_2.get(proba_1);
            String _location = vaa.getLocation();
            String _location_1 = vaa.getLocation();
            double _calculDuree_2 = this.calculDuree(_location_1);
            int _intValue_2 = Double.valueOf(_calculDuree_2).intValue();
            int _divide_2 = (_intValue_2 / 2);
            String _location_2 = vaa.getLocation();
            String _plus_1 = (_location_2 + ".png");
            this.creationVignette(_location, _divide_2, _plus_1);
            String _location_3 = vaa.getLocation();
            String _plus_2 = (("<li>" + "<img src=") + _location_3);
            String _plus_3 = (_plus_2 + ".png/></li>");
            InputOutput.<String>println(_plus_3);
            String _location_4 = vaa.getLocation();
            String _plus_4 = (("<li>" + "Alternative<img src=") + _location_4);
            String _plus_5 = (_plus_4 + ".png/></li>\n");
            writer.write(_plus_5);
            String _location_5 = vaa.getLocation();
            String _plus_6 = ("file \'src/main/webapp/" + _location_5);
            String _plus_7 = (_plus_6 + "\'\n");
            writer2.write(_plus_7);
          }
        }
        InputOutput.<String>println("</ul>");
        writer.write("</ul>\n");
      };
      _videoseqs.forEach(_function);
      InputOutput.<String>println("</ul>");
      writer.write("<ul>\n");
      writer.close();
      writer2.close();
      String cmd = "ffmpeg -f concat -i ffmpegConcatFile -c copy src/main/webapp/output.mp4";
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(cmd);
      while (p.isAlive()) {
        boolean _isAlive = p.isAlive();
        boolean _not = (!_isAlive);
        if (_not) {
          return;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

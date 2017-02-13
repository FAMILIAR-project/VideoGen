package videogen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoGenerator {
  private int seqId = 0;
  
  private List<String> ids = new ArrayList<String>();
  
  public void generateSequence(final String videogenFile, final String outPath, final String playlistName) {
    throw new Error("Unresolved compilation problems:"
      + "\nPlaylistGeneratorModel cannot be resolved to a type."
      + "\nThe method generatePlaylistModel(VideoGeneratorModel) from the type VideoGenerator refers to the missing type PlaylistGeneratorModel"
      + "\nThe method generateM3UExtFile(PlaylistGeneratorModel, String) from the type VideoGenerator refers to the missing type PlaylistGeneratorModel");
  }
  
  public /* PlaylistGeneratorModel */Object generatePlaylistModel(final VideoGeneratorModel videoGeneratorModel) {
    throw new Error("Unresolved compilation problems:"
      + "\nPlaylistFactory cannot be resolved to a type."
      + "\nPlaylistGeneratorModel cannot be resolved to a type."
      + "\nMediafile cannot be resolved to a type."
      + "\nMediafile cannot be resolved to a type."
      + "\nMediafile cannot be resolved to a type."
      + "\nPlaylistFactoryImpl cannot be resolved."
      + "\ncreatePlaylistGeneratorModel cannot be resolved"
      + "\ncreateMediafile cannot be resolved"
      + "\nsetId cannot be resolved"
      + "\nsetLocation cannot be resolved"
      + "\nsetDuration cannot be resolved"
      + "\ngetLocation cannot be resolved"
      + "\nmediafiles cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ncreateMediafile cannot be resolved"
      + "\nsetId cannot be resolved"
      + "\nsetLocation cannot be resolved"
      + "\nsetDuration cannot be resolved"
      + "\ngetLocation cannot be resolved"
      + "\nmediafiles cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ncreateMediafile cannot be resolved"
      + "\nsetLocation cannot be resolved"
      + "\nsetId cannot be resolved"
      + "\nsetDuration cannot be resolved"
      + "\ngetLocation cannot be resolved"
      + "\nmediafiles cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public String getSequenceHtml(final VideoGeneratorModel videogen, final String thumbsPath) {
    CharSequence _htmlTemplate = this.htmlTemplate(videogen, thumbsPath);
    return _htmlTemplate.toString();
  }
  
  public void generateVideogenThumbnails(final String videogenPath, final String outPath) {
    URI _createURI = URI.createURI(videogenPath);
    final VideoGeneratorModel videoGen = this.loadVideoGeneratorModel(_createURI);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoSeq) -> {
      try {
        if ((videoSeq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq)videoSeq).getDescription();
          String _videoid = _description.getVideoid();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
          if (_isNullOrEmpty) {
            VideoDescription _description_1 = ((MandatoryVideoSeq)videoSeq).getDescription();
            String _genID = this.genID();
            _description_1.setVideoid(_genID);
          }
          Runtime _runtime = Runtime.getRuntime();
          VideoDescription _description_2 = ((MandatoryVideoSeq)videoSeq).getDescription();
          String _location = _description_2.getLocation();
          VideoDescription _description_3 = ((MandatoryVideoSeq)videoSeq).getDescription();
          String _videoid_1 = _description_3.getVideoid();
          CharSequence _thumbnailFFMpegCommand = this.thumbnailFFMpegCommand(_location, _videoid_1, outPath);
          String _string = _thumbnailFFMpegCommand.toString();
          _runtime.exec(_string);
        }
        if ((videoSeq instanceof AlternativeVideoSeq)) {
          String _videoid_2 = ((AlternativeVideoSeq)videoSeq).getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_2);
          if (_isNullOrEmpty_1) {
            String _genID_1 = this.genID();
            ((AlternativeVideoSeq)videoSeq).setVideoid(_genID_1);
          }
          this.checkAlternativeVideos(((AlternativeVideoSeq)videoSeq));
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq)videoSeq).getVideodescs();
          final Consumer<VideoDescription> _function_1 = (VideoDescription desc) -> {
            try {
              Runtime _runtime_1 = Runtime.getRuntime();
              String _location_1 = desc.getLocation();
              String _videoid_3 = desc.getVideoid();
              CharSequence _thumbnailFFMpegCommand_1 = this.thumbnailFFMpegCommand(_location_1, _videoid_3, outPath);
              String _string_1 = _thumbnailFFMpegCommand_1.toString();
              _runtime_1.exec(_string_1);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          _videodescs.forEach(_function_1);
        }
        if ((videoSeq instanceof OptionalVideoSeq)) {
          VideoDescription _description_4 = ((OptionalVideoSeq)videoSeq).getDescription();
          String _videoid_3 = _description_4.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_3);
          if (_isNullOrEmpty_2) {
            VideoDescription _description_5 = ((OptionalVideoSeq)videoSeq).getDescription();
            String _genID_2 = this.genID();
            _description_5.setVideoid(_genID_2);
          }
          Runtime _runtime_1 = Runtime.getRuntime();
          VideoDescription _description_6 = ((OptionalVideoSeq)videoSeq).getDescription();
          String _location_1 = _description_6.getLocation();
          VideoDescription _description_7 = ((OptionalVideoSeq)videoSeq).getDescription();
          String _videoid_4 = _description_7.getVideoid();
          CharSequence _thumbnailFFMpegCommand_1 = this.thumbnailFFMpegCommand(_location_1, _videoid_4, outPath);
          String _string_1 = _thumbnailFFMpegCommand_1.toString();
          _runtime_1.exec(_string_1);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public ArrayList<String> generateConfigThumbnails(final String videogenPath, final String outPath) {
    URI _createURI = URI.createURI(videogenPath);
    final VideoGeneratorModel videoGen = this.loadVideoGeneratorModel(_createURI);
    return this.generateConfigThumbnails(videoGen, outPath);
  }
  
  public ArrayList<String> generateConfigThumbnails(final VideoGeneratorModel videoGen, final String outPath) {
    final ArrayList<String> ids = new ArrayList<String>();
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      try {
        if ((videoseq instanceof AlternativeVideoSeq)) {
          String _videoid = ((AlternativeVideoSeq)videoseq).getVideoid();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
          if (_isNullOrEmpty) {
            String _genID = this.genID();
            ((AlternativeVideoSeq)videoseq).setVideoid(_genID);
          }
          this.checkAlternativeVideos(((AlternativeVideoSeq)videoseq));
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq)videoseq).getVideodescs();
          final Consumer<VideoDescription> _function_1 = (VideoDescription desc) -> {
            try {
              Runtime _runtime = Runtime.getRuntime();
              String _location = desc.getLocation();
              String _videoid_1 = desc.getVideoid();
              CharSequence _thumbnailFFMpegCommand = this.thumbnailFFMpegCommand(_location, _videoid_1, outPath);
              String _string = _thumbnailFFMpegCommand.toString();
              _runtime.exec(_string);
              String _videoid_2 = desc.getVideoid();
              ids.add(_videoid_2);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          _videodescs.forEach(_function_1);
        }
        if ((videoseq instanceof OptionalVideoSeq)) {
          VideoDescription _description = ((OptionalVideoSeq)videoseq).getDescription();
          String _videoid_1 = _description.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          if (_isNullOrEmpty_1) {
            VideoDescription _description_1 = ((OptionalVideoSeq)videoseq).getDescription();
            String _genID_1 = this.genID();
            _description_1.setVideoid(_genID_1);
          }
          Runtime _runtime = Runtime.getRuntime();
          VideoDescription _description_2 = ((OptionalVideoSeq)videoseq).getDescription();
          String _location = _description_2.getLocation();
          VideoDescription _description_3 = ((OptionalVideoSeq)videoseq).getDescription();
          String _videoid_2 = _description_3.getVideoid();
          CharSequence _thumbnailFFMpegCommand = this.thumbnailFFMpegCommand(_location, _videoid_2, outPath);
          String _string = _thumbnailFFMpegCommand.toString();
          _runtime.exec(_string);
          VideoDescription _description_4 = ((OptionalVideoSeq)videoseq).getDescription();
          String _videoid_3 = _description_4.getVideoid();
          ids.add(_videoid_3);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    _videoseqs.forEach(_function);
    return ids;
  }
  
  public ArrayList<String> generatePlaylistThumbnails(final /* PlaylistGeneratorModel */Object playlist, final String outPath) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field location is undefined for the type Object"
      + "\nThe method or field id is undefined for the type Object"
      + "\nThe method or field id is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nmediafiles cannot be resolved"
      + "\nforEach cannot be resolved");
  }
  
  public void generateVideoFile(final String videogenFile, final String filename, final String outpath) {
    throw new Error("Unresolved compilation problems:"
      + "\nPlaylistGeneratorModel cannot be resolved to a type."
      + "\nThe method generatePlaylistModel(VideoGeneratorModel) from the type VideoGenerator refers to the missing type PlaylistGeneratorModel"
      + "\nThe method ffmpegPlaylist(PlaylistGeneratorModel) from the type VideoGenerator refers to the missing type PlaylistGeneratorModel");
  }
  
  private VideoGeneratorModel loadVideoGeneratorModel(final URI uri) {
    VideoGenStandaloneSetupGenerated _videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated();
    _videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration();
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    Resource res = _resourceSetImpl.getResource(uri, true);
    EList<EObject> _contents = res.getContents();
    EObject _get = _contents.get(0);
    return ((VideoGeneratorModel) _get);
  }
  
  private /* PlaylistGeneratorModel */Object loadPlaylistGeneratorModel(final URI uri) {
    throw new Error("Unresolved compilation problems:"
      + "\nPlaylistGeneratorModel cannot be resolved to a type."
      + "\nPlaylistStandaloneSetupGenerated cannot be resolved."
      + "\ncreateInjectorAndDoEMFRegistration cannot be resolved");
  }
  
  private void generateM3UExtFile(final /* PlaylistGeneratorModel */Object playlist, final String filename) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method m3uExtendTemplate(PlaylistGeneratorModel) from the type VideoGenerator refers to the missing type PlaylistGeneratorModel");
  }
  
  private String genID() {
    int _plusPlus = this.seqId++;
    return ("sequence" + Integer.valueOf(_plusPlus));
  }
  
  private Float getDuration(final String videoLocation) {
    try {
      Runtime _runtime = Runtime.getRuntime();
      CharSequence _durationFFProbeCommand = this.durationFFProbeCommand(videoLocation);
      String _string = _durationFFProbeCommand.toString();
      final Process pr = _runtime.exec(_string);
      InputStream _inputStream = pr.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      final BufferedReader resBuffer = new BufferedReader(_inputStreamReader);
      String _readLine = resBuffer.readLine();
      return Float.valueOf(Float.parseFloat(_readLine));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void checkIds(final String id) {
    try {
      boolean _contains = this.ids.contains(id);
      if (_contains) {
        throw new Exception((("ID : " + id) + " already exist !"));
      } else {
        this.ids.add(id);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void checkAlternativeVideos(final AlternativeVideoSeq altvid) {
    try {
      int altPropability = 0;
      EList<VideoDescription> _videodescs = altvid.getVideodescs();
      for (final VideoDescription vdesc : _videodescs) {
        {
          String _videoid = vdesc.getVideoid();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
          if (_isNullOrEmpty) {
            String _videoid_1 = altvid.getVideoid();
            String _genID = this.genID();
            String _plus = (_videoid_1 + _genID);
            vdesc.setVideoid(_plus);
          }
          String _videoid_2 = vdesc.getVideoid();
          String _plus_1 = (altvid + _videoid_2);
          this.checkIds(_plus_1);
          int _altPropability = altPropability;
          int _probability = vdesc.getProbability();
          altPropability = (_altPropability + _probability);
        }
      }
      if ((altPropability > 100)) {
        throw new Exception("Probability could not exceed 100 !");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private VideoDescription alternativeRandomizer(final AlternativeVideoSeq altvid) {
    double _random = Math.random();
    final double probability = (_random * 100);
    int cumulativeProbability = 0;
    EList<VideoDescription> _videodescs = altvid.getVideodescs();
    for (final VideoDescription vdesc : _videodescs) {
      {
        if (((probability > cumulativeProbability) && (probability <= (vdesc.getProbability() + cumulativeProbability)))) {
          return vdesc;
        }
        int _cumulativeProbability = cumulativeProbability;
        int _probability = vdesc.getProbability();
        cumulativeProbability = (_cumulativeProbability + _probability);
      }
    }
    return null;
  }
  
  private void generateFile(final String filename, final String data) {
    try {
      FileOutputStream _fileOutputStream = new FileOutputStream(filename);
      OutputStreamWriter _outputStreamWriter = new OutputStreamWriter(_fileOutputStream, "utf-8");
      final BufferedWriter buffer = new BufferedWriter(_outputStreamWriter);
      try {
        buffer.write(data);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        buffer.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private CharSequence durationFFProbeCommand(final String videopath) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 ");
    _builder.append(videopath, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence thumbnailFFMpegCommand(final String videoLocation, final String videoId, final String outPath) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ffmpeg -i ");
    _builder.append(videoLocation, "");
    _builder.append(" -ss 00:05 -vframes 1 ");
    _builder.append(outPath, "");
    _builder.append("/");
    _builder.append(videoId, "");
    _builder.append(".png");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence htmlTemplate(final VideoGeneratorModel videoGen, final String imgPath) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ul>");
    _builder.newLine();
    {
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for(final VideoSeq videoSeq : _videoseqs) {
        {
          if ((videoSeq instanceof MandatoryVideoSeq)) {
            _builder.append("<li id=\"");
            VideoDescription _description = ((MandatoryVideoSeq)videoSeq).getDescription();
            String _videoid = _description.getVideoid();
            _builder.append(_videoid, "");
            _builder.append("\" data-type=\"mandatory\">");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<img src=\"");
            _builder.append(imgPath, "\t");
            _builder.append("/");
            VideoDescription _description_1 = ((MandatoryVideoSeq)videoSeq).getDescription();
            String _videoid_1 = _description_1.getVideoid();
            _builder.append(_videoid_1, "\t");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
            _builder.append("</li>");
            _builder.newLine();
          }
        }
        {
          if ((videoSeq instanceof OptionalVideoSeq)) {
            _builder.append("<li id=\"");
            VideoDescription _description_2 = ((OptionalVideoSeq)videoSeq).getDescription();
            String _videoid_2 = _description_2.getVideoid();
            _builder.append(_videoid_2, "");
            _builder.append("\" data-type=\"optional\">");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<img src=\"");
            _builder.append(imgPath, "\t");
            _builder.append("/");
            VideoDescription _description_3 = ((OptionalVideoSeq)videoSeq).getDescription();
            String _videoid_3 = _description_3.getVideoid();
            _builder.append(_videoid_3, "\t");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
            _builder.append("</li>");
            _builder.newLine();
          }
        }
        {
          if ((videoSeq instanceof AlternativeVideoSeq)) {
            _builder.append("<li id=\"");
            String _videoid_4 = ((AlternativeVideoSeq)videoSeq).getVideoid();
            _builder.append(_videoid_4, "");
            _builder.append("\" data-type=\"alternative\">");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<img src=\"");
            _builder.append(imgPath, "\t");
            _builder.append("/");
            String _videoid_5 = ((AlternativeVideoSeq)videoSeq).getVideoid();
            _builder.append(_videoid_5, "\t");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
            _builder.append("</li>");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("</ul>");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence m3uExtendTemplate(final /* PlaylistGeneratorModel */Object playlist) {
    throw new Error("Unresolved compilation problems:"
      + "\nmediafiles cannot be resolved"
      + "\nduration cannot be resolved"
      + "\nid cannot be resolved"
      + "\nlocation cannot be resolved");
  }
  
  private CharSequence ffmpegPlaylist(final /* PlaylistGeneratorModel */Object playlist) {
    throw new Error("Unresolved compilation problems:"
      + "\nmediafiles cannot be resolved"
      + "\nlocation cannot be resolved");
  }
  
  private CharSequence ffmpegConcatenateCommand(final String mpegPlaylistFile, final String outputPath) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ffmpeg -y -f concat -safe 0 -i ");
    _builder.append(mpegPlaylistFile, "");
    _builder.append(" -c copy ");
    _builder.append(outputPath, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}

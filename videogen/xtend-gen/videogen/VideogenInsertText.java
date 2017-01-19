package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogenPlaylist.MediaFile;
import videogenPlaylist.Playlist;
import videogenPlaylist.impl.VideogenPlaylistFactoryImpl;

@SuppressWarnings("all")
public class VideogenInsertText {
  private static String rootPath = "createdPlaylists/";
  
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
      Process process = _runtime.exec((("lib\\ffmpeg-3.2.2-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + VideogenInsertText.rootPath) + videoLocation));
      process.waitFor(2000, TimeUnit.MILLISECONDS);
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
  
  public static String insertText(final String videoLocation, final String text, final String positionX, final String positionY) {
    try {
      String[] name = videoLocation.split("\\.(?=[^\\.]+$)");
      String pathFontFile = "OpenSans-Regular.ttf";
      String _get = name[0];
      String _plus = (((((((((((((("lib\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -i " + VideogenInsertText.rootPath) + videoLocation) + " -vf drawtext=\'fontfile=") + VideogenInsertText.rootPath) + pathFontFile) + ":text=") + text) + ":fontcolor=white:fontsize=44:box=1:boxcolor=black@0.5:boxborderw=5:x=") + positionX) + ":y=") + positionY) + "\' -codec:a copy ") + VideogenInsertText.rootPath) + _get);
      String cmd = (_plus + "-2.webm");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmd);
      InputOutput.<String>println(cmd);
      process.waitFor(2000, TimeUnit.MILLISECONDS);
      String _get_1 = name[0];
      return (_get_1 + "-2.webm");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    URI _createURI = URI.createURI("testVideos.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    VideogenPlaylistFactoryImpl factory = new VideogenPlaylistFactoryImpl();
    Playlist playlist = factory.createPlaylist();
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    Set<VideoSeq> _set = IterableExtensions.<VideoSeq>toSet(_videoseqs);
    for (final VideoSeq videoseq : _set) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String fileLocation = _description.getLocation();
        MediaFile mediafile = factory.createMediaFile();
        mediafile.setPath(fileLocation);
        double _duration = VideogenInsertText.getDuration(fileLocation);
        mediafile.setDuration(_duration);
        mediafile.setText("Mandatory");
        mediafile.setXAxis("(w-text_w)/2");
        mediafile.setYAxis("(h-text_h)/2");
        String _path = mediafile.getPath();
        String _text = mediafile.getText();
        String _xAxis = mediafile.getXAxis();
        String _yAxis = mediafile.getYAxis();
        String locatTemp = VideogenInsertText.insertText(_path, _text, _xAxis, _yAxis);
        mediafile.setPath(locatTemp);
        EList<MediaFile> _mediaFile = playlist.getMediaFile();
        _mediaFile.add(mediafile);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          Random _random = new Random();
          int _nextInt = _random.nextInt(2);
          boolean _equals = (_nextInt == 0);
          if (_equals) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String fileLocation_1 = _description_1.getLocation();
            MediaFile mediafile_1 = factory.createMediaFile();
            mediafile_1.setPath(fileLocation_1);
            double _duration_1 = VideogenInsertText.getDuration(fileLocation_1);
            mediafile_1.setDuration(_duration_1);
            mediafile_1.setText("Optional");
            mediafile_1.setXAxis("(w-text_w)/3");
            mediafile_1.setYAxis("(h-text_h)/3");
            String _path_1 = mediafile_1.getPath();
            String _text_1 = mediafile_1.getText();
            String _xAxis_1 = mediafile_1.getXAxis();
            String _yAxis_1 = mediafile_1.getYAxis();
            String locatTemp_1 = VideogenInsertText.insertText(_path_1, _text_1, _xAxis_1, _yAxis_1);
            mediafile_1.setPath(locatTemp_1);
            EList<MediaFile> _mediaFile_1 = playlist.getMediaFile();
            _mediaFile_1.add(mediafile_1);
          }
        } else {
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq) videoseq).getVideodescs();
          final int size = _videodescs.size();
          EList<VideoDescription> _videodescs_1 = ((AlternativeVideoSeq) videoseq).getVideodescs();
          Random _random_1 = new Random();
          int _nextInt_1 = _random_1.nextInt(size);
          VideoDescription _get = _videodescs_1.get(_nextInt_1);
          String fileLocation_2 = _get.getLocation();
          MediaFile mediafile_2 = factory.createMediaFile();
          mediafile_2.setPath(fileLocation_2);
          double _duration_2 = VideogenInsertText.getDuration(fileLocation_2);
          mediafile_2.setDuration(_duration_2);
          mediafile_2.setText("Alternative");
          mediafile_2.setXAxis("(w-text_w)/4");
          mediafile_2.setYAxis("(h-text_h)/4");
          String _path_2 = mediafile_2.getPath();
          String _text_2 = mediafile_2.getText();
          String _xAxis_2 = mediafile_2.getXAxis();
          String _yAxis_2 = mediafile_2.getYAxis();
          String locatTemp_2 = VideogenInsertText.insertText(_path_2, _text_2, _xAxis_2, _yAxis_2);
          mediafile_2.setPath(locatTemp_2);
          EList<MediaFile> _mediaFile_2 = playlist.getMediaFile();
          _mediaFile_2.add(mediafile_2);
        }
      }
    }
    try {
      final File newPlaylist = new File("createdPlaylists/playlistText.m3u");
      boolean _exists = newPlaylist.exists();
      boolean _not = (!_exists);
      if (_not) {
        newPlaylist.createNewFile();
      }
      File _absoluteFile = newPlaylist.getAbsoluteFile();
      final FileWriter fw = new FileWriter(_absoluteFile);
      final BufferedWriter bw = new BufferedWriter(fw);
      bw.write("#EXTM3U \n");
      EList<MediaFile> _mediaFile_3 = playlist.getMediaFile();
      for (final MediaFile mediafile_3 : _mediaFile_3) {
        double _duration_3 = mediafile_3.getDuration();
        String _plus = ("#EXTINF:" + Double.valueOf(_duration_3));
        String _plus_1 = (_plus + ", Example Artist - Example title \n");
        String _path_3 = mediafile_3.getPath();
        String _plus_2 = (_plus_1 + _path_3);
        String _plus_3 = (_plus_2 + "\n");
        bw.write(_plus_3);
      }
      bw.close();
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private static int i = 0;
  
  public static String genID() {
    int _plusPlus = VideogenInsertText.i++;
    return ("" + Integer.valueOf(_plusPlus));
  }
}

package videogen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.tritcorp.playlist.model.Playlist.MediaFile;
import org.tritcorp.playlist.model.Playlist.Playlist;
import org.tritcorp.playlist.model.Playlist.PlaylistFactory;
import org.tritcorp.playlist.model.Playlist.impl.PlaylistFactoryImpl;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class playlistTools {
	 private static int i = 0;
	
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
  
  public void concatFFMPEG() {
    try {
      Runtime runtime = Runtime.getRuntime();
      final Process res = runtime.exec("ffmpeg.exe -f concat -i out.ffmpeg -c copy output.mp4");
      System.out.println(res);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  
  public void genDuration(String file){
	  
	  String cmd = "ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "+file+" >res.txt";
	  Process process;
		try {
			process = Runtime.getRuntime().exec(cmd);
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void genVignette(String file){
	  String cmd = "ffmpeg -i "+file+" -ss 00:00:01.000 -vframes 1 "+file+".jpg -y";
	  Process process;
	  try {
		  process = Runtime.getRuntime().exec(cmd);
		  try {
			  process.waitFor();
		  } catch (InterruptedException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
	  } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }		        
  }
  
  public void playlistToM3U(final Playlist playlist) {
    try {
      final FileWriter fw = new FileWriter("out.m3u");
      EList<MediaFile> _files = playlist.getFiles();
      final Consumer<MediaFile> _function = (MediaFile file) -> {
        try {
          String _path = file.getPath();
          String _plus = (_path + "\n");
          fw.write(_plus);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      _files.forEach(_function);
      fw.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void playlistToFFMPEG(final Playlist playlist) {
    try {
      final FileWriter fw = new FileWriter("out.ffmpeg");
      EList<MediaFile> _files = playlist.getFiles();
      final Consumer<MediaFile> _function = (MediaFile file) -> {
        try {
          String _path = file.getPath();
          String _plus = ("file \'" + _path);
          String _plus_1 = (_plus + "\'\n");
          fw.write(_plus_1);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      _files.forEach(_function);
      fw.close();
      this.concatFFMPEG();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void playlistToVignettes(final Playlist playlist) {
	    try {
	      EList<MediaFile> _files = playlist.getFiles();
	      final Consumer<MediaFile> _function = (MediaFile file) -> {
	        try {
	        	String _path = file.getPath();
	        	genVignette(_path);
	        } catch (Throwable _e) {
	          throw Exceptions.sneakyThrow(_e);
	        }
	      };
	      _files.forEach(_function);
	    } catch (Throwable _e) {
	      throw Exceptions.sneakyThrow(_e);
	    }
	  }
  
  public Playlist testM2M() {
    URI _createURI = URI.createURI("foo2bis.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    final PlaylistFactory plf = PlaylistFactoryImpl.init();
    final Playlist pl = plf.createPlaylist();
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      final Random rand = new Random();
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          MediaFile mf = plf.createMediaFile();
          String _location_1 = desc.getLocation();
          mf.setPath(_location_1);
          EList<MediaFile> _files = pl.getFiles();
          _files.add(mf);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          final int p = desc_1.getProbability();
          final int res = rand.nextInt(100);
          if ((p > 0)) {
            if (((!StringExtensions.isNullOrEmpty(desc_1.getLocation())) && (res <= p))) {
              MediaFile mf_1 = plf.createMediaFile();
              String _location_2 = desc_1.getLocation();
              mf_1.setPath(_location_2);
              EList<MediaFile> _files_1 = pl.getFiles();
              _files_1.add(mf_1);
            }
          } else {
            if (((!StringExtensions.isNullOrEmpty(desc_1.getLocation())) && (res <= 50))) {
              MediaFile mf_2 = plf.createMediaFile();
              String _location_3 = desc_1.getLocation();
              mf_2.setPath(_location_3);
              EList<MediaFile> _files_2 = pl.getFiles();
              _files_2.add(mf_2);
            }
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          final EList<VideoDescription> l = altvid.getVideodescs();
          final int r = ((Object[])Conversions.unwrapArray(l, Object.class)).length;
          boolean found = false;
          int pr = 0;
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            int _probability = vdesc.getProbability();
            boolean _greaterThan = (_probability > 0);
            if (_greaterThan) {
              int _probability_1 = vdesc.getProbability();
              pr = _probability_1;
            }
          }
          int i = 0;
          if ((pr == 0)) {
            do {
              {
                i = 0;
                EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
                for (final VideoDescription vdesc_1 : _videodescs_1) {
                  String _location_4 = vdesc_1.getLocation();
                  boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_4);
                  boolean _not_1 = (!_isNullOrEmpty_1);
                  if (_not_1) {
                    int _nextInt = rand.nextInt(r);
                    final int p_1 = (_nextInt % r);
                    if (((p_1 == i) && (!found))) {
                      MediaFile mf_3 = plf.createMediaFile();
                      String _location_5 = vdesc_1.getLocation();
                      mf_3.setPath(_location_5);
                      EList<MediaFile> _files_3 = pl.getFiles();
                      _files_3.add(mf_3);
                      found = true;
                    }
                    i++;
                  }
                }
              }
            } while((!found));
          } else {
            do {
              {
                i = 0;
                EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
                for (final VideoDescription vdesc_1 : _videodescs_1) {
                  String _location_4 = vdesc_1.getLocation();
                  boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_4);
                  boolean _not_1 = (!_isNullOrEmpty_1);
                  if (_not_1) {
                    final int p_1 = rand.nextInt(100);
                    if (((p_1 <= pr) && (!found))) {
                      MediaFile mf_3 = plf.createMediaFile();
                      String _location_5 = vdesc_1.getLocation();
                      mf_3.setPath(_location_5);
                      EList<MediaFile> _files_3 = pl.getFiles();
                      _files_3.add(mf_3);
                      found = true;
                    }
                    i++;
                  }
                }
              }
            } while((!found));
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    return pl;
  }
  
  public Playlist videogenToPlaylist(String file) {
	    URI _createURI = URI.createURI(file);
	    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
	    Assert.assertNotNull(videoGen);
	    final PlaylistFactory plf = PlaylistFactoryImpl.init();
	    final Playlist pl = plf.createPlaylist();
	    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
	    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
	      final Random rand = new Random();
	      if ((videoseq instanceof MandatoryVideoSeq)) {
	        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
	        String _location = desc.getLocation();
	        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
	        boolean _not = (!_isNullOrEmpty);
	        if (_not) {
	          MediaFile mf = plf.createMediaFile();
	          String _location_1 = desc.getLocation();
	          mf.setPath(_location_1);
	          EList<MediaFile> _files = pl.getFiles();
	          _files.add(mf);
	        }
	      } else {
	        if ((videoseq instanceof OptionalVideoSeq)) {
	          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
	          final int p = desc_1.getProbability();
	          final int res = rand.nextInt(100);
	          if ((p > 0)) {
	            if (((!StringExtensions.isNullOrEmpty(desc_1.getLocation())) && (res <= p))) {
	              MediaFile mf_1 = plf.createMediaFile();
	              String _location_2 = desc_1.getLocation();
	              mf_1.setPath(_location_2);
	              EList<MediaFile> _files_1 = pl.getFiles();
	              _files_1.add(mf_1);
	            }
	          } else {
	            if (((!StringExtensions.isNullOrEmpty(desc_1.getLocation())) && (res <= 50))) {
	              MediaFile mf_2 = plf.createMediaFile();
	              String _location_3 = desc_1.getLocation();
	              mf_2.setPath(_location_3);
	              EList<MediaFile> _files_2 = pl.getFiles();
	              _files_2.add(mf_2);
	            }
	          }
	        } else {
	          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
	          final EList<VideoDescription> l = altvid.getVideodescs();
	          final int r = ((Object[])Conversions.unwrapArray(l, Object.class)).length;
	          boolean found = false;
	          int pr = 0;
	          EList<VideoDescription> _videodescs = altvid.getVideodescs();
	          for (final VideoDescription vdesc : _videodescs) {
	            int _probability = vdesc.getProbability();
	            boolean _greaterThan = (_probability > 0);
	            if (_greaterThan) {
	              int _probability_1 = vdesc.getProbability();
	              pr = _probability_1;
	            }
	          }
	          int i = 0;
	          if ((pr == 0)) {
	            do {
	              {
	                i = 0;
	                EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
	                for (final VideoDescription vdesc_1 : _videodescs_1) {
	                  String _location_4 = vdesc_1.getLocation();
	                  boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_4);
	                  boolean _not_1 = (!_isNullOrEmpty_1);
	                  if (_not_1) {
	                    int _nextInt = rand.nextInt(r);
	                    final int p_1 = (_nextInt % r);
	                    if (((p_1 == i) && (!found))) {
	                      MediaFile mf_3 = plf.createMediaFile();
	                      String _location_5 = vdesc_1.getLocation();
	                      mf_3.setPath(_location_5);
	                      EList<MediaFile> _files_3 = pl.getFiles();
	                      _files_3.add(mf_3);
	                      found = true;
	                    }
	                    i++;
	                  }
	                }
	              }
	            } while((!found));
	          } else {
	            do {
	              {
	                i = 0;
	                EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
	                for (final VideoDescription vdesc_1 : _videodescs_1) {
	                  String _location_4 = vdesc_1.getLocation();
	                  boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_4);
	                  boolean _not_1 = (!_isNullOrEmpty_1);
	                  if (_not_1) {
	                    final int p_1 = rand.nextInt(100);
	                    if (((p_1 <= pr) && (!found))) {
	                      MediaFile mf_3 = plf.createMediaFile();
	                      String _location_5 = vdesc_1.getLocation();
	                      mf_3.setPath(_location_5);
	                      EList<MediaFile> _files_3 = pl.getFiles();
	                      _files_3.add(mf_3);
	                      found = true;
	                    }
	                    i++;
	                  }
	                }
	              }
	            } while((!found));
	          }
	        }
	      }
	    };
	    _videoseqs.forEach(_function);
	    return pl;
	  }
	  
  public Playlist videogenToPlaylistFull(final String file) {
	    URI _createURI = URI.createURI(file);
	    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
	    Assert.assertNotNull(videoGen);
	    final PlaylistFactory plf = PlaylistFactoryImpl.init();
	    final Playlist pl = plf.createPlaylist();
	    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
	    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
	      final Random rand = new Random();
	      if ((videoseq instanceof MandatoryVideoSeq)) {
	        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
	        String _location = desc.getLocation();
	        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
	        boolean _not = (!_isNullOrEmpty);
	        if (_not) {
	          MediaFile mf = plf.createMediaFile();
	          String _location_1 = desc.getLocation();
	          mf.setPath(_location_1);
	          EList<MediaFile> _files = pl.getFiles();
	          _files.add(mf);
	        }
	      } else {
	        if ((videoseq instanceof OptionalVideoSeq)) {
	          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
	          String _location_2 = desc_1.getLocation();
	          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_2);
	          boolean _not_1 = (!_isNullOrEmpty_1);
	          if (_not_1) {
	            MediaFile mf_1 = plf.createMediaFile();
	            String _location_3 = desc_1.getLocation();
	            mf_1.setPath(_location_3);
	            EList<MediaFile> _files_1 = pl.getFiles();
	            _files_1.add(mf_1);
	          }
	        } else {
	          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
	          final EList<VideoDescription> l = altvid.getVideodescs();
	          EList<VideoDescription> _videodescs = altvid.getVideodescs();
	          for (final VideoDescription vdesc : _videodescs) {
	            String _location_4 = vdesc.getLocation();
	            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_location_4);
	            boolean _not_2 = (!_isNullOrEmpty_2);
	            if (_not_2) {
	              MediaFile mf_2 = plf.createMediaFile();
	              String _location_5 = vdesc.getLocation();
	              mf_2.setPath(_location_5);
	              EList<MediaFile> _files_2 = pl.getFiles();
	              _files_2.add(mf_2);
	            }
	          }
	        }
	      }
	    };
	    _videoseqs.forEach(_function);
	    return pl;
	  }
  
  public void test1() {
    URI _createURI = URI.createURI("foo2bis.videogen");
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
    URI _createURI_3 = URI.createURI("foo2bis.videogen");
    final VideoGeneratorModel videoGen1 = this.loadVideoGenerator(_createURI_3);
    final Playlist playlist = this.testM2M();
    InputOutput.<String>println("M3U");
    this.playlistToM3U(playlist);
    InputOutput.<String>println("\nFFMPEG");
    this.playlistToFFMPEG(playlist);
  }
  
  public void printVideoList(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      final Random rand = new Random();
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location_1 = desc.getLocation();
          String _plus = ("file \'" + _location_1);
          String _plus_1 = (_plus + "\'");
          InputOutput.<String>println(_plus_1);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          final int p = desc_1.getProbability();
          final int res = rand.nextInt(100);
          if ((p > 0)) {
            if (((!StringExtensions.isNullOrEmpty(desc_1.getLocation())) && (res <= p))) {
              String _location_2 = desc_1.getLocation();
              String _plus_2 = ("file \'" + _location_2);
              String _plus_3 = (_plus_2 + "\'");
              InputOutput.<String>println(_plus_3);
            }
          } else {
            if (((!StringExtensions.isNullOrEmpty(desc_1.getLocation())) && (res <= 50))) {
              String _location_3 = desc_1.getLocation();
              String _plus_4 = ("file \'" + _location_3);
              String _plus_5 = (_plus_4 + "\'");
              InputOutput.<String>println(_plus_5);
            }
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          final EList<VideoDescription> l = altvid.getVideodescs();
          final int r = ((Object[])Conversions.unwrapArray(l, Object.class)).length;
          boolean found = false;
          int pr = 0;
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            int _probability = vdesc.getProbability();
            boolean _greaterThan = (_probability > 0);
            if (_greaterThan) {
              int _probability_1 = vdesc.getProbability();
              pr = _probability_1;
            }
          }
          int i = 0;
          if ((pr == 0)) {
            do {
              {
                i = 0;
                EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
                for (final VideoDescription vdesc_1 : _videodescs_1) {
                  String _location_4 = vdesc_1.getLocation();
                  boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_4);
                  boolean _not_1 = (!_isNullOrEmpty_1);
                  if (_not_1) {
                    int _nextInt = rand.nextInt(r);
                    final int p_1 = (_nextInt % r);
                    if (((p_1 == i) && (!found))) {
                      String _location_5 = vdesc_1.getLocation();
                      String _plus_6 = ("file \'" + _location_5);
                      String _plus_7 = (_plus_6 + "\'");
                      InputOutput.<String>println(_plus_7);
                      found = true;
                    }
                    i++;
                  }
                }
              }
            } while((!found));
          } else {
            do {
              {
                i = 0;
                EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
                for (final VideoDescription vdesc_1 : _videodescs_1) {
                  String _location_4 = vdesc_1.getLocation();
                  boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_4);
                  boolean _not_1 = (!_isNullOrEmpty_1);
                  if (_not_1) {
                    final int p_1 = rand.nextInt(100);
                    if (((p_1 <= pr) && (!found))) {
                      String _location_5 = vdesc_1.getLocation();
                      String _plus_6 = ("file \'" + _location_5);
                      String _plus_7 = (_plus_6 + "\'");
                      InputOutput.<String>println(_plus_7);
                      found = true;
                    }
                    i++;
                  }
                }
              }
            } while((!found));
          }
        }
      }
    };
    _videoseqs.forEach(_function);
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
   
  public String genID() {
    int _plusPlus = playlistTools.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}

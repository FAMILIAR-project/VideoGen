package videogen.vignette;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogen.VideoDemonstrator;
import videogen.vignette.FFMPEGHelper;

@SuppressWarnings("all")
public class VignetteGenerator {
  private VideoDemonstrator vd = new VideoDemonstrator();
  
  @Test
  public void generateVignettes() {
    try {
      final FFMPEGHelper ffmpeg = new FFMPEGHelper();
      URI _createURI = URI.createURI("test-vignette.videogen");
      VideoGeneratorModel videoGen = this.vd.loadVideoGenerator(_createURI);
      Assert.assertNotNull(videoGen);
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      int _size = _videoseqs.size();
      Assert.assertEquals(3, _size);
      final ArrayList<String> ids = new ArrayList<String>();
      final ArrayList<String> locations = new ArrayList<String>();
      EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          final String path = desc.getLocation();
          String _videoid = desc.getVideoid();
          ffmpeg.generateThumbnail(path, _videoid);
          String _videoid_1 = desc.getVideoid();
          ids.add(_videoid_1);
          locations.add(path);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String path_1 = desc_1.getLocation();
            String _videoid_2 = desc_1.getVideoid();
            ffmpeg.generateThumbnail(path_1, _videoid_2);
            String _videoid_3 = desc_1.getVideoid();
            ids.add(_videoid_3);
            locations.add(path_1);
            if (((desc_1.getProbability() > 100) || (desc_1.getProbability() < 0))) {
              String _videoid_4 = desc_1.getVideoid();
              String _plus = ("Video with id " + _videoid_4);
              String _plus_1 = (_plus + " has a bad probability");
              InputOutput.<String>println(_plus_1);
            }
          } else {
            final AlternativeVideoSeq videoseqAlt = ((AlternativeVideoSeq) videoseq);
            int probability = 0;
            EList<VideoDescription> _videodescs = videoseqAlt.getVideodescs();
            for (final VideoDescription video : _videodescs) {
              {
                String _location = video.getLocation();
                String _videoid_5 = video.getVideoid();
                ffmpeg.generateThumbnail(_location, _videoid_5);
                String _videoid_6 = video.getVideoid();
                ids.add(_videoid_6);
                String _location_1 = video.getLocation();
                locations.add(_location_1);
                int _probability = probability;
                int _probability_1 = video.getProbability();
                probability = (_probability + _probability_1);
              }
            }
            if (((probability < 0) || (probability > 100))) {
              InputOutput.<String>println("An alternative has a bad probability");
            }
          }
        }
      };
      _videoseqs_1.forEach(_function);
      HashSet<String> idsWithoutDuplicates = new HashSet<String>(ids);
      HashSet<String> locationsWithoutDuplicates = new HashSet<String>(locations);
      int _size_1 = idsWithoutDuplicates.size();
      int _size_2 = ids.size();
      boolean _notEquals = (_size_1 != _size_2);
      if (_notEquals) {
        InputOutput.<String>println("Some videos have the same identifier");
      }
      int _size_3 = locationsWithoutDuplicates.size();
      int _size_4 = locations.size();
      boolean _notEquals_1 = (_size_3 != _size_4);
      if (_notEquals_1) {
        InputOutput.<String>println("Some videos have the same path (same name)");
      }
      File html = new File("vignettes.html");
      PrintWriter writer = new PrintWriter("vignettes.html");
      writer.write(
        "<html><body>");
      for (int i = 0; (i < videoGen.getVideoseqs().size()); i++) {
        {
          EList<VideoSeq> _videoseqs_2 = videoGen.getVideoseqs();
          VideoSeq videoseq = _videoseqs_2.get(i);
          if ((videoseq instanceof MandatoryVideoSeq)) {
            final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
            final String name = desc.getVideoid();
            writer.write(
              ((((((("<div>\n\t\t\t\t\t\t<img src=./" + name) + 
                ".png width=140 height=80 style=") + 
                "\"") + "margin:10px") + "\"") + ">") + 
                "</div>"));
          } else {
            if ((videoseq instanceof OptionalVideoSeq)) {
              final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
              final String name_1 = desc_1.getVideoid();
              writer.write(
                ((((((("<div>\n\t\t\t\t\t\t<img src=./" + name_1) + 
                  ".png width=140 height=80 style=") + 
                  "\"") + "margin:10px") + "\"") + ">") + 
                  "</div>"));
            } else {
              final AlternativeVideoSeq videoseqAlt = ((AlternativeVideoSeq) videoseq);
              writer.write("<div><span>");
              EList<VideoDescription> _videodescs = videoseqAlt.getVideodescs();
              for (final VideoDescription video : _videodescs) {
                {
                  final String name_2 = video.getVideoid();
                  writer.write(
                    (((((("<img src=./" + name_2) + 
                      ".png width=140 height=80 style=") + 
                      "\"") + "margin:10px") + "\"") + ">"));
                }
              }
              writer.write(
                "</span></div>");
            }
          }
        }
      }
      writer.write("</body></html>");
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

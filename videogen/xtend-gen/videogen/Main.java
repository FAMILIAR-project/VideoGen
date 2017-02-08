package videogen;

import org.eclipse.emf.common.util.URI;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import videogen.transformationsVideo;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    final transformationsVideo vv = new transformationsVideo();
    vv.transform();
    URI _createURI = URI.createURI("foo1.videogen");
    VideoGeneratorModel videoGen = vv.loadVideoGenerator(_createURI);
    vv.verify();
    vv.printToHTMLWithRandom(videoGen);
    vv.createVideoGen();
    vv.filters(videoGen);
    vv.createFeatureModel();
  }
}

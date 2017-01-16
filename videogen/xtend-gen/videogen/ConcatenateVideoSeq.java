package videogen;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import videogen.VideoDemonstrator;

@SuppressWarnings("all")
public class ConcatenateVideoSeq {
  private VideoDemonstrator vd = new VideoDemonstrator();
  
  public Resource saveFile(final URI uri) {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    Resource rs = _resourceSetImpl.createResource(uri);
    return rs;
  }
  
  public Object random() {
    return null;
  }
  
  @Test
  public void generateAllAlternatives() {
    throw new Error("Unresolved compilation problems:"
      + "\nMandatoryVideoSeq cannot be resolved to a type."
      + "\nMandatoryVideoSeq cannot be resolved to a type."
      + "\nOptionalVideoSeq cannot be resolved to a type."
      + "\nOptionalVideoSeq cannot be resolved to a type."
      + "\nOptionalVideoSeq cannot be resolved to a type."
      + "\nOptionalVideoSeq cannot be resolved to a type."
      + "\nAlternativeVideoSeq cannot be resolved to a type."
      + "\nThe method loadVideoGenerator(URI) from the type VideoDemonstrator refers to the missing type VideoGeneratorModel"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nUnreachable code: The if condition can never match. It is already handled by a previous condition."
      + "\nvideoseqs cannot be resolved"
      + "\nsize cannot be resolved"
      + "\nvideoseqs cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nprobability cannot be resolved"
      + "\n== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nprobability cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nvideodescs cannot be resolved"
      + "\nsize cannot be resolved"
      + "\nvideodescs cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlocation cannot be resolved");
  }
}

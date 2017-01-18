package videogen;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGenPackage;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import playlist.Playlist;
import playlist.PlaylistFactory;
import playlist.impl.PlaylistFactoryImpl;

@SuppressWarnings("all")
public class SiteWeb {
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
	public void genHTML() {
		try {
			URI _createURI = URI.createURI("q10.videogen");
			VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
			EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
			final PrintWriter file = new PrintWriter("index.html", "UTF-8");
			file.println("<html>");
			final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
				try {
					String path = "";
					String name = "";
					List<VideoDescription> _videodescs = new ArrayList<>() ;
					if ((videoseq instanceof MandatoryVideoSeq)) {
						file.println("<h1>mandatory</h1>");
						file.println("<br>");
						VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
						String _location = _description.getLocation();
						path = _location;
						String _videoid = _description.getVideoid();
						name = _videoid;
						_videodescs.add(_description);
						writeHtmlForImage(file, name);
					} else {
						if ((videoseq instanceof OptionalVideoSeq)) {
							file.println("<h1>optional</h1>");
							file.println("<br>");
							VideoDescription _description = ((OptionalVideoSeq) videoseq).getDescription();
							String _location_1 = _description.getLocation();
							path = _location_1;
							String _videoid_1 = _description.getVideoid();
							name = _videoid_1;
							_videodescs.add(_description);
							writeHtmlForImage(file, name);
						} else {
							if ((videoseq instanceof AlternativeVideoSeq)) {
								file.println("<h1>alternative</h1>");
								file.println("<br>");
								_videodescs = ((AlternativeVideoSeq) videoseq).getVideodescs();
								
							}
						}
					}
					
					for (final VideoDescription vdesc : _videodescs) {
						{
							String _location = vdesc.getLocation();
							path = _location;
							String _videoid = vdesc.getVideoid();
							name = _videoid;
							writeHtmlForImage(file, name);
							InputOutput.<String>println(("path=" + path));
							InputOutput.<String>println(("name=" + name));
							String cmd = (((("ffmpeg -i " + path) + " -ss 00:00:01.000 -vframes 1 ") + name) + ".jpg -y");
							InputOutput.<String>println(cmd);
							Runtime _runtime = Runtime.getRuntime();
							Process process = _runtime.exec(cmd);
							process.waitFor();
						}
					}
					
				} catch (Throwable _e) {
					throw Exceptions.sneakyThrow(_e);
				}
			};
			_videoseqs.forEach(_function);
			file.println("</html>");
			file.close();
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}
	
	public void writeHtmlForImage(PrintWriter file, String name){
		file.println("<img src=\'"+name+".jpg'>");
		file.println("<br>");
	}
}

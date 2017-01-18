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
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import playlist.Playlist;
import playlist.PlaylistFactory;
import playlist.impl.PlaylistFactoryImpl;

@SuppressWarnings("all")
public class Vignette {
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
	public void genVignette() {
		try {
			URI _createURI = URI.createURI("q9.videogen");
			VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
			EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
			final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
				try {
					String path = "";
					String name = "";
					List<VideoDescription> _videodescs = new ArrayList<>() ;
					if ((videoseq instanceof MandatoryVideoSeq)) {
						VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
						String _location = _description.getLocation();
						path = _location;
						String _videoid = _description.getVideoid();
						name = _videoid;
						_videodescs.add(_description);
					} else {
						if ((videoseq instanceof OptionalVideoSeq)) {
							VideoDescription _description = ((OptionalVideoSeq) videoseq).getDescription();
							String _location_1 = _description.getLocation();
							path = _location_1;
							String _videoid_1 = _description.getVideoid();
							name = _videoid_1;
							_videodescs.add(_description);
						} else {
							if ((videoseq instanceof AlternativeVideoSeq)) {
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

		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}
}

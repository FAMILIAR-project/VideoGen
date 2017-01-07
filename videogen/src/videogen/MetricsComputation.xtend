package videogen

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.VideoSeq

class MetricsComputation {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def metricsComputation(URI in){
		var videogen = loadVideoGenerator(in)
		var nb = variationNumber(videogen)
		print("Nombre de variations : "+nb)
	}
	
	def int variationNumber(VideoGeneratorModel videogen){
		var out = 1
		for (vid:videogen.videoseqs){
			if (vid instanceof OptionalVideoSeq){
				out *= 2
			}
			if (vid instanceof AlternativeVideoSeq){
				out *= vid.videodescs.size
			}
		}
		return out
	}
	def static void main(String[] args) {
		val mc = new MetricsComputation
		val fin = URI.createURI("foo2.videogen")
		//val m3uext = "foo2.m3u"
		mc.metricsComputation(fin)
	}
}
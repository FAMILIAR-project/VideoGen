package videogen

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq

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
		durationStatistic(videogen)
		sizeStatistic(videogen)
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
	
	def durationStatistic(VideoGeneratorModel videogen){
		//Hypothèse : on considère la moyenne pondérée par les probabilités
		var min=0
		var max=0
		var moy=0
		for (vid:videogen.videoseqs){
			if (vid instanceof MandatoryVideoSeq){
				max+=vid.description.duration
				moy+=vid.description.duration
				min+=vid.description.duration
			}
			if (vid instanceof OptionalVideoSeq){
				max+=vid.description.duration
				if (vid.description.probability==0){
					moy+=(vid.description.duration)/2
				}else{
					moy+=(vid.description.duration)*vid.description.probability/100
				}
			}
			if (vid instanceof AlternativeVideoSeq){
				var tmpmax=0
				var tmpmin=1000000
				var tmpmoy=0
				for (vids:vid.videodescs){
					tmpmoy+=vids.duration*vids.probability
					if (vids.duration>tmpmax){
						tmpmax = vids.duration
					}
					if (vids.duration<tmpmin){
						tmpmin = vids.duration
					}
				}
				moy+=tmpmoy/100
				max+=tmpmax
				min+=tmpmin
			}
		}
		print("Durée maximum : "+max)
		print("Durée minimum : "+min)
		print("Durée moyenne : "+moy)
	}
	
	def sizeStatistic(VideoGeneratorModel videogen){
		
	}
	
	def static void main(String[] args) {
		val mc = new MetricsComputation
		val fin = URI.createURI("foo2.videogen")
		//val m3uext = "foo2.m3u"
		mc.metricsComputation(fin)
	}
}
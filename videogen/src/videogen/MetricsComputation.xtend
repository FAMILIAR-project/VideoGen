package videogen

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.File
import java.util.ArrayList
import java.io.FileWriter

class MetricsComputation {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def metricsComputation(URI in,FileWriter out){
		var videogen = loadVideoGenerator(in)
		var nb = variationNumber(videogen)
		println("Nombre de variations : "+nb)
		durationStatistic(videogen)
		sizeStatistic(videogen)
		var listVariation = getVariations(videogen)
		printToCSV(listVariation,out)
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
				var duree = getDuree(vid.description)
				max+=duree
				moy+=duree
				min+=duree
			}
			if (vid instanceof OptionalVideoSeq){
				var duree = getDuree(vid.description)
				max+=duree
				if (vid.description.probability==0){
					moy+=duree/2
				}else{
					moy+=duree*vid.description.probability/100
				}
			}
			if (vid instanceof AlternativeVideoSeq){
				var tmpmax=0
				var tmpmin=1000000
				var tmpmoy=0
				for (vids:vid.videodescs){
					var duree = getDuree(vids)
					tmpmoy+=duree*vids.probability
					if (duree>tmpmax){
						tmpmax = duree
					}
					if (duree<tmpmin){
						tmpmin = duree
					}
				}
				moy+=tmpmoy/100
				max+=tmpmax
				min+=tmpmin
			}
		}
		println("Durée maximum : "+max)
		println("Durée minimum : "+min)
		println("Durée moyenne : "+moy)
	}
	
	def sizeStatistic(VideoGeneratorModel videogen){
		//Hypothèse : on considère la moyenne pondérée par les probabilités
		var min=0L
		var max=0L
		var moy=0L
		for (vid:videogen.videoseqs){
			if (vid instanceof MandatoryVideoSeq){
				var size = getTaille(vid.description)
				max+=size
				moy+=size
				min+=size
			}
			if (vid instanceof OptionalVideoSeq){
				var size = getTaille(vid.description)
				max+=size
				if (vid.description.probability==0){
					moy+=size/2
				}else{
					moy+=size*vid.description.probability/100
				}
			}
			if (vid instanceof AlternativeVideoSeq){
				var tmpmax=0L
				var tmpmin=1000000000000L
				var tmpmoy=0L
				for (vids:vid.videodescs){
					var size = getTaille(vids)
					tmpmoy+=size*vids.probability
					if (size>tmpmax){
						tmpmax = size
					}
					if (size<tmpmin){
						tmpmin = size
					}
				}
				moy+=tmpmoy/100
				max+=tmpmax
				min+=tmpmin
			}
		}
		println("Taille maximum : "+max+"o")
		println("Taille minimum : "+min+"o")
		println("Taille moyenne : "+moy+"o")
	}
	
	def getVariations(VideoGeneratorModel videogen){
		var listVariation = new ArrayList<ArrayList<VideoDescription>>
		listVariation.add(new ArrayList<VideoDescription>())
		for (vid:videogen.videoseqs){
			if (vid instanceof MandatoryVideoSeq){
				for (list:listVariation){
					list.add(vid.description)
				}
			}
			if (vid instanceof OptionalVideoSeq){
				var listminus1 = listVariation.clone as ArrayList<ArrayList<VideoDescription>>
				var listTmp = new ArrayList<ArrayList<VideoDescription>>
				for (list:listminus1){
					var tmp = list.clone as ArrayList<VideoDescription>
					listTmp.add(list)
					tmp.add(vid.description)
					listTmp.add(tmp)
				}
				listVariation = listTmp
			}
			if (vid instanceof AlternativeVideoSeq){
				var listminus1 = listVariation.clone as ArrayList<ArrayList<VideoDescription>>
				var listTmp = new ArrayList<ArrayList<VideoDescription>>
				for (vids:vid.videodescs){
					for (list:listminus1){
						var tmp = list.clone as ArrayList<VideoDescription>
						tmp.add(vids)
						listTmp.add(tmp)
					}
				}
				listVariation = listTmp
			}
		}
		return listVariation	
	}
	
	def static int getDuree(VideoDescription desc){
		var duree = 0
		if (desc.duration!=0){
			duree = desc.duration
		}else{
			var cmd = "/usr/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + desc.location
			var Process process = Runtime.getRuntime().exec(cmd)
			process.waitFor()
			var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			var String line = "";
			var String outputJson = "";
	    	while ((line = reader.readLine()) != null) {
	        	outputJson = outputJson + line;
	    	}
	    	if (process.exitValue()==1){
	    		println(desc.location)
	    	}
	    	duree = Math.round(Float.parseFloat(outputJson))-1;
		}
		return duree
	}
	
	def static long getTaille(VideoDescription desc){
		var taille = new File(desc.location).length
		return taille
	}
	
	def static void printToCSV(ArrayList<ArrayList<VideoDescription>> listList,FileWriter fout){
		var loop=0
		fout.write("Séquence vidéo,Taille,Duree\n")
		for (list:listList){
			loop+=1
			if (loop>10){
				fout.close
				return
			}else{
				var taille=0L
				var duree=0
				fout.write("[")
				for (desc:list){
					fout.write(desc.videoid.toString+" ")
					taille+=getTaille(desc)
					duree+=getDuree(desc)
				}
				fout.write("],"+taille.toString+","+duree.toString+"\n")
			}
		}
		fout.close
	}
	
	def static void main(String[] args) {
		val mc = new MetricsComputation
		val fin = URI.createURI("persoduration.videogen")
		val fout = new FileWriter("persostatistics.csv")
		mc.metricsComputation(fin,fout)
	}
}
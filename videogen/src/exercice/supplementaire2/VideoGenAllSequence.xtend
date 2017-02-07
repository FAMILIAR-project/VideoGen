package exercice.supplementaire2

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq 
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.util.ArrayList
import java.util.List
import java.io.PrintWriter

class VideoGenAllSequence { 
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	@Test
	def void generateAllSequences() {
		var videoGen = loadVideoGenerator(URI.createURI("foo2bis2.videogen")) 
		val res = generateSeqs(videoGen)
		Calcule.generateDuration(res)
		println("nombre de variantes : " + res.length)
		println("taille min de variantes : " + Calcule.minSequence(res))
		println("taille max de variantes : " + Calcule.maxSequence(res))
		println("taille moyenne de variantes : " + Calcule.moySequence(res))
		 val writer = new PrintWriter("sequences.csv", "UTF-8");
		 res.forEach[ sq|
		 	writer.print(sq.id)
		 	writer.print(",")
		 	sq.variantes.forEach[ss |
		 		writer.print(ss)
		 		writer.print(",")
		 	]
		 	writer.print(sq.duree)
		 	writer.print(",")
		 	writer.println()
		 ]
		 writer.close
	}
	
	def extractTailleMin(ArrayList<SequenceVideo> videos) {
		val res = 100
		videos.forEach[sv |
			Math.min(sv.variantes.size, res)
		]
	}
	
	def generateSeqs(VideoGeneratorModel videoGen) {
		val parent = new Node();
		
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  {
					var nodeFis = new ArrayList()
					nodeFis.add(new Node())
					nodeFis.get(0).name = desc.location
					addFisToParent(parent, nodeFis)
				}			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) {
					var nodeFis = new ArrayList()
					nodeFis.add(new Node())
					nodeFis.get(0).name = desc.location
					nodeFis.add(new Node())
					nodeFis.get(1).name = "_neutre_"
					addFisToParent(parent, nodeFis)
				}
			}
			else if (videoseq instanceof AlternativeVideoSeq) {
				val altvid = (videoseq as AlternativeVideoSeq)
				val nodeFis = new ArrayList()
				for (vdesc : altvid.videodescs) {
					if(!vdesc.location.isNullOrEmpty) {
						var subnode = new Node()
						nodeFis.add(subnode)
						subnode.name = vdesc.location
					}
				}
				addFisToParent(parent, nodeFis)
			}
		]
		val seqs = new ArrayList<SequenceVideo>()
		updateParent(parent)
		checkParents(parent)
		extractListSeqs(parent, seqs)
		seqs
	}
	
	static var i = 0;
	
	def extractListSeqs(Node node, ArrayList<SequenceVideo> seqs) {
		if (node.listSub.length>0) {
			for(Node subnode : node.listSub) {
				extractListSeqs(subnode, seqs)
			}
		}	
		else {
			var seq = new SequenceVideo()
			seq.id = i++;
			var seqVar = new ArrayList<String>()
			extractVariantes(node, seqVar)
			seq.variantes = seqVar
			seqs.add(seq)
		}	
	}
	
	def checkParents(Node node) {
		node.listSub.forEach[subnode | 
			checkParents(subnode)
		]
	}
	
	def extractVariantes(Node node, List<String> seqVar) {
		if (node.name != null && node.name != "_neutre_") {
			seqVar.add(node.name)
		}
		if (node.parentNode != null) {
			extractVariantes(node.parentNode, seqVar)
		}
	}
	
	def addFisToParent(Node parent, ArrayList<Node> nodes) {
		if (nodes.contains(parent)) return;
		if (parent.listSub.length>0) {
			val arr = parent.listSub
			arr.forEach[nid | 
				if (!nodes.contains(nid)) {
					addFisToParent(nid, nodes)
				}
			]
		}
		else {
			parent.listSub.addAll(copyArray(nodes))
		}
	}
	
	def copyArray(ArrayList<Node> nodes) {
		val res = new ArrayList()
		nodes.forEach[nod |
			val nn = new Node()
			nn.listSub = nod.listSub
			nn.name =  nod.name
			res.add(nn)
		]
		return res
	}
	
	def void updateParent(Node nod) {
		for (Node sub : nod.listSub) {
			sub.parentNode = nod
			updateParent(sub)
		}
	}
	
}
				
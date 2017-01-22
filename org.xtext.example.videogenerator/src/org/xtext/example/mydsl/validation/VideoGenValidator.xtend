/*
 * generated by Xtext
 */
package org.xtext.example.mydsl.validation

import org.eclipse.xtext.validation.Check
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGenPackage
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class VideoGenValidator extends AbstractVideoGenValidator {

//  public static val INVALID_NAME = 'invalidName'
//
//	@Check
//	def checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
//			warning('Name should start with a capital', 
//					MyDslPackage.Literals.GREETING__NAME,
//					INVALID_NAME)
//		}
//	}
	@Check
	def void checkVideoIdentifierIsUnique(VideoDescription desc) {
		if(desc.videoid == null || desc.videoid.isEmpty) return;
		var seq = desc.eContainer // video sequence
		println("checking " + desc.videoid + " with parent: " + seq)
		var gen = if (seq instanceof MandatoryVideoSeq) {
				(seq as MandatoryVideoSeq).eContainer as VideoGeneratorModel
			} else if (seq instanceof OptionalVideoSeq) {
				(seq as OptionalVideoSeq).eContainer as VideoGeneratorModel
			} else {
				(seq as AlternativeVideoSeq).eContainer as VideoGeneratorModel
			}

		for (seq2 : gen.videoseqs) {

			// if (seq != seq2) {
			if (seq2 instanceof MandatoryVideoSeq) {
				var desc2 = (seq2 as MandatoryVideoSeq).getDescription()
				if (desc2 != null && desc != desc2)
					if (desc.videoid.equals(desc2.videoid)) {
						error(
							"Video sequence identifiers have to be unique (" + desc2.videoid + " is not)",
							VideoGenPackage.Literals::VIDEO_DESCRIPTION__VIDEOID
						);
						return;
					}
			} else if (seq2 instanceof OptionalVideoSeq) {
				var desc2 = (seq2 as OptionalVideoSeq).getDescription()
				if (desc2 != null && desc != desc2)
					if (desc.videoid.equals(desc2.videoid)) {
						error(
							"Video sequence identifiers have to be unique (" + desc2.videoid + " is not)",
							VideoGenPackage.Literals::VIDEO_DESCRIPTION__VIDEOID
						);
						return;
					}
			} else {
				var vid2 = (seq2 as AlternativeVideoSeq).videoid

				if (seq != seq2 && desc.videoid.equals(vid2)) {
					error(
						"Video sequence identifiers have to be unique (" + vid2 + " is not)",
						VideoGenPackage.Literals::VIDEO_DESCRIPTION__VIDEOID
					);
					return;
				}

				for (adesc : (seq2 as AlternativeVideoSeq).videodescs) {
					if (adesc != null && adesc != desc)
						if (desc.videoid.equals(adesc.videoid)) {
							error(
								"Video sequence identifiers have to be unique (" + adesc.videoid + " is not)",
								VideoGenPackage.Literals::VIDEO_DESCRIPTION__VIDEOID
							);
							return;
						}
				}
			}

		// }
		}

	}

	@Check
	def void checkVideoIdentifierIsUniqueForAlternative(AlternativeVideoSeq seq) {
		println("checking alternative " + seq.videoid)
		if(seq.videoid == null) return;
		for (avid : seq.videodescs) {
			if (seq.videoid.equals(avid.videoid)) {
				error(
					"Video sequence identifiers have to be unique (" + seq.videoid + " is not)",
					VideoGenPackage.Literals::ALTERNATIVE_VIDEO_SEQ__VIDEOID
				);
				return;
			}
		}

	}

	@Check
	def void checkValidProbability(VideoDescription desc) {
		if (desc.probability > 100)
			error("Probality should be < 100", VideoGenPackage.Literals::VIDEO_DESCRIPTION__PROBABILITY)
	}

	@Check
	def void checkAlternativesProbability(VideoDescription desc) {
		var sum = 0
		var seq = desc.eContainer // video sequence
		if (seq instanceof AlternativeVideoSeq) {
			var gen = (seq as AlternativeVideoSeq).eContainer as VideoGeneratorModel
			for (vdesc : seq.videodescs) {
				sum += vdesc.probability
			}
			if (sum > 100) {
				error(
					"Alternatives probability sum > 100",
					VideoGenPackage.Literals::VIDEO_DESCRIPTION__PROBABILITY
				);
				return;
			}

		}
	}

	@Check
	def void checkUniqueVideoPath(VideoDescription desc) {
		var seq = desc.eContainer // video sequence
		var gen = if (seq instanceof MandatoryVideoSeq) {
				(seq as MandatoryVideoSeq).eContainer as VideoGeneratorModel
			} else if (seq instanceof OptionalVideoSeq) {
				(seq as OptionalVideoSeq).eContainer as VideoGeneratorModel
			} else {
				(seq as AlternativeVideoSeq).eContainer as VideoGeneratorModel
			}

		for (seq2 : gen.videoseqs) {
			if (seq2 instanceof MandatoryVideoSeq) {
				var desc2 = (seq2 as MandatoryVideoSeq).getDescription()
				if (desc2 != null && desc != desc2)
					if (desc.location.equals(desc2.location)) {
						error(
							"Video path already exists",
							VideoGenPackage.Literals::VIDEO_DESCRIPTION__LOCATION
						);
						return;
					}
			} else if (seq2 instanceof OptionalVideoSeq) {
				var desc2 = (seq2 as OptionalVideoSeq).getDescription()
				if (desc2 != null && desc != desc2)
					if (desc.location.equals(desc2.location)) {
						error(
							"Video path already exists",
							VideoGenPackage.Literals::VIDEO_DESCRIPTION__LOCATION
						);
						return;
					}
			} else {
				var vid2 = (seq2 as AlternativeVideoSeq).videoid
				for (adesc : (seq2 as AlternativeVideoSeq).videodescs) {
					if (adesc != null && adesc != desc)
						if (desc.location.equals(adesc.location)) {
							error(
								"Video path already exists",
								VideoGenPackage.Literals::VIDEO_DESCRIPTION__LOCATION
							);
							return;
						}
				}
			}
			
			
		}
	}

}

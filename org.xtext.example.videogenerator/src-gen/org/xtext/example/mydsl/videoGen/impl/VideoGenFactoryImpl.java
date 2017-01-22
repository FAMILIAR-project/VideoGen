/**
 */
package org.xtext.example.mydsl.videoGen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.example.mydsl.videoGen.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VideoGenFactoryImpl extends EFactoryImpl implements VideoGenFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static VideoGenFactory init()
  {
		try {
			VideoGenFactory theVideoGenFactory = (VideoGenFactory)EPackage.Registry.INSTANCE.getEFactory(VideoGenPackage.eNS_URI);
			if (theVideoGenFactory != null) {
				return theVideoGenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VideoGenFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VideoGenFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
<<<<<<< HEAD
		switch (eClass.getClassifierID()) {
			case VideoGenPackage.VIDEO_GENERATOR_MODEL: return createVideoGeneratorModel();
			case VideoGenPackage.VIDEO_GEN_INFORMATION: return createVideoGenInformation();
			case VideoGenPackage.VIDEO_SEQ: return createVideoSeq();
			case VideoGenPackage.MANDATORY_VIDEO_SEQ: return createMandatoryVideoSeq();
			case VideoGenPackage.OPTIONAL_VIDEO_SEQ: return createOptionalVideoSeq();
			case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ: return createAlternativeVideoSeq();
			case VideoGenPackage.VIDEO_DESCRIPTION: return createVideoDescription();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}
=======
    switch (eClass.getClassifierID())
    {
      case VideoGenPackage.VIDEO_GENERATOR_MODEL: return createVideoGeneratorModel();
      case VideoGenPackage.VIDEO_GEN_INFORMATION: return createVideoGenInformation();
      case VideoGenPackage.VIDEO_SEQ: return createVideoSeq();
      case VideoGenPackage.MANDATORY_VIDEO_SEQ: return createMandatoryVideoSeq();
      case VideoGenPackage.OPTIONAL_VIDEO_SEQ: return createOptionalVideoSeq();
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ: return createAlternativeVideoSeq();
      case VideoGenPackage.VIDEO_DESCRIPTION: return createVideoDescription();
      case VideoGenPackage.SUBTITLE: return createSubtitle();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }
>>>>>>> a150e5426d31f2a499effc322af3d84e64af383f

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VideoGeneratorModel createVideoGeneratorModel()
  {
		VideoGeneratorModelImpl videoGeneratorModel = new VideoGeneratorModelImpl();
		return videoGeneratorModel;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VideoGenInformation createVideoGenInformation()
  {
		VideoGenInformationImpl videoGenInformation = new VideoGenInformationImpl();
		return videoGenInformation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VideoSeq createVideoSeq()
  {
		VideoSeqImpl videoSeq = new VideoSeqImpl();
		return videoSeq;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MandatoryVideoSeq createMandatoryVideoSeq()
  {
		MandatoryVideoSeqImpl mandatoryVideoSeq = new MandatoryVideoSeqImpl();
		return mandatoryVideoSeq;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OptionalVideoSeq createOptionalVideoSeq()
  {
		OptionalVideoSeqImpl optionalVideoSeq = new OptionalVideoSeqImpl();
		return optionalVideoSeq;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AlternativeVideoSeq createAlternativeVideoSeq()
  {
		AlternativeVideoSeqImpl alternativeVideoSeq = new AlternativeVideoSeqImpl();
		return alternativeVideoSeq;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VideoDescription createVideoDescription()
  {
		VideoDescriptionImpl videoDescription = new VideoDescriptionImpl();
		return videoDescription;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
<<<<<<< HEAD
	 * @generated
	 */
=======
   * @generated
   */
  public Subtitle createSubtitle()
  {
    SubtitleImpl subtitle = new SubtitleImpl();
    return subtitle;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
>>>>>>> a150e5426d31f2a499effc322af3d84e64af383f
  public VideoGenPackage getVideoGenPackage()
  {
		return (VideoGenPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static VideoGenPackage getPackage()
  {
		return VideoGenPackage.eINSTANCE;
	}

} //VideoGenFactoryImpl

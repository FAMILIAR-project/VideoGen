/**
 */
package org.xtext.example.mydsl.videoGen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.videoGen.VideoGenFactory
 * @model kind="package"
 * @generated
 */
public interface VideoGenPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "videoGen";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.xtext.org/example/mydsl/VideoGen";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "videoGen";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  VideoGenPackage eINSTANCE = org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoGeneratorModelImpl <em>Video Generator Model</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGeneratorModelImpl
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoGeneratorModel()
	 * @generated
	 */
  int VIDEO_GENERATOR_MODEL = 0;

  /**
	 * The feature id for the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_GENERATOR_MODEL__INFORMATION = 0;

  /**
	 * The feature id for the '<em><b>Videoseqs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_GENERATOR_MODEL__VIDEOSEQS = 1;

  /**
	 * The number of structural features of the '<em>Video Generator Model</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_GENERATOR_MODEL_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoGenInformationImpl <em>Information</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenInformationImpl
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoGenInformation()
	 * @generated
	 */
  int VIDEO_GEN_INFORMATION = 1;

  /**
	 * The feature id for the '<em><b>Author Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_GEN_INFORMATION__AUTHOR_NAME = 0;

  /**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_GEN_INFORMATION__VERSION = 1;

  /**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_GEN_INFORMATION__CREATION_DATE = 2;

  /**
	 * The number of structural features of the '<em>Information</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_GEN_INFORMATION_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoSeqImpl <em>Video Seq</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoSeqImpl
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoSeq()
	 * @generated
	 */
  int VIDEO_SEQ = 2;

  /**
	 * The number of structural features of the '<em>Video Seq</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_SEQ_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.MandatoryVideoSeqImpl <em>Mandatory Video Seq</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.xtext.example.mydsl.videoGen.impl.MandatoryVideoSeqImpl
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getMandatoryVideoSeq()
	 * @generated
	 */
  int MANDATORY_VIDEO_SEQ = 3;

  /**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MANDATORY_VIDEO_SEQ__DESCRIPTION = VIDEO_SEQ_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Mandatory Video Seq</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MANDATORY_VIDEO_SEQ_FEATURE_COUNT = VIDEO_SEQ_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.OptionalVideoSeqImpl <em>Optional Video Seq</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.xtext.example.mydsl.videoGen.impl.OptionalVideoSeqImpl
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getOptionalVideoSeq()
	 * @generated
	 */
  int OPTIONAL_VIDEO_SEQ = 4;

  /**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPTIONAL_VIDEO_SEQ__DESCRIPTION = VIDEO_SEQ_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Optional Video Seq</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPTIONAL_VIDEO_SEQ_FEATURE_COUNT = VIDEO_SEQ_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.AlternativeVideoSeqImpl <em>Alternative Video Seq</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.xtext.example.mydsl.videoGen.impl.AlternativeVideoSeqImpl
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getAlternativeVideoSeq()
	 * @generated
	 */
  int ALTERNATIVE_VIDEO_SEQ = 5;

  /**
	 * The feature id for the '<em><b>Videoid</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ALTERNATIVE_VIDEO_SEQ__VIDEOID = VIDEO_SEQ_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Videodescs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ALTERNATIVE_VIDEO_SEQ__VIDEODESCS = VIDEO_SEQ_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Alternative Video Seq</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ALTERNATIVE_VIDEO_SEQ_FEATURE_COUNT = VIDEO_SEQ_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl <em>Video Description</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl
	 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoDescription()
	 * @generated
	 */
  int VIDEO_DESCRIPTION = 6;

  /**
	 * The feature id for the '<em><b>Videoid</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_DESCRIPTION__VIDEOID = 0;

  /**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_DESCRIPTION__LOCATION = 1;

  /**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_DESCRIPTION__DURATION = 2;

  /**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_DESCRIPTION__PROBABILITY = 3;

  /**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_DESCRIPTION__SIZE = 4;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_DESCRIPTION__DESCRIPTION = 5;

  /**
<<<<<<< HEAD
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_DESCRIPTION__TEXT = 6;

		/**
	 * The number of structural features of the '<em>Video Description</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIDEO_DESCRIPTION_FEATURE_COUNT = 7;
=======
   * The feature id for the '<em><b>Subtitle</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIDEO_DESCRIPTION__SUBTITLE = 6;

  /**
   * The number of structural features of the '<em>Video Description</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIDEO_DESCRIPTION_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.videoGen.impl.SubtitleImpl <em>Subtitle</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.videoGen.impl.SubtitleImpl
   * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getSubtitle()
   * @generated
   */
  int SUBTITLE = 7;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTITLE__TEXT = 0;

  /**
   * The feature id for the '<em><b>Colorfont</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTITLE__COLORFONT = 1;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTITLE__SIZE = 2;

  /**
   * The number of structural features of the '<em>Subtitle</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTITLE_FEATURE_COUNT = 3;
>>>>>>> a150e5426d31f2a499effc322af3d84e64af383f


  /**
	 * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.VideoGeneratorModel <em>Video Generator Model</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Generator Model</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoGeneratorModel
	 * @generated
	 */
  EClass getVideoGeneratorModel();

  /**
	 * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.videoGen.VideoGeneratorModel#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Information</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoGeneratorModel#getInformation()
	 * @see #getVideoGeneratorModel()
	 * @generated
	 */
  EReference getVideoGeneratorModel_Information();

  /**
	 * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.videoGen.VideoGeneratorModel#getVideoseqs <em>Videoseqs</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Videoseqs</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoGeneratorModel#getVideoseqs()
	 * @see #getVideoGeneratorModel()
	 * @generated
	 */
  EReference getVideoGeneratorModel_Videoseqs();

  /**
	 * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.VideoGenInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoGenInformation
	 * @generated
	 */
  EClass getVideoGenInformation();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getAuthorName <em>Author Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author Name</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoGenInformation#getAuthorName()
	 * @see #getVideoGenInformation()
	 * @generated
	 */
  EAttribute getVideoGenInformation_AuthorName();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoGenInformation#getVersion()
	 * @see #getVideoGenInformation()
	 * @generated
	 */
  EAttribute getVideoGenInformation_Version();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoGenInformation#getCreationDate()
	 * @see #getVideoGenInformation()
	 * @generated
	 */
  EAttribute getVideoGenInformation_CreationDate();

  /**
	 * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.VideoSeq <em>Video Seq</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Seq</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoSeq
	 * @generated
	 */
  EClass getVideoSeq();

  /**
	 * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.MandatoryVideoSeq <em>Mandatory Video Seq</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mandatory Video Seq</em>'.
	 * @see org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
	 * @generated
	 */
  EClass getMandatoryVideoSeq();

  /**
	 * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.videoGen.MandatoryVideoSeq#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.xtext.example.mydsl.videoGen.MandatoryVideoSeq#getDescription()
	 * @see #getMandatoryVideoSeq()
	 * @generated
	 */
  EReference getMandatoryVideoSeq_Description();

  /**
	 * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.OptionalVideoSeq <em>Optional Video Seq</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optional Video Seq</em>'.
	 * @see org.xtext.example.mydsl.videoGen.OptionalVideoSeq
	 * @generated
	 */
  EClass getOptionalVideoSeq();

  /**
	 * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.videoGen.OptionalVideoSeq#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.xtext.example.mydsl.videoGen.OptionalVideoSeq#getDescription()
	 * @see #getOptionalVideoSeq()
	 * @generated
	 */
  EReference getOptionalVideoSeq_Description();

  /**
	 * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.AlternativeVideoSeq <em>Alternative Video Seq</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Video Seq</em>'.
	 * @see org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
	 * @generated
	 */
  EClass getAlternativeVideoSeq();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.AlternativeVideoSeq#getVideoid <em>Videoid</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Videoid</em>'.
	 * @see org.xtext.example.mydsl.videoGen.AlternativeVideoSeq#getVideoid()
	 * @see #getAlternativeVideoSeq()
	 * @generated
	 */
  EAttribute getAlternativeVideoSeq_Videoid();

  /**
	 * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.videoGen.AlternativeVideoSeq#getVideodescs <em>Videodescs</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Videodescs</em>'.
	 * @see org.xtext.example.mydsl.videoGen.AlternativeVideoSeq#getVideodescs()
	 * @see #getAlternativeVideoSeq()
	 * @generated
	 */
  EReference getAlternativeVideoSeq_Videodescs();

  /**
	 * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.VideoDescription <em>Video Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Description</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription
	 * @generated
	 */
  EClass getVideoDescription();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getVideoid <em>Videoid</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Videoid</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription#getVideoid()
	 * @see #getVideoDescription()
	 * @generated
	 */
  EAttribute getVideoDescription_Videoid();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription#getLocation()
	 * @see #getVideoDescription()
	 * @generated
	 */
  EAttribute getVideoDescription_Location();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription#getDuration()
	 * @see #getVideoDescription()
	 * @generated
	 */
  EAttribute getVideoDescription_Duration();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription#getProbability()
	 * @see #getVideoDescription()
	 * @generated
	 */
  EAttribute getVideoDescription_Probability();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription#getSize()
	 * @see #getVideoDescription()
	 * @generated
	 */
  EAttribute getVideoDescription_Size();

  /**
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription#getDescription()
	 * @see #getVideoDescription()
	 * @generated
	 */
  EAttribute getVideoDescription_Description();

  /**
<<<<<<< HEAD
	 * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.xtext.example.mydsl.videoGen.VideoDescription#getText()
	 * @see #getVideoDescription()
	 * @generated
	 */
	EAttribute getVideoDescription_Text();

		/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
=======
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.videoGen.VideoDescription#getSubtitle <em>Subtitle</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Subtitle</em>'.
   * @see org.xtext.example.mydsl.videoGen.VideoDescription#getSubtitle()
   * @see #getVideoDescription()
   * @generated
   */
  EReference getVideoDescription_Subtitle();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.videoGen.Subtitle <em>Subtitle</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtitle</em>'.
   * @see org.xtext.example.mydsl.videoGen.Subtitle
   * @generated
   */
  EClass getSubtitle();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.Subtitle#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see org.xtext.example.mydsl.videoGen.Subtitle#getText()
   * @see #getSubtitle()
   * @generated
   */
  EAttribute getSubtitle_Text();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.Subtitle#getColorfont <em>Colorfont</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Colorfont</em>'.
   * @see org.xtext.example.mydsl.videoGen.Subtitle#getColorfont()
   * @see #getSubtitle()
   * @generated
   */
  EAttribute getSubtitle_Colorfont();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.videoGen.Subtitle#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see org.xtext.example.mydsl.videoGen.Subtitle#getSize()
   * @see #getSubtitle()
   * @generated
   */
  EAttribute getSubtitle_Size();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
>>>>>>> a150e5426d31f2a499effc322af3d84e64af383f
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  VideoGenFactory getVideoGenFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoGeneratorModelImpl <em>Video Generator Model</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGeneratorModelImpl
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoGeneratorModel()
		 * @generated
		 */
    EClass VIDEO_GENERATOR_MODEL = eINSTANCE.getVideoGeneratorModel();

    /**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VIDEO_GENERATOR_MODEL__INFORMATION = eINSTANCE.getVideoGeneratorModel_Information();

    /**
		 * The meta object literal for the '<em><b>Videoseqs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VIDEO_GENERATOR_MODEL__VIDEOSEQS = eINSTANCE.getVideoGeneratorModel_Videoseqs();

    /**
		 * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoGenInformationImpl <em>Information</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenInformationImpl
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoGenInformation()
		 * @generated
		 */
    EClass VIDEO_GEN_INFORMATION = eINSTANCE.getVideoGenInformation();

    /**
		 * The meta object literal for the '<em><b>Author Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_GEN_INFORMATION__AUTHOR_NAME = eINSTANCE.getVideoGenInformation_AuthorName();

    /**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_GEN_INFORMATION__VERSION = eINSTANCE.getVideoGenInformation_Version();

    /**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_GEN_INFORMATION__CREATION_DATE = eINSTANCE.getVideoGenInformation_CreationDate();

    /**
		 * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoSeqImpl <em>Video Seq</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoSeqImpl
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoSeq()
		 * @generated
		 */
    EClass VIDEO_SEQ = eINSTANCE.getVideoSeq();

    /**
		 * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.MandatoryVideoSeqImpl <em>Mandatory Video Seq</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.xtext.example.mydsl.videoGen.impl.MandatoryVideoSeqImpl
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getMandatoryVideoSeq()
		 * @generated
		 */
    EClass MANDATORY_VIDEO_SEQ = eINSTANCE.getMandatoryVideoSeq();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MANDATORY_VIDEO_SEQ__DESCRIPTION = eINSTANCE.getMandatoryVideoSeq_Description();

    /**
		 * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.OptionalVideoSeqImpl <em>Optional Video Seq</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.xtext.example.mydsl.videoGen.impl.OptionalVideoSeqImpl
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getOptionalVideoSeq()
		 * @generated
		 */
    EClass OPTIONAL_VIDEO_SEQ = eINSTANCE.getOptionalVideoSeq();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference OPTIONAL_VIDEO_SEQ__DESCRIPTION = eINSTANCE.getOptionalVideoSeq_Description();

    /**
		 * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.AlternativeVideoSeqImpl <em>Alternative Video Seq</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.xtext.example.mydsl.videoGen.impl.AlternativeVideoSeqImpl
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getAlternativeVideoSeq()
		 * @generated
		 */
    EClass ALTERNATIVE_VIDEO_SEQ = eINSTANCE.getAlternativeVideoSeq();

    /**
		 * The meta object literal for the '<em><b>Videoid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ALTERNATIVE_VIDEO_SEQ__VIDEOID = eINSTANCE.getAlternativeVideoSeq_Videoid();

    /**
		 * The meta object literal for the '<em><b>Videodescs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ALTERNATIVE_VIDEO_SEQ__VIDEODESCS = eINSTANCE.getAlternativeVideoSeq_Videodescs();

    /**
		 * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl <em>Video Description</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl
		 * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getVideoDescription()
		 * @generated
		 */
    EClass VIDEO_DESCRIPTION = eINSTANCE.getVideoDescription();

    /**
		 * The meta object literal for the '<em><b>Videoid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_DESCRIPTION__VIDEOID = eINSTANCE.getVideoDescription_Videoid();

    /**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_DESCRIPTION__LOCATION = eINSTANCE.getVideoDescription_Location();

    /**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_DESCRIPTION__DURATION = eINSTANCE.getVideoDescription_Duration();

    /**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_DESCRIPTION__PROBABILITY = eINSTANCE.getVideoDescription_Probability();

    /**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_DESCRIPTION__SIZE = eINSTANCE.getVideoDescription_Size();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIDEO_DESCRIPTION__DESCRIPTION = eINSTANCE.getVideoDescription_Description();

<<<<<<< HEAD
				/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_DESCRIPTION__TEXT = eINSTANCE.getVideoDescription_Text();
=======
    /**
     * The meta object literal for the '<em><b>Subtitle</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIDEO_DESCRIPTION__SUBTITLE = eINSTANCE.getVideoDescription_Subtitle();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.videoGen.impl.SubtitleImpl <em>Subtitle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.videoGen.impl.SubtitleImpl
     * @see org.xtext.example.mydsl.videoGen.impl.VideoGenPackageImpl#getSubtitle()
     * @generated
     */
    EClass SUBTITLE = eINSTANCE.getSubtitle();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBTITLE__TEXT = eINSTANCE.getSubtitle_Text();

    /**
     * The meta object literal for the '<em><b>Colorfont</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBTITLE__COLORFONT = eINSTANCE.getSubtitle_Colorfont();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBTITLE__SIZE = eINSTANCE.getSubtitle_Size();
>>>>>>> a150e5426d31f2a499effc322af3d84e64af383f

  }

} //VideoGenPackage

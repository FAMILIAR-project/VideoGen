/**
 */
package org.xtext.example.mydsl.videoGen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.BlackWhiteFilter;
import org.xtext.example.mydsl.videoGen.Filter;
import org.xtext.example.mydsl.videoGen.FlipFilter;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.NegateFilter;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.Subtitle;
import org.xtext.example.mydsl.videoGen.Text;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGenFactory;
import org.xtext.example.mydsl.videoGen.VideoGenInformation;
import org.xtext.example.mydsl.videoGen.VideoGenPackage;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VideoGenPackageImpl extends EPackageImpl implements VideoGenPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass videoGeneratorModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass videoGenInformationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass videoSeqEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mandatoryVideoSeqEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalVideoSeqEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alternativeVideoSeqEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass videoDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subtitleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass textEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass filterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blackWhiteFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negateFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass flipFilterEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private VideoGenPackageImpl()
  {
    super(eNS_URI, VideoGenFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link VideoGenPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static VideoGenPackage init()
  {
    if (isInited) return (VideoGenPackage)EPackage.Registry.INSTANCE.getEPackage(VideoGenPackage.eNS_URI);

    // Obtain or create and register package
    VideoGenPackageImpl theVideoGenPackage = (VideoGenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VideoGenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VideoGenPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theVideoGenPackage.createPackageContents();

    // Initialize created meta-data
    theVideoGenPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theVideoGenPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(VideoGenPackage.eNS_URI, theVideoGenPackage);
    return theVideoGenPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVideoGeneratorModel()
  {
    return videoGeneratorModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVideoGeneratorModel_Information()
  {
    return (EReference)videoGeneratorModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVideoGeneratorModel_Videoseqs()
  {
    return (EReference)videoGeneratorModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVideoGenInformation()
  {
    return videoGenInformationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoGenInformation_AuthorName()
  {
    return (EAttribute)videoGenInformationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoGenInformation_Version()
  {
    return (EAttribute)videoGenInformationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoGenInformation_CreationDate()
  {
    return (EAttribute)videoGenInformationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVideoSeq()
  {
    return videoSeqEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMandatoryVideoSeq()
  {
    return mandatoryVideoSeqEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMandatoryVideoSeq_Description()
  {
    return (EReference)mandatoryVideoSeqEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalVideoSeq()
  {
    return optionalVideoSeqEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptionalVideoSeq_Description()
  {
    return (EReference)optionalVideoSeqEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlternativeVideoSeq()
  {
    return alternativeVideoSeqEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternativeVideoSeq_Videoid()
  {
    return (EAttribute)alternativeVideoSeqEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlternativeVideoSeq_Videodescs()
  {
    return (EReference)alternativeVideoSeqEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVideoDescription()
  {
    return videoDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoDescription_Videoid()
  {
    return (EAttribute)videoDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoDescription_Location()
  {
    return (EAttribute)videoDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoDescription_Duration()
  {
    return (EAttribute)videoDescriptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoDescription_Probability()
  {
    return (EAttribute)videoDescriptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoDescription_TextIncrust()
  {
    return (EAttribute)videoDescriptionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoDescription_Size()
  {
    return (EAttribute)videoDescriptionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVideoDescription_Description()
  {
    return (EAttribute)videoDescriptionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVideoDescription_Subtitle()
  {
    return (EReference)videoDescriptionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVideoDescription_Text()
  {
    return (EReference)videoDescriptionEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVideoDescription_Filter()
  {
    return (EReference)videoDescriptionEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubtitle()
  {
    return subtitleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubtitle_Text()
  {
    return (EAttribute)subtitleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubtitle_Colorfont()
  {
    return (EAttribute)subtitleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubtitle_Size()
  {
    return (EAttribute)subtitleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getText()
  {
    return textEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getText_Content()
  {
    return (EAttribute)textEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getText_Position()
  {
    return (EAttribute)textEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getText_Color()
  {
    return (EAttribute)textEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getText_Size()
  {
    return (EAttribute)textEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFilter()
  {
    return filterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlackWhiteFilter()
  {
    return blackWhiteFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegateFilter()
  {
    return negateFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFlipFilter()
  {
    return flipFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFlipFilter_Orientation()
  {
    return (EAttribute)flipFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VideoGenFactory getVideoGenFactory()
  {
    return (VideoGenFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    videoGeneratorModelEClass = createEClass(VIDEO_GENERATOR_MODEL);
    createEReference(videoGeneratorModelEClass, VIDEO_GENERATOR_MODEL__INFORMATION);
    createEReference(videoGeneratorModelEClass, VIDEO_GENERATOR_MODEL__VIDEOSEQS);

    videoGenInformationEClass = createEClass(VIDEO_GEN_INFORMATION);
    createEAttribute(videoGenInformationEClass, VIDEO_GEN_INFORMATION__AUTHOR_NAME);
    createEAttribute(videoGenInformationEClass, VIDEO_GEN_INFORMATION__VERSION);
    createEAttribute(videoGenInformationEClass, VIDEO_GEN_INFORMATION__CREATION_DATE);

    videoSeqEClass = createEClass(VIDEO_SEQ);

    mandatoryVideoSeqEClass = createEClass(MANDATORY_VIDEO_SEQ);
    createEReference(mandatoryVideoSeqEClass, MANDATORY_VIDEO_SEQ__DESCRIPTION);

    optionalVideoSeqEClass = createEClass(OPTIONAL_VIDEO_SEQ);
    createEReference(optionalVideoSeqEClass, OPTIONAL_VIDEO_SEQ__DESCRIPTION);

    alternativeVideoSeqEClass = createEClass(ALTERNATIVE_VIDEO_SEQ);
    createEAttribute(alternativeVideoSeqEClass, ALTERNATIVE_VIDEO_SEQ__VIDEOID);
    createEReference(alternativeVideoSeqEClass, ALTERNATIVE_VIDEO_SEQ__VIDEODESCS);

    videoDescriptionEClass = createEClass(VIDEO_DESCRIPTION);
    createEAttribute(videoDescriptionEClass, VIDEO_DESCRIPTION__VIDEOID);
    createEAttribute(videoDescriptionEClass, VIDEO_DESCRIPTION__LOCATION);
    createEAttribute(videoDescriptionEClass, VIDEO_DESCRIPTION__DURATION);
    createEAttribute(videoDescriptionEClass, VIDEO_DESCRIPTION__PROBABILITY);
    createEAttribute(videoDescriptionEClass, VIDEO_DESCRIPTION__TEXT_INCRUST);
    createEAttribute(videoDescriptionEClass, VIDEO_DESCRIPTION__SIZE);
    createEAttribute(videoDescriptionEClass, VIDEO_DESCRIPTION__DESCRIPTION);
    createEReference(videoDescriptionEClass, VIDEO_DESCRIPTION__SUBTITLE);
    createEReference(videoDescriptionEClass, VIDEO_DESCRIPTION__TEXT);
    createEReference(videoDescriptionEClass, VIDEO_DESCRIPTION__FILTER);

    subtitleEClass = createEClass(SUBTITLE);
    createEAttribute(subtitleEClass, SUBTITLE__TEXT);
    createEAttribute(subtitleEClass, SUBTITLE__COLORFONT);
    createEAttribute(subtitleEClass, SUBTITLE__SIZE);

    textEClass = createEClass(TEXT);
    createEAttribute(textEClass, TEXT__CONTENT);
    createEAttribute(textEClass, TEXT__POSITION);
    createEAttribute(textEClass, TEXT__COLOR);
    createEAttribute(textEClass, TEXT__SIZE);

    filterEClass = createEClass(FILTER);

    blackWhiteFilterEClass = createEClass(BLACK_WHITE_FILTER);

    negateFilterEClass = createEClass(NEGATE_FILTER);

    flipFilterEClass = createEClass(FLIP_FILTER);
    createEAttribute(flipFilterEClass, FLIP_FILTER__ORIENTATION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    mandatoryVideoSeqEClass.getESuperTypes().add(this.getVideoSeq());
    optionalVideoSeqEClass.getESuperTypes().add(this.getVideoSeq());
    alternativeVideoSeqEClass.getESuperTypes().add(this.getVideoSeq());
    blackWhiteFilterEClass.getESuperTypes().add(this.getFilter());
    negateFilterEClass.getESuperTypes().add(this.getFilter());
    flipFilterEClass.getESuperTypes().add(this.getFilter());

    // Initialize classes and features; add operations and parameters
    initEClass(videoGeneratorModelEClass, VideoGeneratorModel.class, "VideoGeneratorModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVideoGeneratorModel_Information(), this.getVideoGenInformation(), null, "information", null, 0, 1, VideoGeneratorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVideoGeneratorModel_Videoseqs(), this.getVideoSeq(), null, "videoseqs", null, 0, -1, VideoGeneratorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(videoGenInformationEClass, VideoGenInformation.class, "VideoGenInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVideoGenInformation_AuthorName(), ecorePackage.getEString(), "authorName", null, 0, 1, VideoGenInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoGenInformation_Version(), ecorePackage.getEString(), "version", null, 0, 1, VideoGenInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoGenInformation_CreationDate(), ecorePackage.getEString(), "creationDate", null, 0, 1, VideoGenInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(videoSeqEClass, VideoSeq.class, "VideoSeq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mandatoryVideoSeqEClass, MandatoryVideoSeq.class, "MandatoryVideoSeq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMandatoryVideoSeq_Description(), this.getVideoDescription(), null, "description", null, 0, 1, MandatoryVideoSeq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalVideoSeqEClass, OptionalVideoSeq.class, "OptionalVideoSeq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionalVideoSeq_Description(), this.getVideoDescription(), null, "description", null, 0, 1, OptionalVideoSeq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alternativeVideoSeqEClass, AlternativeVideoSeq.class, "AlternativeVideoSeq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlternativeVideoSeq_Videoid(), ecorePackage.getEString(), "videoid", null, 0, 1, AlternativeVideoSeq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAlternativeVideoSeq_Videodescs(), this.getVideoDescription(), null, "videodescs", null, 0, -1, AlternativeVideoSeq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(videoDescriptionEClass, VideoDescription.class, "VideoDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVideoDescription_Videoid(), ecorePackage.getEString(), "videoid", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoDescription_Location(), ecorePackage.getEString(), "location", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoDescription_Duration(), ecorePackage.getEFloat(), "duration", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoDescription_Probability(), ecorePackage.getEInt(), "probability", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoDescription_TextIncrust(), ecorePackage.getEString(), "textIncrust", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoDescription_Size(), ecorePackage.getEInt(), "size", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVideoDescription_Description(), ecorePackage.getEString(), "description", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVideoDescription_Subtitle(), this.getSubtitle(), null, "subtitle", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVideoDescription_Text(), this.getText(), null, "text", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVideoDescription_Filter(), this.getFilter(), null, "filter", null, 0, 1, VideoDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subtitleEClass, Subtitle.class, "Subtitle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubtitle_Text(), ecorePackage.getEString(), "text", null, 0, 1, Subtitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSubtitle_Colorfont(), ecorePackage.getEString(), "colorfont", null, 0, 1, Subtitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSubtitle_Size(), ecorePackage.getEInt(), "size", null, 0, 1, Subtitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getText_Content(), ecorePackage.getEString(), "content", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getText_Position(), ecorePackage.getEString(), "position", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getText_Color(), ecorePackage.getEString(), "color", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getText_Size(), ecorePackage.getEInt(), "size", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(filterEClass, Filter.class, "Filter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(blackWhiteFilterEClass, BlackWhiteFilter.class, "BlackWhiteFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(negateFilterEClass, NegateFilter.class, "NegateFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(flipFilterEClass, FlipFilter.class, "FlipFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFlipFilter_Orientation(), ecorePackage.getEString(), "orientation", null, 0, 1, FlipFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //VideoGenPackageImpl

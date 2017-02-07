/**
 */
package org.xtext.example.mydsl.videoGen.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xtext.example.mydsl.videoGen.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage
 * @generated
 */
public class VideoGenSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VideoGenPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VideoGenSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = VideoGenPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case VideoGenPackage.VIDEO_GENERATOR_MODEL:
      {
        VideoGeneratorModel videoGeneratorModel = (VideoGeneratorModel)theEObject;
        T result = caseVideoGeneratorModel(videoGeneratorModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.VIDEO_GEN_INFORMATION:
      {
        VideoGenInformation videoGenInformation = (VideoGenInformation)theEObject;
        T result = caseVideoGenInformation(videoGenInformation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.VIDEO_SEQ:
      {
        VideoSeq videoSeq = (VideoSeq)theEObject;
        T result = caseVideoSeq(videoSeq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.MANDATORY_VIDEO_SEQ:
      {
        MandatoryVideoSeq mandatoryVideoSeq = (MandatoryVideoSeq)theEObject;
        T result = caseMandatoryVideoSeq(mandatoryVideoSeq);
        if (result == null) result = caseVideoSeq(mandatoryVideoSeq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.OPTIONAL_VIDEO_SEQ:
      {
        OptionalVideoSeq optionalVideoSeq = (OptionalVideoSeq)theEObject;
        T result = caseOptionalVideoSeq(optionalVideoSeq);
        if (result == null) result = caseVideoSeq(optionalVideoSeq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ:
      {
        AlternativeVideoSeq alternativeVideoSeq = (AlternativeVideoSeq)theEObject;
        T result = caseAlternativeVideoSeq(alternativeVideoSeq);
        if (result == null) result = caseVideoSeq(alternativeVideoSeq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.VIDEO_DESCRIPTION:
      {
        VideoDescription videoDescription = (VideoDescription)theEObject;
        T result = caseVideoDescription(videoDescription);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.SUBTITLE:
      {
        Subtitle subtitle = (Subtitle)theEObject;
        T result = caseSubtitle(subtitle);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.TEXT:
      {
        Text text = (Text)theEObject;
        T result = caseText(text);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.FILTER:
      {
        Filter filter = (Filter)theEObject;
        T result = caseFilter(filter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.BLACK_WHITE_FILTER:
      {
        BlackWhiteFilter blackWhiteFilter = (BlackWhiteFilter)theEObject;
        T result = caseBlackWhiteFilter(blackWhiteFilter);
        if (result == null) result = caseFilter(blackWhiteFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.NEGATE_FILTER:
      {
        NegateFilter negateFilter = (NegateFilter)theEObject;
        T result = caseNegateFilter(negateFilter);
        if (result == null) result = caseFilter(negateFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VideoGenPackage.FLIP_FILTER:
      {
        FlipFilter flipFilter = (FlipFilter)theEObject;
        T result = caseFlipFilter(flipFilter);
        if (result == null) result = caseFilter(flipFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Video Generator Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Video Generator Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVideoGeneratorModel(VideoGeneratorModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Information</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Information</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVideoGenInformation(VideoGenInformation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Video Seq</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Video Seq</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVideoSeq(VideoSeq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mandatory Video Seq</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mandatory Video Seq</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMandatoryVideoSeq(MandatoryVideoSeq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Video Seq</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Video Seq</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalVideoSeq(OptionalVideoSeq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alternative Video Seq</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alternative Video Seq</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlternativeVideoSeq(AlternativeVideoSeq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Video Description</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Video Description</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVideoDescription(VideoDescription object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subtitle</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subtitle</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubtitle(Subtitle object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Text</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Text</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseText(Text object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFilter(Filter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Black White Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Black White Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlackWhiteFilter(BlackWhiteFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negate Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negate Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegateFilter(NegateFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Flip Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Flip Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFlipFilter(FlipFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //VideoGenSwitch
